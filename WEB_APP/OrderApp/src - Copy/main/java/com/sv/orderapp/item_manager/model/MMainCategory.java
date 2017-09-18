package com.sv.orderapp.item_manager.model;
// Generated May 30, 2016 4:12:41 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MMainCategory generated by hbm2java
 */
@Entity(name = "com.sv.orderapp.item_manager.model.MMainCategory")
@Table(name = "m_main_category")
public class MMainCategory implements java.io.Serializable {

    private Integer indexNo;
    private int version;
    private int department;
    private String name;

    public MMainCategory() {
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "index_no", unique = true, nullable = false)
    public Integer getIndexNo() {
        return this.indexNo;
    }

    public void setIndexNo(Integer indexNo) {
        this.indexNo = indexNo;
    }

    @Column(name = "version", nullable = false)
    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Column(name = "department", nullable = false)
    public int getDepartment() {
        return this.department;
    }

    public void setDepartment(int MDepartment) {
        this.department = MDepartment;
    }

    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}