package java_study.java_practice.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.Optional;
import java.util.UUID;

@Repository
public class RedisTokenRepository {

    private static final String TEMP_TOKEN_PREFIX = "tempToken";
    private static final String TEMP_TOKEN_LOOKUP_PREFIX = "tempTokenLookup";

    private final RedisTemplate<String, String> redisTemplate;

    public RedisTokenRepository(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setTempToken(String email, String token, long ttlTime) {
        String tokenKey = TEMP_TOKEN_PREFIX + email;
        String lookupKey = TEMP_TOKEN_LOOKUP_PREFIX + token;
        Duration ttl = Duration.ofSeconds(ttlTime);

        redisTemplate.opsForValue().set(tokenKey, token, ttl);
        redisTemplate.opsForValue().set(lookupKey, email, ttl);
    }

    public String getEmailByTempToken(String token) {
        String lookupKey = TEMP_TOKEN_LOOKUP_PREFIX + token;

        return redisTemplate.opsForValue().get(lookupKey);
    }

    public void deleteTempToken(String token) {
        String lookupKey = TEMP_TOKEN_LOOKUP_PREFIX + token;
        String email = redisTemplate.opsForValue().get(lookupKey);

        if (email != null) {
            redisTemplate.delete(TEMP_TOKEN_PREFIX + email);
        }

        redisTemplate.delete(lookupKey);
    }

    public String createTempToken(String email, boolean isLoginToken) {
        String existingToken = redisTemplate.opsForValue().get(TEMP_TOKEN_PREFIX + email);
        Optional.ofNullable(existingToken).ifPresent(this::deleteTempToken);

        String tempToken = UUID.randomUUID().toString();
        long ttl = isLoginToken ? 3600 : 5 * 60;
        setTempToken(email, tempToken, ttl);

        return tempToken;
    }
}
