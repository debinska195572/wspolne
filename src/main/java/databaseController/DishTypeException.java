package databaseController;

public class DishTypeException extends Exception{
	  public DishTypeException() {
	  System.out.println("Zły typ przepisu, przepis powinien być typu: SNIADANIE, OBIAD, KOLACJA, DESER lub PRZEKASKA");
	  }
	  
	  public DishTypeException(String message) {
		  System.out.println("Zły typ przepisu. Podany typ: "+message+"\n Przepis powinien być typu: SNIADANIE, OBIAD, KOLACJA, DESER lub PRZEKASKA");
		  }
	}
	