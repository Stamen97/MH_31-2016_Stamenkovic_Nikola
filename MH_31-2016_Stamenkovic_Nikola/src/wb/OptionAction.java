package wb;

public class OptionAction {
	
	private static int chosenAction = 0;
	
	private static int actionDraw = 1;
	private static int actionSelect = 2;
	private static int actionModify = 3;
	private static int actionDelete = 4;
	
	public static int getChosenAction() {
		return chosenAction;
	}
	
	public static void setChosenAction(int action) {
		OptionAction.chosenAction = action;
	}

	public static int getActionDraw() {
		return actionDraw;
	}

	public static int getActionSelect() {
		return actionSelect;
	}

	public static int getActionModify() {
		return actionModify;
	}

	public static int getActionDelete() {
		return actionDelete;
	}
	
}
