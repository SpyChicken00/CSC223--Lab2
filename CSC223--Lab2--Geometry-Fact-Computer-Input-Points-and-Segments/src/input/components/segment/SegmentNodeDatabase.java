/**
 * A database to store segment nodes
 * 
 * <p>Bugs: 
 * 
 * @author Jace Rettig and James Crawford
 * @Date 9-1-22
 */
package input.components.segment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.*;
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
		int numUndirectedEdges = 0;
		//count number of pairs in adjLists
		
		
		//returns set of every entry pair
		for (Map.Entry<PointNode, Set<PointNode>> OuterPoint: _adjLists.entrySet()) {
			for (PointNode value: OuterPoint.getValue()) {
				if (_adjLists.get(value).contains(OuterPoint.getKey())) {
					numUndirectedEdges += 1;
				}	
			}
		}
		_adjLists.entrySet();
		//divide by 2 to remove duplicates
		numUndirectedEdges = numUndirectedEdges / 2;
		return numUndirectedEdges;
	}
	
	private void addDirectedEdge(PointNode pt1, PointNode pt2) {
		//TODO
		if (_adjLists.get(pt1) == null) {
			Set<PointNode> nodeSet = new HashSet<PointNode>();
			_adjLists.put(pt1, nodeSet);
			_adjLists.get(pt1).add(pt2);
		} 
		else if (_adjLists.get(pt1).contains(pt2)) {
			
		}
		else {
			_adjLists.get(pt1).add(pt2);
		}
		
	}
	
	public void addUndirectedEdge(PointNode pt1, PointNode pt2) {
		//TODO
		//Call directed edge twice, makes 1 directed edge
		addDirectedEdge(pt1, pt2);
		addDirectedEdge(pt2, pt1);
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
		//TODO error checking
		//turn into set
		//Add point as the key as d list as the "value" pair to _adjLists
		_adjLists.put(point, this.listToSet(list));
	}
	
	
	
	
	
	//TODO TEST
	public List<SegmentNode> asSegmentList() {
		
		List<SegmentNode> segmentList = new ArrayList<SegmentNode>();
		//loop through each list in adjLists
		for (Map.Entry<PointNode, Set<PointNode>> OuterPoint: _adjLists.entrySet()) {
			//loop through list values
			for (PointNode value: OuterPoint.getValue()) {
				SegmentNode tempSegment = new SegmentNode(OuterPoint.getKey(), value);
				//TODO TEMP
				System.out.print(tempSegment.toString());
				//TODO TEMP
				segmentList.add(tempSegment);
			}
		}
		
		return segmentList;
		
		
	}
	
	private boolean hasDirectedSegment(PointNode start, PointNode end) {
		//determine if 
	}
	
	public List<SegmentNode> asUniqueSegmentList() {
		//unique, CANNOT have duplicate segments
		
		List<SegmentNode> segmentList = new ArrayList<SegmentNode>();
		//loop through each list in adjLists
		for (Map.Entry<PointNode, Set<PointNode>> OuterPoint: _adjLists.entrySet()) {
			//loop through list values
			for (PointNode value: OuterPoint.getValue()) {
				SegmentNode tempSegment = new SegmentNode(OuterPoint.getKey(), value);
				if (this.hasDirectedSegment()) {
					segmentList.add(tempSegment);
				}
				
			}
		}
		
		return segmentList;
	}
	
	
	
}
