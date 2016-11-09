package com.tiko.facebook.entity.authority;

import com.tiko.facebook.entity.AbstractDomainEntityModel;
import com.tiko.facebook.entity.user.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Set;

/**
 * User: Vazgen Danielyan
 * Date: 11/9/16
 * Time: 8:44 PM
 */
@Entity
@Table(name = "authority")
@SequenceGenerator(name = "sequence_generator", sequenceName = "authority_seq")
public class Authority extends AbstractDomainEntityModel {

    private static final long serialVersionUID = -5666988522474466583L;

    /*Properties*/
    @Column(name = "authority", nullable = false)
    private String authority;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = User.class, mappedBy = "authoritySet")
    private Set<User> users;


    /*Getters and setters*/
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(final String authority) {
        this.authority = authority;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(final Set<User> users) {
        this.users = users;
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
        final Authority rhs = (Authority) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(this.getAuthority(), rhs.getAuthority())
                .append(this.getUpdated(), rhs.getUpdated())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(getAuthority())
                .append(getUpdated())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("authority", getAuthority())
                .append("users", getUpdated())
                .toString();
    }
}
