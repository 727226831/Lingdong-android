package com.example.storescontrol;

import android.databinding.DataBinderMapper;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.example.storescontrol.databinding.ActivityIndexBindingImpl;
import com.example.storescontrol.databinding.ActivityLoginBindingImpl;
import com.example.storescontrol.databinding.ActivityMaterialBindingImpl;
import com.example.storescontrol.databinding.ActivityPrintBindingImpl;
import com.example.storescontrol.databinding.ActivityProductionwarehousingBindingImpl;
import com.example.storescontrol.databinding.ActivityPutdetailBindingImpl;
import com.example.storescontrol.databinding.ActivityReportBindingImpl;
import com.example.storescontrol.databinding.ActivityStockcheckBindingImpl;
import com.example.storescontrol.databinding.ActivityTaskBindingImpl;
import com.example.storescontrol.databinding.ItemDetailListBindingImpl;
import com.example.storescontrol.databinding.ItemDispatchdetailsBindingImpl;
import com.example.storescontrol.databinding.ItemInputBindingImpl;
import com.example.storescontrol.databinding.ItemProductionListBindingImpl;
import com.example.storescontrol.databinding.ItemStockcheckBindingImpl;
import com.example.storescontrol.databinding.ItemTaskBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYINDEX = 1;

  private static final int LAYOUT_ACTIVITYLOGIN = 2;

  private static final int LAYOUT_ACTIVITYMATERIAL = 3;

  private static final int LAYOUT_ACTIVITYPRINT = 4;

  private static final int LAYOUT_ACTIVITYPRODUCTIONWAREHOUSING = 5;

  private static final int LAYOUT_ACTIVITYPUTDETAIL = 6;

  private static final int LAYOUT_ACTIVITYREPORT = 7;

  private static final int LAYOUT_ACTIVITYSTOCKCHECK = 8;

  private static final int LAYOUT_ACTIVITYTASK = 9;

  private static final int LAYOUT_ITEMDETAILLIST = 10;

  private static final int LAYOUT_ITEMDISPATCHDETAILS = 11;

  private static final int LAYOUT_ITEMINPUT = 12;

  private static final int LAYOUT_ITEMPRODUCTIONLIST = 13;

  private static final int LAYOUT_ITEMSTOCKCHECK = 14;

  private static final int LAYOUT_ITEMTASK = 15;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(15);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.storescontrol.R.layout.activity_index, LAYOUT_ACTIVITYINDEX);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.storescontrol.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.storescontrol.R.layout.activity_material, LAYOUT_ACTIVITYMATERIAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.storescontrol.R.layout.activity_print, LAYOUT_ACTIVITYPRINT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.storescontrol.R.layout.activity_productionwarehousing, LAYOUT_ACTIVITYPRODUCTIONWAREHOUSING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.storescontrol.R.layout.activity_putdetail, LAYOUT_ACTIVITYPUTDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.storescontrol.R.layout.activity_report, LAYOUT_ACTIVITYREPORT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.storescontrol.R.layout.activity_stockcheck, LAYOUT_ACTIVITYSTOCKCHECK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.storescontrol.R.layout.activity_task, LAYOUT_ACTIVITYTASK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.storescontrol.R.layout.item_detail_list, LAYOUT_ITEMDETAILLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.storescontrol.R.layout.item_dispatchdetails, LAYOUT_ITEMDISPATCHDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.storescontrol.R.layout.item_input, LAYOUT_ITEMINPUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.storescontrol.R.layout.item_production_list, LAYOUT_ITEMPRODUCTIONLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.storescontrol.R.layout.item_stockcheck, LAYOUT_ITEMSTOCKCHECK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.storescontrol.R.layout.item_task, LAYOUT_ITEMTASK);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYINDEX: {
          if ("layout/activity_index_0".equals(tag)) {
            return new ActivityIndexBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_index is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLOGIN: {
          if ("layout/activity_login_0".equals(tag)) {
            return new ActivityLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMATERIAL: {
          if ("layout/activity_material_0".equals(tag)) {
            return new ActivityMaterialBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_material is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPRINT: {
          if ("layout/activity_print_0".equals(tag)) {
            return new ActivityPrintBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_print is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPRODUCTIONWAREHOUSING: {
          if ("layout/activity_productionwarehousing_0".equals(tag)) {
            return new ActivityProductionwarehousingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_productionwarehousing is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPUTDETAIL: {
          if ("layout/activity_putdetail_0".equals(tag)) {
            return new ActivityPutdetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_putdetail is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYREPORT: {
          if ("layout/activity_report_0".equals(tag)) {
            return new ActivityReportBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_report is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSTOCKCHECK: {
          if ("layout/activity_stockcheck_0".equals(tag)) {
            return new ActivityStockcheckBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_stockcheck is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYTASK: {
          if ("layout/activity_task_0".equals(tag)) {
            return new ActivityTaskBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_task is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMDETAILLIST: {
          if ("layout/item_detail_list_0".equals(tag)) {
            return new ItemDetailListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_detail_list is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMDISPATCHDETAILS: {
          if ("layout/item_dispatchdetails_0".equals(tag)) {
            return new ItemDispatchdetailsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_dispatchdetails is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMINPUT: {
          if ("layout/item_input_0".equals(tag)) {
            return new ItemInputBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_input is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMPRODUCTIONLIST: {
          if ("layout/item_production_list_0".equals(tag)) {
            return new ItemProductionListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_production_list is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMSTOCKCHECK: {
          if ("layout/item_stockcheck_0".equals(tag)) {
            return new ItemStockcheckBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_stockcheck is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMTASK: {
          if ("layout/item_task_0".equals(tag)) {
            return new ItemTaskBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_task is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new com.android.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(4);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "user");
      sKeys.put(2, "bean");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(15);

    static {
      sKeys.put("layout/activity_index_0", com.example.storescontrol.R.layout.activity_index);
      sKeys.put("layout/activity_login_0", com.example.storescontrol.R.layout.activity_login);
      sKeys.put("layout/activity_material_0", com.example.storescontrol.R.layout.activity_material);
      sKeys.put("layout/activity_print_0", com.example.storescontrol.R.layout.activity_print);
      sKeys.put("layout/activity_productionwarehousing_0", com.example.storescontrol.R.layout.activity_productionwarehousing);
      sKeys.put("layout/activity_putdetail_0", com.example.storescontrol.R.layout.activity_putdetail);
      sKeys.put("layout/activity_report_0", com.example.storescontrol.R.layout.activity_report);
      sKeys.put("layout/activity_stockcheck_0", com.example.storescontrol.R.layout.activity_stockcheck);
      sKeys.put("layout/activity_task_0", com.example.storescontrol.R.layout.activity_task);
      sKeys.put("layout/item_detail_list_0", com.example.storescontrol.R.layout.item_detail_list);
      sKeys.put("layout/item_dispatchdetails_0", com.example.storescontrol.R.layout.item_dispatchdetails);
      sKeys.put("layout/item_input_0", com.example.storescontrol.R.layout.item_input);
      sKeys.put("layout/item_production_list_0", com.example.storescontrol.R.layout.item_production_list);
      sKeys.put("layout/item_stockcheck_0", com.example.storescontrol.R.layout.item_stockcheck);
      sKeys.put("layout/item_task_0", com.example.storescontrol.R.layout.item_task);
    }
  }
}