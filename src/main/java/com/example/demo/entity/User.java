package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash(value = "UserActivityStatus", timeToLive = 60L)
@Getter
@AllArgsConstructor
public class User implements Serializable {
    @Id
    private Integer userID;
    private boolean status;
}
