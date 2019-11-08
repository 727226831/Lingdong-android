package com.example.storescontrol.databinding;
import com.example.storescontrol.R;
import com.example.storescontrol.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityTaskBindingImpl extends ActivityTaskBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.l_title, 19);
        sViewsWithIds.put(R.id.rl_bottom, 20);
        sViewsWithIds.put(R.id.b_agree, 21);
        sViewsWithIds.put(R.id.b_disagree, 22);
        sViewsWithIds.put(R.id.b_exit, 23);
        sViewsWithIds.put(R.id.tv_total, 24);
        sViewsWithIds.put(R.id.tv_ccodekey, 25);
        sViewsWithIds.put(R.id.l_cvenabbname, 26);
        sViewsWithIds.put(R.id.l_moq, 27);
        sViewsWithIds.put(R.id.tv_key, 28);
        sViewsWithIds.put(R.id.rg_moq, 29);
        sViewsWithIds.put(R.id.rb_yes, 30);
        sViewsWithIds.put(R.id.rb_no, 31);
        sViewsWithIds.put(R.id.et_P_AuditMemo, 32);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.widget.TextView mboundView10;
    @NonNull
    private final android.widget.TextView mboundView11;
    @NonNull
    private final android.widget.TextView mboundView12;
    @NonNull
    private final android.widget.TextView mboundView13;
    @NonNull
    private final android.widget.TextView mboundView14;
    @NonNull
    private final android.widget.TextView mboundView15;
    @NonNull
    private final android.widget.TextView mboundView16;
    @NonNull
    private final android.widget.TextView mboundView17;
    @NonNull
    private final android.widget.TextView mboundView18;
    @NonNull
    private final android.widget.TextView mboundView3;
    @NonNull
    private final android.widget.TextView mboundView7;
    @NonNull
    private final android.widget.TextView mboundView8;
    @NonNull
    private final android.widget.TextView mboundView9;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityTaskBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 33, sIncludes, sViewsWithIds));
    }
    private ActivityTaskBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[21]
            , (android.widget.Button) bindings[22]
            , (android.widget.Button) bindings[23]
            , (android.widget.EditText) bindings[32]
            , (android.widget.LinearLayout) bindings[26]
            , (android.widget.LinearLayout) bindings[27]
            , (android.view.View) bindings[19]
            , (android.widget.RadioButton) bindings[31]
            , (android.widget.RadioButton) bindings[30]
            , (android.widget.RadioGroup) bindings[29]
            , (android.widget.RelativeLayout) bindings[20]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[25]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[28]
            , (android.widget.TextView) bindings[24]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView10 = (android.widget.TextView) bindings[10];
        this.mboundView10.setTag(null);
        this.mboundView11 = (android.widget.TextView) bindings[11];
        this.mboundView11.setTag(null);
        this.mboundView12 = (android.widget.TextView) bindings[12];
        this.mboundView12.setTag(null);
        this.mboundView13 = (android.widget.TextView) bindings[13];
        this.mboundView13.setTag(null);
        this.mboundView14 = (android.widget.TextView) bindings[14];
        this.mboundView14.setTag(null);
        this.mboundView15 = (android.widget.TextView) bindings[15];
        this.mboundView15.setTag(null);
        this.mboundView16 = (android.widget.TextView) bindings[16];
        this.mboundView16.setTag(null);
        this.mboundView17 = (android.widget.TextView) bindings[17];
        this.mboundView17.setTag(null);
        this.mboundView18 = (android.widget.TextView) bindings[18];
        this.mboundView18.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView7 = (android.widget.TextView) bindings[7];
        this.mboundView7.setTag(null);
        this.mboundView8 = (android.widget.TextView) bindings[8];
        this.mboundView8.setTag(null);
        this.mboundView9 = (android.widget.TextView) bindings[9];
        this.mboundView9.setTag(null);
        this.tvCInvName.setTag(null);
        this.tvCInvStd.setTag(null);
        this.tvCcode.setTag(null);
        this.tvCinvcode.setTag(null);
        this.tvCvenabbname.setTag(null);
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
            setBean((com.example.storescontrol.bean.TaskBean.Data) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setBean(@Nullable com.example.storescontrol.bean.TaskBean.Data Bean) {
        this.mBean = Bean;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.bean);
        super.requestRebind();
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
        java.lang.String beanSQuotationID = null;
        java.lang.String beanSVerifyer = null;
        java.lang.String beanSApplicationArea = null;
        java.lang.String beanSInvName = null;
        java.lang.String beanSRegion = null;
        java.lang.String beanSProjectName = null;
        java.lang.String beanSUseQty = null;
        java.lang.String beanSInvType = null;
        java.lang.String beanSRegisterDate = null;
        java.lang.String beanSPackage = null;
        java.lang.String beanSApplicationProject = null;
        java.lang.String beanSInvVersion = null;
        java.lang.String beanSSum = null;
        java.lang.String beanSAddress = null;
        java.lang.String beanRRecordCompany = null;
        com.example.storescontrol.bean.TaskBean.Data bean = mBean;
        java.lang.String beanMMSN = null;
        java.lang.String beanSPrice = null;
        java.lang.String beanSQty = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (bean != null) {
                    // read bean.s_QuotationID
                    beanSQuotationID = bean.getS_QuotationID();
                    // read bean.s_Verifyer
                    beanSVerifyer = bean.getS_Verifyer();
                    // read bean.s_ApplicationArea
                    beanSApplicationArea = bean.getS_ApplicationArea();
                    // read bean.s_InvName
                    beanSInvName = bean.getS_InvName();
                    // read bean.S_Region
                    beanSRegion = bean.getS_Region();
                    // read bean.S_ProjectName
                    beanSProjectName = bean.getS_ProjectName();
                    // read bean.S_UseQty
                    beanSUseQty = bean.getS_UseQty();
                    // read bean.S_InvType
                    beanSInvType = bean.getS_InvType();
                    // read bean.s_RegisterDate
                    beanSRegisterDate = bean.getS_RegisterDate();
                    // read bean.S_Package
                    beanSPackage = bean.getS_Package();
                    // read bean.S_ApplicationProject
                    beanSApplicationProject = bean.getS_ApplicationProject();
                    // read bean.s_InvVersion
                    beanSInvVersion = bean.getS_InvVersion();
                    // read bean.S_Sum
                    beanSSum = bean.getS_Sum();
                    // read bean.S_Address
                    beanSAddress = bean.getS_Address();
                    // read bean.r_RecordCompany
                    beanRRecordCompany = bean.getR_RecordCompany();
                    // read bean.m_MSN
                    beanMMSN = bean.getM_MSN();
                    // read bean.S_Price
                    beanSPrice = bean.getS_Price();
                    // read bean.S_Qty
                    beanSQty = bean.getS_Qty();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView10, beanSInvName);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView11, beanSInvVersion);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView12, beanSUseQty);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView13, beanSQty);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView14, beanSPrice);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView15, beanSSum);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView16, beanSPackage);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView17, beanSAddress);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView18, beanSRegisterDate);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, beanMMSN);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView7, beanSInvType);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView8, beanSProjectName);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView9, beanSVerifyer);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvCInvName, beanRRecordCompany);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvCInvStd, beanSApplicationArea);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvCcode, beanSRegion);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvCinvcode, beanSQuotationID);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvCvenabbname, beanSApplicationProject);
        }
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