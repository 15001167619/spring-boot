package com.whs.beetlsql.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-23 14:02
 */
@Data
public class Parameters implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer offset;//起始数
    private Integer limit;//页面大小
    private String search;//搜索内容
    private String sort;//排序列名称
    private String order;//排序方法 ASC DESC
    private String startTime;//开始时间
    private String endTime;//结束时间
    private Integer selectBox;//下拉框

}
