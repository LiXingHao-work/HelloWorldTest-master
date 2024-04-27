package com.lxh.HelloWorld.filter;

import com.lxh.HelloWorld.exception.Code;
import com.lxh.HelloWorld.dao.vo.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Component
@Slf4j
@RequiredArgsConstructor
public class ResponseHelper {
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public Mono<Void> response(Code code, ServerWebExchange exchange) {
        byte[] bytes = objectMapper.writeValueAsString(Result.error(code))
                .getBytes(StandardCharsets.UTF_8);
        ServerHttpResponse response = exchange.getResponse();
        DataBuffer wrap = response.bufferFactory().wrap(bytes);
        response.getHeaders().add("Content-Type", "application/json");
        return response.writeWith(Flux.just(wrap));
    }
}
