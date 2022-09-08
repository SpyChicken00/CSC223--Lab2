/**
 * Tests for SegmentNodeDatabase
 * 
 * <p>Bugs: 
 * 
 * @author Jace Rettig and James Crawford
 * @Date 9-1-22
 */
package input.components.segment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import input.components.point.PointNode;

class SegmentNodeDatabaseTest {

	public SegmentNodeDatabase build()
    {
    	//      A                                 
    	//     / \                                
    	//    B___C                               
    	//   / \ / \                              
    	//  /   X   \ 
    	// D___/_\___E
    	//
		//
    	PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);

    	PointNode d = new PointNode("D", 0, 0);
    	PointNode e = new PointNode("E", 6, 0);
    	PointNode x = new PointNode("X", 3, 3);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();
    	  	
    	db.addUndirectedEdge(a, b);
    	db.addUndirectedEdge(a, c);
    	db.addUndirectedEdge(b, c);
    	db.addUndirectedEdge(b, x);
    	db.addUndirectedEdge(b, d);
    	db.addUndirectedEdge(c, x);
    	db.addUndirectedEdge(c, e);
    	db.addUndirectedEdge(x, d);
    	db.addUndirectedEdge(x, e);
    	db.addUndirectedEdge(d, e);
    	
    	return db;
    }
	/**
	 * Builds a simple triangle to facilitate testing
	 * @return segmentNodeDatabase for triangle
	 */
	public SegmentNodeDatabase buildTriangle () {
		//       A
		//      / \
		//	   B___C
		
		PointNode a = new PointNode("A", 1, 2);
    	PointNode b = new PointNode("B", 0, 0);
    	PointNode c = new PointNode("C", 2, 0);
		
		SegmentNodeDatabase db = new SegmentNodeDatabase();
		
		db.addUndirectedEdge(a, b);
    	db.addUndirectedEdge(a, c);
    	db.addUndirectedEdge(b, c);
    	
		return db;
	}
	
	/**
	 * tests the numUndirectedEdges method
	 */
	@Test
	void testNumUndirectedEdges()
	{
		SegmentNodeDatabase db = build();
		SegmentNodeDatabase triangle = buildTriangle();
		
		
		assertEquals(10, db.numUndirectedEdges());
		assertEquals(3, triangle.numUndirectedEdges());
		//test node pointing to itself?
		//empty database/ no edges? 
	}
	
	
	/*
	@Test
	void testAddDirectedEdge() {
		
		PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);

    	PointNode d = new PointNode("D", 0, 0);
    	PointNode e = new PointNode("E", 6, 0);
    	PointNode x = new PointNode("X", 3, 3);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();
    	
    	db.addDirectedEdge(a, b);
    	

		
	} */

	
	/**
	 * test addAdjacencyList and list to set helper method
	 */
	@Test
	public void testAddAdjacencyList() {
		
	}
	
	/*
	@Test //temp test for converting list to set
	//check that values in set are unique
	public void testListtoSet() {
		
		List<PointNode> l = new ArrayList<PointNode>();
		PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);

    	PointNode d = new PointNode("D", 0, 0);
    	PointNode e = new PointNode("E", 6, 0);
    	PointNode x = new PointNode("X", 3, 3);
    	PointNode x2 = new PointNode("X", 3, 3);
    	
    	SegmentNodeDatabase db = new SegmentNodeDatabase();
    	
    	
		l.add(a);
		l.add(b);
		l.add(c);
		l.add(d);
		l.add(e);
		l.add(x);
		l.add(x);
		l.add(x);
		Set<PointNode> nodeSet = new HashSet<PointNode>();
		nodeSet = db.listToSet(l);
		
		for (PointNode p:nodeSet) {
			System.out.println(p);
		}
		
		
		
		
	}
	**/
	@Test
	public void testAsSegmentEdge() {
		SegmentNodeDatabase db = buildTriangle();
		
		assertEquals("AB AC BA BC CA CB ", db.segmentListToString(db.asSegmentList()));
	}
	
	@Test
	public void testasUniqueSegmentList() {
		SegmentNodeDatabase db = buildTriangle();
		
		assertEquals("AB AC BC ", db.segmentListToString(db.asUniqueSegmentList()));
	}
	
}
