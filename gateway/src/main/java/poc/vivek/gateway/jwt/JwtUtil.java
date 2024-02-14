package poc.vivek.gateway.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    private Key key;

    public Key getKey() {
        if (key == null) {
            this.key = Keys.hmacShaKeyFor(secret.getBytes());
        }
        return key;
    }

    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .claim("id", "1")
                .setExpiration(new Date(System.currentTimeMillis() + 864_000_000))
                .signWith(getKey())
                .compact();
    }

    private boolean isTokenExpired(String token) {
        return this.getAllClaimsFromToken(token).getExpiration().before(new Date());
    }

    public boolean isInvalid(String token) {
        return this.isTokenExpired(token);
    }

}