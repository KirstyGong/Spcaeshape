package spaceshapes;

/**
 * Class to represent a simple Dynamic space-shape.
 * 
 */

import java.awt.Color;

public class DynamicRectangleShape extends Shape {

	private wallDirection bounce;
	private boolean fill=false;
	private Color _color;
	private Color _defaultColor=new Color(212, 212, 212);

	/**
	 * Creates a DynamicShape object with default values for instance variables.
	 */
	public DynamicRectangleShape() {
		super();
	}
	
	/**
	 * Creates a DynamicShape object with default values for instance variables and color.
	 */
	public DynamicRectangleShape(Color color) {
		_color=color;
	}

	/**
	 * Creates a DynamicShape instance with specified values for instance variables
	 * @param x x position
	 * @param y y position
	 */
	public DynamicRectangleShape(int x, int y, Color color) {
		super(x,y);
		_color=color;
	}

	/**
	 * Creates a DynamicShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * 
	 */
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, Color color) {
		super(x,y,deltaX,deltaY);
		_color = color;
	}

	/**
	 * Creates a DynamicShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal 
	 *        axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical 
	 *        axis.
	 * @param width width in pixels.
	 * @param height height in pixels.
	 */
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, Color color) {
		super(x,y,deltaX,deltaY,width,height);
		_color=color;
	}
	
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, String text,Color color) {
		super(x,y,deltaX,deltaY,width,height,text);
		_color=color;
	}
	 
	/**
	 * Moves this DynamicShape object within the specified bounds. On hitting a 
	 * boundary the Shape instance bounces off and back into the two- 
	 * dimensional world. 
	 * @param width - width of two-dimensional world.
	 * @param height - height of two-dimensional world.
	 */
	public void move(int width, int height) {
		int nextXnWitdh= _x+_deltaX+_width;
		int nextYnHeight=_y+_deltaY+_height;
		int nextX= _x+_deltaX;
		int nextY=_y + _deltaY;
		
		if(nextX<=0 || nextXnWitdh>=width) {
			bounce=wallDirection.LEFTANDRIGHT;
		}
		if(nextY <= 0||nextYnHeight>= height) {
			bounce=wallDirection.TOPANDBOTTOM;
		}
		
		super.move(width, height);
	}
	
	enum wallDirection{
		TOPANDBOTTOM,LEFTANDRIGHT, NONE
	}

	/**
	 * Paints a dynamic shape and change color when it hits the wall.
	 */
	protected void doPaint(Painter painter) {
		
		if(bounce==wallDirection.LEFTANDRIGHT){
			fill=true;
		}else if(bounce==wallDirection.TOPANDBOTTOM) {
			fill=false;
		}

		if (fill==true &&_color!= null) {
			painter.getColor();
			painter.setColor(_color);
			painter.fillRetangle(_x, _y, _width, _height); 
			painter.setColor(_defaultColor);
 
		}else {
			painter.drawRect(_x,_y,_width,_height);
		}


	}



}
