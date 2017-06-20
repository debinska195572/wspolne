package calculations;


import static junit.framework.Assert.assertEquals;


import org.junit.Test;


/**
 * Created by olami on 20.06.2017.
 */


public class BMITest {



    @Test
    public void getBmiTest(){

        assertEquals("Wrong BMI Normal", 19 , (int)BMI.getBmi(160,50));
        assertEquals("Wrong BMI Starvation", 12 , (int)BMI.getBmi(180,40));
        assertEquals("Wrong BMI Obesity", 35 , (int)BMI.getBmi(140,70));

    }


    @Test
    public void getObesityInfoTest(){
        float bmiNormal = 19;
        float bmiStarvation = 12;
        float bmiObesity = 35;

        assertEquals("Normal BMI", "Prawidłowa waga ciała", BMI.getObesityInfo(bmiNormal ));
        assertEquals("starvation", "Niedowaga", BMI.getObesityInfo(bmiStarvation ));
        assertEquals("obesity", "Drugi stopień otyłości", BMI.getObesityInfo(bmiObesity ));

    }


}
