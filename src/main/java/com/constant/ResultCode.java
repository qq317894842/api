package com.constant;

public enum ResultCode {
    ACCOUNT_CLOSURE("521", "账号已封停"),
    CAPTCHA_FREQUENT("520", "验证码发送频繁"),
    EXIST_USERNAME("519", "用户名已存在"),
    NAME_PHONE_FAILURE("513", "手机号与用户名不匹配"),
    PHONE_FAILURE("512", "手机号格式错误"),
    PWD_AGAIN_FAILURE("511", "两次密码不一致"),
    NOTFOUND_USER("510", "找不到用户"),
    NOTFOUND_FILE_FAILURE("518", "找不到文件"),
    CAPTCHA_FAILURE("509", "验证码错误"),
    PASSWORD_FAILURE("516", "密码错误"),
    CAPTCHA_EXPIRE("508", "验证码过期或无效"),
    EXIST_PHONE_FAILURE("517", "手机号已注册"),
    PASSWORD_REG_FAILURE("518", "密码格式错误，必须包含数字和字母且8位以上"),
    NOTFOUND_PHONE_FAILURE("507", "手机号未注册"),
    EXIST_BANKCARD("506", "卡号已绑定"),
    TOOMUCH_BANKCARD("505", "当前只能绑定一张"),
    INVITATION_CODE_FAILURE("504", "邀请码无效"),
    INVITATION_FAILURE("503", "邀请码格式错误"),
    LOAD_USER_FAILURE("502", "找不到用户"),
    PLEASE_LOGIN("500", "未登陆请登陆"),
    FAILURE("501", "失败"),
    SUCCESS("200", "成功"),
    NOTFOUND("404", "请求无效"),
    LOGINOUT_SUCCESS("200", "退出成功"),
    LOGIN_AUTH("500", "请先登录"),
    LOGIN_EXPIRE("500", "登陆过期"),
    LOGIN_FAILURE("514", "登陆失败"),
    LOGIN_SUCCESS("200", "登陆成功"),
    NOTBUYGOODS("200", "该用户没有购买任何矿机");
    private String code;
    private String msg;

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String toJSONString() {
        return String.format("{\"code\":\"%s\",\"msg\":\"%s\"}", code, msg);
    }
}
