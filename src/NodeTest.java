import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class NodeTest extends TestCase {
	private INode left = null;
	private INode right = null;
	private INode parent = null;
	private Node node = null;
	INode leaf = null;
	private IComparisonStrategy comparator = null;

	@Before
	public void setUp() {
		parent = new HeadNode();
		leaf = new LeafNode<>();
		parent.setRight(leaf);
		parent.setLeft(leaf);
		left = new LeafNode();
		right = new LeafNode();
	}

	@Test
	public void testAdd() {
		System.out.println("Running testAdd() ");
		assertTrue("adding to head node", this.parent.add("banana", comparator, null));
		assertTrue("adding to leaf node", this.leaf.add("apple", comparator, parent));
		assertTrue("adding to leaf node", this.leaf.add("fig", comparator, parent));
		assertTrue("adding to leaf node", this.leaf.add("grapes", comparator, parent));
		assertEquals("checking parent's left node", parent.getLeft().getData(), "apple");
	}

	@Test
	public void testContains() {
		System.out.println("Running testContains() ");
		this.parent.add("litchi", comparator, null);
		this.leaf.add("banana", comparator, parent);
		this.leaf.add("pears", comparator, parent);
		assertTrue("checking parent contains method", this.parent.contains("litchi"));
		assertTrue("checking left node contains method", parent.getLeft().contains("banana"));
		assertTrue("checking right node conatins method", parent.getRight().contains("pears"));
	}

	@Test
	public void testPrivateAdd() {
		System.out.println("Running testPrivateAdd() ");
		this.parent.add("litchi", comparator, null);
		node = new Node("fig", null, left, right, parent);
		assertTrue("adding value to node", node.privateAdd("banana", comparator, parent));
	}

	@Test
	public void testAddNodeWithoutParent() {
		System.out.println("Running testAddNodeWithoutParent");
		try {
			this.leaf.add("banana", comparator, null);
			assertTrue("Exception wasn't thrown", false);
		} catch (NullPointerException de) {
			assertTrue(true);
		}
	}

}
