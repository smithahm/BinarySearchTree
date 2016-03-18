
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class BinarySearchTreeTest extends TestCase {
	BinarySearchTree<String> empty;
	private BinarySearchTree<String> several;
	private BinarySearchTree<String> one;
	private BinarySearchTree<String> languages;

	@Before
	public void setUp() {
		/**
		 * No strategy set so it will take the default lexicographical
		 * comparison
		 */
		empty = new BinarySearchTree<>();
		several = new BinarySearchTree<String>();
		one = new BinarySearchTree<String>();
		languages = new BinarySearchTree<>();
		languages.add("java");
		languages.add("oracle");
		languages.add("sql");
		languages.add("Python");
		several.add("litchi");
		several.add("dates");
		several.add("GRAPES");
		several.add("chikko");
		several.add("ROSE");
		several.add("saffron");
		several.add("Elaichi");
	}

	@Test
	public void testAdd() {
		System.out.println("Running testAdd() ");
		assertTrue("adding one element", one.add("banana"));
		assertTrue("adding element", several.add("kiwi"));
		assertTrue("adding element", several.add("raspberry"));
		assertTrue("adding element", several.add("sweetpotato"));
		assertTrue("adding duplicate element", several.add("kiwi"));
		assertFalse("testing addition empty value", several.add(""));
	}

	@Test
	public void testContains() {
		System.out.println("Running testContains() ");
		assertTrue("testing whether element is present in BST", several.contains("litchi"));
		assertTrue("testing whether element is present in BST", several.contains("dates"));
		assertFalse("testing for element NOT present", one.contains("Carrot"));
		assertFalse("testing for element NOT present", several.contains("Beans"));
		assertFalse("testing for null value NOT present", several.contains(""));
		assertFalse("testing for empty present", empty.contains(""));
	}

	@Test
	public void testToString() {
		System.out.println("Running testToString() ");
		String expectedValue = "[Python, java, oracle, sql]";
		assertEquals(expectedValue, languages.toString());
	}

	@Test
	public void testToArray() {
		System.out.println("Running testToArray() ");
		String expectedOutput[] = new String[] { "Python", "java", "oracle", "sql" };
		assertTrue("Arrays not the same length", languages.toArray().length == expectedOutput.length);
		for (int i = 0; i < languages.toArray().length; i++)
			assertEquals(expectedOutput[i], (String) languages.toArray()[i]);
	}

	@Test
	public void testSize() {
		System.out.println("Running testSize() ");
		BinarySearchTree<String> veggies = new BinarySearchTree<>();
		assertTrue("adding element", veggies.add("peas"));
		assertTrue("adding element", veggies.add("raspberry"));
		assertTrue("adding element", veggies.add("sweetpotato"));
		assertEquals("testing size of the bst node", veggies.size(), 3);

	}

	@Test
	public void testIterator() {
		System.out.println("Running testIterator() ");
		String[] expectedValue = several.toArray();
		int index = 0;
		Iterator<String> emptyIterator = empty.iterator();
		while (emptyIterator.hasNext()) {
			assertNull("testing iterator on empty BST node", emptyIterator.next());
		}
		Iterator<String> iterator = several.iterator();
		while (iterator.hasNext()) {
			assertEquals(iterator.next(), expectedValue[index]);
			index++;
		}
	}

	@Test
	public void testIteratorHasNext() {
		System.out.println("Running testIteratorHasNext() ");
		BinarySearchTree<String> languages = new BinarySearchTree<String>(new CaseSensitiveLexicalOrder<String>());
		assertTrue(languages.add("oracle"));
		assertTrue(languages.add("java"));
		assertTrue(languages.add("SQL"));
		Iterator<String> iterator = languages.iterator();
		assertTrue("testing when there is a next element", iterator.hasNext());
		assertEquals("SQL", iterator.next());
		assertTrue("testing when there is a next element", iterator.hasNext());
		iterator.next();
		assertTrue("testing when there is a next element", iterator.hasNext());
		iterator.next();
		assertFalse("testing when there is no next element", iterator.hasNext());
	}

	@Test
	public void testIteratorNext() {
		System.out.println("Running testIteratorNext() ");
		BinarySearchTree<String> languages = new BinarySearchTree<String>(new CaseInsensitiveLexicalOrder<String>());
		assertTrue(languages.add("oracle"));
		assertTrue(languages.add("java"));
		assertTrue(languages.add("SQL"));
		Iterator<String> iterator = languages.iterator();
		assertEquals("java", iterator.next());
		assertEquals("oracle", iterator.next());
		assertEquals("SQL", iterator.next());
		try {
			assertNull(iterator.next());
		} catch (Exception e) {

		}
	}
}
