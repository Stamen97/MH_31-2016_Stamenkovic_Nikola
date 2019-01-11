package geometry;

import java.awt.Color;
import java.awt.Graphics;

import wb.FrmDrawing;

public class Rectangle extends Shape{
	private Point upperLeft;
	private int width;
	private int height;
		
	public Rectangle() {
		
	}
	
	public Rectangle(Point upperLeft, int width, int height) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(Point upperLeft, int width, int height, boolean selected) {
		this(upperLeft, width, height);
		this.selected = selected;
	}
	
	public Rectangle(Point upperLeft, int width, int height, Color shpColor) {
		this(upperLeft, width, height);
		this.shpColor = shpColor;
	}

	@Override
	public void moveBy(int byX, int byY) {
		upperLeft.moveBy(byX, byY);
		
	}

	@Override
	public void moveTo(int x, int y) {
		upperLeft.moveTo(x, y);
		
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			return (int)(this.area() - ((Rectangle)o).area());
		}
		return 0;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(shpColor);
		g.drawRect(upperLeft.getX(), upperLeft.getY(), width, height);
		if (selected) {
			g.setColor(Color.blue);
			g.drawRect(upperLeft.getX() - 2, upperLeft.getY() - 2, 4, 4);
			g.drawRect(upperLeft.getX() + width - 2, upperLeft.getY() - 2, 4, 4);
			g.drawRect(upperLeft.getX() - 2, upperLeft.getY() + height - 2, 4, 4);
			g.drawRect(upperLeft.getX() + width  - 2, upperLeft.getY() + height - 2, 4, 4);
		}
	}

	
	public boolean contains(int x, int y) {
		return (upperLeft.getX() < x && x < (upperLeft.getX() + width) && upperLeft.getY() < y && y < (upperLeft.getY()+height));
	}
	
	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}
	
	@Override
	public String toString() {
		return "Upper left point: " + upperLeft + ", width = " + width + ", height = " + height;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Rectangle) {
			Rectangle temp = (Rectangle)obj;
			return (upperLeft.equals(temp.upperLeft) && (width == temp.width) && (height == temp.height));
		}
		
		return false;
	}
	
	public int area() {
		return width * height;
	}
	
	public Point getUpperLeft() {
		return upperLeft;
	}
	
	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		if(width>0)
			this.width = width;
		else this.width = 0;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		if(height>0)
			this.height = height;
		else this.height = 0;
	}

}
