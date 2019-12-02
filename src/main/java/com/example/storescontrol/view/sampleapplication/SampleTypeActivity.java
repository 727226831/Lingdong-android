package com.example.storescontrol.view.sampleapplication;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.example.storescontrol.R;
import com.example.storescontrol.Url.Untils;
import com.example.storescontrol.databinding.ActivitySampleTypeBinding;
import com.example.storescontrol.view.BaseActivity;

public class SampleTypeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySampleTypeBinding binding= DataBindingUtil.setContentView(SampleTypeActivity.this,R.layout.activity_sample_type);

        Untils.initTitle(getIntent().getStringExtra("menuname"),this);
        binding.lOne.setOnClickListener(onClickListenern);
        binding.lTwo.setOnClickListener(onClickListenern);
        binding.lThree.setOnClickListener(onClickListenern);



    }
    View.OnClickListener onClickListenern=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=null;
            intent=new Intent(SampleTypeActivity.this,IssueApplicationActivity.class);
            switch (v.getId()){
                case R.id.l_one:
                    intent.putExtra("menuname","MCU销售订单申请");
                    intent.putExtra("type","YP");
                    break;
                case R.id.l_two:
                    intent.putExtra("menuname","MCU工程品发放申请");
                    intent.putExtra("type","GC");
                    break;
                case R.id.l_three:
                    intent.putExtra("menuname","MM32-Motor-DK申请");
                    intent.putExtra("type","");
                    break;


            }

            startActivity(intent);
        }
    };
}
