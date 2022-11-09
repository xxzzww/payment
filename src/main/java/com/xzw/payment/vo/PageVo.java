package com.xzw.payment.vo;

import lombok.Data;
//接收前端传递的分页信息
@Data
public class PageVo {
//    页数，默认1
    private Integer pageNo = 1;
//    页码，默认10
    private Integer pageSize = 10;
}
