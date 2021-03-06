package cn.iotat.consumer.faced.response.model;

import java.io.Serializable;

/**
 * 此处文件名不一致知识为了与生产者区分
 */
public class ItemConsumerInfo implements Serializable {

    private static final long serialVersionUID = 4801568842144562892L;
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
