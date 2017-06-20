package databaseController;

import databaseManager.HibernateUtil;
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
 * Created by olami on 21.06.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class IngredientControllerTest {

    @Mock
    Session session;

    String ingredientName ="nazwa";
    boolean lactose = true;
    boolean gluten =true ;
    int calories =200;
    boolean meat = true;


    IngredientController ingredientController;

    @Before
    public void setUp(){


        session = HibernateUtil.getSessionFactory().openSession();
        ingredientController = new IngredientController(session);
    }

    @After
    public void end(){
        session.close();
    }


    @Test
    public void changeIngregient(){
        session.beginTransaction();
        ingredientController.addIngredient(ingredientName,lactose,gluten,calories,meat);

        assertEquals("Skladnik sie nie zgadza", calories, ingredientController.getIngredient(ingredientName).getCalories());

        session.beginTransaction();
        int newCaloriess = 400;
        ingredientController.changeIngredient(ingredientController.getIngredient(ingredientName),lactose,gluten,newCaloriess,meat);

        assertNotEquals("Skladnik sie nie zgadza", calories, ingredientController.getIngredient(ingredientName).getCalories());

        session.beginTransaction();
        ingredientController.deleteIngredient(ingredientController.getIngredient(ingredientName));

        assertEquals("Skladnik sie nie usunal", null, ingredientController.getIngredient(ingredientName));

    }



}
