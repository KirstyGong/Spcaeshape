package spaceshapes;

/**
 * Class to represent a simple Oval space-shape.
 * 
 */

public class OvalShape extends Shape{

	/**
	 *Creating a oval shape instant with default values
	 */
	public OvalShape() {
		super();
	}
	
	/**
	 * Creating an oval shape instant with specific x and y position.
	 * @param x x position
	 * @param y y position
	 */
	public OvalShape(int x, int y) {
		super(x,y);
	}
	
	/**
	 * Creating an oval shape instant with specific x, y position and speed and direction for 
	 * horizontal and vertical axis.
	 * @param x x position
	 * @param y y position
	 * @param deltaX speed (pixels per move call) and direction for horizontal 
	 *        axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical 
	 *        axis.
	 */
	public OvalShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	
	/**
	 * Creates an Oval Shape instance with specified values for instance 
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
	public OvalShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}
	
	public OvalShape(int x, int y, int deltaX, int deltaY, int width, int height,String text) {
		super(x,y,deltaX,deltaY,width,height,text);
	}
	
	/**
	 * Paints an OvalShape object.
	 */
	@Override
	protected void doPaint(Painter painter) {
		painter.drawOval(_x, _y, _width, _height);
	}

}
