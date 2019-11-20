package com.example.storescontrol.view.sampleapplication;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.storescontrol.R;
import com.example.storescontrol.Url.Untils;
import com.example.storescontrol.databinding.ActivitySampleApplationBinding;
import com.example.storescontrol.view.BaseActivity;

public class SampleApplationActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySampleApplationBinding binding= DataBindingUtil.setContentView(SampleApplationActivity.this,R.layout.activity_sample_applation);
        Untils.initTitle(getIntent().getStringExtra("menuname"),this);
        binding.bOrderdatails.setOnClickListener(onClickListener);
        binding.bSendinformation.setOnClickListener(onClickListener);
    }
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=null;
            switch (view.getId()){
                case R.id.b_orderdatails:
                     intent=new Intent(SampleApplationActivity.this,OrderDetailActivity.class);
                    intent.putExtra("menuname","订单明细");
                    break;
                case R.id.b_sendinformation:
                    intent=new Intent(SampleApplationActivity.this,SendInformationActivity.class);
                    intent.putExtra("menuname","寄送明细");
                    break;
            }
            startActivity(intent);
        }
    };
}
