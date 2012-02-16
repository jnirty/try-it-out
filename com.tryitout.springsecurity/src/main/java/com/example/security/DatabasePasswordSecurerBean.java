package com.example.security;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.authentication.encoding.PasswordEncoder;

public class DatabasePasswordSecurerBean extends JdbcDaoSupport {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private Logger logger = Logger.getLogger(DatabasePasswordSecurerBean.class);
	
	public void secureDatabase(){
		getJdbcTemplate().query("select username,password from users",new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				String username = rs.getString(1);
				String password = rs.getString(2);
				String encodedPassword = passwordEncoder.encodePassword(password, null );
				getJdbcTemplate().update("update users set password = ? where username = ?", encodedPassword, username);
				logger.debug("updated password for username "  + username + " old/new: " + password + "/" + encodedPassword );
			}
		});
	}
}
