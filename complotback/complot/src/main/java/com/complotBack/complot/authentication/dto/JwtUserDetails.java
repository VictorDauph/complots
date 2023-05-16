package com.complotBack.complot.authentication.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class JwtUserDetails extends User {

	private static final long serialVersionUID = -4640069446204663456L;
	public final Long id;

    public JwtUserDetails(final Long id, final String username, final String hash,
                          final Collection<? extends GrantedAuthority> authorities) {
        super(username, hash, authorities);
        this.id = id;
    }

}