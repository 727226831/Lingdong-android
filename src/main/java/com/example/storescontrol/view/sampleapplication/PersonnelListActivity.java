package com.example.storescontrol.view.sampleapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.storescontrol.R;
import com.example.storescontrol.Url.Request;
import com.example.storescontrol.Url.Untils;
import com.example.storescontrol.bean.DetailsBean;
import com.example.storescontrol.bean.PersonnelBean;
import com.example.storescontrol.bean.SampleApplicationBean;
import com.example.storescontrol.bean.TROutBywhcodeBean;
import com.example.storescontrol.view.BaseActivity;
import com.example.storescontrol.view.DetailListActivity;
import com.example.storescontrol.view.ProductionListActivity;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonnelListActivity extends BaseActivity {
    PersonnelBean personnelBean;
    FunctionAdapter functionAdapter;
    RecyclerView recyclerView;

    private EditText editTextSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personnel_list);
        Untils.initTitle("销售人员",this);
        recyclerView=findViewById(R.id.rv_list);
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
    private void getData(String keyword ) {

        JSONObject jsonObject=new JSONObject();
        try {

            jsonObject.put("methodname","SaleMan");
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

                try {
                    if(response.code()==200) {
                        String result=response.body().string();

                        personnelBean=new Gson().fromJson(result, PersonnelBean.class);
                        if(personnelBean.getResultcode().equals("200")){
                            functionAdapter=new FunctionAdapter(personnelBean.getData());
                        }else {
                            List<PersonnelBean.Data> data=new ArrayList<>();
                            functionAdapter=new FunctionAdapter(data);
                            Toast.makeText(PersonnelListActivity.this, personnelBean.getResultMessage(), Toast.LENGTH_LONG).show();
                        }

                        recyclerView.setLayoutManager(new LinearLayoutManager(PersonnelListActivity.this));
                        recyclerView.addItemDecoration(new DividerItemDecoration(PersonnelListActivity.this,DividerItemDecoration.VERTICAL));
                        recyclerView.setAdapter(functionAdapter);



                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {

            } });
    }
    class FunctionAdapter extends RecyclerView.Adapter<FunctionAdapter.VH>{

        @NonNull
        @Override
        public FunctionAdapter.VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v=getLayoutInflater().inflate(R.layout.item_personnel,viewGroup,false);
            return new FunctionAdapter.VH(v);
        }

        private List<PersonnelBean.Data> mDatas;
        public FunctionAdapter(List<PersonnelBean.Data> data) {
            this.mDatas = data;
        }

        @Override
        public void onBindViewHolder(@NonNull FunctionAdapter.VH vh, final int i) {
           vh.textViewDepartment.setText(mDatas.get(i).getA_Department());
           vh.textViewname.setText(mDatas.get(i).getA_Name());
           vh.linearLayout.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   SampleApplicationBean bean=Untils.getSampleApplicationBean(PersonnelListActivity.this);
                   bean.setS_SaleMan(mDatas.get(i).getA_Name());
                   bean.setS_DepName(mDatas.get(i).getA_Department());
                   bean.setS_SaleMan_Id(mDatas.get(i).getA_Id());
                   Untils.setSampleApplicationBean(PersonnelListActivity.this,bean);
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
            TextView textViewname,textViewDepartment;
            public VH(@NonNull View itemView) {
                super(itemView);
                linearLayout=itemView.findViewById(R.id.l_layout);
                textViewname=itemView.findViewById(R.id.tv_namevalue);
                textViewDepartment=itemView.findViewById(R.id.tv_departmentvalue);
            }
        }
    }
}
