
package com.portfolioalmagiraudo.ap.Security.Dto;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;


public class JwtDto {
    private String token;
private String bearer = "Bearer";
private String NombreUsuario;
private Collection<? extends GrantedAuthority> authorities;

//Constructor

    public JwtDto(String token, String NombreUsuario, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.NombreUsuario = NombreUsuario;
        this.authorities = authorities;
    }
//GEtters and Setters

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
