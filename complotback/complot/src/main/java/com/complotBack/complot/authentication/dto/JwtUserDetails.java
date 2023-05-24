package com.complotBack.complot.authentication.dto;

import com.complotBack.complot.models.UserApp;

public class JwtUserDetails extends UserApp {

	public final Long id;

    public JwtUserDetails(final Long id, final String username, final String login, final String hash) {
        super(username,login, hash);
        this.id = id;
    }

}