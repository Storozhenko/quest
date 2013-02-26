package com.sam.quest.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="users")
public class Users implements Serializable, UserDetails {
    private static final long serialVersionUID = -3357675102403861567L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="user_type")
    private String userType;
    @Column(name="user_lang")
    private String userLang;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userId")
    private Set<Forms> forms;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userId")
    private Set<AnswForms> answForms;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserLang() {
        return userLang;
    }

    public void setUserLang(String userLang) {
        this.userLang = userLang;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Forms> getForms() {
        return forms;
    }

    public void setForms(Set<Forms> forms) {
        this.forms = forms;
    }

    public Set<AnswForms> getAnswForms() {
        return answForms;
    }

    public void setAnswForms(Set<AnswForms> answForms) {
        this.answForms = answForms;
    }


    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        final String role = getUserType();
        GrantedAuthority grandAuthority = new GrantedAuthority() {
            private static final long serialVersionUID = -1824766736699440960L;

            public String getAuthority() {
                return role;
            }
        };
        authorities.add(grandAuthority);
        return authorities;
    }
}
