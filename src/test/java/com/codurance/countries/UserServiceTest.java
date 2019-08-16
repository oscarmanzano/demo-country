package com.codurance.countries;

import com.codurance.countries.domain.MyUser;
import com.codurance.countries.infrastructure.UserRepository;
import com.codurance.countries.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Mock
    UserRepository userRepositoryMock;

    @Test
    public void validate_user(){

        MyUser user = new MyUser("oscar", "manzano");

        userService = new UserService(userRepositoryMock);

        when(userRepositoryMock.save(user)).thenReturn(user);

        user = userService.validate_user(user);

        assertNotNull(user);
    }
}
