package com.example.storescontrol.view.sampleapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.storescontrol.R;
import com.example.storescontrol.Url.Untils;
import com.example.storescontrol.bean.SampleApplicationBean;
import com.example.storescontrol.databinding.ActivityOrderDetailBinding;
import com.example.storescontrol.view.BaseActivity;
import com.google.gson.Gson;

public class OrderDetailActivity extends BaseActivity {
      ActivityOrderDetailBinding binding;
      SampleApplicationBean.Product bean;
      String[] stringsField=new String[]{"车用电子","工业及电机","家电及医疗","消费及玩具","手机周边","显示及人机界面","其他"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        binding= DataBindingUtil.setContentView(OrderDetailActivity.this,R.layout.activity_order_detail);
        Untils.initTitle("样品&评估板&管芯",this);
        binding.tvFamily.setOnClickListener(onClickListener);
        binding.tvModel.setOnClickListener(onClickListener);
        binding.tvField.setOnClickListener(onClickListener);
        binding.tvDescription.setOnClickListener(onClickListener);
        binding.tvModelAC.setOnClickListener(onClickListener);
        binding.bSubmit.setOnClickListener(onClickListener);
        if(getIntent().getStringExtra("type").equals("GC")){
          binding.lInvNameAC.setVisibility(View.VISIBLE);
          binding.lInvVersionAC.setVisibility(View.VISIBLE);
        }
        if(getIntent().getParcelableExtra("Product")!=null){
            bean=getIntent().getParcelableExtra("Product");
        }else {
            Log.i("is run","");
            bean=new SampleApplicationBean.Product();
            bean.setS_InvDefine1("");
        }
        Untils.setProductBean(OrderDetailActivity.this,bean);
        binding.etQty.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                SampleApplicationBean.Product product=Untils.getProductBean(OrderDetailActivity.this);
                product.setS_Qty(editable.toString());
                Untils.setProductBean(OrderDetailActivity.this,product);
            }
        });
        binding.etUseprice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                SampleApplicationBean.Product product=Untils.getProductBean(OrderDetailActivity.this);
                product.setS_UsePrice(editable.toString());
                Untils.setProductBean(OrderDetailActivity.this,product);
            }
        });
        binding.etUseqty.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                SampleApplicationBean.Product product=Untils.getProductBean(OrderDetailActivity.this);
                product.setS_UseQty(editable.toString());
                Untils.setProductBean(OrderDetailActivity.this,product);
            }
        });
    }
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=null;
            switch (view.getId()){
                case R.id.tv_family:

                    intent=new Intent(OrderDetailActivity.this,FamilyListActivity.class);
                    intent.putExtra("type",getIntent().getStringExtra("type"));
                    startActivity(intent);
                    break;
                case R.id.tv_model:
                    if(binding.tvFamily.getText().equals("")){
                        Toast.makeText(OrderDetailActivity.this, "请先选择产品系列", Toast.LENGTH_LONG).show();
                        return;
                    }
                    intent=new Intent(OrderDetailActivity.this, ModelListActivity.class);
                    intent.putExtra("type",getIntent().getStringExtra("type"));
                    startActivity(intent);
                    break;
                case R.id.tv_model_AC:
                    if(binding.tvFamily.getText().equals("")){
                        Toast.makeText(OrderDetailActivity.this, "请先选择产品系列", Toast.LENGTH_LONG).show();
                        return;
                    }
                    intent=new Intent(OrderDetailActivity.this, ModelListActivity.class);
                    intent.putExtra("type",getIntent().getStringExtra("type"));
                    break;
                case R.id.tv_field:
                    AlertDialog.Builder builder=new AlertDialog.Builder(OrderDetailActivity.this);
                    builder.setTitle("请选择应用领域：").setSingleChoiceItems(stringsField, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Log.i("switch",stringsField[which]);
                            SampleApplicationBean.Product product=Untils.getProductBean(OrderDetailActivity.this);
                            product.setS_ApplicationArea(stringsField[which]);
                            Untils.setProductBean(OrderDetailActivity.this,product);
                             binding.setBean(product);
                            dialog.dismiss();
                        }
                    }).show();
                    break;
                case R.id.tv_description:
                    if(binding.tvField.getText().equals("")){
                        Toast.makeText(OrderDetailActivity.this, "请先选择应用领域", Toast.LENGTH_LONG).show();
                        return;
                    }
                    intent=new Intent(OrderDetailActivity.this, DescriptionListActivity.class);
                    intent.putExtra("type",getIntent().getStringExtra("type"));
                    startActivity(intent);
                    break;
                case R.id.b_submit:
                    SampleApplicationBean sampleApplicationBean=Untils.getSampleApplicationBean(OrderDetailActivity.this);
                    SampleApplicationBean.Product product=Untils.getProductBean(OrderDetailActivity.this);


                    sampleApplicationBean.getDetails().add(product);
                    Log.i("submit",new Gson().toJson(sampleApplicationBean));
                    Untils.setSampleApplicationBean(OrderDetailActivity.this,sampleApplicationBean);
                    finish();
                    break;
            }

        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        SampleApplicationBean.Product product=Untils.getProductBean(OrderDetailActivity.this);
        binding.setBean(product);

    }
}
