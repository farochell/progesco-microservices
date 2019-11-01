package com.progesco.pedagogy.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 *
 */

public class Helpers {

    /**
     *
     * @param request
     * @param role
     * @param jwtSecret
     * @return
     */
    public static Boolean hasRole(HttpServletRequest request, String role, String jwtSecret) {
        String[] tempArray;
        String bearerToken = request.getHeader("Authorization");
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(bearerToken.substring(7, bearerToken.length()))
                .getBody();
        String roles = (String) claims.get("scopes");
        tempArray = roles.split(",");

        return Arrays.asList(tempArray).contains(role);
    }
}
