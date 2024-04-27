package com.lxh.HelloWorld.component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.lxh.HelloWorld.exception.Code;
import com.lxh.HelloWorld.exception.XException;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

@Component
@Slf4j
public class JWTComponent {

    //密钥
    @Value("${my.secretkey}")
    private String secretkey;
    private Algorithm algorithm;

    //组件初始化后,初始化加密算法对象,无需反复创建
    @PostConstruct
    private void init(){
        algorithm = Algorithm.HMAC256(secretkey);
    }

    /**
     * 生成token
     * @param map
     * @return
     */
    public String encode(Map<String,Object> map) {
        LocalDateTime time = LocalDateTime.now().plusMinutes(5);
        return JWT.create()
                .withPayload(map)
                .withIssuedAt(new Date())
                .withExpiresAt(Date.from(time.atZone(ZoneId.systemDefault()).toInstant()))
                .sign(algorithm);
    }

    /**
     * 解析token
     * @param token
     * @return
     */

    public Mono<DecodedJWT> decode(String token) {
        try {
            DecodedJWT decodedJWT = JWT.require(algorithm).build().verify(token);
            return Mono.just(decodedJWT);
        } catch (TokenExpiredException e) {
                Code code = Code.TOKEN_EXPIRED;
                XException x = new XException(code);
            return Mono.error(x);
        }
    }
}
