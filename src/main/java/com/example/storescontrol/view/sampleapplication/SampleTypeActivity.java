package com.example.storescontrol.view.sampleapplication;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.storescontrol.R;
import com.example.storescontrol.Url.Untils;
import com.example.storescontrol.databinding.ActivitySampleTypeBinding;
import com.example.storescontrol.view.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class SampleTypeActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySampleTypeBinding binding= DataBindingUtil.setContentView(SampleTypeActivity.this,R.layout.activity_sample_type);

        Untils.initTitle(getIntent().getStringExtra("menuname"),this);

        List<String> stringList=new ArrayList<>();
        stringList.add("样片&评估板&管芯");
        stringList.add("MCU工程品发放申请");
        stringList.add("MM32-Motor-DK申请");
        stringList.add("我的审批任务");
        stringList.add("我的样品申请");

        FunctionAdapter functionAdapter=new FunctionAdapter(stringList);

        binding.rvList.setLayoutManager(new LinearLayoutManager(SampleTypeActivity.this));
        binding.rvList.addItemDecoration(new DividerItemDecoration(SampleTypeActivity.this,DividerItemDecoration.VERTICAL));
        binding.rvList.setAdapter(functionAdapter);


//        binding.lOne.setOnClickListener(onClickListenern);
//        binding.lTwo.setOnClickListener(onClickListenern);
//        binding.lThree.setOnClickListener(onClickListenern);
//        binding.lFour.setOnClickListener(onClickListenern);



    }
    View.OnClickListener onClickListenern=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=null;

            switch (v.getId()){
//                case R.id.l_one:
//                    intent=new Intent(SampleTypeActivity.this,IssueApplicationActivity.class);
//                    intent.putExtra("menuname","样片&评估板&管芯");
//                    intent.putExtra("type","YP");
//                    break;
//                case R.id.l_two:
//                    intent=new Intent(SampleTypeActivity.this,IssueApplicationActivity.class);
//                    intent.putExtra("menuname","MCU工程品发放申请");
//                    intent.putExtra("type","GC");
//                    break;
//                case R.id.l_three:
//                    intent=new Intent(SampleTypeActivity.this,IssueApplicationActivity.class);
//                    intent.putExtra("menuname","MM32-Motor-DK申请");
//                    intent.putExtra("type","");
//                    break;
//                case R.id.l_four:
//                    intent=new Intent(SampleTypeActivity.this,SampleListActivity.class);
//                    intent.putExtra("menuname","样品申请审批");
//                    intent.putExtra("type","");
//                    break;


            }

            startActivity(intent);
        }
    };
    class FunctionAdapter extends RecyclerView.Adapter<FunctionAdapter.VH>{

        @NonNull
        @Override
        public FunctionAdapter.VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v=getLayoutInflater().inflate(R.layout.item_selector,viewGroup,false);
            return new FunctionAdapter.VH(v);
        }

        private List<String> mDatas;
        public FunctionAdapter(List<String> data) {
            this.mDatas = data;
        }

        @Override
        public void onBindViewHolder(@NonNull FunctionAdapter.VH vh, final int i) {

            vh.textViewAgent.setText(mDatas.get(i));
            vh.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent  intent=null;
                    switch (i){
                        case 0:
                            intent= new Intent(SampleTypeActivity.this,IssueApplicationActivity.class);
                            intent.putExtra("menuname","样片&评估板&管芯");
                            intent.putExtra("type","YP");
                            break;
                        case 1:
                            intent=new Intent(SampleTypeActivity.this,IssueApplicationActivity.class);
                            intent.putExtra("menuname","MCU工程品发放申请");
                            intent.putExtra("type","GC");
                            break;
                        case 2:
                            intent=new Intent(SampleTypeActivity.this,IssueApplicationActivity.class);
                            intent.putExtra("menuname","MM32-Motor-DK申请");
                            intent.putExtra("type","");
                            break;
                        case 3:
                            intent=new Intent(SampleTypeActivity.this,SampleListActivity.class);
                            intent.putExtra("menuname","我的审批任务");
                            intent.putExtra("type","");
                            break;
                        case 4:
                            intent=new Intent(SampleTypeActivity.this, MySampleActivity.class);
                            intent.putExtra("menuname","我的样品申请");
                            intent.putExtra("type","");
                            break;
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
            LinearLayout linearLayout;
            TextView textViewAgent;
            public VH(@NonNull View itemView) {
                super(itemView);
                linearLayout=itemView.findViewById(R.id.l_layout);
                textViewAgent=itemView.findViewById(R.id.tv_key);

            }
        }
    }
}
