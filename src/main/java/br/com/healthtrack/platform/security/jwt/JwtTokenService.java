package br.com.healthtrack.platform.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class JwtTokenService {

    private final Logger logger = Logger.getLogger(JwtTokenService.class.toString());

    private String rawBase64Secret = "eTBuMUU5cW5mYWdrUUk2aGN1MGhNckdDYUNJM09mamQxODkyaigqU0oqKEF4YTk4c2owaWs5czA5YQ==";

    private long expireTime = 60 * 60 * 1000;

    private Key buildKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(rawBase64Secret));
    }

    public String createToken(String userIdentity) {
        Date issuedDate = new Date();
        Date expirationDate = new Date(issuedDate.getTime() + expireTime);

        return Jwts
                .builder()
                .setIssuedAt(issuedDate)
                .setExpiration(expirationDate)
                .setSubject(userIdentity)
                .signWith(buildKey())
                .compact();
    }

    public Optional<Claims> retrieveClaims(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(buildKey()).build()
                    .parseClaimsJws(token);

            return Optional.of(claimsJws.getBody());
        } catch (JwtException ex) {
            logger.log(Level.INFO, ex.getLocalizedMessage());
            return Optional.empty();
        }
    }
}