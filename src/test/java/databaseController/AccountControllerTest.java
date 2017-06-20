package databaseController;


import databaseManager.HibernateUtil;
import databaseManager.User;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by olami on 20.06.2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {


    @Mock
    Session session;

    String login = "login";
    String haslo = "haslo";



    AccountController accountController;

    @Before
    public void setUp(){


        session = HibernateUtil.getSessionFactory().openSession();
        accountController = new AccountController(session);
    }

    @After
    public void end(){
        session.close();
    }

    @Test
    public void createDeleteUserTest(){

        session.beginTransaction();
        accountController.createUser(login,haslo);

       assertEquals("Haslo nie pasuje",haslo, accountController.getUser(login).getPassword());
        session.beginTransaction();
        accountController.deleteUser(accountController.getUser(login));

        assertEquals("obiekt nie jest nullem",null, accountController.getUser(login));


    }


    @Test
    public void changePassword(){

        session.beginTransaction();
        accountController.createUser(login,haslo);

        String nowehaslo= "nowe_haslo";
        session.beginTransaction();
        accountController.changePssword(accountController.getUser(login),nowehaslo);

        assertNotEquals("Haslo pasuje a nie powinoo", haslo, accountController.getUser(login).getPassword());
        session.beginTransaction();
        accountController.deleteUser(accountController.getUser(login));



    }


}
