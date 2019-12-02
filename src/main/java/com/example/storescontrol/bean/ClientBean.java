package com.example.storescontrol.bean;

import java.util.List;

public class ClientBean {


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

        private int R_Id;

        public String getR_RecordDate() {
            return R_RecordDate;
        }

        public void setR_RecordDate(String r_RecordDate) {
            R_RecordDate = r_RecordDate;
        }

        public String getR_Update() {
            return R_Update;
        }

        public void setR_Update(String r_Update) {
            R_Update = r_Update;
        }

        public String getR_LastUpdate() {
            return R_LastUpdate;
        }

        public void setR_LastUpdate(String r_LastUpdate) {
            R_LastUpdate = r_LastUpdate;
        }

        private String R_RecordDate;
        private String R_RecordCompany;
        private String R_RecordType;
        private String R_RecordCompanyId;
        private String R_ContactPerson;
        private String R_Position;
        private String R_Tel;
        private String R_Address;
        private String R_Update;
        private int R_Mid;
        private int R_Status;
        private String R_CompanyWebsite;
        private String R_Email;
        private String R_Reason;

        private String R_ProjectDesc;
        private int R_Week_1;
        private int R_Week_2;
        private int R_Week_3;
        private int R_Week_4;
        private String R_Month_1;
        private String R_Month_2;
        private String R_Month_3;
        private String R_LastUpdate;
        private String R_Region;
        private String R_ApplicationArea;
        public void setR_Id(int R_Id) {
            this.R_Id = R_Id;
        }
        public int getR_Id() {
            return R_Id;
        }



        public void setR_RecordCompany(String R_RecordCompany) {
            this.R_RecordCompany = R_RecordCompany;
        }
        public String getR_RecordCompany() {
            return R_RecordCompany;
        }

        public void setR_RecordType(String R_RecordType) {
            this.R_RecordType = R_RecordType;
        }
        public String getR_RecordType() {
            return R_RecordType;
        }

        public void setR_RecordCompanyId(String R_RecordCompanyId) {
            this.R_RecordCompanyId = R_RecordCompanyId;
        }
        public String getR_RecordCompanyId() {
            return R_RecordCompanyId;
        }

        public void setR_ContactPerson(String R_ContactPerson) {
            this.R_ContactPerson = R_ContactPerson;
        }
        public String getR_ContactPerson() {
            return R_ContactPerson;
        }

        public void setR_Position(String R_Position) {
            this.R_Position = R_Position;
        }
        public String getR_Position() {
            return R_Position;
        }

        public void setR_Tel(String R_Tel) {
            this.R_Tel = R_Tel;
        }
        public String getR_Tel() {
            return R_Tel;
        }

        public void setR_Address(String R_Address) {
            this.R_Address = R_Address;
        }
        public String getR_Address() {
            return R_Address;
        }



        public void setR_Mid(int R_Mid) {
            this.R_Mid = R_Mid;
        }
        public int getR_Mid() {
            return R_Mid;
        }

        public void setR_Status(int R_Status) {
            this.R_Status = R_Status;
        }
        public int getR_Status() {
            return R_Status;
        }

        public void setR_CompanyWebsite(String R_CompanyWebsite) {
            this.R_CompanyWebsite = R_CompanyWebsite;
        }
        public String getR_CompanyWebsite() {
            return R_CompanyWebsite;
        }

        public void setR_Email(String R_Email) {
            this.R_Email = R_Email;
        }
        public String getR_Email() {
            return R_Email;
        }

        public void setR_Reason(String R_Reason) {
            this.R_Reason = R_Reason;
        }
        public String getR_Reason() {
            return R_Reason;
        }



        public void setR_ProjectDesc(String R_ProjectDesc) {
            this.R_ProjectDesc = R_ProjectDesc;
        }
        public String getR_ProjectDesc() {
            return R_ProjectDesc;
        }

        public void setR_Week_1(int R_Week_1) {
            this.R_Week_1 = R_Week_1;
        }
        public int getR_Week_1() {
            return R_Week_1;
        }

        public void setR_Week_2(int R_Week_2) {
            this.R_Week_2 = R_Week_2;
        }
        public int getR_Week_2() {
            return R_Week_2;
        }

        public void setR_Week_3(int R_Week_3) {
            this.R_Week_3 = R_Week_3;
        }
        public int getR_Week_3() {
            return R_Week_3;
        }

        public void setR_Week_4(int R_Week_4) {
            this.R_Week_4 = R_Week_4;
        }
        public int getR_Week_4() {
            return R_Week_4;
        }

        public void setR_Month_1(String R_Month_1) {
            this.R_Month_1 = R_Month_1;
        }
        public String getR_Month_1() {
            return R_Month_1;
        }

        public void setR_Month_2(String R_Month_2) {
            this.R_Month_2 = R_Month_2;
        }
        public String getR_Month_2() {
            return R_Month_2;
        }

        public void setR_Month_3(String R_Month_3) {
            this.R_Month_3 = R_Month_3;
        }
        public String getR_Month_3() {
            return R_Month_3;
        }



        public void setR_Region(String R_Region) {
            this.R_Region = R_Region;
        }
        public String getR_Region() {
            return R_Region;
        }

        public void setR_ApplicationArea(String R_ApplicationArea) {
            this.R_ApplicationArea = R_ApplicationArea;
        }
        public String getR_ApplicationArea() {
            return R_ApplicationArea;
        }

    }

}
