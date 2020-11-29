package cn.iotat.consumer.faced.request.model;


import cn.iotat.consumer.faced.request.BaseRequest;

/**
 * 此处类名不一样只是为了与生产者区分
 */
public class ConsumerItemAddRequest extends BaseRequest {
    private static final long serialVersionUID = -6381056365713572846L;
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
