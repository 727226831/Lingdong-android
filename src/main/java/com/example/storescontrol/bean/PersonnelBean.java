package com.example.storescontrol.bean;

import java.util.List;

public class PersonnelBean {


        private String Resultcode;
        private String ResultMessage;
        private List<Data> data;
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

        public void setData(List<Data> data) {
            this.data = data;
        }
        public List<Data> getData() {
            return data;
        }

    public class Data {

        private int A_Id;
        private String A_UserName;
        private String A_Password;
        private String A_RoleId;
        private boolean A_State;
        private String A_CompanyName;
        private String A_Name;
        private String A_Number;
        private String A_Department;
        private String A_Remark;
        private int A_LoginCount;
        private String A_LoginTime;
        private String A_LoginIp;
        private String A_EmailAddress;
        private String A_Phone;
        private String A_Region;
        private String A_Position;
        public void setA_Id(int A_Id) {
            this.A_Id = A_Id;
        }
        public int getA_Id() {
            return A_Id;
        }

        public void setA_UserName(String A_UserName) {
            this.A_UserName = A_UserName;
        }
        public String getA_UserName() {
            return A_UserName;
        }

        public void setA_Password(String A_Password) {
            this.A_Password = A_Password;
        }
        public String getA_Password() {
            return A_Password;
        }

        public void setA_RoleId(String A_RoleId) {
            this.A_RoleId = A_RoleId;
        }
        public String getA_RoleId() {
            return A_RoleId;
        }

        public void setA_State(boolean A_State) {
            this.A_State = A_State;
        }
        public boolean getA_State() {
            return A_State;
        }

        public void setA_CompanyName(String A_CompanyName) {
            this.A_CompanyName = A_CompanyName;
        }
        public String getA_CompanyName() {
            return A_CompanyName;
        }

        public void setA_Name(String A_Name) {
            this.A_Name = A_Name;
        }
        public String getA_Name() {
            return A_Name;
        }

        public void setA_Number(String A_Number) {
            this.A_Number = A_Number;
        }
        public String getA_Number() {
            return A_Number;
        }

        public void setA_Department(String A_Department) {
            this.A_Department = A_Department;
        }
        public String getA_Department() {
            return A_Department;
        }

        public void setA_Remark(String A_Remark) {
            this.A_Remark = A_Remark;
        }
        public String getA_Remark() {
            return A_Remark;
        }

        public void setA_LoginCount(int A_LoginCount) {
            this.A_LoginCount = A_LoginCount;
        }
        public int getA_LoginCount() {
            return A_LoginCount;
        }

        public void setA_LoginTime(String A_LoginTime) {
            this.A_LoginTime = A_LoginTime;
        }
        public String getA_LoginTime() {
            return A_LoginTime;
        }

        public void setA_LoginIp(String A_LoginIp) {
            this.A_LoginIp = A_LoginIp;
        }
        public String getA_LoginIp() {
            return A_LoginIp;
        }

        public void setA_EmailAddress(String A_EmailAddress) {
            this.A_EmailAddress = A_EmailAddress;
        }
        public String getA_EmailAddress() {
            return A_EmailAddress;
        }

        public void setA_Phone(String A_Phone) {
            this.A_Phone = A_Phone;
        }
        public String getA_Phone() {
            return A_Phone;
        }

        public void setA_Region(String A_Region) {
            this.A_Region = A_Region;
        }
        public String getA_Region() {
            return A_Region;
        }

        public void setA_Position(String A_Position) {
            this.A_Position = A_Position;
        }
        public String getA_Position() {
            return A_Position;
        }

    }




}
