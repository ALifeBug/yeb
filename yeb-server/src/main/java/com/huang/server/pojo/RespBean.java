package com.huang.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
    private long code;
    private String message;
    private Object obj;

    public static RespBean success(String message){
        return new RespBean(200,message,null);
    }

    public static RespBean success(String message, Object obj){
        return new RespBean(200,message,obj);
    }

    public static RespBean error(String message){
        return new RespBean(500,message,null);
    }

    public static RespBean error(String message, Object obj){
        return new RespBean(500,message,obj);
    }
}
