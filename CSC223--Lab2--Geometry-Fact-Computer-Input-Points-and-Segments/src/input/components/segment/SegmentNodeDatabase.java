/**
 * A database to store segment nodes
 * 
 * <p>Bugs: 
 * 
 * @author Jace Rettig and James ???
 * @Date 9-1-22
 */
package input.components.segment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import input.components.point.*;

public class SegmentNodeDatabase {
	private Map<PointNode, Set<PointNode>> _adjLists;
	
	public SegmentNodeDatabase() {
		//TODO what kind of map should the adjList be
		_adjLists = new HashMap<PointNode, Set<PointNode>>();
	}
	
	public SegmentNodeDatabase(Map<PointNode, Set<PointNode>> m) {
		_adjLists = m;
	}
	
	public int numUndirectedEdges() {
		//TODO
		return -1;
	}
	
	private void addDirectedEdge(PointNode pt1, PointNode pt2) {
		//TODO
	}
	
	public void addUndirectedEdge(PointNode pt1, PointNode pt2) {
		//TODO
	}
	
	public void addAdjacencyList(PointNode point, List<PointNode> list) {
		//TODO
	}
	
	public List<SegmentNode> asSegmentList() {
		//TODO fix me this is just temp to make errors go away
		List<SegmentNode> FIXME = new ArrayList<SegmentNode>();
		return FIXME;
	}
	
	public List<SegmentNode> asUniqueSegmentList() {
		//TODO fix me this is just temp to make errors go away
		//should remove duplicates (make set to remove?)
		List<SegmentNode> FIXME = new ArrayList<SegmentNode>();
		return FIXME;
	}
	
	
	
}
