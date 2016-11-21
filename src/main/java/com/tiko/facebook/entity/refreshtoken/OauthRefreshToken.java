package com.tiko.facebook.entity.refreshtoken;

import com.tiko.facebook.entity.accesstoken.OauthAccessToken;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: Vazgen Danielyan
 * Date: 11/20/16
 * Time: 10:58 PM
 */
@Entity
@Table(name = "oauth_refresh_token")
public class OauthRefreshToken implements Serializable {

    private static final long serialVersionUID = 632759132130413163L;

    /*Properties*/
    @Id
    @Column(name = "token_id")
    private String tokenId;

    @Column(name = "token")
    private byte[] token;

    @Column(name = "authentication")
    private byte[] authentication;

/*
    @OneToOne(mappedBy = "refreshToken", fetch = FetchType.LAZY)
    private OauthAccessToken oauthAccessToken;
*/

    /*Getters and setter*/
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
/*

    public OauthAccessToken getOauthAccessToken() {
        return oauthAccessToken;
    }

    public void setOauthAccessToken(final OauthAccessToken oauthAccessToken) {
        this.oauthAccessToken = oauthAccessToken;
    }
*/


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
                .append(this.getTokenId(), rhs.getTokenId())
                .append(this.getToken(), rhs.getToken())
                .append(this.getAuthentication(), rhs.getAuthentication())
//                .append(this.getOauthAccessToken(), rhs.getOauthAccessToken())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getTokenId())
                .append(getToken())
                .append(getAuthentication())
//                .append(getOauthAccessToken())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("tokenId", getTokenId())
                .append("token", getToken())
                .append("authentication", getAuthentication())
//                .append("oauthAccessToken", getOauthAccessToken())
                .toString();
    }
}
