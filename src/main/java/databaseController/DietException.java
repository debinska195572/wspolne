package databaseController;

public class DietException extends Exception{
	  public DietException() {
	  System.out.println("Zla dieta. Dieta powinna być WEGETARIANSKA lub NORMALNA");
	  }
	  
	  public DietException(String message) {
		  System.out.println("Zla dieta. Podana dieta: "+message+" Dieta powinna być WEGETARIANSKA lub NORMALNA");
		  }
	}
	
