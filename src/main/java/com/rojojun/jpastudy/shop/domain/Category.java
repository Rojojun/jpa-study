package com.rojojun.jpastudy.shop.domain;

import com.rojojun.jpastudy.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Setter;
import org.springframework.data.domain.Auditable;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category extends BaseEntity {
    private String name;

    @ManyToMany
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items = new ArrayList<>();

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    // 연관관계 메서드
    private void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }
}