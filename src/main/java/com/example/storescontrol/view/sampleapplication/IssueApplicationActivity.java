package com.example.storescontrol.view.sampleapplication;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.storescontrol.R;
import com.example.storescontrol.Url.Untils;
import com.example.storescontrol.databinding.ActivityIssueApplicationBinding;
import com.example.storescontrol.view.BaseActivity;

public class IssueApplicationActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityIssueApplicationBinding binding= DataBindingUtil.setContentView(IssueApplicationActivity.this,R.layout.activity_issue_application);
        Untils.initTitle(getIntent().getStringExtra("menuname"),this);
        binding.bApplicationdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(IssueApplicationActivity.this,ApplicationDetailsActivity.class);
                intent.putExtra("menuname","工程品申请明细");
                startActivity(intent);
            }
        });
    }
}
