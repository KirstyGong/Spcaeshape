package spaceshapes;

/**
 * A class that implements test cases aimed at identifying bugs in the 
 * implementations of classes HexagonShape.
 * 
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestHexagonShape {

	private MockPainter _painter;
	
	/**
	 * This method is called automatically by the JUnit test-runner immediately
	 * before each @Test method is executed. setUp() recreates the fixture so 
	 * that there no side effects from running individual tests.
	 */
	@Before
	public void setUp() {
		_painter=new MockPainter();
	}
	
	/**
	 * Test to perform a simple (non-bouncing) movement, and to ensure that a
	 * Shape's position after the movement is correct for small hexagon.
	 */
	@Test
	public void testSimpleMove() {
		HexagonShape shape=new HexagonShape(100,20,12,15);
		shape.paint(_painter);
		shape.move(500,500);
		shape.paint(_painter);
		assertEquals("(line 100,37,112,20)(line 112,20,125,37)(line 125,37,112,55)"
				+ "(line 112,55,100,37)(line 112,52,124,35)(line 124,35,137,52)"
				+ "(line 137,52,124,70)(line 124,70,112,52)", _painter.toString());

	}

	/**
	 * Test to perform a simple (non-bouncing) movement, and to ensure that a
	 * Shape's position after the movement is correct for Big hexagon.
	 */
	@Test
	public void testSimpleMoveBig() {
		HexagonShape shape=new HexagonShape(100,20,12,15,50,50);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(line 100,45,120,20)(line 120,20,130,20)(line 130,20,150,45)"
				+ "(line 150,45,130,70)(line 130,70,120,70)(line 120,70,100,45)"
				+ "(line 112,60,132,35)(line 132,35,142,35)(line 142,35,162,60)"
				+ "(line 162,60,142,85)(line 142,85,132,85)(line 132,85,112,60)",
				_painter.toString());

	}

	/**
	 * Test to perform a bounce movement off the right-most boundary and to
	 * ensure that the Shape's position after the movement is correct for small hexagon.
	 */
	@Test
	public void testShpaeMoveWithBounceOffRightSmall() {
		HexagonShape shape=new HexagonShape(100,20,12,15);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		shape.move(135,10000);
		shape.paint(_painter);
		assertEquals("(line 100,37,112,20)(line 112,20,125,37)(line 125,37,112,55)(line 112,55,100,37)"
				+ "(line 110,52,122,35)(line 122,35,135,52)(line 135,52,122,70)(line 122,70,110,52)"
				+ "(line 98,67,110,50)(line 110,50,123,67)(line 123,67,110,85)(line 110,85,98,67)",
				_painter.toString());	
	}

	/**
	 * Test to perform a bounce movement off the right-most boundary and to
	 * ensure that the Shape's position after the movement is correct for big hexagon.
	 */
	@Test
	public void testShapeMoveWithBouceOffRightBig() {
		HexagonShape shape=new HexagonShape(100,20,12,15,50,50);
		shape.paint(_painter);
		shape.move(160, 10000);
		shape.paint(_painter);
		shape.move(160,10000);
		shape.paint(_painter);
		assertEquals("(line 100,45,120,20)(line 120,20,130,20)(line 130,20,150,45)"
				+ "(line 150,45,130,70)(line 130,70,120,70)(line 120,70,100,45)"
				+ "(line 110,60,130,35)(line 130,35,140,35)(line 140,35,160,60)"
				+ "(line 160,60,140,85)(line 140,85,130,85)(line 130,85,110,60)"
				+ "(line 98,75,118,50)(line 118,50,128,50)(line 128,50,148,75)"
				+ "(line 148,75,128,100)(line 128,100,118,100)(line 118,100,98,75)"
				, _painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the left-most boundary and to
	 * ensure that the Shape's position after the movement is correct for small hexagon.
	 */
	@Test
	public void testShpaeMoveWithBounceOffLeftSmall() {
		HexagonShape shape=new HexagonShape(10, 20, -12, 15);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(line 10,37,22,20)(line 22,20,35,37)(line 35,37,22,55)(line 22,55,10,37)"
				+ "(line 0,52,12,35)(line 12,35,25,52)(line 25,52,12,70)(line 12,70,0,52)"
				+ "(line 12,67,24,50)(line 24,50,37,67)(line 37,67,24,85)(line 24,85,12,67)"
				,_painter.toString());

	}

	/**
	 * Test to perform a bounce movement off the left-most boundary and to
	 * ensure that the Shape's position after the movement is correct for big hexagon.
	 */
	@Test 
	public void testShapeMoveWithBounceOffLeftBig() {
		HexagonShape shape=new HexagonShape(10, 20, -12, 15,50,50);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(line 10,45,30,20)(line 30,20,40,20)(line 40,20,60,45)"
				+ "(line 60,45,40,70)(line 40,70,30,70)(line 30,70,10,45)"
				+ "(line 0,60,20,35)(line 20,35,30,35)(line 30,35,50,60)"
				+ "(line 50,60,30,85)(line 30,85,20,85)(line 20,85,0,60)"
				+ "(line 12,75,32,50)(line 32,50,42,50)(line 42,50,62,75)"
				+ "(line 62,75,42,100)(line 42,100,32,100)(line 32,100,12,75)"
				, _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the bottom boundary and to
	 * ensure that the Shape's position after the movement is correct for small hexgon.
	 */
	@Test 
	public void testShapeMoveWithBounceOffBottomSmaill() {
		HexagonShape shape=new HexagonShape(10, 10, 12, -15);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(line 10,27,22,10)(line 22,10,35,27)(line 35,27,22,45)(line 22,45,10,27)"
				+ "(line 22,17,34,0)(line 34,0,47,17)(line 47,17,34,35)(line 34,35,22,17)"
				+ "(line 34,32,46,15)(line 46,15,59,32)(line 59,32,46,50)(line 46,50,34,32)"
				,_painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the bottom boundary and to
	 * ensure that the Shape's position after the movement is correct for big hexagon.
	 */
	@Test
	public void testShapeMoveWithBounceOffBottomBig() {
		HexagonShape shape=new HexagonShape(10, 10, 12, -15,50,50);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(line 10,35,30,10)(line 30,10,40,10)(line 40,10,60,35)"
				+ "(line 60,35,40,60)(line 40,60,30,60)(line 30,60,10,35)"
				+ "(line 22,25,42,0)(line 42,0,52,0)(line 52,0,72,25)"
				+ "(line 72,25,52,50)(line 52,50,42,50)(line 42,50,22,25)"
				+ "(line 34,40,54,15)(line 54,15,64,15)(line 64,15,84,40)"
				+ "(line 84,40,64,65)(line 64,65,54,65)(line 54,65,34,40)"
				,_painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the top boundary and to
	 * ensure that the Shape's position after the movement is correct for Big hexagon.
	 */
	@Test
	public void testShapeMoveWithBounceOffTopBig() {
		HexagonShape shape=new HexagonShape(10, 10, 12, -15,50,50);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(line 10,35,30,10)(line 30,10,40,10)(line 40,10,60,35)"
				+ "(line 60,35,40,60)(line 40,60,30,60)(line 30,60,10,35)"
				+ "(line 22,25,42,0)(line 42,0,52,0)(line 52,0,72,25)"
				+ "(line 72,25,52,50)(line 52,50,42,50)(line 42,50,22,25)"
				+ "(line 34,40,54,15)(line 54,15,64,15)(line 64,15,84,40)"
				+ "(line 84,40,64,65)(line 64,65,54,65)(line 54,65,34,40)"
				,_painter.toString());
	}


	/**
	 * Test to perform a bounce movement off the top boundary and to
	 * ensure that the Shape's position after the movement is correct for small hexagon.
	 */
	@Test
	public void testShapeMoveWithBounceOffTopSmall() {
		HexagonShape shape=new HexagonShape(10, 10, 12, -15);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(line 10,27,22,10)(line 22,10,35,27)(line 35,27,22,45)"
				+ "(line 22,45,10,27)(line 22,17,34,0)(line 34,0,47,17)"
				+ "(line 47,17,34,35)(line 34,35,22,17)(line 34,32,46,15)"
				+ "(line 46,15,59,32)(line 59,32,46,50)(line 46,50,34,32)"
				,_painter.toString());
	}

}
