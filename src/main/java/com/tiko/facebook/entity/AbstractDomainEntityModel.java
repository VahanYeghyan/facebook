package com.tiko.facebook.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * User: Vazgen Danielyan
 * LocalDateTime: 11/9/16
 * Time: 7:51 PM
 */
@MappedSuperclass
public class AbstractDomainEntityModel implements Serializable {

    private static final long serialVersionUID = 621358346200448606L;


    /*Properties*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @Column(name = "removed")
    private LocalDateTime removed;

    @Column(name = "updated", nullable = false)
    private LocalDateTime updated;


    /*Constructor*/
    public AbstractDomainEntityModel() {
        //
        setCreated(LocalDateTime.now());
        //
        setUpdated(getCreated());
    }


    /*Getters and setters*/
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(final LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getRemoved() {
        return removed;
    }

    public void setRemoved(final LocalDateTime removed) {
        this.removed = removed;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(final LocalDateTime updated) {
        this.updated = updated;
    }


    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        final AbstractDomainEntityModel rhs = (AbstractDomainEntityModel) obj;
        return new EqualsBuilder()
                .append(this.getId(), rhs.getId())
                .append(this.getCreated(), rhs.getCreated())
                .append(this.getRemoved(), rhs.getRemoved())
                .append(this.getUpdated(), rhs.getUpdated())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .append(getCreated())
                .append(getRemoved())
                .append(getUpdated())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", getId())
                .append("created", getCreated())
                .append("removed", getRemoved())
                .append("updated", getUpdated())
                .toString();
    }
}
