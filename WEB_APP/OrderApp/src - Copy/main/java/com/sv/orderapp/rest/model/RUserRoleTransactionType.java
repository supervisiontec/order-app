package com.sv.orderapp.rest.model;
// Generated May 30, 2016 4:14:04 AM by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RUserRoleTransactionType generated by hbm2java
 */
@Entity
@Table(name="r_user_role_transaction_type"
    ,catalog="estoke"
)
public class RUserRoleTransactionType  implements java.io.Serializable {


     private RUserRoleTransactionTypeId id;
     private MUserRole MUserRole;

    public RUserRoleTransactionType() {
    }

    public RUserRoleTransactionType(RUserRoleTransactionTypeId id, MUserRole MUserRole) {
       this.id = id;
       this.MUserRole = MUserRole;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="userRole", column=@Column(name="user_role", nullable=false, length=10) ), 
        @AttributeOverride(name="transactionType", column=@Column(name="transaction_type", nullable=false, length=10) ) } )
    public RUserRoleTransactionTypeId getId() {
        return this.id;
    }
    
    public void setId(RUserRoleTransactionTypeId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_role", nullable=false, insertable=false, updatable=false)
    public MUserRole getMUserRole() {
        return this.MUserRole;
    }
    
    public void setMUserRole(MUserRole MUserRole) {
        this.MUserRole = MUserRole;
    }




}


