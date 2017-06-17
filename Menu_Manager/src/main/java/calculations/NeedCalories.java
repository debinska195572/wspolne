package calculations;

/**
 * @author Marcin
 *
 */
public final class NeedCalories {
	
	
	public static float minCalories(String plec, float waga, float wzrost, float wiek)
	{
		float zapotrzebowanie;
		
		if(plec.equals("M"))
		{
			zapotrzebowanie=(float) (66.47+(13.7 * waga) + 5*wzrost - 6.76 * wiek);
		}
		else
		{
			zapotrzebowanie=(float) (665.09+(9.56 * waga) + 1.85*wzrost + 4.67 - wiek);
		}
		
		
		return zapotrzebowanie;
		
	}
	
	

}
