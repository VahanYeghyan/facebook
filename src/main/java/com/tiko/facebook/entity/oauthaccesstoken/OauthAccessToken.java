package com.tiko.facebook.entity.oauthaccesstoken;

import com.tiko.facebook.entity.AbstractDomainEntityModel;

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

}
