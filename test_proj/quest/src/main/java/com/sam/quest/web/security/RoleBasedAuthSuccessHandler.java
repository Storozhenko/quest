package com.sam.quest.web.security;

import com.sam.quest.entity.Users;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class RoleBasedAuthSuccessHandler implements AuthenticationSuccessHandler {
    private Map<String, String> roleUrlMap;

    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        if (authentication.getPrincipal() instanceof UserDetails) {
            Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String role = user.getUserType();
            response.sendRedirect(request.getContextPath() + roleUrlMap.get(role));
        }
    }

    public void setRoleUrlMap(Map<String, String> roleUrlMap) {
        this.roleUrlMap = roleUrlMap;
    }
}