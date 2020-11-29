package cn.iotat.consumer.faced.request;

import java.io.Serializable;

/**
 * 基础请求参数
 * @author Pang
 */
public abstract class BaseRequest implements Serializable {

    private static final long serialVersionUID = -5926491140915744775L;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append('}');
        return sb.toString();
    }
}
