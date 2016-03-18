
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class UpperCaseDecoratorTest extends TestCase {
	private List<String> colors;
	private IStringIteratorDecorator<String> iterator;
	BinarySearchTree<String> languages = new BinarySearchTree<>();
	private IStringIteratorDecorator<String> binarySearchTreeIterator;

	@Before
	public void setUp() {
		colors = new ArrayList<>();
		languages.add("java");
		languages.add("oracle");
		languages.add("sql");
		languages.add("Python");
		colors.add("red");
		colors.add("blue");
		colors.add("purple");
		colors.add("green");
	}

	@Test
	public void testHasNext() {
		Iterator<Object> nullIterator = Collections.emptyIterator();
		iterator = new UpperCaseDecorator(colors.iterator());
		binarySearchTreeIterator = new UpperCaseDecorator(languages.iterator());
		assertTrue("testing if there are next elements", iterator.hasNext());
		iterator.next();
		assertTrue("testing if there are next elements", iterator.hasNext());
		iterator.next();
		assertTrue("testing if there are next elements", iterator.hasNext());
		iterator.next();
		assertTrue("testing if there are next elements", iterator.hasNext());
		iterator.next();
		assertFalse(iterator.hasNext());
		assertFalse(nullIterator.hasNext());
		assertTrue("testing when there is a next element", binarySearchTreeIterator.hasNext());
		iterator.next();
		assertTrue("testing when there is a next element", binarySearchTreeIterator.hasNext());
		iterator.next();
		assertTrue("testing when there is a next element", binarySearchTreeIterator.hasNext());
		iterator.next();
		assertTrue("testing when there is a next element", binarySearchTreeIterator.hasNext());
		iterator.next();
		assertFalse("testing when there is no next element", binarySearchTreeIterator.hasNext());
	}

	@Test
	public void testNext() {
		iterator = new UpperCaseDecorator(colors.iterator());
		binarySearchTreeIterator = new UpperCaseDecorator(languages.iterator());
		iterator.hasNext();
		assertEquals("RED", iterator.next());
		iterator.hasNext();
		assertEquals("BLUE", iterator.next());
		iterator.hasNext();
		assertEquals("PURPLE", iterator.next());
		iterator.hasNext();
		assertEquals("GREEN", iterator.next());
		binarySearchTreeIterator.hasNext();
		assertEquals("PYTHON", binarySearchTreeIterator.next());
		binarySearchTreeIterator.hasNext();
		assertEquals("JAVA", binarySearchTreeIterator.next());
		binarySearchTreeIterator.hasNext();
		assertEquals("ORACLE", binarySearchTreeIterator.next());
		binarySearchTreeIterator.hasNext();
		assertEquals("SQL", binarySearchTreeIterator.next());
	}
}
