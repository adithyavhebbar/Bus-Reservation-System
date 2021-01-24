package hebbar.brs.models;

import io.jsonwebtoken.Claims;

@FunctionalInterface
public interface ClaimsResolver {
    <T> T getALlClais(Claims claims, T t);
}
