package spaceshapes.views;

/**
 * In this task I used the adapter method between the ShapeModel and the TreemModel class.
 * @author Kirsty Gong
 *
 */
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import spaceshapes.CarrierShape;
import spaceshapes.Shape;
import spaceshapes.ShapeModel;

public class Task1 implements TreeModel  {

	private ShapeModel _model;

	public Task1(ShapeModel model) {
		_model=model; 
	}

	/**
	 * Storing the added TreeModelListener.
	 */
	@Override
	public void addTreeModelListener(TreeModelListener l) {
	}  

	/**
	 * It return the child at a given index
	 */
	@Override
	public Object getChild(Object parent, int index) {
		if(parent instanceof CarrierShape ) {
			CarrierShape shape =(CarrierShape) parent;
			if(index<shape.shapeCount()&& index>=0) { 
				return shape.shapeAt(index);
			}
		}
		return null;
	}
	

	/**
	 * It returns the total number of children
	 */
	@Override
	public int getChildCount(Object parent) {
		if(parent instanceof CarrierShape) {
			CarrierShape shape =(CarrierShape) parent;
			return shape.shapeCount();
		}
		return 0;
	}

	/**
	 * It return the index of the child with a given parent
	 */
	@Override
	public int getIndexOfChild(Object parent, Object child) {
		if(parent instanceof CarrierShape && child instanceof Shape) {
			CarrierShape shape =(CarrierShape) parent;
			Shape childShape=(Shape) child;
			return shape.indexOf(childShape);
		}
		return -1;
	}

	/**
	 * It return the root of the object
	 */
	@Override 
	public Object getRoot() {
		return _model.root();
	}

	/**
	 * To check it the object is a a lead
	 */
	@Override
	public boolean isLeaf(Object node) {
		return !(node instanceof CarrierShape);
	}

	/**
	 * Deleting the TreeModelListener.
	 */
	@Override
	public void removeTreeModelListener(TreeModelListener l) {
	}

	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
	}



}
