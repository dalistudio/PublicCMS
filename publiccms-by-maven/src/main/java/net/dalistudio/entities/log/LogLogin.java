package net.dalistudio.entities.log;

// Generated 2016-1-19 11:28:06 by Hibernate Tools 4.3.1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.wangdali.common.source.entity.MyColumn;

/**
 * LogLogin generated by hbm2java
 */
@Entity
@Table(name = "log_login")
public class LogLogin implements java.io.Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @MyColumn(title = "ID")
    private Long id;
    @MyColumn(title = "站点", condition = true)
    private int siteId;
    @MyColumn(title = "用户名", condition = true, like = true)
    private String name;
    @MyColumn(title = "用户", condition = true)
    private Long userId;
    @MyColumn(title = "IP", condition = true, like = true)
    private String ip;
    @MyColumn(title = "登陆渠道", condition = true)
    private String channel;
    @MyColumn(title = "登录结果", condition = true)
    private boolean result;
    @MyColumn(title = "登录日期", condition = true, order = true)
    private Date createDate;
    @MyColumn(title = "错误密码")
    private String errorPassword;

    public LogLogin() {
    }

    public LogLogin(int siteId, String name, String ip, String channel, boolean result, Date createDate) {
        this.siteId = siteId;
        this.name = name;
        this.ip = ip;
        this.channel = channel;
        this.result = result;
        this.createDate = createDate;
    }

    public LogLogin(int siteId, String name, Long userId, String ip, String channel, boolean result, Date createDate,
            String errorPassword) {
        this.siteId = siteId;
        this.name = name;
        this.userId = userId;
        this.ip = ip;
        this.channel = channel;
        this.result = result;
        this.createDate = createDate;
        this.errorPassword = errorPassword;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "site_id", nullable = false)
    public int getSiteId() {
        return this.siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "user_id")
    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "ip", nullable = false, length = 64)
    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Column(name = "channel", nullable = false, length = 50)
    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    @Column(name = "result", nullable = false)
    public boolean isResult() {
        return this.result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false, length = 19)
    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(name = "error_password", length = 100)
    public String getErrorPassword() {
        return this.errorPassword;
    }

    public void setErrorPassword(String errorPassword) {
        this.errorPassword = errorPassword;
    }

}
