package com.example.storescontrol.view.sampleapplication;

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
import com.example.storescontrol.url.Request;
import com.example.storescontrol.url.Untils;
import com.example.storescontrol.bean.SampleApplicationBean;
import com.example.storescontrol.bean.SampleListBean;
import com.example.storescontrol.view.BaseActivity;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MySampleActivity extends BaseActivity {
    RecyclerView recyclerView;
    private FunctionAdapter functionAdapter;
    private EditText editTextSearch;
    private String menuname;
    SharedPreferences sharedPreferences;
    TabLayout tabLayout;
    int listType=0;
    SampleListBean taskBean= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v=getLayoutInflater().inflate(R.layout.activity_mytask,null,false);
        setContentView(v);

        tabLayout=findViewById(R.id.tl_title);
        editTextSearch=findViewById(R.id.et_search);
        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                List<SampleApplicationBean> data=new ArrayList<>();

                for (int j = 0; j <taskBean.getData().size() ; j++) {
                    String bean=new Gson().toJson(taskBean.getData().get(j));
                    if(bean.contains(charSequence
                    )){
                        data.add(taskBean.getData().get(j));
                    }
                }
                initAdapter(data);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                getData(tab.getPosition());

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
        getData(listType);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void getData(final int statusType) {
        listType=statusType;

        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("usercode",acccode);
            jsonObject.put("methodname","SampleList");
            jsonObject.put("keyword","");
            switch (statusType){
                case 0:
                    jsonObject.put("status","未提交");
                    break;
                case 1:
                    jsonObject.put("status","审批中");
                    break;
                case 2:
                    jsonObject.put("status","已审核");
                    break;
            }



        } catch (JSONException e) {
            e.printStackTrace();
        }
        String obj=jsonObject.toString();
        Log.i("json object",obj);

        Call<ResponseBody> call = Request.requestbody(obj);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, Response<ResponseBody> response) {


                if(response.code()==200) {

                    try {
                        taskBean = new Gson().fromJson(response.body().string(), SampleListBean.class);
                        if(taskBean.getResultcode().equals("200")){

                            switch (statusType){
                                case 0:
                                    tabLayout.getTabAt(0).setText("未提交("+taskBean.getData().size()+")");
                                    break;
                                case 1:
                                    tabLayout.getTabAt(1).setText("审批中("+taskBean.getData().size()+")");
                                    break;
                                case 2:
                                    tabLayout.getTabAt(2).setText("已审核("+taskBean.getData().size()+")");
                                    break;
                            }
                            initAdapter(taskBean.getData());

                        }else {
                            List<SampleApplicationBean> data=new ArrayList<>();
                            initAdapter(data);

                            switch (statusType){
                                case 0:
                                    tabLayout.getTabAt(0).setText("未提交");

                                    break;
                                case 1:
                                    tabLayout.getTabAt(1).setText("审批中");
                                    break;
                                case 2:
                                    tabLayout.getTabAt(2).setText("已审核");
                                    break;
                            }
                            Toast.makeText(MySampleActivity.this, taskBean.getResultMessage(), Toast.LENGTH_LONG).show();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }



                }


            }
            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
                Log.i("onFailure",t.toString());
            } });
    }

    private void initAdapter(List<SampleApplicationBean> data) {

        functionAdapter = new FunctionAdapter(data);
        recyclerView.setLayoutManager(new LinearLayoutManager(MySampleActivity.this));
        recyclerView.addItemDecoration(new DividerItemDecoration(MySampleActivity.this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(functionAdapter);
        functionAdapter.notifyDataSetChanged();
    }

    class FunctionAdapter extends RecyclerView.Adapter<FunctionAdapter.VH>{

        @NonNull
        @Override
        public FunctionAdapter.VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v=getLayoutInflater().inflate(R.layout.item_sample,viewGroup,false);
            return new FunctionAdapter.VH(v);


        }

        private List<SampleApplicationBean> mDatas;
        public FunctionAdapter(List<SampleApplicationBean> data) {
            this.mDatas = data;
        }

        @Override
        public void onBindViewHolder(@NonNull final FunctionAdapter.VH vh, final int i) {



            vh.textViewS_QuotationID.setText(mDatas.get(i).getS_Code());
              vh.textViewS_RegisterDate.setText("时间："+mDatas.get(i).getS_RegisterDate());

            vh.textViewR_RecordCompany.setText("客户："+mDatas.get(i).getR_RecordCompany());
            vh.textViewS_Verifyer.setText("销售："+mDatas.get(i).getS_SaleMan());
            vh.textViewM_MSN.setText("代理商："+mDatas.get(i).getR_MemberAgents());


            if(sharedPreferences.getBoolean(mDatas.get(i).getS_Code(),false)){
                vh.imageViewTag.setVisibility(View.GONE);
                vh.textViewtag.setVisibility(View.GONE);
            }else {

                vh.imageViewTag.setVisibility(View.VISIBLE);
            }



            vh.textViewS_State.setText("状态："+mDatas.get(i).getS_State());
            vh.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sharedPreferences.edit().putBoolean(mDatas.get(i).getS_Code(),true).commit();
                    vh.imageViewTag.setVisibility(View.GONE);


                        Intent intent = new Intent(MySampleActivity.this, IssueApplicationActivity.class);

                         switch (listType) {
                             case 0:
                                 mDatas.get(i).setS_State("未提交");
                                 intent.putExtra("isApproved", false);
                                 break;
                             case 1:
                                 mDatas.get(i).setS_State("审核中");
                                 intent.putExtra("isApproved", true);
                                 break;
                             case 2:
                                 mDatas.get(i).setS_State("已审核");
                                 intent.putExtra("isApproved", false);
                                 break;
                         }
                        intent.putExtra("SampleApplicationBean", mDatas.get(i));
                        intent.putExtra("form",3);
                        if(mDatas.get(i).getS_AppType().equals("样片&评估板")){
                            intent.putExtra("userType","YP");
                        }else   if(mDatas.get(i).getS_AppType().equals("工程品")){
                            intent.putExtra("userType","GC");
                        }else {
                            intent.putExtra("userType","");
                        }

                        startActivity(intent);
                    }



            });



        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }
        class  VH extends RecyclerView.ViewHolder{
            TextView textViewtag,textViewS_QuotationID,textViewR_RecordCompany, textViewS_Verifyer,textViewS_State,textViewS_RegisterDate,
                    textViewM_MSN;
            LinearLayout linearLayout;
            ImageView imageViewTag;

            public VH(@NonNull View itemView) {
                super(itemView);
                linearLayout=itemView.findViewById(R.id.l_input);
                textViewtag=itemView.findViewById(R.id.tv_tag);
                textViewS_QuotationID=itemView.findViewById(R.id.tv_S_QuotationID);
                textViewR_RecordCompany=itemView.findViewById(R.id.tv_R_RecordCompany);

                textViewS_Verifyer=itemView.findViewById(R.id.tv_S_Verifyer);
                textViewS_State=itemView.findViewById(R.id.tv_S_State);
                textViewS_RegisterDate=itemView.findViewById(R.id.tv_S_RegisterDate);
                imageViewTag=itemView.findViewById(R.id.iv_tag);
                textViewM_MSN=itemView.findViewById(R.id.tv_M_MSN);





            }
        }
    }
}
