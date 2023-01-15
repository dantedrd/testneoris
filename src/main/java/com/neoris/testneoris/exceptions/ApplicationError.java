package com.neoris.testneoris.exceptions;

public class ApplicationError {

    public enum ApplicationCode {
        GENERAL("G-");

         public String appCode;

        ApplicationCode(String appCode){
            this.appCode = appCode;
        }

        public String getAppCode() {
            return appCode;
        }
    }

    public enum ApplicationErrorCode {
        BUSINESS_ERROR("001", "Error de negocio");


        String code;
        String desc;

        ApplicationErrorCode(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public String getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }


}
