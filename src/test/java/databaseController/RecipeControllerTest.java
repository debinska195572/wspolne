package databaseController;

import databaseManager.HibernateUtil;
import databaseManager.RecipeIngredient;
import databaseManager.User;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by olami on 21.06.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class RecipeControllerTest {


    @Mock
    Session session;

    private String recipeName = "nazwaPrzepisu";
    private String recipeType = "OBIAD";
    private User owner;
    private String content ="przepis";

    @Mock
    AccountController ac;

    RecipeController recipeController;

    @Before
    public void setUp(){


        session = HibernateUtil.getSessionFactory().openSession();
        recipeController = new RecipeController(session);
        ac = new AccountController(session);


    }

    @After
    public void end(){
        session.close();
    }



    @Test
    public void changeRecipeTest(){


        owner = ac.getUser("user1");

        session.beginTransaction();

        try {
            recipeController.addRecipe(recipeName,recipeType,owner,content);

            assertEquals("Typ sie nie zgadza", recipeType, recipeController.getRecipe(recipeName).getRecipeType());

           session.beginTransaction();
            String newRecipType = "SNIADANIE";
            recipeController.changeRecipe(recipeController.getRecipe(recipeName),recipeName,newRecipType,content);
            assertNotEquals("Typ sie nie zgadza", recipeType, recipeController.getRecipe(recipeName).getRecipeType());

            session.beginTransaction();
            recipeController.deleteRecipe(recipeController.getRecipe(recipeName));

            assertEquals("Przepis sie nie usunal", null, recipeController.getRecipe(recipeName));
        } catch (DishTypeException e) {
            e.printStackTrace();
        }


    }




}
