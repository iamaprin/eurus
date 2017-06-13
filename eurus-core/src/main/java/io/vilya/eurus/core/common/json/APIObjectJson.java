package io.vilya.eurus.core.common.json;

import java.io.Serializable;

/**
 * @author iamaprin
 * @time 2017年6月13日 下午10:52:12
 */
@SuppressWarnings("serial")
public class APIObjectJson<T extends Serializable> extends APIRespJson {
    
    private T data;
    
    public APIObjectJson(T data) {
        this.setData(data);
    }

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }
    
}
