package spaceshapes;

/**
 * Class to represent CarrrierShape. Composite pattern is used, it allows to inherit child that
 * is from the different shape class.
 */

import java.util.ArrayList;
import java.util.List;

public class CarrierShape extends Shape {
	private List <Shape> _shapeList= new ArrayList<>();

	/**
	 * Creates a Shape object with default values for instance variables.
	 */
	public CarrierShape() {
		super();

	}

	/**
	 * Creates a Shape object with a specified x and y position.
	 */
	public CarrierShape(int x, int y) {
		super(x,y);
	}

	/**
	 * Creates a Shape instance with specified x, y, deltaX and deltaY values.
	 * The Shape object is created with a default width and height.
	 */
	public CarrierShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX, deltaY);
	}

	/**
	 * Creates a Shape instance with specified x, y, deltaX, deltaY, width and
	 * height values.
	 */
	public CarrierShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}
	
	public CarrierShape(int x, int y, int deltaX, int deltaY, int width, int height,String text) {
		super(x,y,deltaX,deltaY,width,height,text);
	}

	/**
	 * Moves a CarrierShape object (including its children) within the bounds specified by 
	 * arguments width and height.
	 */
	public void move(int width, int height) {
		super.move(width, height);
		for(Shape i:_shapeList) {
			i.move(_width, _height);
		}
	}

	/**
	 * Paints a CarrierShape object by drawing a rectangle around the edge of 
	 * its bounding box. The CarrierShape object's children are then painted.
	 */

	@Override 
	protected void doPaint(Painter painter) {
		painter.drawRect(_x, _y, _width,_height);
		painter.translate(_x,_y);
		for(Shape i:_shapeList) { 
			i.paint(painter);
		}
		painter.translate(-_x, -_y);
	}

	/**
	 * Attempts to add a shape to a CarrierShape object. If successful, a two-way link is 
	 * established between the CarrierShape and the newly added Shape. 
	 * @param shape the shape to be added
	 * @throws IllegalArgumentException if an attempt is made to add a Shape to a CarrierShape
	 * instance where the Shape argument is already a child within a CarrierShape instance. An 
	 * IllgalArgumentExpection is also thrown when an attempt is made to add a Shape that will
	 * not fit within the bounds of the proposed CarrierShape object.
	 */
	public void add(Shape shape) throws IllegalArgumentException {
		if(shape.parent()!=null||shape._width+shape._x>=_width||shape._height+shape._y>=_height) {
			throw new IllegalArgumentException();
		}else {
			_shapeList.add(shape);
			shape._parent=this;
			shape._self=shape;
		}
 
	}

	/**
	 * Removes a particular Shape from a CarrierShape instance. Once removed, the two-way link
	 * between the CarrierShape and its former child is destroyed. This method has no effect if 
	 * the Shape specified to remove is not a child of the CarrierShape.
	 * @param shape the shape to be removed.
	 */
	public void remove(Shape shape) {
		_shapeList.remove(shape);
		shape._parent=null;
	}

	/**
	 * Returns the Shape at a specified position within a CarrierShape. If the position
	 * specified is less than zero or greater than the number of children stored in the 
	 * CarrierShape less one this method throws an IndexOutBoundssException.
	 * @param index the specified index position.
	 */
	public Shape shapeAt(int index) {
		return _shapeList.get(index);

	}

	/**
	 * Returns the number of children contained with a CarrierShape object.
	 */
	public int shapeCount() {
		return _shapeList.size();
	}

	/**
	 * Returns the index of a specified within a CarrierShape object. If the Shape specified
	 * is not actually a child of the CarrierShape this method returns -1; otherwise the 
	 * value returned is in the range 0.. ShapeCout()-1.
	 * @param shape whose index position within the CarrierShape is requested.
	 * @return
	 */
	public int indexOf(Shape shape) {
		return _shapeList.indexOf(shape);
	}

	/**
	 * Returns true if the Shape argument is a child of the CarrierShape object on which this
	 * method is called.
	 */
	public boolean contains(Shape shape) {
		return _shapeList.contains(shape);
	}
}


