package com.example.storescontrol.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;


/**
 * Copyright 2018 bejson.com
 */

/**
 * Auto-generated: 2018-11-16 11:20:42
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class LoginBean implements Parcelable {

    private String Resultcode;
    private String ResultMessage;
    private String usercode;
    private String username;
    private String acccode;
    private String accname;

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    private String totalCount;
    public String getVersionNumber() {
        return VersionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        VersionNumber = versionNumber;
    }

    private String VersionNumber;
    private List<User> data=new ArrayList<>();
    public void setResultcode(String Resultcode) {
        this.Resultcode = Resultcode;
    }
    public String getResultcode() {
        return Resultcode;
    }

    public void setResultMessage(String ResultMessage) {
        this.ResultMessage = ResultMessage;
    }
    public String getResultMessage() {
        return ResultMessage;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }
    public String getUsercode() {
        return usercode;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setAcccode(String acccode) {
        this.acccode = acccode;
    }
    public String getAcccode() {
        return acccode;
    }

    public void setAccname(String accname) {
        this.accname = accname;
    }
    public String getAccname() {
        return accname;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
    public List<User> getData() {
        return data;
    }
    public static class User implements Parcelable {

        private String menucode;
        private String menuname;

        public String getVoucherCount() {
            return VoucherCount;
        }

        public void setVoucherCount(String voucherCount) {
            VoucherCount = voucherCount;
        }

        private String VoucherCount;
        public void setMenucode(String menucode) {
            this.menucode = menucode;
        }
        public String getMenucode() {
            return menucode;
        }

        public void setMenuname(String menuname) {
            this.menuname = menuname;
        }
        public String getMenuname() {
            return menuname;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.menucode);
            dest.writeString(this.menuname);
            dest.writeString(this.VoucherCount);
        }

        public User() {
        }

        protected User(Parcel in) {
            this.menucode = in.readString();
            this.menuname = in.readString();
            this.VoucherCount = in.readString();
        }

        public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
            @Override
            public User createFromParcel(Parcel source) {
                return new User(source);
            }

            @Override
            public User[] newArray(int size) {
                return new User[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Resultcode);
        dest.writeString(this.ResultMessage);
        dest.writeString(this.usercode);
        dest.writeString(this.username);
        dest.writeString(this.acccode);
        dest.writeString(this.accname);
        dest.writeString(this.totalCount);
        dest.writeString(this.VersionNumber);
        dest.writeTypedList(this.data);
    }

    public LoginBean() {
    }

    protected LoginBean(Parcel in) {
        this.Resultcode = in.readString();
        this.ResultMessage = in.readString();
        this.usercode = in.readString();
        this.username = in.readString();
        this.acccode = in.readString();
        this.accname = in.readString();
        this.totalCount = in.readString();
        this.VersionNumber = in.readString();
        this.data = in.createTypedArrayList(User.CREATOR);
    }

    public static final Parcelable.Creator<LoginBean> CREATOR = new Parcelable.Creator<LoginBean>() {
        @Override
        public LoginBean createFromParcel(Parcel source) {
            return new LoginBean(source);
        }

        @Override
        public LoginBean[] newArray(int size) {
            return new LoginBean[size];
        }
    };
}

