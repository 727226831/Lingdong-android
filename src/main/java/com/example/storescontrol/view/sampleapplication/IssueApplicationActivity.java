package com.example.storescontrol.view.sampleapplication;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
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
import com.example.storescontrol.url.FileUtil;
import com.example.storescontrol.url.Request;
import com.example.storescontrol.url.Untils;
import com.example.storescontrol.bean.AgmentBean;
import com.example.storescontrol.bean.SampleApplicationBean;
import com.example.storescontrol.bean.UplodaBean;
import com.example.storescontrol.databinding.ActivityIssueApplicationBinding;
import com.example.storescontrol.view.BaseActivity;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IssueApplicationActivity extends BaseActivity {
    ActivityIssueApplicationBinding binding;
    SampleApplicationBean bean;

    List<String> stringList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(IssueApplicationActivity.this,R.layout.activity_issue_application);

        if(getIntent().getStringExtra("userType").equals("YP")){
            Untils.initTitle("样片&评估板&管芯",this);
        }else   if(getIntent().getStringExtra("userType").equals("GC")){
            Untils.initTitle("MCU工程品发放申请",this);
        }else {
            Untils.initTitle("MM32-Motor-DK申请",this);
        }
        binding.bApplicationdetails.setOnClickListener(onClickListener);
        binding.tvPersonnel.setOnClickListener(onClickListener);
        binding.tvRecordcompany.setOnClickListener(onClickListener);
        binding.tvAgent.setOnClickListener(onClickListener);
        binding.bSubmit.setOnClickListener(onClickListener);
        binding.bAdd.setOnClickListener(onClickListener);
        binding.bAgree.setOnClickListener(onClickListener);
        binding.bUnagree.setOnClickListener(onClickListener);
        binding.bExit.setOnClickListener(onClickListener);

        binding.bUploadFile.setOnClickListener(onClickListener);
        if(getIntent().getParcelableExtra("SampleApplicationBean")==null){
            //新增
            bean=new SampleApplicationBean();
            if(getIntent().getStringExtra("userType").equals("YP")){
                bean.setS_AppType("样片&评估板");
            }else   if(getIntent().getStringExtra("userType").equals("GC")){
                bean.setS_AppType("工程品");
            }else {
                bean.setS_AppType("Motor DK");
            }
            bean.setS_Maker_Id(acccode);
            binding.bSubmit.setVisibility(View.VISIBLE);

        }else {
            bean=getIntent().getParcelableExtra("SampleApplicationBean");
            binding.lApproval.setVisibility(View.VISIBLE);
            binding.bApplicationdetails.setVisibility(View.GONE);
            binding.bUploadFile.setVisibility(View.GONE);
            binding.lFeedback.setVisibility(View.GONE);
            Log.i("bean-->",new Gson().toJson(bean));
            if(getIntent().getBooleanExtra("isApproved",false)){
                binding.bExit.setVisibility(View.VISIBLE);
            }else {
                if(bean.getS_State().equals("")||bean.getS_State().equals("未提交")){
                    binding.bAdd.setVisibility(View.VISIBLE);
                }else  if(bean.getS_State().equals("已提交")||bean.getS_State().equals("审核中")){
                    binding.bAgree.setVisibility(View.VISIBLE);
                    binding.bUnagree.setVisibility(View.VISIBLE);
                }
            }

        }




        addTextWatcher();
        Untils.setSampleApplicationBean(IssueApplicationActivity.this,bean);
    }



    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent  intent=null;
              switch (view.getId()){
                  case R.id.b_applicationdetails:
                      if(getIntent().getStringExtra("userType").equals("YP")){
                          intent=new Intent(IssueApplicationActivity.this,OrderDetailActivity.class);

                      }else   if(getIntent().getStringExtra("userType").equals("GC")){
                          intent=new Intent(IssueApplicationActivity.this,OrderDetailActivity.class);
                      }else {
                          intent=new Intent(IssueApplicationActivity.this,DkDetailsActivity.class);
                      }
                      intent.putExtra("form",1);
                      intent.putExtra("userType",getIntent().getStringExtra("userType"));
                      intent.putExtra("menuname",getIntent().getStringExtra("menuname"));
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
                      if(binding.tvPersonnel.getText().toString().isEmpty()){
                          Toast.makeText(IssueApplicationActivity.this,"销售人员不能为空！",Toast.LENGTH_SHORT).show();
                          return;
                      }
                      if(binding.tvRecordcompany.getText().toString().isEmpty()){
                          Toast.makeText(IssueApplicationActivity.this,"客户名称不能为空！",Toast.LENGTH_SHORT).show();
                          return;
                      }
                      if(binding.etSPerson.getText().toString().isEmpty()){
                          Toast.makeText(IssueApplicationActivity.this,"收货联系人不能为空！",Toast.LENGTH_SHORT).show();
                          return;
                      }
                      if(binding.etSPhone.getText().toString().isEmpty()){
                          Toast.makeText(IssueApplicationActivity.this,"收货人联系电话不能为空！",Toast.LENGTH_SHORT).show();
                          return;
                      }
                      if(binding.etSAddress.getText().toString().isEmpty()){
                          Toast.makeText(IssueApplicationActivity.this,"收货人联系地址不能为空！",Toast.LENGTH_SHORT).show();
                          return;
                      }

                      SampleApplicationBean bean=Untils.getSampleApplicationBean(IssueApplicationActivity.this);
                      putData(bean);

                      break;

                  case R.id.b_uploadFile:

                    checkPermissionREAD_EXTERNAL_STORAGE(IssueApplicationActivity.this);

                      break;
                  case R.id.b_add:
                      tagApproroval=0;
                      Approroval();
                      break;
                  case R.id.b_agree:
                      tagApproroval=1;
                      Approroval();
                      break;
                  case R.id.b_unagree:
                      tagApproroval=2;
                      Approroval();
                      break;
                  case R.id.b_exit:
                      tagApproroval=3;
                      Approroval();
                      break;

              }

        }
    };
    int tagApproroval=-1;
    int tag=-1;

    private void Approroval() {
        dialog.show();
        JSONObject jsonObject=new JSONObject();
        try {
          switch (tagApproroval){
              case 0:
                  jsonObject.put("methodname","SubmitSample");

                  break;
              case 1:
                  jsonObject.put("methodname","AgreeSample");
                  jsonObject.put("P_AuditMemo",binding.etMemo.getText().toString());
                  jsonObject.put("P_Id",bean.getP_Id());
                  break;
              case 2:
                  jsonObject.put("methodname","UnAgreeSample");
                  jsonObject.put("P_AuditMemo",binding.etMemo.getText().toString());
                  jsonObject.put("P_Id",bean.getP_Id());
                  break;
              case 3:
                  jsonObject.put("methodname","RollBackSample");
                  jsonObject.put("P_AuditMemo",binding.etMemo.getText().toString());
                  jsonObject.put("P_Id",bean.getP_Id());
                  break;
          }

            jsonObject.put("usercode",acccode);
            jsonObject.put("S_Id",bean.getS_Id());




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

    public static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 123;
    public boolean checkPermissionREAD_EXTERNAL_STORAGE(
            final Context context) {
        int currentAPIVersion = Build.VERSION.SDK_INT;
        if (currentAPIVersion >= android.os.Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        (Activity) context,
                        Manifest.permission.READ_EXTERNAL_STORAGE)) {


                } else {
                    ActivityCompat
                            .requestPermissions(
                                    (Activity) context,
                                    new String[] { Manifest.permission.READ_EXTERNAL_STORAGE },
                                    MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                }
                return false;
            } else {
                Intent  intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");//设置类型，我这里是任意类型，任意后缀的可以这样写。
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent,1);
                return true;
            }

        } else {
            return true;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // do your stuff
                  Intent  intent = new Intent(Intent.ACTION_GET_CONTENT);
                    intent.setType("*/*");//设置类型，我这里是任意类型，任意后缀的可以这样写。
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                    startActivityForResult(intent,1);
                } else {
                    Toast.makeText(IssueApplicationActivity.this, "GET_ACCOUNTS Denied",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions,
                        grantResults);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case 1:

                    try {
                        Uri selectedImage = data.getData(); //获取系统返回的照片的Uri
                        String path=FileUtil.getPath(IssueApplicationActivity.this,selectedImage);
                         uploadFile(path);
                         stringList.add(path);
                     handler.sendEmptyMessage(0);
                    } catch (Exception e) {
                        // TODO Auto-generatedcatch block
                        e.printStackTrace();
                    }


                break;
        }
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            FileAdapter functionAdapter=new FileAdapter(stringList);
            binding.rvListFile.setLayoutManager(new GridLayoutManager(IssueApplicationActivity.this,1));
            binding.rvListFile.setAdapter(functionAdapter);
            functionAdapter.notifyDataSetChanged();
        }
    };

    private void uploadFile(String  filePath) {
        File file=new File(filePath);
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("picturePath", file.getName(),
                        RequestBody.create(MediaType.parse("multipart/form-data"), file))
                .build();

        okhttp3.Request request = new okhttp3.Request.Builder()
                .header("Content-Type", "application/x-www-form-urlencoded ")
                .url(" http://47.103.60.28:8090/Handler.ashx")
                .post(requestBody)
                .build();
        Log.i("url",request.url().toString());
        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                Log.i("onFailure",e.toString());
            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {

             UplodaBean uplodaBean =new Gson().fromJson(response.body().string(), UplodaBean.class);
             if(uplodaBean.getResultcode().equals("200")){
                 SampleApplicationBean bean=Untils.getSampleApplicationBean(IssueApplicationActivity.this);

                     switch (tag){
                         case 0:
                             bean.setS_Attachment01(uplodaBean.getData());
                             break;
                         case 1:
                             bean.setS_Attachment02(uplodaBean.getData());
                             break;
                         case 2:
                             bean.setS_Attachment03(uplodaBean.getData());
                             break;
                         case 3:
                             bean.setS_Attachment04(uplodaBean.getData());
                             break;
                         case 4:
                             bean.setS_Attachment05(uplodaBean.getData());
                             break;

                     }
                 tag++;
                 Untils.setSampleApplicationBean(IssueApplicationActivity.this,bean);

             }

            }
        });
    }


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
       FunctionAdapter functionAdapter=new  FunctionAdapter(sampleApplicationBean.getJ_SampleDetails());
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
                     if(getIntent().getStringExtra("userType").equals("YP")){
                         intent=new Intent(IssueApplicationActivity.this,OrderDetailActivity.class);

                     }else   if(getIntent().getStringExtra("userType").equals("GC")){
                         intent=new Intent(IssueApplicationActivity.this,OrderDetailActivity.class);
                     }else {
                         intent=new Intent(IssueApplicationActivity.this,DkDetailsActivity.class);
                     }
                     intent.putExtra("menuname","明细"+(i+1));
                     intent.putExtra("position",i);
                     intent.putExtra("form",getIntent().getIntExtra("form",2));
                     intent.putExtra("Product",mDatas.get(i));
                     intent.putExtra("userType",getIntent().getStringExtra("userType"));
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

    class FileAdapter extends RecyclerView.Adapter<FileAdapter.VH>{

        @NonNull
        @Override
        public FileAdapter.VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v=getLayoutInflater().inflate(R.layout.item_details,viewGroup,false);
            return new FileAdapter.VH(v);
        }

        private List<String> mDatas;
        public FileAdapter(List<String> data) {
            this.mDatas = data;
        }

        @Override
        public void onBindViewHolder(@NonNull FileAdapter.VH vh, final int i) {
            vh.textViewDetails.setText("附件："+(i+1));

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
