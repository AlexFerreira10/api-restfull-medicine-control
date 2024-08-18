package com.alexferreira10.demo.config;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.alexferreira10.demo.model.entities.user.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

@Service
public class TokenService {
//Token = assinatura digital
	
	@Value("${api.security.token.secret}")
	private String secret; //Created in the properties
	
	public String generateToken(User user) {
		try {
		    var algorithm = Algorithm.HMAC256(secret);
		    return JWT.create()
		        .withIssuer("Medicines_API")
		        .withSubject(user.getUsername())
		        .withExpiresAt(expirationTime())
		        .sign(algorithm);
		} catch (JWTCreationException exception){
		    throw new RuntimeException("Error generate token", exception);
		}
	}

	public String generateSubject(String tokenJWT) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm)
					// specify any specific claim validations
					.withIssuer("Medicines_API")
					// reusable verifier instance
					.build()
					.verify(tokenJWT)
					.getSubject();
		} catch (JWTVerificationException exception){
			throw new RuntimeException("Invalid or expired JWT token");
		}
	}
	
	public Instant expirationTime() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
}