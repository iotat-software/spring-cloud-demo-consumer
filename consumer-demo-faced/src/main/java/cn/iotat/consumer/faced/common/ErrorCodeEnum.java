package cn.iotat.consumer.faced.common;

public enum ErrorCodeEnum {
    //=========== 参数错误(1xxx) ===========
    /**
     * 必填参数没有填写
     */
    HAVE_NO_ID("1000","param 'id' is required"),
    //=========== 内部错误(2xxx) ===========

    //=========== 网络错误(3xxx) ===========

    //=========== 业务错误(4xxx) ===========
    /**
     * 由于开关关闭导致访问失败
     */
    SWITCH_OFF("4000","switch is off")
    ;

    ErrorCodeEnum(String errCode, String errMsg) {
        this.errMsg = errMsg;
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    private String errMsg;

    private String errCode;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"errMsg\":\"")
                .append(errMsg).append('\"');
        sb.append(",\"errCode\":")
                .append(errCode);
        sb.append('}');
        return sb.toString();
    }
}
