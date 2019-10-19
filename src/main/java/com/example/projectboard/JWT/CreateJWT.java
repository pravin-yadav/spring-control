package com.example.projectboard.JWT;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class CreateJWT {
    public static String createToken(String email, String password) {
        Algorithm algorithm = Algorithm.HMAC256(email + ':' + password);
        String token = JWT.create()
                .sign(algorithm);

        return token;
    }

}
