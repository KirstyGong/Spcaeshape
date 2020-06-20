package spaceshapes.views;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import spaceshapes.Shape;
import spaceshapes.ShapeModel;
import spaceshapes.ShapeModelEvent;
import spaceshapes.ShapeModelListener;

/**
 * In this task I used the adapter method between the ShapeModelListener and the TreeModeListener.
 * @author Kirsty Gong
 *
 */
public class Task2 extends Task1 implements ShapeModelListener {

	private TreeModelEvent _event;
	private Object[] pathList;
	private List<TreeModelListener> _listener=new ArrayList<>();
	
	public Task2(ShapeModel model) {
		super(model);
	}

	/**
	 * This method updates the JTree, when new shape is added or when shape is deleted. 
	 */
	@Override
	public void update(ShapeModelEvent event) {
		// Unpack event.
		ShapeModelEvent.EventType eventType = event.eventType();
		Shape shape = event.operand(); 
		if(event.parent()!=null) { 
			pathList=event.parent().path().toArray();
		}else { 
			pathList= new Object[] {shape};	  
		}

		int[] childIndices=new int[] {event.index()};
		Object[]childList=new Shape[] {shape};
		_event=new TreeModelEvent(this, pathList, childIndices,childList);

		if(eventType == ShapeModelEvent.EventType.ShapeAdded) {
			for(TreeModelListener l: _listener) {
				l.treeNodesInserted(_event);
			}

		}
		else if(eventType == ShapeModelEvent.EventType.ShapeRemoved) {
			for(TreeModelListener l: _listener) {
				l.treeNodesRemoved(_event);
			} 
		}
	} 
	
	/**
	 * Storing the added TreeModelListener.
	 */
	@Override 
	public void addTreeModelListener(TreeModelListener l) {
		_listener.add(l);
	} 
	
	/**
	 * Deleting the TreeModelListener.
	 */
	@Override
	public void removeTreeModelListener(TreeModelListener l) {
		_listener.remove(l);
	}
}




