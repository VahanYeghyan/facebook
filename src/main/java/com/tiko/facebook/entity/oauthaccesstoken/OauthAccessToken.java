package com.tiko.facebook.entity.oauthaccesstoken;

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
 * Time: 9:06 PM
 */
@Entity
@Table(name = "oauth_access_token")
@SequenceGenerator(name = "sequence_generator", sequenceName = "oauth_access_token_seq")
public class OauthAccessToken extends AbstractDomainEntityModel {

    private static final long serialVersionUID = 4240086744202646810L;

    /*Properties*/
    @Column(name = "token_id")
    private String tokenId;

    @Column(name = "token")
    private byte[] token;

    @Column(name = "authentication_id")
    private String authenticationId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "authentication")
    private byte[] authentication;

    @Column(name = "refresh_token")
    private String refreshToken;


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

    public String getAuthenticationId() {
        return authenticationId;
    }

    public void setAuthenticationId(final String authenticationId) {
        this.authenticationId = authenticationId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(final String clientId) {
        this.clientId = clientId;
    }

    public byte[] getAuthentication() {
        return authentication;
    }

    public void setAuthentication(final byte[] authentication) {
        this.authentication = authentication;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(final String refreshToken) {
        this.refreshToken = refreshToken;
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
        final OauthAccessToken rhs = (OauthAccessToken) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(this.getTokenId(), rhs.getTokenId())
                .append(this.getToken(), rhs.getToken())
                .append(this.getAuthenticationId(), rhs.getAuthenticationId())
                .append(this.getUserName(), rhs.getUserName())
                .append(this.getClientId(), rhs.getClientId())
                .append(this.getAuthentication(), rhs.getAuthentication())
                .append(this.getRefreshToken(), rhs.getRefreshToken())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(getTokenId())
                .append(getToken())
                .append(getAuthenticationId())
                .append(getUserName())
                .append(getClientId())
                .append(getAuthentication())
                .append(getRefreshToken())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("tokenId", getTokenId())
                .append("token", getToken())
                .append("authenticationId", getAuthenticationId())
                .append("userName", getUserName())
                .append("clientId", getClientId())
                .append("authentication", getAuthentication())
                .append("refreshToken", getRefreshToken())
                .toString();
    }
}
