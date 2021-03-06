package com.example.storescontrol.view.sampleapplication;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import com.example.storescontrol.R;

import com.example.storescontrol.url.Untils;
import com.example.storescontrol.bean.SampleApplicationBean;
import com.example.storescontrol.databinding.ActivityDkDetailsBinding;
import com.example.storescontrol.view.BaseActivity;
import com.google.gson.Gson;

public class DkDetailsActivity extends BaseActivity {
    SampleApplicationBean.Product bean;
    String[] stringsField=new String[]{"车用电子","工业及电机","家电及医疗","消费及玩具","手机周边","显示及人机界面","其他"};
    ActivityDkDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(DkDetailsActivity.this,R.layout.activity_dk_details);
        Untils.initTitle("Motor DK",this);


        switch (getIntent().getIntExtra("form",-1)){

            case 1:
                bean=new SampleApplicationBean.Product();
                bean.setS_InvDefine1("");
                break;
            case 2:
                bean=getIntent().getParcelableExtra("Product");
                break;
            case 3:
                bean=getIntent().getParcelableExtra("Product");
                binding.bSubmit.setVisibility(View.GONE);
                break;
        }
        Untils.setProductBean(DkDetailsActivity.this,bean);

        binding.tvModel.setOnClickListener(onClickListener);
        binding.tvField.setOnClickListener(onClickListener);
        binding.tvDescription.setOnClickListener(onClickListener);
        binding.bSubmit.setOnClickListener(onClickListener);
        binding.etQty.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                SampleApplicationBean.Product product=Untils.getProductBean(DkDetailsActivity.this);
                product.setS_Qty(editable.toString());
                Untils.setProductBean(DkDetailsActivity.this,product);
            }
        });
        binding.etMemo1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                SampleApplicationBean.Product product=Untils.getProductBean(DkDetailsActivity.this);
                product.setS_Memo1(editable.toString());
                Untils.setProductBean(DkDetailsActivity.this,product);
            }
        });
        binding.etMemo2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                SampleApplicationBean.Product product=Untils.getProductBean(DkDetailsActivity.this);
                product.setS_Memo2(editable.toString());
                Untils.setProductBean(DkDetailsActivity.this,product);
            }
        });
        binding.etMemo3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                SampleApplicationBean.Product product=Untils.getProductBean(DkDetailsActivity.this);
                product.setS_Memo3(editable.toString());
                Untils.setProductBean(DkDetailsActivity.this,product);
            }
        });

        binding.etFunctionDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                SampleApplicationBean.Product product=Untils.getProductBean(DkDetailsActivity.this);
                product.setS_FunctionDescription(editable.toString());
                Untils.setProductBean(DkDetailsActivity.this,product);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        SampleApplicationBean.Product product=Untils.getProductBean(DkDetailsActivity.this);
        if(product.getS_FunctionDescription()!=null){
            if(product.getS_FunctionDescription().equals("其他")){
                binding.etFunctionDescription.setVisibility(View.VISIBLE);
            }
        }
        binding.setBean(product);

    }
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=null;
            switch (view.getId()){
                case R.id.tv_model:

                    intent=new Intent(DkDetailsActivity.this, ModelListActivity.class);
                    intent.putExtra("userType",getIntent().getStringExtra("userType"));
                    startActivity(intent);
                    break;
                case R.id.tv_field:
                    intent=new Intent(DkDetailsActivity.this, ApplicationFieldActivity.class);
                    intent.putExtra("key","Define29");
                    startActivity(intent);

                    break;
                case R.id.tv_description:
                    if(binding.tvField.getText().equals("")){
                        Toast.makeText(DkDetailsActivity.this, "请先选择应用领域", Toast.LENGTH_LONG).show();
                        return;
                    }
                    intent=new Intent(DkDetailsActivity.this, DescriptionListActivity.class);
                    intent.putExtra("userType",getIntent().getStringExtra("userType"));
                    startActivity(intent);
                    break;
                case R.id.tv_functiondescription:
                    if(binding.tvField.getText().equals("")){
                        Toast.makeText(DkDetailsActivity.this, "请先选择应用领域", Toast.LENGTH_LONG).show();
                        return;
                    }
                    intent=new Intent(DkDetailsActivity.this, ApplicationFieldActivity.class);
                    intent.putExtra("key","Define31");
                    intent.putExtra("applicationarea",binding.tvField.getText().toString());
                    startActivity(intent);
                    break;

                case R.id.b_submit:
                    if(binding.tvModel.getText().toString().isEmpty()){
                        Toast.makeText(DkDetailsActivity.this, "请选择产品型号", Toast.LENGTH_LONG).show();
                        return;
                    }
                    if(binding.etQty.getText().toString().isEmpty()){
                        Toast.makeText(DkDetailsActivity.this, "请填写申请数量", Toast.LENGTH_LONG).show();
                        return;
                    }
                    if(binding.etQty.getText().toString().isEmpty()){
                        Toast.makeText(DkDetailsActivity.this, "请填写申请数量", Toast.LENGTH_LONG).show();
                        return;
                    }
                    if(binding.tvField.getText().toString().isEmpty()){
                        Toast.makeText(DkDetailsActivity.this, "应用领域不能为空", Toast.LENGTH_LONG).show();
                        return;
                    }
                    if(binding.tvDescription.getText().toString().isEmpty()){
                        Toast.makeText(DkDetailsActivity.this, "应用描述不能为空", Toast.LENGTH_LONG).show();
                        return;
                    }
                    SampleApplicationBean sampleApplicationBean=Untils.getSampleApplicationBean(DkDetailsActivity.this);
                    SampleApplicationBean.Product product=Untils.getProductBean(DkDetailsActivity.this);
                    sampleApplicationBean.getJ_SampleDetails().add(product);
                    Log.i("submit",new Gson().toJson(sampleApplicationBean));
                    Untils.setSampleApplicationBean(DkDetailsActivity.this,sampleApplicationBean);
                    finish();
                    break;
            }

        }
    };
}
