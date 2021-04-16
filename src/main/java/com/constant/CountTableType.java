package com.constant;

public enum CountTableType {

//    {"airport_outin", "airport_terminal", "airport_airelinetype", "airport_bagtype", "airport_errbag",
//            "company_outin", "company_airelinetype", "company_bagtype", "company_errbag"};
    AIRPORT_OUTIN("airport_outin", "机场_进离岗"),
    AIRPORT_TERMINAL("airport_terminal","机场_航站楼"),
    AIRPORT_AIRELINETYPE  ("airport_airelinetype","机场_航线类型(国际/国内)"),
    AIRPORT_BAGTYPE  ("airport_bagtype","机场_行李类型(超重/超标...)"),
    AIRPORT_ERRBAG  ("airport_errbag","机场_异常行李"),
    COMPANY_OUTIN ("company_outin","航司_进离港"),
    COMPANY_AIRELINETYPE  ("company_airelinetype","航司_航线类型(国际/国内)"),
    COMPANY_BAGTYPE  ("company_bagtype","航司_行李类型(超重/超标...)"),
    COMPANY_ERRBAG  ("company_errbag","航司_异常行李"),
    ;


    private String code;

    private String value;

    CountTableType(String code, String value) {
        this.code = code;
        this.value = value;
    }


    public static String getCode(String code) {
        CountTableType[] types = values();
        for (CountTableType type : types) {
            if (type.code().equals(code)) {
                return type.code();
            }
        }
        return null;
    }

    public static String getValue(String code) {
        CountTableType[] types = values();
        for (CountTableType type : types) {
            if (type.code().equals(code)) {
                return type.value();
            }
        }
        return null;
    }

    public String code() {
        return code;
    }

    public String value() {
        return value;
    }



}