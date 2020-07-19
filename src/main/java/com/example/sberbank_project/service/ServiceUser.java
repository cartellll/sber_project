package com.example.sberbank_project.service;


import EntityConverters.UserMapper;
import com.example.sberbank_project.model.User;
import com.example.sberbank_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simpleModel.SimpleUser;

@Service
public class ServiceUser implements IServiceUser {

    @Autowired
    private UserRepository repositoryUser;

    @Override
    public SimpleUser getUserByLoginAndPassword(String login, String password) {
        User user = null;
        for (User tempUser : repositoryUser.findAll()) {
            if (tempUser.getLogin().equals(login) && tempUser.getPassword().equals(password)) {
                user = tempUser;
                break;
            }
        }
        return UserMapper.INSTANCE.toDTO(user);
    }
}