package wb;

public class OptionShape {
	
	private static int chosenOption = 0;
	
	private static int drawPoint = 1;
	private static int drawLine  = 2;
	private static int drawRect  = 3;
	private static int drawCircle= 4;
	private static int drawDonut = 5;
	
	
	public static int getChosenShape() {
		return chosenOption;
	}
	public static void setChosenShape(int chosenOption) {
		OptionShape.chosenOption = chosenOption;
	}
	
	public static int getDrawPoint() {
		return drawPoint;
	}
	public static int getDrawLine() {
		return drawLine;
	}
	public static int getDrawRect() {
		return drawRect;
	}
	public static int getDrawCircle() {
		return drawCircle;
	}
	public static int getDrawDonut() {
		return drawDonut;
	}
}
