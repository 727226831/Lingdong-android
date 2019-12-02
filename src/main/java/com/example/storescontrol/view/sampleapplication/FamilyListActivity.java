package com.example.storescontrol.view.sampleapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.storescontrol.R;
import com.example.storescontrol.Url.Request;
import com.example.storescontrol.Url.Untils;
import com.example.storescontrol.bean.AgmentBean;
import com.example.storescontrol.bean.SampleApplicationBean;
import com.example.storescontrol.view.BaseActivity;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FamilyListActivity extends BaseActivity {
    AgmentBean agmentBean;
    FunctionAdapter functionAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_list);
        Untils.initTitle("产品系列列表",this);
        recyclerView=findViewById(R.id.rv_list);
        getData();
    }
    private void getData() {
        dialog.show();
        JSONObject jsonObject=new JSONObject();
        try {

            jsonObject.put("methodname","InvDefine1");
            jsonObject.put("type",getIntent().getStringExtra("type"));


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
                        agmentBean =new Gson().fromJson(result, AgmentBean.class);
                        functionAdapter=new FunctionAdapter(agmentBean.getData());
                        recyclerView.setLayoutManager(new LinearLayoutManager(FamilyListActivity.this));
                        recyclerView.addItemDecoration(new DividerItemDecoration(FamilyListActivity.this,DividerItemDecoration.VERTICAL));
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

        @NonNull
        @Override
        public FunctionAdapter.VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v=getLayoutInflater().inflate(R.layout.item_agent,viewGroup,false);
            return new FunctionAdapter.VH(v);
        }

        private List<AgmentBean.Data> mDatas;
        public FunctionAdapter(List<AgmentBean.Data> data) {
            this.mDatas = data;
        }

        @Override
        public void onBindViewHolder(@NonNull FunctionAdapter.VH vh, final int i) {

            vh.textViewAgent.setText(mDatas.get(i).getcInvDefine1());
            vh.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SampleApplicationBean.Product bean=Untils.getProductBean(FamilyListActivity.this);
                    bean.setS_InvDefine1(mDatas.get(i).getcInvDefine1());
                    Untils.setProductBean(FamilyListActivity.this,bean);
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
            TextView textViewAgent;
            public VH(@NonNull View itemView) {
                super(itemView);
                linearLayout=itemView.findViewById(R.id.l_layout);
                textViewAgent=itemView.findViewById(R.id.tv_agentvalue);

            }
        }
    }
}
