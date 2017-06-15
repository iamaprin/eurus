package io.vilya.eurus.core.bean;

import java.io.Serializable;
import java.util.Date;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author iamaprin
 * @time 2017年6月13日 下午10:04:29
 */
@XmlRootElement
@SuppressWarnings("serial")
public class AccountResp implements Serializable{
    @FormParam("id")
    private Integer id;
    
    @FormParam("username")
    private String accUsername;
    
    @FormParam("password")
    private String accPassword;
    
    @FormParam("token")
    private String token;
    
    private Date createTime;
    
    private Date updateTime;
    
    @FormParam("isDeleted")
    private Boolean isDeleted;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the accUsername
     */
    public String getAccUsername() {
        return accUsername;
    }

    /**
     * @param accUsername the accUsername to set
     */
    public void setAccUsername(String accUsername) {
        this.accUsername = accUsername;
    }

    /**
     * @return the accPassword
     */
    public String getAccPassword() {
        return accPassword;
    }

    /**
     * @param accPassword the accPassword to set
     */
    public void setAccPassword(String accPassword) {
        this.accPassword = accPassword;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime the updateTime to set
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return the isDeleted
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted the isDeleted to set
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
