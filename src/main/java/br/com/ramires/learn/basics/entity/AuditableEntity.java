package br.com.ramires.learn.basics.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

/**
 * Basic class for Audit , all entities that required audit , necessary extends
 * this class.
 * 
 * @author feliperamires
 * @date 26,Out 2020
 */
@Getter
@Setter
@Audited
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableEntity {

    @Transient
    @Column(name = "CREATED_AT")
    private Date createdAt;

    @Column(name = "UPDATED_AT")
    private Date updatedAt;

    @PrePersist
    public void onPrePersist() {
	updatedAt = new Date();
    }

    @PreUpdate
    public void onPreUpdate() {
	updatedAt = new Date();
    }
}