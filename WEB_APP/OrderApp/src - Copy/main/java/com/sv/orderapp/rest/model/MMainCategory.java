package com.sv.orderapp.rest.model;
// Generated May 30, 2016 4:14:04 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * MMainCategory generated by hbm2java
 */
@Entity
@Table(name="m_main_category"
    ,catalog="estoke"
)
public class MMainCategory  implements java.io.Serializable {


     private Integer indexNo;
     private int version;
     private MDepartment MDepartment;
     private String name;
     private Set<MItem> MItems = new HashSet<MItem>(0);
     private Set<MSubCategory> MSubCategories = new HashSet<MSubCategory>(0);

    public MMainCategory() {
    }

	
    public MMainCategory(MDepartment MDepartment, String name) {
        this.MDepartment = MDepartment;
        this.name = name;
    }
    public MMainCategory(MDepartment MDepartment, String name, Set<MItem> MItems, Set<MSubCategory> MSubCategories) {
       this.MDepartment = MDepartment;
       this.name = name;
       this.MItems = MItems;
       this.MSubCategories = MSubCategories;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="index_no", unique=true, nullable=false)
    public Integer getIndexNo() {
        return this.indexNo;
    }
    
    public void setIndexNo(Integer indexNo) {
        this.indexNo = indexNo;
    }

    @Version
    @Column(name="version", nullable=false)
    public int getVersion() {
        return this.version;
    }
    
    public void setVersion(int version) {
        this.version = version;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="department", nullable=false)
    public MDepartment getMDepartment() {
        return this.MDepartment;
    }
    
    public void setMDepartment(MDepartment MDepartment) {
        this.MDepartment = MDepartment;
    }

    
    @Column(name="name", nullable=false, length=50)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="MMainCategory")
    public Set<MItem> getMItems() {
        return this.MItems;
    }
    
    public void setMItems(Set<MItem> MItems) {
        this.MItems = MItems;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="MMainCategory")
    public Set<MSubCategory> getMSubCategories() {
        return this.MSubCategories;
    }
    
    public void setMSubCategories(Set<MSubCategory> MSubCategories) {
        this.MSubCategories = MSubCategories;
    }




}


