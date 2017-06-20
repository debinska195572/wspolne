package calculations;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
/**
 * Created by olami on 20.06.2017.
 */
public class NeedCaloriesTest {


    @Test
    public void minCaloriesTest(){


        assertTrue("Men Bda Calories",NeedCalories.minCalories("M", 70, 180, 30 )>2.400);
        assertTrue("Women bad Calories",NeedCalories.minCalories("K", 70, 170, 20 )>1600);


    }
}
