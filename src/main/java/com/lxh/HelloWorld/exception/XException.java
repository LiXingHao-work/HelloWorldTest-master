package com.lxh.HelloWorld.exception;


import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class XException extends RuntimeException{
    private Code code;
    private String message;

    public XException(Code code) {
    }
}
