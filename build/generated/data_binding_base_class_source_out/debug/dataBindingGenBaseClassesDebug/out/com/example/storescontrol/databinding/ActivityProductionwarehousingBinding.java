// Generated by data binding compiler. Do not edit!
package com.example.storescontrol.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.storescontrol.R;
import com.example.storescontrol.bean.ArrivalHeadBean;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityProductionwarehousingBinding extends ViewDataBinding {
  @NonNull
  public final Button bSearch;

  @NonNull
  public final Button bSubmit;

  @NonNull
  public final EditText etBatch;

  @NonNull
  public final EditText etCdefine10;

  @NonNull
  public final EditText etCount;

  @NonNull
  public final EditText etCwhcode;

  @NonNull
  public final EditText etTimes;

  @NonNull
  public final EditText etUpdatecwhcode;

  @NonNull
  public final ImageButton ibUpload;

  @NonNull
  public final ImageView ivAdd;

  @NonNull
  public final ImageView ivBatch;

  @NonNull
  public final ImageView ivCdefine10;

  @NonNull
  public final ImageView ivCwhcode;

  @NonNull
  public final ImageView ivMinus;

  @NonNull
  public final ImageView ivUpdatecwhcode;

  @NonNull
  public final LinearLayout lBatch;

  @NonNull
  public final LinearLayout lCboxno;

  @NonNull
  public final LinearLayout lCcode;

  @NonNull
  public final LinearLayout lCvenabbname;

  @NonNull
  public final RelativeLayout rlCdefine10;

  @NonNull
  public final RelativeLayout rlCwhcode;

  @NonNull
  public final RelativeLayout rlUpdate;

  @NonNull
  public final TextView tvCBoxNo;

  @NonNull
  public final TextView tvCBoxNokey;

  @NonNull
  public final TextView tvCInvName;

  @NonNull
  public final TextView tvCInvStd;

  @NonNull
  public final TextView tvCcode;

  @NonNull
  public final TextView tvCcodekey;

  @NonNull
  public final TextView tvCinvcode;

  @NonNull
  public final TextView tvCount;

  @NonNull
  public final TextView tvCvenabbname;

  @NonNull
  public final TextView tvCvenbatch;

  @NonNull
  public final TextView tvTitle1;

  @NonNull
  public final TextView tvTitle2;

  @NonNull
  public final TextView tvTitle3;

  @NonNull
  public final TextView tvTitle4;

  @NonNull
  public final TextView tvTotal;

  @Bindable
  protected ArrivalHeadBean mBean;

  protected ActivityProductionwarehousingBinding(Object _bindingComponent, View _root,
      int _localFieldCount, Button bSearch, Button bSubmit, EditText etBatch, EditText etCdefine10,
      EditText etCount, EditText etCwhcode, EditText etTimes, EditText etUpdatecwhcode,
      ImageButton ibUpload, ImageView ivAdd, ImageView ivBatch, ImageView ivCdefine10,
      ImageView ivCwhcode, ImageView ivMinus, ImageView ivUpdatecwhcode, LinearLayout lBatch,
      LinearLayout lCboxno, LinearLayout lCcode, LinearLayout lCvenabbname,
      RelativeLayout rlCdefine10, RelativeLayout rlCwhcode, RelativeLayout rlUpdate,
      TextView tvCBoxNo, TextView tvCBoxNokey, TextView tvCInvName, TextView tvCInvStd,
      TextView tvCcode, TextView tvCcodekey, TextView tvCinvcode, TextView tvCount,
      TextView tvCvenabbname, TextView tvCvenbatch, TextView tvTitle1, TextView tvTitle2,
      TextView tvTitle3, TextView tvTitle4, TextView tvTotal) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bSearch = bSearch;
    this.bSubmit = bSubmit;
    this.etBatch = etBatch;
    this.etCdefine10 = etCdefine10;
    this.etCount = etCount;
    this.etCwhcode = etCwhcode;
    this.etTimes = etTimes;
    this.etUpdatecwhcode = etUpdatecwhcode;
    this.ibUpload = ibUpload;
    this.ivAdd = ivAdd;
    this.ivBatch = ivBatch;
    this.ivCdefine10 = ivCdefine10;
    this.ivCwhcode = ivCwhcode;
    this.ivMinus = ivMinus;
    this.ivUpdatecwhcode = ivUpdatecwhcode;
    this.lBatch = lBatch;
    this.lCboxno = lCboxno;
    this.lCcode = lCcode;
    this.lCvenabbname = lCvenabbname;
    this.rlCdefine10 = rlCdefine10;
    this.rlCwhcode = rlCwhcode;
    this.rlUpdate = rlUpdate;
    this.tvCBoxNo = tvCBoxNo;
    this.tvCBoxNokey = tvCBoxNokey;
    this.tvCInvName = tvCInvName;
    this.tvCInvStd = tvCInvStd;
    this.tvCcode = tvCcode;
    this.tvCcodekey = tvCcodekey;
    this.tvCinvcode = tvCinvcode;
    this.tvCount = tvCount;
    this.tvCvenabbname = tvCvenabbname;
    this.tvCvenbatch = tvCvenbatch;
    this.tvTitle1 = tvTitle1;
    this.tvTitle2 = tvTitle2;
    this.tvTitle3 = tvTitle3;
    this.tvTitle4 = tvTitle4;
    this.tvTotal = tvTotal;
  }

  public abstract void setBean(@Nullable ArrivalHeadBean bean);

  @Nullable
  public ArrivalHeadBean getBean() {
    return mBean;
  }

  @NonNull
  public static ActivityProductionwarehousingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_productionwarehousing, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityProductionwarehousingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityProductionwarehousingBinding>inflateInternal(inflater, R.layout.activity_productionwarehousing, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityProductionwarehousingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_productionwarehousing, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityProductionwarehousingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityProductionwarehousingBinding>inflateInternal(inflater, R.layout.activity_productionwarehousing, null, false, component);
  }

  public static ActivityProductionwarehousingBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityProductionwarehousingBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityProductionwarehousingBinding)bind(component, view, R.layout.activity_productionwarehousing);
  }
}
