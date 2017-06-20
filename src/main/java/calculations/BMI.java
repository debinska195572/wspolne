/**
 * 
 */
package calculations;

/**
 * @author Marcin
 *
 */
public final class BMI {

	static int i=0;
	public static float getBmi(float height, float weight) // in centimeters, in
															// kg
	{
		height = height / 100;
		height *= height;
		float justBmi = weight / height;
		return justBmi;

	}

	public static String getObesityInfo(float bmi) {
		if (bmi < 18.5)
		{
			i=1;return "Niedowaga";
		}
			
		else if (bmi >= 18.5 && bmi < 25) {
			i=2; return "Prawidłowa waga ciała";
		} else if (bmi >= 25 && bmi < 30) {
			i=3; return "Nadwaga bez otyłości";
		} else if (bmi >= 30 && bmi < 35) {
			i=4; return "Pierwzy stopień otyłości";
		} else if (bmi >= 35 && bmi < 40) {
			i=5; return "Drugi stopień otyłości";
		} else
			i=6; return "Otyłość ekstremalna";

	}
	
	public static String getHowMuchCalShould() {
		if(i==1) return "Ponieważ masz niedowagę musisz jeść jak najwięcej !";
		if(i==2) return "Brawo, prawidłowa waga ciała ! Jedz śmiało !";
		if(i==3) return "Lekka nadwaga, nie unikaj kalorii, ale może czas pobiegać?";
		if(i==4) return "Oj oj pierwszy stopień otyłości, ostrożnie z kaloriami, nie przekraczaj minimum !";
		if(i==5) return "Drugi stopień to poważna sprawa, ogranicz węglowodany i cukry proste, zejdż poniżej minimum kalorii";
		return "Otyłość ekstremalna, uważaj na to co jesz, powinieneś jeść jak najmniej";

	}

}
