package com.tiko.facebook.entity.oauthrefreshtoken;

import com.tiko.facebook.entity.AbstractDomainEntityModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * User: Vazgen Danielyan
 * Date: 11/9/16
 * Time: 9:13 PM
 */
@Entity
@Table(name = "oauth_refresh_token")
@SequenceGenerator(name = "sequence_generator", sequenceName = "oauth_refresh_token_seq")
public class OauthRefreshToken extends AbstractDomainEntityModel {

    private static final long serialVersionUID = 2426951233375687528L;


    /*Properties*/
    @Column(name = "token_id")
    private String tokenId;

    @Column(name = "token")
    private byte[] token;

    @Column(name = "authentication")
    private byte[] authentication;


    /*Getters and setters*/
    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(final String tokenId) {
        this.tokenId = tokenId;
    }

    public byte[] getToken() {
        return token;
    }

    public void setToken(final byte[] token) {
        this.token = token;
    }

    public byte[] getAuthentication() {
        return authentication;
    }

    public void setAuthentication(final byte[] authentication) {
        this.authentication = authentication;
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
        final OauthRefreshToken rhs = (OauthRefreshToken) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(this.getTokenId(), rhs.getTokenId())
                .append(this.getToken(), rhs.getToken())
                .append(this.getAuthentication(), rhs.getAuthentication())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(getTokenId())
                .append(getToken())
                .append(getAuthentication())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("tokenId", getTokenId())
                .append("token", getToken())
                .append("authentication", getAuthentication())
                .toString();
    }
}
