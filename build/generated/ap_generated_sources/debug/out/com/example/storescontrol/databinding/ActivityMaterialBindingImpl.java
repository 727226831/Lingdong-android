package com.example.storescontrol.databinding;
import com.example.storescontrol.R;
import com.example.storescontrol.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMaterialBindingImpl extends ActivityMaterialBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tv_title1, 2);
        sViewsWithIds.put(R.id.iv_cwhcode, 3);
        sViewsWithIds.put(R.id.et_cwhcode, 4);
        sViewsWithIds.put(R.id.et_warehouse, 5);
        sViewsWithIds.put(R.id.et_inventory, 6);
        sViewsWithIds.put(R.id.tv_title0, 7);
        sViewsWithIds.put(R.id.et_position, 8);
        sViewsWithIds.put(R.id.et_batch, 9);
        sViewsWithIds.put(R.id.b_search, 10);
        sViewsWithIds.put(R.id.rv_list, 11);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMaterialBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private ActivityMaterialBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[10]
            , (android.widget.TextView) bindings[9]
            , (android.widget.EditText) bindings[4]
            , (android.widget.EditText) bindings[6]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[5]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.LinearLayout) bindings[1]
            , (android.support.v7.widget.RecyclerView) bindings[11]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[2]
            );
        this.lInput.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.bean == variableId) {
            setBean((com.example.storescontrol.bean.ArrivalHeadBean) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setBean(@Nullable com.example.storescontrol.bean.ArrivalHeadBean Bean) {
        this.mBean = Bean;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): bean
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}