package com.example.storescontrol.view.sampleapplication;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.storescontrol.R;
import com.example.storescontrol.Url.Request;
import com.example.storescontrol.Url.Untils;
import com.example.storescontrol.bean.ClientBean;
import com.example.storescontrol.bean.ModelBean;
import com.example.storescontrol.bean.SampleApplicationBean;
import com.example.storescontrol.databinding.ItemModelBinding;
import com.example.storescontrol.view.BaseActivity;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelListActivity extends BaseActivity {
    ModelBean modelBean;
    FunctionAdapter functionAdapter;
    RecyclerView recyclerView;
    SampleApplicationBean.Product bean;
    private EditText editTextSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_list);
        Untils.initTitle("型号列表",this);
        recyclerView=findViewById(R.id.rv_list);
        bean=Untils.getProductBean(ModelListActivity.this);
        editTextSearch=findViewById(R.id.et_search);
        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                getData(editable.toString());
            }
        });
        getData("");
    }
    private void getData(String keyword) {
        dialog.show();
        JSONObject jsonObject=new JSONObject();
        try {
            if(getIntent().getStringExtra("type").equals("GC")){
                jsonObject.put("methodname","Inv");
            }else {
                jsonObject.put("methodname","InvST");
            }

            jsonObject.put("type",getIntent().getStringExtra("type"));
            jsonObject.put("invdefine1",bean.getS_InvDefine1());
            jsonObject.put("keyword",keyword);


        } catch (JSONException e) {
            e.printStackTrace();
        }
        String obj=jsonObject.toString();
        Log.i("json object",obj);

        Call<ResponseBody> data = Request.requestbody(obj);
        data.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, Response<ResponseBody> response) {
                dialog.dismiss();
                try {
                    if(response.code()==200) {
                        String result=response.body().string();
                        modelBean =new Gson().fromJson(result, ModelBean.class);
                        if(modelBean.getResultcode().equals("200")) {
                            functionAdapter = new FunctionAdapter(modelBean.getData());

                        }else {
                            List<ModelBean.Data> data=new ArrayList<>();
                            functionAdapter = new FunctionAdapter(data);
                            Toast.makeText(ModelListActivity.this, modelBean.getResultMessage(), Toast.LENGTH_LONG).show();
                        }
                        recyclerView.setLayoutManager(new LinearLayoutManager(ModelListActivity.this));
                        recyclerView.addItemDecoration(new DividerItemDecoration(ModelListActivity.this, DividerItemDecoration.VERTICAL));
                        recyclerView.setAdapter(functionAdapter);


                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
                dialog.dismiss();
            } });
    }
    class FunctionAdapter extends RecyclerView.Adapter<FunctionAdapter.VH>{
        ItemModelBinding binding;
        @NonNull
        @Override
        public FunctionAdapter.VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            binding= DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_model,viewGroup,false);
            return new FunctionAdapter.VH(binding.getRoot());
        }

        private List<ModelBean.Data> mDatas;
        public FunctionAdapter(List<ModelBean.Data> data) {
            this.mDatas = data;
        }

        @Override
        public void onBindViewHolder(@NonNull FunctionAdapter.VH vh, final int i) {

            binding=DataBindingUtil.getBinding(vh.itemView);
            binding.setBean(mDatas.get(i));
            binding.executePendingBindings();

            vh.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(getIntent().getStringExtra("type").equals("GC")){
                        bean.setS_InvName_AC(mDatas.get(i).getCInvName());
                        bean.setS_InvVersion_AC(mDatas.get(i).getCInvAddCode());

                    }else {
                        bean.setS_InvName(mDatas.get(i).getCInvName());
                        bean.setS_InvVersion(mDatas.get(i).getCInvAddCode());
                        bean.setS_Batch(mDatas.get(i).getCBatch());
                        bean.setS_WhCode(mDatas.get(i).getCWhCode());
                    }

                    Untils.setProductBean(ModelListActivity.this,bean);
                    finish();
                }
            });

        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }
        class  VH extends RecyclerView.ViewHolder{
            LinearLayout linearLayout;
            TextView textViewRecordcompany,textViewType;
            public VH(@NonNull View itemView) {
                super(itemView);
                linearLayout=itemView.findViewById(R.id.l_layout);
                textViewRecordcompany=itemView.findViewById(R.id.tv_recordcompanyvalue);
                textViewType=itemView.findViewById(R.id.tv_typevalue);
            }
        }
    }
}
