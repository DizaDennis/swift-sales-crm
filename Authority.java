package com.sales.swiftsalescrm.entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Authority implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String authority;
    private User user;


    @Override
    public String getAuthority() {
        return this.authority;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
