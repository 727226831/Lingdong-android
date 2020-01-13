package com.example.storescontrol.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.storescontrol.R;
import com.example.storescontrol.bean.LoginBean;
import com.example.storescontrol.databinding.ActivityIndexBinding;

import com.example.storescontrol.view.sampleapplication.SampleTypeActivity;
import com.example.storescontrol.view.task.TaskListActivity;
import com.google.gson.Gson;



public class IndexActivity extends BaseActivity {

    RecyclerView recyclerView;
    FunctionAdapter functionAdapter;
    TextView titleTv,textViewExit;
    LoginBean userinfoBean;
    ActivityIndexBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_index);

        SharedPreferences sharedPreferences = getSharedPreferences("sp", Context.MODE_PRIVATE);
        String data=sharedPreferences.getString("userinfo","");
        if(!data.equals("")){
            userinfoBean=new Gson().fromJson(data,LoginBean.class);
           Log.i("menu-->",new Gson().toJson(userinfoBean));
        }

        binding.setUser(userinfoBean);


        titleTv=binding.getRoot().findViewById(R.id.tv_title);
        titleTv.setText("首页");
        binding.lTitle.setBackgroundColor(Color.TRANSPARENT);

        textViewExit=binding.getRoot().findViewById(R.id.tv_exit);
        textViewExit.setVisibility(View.VISIBLE);



        functionAdapter=new FunctionAdapter();
        recyclerView=findViewById(R.id.rv_function);
        recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        recyclerView.setAdapter(functionAdapter);
        textViewExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this,LoginActivity.class));
                IndexActivity.this.finish();
            }
        });



    }


    class FunctionAdapter extends RecyclerView.Adapter<FunctionAdapter.VH>{

        @NonNull
        @Override
        public FunctionAdapter.VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v=getLayoutInflater().inflate(R.layout.item_funcation,viewGroup,false);
            return new VH(v);
        }

        @Override
        public void onBindViewHolder(@NonNull  FunctionAdapter.VH vh, final int i) {
            if(userinfoBean.getData().get(i).getVoucherCount().equals("0")){
                vh.textViewTag.setVisibility(View.GONE);
            }
            vh.textViewTag.setText(userinfoBean.getData().get(i).getVoucherCount());
            vh.funcationButton.setText(userinfoBean.getData().get(i).getMenuname());

            vh.funcationButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent();

                if(userinfoBean.getData().get(i).getMenuname().equals("报价审批")){
                        intent  =new Intent(IndexActivity.this, TaskListActivity.class);
                    }else if(userinfoBean.getData().get(i).getMenuname().equals("样品申请")){
                        intent  =new Intent(IndexActivity.this, SampleTypeActivity.class);
                    }
                    intent.putExtra("menuname",userinfoBean.getData().get(i).getMenuname());

                    startActivity(intent);

                }
            });
            Drawable drawableLeft = null;
           if(userinfoBean.getData().get(i).getMenuname().contains("报价审批")){
                drawableLeft = IndexActivity.this.getResources().getDrawable(R.mipmap.apprival);
            }else if(userinfoBean.getData().get(i).getMenuname().contains("样品申请")){
                drawableLeft = IndexActivity.this.getResources().getDrawable(R.mipmap.apprival);
            }
            vh.funcationButton.setCompoundDrawablesWithIntrinsicBounds(null,
                    drawableLeft, null, null);
        }

        @Override
        public int getItemCount() {
            return userinfoBean.getData().size();
        }
        class  VH extends RecyclerView.ViewHolder{
            Button funcationButton;
            TextView textViewTag;
            public VH(@NonNull View itemView) {
                super(itemView);
                funcationButton=itemView.findViewById(R.id.b_funcation);
                textViewTag=itemView.findViewById(R.id.tv_tag);
            }
        }
    }
}
