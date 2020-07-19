package com.example.sberbank_project.dtoController;

import com.example.sberbank_project.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simpleModel.SimpleUser;

@Component
public class UserController implements IUserController {

    @Autowired
    ServiceUser serviceUser;

    private SimpleUser activeUser;

    @Override
    public SimpleUser getUserByLoginAndPassword(SimpleUser user) { ;
        activeUser = serviceUser.getUserByLoginAndPassword(user.getLogin(), user.getPassword());
        if (activeUser != null) {
            return activeUser;
        }
        return null;
    }

    @Override
    public SimpleUser getActiveUser() {
        return getUserByLoginAndPassword(activeUser);
    }
}
