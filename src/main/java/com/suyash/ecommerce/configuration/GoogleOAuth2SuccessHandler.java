package com.suyash.ecommerce.configuration;

import com.suyash.ecommerce.model.Role;
import com.suyash.ecommerce.model.User;
import com.suyash.ecommerce.repository.RoleRepository;
import com.suyash.ecommerce.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GoogleOAuth2SuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {
        OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;

        String email = oAuth2AuthenticationToken
                .getPrincipal()
                .getAttributes()
                .get("email")
                .toString();

        if (!userRepository.findUserByEmail(email).isPresent()) {
            User user = new User();

            user.setFirstName(oAuth2AuthenticationToken.getPrincipal().getAttributes().get("given_name").toString());
            user.setLastName(oAuth2AuthenticationToken.getPrincipal().getAttributes().get("family_name").toString());
            user.setEmail(email);

            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findById(2L).get());
            user.setRoles(roles);

            userRepository.save(user);
        }
        redirectStrategy.sendRedirect(request, response, "/");
    }

}
