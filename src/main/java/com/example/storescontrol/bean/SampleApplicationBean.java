package com.example.storescontrol.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class SampleApplicationBean implements Parcelable {
    private String S_Code;//申请单号
    private String S_Maker;//申请人

    public String getS_State() {
        return S_State;
    }

    public void setS_State(String s_State) {
        S_State = s_State;
    }

    private String S_State;
    public String getS_Id() {
        return S_Id;
    }

    public void setS_Id(String s_Id) {
        S_Id = s_Id;
    }

    private String S_Id;

    public String getP_Id() {
        return P_Id;
    }

    public void setP_Id(String p_Id) {
        P_Id = p_Id;
    }

    private String P_Id;
    public String getS_Maker_Id() {
        return S_Maker_Id;
    }

    public void setS_Maker_Id(String s_Maker_Id) {
        S_Maker_Id = s_Maker_Id;
    }

    private String S_Maker_Id;
    private String S_SaleMan;//责任销售
    private String S_DepName;//所在部门
    private int S_SaleMan_Id;//责任销售ID
    private String R_RecordCompany;//备案客户名称
    private int R_Id;//备案客户ID
    private String S_ContactPerson;//联系人
    private String S_ContactPhone;
    private String S_ContactMail;
    private String S_ContactAddress;
    private String S_AppType;//申请类型
    private String R_MemberAgents;//供应商
    String S_Attachment01;

    public String getS_Attachment01() {
        return S_Attachment01;
    }

    public void setS_Attachment01(String s_Attachment01) {
        S_Attachment01 = s_Attachment01;
    }

    public String getS_Attachment02() {
        return S_Attachment02;
    }

    public void setS_Attachment02(String s_Attachment02) {
        S_Attachment02 = s_Attachment02;
    }

    public String getS_Attachment03() {
        return S_Attachment03;
    }

    public void setS_Attachment03(String s_Attachment03) {
        S_Attachment03 = s_Attachment03;
    }

    public String getS_Attachment04() {
        return S_Attachment04;
    }

    public void setS_Attachment04(String s_Attachment04) {
        S_Attachment04 = s_Attachment04;
    }

    public String getS_Attachment05() {
        return S_Attachment05;
    }

    public void setS_Attachment05(String s_Attachment05) {
        S_Attachment05 = s_Attachment05;
    }

    String S_Attachment02;
    String S_Attachment03;
    String S_Attachment04;
    String S_Attachment05;

    public String getS_Code() {
        return S_Code;
    }

    public void setS_Code(String s_Code) {
        S_Code = s_Code;
    }

    public String getS_Maker() {
        return S_Maker;
    }

    public void setS_Maker(String s_Maker) {
        S_Maker = s_Maker;
    }

    public String getS_SaleMan() {
        return S_SaleMan;
    }

    public void setS_SaleMan(String s_SaleMan) {
        S_SaleMan = s_SaleMan;
    }

    public String getS_DepName() {
        return S_DepName;
    }

    public void setS_DepName(String s_DepName) {
        S_DepName = s_DepName;
    }

    public int getS_SaleMan_Id() {
        return S_SaleMan_Id;
    }

    public void setS_SaleMan_Id(int s_SaleMan_Id) {
        S_SaleMan_Id = s_SaleMan_Id;
    }

    public String getR_RecordCompany() {
        return R_RecordCompany;
    }

    public void setR_RecordCompany(String r_RecordCompany) {
        R_RecordCompany = r_RecordCompany;
    }

    public int getR_Id() {
        return R_Id;
    }

    public void setR_Id(int r_Id) {
        R_Id = r_Id;
    }

    public String getS_ContactPerson() {
        return S_ContactPerson;
    }

    public void setS_ContactPerson(String s_ContactPerson) {
        S_ContactPerson = s_ContactPerson;
    }

    public String getS_ContactPhone() {
        return S_ContactPhone;
    }

    public void setS_ContactPhone(String s_ContactPhone) {
        S_ContactPhone = s_ContactPhone;
    }

    public String getS_ContactMail() {
        return S_ContactMail;
    }

    public void setS_ContactMail(String s_ContactMail) {
        S_ContactMail = s_ContactMail;
    }

    public String getS_ContactAddress() {
        return S_ContactAddress;
    }

    public void setS_ContactAddress(String s_ContactAddress) {
        S_ContactAddress = s_ContactAddress;
    }

    public String getS_AppType() {
        return S_AppType;
    }

    public void setS_AppType(String s_AppType) {
        S_AppType = s_AppType;
    }

    public String getR_MemberAgents() {
        return R_MemberAgents;
    }

    public void setR_MemberAgents(String r_MemberAgents) {
        R_MemberAgents = r_MemberAgents;
    }

    public String getS_ContactPerson_M() {
        return S_ContactPerson_M;
    }

    public void setS_ContactPerson_M(String s_ContactPerson_M) {
        S_ContactPerson_M = s_ContactPerson_M;
    }

    public String getS_ContactPhone_M() {
        return S_ContactPhone_M;
    }

    public void setS_ContactPhone_M(String s_ContactPhone_M) {
        S_ContactPhone_M = s_ContactPhone_M;
    }

    public String getS_ContactAddress_M() {
        return S_ContactAddress_M;
    }

    public void setS_ContactAddress_M(String s_ContactAddress_M) {
        S_ContactAddress_M = s_ContactAddress_M;
    }

    public String getS_ExpressCompany() {
        return S_ExpressCompany;
    }

    public void setS_ExpressCompany(String s_ExpressCompany) {
        S_ExpressCompany = s_ExpressCompany;
    }

    public String getS_ExpressNumber() {
        return S_ExpressNumber;
    }

    public void setS_ExpressNumber(String s_ExpressNumber) {
        S_ExpressNumber = s_ExpressNumber;
    }

    public String getS_Memo() {
        return S_Memo;
    }

    public void setS_Memo(String s_Memo) {
        S_Memo = s_Memo;
    }

    public String getS_Feedback() {
        return S_Feedback;
    }

    public void setS_Feedback(String s_Feedback) {
        S_Feedback = s_Feedback;
    }



    private String S_ContactPerson_M;
    private String S_ContactPhone_M;
    private String S_ContactAddress_M;
    private String S_ExpressCompany;//快递公司
    private String S_ExpressNumber;//快递单号
    private String S_Memo;
    private String S_Feedback;

    public List<Product> getJ_SampleDetails() {
        return J_SampleDetails;
    }

    public void setJ_SampleDetails(List<Product> j_SampleDetails) {
        J_SampleDetails = j_SampleDetails;
    }

    private List<Product> J_SampleDetails =new ArrayList<>();


    public static class Product implements Parcelable {
        String S_InvDefine1="";
        String S_InvName;

        public String getS_InvDefine1() {
            return S_InvDefine1;
        }

        public void setS_InvDefine1(String s_InvDefine1) {
            S_InvDefine1 = s_InvDefine1;
        }

        public String getS_InvName() {
            return S_InvName;
        }

        public void setS_InvName(String s_InvName) {
            S_InvName = s_InvName;
        }

        public String getS_InvVersion() {
            return S_InvVersion;
        }

        public void setS_InvVersion(String s_InvVersion) {
            S_InvVersion = s_InvVersion;
        }

        public String getS_Qty() {
            return S_Qty;
        }

        public void setS_Qty(String s_Qty) {
            S_Qty = s_Qty;
        }

        public String getS_Batch() {
            return S_Batch;
        }

        public void setS_Batch(String s_Batch) {
            S_Batch = s_Batch;
        }

        public String getS_WhCode() {
            return S_WhCode;
        }

        public void setS_WhCode(String s_WhCode) {
            S_WhCode = s_WhCode;
        }

        public String getS_InvName_AC() {
            return S_InvName_AC;
        }

        public void setS_InvName_AC(String s_InvName_AC) {
            S_InvName_AC = s_InvName_AC;
        }

        public String getS_InvVersion_AC() {
            return S_InvVersion_AC;
        }

        public void setS_InvVersion_AC(String s_InvVersion_AC) {
            S_InvVersion_AC = s_InvVersion_AC;
        }

        public String getS_ApplicationArea() {
            return S_ApplicationArea;
        }

        public void setS_ApplicationArea(String s_ApplicationArea) {
            S_ApplicationArea = s_ApplicationArea;
        }

        public String getS_ApplicationProject() {
            return S_ApplicationProject;
        }

        public void setS_ApplicationProject(String s_ApplicationProject) {
            S_ApplicationProject = s_ApplicationProject;
        }

        public String getS_UseQty() {
            return S_UseQty;
        }

        public void setS_UseQty(String s_UseQty) {
            S_UseQty = s_UseQty;
        }

        public String getS_UsePrice() {
            return S_UsePrice;
        }

        public void setS_UsePrice(String s_UsePrice) {
            S_UsePrice = s_UsePrice;
        }

        String S_InvVersion;
        String S_Qty;
        String S_Batch;
        String S_WhCode;
        String S_InvName_AC;//实际需求产品型号
        String S_InvVersion_AC;
        String S_ApplicationArea;
        String S_ApplicationProject;
        String S_UseQty;
        String S_UsePrice;
        String S_Memo1;



        public String getS_Memo1() {
            return S_Memo1;
        }

        public void setS_Memo1(String s_Memo1) {
            S_Memo1 = s_Memo1;
        }

        public String getS_Memo2() {
            return S_Memo2;
        }

        public void setS_Memo2(String s_Memo2) {
            S_Memo2 = s_Memo2;
        }

        public String getS_Memo3() {
            return S_Memo3;
        }

        public void setS_Memo3(String s_Memo3) {
            S_Memo3 = s_Memo3;
        }

        String S_Memo2;
        String S_Memo3;


        public Product() {
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.S_InvDefine1);
            dest.writeString(this.S_InvName);
            dest.writeString(this.S_InvVersion);
            dest.writeString(this.S_Qty);
            dest.writeString(this.S_Batch);
            dest.writeString(this.S_WhCode);
            dest.writeString(this.S_InvName_AC);
            dest.writeString(this.S_InvVersion_AC);
            dest.writeString(this.S_ApplicationArea);
            dest.writeString(this.S_ApplicationProject);
            dest.writeString(this.S_UseQty);
            dest.writeString(this.S_UsePrice);
            dest.writeString(this.S_Memo1);
            dest.writeString(this.S_Memo2);
            dest.writeString(this.S_Memo3);
        }

        protected Product(Parcel in) {
            this.S_InvDefine1 = in.readString();
            this.S_InvName = in.readString();
            this.S_InvVersion = in.readString();
            this.S_Qty = in.readString();
            this.S_Batch = in.readString();
            this.S_WhCode = in.readString();
            this.S_InvName_AC = in.readString();
            this.S_InvVersion_AC = in.readString();
            this.S_ApplicationArea = in.readString();
            this.S_ApplicationProject = in.readString();
            this.S_UseQty = in.readString();
            this.S_UsePrice = in.readString();
            this.S_Memo1 = in.readString();
            this.S_Memo2 = in.readString();
            this.S_Memo3 = in.readString();
        }

        public static final Creator<Product> CREATOR = new Creator<Product>() {
            @Override
            public Product createFromParcel(Parcel source) {
                return new Product(source);
            }

            @Override
            public Product[] newArray(int size) {
                return new Product[size];
            }
        };
    }


    public SampleApplicationBean() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.S_Code);
        dest.writeString(this.S_Maker);
        dest.writeString(this.S_State);
        dest.writeString(this.S_Id);
        dest.writeString(this.P_Id);
        dest.writeString(this.S_Maker_Id);
        dest.writeString(this.S_SaleMan);
        dest.writeString(this.S_DepName);
        dest.writeInt(this.S_SaleMan_Id);
        dest.writeString(this.R_RecordCompany);
        dest.writeInt(this.R_Id);
        dest.writeString(this.S_ContactPerson);
        dest.writeString(this.S_ContactPhone);
        dest.writeString(this.S_ContactMail);
        dest.writeString(this.S_ContactAddress);
        dest.writeString(this.S_AppType);
        dest.writeString(this.R_MemberAgents);
        dest.writeString(this.S_Attachment01);
        dest.writeString(this.S_Attachment02);
        dest.writeString(this.S_Attachment03);
        dest.writeString(this.S_Attachment04);
        dest.writeString(this.S_Attachment05);
        dest.writeString(this.S_ContactPerson_M);
        dest.writeString(this.S_ContactPhone_M);
        dest.writeString(this.S_ContactAddress_M);
        dest.writeString(this.S_ExpressCompany);
        dest.writeString(this.S_ExpressNumber);
        dest.writeString(this.S_Memo);
        dest.writeString(this.S_Feedback);
        dest.writeTypedList(this.J_SampleDetails);
    }

    protected SampleApplicationBean(Parcel in) {
        this.S_Code = in.readString();
        this.S_Maker = in.readString();
        this.S_State = in.readString();
        this.S_Id = in.readString();
        this.P_Id = in.readString();
        this.S_Maker_Id = in.readString();
        this.S_SaleMan = in.readString();
        this.S_DepName = in.readString();
        this.S_SaleMan_Id = in.readInt();
        this.R_RecordCompany = in.readString();
        this.R_Id = in.readInt();
        this.S_ContactPerson = in.readString();
        this.S_ContactPhone = in.readString();
        this.S_ContactMail = in.readString();
        this.S_ContactAddress = in.readString();
        this.S_AppType = in.readString();
        this.R_MemberAgents = in.readString();
        this.S_Attachment01 = in.readString();
        this.S_Attachment02 = in.readString();
        this.S_Attachment03 = in.readString();
        this.S_Attachment04 = in.readString();
        this.S_Attachment05 = in.readString();
        this.S_ContactPerson_M = in.readString();
        this.S_ContactPhone_M = in.readString();
        this.S_ContactAddress_M = in.readString();
        this.S_ExpressCompany = in.readString();
        this.S_ExpressNumber = in.readString();
        this.S_Memo = in.readString();
        this.S_Feedback = in.readString();
        this.J_SampleDetails = in.createTypedArrayList(Product.CREATOR);
    }

    public static final Creator<SampleApplicationBean> CREATOR = new Creator<SampleApplicationBean>() {
        @Override
        public SampleApplicationBean createFromParcel(Parcel source) {
            return new SampleApplicationBean(source);
        }

        @Override
        public SampleApplicationBean[] newArray(int size) {
            return new SampleApplicationBean[size];
        }
    };
}
