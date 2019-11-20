package com.example.storescontrol.view.sampleapplication;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.storescontrol.R;
import com.example.storescontrol.Url.Untils;
import com.example.storescontrol.databinding.ActivityDkapplicationBinding;
import com.example.storescontrol.view.BaseActivity;

public class DkApplicationActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDkapplicationBinding binding= DataBindingUtil.setContentView(DkApplicationActivity.this,R.layout.activity_dkapplication);
        Untils.initTitle(getIntent().getStringExtra("menuname"),this);
        binding.bDeatils.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DkApplicationActivity.this,DkDetailsActivity.class);
                intent.putExtra("menuname","明细");
                startActivity(intent);
            }
        });
    }
}
