package geometry;

import java.awt.Color;
import java.awt.Graphics;

import wb.FrmDrawing;

public class Point extends Shape{
	private int x;
	private int y;
			
	public Point() {
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(int x, int y, boolean selected) {
		this(x,y);
		this.selected = selected;
	}
	
	public Point(int x, int y, Color shpColor) {
		this(x,y);
		this.shpColor = shpColor;
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Point) {
			return (int)(this.distance(0, 0) - ((Point)o).distance(0, 0));
		}
		return 0;
	}

	@Override
	public void moveBy(int byX, int byY) {
		x += byX;
		y += byY;
		
	}

	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(shpColor);
		g.drawLine(x-2, y, x+2, y);
		g.drawLine(x, y-2, x, y+2);
		if(selected) {
			g.setColor(Color.blue);
			g.drawRect(x-2, y-2, 4, 4);
		}
	}
	
	public boolean contains(int x, int y) {
		return this.distance(x, y) <= 2;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point temp = (Point)obj;
			return (this.x == temp.x && this.y == temp.y);
		}
		return false;
	}

	public double distance(int x, int y) {
		int dx = this.x - x;
		int dy = this.y - y;
		double d = Math.sqrt(dx*dx + dy*dy);
		return d;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y = x;
	}
	
	public int getY() {
		return y;
	}

}
