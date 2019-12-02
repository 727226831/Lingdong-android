package com.example.storescontrol.bean;

import java.util.List;

public class AgmentBean {


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

        private String M_MSN;

        public String getcInvDefine1() {
            return cInvDefine1;
        }

        public void setcInvDefine1(String cInvDefine1) {
            this.cInvDefine1 = cInvDefine1;
        }

        private String cInvDefine1;

        public String getcDefine30() {
            return cDefine30;
        }

        public void setcDefine30(String cDefine30) {
            this.cDefine30 = cDefine30;
        }

        private String cDefine30;
        public void setM_MSN(String M_MSN) {
            this.M_MSN = M_MSN;
        }
        public String getM_MSN() {
            return M_MSN;
        }

    }

}
