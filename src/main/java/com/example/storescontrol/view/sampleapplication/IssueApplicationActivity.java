package com.example.storescontrol.view.sampleapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.storescontrol.R;
import com.example.storescontrol.Url.Request;
import com.example.storescontrol.Url.Untils;
import com.example.storescontrol.bean.AgmentBean;
import com.example.storescontrol.bean.ClientBean;
import com.example.storescontrol.bean.SampleApplicationBean;
import com.example.storescontrol.databinding.ActivityIssueApplicationBinding;
import com.example.storescontrol.view.BaseActivity;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IssueApplicationActivity extends BaseActivity {
    ActivityIssueApplicationBinding binding;
    SampleApplicationBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(IssueApplicationActivity.this,R.layout.activity_issue_application);
        Untils.initTitle(getIntent().getStringExtra("menuname"),this);

        binding.bApplicationdetails.setOnClickListener(onClickListener);
        binding.tvPersonnel.setOnClickListener(onClickListener);
        binding.tvRecordcompany.setOnClickListener(onClickListener);
        binding.tvAgent.setOnClickListener(onClickListener);
        binding.bSubmit.setOnClickListener(onClickListener);

       bean=new SampleApplicationBean();
        if(getIntent().getStringExtra("type").equals("YP")){
           bean.setS_AppType("样片&评估板");
        }else   if(getIntent().getStringExtra("type").equals("GC")){
            bean.setS_AppType("工程品");
        }else {
            bean.setS_AppType("Motor DK");
        }
        bean.setS_Maker_Id(acccode);

        addTextWatcher();
        Untils.setSampleApplicationBean(IssueApplicationActivity.this,bean);
    }



    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent  intent=null;
              switch (view.getId()){
                  case R.id.b_applicationdetails:
                      if(getIntent().getStringExtra("type").equals("YP")){
                          intent=new Intent(IssueApplicationActivity.this,OrderDetailActivity.class);

                      }else   if(getIntent().getStringExtra("type").equals("GC")){
                          intent=new Intent(IssueApplicationActivity.this,ApplicationDetailsActivity.class);
                      }else {
                          intent=new Intent(IssueApplicationActivity.this,DkDetailsActivity.class);
                      }
                      intent.putExtra("type",getIntent().getStringExtra("type"));
                      startActivity(intent);
                      break;
                  case R.id.tv_personnel:
                      intent=new Intent(IssueApplicationActivity.this,PersonnelListActivity.class);
                      startActivity(intent);
                      break;
                  case R.id.tv_recordcompany:
                      intent=new Intent(IssueApplicationActivity.this,ClientListActivity.class);
                      startActivity(intent);

                      break;
                  case R.id.tv_agent:
                      intent=new Intent(IssueApplicationActivity.this,AgentListActivity.class);
                      startActivity(intent);
                      break;
                  case R.id.b_submit:
                      SampleApplicationBean bean=Untils.getSampleApplicationBean(IssueApplicationActivity.this);
                      putData(bean);

                      break;

              }

        }
    };
    private void putData(SampleApplicationBean bean) {
        dialog.show();
        JSONObject jsonObject=new JSONObject();
        try {

            jsonObject.put("methodname","EditSample");
            jsonObject.put("usercode",acccode);

            JSONObject object=new JSONObject(new Gson().toJson(bean));
            jsonObject.put("data",object);


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
                       AgmentBean agmentBean =new Gson().fromJson(result, AgmentBean.class);
                        Toast.makeText(IssueApplicationActivity.this, agmentBean.getResultMessage(), Toast.LENGTH_LONG).show();
                       finish();



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
    @Override
    protected void onStart() {
        super.onStart();
        SampleApplicationBean sampleApplicationBean=Untils.getSampleApplicationBean(IssueApplicationActivity.this);
        Log.i("sampleApplicationBean",new Gson().toJson(sampleApplicationBean));
       FunctionAdapter functionAdapter=new  FunctionAdapter(sampleApplicationBean.getDetails());
        binding.rvList.setLayoutManager(new GridLayoutManager(IssueApplicationActivity.this,6));
        binding.rvList.setAdapter(functionAdapter);
        binding.setBean(sampleApplicationBean);
    }
    class FunctionAdapter extends RecyclerView.Adapter<FunctionAdapter.VH>{

        @NonNull
        @Override
        public FunctionAdapter.VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v=getLayoutInflater().inflate(R.layout.item_details,viewGroup,false);
            return new FunctionAdapter.VH(v);
        }

        private List<SampleApplicationBean.Product> mDatas;
        public FunctionAdapter(List<SampleApplicationBean.Product> data) {
            this.mDatas = data;
        }

        @Override
        public void onBindViewHolder(@NonNull FunctionAdapter.VH vh, final int i) {
             vh.textViewDetails.setText("明细"+(i+1));
             vh.linearLayout.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     Intent intent;
                     if(getIntent().getStringExtra("type").equals("YP")){
                         intent=new Intent(IssueApplicationActivity.this,OrderDetailActivity.class);

                     }else   if(getIntent().getStringExtra("type").equals("GC")){
                         intent=new Intent(IssueApplicationActivity.this,OrderDetailActivity.class);
                     }else {
                         intent=new Intent(IssueApplicationActivity.this,DkDetailsActivity.class);
                     }
                     intent.putExtra("Product",mDatas.get(i));
                     intent.putExtra("type",getIntent().getStringExtra("type"));
                     startActivity(intent);
                 }
             });

        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }
        class  VH extends RecyclerView.ViewHolder{
            LinearLayout linearLayout;
            TextView textViewDetails;
            public VH(@NonNull View itemView) {
                super(itemView);
                linearLayout=itemView.findViewById(R.id.l_layout);
                textViewDetails=itemView.findViewById(R.id.tv_deatils);
            }
        }
    }
    private void addTextWatcher() {
        binding.etFeedback.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                SampleApplicationBean bean=Untils.getSampleApplicationBean(IssueApplicationActivity.this);
                bean.setS_Feedback(editable.toString());
                Untils.setSampleApplicationBean(IssueApplicationActivity.this,bean);
            }
        });
        binding.etSPerson.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                SampleApplicationBean bean=Untils.getSampleApplicationBean(IssueApplicationActivity.this);
                bean.setS_ContactPerson(editable.toString());
                Untils.setSampleApplicationBean(IssueApplicationActivity.this,bean);
            }
        });
        binding.etSPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                SampleApplicationBean bean=Untils.getSampleApplicationBean(IssueApplicationActivity.this);
                bean.setS_ContactPhone(editable.toString());
                Untils.setSampleApplicationBean(IssueApplicationActivity.this,bean);
            }
        });
        binding.etSAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                SampleApplicationBean bean=Untils.getSampleApplicationBean(IssueApplicationActivity.this);
                bean.setS_ContactAddress(editable.toString());
                Untils.setSampleApplicationBean(IssueApplicationActivity.this,bean);
            }
        });
        binding.etMAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                SampleApplicationBean bean=Untils.getSampleApplicationBean(IssueApplicationActivity.this);
                bean.setS_ContactAddress_M(editable.toString());
                Untils.setSampleApplicationBean(IssueApplicationActivity.this,bean);
            }
        });
        binding.etMPerson.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                SampleApplicationBean bean=Untils.getSampleApplicationBean(IssueApplicationActivity.this);
                bean.setS_ContactPerson_M(editable.toString());
                Untils.setSampleApplicationBean(IssueApplicationActivity.this,bean);
            }
        });
        binding.etMPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                SampleApplicationBean bean=Untils.getSampleApplicationBean(IssueApplicationActivity.this);
                bean.setS_ContactPhone_M(editable.toString());
                Untils.setSampleApplicationBean(IssueApplicationActivity.this,bean);
            }
        });
        binding.etMemo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                SampleApplicationBean bean=Untils.getSampleApplicationBean(IssueApplicationActivity.this);
                bean.setS_Memo(editable.toString());
                Untils.setSampleApplicationBean(IssueApplicationActivity.this,bean);
            }
        });
    }
}
