package com.example.demo.controller;

import com.example.demo.dto.StatusResponseDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StatusController {

    @Autowired
    UserRepository userRepository;

//    @Autowired
//    RedisTemplate redisTemplate;

    @GetMapping("/status")
    public List<StatusResponseDTO> getStatus(@RequestParam List<Integer> userID)
    {
        System.out.println(String.format("UserID List: %s",userID));

        Iterable<User> activeUserList = userRepository.findAllById(userID);

        List<StatusResponseDTO> res = new ArrayList<>();
        activeUserList.forEach(user -> res.add(StatusResponseDTO.builder().userID(user.getUserID()).isOnline(user.isStatus()).build()));

//        HashOperations hashOperations = redisTemplate.opsForHash();
//        System.out.println(hashOperations.get("1","UserActivityStatus"));;


        return res;
    }


    @PostMapping("push/status")
    public void pushStatus(@RequestParam Integer userID)
    {

        User user1 = new User(userID,true);

        userRepository.save(user1);

        System.out.println(String.format("Pushed status for user: %s",userID));
    }

}
