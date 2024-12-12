package com.rojojun.jpastudy.shop.domain;

import com.rojojun.jpastudy.shop.domain.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderSearch {
    private String memberName;
    private OrderStatus orderStatus;
}
