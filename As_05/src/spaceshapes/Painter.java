package spaceshapes;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.ImageObserver;

/** 
 * Interface to represent a type that offers primitive drawing methods.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public interface Painter {
	/**
	 * Draws a rectangle. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawRect(int x, int y, int width, int height);
	
	/**
	 * Draws an oval. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawOval(int x, int y, int width, int height);
	
	/**
	 * Draws a line. Parameters x1 and y1 specify the starting point of the 
	 * line, parameters x2 and y2 the ending point.
	 */
	public void drawLine(int x1, int y1, int x2, int y2);
	

	/**
	 * Draws a filled rectangle
	 * @param x x position
	 * @param y y position
	 * @param width width of the rectangle
	 * @param height height of the rectangle
	 */
	public void fillRetangle(int x, int y, int width, int height );
	
	/**
	 * Get the current colour of the shape
	 * @return 
	 */
	public Color getColor();
	
	/**
	 * Set the colour of a shape
	 * @param colour colour to set.
	 */
	public void setColor(Color colour);
	
	/**
	 * Draws a string of text at the middle of the shape
	 */
	public void drawCentredText(String text, int x, int y,int height, int width);
	
	/**
	 * Translate the x and y to be the new origin.

	 */
	public void translate(int x, int y);

	public void drawImage(Image _picture, int _x, int _y, int _width, int _height, ImageObserver observer);
	
}
