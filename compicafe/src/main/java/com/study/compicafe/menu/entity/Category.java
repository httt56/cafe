package com.study.compicafe.menu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_category")
public class Category {
    @Id
    @Column(name = "category_code")
    private Integer CategoryCode;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "ref_categokry_code")
    private Integer refCategoryCode;

    public Category() {
    }

    public Category(Integer categoryCode, String categoryName, Integer refCategoryCode) {
        CategoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
    }

    public Integer getCategoryCode() {
        return CategoryCode;
    }

    public void setCategoryCode(Integer categoryCode) {
        CategoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }

    public void setRefCategoryCode(Integer refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    @Override
    public String toString() {
        return "Category{" +
                "CategoryCode=" + CategoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                '}';
    }
}
