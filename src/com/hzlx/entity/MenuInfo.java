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
public class MenuInfo{
    private Integer id;
    private String title;
    private String icon;
    private String href;
    private Integer pId;
    private Date createTime;
    private Integer status;
}
