package com.tiko.facebook.entity.accesstoken;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * User: Vazgen Danielyan
 * Date: 11/20/16
 * Time: 10:45 PM
 */
@Entity
@Table(name = "oauth_access_token")
public class OauthAccessToken implements Serializable {

    private static final long serialVersionUID = 2538480221027920111L;

    /*Properties*/
    @Id
    @Column(name = "authentication_id")
    private String authenticationId;

    @Column(name = "token_id")
    private String tokenId;

    @Column(name = "token")
    private byte[] token;

    @Column(name = "user_name")
    private String username;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "authentication")
    private byte[] authentication;

    @Column(name = "refresh_token")
    private String refreshToken;


    /*Getters and setters*/
    public String getAuthenticationId() {
        return authenticationId;
    }

    public void setAuthenticationId(final String authenticationId) {
        this.authenticationId = authenticationId;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
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


}
