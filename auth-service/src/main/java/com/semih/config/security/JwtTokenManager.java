package com.semih.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class JwtTokenManager {
    /**
     * 1- Create JWT
     * 2- Validate JWT
     */
    public Optional<String> createToken(Long id) {
        String token = null;
        String secretKey = "~sXVvAEdk0:{lfP*tsX3,Km|3}%*`jsOujHxC&3M;kubyC'ohsfvN3j]MFg_`S:";
        try {
            /**
             * Do not put sensitive information such as passwords in JWT.Like password, email, etc.
             */
            token = JWT.create()
                    .withAudience()
                    .withClaim("id", id)
                    .withIssuer("semih")
                    .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60*5))
                    .withIssuedAt(new Date())
                    .sign(Algorithm.HMAC256(secretKey));
            return Optional.of(token);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public boolean validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("~sXVvAEdk0:{lfP*tsX3,Km|3}%*`jsOujHxC&3M;kubyC'ohsfvN3j]MFg_`S:");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("semih")
                    .build();
            DecodedJWT decode = verifier.verify(token);
            if (decode == null)
                return false;
        } catch (Exception e) {
            return false;
        }
        return true;

    }

    public Optional<Long> getUserId(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("~sXVvAEdk0:{lfP*tsX3,Km|3}%*`jsOujHxC&3M;kubyC'ohsfvN3j]MFg_`S:");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("semih")
                    .build();
            DecodedJWT decode = verifier.verify(token);
            if (decode == null)
                return Optional.empty();
            return Optional.of(decode.getClaim("id").asLong());
        } catch (Exception e) {
            return Optional.empty();
        }
    }


}
