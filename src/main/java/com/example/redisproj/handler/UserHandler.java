package com.example.redisproj.handler;

import com.example.redisproj.dto.UserRequestDto;
import com.example.redisproj.entity.User;
import com.example.redisproj.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserHandler {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private RedisTemplate<Long, Object> redisTemplate;

    public UserRequestDto createUser(UserRequestDto userRequestDto) {
        try {
            User user = new User();
            user.setFname(userRequestDto.getFname());
            user.setLname(userRequestDto.getLname());
            user.setName(userRequestDto.getFname() + " " + userRequestDto.getLname());
            User userres = userRepository.save(user);
            UserRequestDto userResult = new UserRequestDto();
            userResult.setId(userres.getId());
            userResult.setLname(userres.getLname());
            userResult.setFname(userres.getFname());

            redisTemplate.opsForValue().set(userResult.getId(), userResult);
            return userResult;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public UserRequestDto getUser(Long id) {

        if (redisTemplate.hasKey(id)) {
            return (UserRequestDto) redisTemplate.opsForValue().get(id);
        }
        User user = userRepository.getReferenceById(id);
        UserRequestDto userResult = new UserRequestDto();
        userResult.setId(user.getId());
        userResult.setLname(user.getLname());
        userResult.setFname(user.getFname());
        return userResult;
    }
}
