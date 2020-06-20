package spaceshapes;

/**
 * A class that implements test cases aimed at identifying bugs in the 
 * implementations of classes DynamicShapep.
 * 
 */
import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class TestDynamicShape {

	private MockPainter _painter;
	
	/**
	 * This method is called automatically by the JUnit test-runner immediately
	 * before each @Test method is executed. setUp() recreates the fixture so 
	 * that there no side effects from running individual tests.
	 */
	@Before
	public void setUp() {
		_painter = new MockPainter();
	}
	
	/**
	 * Test to perform a simple (non-bouncing) movement, and to ensure that a
	 * Shape's position after the movement is correct.
	 */
	@Test
	public void SimpleMovement() {
		DynamicRectangleShape shape=new DynamicRectangleShape(100,20,12,15,null);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(rectangle 100,20,25,35)(rectangle 112,35,25,35)", _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the right-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffRight() {
		DynamicRectangleShape shape=new DynamicRectangleShape(100, 20, 12, 15,Color.red);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		assertEquals("(rectangle 100,20,25,35)(Got it)(filled retangle 110,35,25,35)"
				+ "(Got it)(filled retangle 98,50,25,35)", _painter.toString());
	}
	
	/**
	 * Test for shape with no color and make sure it does not change color.
	 */
	@Test
	public void testShapeMoveWithBounceOffRightAndNoColor() {
		DynamicRectangleShape shape=new DynamicRectangleShape(100, 20, 12, 15,null);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		assertEquals("(rectangle 100,20,25,35)(rectangle 110,35,25,35)"
				+ "(rectangle 98,50,25,35)", _painter.toString());
	}
	
	
	/**
	 * Test to perform a bounce movement off the left-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffLeft() {
		DynamicRectangleShape shape=new DynamicRectangleShape(10, 20, -12, 15,Color.red);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(rectangle 10,20,25,35)(Got it)(filled retangle 0,35,25,35)"
				+ "(Got it)(filled retangle 12,50,25,35)", _painter.toString());
	}

	/**
	 * Test for shape with no color and make sure it does not change color.
	 */
	@Test
	public void testShapeMoveWithBounceOffLeftAndNoColor() {
		DynamicRectangleShape shape=new DynamicRectangleShape(10, 20, -12, 15,null);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(rectangle 10,20,25,35)(rectangle 0,35,25,35)"
				+ "(rectangle 12,50,25,35)", _painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the top-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	
	@Test
	public void MovementWithBounceOffTop() {
		DynamicRectangleShape shape=new DynamicRectangleShape(10, 100, 12, 15,Color.red);
		shape.paint(_painter);
		shape.move(10000, 100);
		shape.paint(_painter);
		shape.move(10000, 100);
		shape.paint(_painter);
		assertEquals("(rectangle 10,100,25,35)(rectangle 22,65,25,35)"
				+ "(rectangle 34,50,25,35)", _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the bottom boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void MovementWithBounceOffBottom() {
		DynamicRectangleShape shape=new DynamicRectangleShape(10, 110, 12, 15,Color.red);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(rectangle 10,110,25,35)(rectangle 22,100,25,35)"
				+ "(rectangle 34,85,25,35)", _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the bottom left corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	
	@Test
	public void testShapeMoveWithBounceOffBottomAndLeft() {
		DynamicRectangleShape shape=new DynamicRectangleShape(13, 100, -12, 15,Color.red);
		shape.paint(_painter);
		shape.move(125, 130);
		shape.paint(_painter);
		shape.move(125, 130);
		shape.paint(_painter);
		assertEquals("(rectangle 13,100,25,35)(rectangle 1,95,25,35)"
				+ "(Got it)(filled retangle 0,80,25,35)", _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the bottom right corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test	
	public void testShapeMoveWithBounceOffBottomAndRight() {
		DynamicRectangleShape shape=new DynamicRectangleShape(50, 100, 60, 15,Color.red);
		shape.paint(_painter);
		shape.move(100, 160);
		shape.paint(_painter);
		shape.move(100, 160);
		shape.paint(_painter);
		assertEquals("(rectangle 50,100,25,35)(Got it)(filled retangle 75,115,25,35)"
				+ "(rectangle 15,125,25,35)", _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the top right corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffTopAndRight() {
		DynamicRectangleShape shape=new DynamicRectangleShape(100, 16, 20, -15,Color.red);
		shape.paint(_painter);
		shape.move(125, 100);
		shape.paint(_painter);
		shape.move(125, 100);
		shape.paint(_painter);
		assertEquals("(rectangle 100,16,25,35)(Got it)(filled retangle 100,1,25,35)"
				+ "(rectangle 80,0,25,35)", _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the top left corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffTopAndLeft() {
		DynamicRectangleShape shape=new DynamicRectangleShape(10, 16, -12, -15,Color.red);
		shape.paint(_painter);
		shape.move(125, 100);
		shape.paint(_painter);
		shape.move(125, 100);
		shape.paint(_painter);
		assertEquals("(rectangle 10,16,25,35)(Got it)(filled retangle 0,1,25,35)"
				+ "(rectangle 12,0,25,35)", _painter.toString());
	}
	
}

