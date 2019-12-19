package com.example.storescontrol.view.task;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.storescontrol.R;
import com.example.storescontrol.Url.Request;
import com.example.storescontrol.Url.Untils;
import com.example.storescontrol.Url.iUrl;
import com.example.storescontrol.bean.TaskBean;
import com.example.storescontrol.view.BaseActivity;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TaskListActivity extends BaseActivity {
    RecyclerView recyclerView;
    private FunctionAdapter functionAdapter;
    private EditText editTextSearch;
    private String menuname;
    SharedPreferences sharedPreferences;
    TabLayout tabLayout;
    int listType=0;
    TaskBean taskBean= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v=getLayoutInflater().inflate(R.layout.activity_production_list,null,false);
        setContentView(v);

        tabLayout=findViewById(R.id.tl_title);
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
                getData(listType,editable.toString());

            }
        });


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                getData(tab.getPosition(),"");

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        menuname=getIntent().getStringExtra("menuname");
        Untils.initTitle(menuname,this);

        recyclerView=findViewById(R.id.rv_list);


        sharedPreferences=getSharedPreferences(acccode+"",0);


    }

    @Override
    protected void onStart() {
        super.onStart();
       getData(listType,"");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void getData(final int type,String keyword) {
         listType=type;

        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("usercode",acccode);

            jsonObject.put("methodname","PriceAuditList");
            switch (type){
                case 0:
                    jsonObject.put("auditstatus","待审批");
                    break;
                case 1:
                    jsonObject.put("auditstatus","已审批");
                    break;
            }
            jsonObject.put("keyword",keyword);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        String obj=jsonObject.toString();
        Log.i("json object",obj);

        OkHttpClient client = new OkHttpClient.Builder().
                connectTimeout(10, TimeUnit.SECONDS).
                readTimeout(10, TimeUnit.SECONDS).
                writeTimeout(10, TimeUnit.SECONDS).build();

        Retrofit retrofit=new Retrofit.Builder().client(client).baseUrl(Request.URL_LD8090).build();
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),obj);
        iUrl login = retrofit.create(iUrl.class);
        Call<ResponseBody> call = login.getMessage(body);
        Log.i("ResponseBody",call.request().url().toString());
        dialog.show();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, Response<ResponseBody> response) {
                     dialog.dismiss();

                    if(response.code()==200) {

                        try {
                            taskBean = new Gson().fromJson(response.body().string(), TaskBean.class);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        if(taskBean.getResultcode().equals("200")){
                            if(type==0){
                                tabLayout.getTabAt(0).setText("待审批("+taskBean.getData().size()+")");
                            }else if(type==1) {
                                tabLayout.getTabAt(1).setText("已审批("+taskBean.getData().size()+")");
                            }

                            initAdapter(taskBean.getData());
                        }else {
                            Toast.makeText(TaskListActivity.this, taskBean.getResultMessage(), Toast.LENGTH_LONG).show();
                            recyclerView.setVisibility(View.GONE);
                        }



                    }else {
                      recyclerView.setVisibility(View.GONE);
                    }


            }
            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
                dialog.dismiss();
                Log.i("onFailure",t.toString());
                recyclerView.setVisibility(View.GONE);
            } });
    }

    private void initAdapter(List<TaskBean.Data> data) {
        recyclerView.setVisibility(View.VISIBLE);
        functionAdapter = new FunctionAdapter(data);
        recyclerView.setLayoutManager(new LinearLayoutManager(TaskListActivity.this));
        recyclerView.addItemDecoration(new DividerItemDecoration(TaskListActivity.this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(functionAdapter);
        functionAdapter.notifyDataSetChanged();
    }

    class FunctionAdapter extends RecyclerView.Adapter<FunctionAdapter.VH>{

        @NonNull
        @Override
        public FunctionAdapter.VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v=getLayoutInflater().inflate(R.layout.item_task,viewGroup,false);
            return new FunctionAdapter.VH(v);


        }

        private List<TaskBean.Data> mDatas;
        public FunctionAdapter(List<TaskBean.Data> data) {
            this.mDatas = data;
        }

        @Override
        public void onBindViewHolder(@NonNull final FunctionAdapter.VH vh, final int i) {



            vh.textViewS_QuotationID.setText(mDatas.get(i).getS_QuotationID());
            vh.textViewS_RegisterDate.setText("时间："+mDatas.get(i).getS_RegisterDate());

            vh.textViewS_InvVersion.setText("版本："+mDatas.get(i).getS_InvVersion());
            vh.textViewS_InvName.setText("型号："+mDatas.get(i).getS_InvName());
            vh.textViewR_RecordCompany.setText("客户："+mDatas.get(i).getR_RecordCompany());
            vh.textViewS_Verifyer.setText("销售："+mDatas.get(i).getS_Verifyer());
            vh.textViewM_MSN.setText("代理商："+mDatas.get(i).getM_MSN());


            if(sharedPreferences.getBoolean(mDatas.get(i).getS_QuotationID(),false)){
                vh.imageViewTag.setVisibility(View.GONE);
                vh.textViewtag.setVisibility(View.GONE);
            }else {

                vh.imageViewTag.setVisibility(View.VISIBLE);
            }



            vh.textViewS_State.setText("状态："+mDatas.get(i).getS_State());
            vh.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sharedPreferences.edit().putBoolean(mDatas.get(i).getS_QuotationID(),true).commit();
                    vh.imageViewTag.setVisibility(View.GONE);

                    if(type==1) {
                        Intent intent = new Intent(TaskListActivity.this, TaskActivity.class);
                        intent.putExtra("taskBean", mDatas.get(i));
                        if(acccode.equals("15")){
                            intent.putExtra("type",-1);
                        }else {
                            intent.putExtra("type",listType);
                        }

                        startActivity(intent);
                    }


                }
            });



        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }
        class  VH extends RecyclerView.ViewHolder{
            TextView textViewtag,textViewS_QuotationID,textViewR_RecordCompany, textViewS_InvName,
                    textViewS_InvVersion,textViewS_Verifyer,textViewS_State,textViewS_RegisterDate,
                    textViewM_MSN;
            LinearLayout linearLayout;
            ImageView imageViewTag;

            public VH(@NonNull View itemView) {
                super(itemView);
                linearLayout=itemView.findViewById(R.id.l_input);
                textViewtag=itemView.findViewById(R.id.tv_tag);
                textViewS_QuotationID=itemView.findViewById(R.id.tv_S_QuotationID);
                textViewR_RecordCompany=itemView.findViewById(R.id.tv_R_RecordCompany);
                textViewS_InvName=itemView.findViewById(R.id.tv_S_InvName);
               textViewS_InvVersion=itemView.findViewById(R.id.tv_S_InvVersion);
               textViewS_Verifyer=itemView.findViewById(R.id.tv_S_Verifyer);
               textViewS_State=itemView.findViewById(R.id.tv_S_State);
               textViewS_RegisterDate=itemView.findViewById(R.id.tv_S_RegisterDate);
               imageViewTag=itemView.findViewById(R.id.iv_tag);
               textViewM_MSN=itemView.findViewById(R.id.tv_M_MSN);





            }
        }
    }
}
