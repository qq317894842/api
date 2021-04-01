package com.constant;

public enum DementionType {
    /**
     */
    COMPANY(1, "航司"),
    /**
     */
    TERMINAL(2, "航站楼"),

    /**
     */
    OPERATOR(3, "操作员"),

    /**
     */
    RESOURCE(4, "设备"),

    /**
     */
    BAGGAGETYPE(5, "行李类型"),

    /**
     */
    BAGGAGESTATUS(6, "行李状态"),

    ;

    private Integer code;

    private String value;


    DementionType(Integer code, String value) {
        this.code = code;
        this.value = value;
    }


    public static Integer getCode(Integer code) {
        DementionType[] types = values();
        for (DementionType type : types) {
            if (type.code().equals(code)) {
                return type.code();
            }
        }
        return null;
    }

    public static String getValue(Integer code) {
        DementionType[] types = values();
        for (DementionType type : types) {
            if (type.code().equals(code)) {
                return type.value();
            }
        }
        return null;
    }

    public Integer code() {
        return code;
    }

    public String value() {
        return value;
    }


}
