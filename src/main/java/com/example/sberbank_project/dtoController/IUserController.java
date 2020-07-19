package com.example.sberbank_project.dtoController;

import simpleModel.SimpleUser;

public interface IUserController {
    SimpleUser getUserByLoginAndPassword(SimpleUser user);

    SimpleUser getActiveUser();
}
