package com.example.sberbank_project.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import simpleModel.SimpleUser;

import static org.junit.jupiter.api.Assertions.*;

class IServiceUserTest {

    private ServiceUser serviceUser;
    @Test
    void getUserByLoginAndPassword() {
        SimpleUser user = serviceUser.getUserByLoginAndPassword("cartel","111");
        //Assert.assertThat(user).
    }
}