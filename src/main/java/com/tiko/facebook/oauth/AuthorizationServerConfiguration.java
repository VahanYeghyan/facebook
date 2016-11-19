package com.tiko.facebook.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * User: Vazgen Danielyan
 * Date: 11/19/16
 * Time: 6:20 PM
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private UserApprovalHandler userApprovalHandler;

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {

        clients.inMemory()
                .withClient("353b302c44574f565045687e534e7d6a")
                .secret("286924697e615a672a646a493545646c")
                .authorizedGrantTypes("password", "refresh_token")
                .authorities("ROLE_ANDROID")
                .scopes("read", "write", "trust")
                .accessTokenValiditySeconds(172800)
                .refreshTokenValiditySeconds(864000)
                .and()
                .withClient("353b302c44574f565045687e534e7d6a")
                .secret("286924697e615a672a646a493545646c")
                .authorizedGrantTypes("password", "refresh_token")
                .authorities("ROLE_IOS")
                .scopes("read", "write", "trust")
                .accessTokenValiditySeconds(172800)
                .refreshTokenValiditySeconds(864000);
    }

    @Override
    public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(tokenStore)
                .userApprovalHandler(userApprovalHandler)
                .authenticationManager(authenticationManager);
    }

    @Override
    public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        final String REALM = "MY_OAUTH_REALM";
        oauthServer.realm(REALM + "/client");
    }

}