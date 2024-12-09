package com.rojojun.jpastudy.shop.domain;

import com.rojojun.jpastudy.common.BaseEntity;
import com.rojojun.jpastudy.shop.domain.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.Setter;

@Entity
public class Delivery extends BaseEntity {
    @Setter
    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
}
