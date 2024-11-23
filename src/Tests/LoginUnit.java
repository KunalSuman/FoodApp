package page.Tests;

import org.junit.jupiter.api.Test;
import page.server.User.SignIn;
import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginUnit {
    @Test
    public void LoginUnitTest() {
        String username = "kunal" ;
        String password = "123" ;
        int result = SignIn.signIn(username, password);
        assertEquals(result,0);
    }
}
