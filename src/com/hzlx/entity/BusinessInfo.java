package com.hzlx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @param
 * @return
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessInfo implements Serializable {
    private Integer id;
    private String userName;
    private String password;
    private String avatar;
    private String shopName;
    private String address;
    private String tel;
    private Date createTime;
    private Integer status;

}
