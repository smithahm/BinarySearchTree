
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class VowelsDecoratorTest extends TestCase {
	private List<String> flavours;
	private IStringIteratorDecorator<String> iterator;
	BinarySearchTree<String> languages = new BinarySearchTree<>();
	private IStringIteratorDecorator<String> binarySearchTreeIterator;

	@Before
	public void setUp() {
		flavours = new ArrayList<>();
		languages.add("java");
		languages.add("oracle");
		languages.add("sql");
		languages.add("Python");
		flavours.add("chocolate");
		flavours.add("orange");
		flavours.add("apple");
		flavours.add("banana");
		flavours.add("ube");
	}

	@Test
	public void testHasNext() {
		Iterator<Object> nullIterator = Collections.emptyIterator();
		binarySearchTreeIterator = new VowelsDecorator(languages.iterator());
		iterator = new VowelsDecorator(flavours.iterator());
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
		assertFalse("testing when there is no next element", binarySearchTreeIterator.hasNext());
	}

	@Test
	public void testNext() {
		iterator = new VowelsDecorator(flavours.iterator());
		binarySearchTreeIterator = new VowelsDecorator(languages.iterator());
		iterator.hasNext();
		assertEquals("orange", iterator.next());
		iterator.hasNext();
		assertEquals("apple", iterator.next());
		iterator.hasNext();
		assertEquals("ube", iterator.next());
		binarySearchTreeIterator.hasNext();
		assertEquals("oracle", binarySearchTreeIterator.next());
	}

}
