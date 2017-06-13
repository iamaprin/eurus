package io.vilya.eurus.core.common.json;

import java.io.Serializable;
import java.util.List;

/**
 * @author iamaprin
 * @time 2017年6月13日 下午10:59:15
 */
@SuppressWarnings("serial")
public class APIListJson<T extends Serializable> extends APIRespJson {

    private List<T> list;

    public APIListJson(List<T> list) {
        this.setList(list);
    }

    /**
     * @return the list
     */
    public List<T> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<T> list) {
        this.list = list;
    }
}
