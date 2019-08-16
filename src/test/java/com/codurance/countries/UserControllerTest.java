package com.codurance.countries;

import com.codurance.countries.controller.UserController;
import com.codurance.countries.domain.MyUser;
import com.codurance.countries.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    UserService userServiceMock;

    @Autowired
    UserController userController;

    MyUser user;

    @Before
    public void init(){
        userController = new UserController(userServiceMock);
        user = new MyUser("oscar", "manzano");
    }

    @Test
    public void validate_user(){

        when(userServiceMock.validate_user(any())).thenReturn(user);

        MyUser newuser = userController.validate_user("oscar", "manzano");

        assertNotNull(newuser);
    }

    @Transactional
    @Rollback
    @Test
    public void create_user(){

        when(userServiceMock.create_user(any())).thenReturn(user);

        MyUser newuser = userController.create_user("qwe", "rty");

        assertNotNull(newuser);
    }
}
