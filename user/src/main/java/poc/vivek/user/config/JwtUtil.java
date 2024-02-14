package poc.vivek.user.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .claim("id", "1")
                .setExpiration(new Date(System.currentTimeMillis() + 864_000_000))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();
    }
}