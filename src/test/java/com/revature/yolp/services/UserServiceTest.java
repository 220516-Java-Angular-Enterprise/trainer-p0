package com.revature.yolp.services;

import com.revature.yolp.daos.UserDAO;
import com.revature.yolp.models.User;
import com.revature.yolp.util.custom_exceptions.InvalidUserException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService = new UserService(new UserDAO());

    @Test
    public void isDuplicateUsername_willThrowExceptionIfThereIsADupUsername() {
        /* Act */
        String username = "bduong0929";

        /* Arrange */
        boolean isTrue = userService.isNotDuplicateUsername(username);

        /* Assert */
        assertTrue(isTrue);
    }

    @Test
    public void login_willThrowExceptionIfUsernameIsEmpty() {
        /* AAA = Act, Arrange, Assert */

        /* Act */
        String username = "";
        String password = "P@ssw0rd";

        /* Arrange */

        /* Assert */
        Assert.assertThrows(InvalidUserException.class, () -> userService.login(username, password));
    }

    @Test
    public void login_willThrowExceptionIfPasswordIsEmpty() {
        /* AAA = Act, Arrange, Assert */

        /* Act */
        String username = "bduong0929";
        String password = "";

        /* Arrange */

        /* Assert */
        Assert.assertThrows(InvalidUserException.class, () -> userService.login(username, password));
    }
}