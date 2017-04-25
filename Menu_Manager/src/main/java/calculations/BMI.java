/**
 * 
 */
package calculations;

/**
 * @author Marcin
 *
 */
public final class BMI {

	public static float getBmi(float height, float weight) // in centimeters, in kg
	{
		height = height / 100;
		height *= height;
		float justBmi=weight/height;
		return justBmi;
		 
	}
	        
	public static String getObesityInfo(float bmi) 
	{ 
		if(bmi<18.5)
			return "Niedowaga";
		else if (bmi>=18.5 && bmi<25) {
			return "Prawidłowa waga ciała";
		}
		else if(bmi>=25 && bmi<30) {
			return "Nadwaga bez otyłości";
		}
		else if (bmi>=30 && bmi<35) {
			return "Pierwzy stopień otyłości";
		}
		else if (bmi>=35 && bmi<40) {
			return "Drugi stopień otyłości";
		}
		else return "Otyłość ekstremalna";
		
	}
	
	
}
