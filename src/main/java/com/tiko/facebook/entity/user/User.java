package com.tiko.facebook.entity.user;

import com.tiko.facebook.entity.AbstractDomainEntityModel;
import com.tiko.facebook.entity.authority.Authority;

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


}
