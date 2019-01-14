package geometry;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

import wb.DlgDrawCircle;
import wb.DlgDrawDonut;
import wb.DlgDrawRectangle;
import wb.FrmDrawing;
import wb.OptionAction;
import wb.OptionShape;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PnlDrawing extends JPanel {
	
	private boolean allowLine = false;
	private int pomX;
	private int pomY;
	private static int lastIndex=-1;
	
	private ArrayList<Shape> shapes = new ArrayList<Shape>();

	/**
	 * Create the panel.
	 */
	public PnlDrawing() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				if(OptionAction.getChosenAction() == OptionAction.getActionDraw()) { //ako je crtanje
					
					if(OptionShape.getChosenShape() == OptionShape.getDrawPoint()) { //ako je tacka
						Shape s1 = new Point(me.getX(), me.getY(), FrmDrawing.getShapeColor());
						shapes.add(s1);
					}
					
					else if(OptionShape.getChosenShape() == OptionShape.getDrawLine()) { //ako je linija
						if (allowLine == false) {
							pomX = me.getX();
							pomY = me.getY();
							allowLine = true;
						} else {
							Shape s1 = new Line(new Point(pomX, pomY), new Point(me.getX(), me.getY()), FrmDrawing.getShapeColor());
							shapes.add(s1);
							allowLine = false;
						}
					}
					
					else if(OptionShape.getChosenShape() == OptionShape.getDrawRect()) { //ako je pravougaonik
						DlgDrawRectangle dlgRectangle = new DlgDrawRectangle();
						dlgRectangle.setVisible(true);
						if(dlgRectangle.isAllowedToDraw()) {
							Shape s1 = new Rectangle(new Point(me.getX(),me.getY()), dlgRectangle.getRectWidth(), dlgRectangle.getRectHeight(), FrmDrawing.getShapeColor());
							shapes.add(s1);
						}
					}
					
					else if(OptionShape.getChosenShape() == OptionShape.getDrawCircle()) { //ako je krug
						DlgDrawCircle dlgCircle = new DlgDrawCircle();
						dlgCircle.setVisible(true);
						if(dlgCircle.isAllowedToDraw()) {
							Shape s1 = new Circle(new Point(me.getX(),me.getY()), dlgCircle.getRadius(), FrmDrawing.getShapeColor());
							shapes.add(s1);
						}
					}
					
					else if(OptionShape.getChosenShape() == OptionShape.getDrawDonut()) { //ako je krug sa rupom
						DlgDrawDonut dlgDonut = new DlgDrawDonut();
						dlgDonut.setVisible(true);
						if(dlgDonut.isAllowedToDraw()) {
							Shape s1 = new Donut(new Point(me.getX(),me.getY()), dlgDonut.getRadius(), dlgDonut.getInnerR(), FrmDrawing.getShapeColor());
							shapes.add(s1);
						}
					}
				}
				
				else if(OptionAction.getChosenAction() == OptionAction.getActionSelect()) { //selekcija
					lastIndex = -1;
					shapes.forEach((a) -> {
						a.setSelected(false);
						if(a.contains(me.getX(), me.getY())) {
							lastIndex = shapes.indexOf(a);
						}
					});
					if(lastIndex >= 0) {
						shapes.get(lastIndex).setSelected(true);
					}
				}
				repaint();
			}
		});
		

	}

	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("PnlDrawing");
		frame.setSize(800, 600);
		PnlDrawing PnlDrawing = new PnlDrawing();
		frame.getContentPane().add(PnlDrawing);
		frame.setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Shape> it = shapes.iterator();
		while(it.hasNext()) {
			Shape temp = it.next();
			temp.draw(g);
		}
	}

	public static int getLastIndex() {
		return lastIndex;
	}

	public static void setLastIndex(int lastIndex) {
		PnlDrawing.lastIndex = lastIndex;
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}
}
