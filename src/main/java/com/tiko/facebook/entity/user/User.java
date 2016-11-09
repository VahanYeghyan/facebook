package com.tiko.facebook.entity.user;

import com.tiko.facebook.entity.AbstractDomainEntityModel;
import com.tiko.facebook.entity.authority.Authority;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Set;

/**
 * User: Vazgen Danielyan
 * Date: 11/9/16
 * Time: 8:41 PM
 */
@Entity
@Table(name = "users")
@SequenceGenerator(name = "sequence_generator", sequenceName = "user_seq")
public class User extends AbstractDomainEntityModel {

    private static final long serialVersionUID = 5071892070450680414L;


    /*Getters and setter*/
    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "activated")
    private Boolean activated;

    @Column(name = "activation_key")
    private String activationKey;

    @Column(name = "activation_password_key")
    private String activationPasswordKey;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Authority.class)
    @JoinTable(name = "user_authority",
            joinColumns = {
                    @JoinColumn(name = "user_id", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "authority_id", nullable = false, updatable = false)
            }
    )
    private Set<Authority> authoritySet;


    /*Getters and setters*/
    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(final Boolean activated) {
        this.activated = activated;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(final String activationKey) {
        this.activationKey = activationKey;
    }

    public String getActivationPasswordKey() {
        return activationPasswordKey;
    }

    public void setActivationPasswordKey(final String activationPasswordKey) {
        this.activationPasswordKey = activationPasswordKey;
    }

    public Set<Authority> getAuthoritySet() {
        return authoritySet;
    }

    public void setAuthoritySet(final Set<Authority> authoritySet) {
        this.authoritySet = authoritySet;
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
        final User rhs = (User) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(this.getUsername(), rhs.getUsername())
                .append(this.getEmail(), rhs.getEmail())
                .append(this.getPassword(), rhs.getPassword())
                .append(this.getActivated(), rhs.getActivated())
                .append(this.getActivationKey(), rhs.getActivationKey())
                .append(this.getActivationPasswordKey(), rhs.getActivationPasswordKey())
                .append(this.getAuthoritySet(), rhs.getAuthoritySet())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(getUsername())
                .append(getEmail())
                .append(getPassword())
                .append(getActivated())
                .append(getActivationKey())
                .append(getActivationPasswordKey())
                .append(getAuthoritySet())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("username", getUsername())
                .append("email", getEmail())
                .append("password", getPassword())
                .append("activated", getActivated())
                .append("activationKey", getActivationKey())
                .append("activationPasswordKey", getActivationPasswordKey())
                .append("authoritySet", getAuthoritySet())
                .toString();
    }
}
