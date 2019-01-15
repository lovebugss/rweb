package com.itrjp.radmin.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ren on 2018/11/4.
 */
@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String chineseName;
    private String idcardNo;
    private String policeCode;
    private String deptCode;
    private Integer gender;
    private String email;
    private String phoneNo;
    private String duty;
    private String address;
    private String remark;
    private Integer type;
    private Integer status;
    private String deptName;
    private String ticket;
    private String gxdwdm;
    private String deptLevel;
    private String defaultDeptCode;
    private String defaultXzqhCode;
    @Column(unique = true)
    private String username;//帐号
    @JsonIgnore
    private String password; //密码;
    @JsonIgnore
    private String salt;//加密密码的盐
    private byte state;//用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
    //@ManyToMany(fetch= FetchType.EAGER)//立即从数据库中进行加载数据;
    //@JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    //private List<SysRole> roles;// 一个用户具有多个角色
    /**
     * 是否启用
     */
    private Integer enable;


    /**
     * 密码盐.重新对盐重新进行了定义，用户名+salt，这样就更加不容易被破解
     *
     * @return
     */
    public String getCredentialsSalt() {
        return this.username + this.salt;
    }
}
