package com.example.storescontrol.bean;

import java.util.List;

public class ModelBean {


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

        private String cInvCode;
        private String cWhCode;
        private String cWhName;
        private String cPosCode;
        private String cInvName;
        private String cInvStd;
        private String cInvAddCode;
        private String cBatch;
        private String cBatchProperty2;
        private String dMdate;
        private String iQuantity;
        public void setCInvCode(String cInvCode) {
            this.cInvCode = cInvCode;
        }
        public String getCInvCode() {
            return cInvCode;
        }

        public void setCWhCode(String cWhCode) {
            this.cWhCode = cWhCode;
        }
        public String getCWhCode() {
            return cWhCode;
        }

        public void setCWhName(String cWhName) {
            this.cWhName = cWhName;
        }
        public String getCWhName() {
            return cWhName;
        }

        public void setCPosCode(String cPosCode) {
            this.cPosCode = cPosCode;
        }
        public String getCPosCode() {
            return cPosCode;
        }

        public void setCInvName(String cInvName) {
            this.cInvName = cInvName;
        }
        public String getCInvName() {
            return cInvName;
        }

        public void setCInvStd(String cInvStd) {
            this.cInvStd = cInvStd;
        }
        public String getCInvStd() {
            return cInvStd;
        }

        public void setCInvAddCode(String cInvAddCode) {
            this.cInvAddCode = cInvAddCode;
        }
        public String getCInvAddCode() {
            return cInvAddCode;
        }

        public void setCBatch(String cBatch) {
            this.cBatch = cBatch;
        }
        public String getCBatch() {
            return cBatch;
        }

        public void setCBatchProperty2(String cBatchProperty2) {
            this.cBatchProperty2 = cBatchProperty2;
        }
        public String getCBatchProperty2() {
            return cBatchProperty2;
        }

        public void setDMdate(String dMdate) {
            this.dMdate = dMdate;
        }
        public String getDMdate() {
            return dMdate;
        }

        public void setIQuantity(String iQuantity) {
            this.iQuantity = iQuantity;
        }
        public String getIQuantity() {
            return iQuantity;
        }

    }

}
