package com.example.springsecuritypractice.service;

import com.example.springsecuritypractice.dto.JoinDTO;
import com.example.springsecuritypractice.entity.UserEntity;
import com.example.springsecuritypractice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(JoinDTO joinDTO){

        //db에 이미 동일한 username을 가진 사람이 있는지 존재하는지?

        UserEntity data = new UserEntity();

        data.setUsername(joinDTO.getUsername());
        data.setPassword(bCryptPasswordEncoder.encode(joinDTO.getPassword()));
        data.setRole("ROLE_USER");

        userRepository.save(data);

    }
}
