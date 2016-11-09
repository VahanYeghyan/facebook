package com.tiko.facebook.entity.oauthrefreshtoken;

import com.tiko.facebook.entity.AbstractDomainEntityModel;

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
}
