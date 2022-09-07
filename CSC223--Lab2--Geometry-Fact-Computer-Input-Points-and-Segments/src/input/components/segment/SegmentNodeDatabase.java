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
import java.util.HashSet;
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
		//creates an edge of pt1 -> pt2, create a segment via points
		SegmentNode seg = new SegmentNode(pt1, pt2);
		//add to segment list? 
	}
	
	public void addUndirectedEdge(PointNode pt1, PointNode pt2) {
		//TODO
		//Call directed edge twice, makes 1 directed edge
			//pt1 -> pt2 and pt1 <- pt2
			//pt1 <-> pt2
	}
	
	/**
	 * Helper method to turn this list into set
	 * @param list of pointNodes
	 * @return set of PointNodes
	 */
	public Set<PointNode> listToSet(List<PointNode> list) {
		Set<PointNode> nodeSet = new HashSet<PointNode>();
		for (PointNode node: list) {
			nodeSet.add(node);
		}
		return nodeSet;
	}
	
	/**
	 * Adds a new adjacencyList to adjLists
	 * @param point- point to add
	 * @param list- list of points that point is next to
	 */
	public void addAdjacencyList(PointNode point, List<PointNode> list) {
		//TODO
		//turn into set
		//Add point as the key as d list as the "value" pair to _adjLists
		_adjLists.put(point, this.listToSet(list));
	}
	
	
	
	
	
	
	public List<SegmentNode> asSegmentList() {
		
		List<SegmentNode> segmentList = new ArrayList<SegmentNode>();
		SegmentNode tempSegment = new SegmentNode(null, null);
		PointNode tempPoint = new PointNode(null, null);
		
		//loop through each map value and retrieve list
		_adjLists.forEach((node, set) -> 
			//System.out.println("Test") 
			//iterate through set
			//Iterator it = set.iterator();
			
		
			//loop through set PointNode (iterate)
				segmentList.add(node, tempPoint )
		);
		return segmentList;
		//loop thnrough each map value and retrieve list
		//for (PointNode node: _adjLists)
			//for each value and list value create a segment and add to segmentList?
		
		
		//TODO fix me this is just temp to make errors go away
		List<SegmentNode> FIXME = new ArrayList<SegmentNode>();
		return FIXME;
	}
	
	public List<SegmentNode> asUniqueSegmentList() {
		//unique, CANNOT have duplicate segments
		
		//same as before but have a way to check if segment/reverse 
		//segment already exists in list
		
		
		//TODO fix me this is just temp to make errors go away
		//should remove duplicates (make set to remove?)
		List<SegmentNode> FIXME = new ArrayList<SegmentNode>();
		return FIXME;
	}
	
	
	
}
