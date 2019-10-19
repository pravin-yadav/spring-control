package com.example.projectboard.JWT;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class VerifyJWT {

    public static boolean tokenVerify(String email, String password, String token) {
        String filterToken = token.substring(7);
        Algorithm algorithm1 = Algorithm.HMAC256(email + ':' + password);
        JWTVerifier jwtVerifier = JWT.require(algorithm1).build();
        DecodedJWT decodedToken = jwtVerifier.verify(filterToken);
        if (token.equals("Bearer " + decodedToken.getToken())) {
            return true;
        } else {
            return false;
        }
    }
}
