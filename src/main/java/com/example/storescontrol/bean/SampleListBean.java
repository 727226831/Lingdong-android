package com.example.storescontrol.bean;

import java.util.List;

public class SampleListBean {


        private String Resultcode;
        private String ResultMessage;
        private List<SampleApplicationBean> data;
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

        public void setData(List<SampleApplicationBean> data) {
            this.data = data;
        }
        public List<SampleApplicationBean> getData() {
            return data;
        }


}
