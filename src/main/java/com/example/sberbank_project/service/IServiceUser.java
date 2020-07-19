package com.example.sberbank_project.service;

import simpleModel.SimpleUser;

public interface IServiceUser {
    SimpleUser getUserByLoginAndPassword(String login, String password);
}