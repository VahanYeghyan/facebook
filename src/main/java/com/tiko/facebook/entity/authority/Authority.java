package com.tiko.facebook.entity.authority;

import com.tiko.facebook.entity.AbstractDomainEntityModel;
import com.tiko.facebook.entity.user.User;

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

    @Column(name = "authority", nullable = false)
    private String authority;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = User.class, mappedBy = "authoritySet")
    private Set<User> users;
}
