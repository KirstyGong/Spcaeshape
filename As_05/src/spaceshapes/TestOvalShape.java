package spaceshapes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * A class that implements test cases aimed at identifying bugs in the 
 * implementations of classes Oval shape.
 * 
 * 
 */
public class TestOvalShape {
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
		OvalShape shape= new OvalShape(100,20,12,15);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(oval 100,20,25,35)(oval 112,35,25,35)", _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the right-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void MovementwithBounceOffRight() {
		OvalShape shape= new OvalShape(100,20,12,15);
		shape.paint(_painter);
		shape.move(135, 500);
		shape.paint(_painter);
		shape.move(135, 300); 
		shape.paint(_painter);
		assertEquals("(oval 100,20,25,35)(oval 110,35,25,35)(oval 98,50,25,35)", _painter.toString());
		//(oval 112,35,25,35)"+"(oval 100,50,25,35)
	}
	
	/**
	 * Test to perform a bounce movement off the left-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void MovementwithBounceOffleft() {
		OvalShape shape = new OvalShape(10, 20, -12, 15);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(oval 10,20,25,35)(oval 0,35,25,35)"+"(oval 12,50,25,35)", _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the bottom-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void MovementWithBouceOffBottom() {
		OvalShape shape = new OvalShape(10, 10, 12, -15);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(oval 10,10,25,35)(oval 22,0,25,35)(oval 34,15,25,35)", _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the top-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test 
	public void MovementWithBounceOffTop() {
		OvalShape shape = new OvalShape(10, 100, 12, 15);
		shape.paint(_painter);
		shape.move(10000, 100);
		shape.paint(_painter);
		shape.move(10000, 100);
		shape.paint(_painter);
		assertEquals("(oval 10,100,25,35)(oval 22,65,25,35)(oval 34,50,25,35)", _painter.toString());
	}
	
}
