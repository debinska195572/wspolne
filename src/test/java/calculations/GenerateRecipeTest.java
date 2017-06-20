package calculations;

/**
 * Created by olami on 20.06.2017.
 */

import databaseManager.HibernateUtil;
import databaseManager.User;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;



@RunWith(MockitoJUnitRunner.class)
public class GenerateRecipeTest {

    @Mock
    User user;

    @Mock
    Session session;


    GenerateRecipe generateRecipe;

    @Before
    public void setUp(){

        user = new User("login", "password", 20, 170, 60, false, true, "NORMALNA", "K");
        session = HibernateUtil.getSessionFactory().openSession();
        generateRecipe = new GenerateRecipe(user,session);
    }

    @After
    public void end(){
        session.close();
    }


    @Test
    public void dinnerGenereteTest(){

        String result = (generateRecipe.getRecipe(1900,"OBIAD"));

        assertThat(result, containsString("OBIAD"));

    }


    @Test
    public void genereteCaloriesTest(){
        float minCalories=NeedCalories.minCalories(user.getGender(), user.getWeight(), user.getHeight(), user.getAge());
        String recipe ="";
        int calories = 0;

        recipe += generateRecipe.getRecipe(minCalories,"SNIADANIE");
        calories +=generateRecipe.getObliczoneKalorie();
        recipe += generateRecipe.getRecipe(minCalories, "PRZEKASKA");
        calories +=generateRecipe.getObliczoneKalorie();
        recipe += generateRecipe.getRecipe(minCalories,"KOLACJA");
        calories +=generateRecipe.getObliczoneKalorie();
        recipe += generateRecipe.getRecipe(minCalories, "DESER");
        calories +=generateRecipe.getObliczoneKalorie();
        recipe += generateRecipe.getRecipe(minCalories,"OBIAD");
        calories +=generateRecipe.getObliczoneKalorie();

        assertTrue("To much calories", calories < minCalories);

    }


    @Test
    public void genereteAllMeal(){
        float minCalories=NeedCalories.minCalories(user.getGender(), user.getWeight(), user.getHeight(), user.getAge());
        String recipe ="";


        recipe += generateRecipe.getRecipe(minCalories,"SNIADANIE");
        recipe += generateRecipe.getRecipe(minCalories, "PRZEKASKA");
        recipe += generateRecipe.getRecipe(minCalories,"KOLACJA");
        recipe += generateRecipe.getRecipe(minCalories, "DESER");
        recipe += generateRecipe.getRecipe(minCalories,"OBIAD");

        assertThat(recipe, both(containsString("SNIADANIE"))
                .and(containsString("PRZEKASKA"))
                .and(containsString("KOLACJA"))
                .and(containsString("DESER"))
                .and(containsString("OBIAD")));


    }




}
