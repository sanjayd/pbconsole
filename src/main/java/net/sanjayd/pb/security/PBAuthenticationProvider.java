package net.sanjayd.pb.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class PBAuthenticationProvider implements AuthenticationProvider {

    private Logger logger = Logger.getLogger(PBAuthenticationProvider.class);

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String username = ((String)authentication.getPrincipal()).toLowerCase();
        String password = (String) authentication.getCredentials();
        
        /* This SQL injection vulnerability is intentional. The point of the demo
         * is to teach students why it is dangerous. */
        String query = "select count(*) from users where username = '" + username
                + "' and password = '" + password + "'";
        logger.info(query);
        // String query = "select count(*) from users where username = ? and password = ?";
        if (jdbcTemplate.queryForObject(query, Integer.class) > 0) {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            return new UsernamePasswordAuthenticationToken(username,
                    password, authorities);
        } else {
            throw new BadCredentialsException("Login failed for user " + username);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}
