package spaceshapes;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

/**
 * Implementation of the Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public class GraphicsPainter implements Painter {
	// Delegate object.
	private Graphics _g;

	/**
	 * Creates a GraphicsPainter object and sets its Graphics delegate.
	 */
	public GraphicsPainter(Graphics g) {
		this._g = g;
		_g.setColor(new Color(212, 212, 212));
	}

	/**
	 * @see spaceshapes.Painter.drawRect
	 */
	public void drawRect(int x, int y, int width, int height) {
		_g.drawRect(x, y, width, height);
	}

	/**
	 * @see spaceshapes.Painter.drawOval
	 */
	public void drawOval(int x, int y, int width, int height) {
		_g.drawOval(x, y, width, height);
	}

	/**
	 * @see spaeshapes.Painter.drawLine.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_g.drawLine(x1, y1, x2, y2);
	}

	/**
	 * @see spaeshapes.Painter.fillRetangle.
	 */

	public void fillRetangle(int x, int y, int width, int height) {
		_g.fillRect(x, y, width, height);
	}

	/**
	 * @see spaeshapes.Painter.getColor.
	 */
	public Color getColor() {
		return _g.getColor();
	}
	
	/**
	 * @see spaeshapes.Painter.setColor.
	 */
	public void setColor(Color colour) {
			_g.setColor(colour);

	}

	/**
	 * @see spaeshapes.Painter.drawCentredText.
	 */
	public void drawCentredText(String text, int x, int y,int width, int height) {
		FontMetrics font=_g.getFontMetrics();
		int yPosition=0;
		int ascent=font.getAscent();
		int descent = font.getDescent();
		int widthWord=0;
		if(ascent>descent) {
			yPosition=(ascent-descent)/2;
		}else {
			yPosition=(descent-ascent)/2;
		}
 
		for(int i=0;i<text.length();i++) { 
			widthWord=widthWord+font.charWidth(text.charAt(i));

		}
		if(width%2!=0) {
			width++;
		}
		
		if(height%2!=0) {
			height++;
		}		
		_g.drawString(text, x+width/2-widthWord/2, y+height/2+yPosition);
		
	}

	@Override
	public void translate(int x, int y) {
		_g.translate(x, y);
		
	}

	@Override
	public void drawImage(Image _picture, int _x, int _y, int _width, int _height, ImageObserver observer) {
		_g.drawImage(_picture, _x, _y, _width, _height, observer);
	}
	
		
	
}
