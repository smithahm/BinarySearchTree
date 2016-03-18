import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class CaseInsensitiveLexicalOrderTest extends TestCase {
	private BinarySearchTree<String> several;
	CaseInsensitiveLexicalOrder<String> testCompare = new CaseInsensitiveLexicalOrder<>();

	// Test Null value in compareTo method

	@Before
	public void setUp() {
		several = new BinarySearchTree<String>(new CaseInsensitiveLexicalOrder<String>());
		several.add("Grapefruit");
		several.add("pears");
		several.add("banana");
		several.add("apple");
		several.add("Apple");
		several.add("Fig");
		several.add("mango");
		several.add("dates");
		several.add("raisins");
	}

	@Test
	public void testToString() {
		System.out.println("Running testToString()");
		String expectedValue = "[apple, Apple, banana, dates, Fig, Grapefruit, mango, pears, raisins]";
		assertEquals(expectedValue, several.toString());
	}

	@Test
	public void testCompare() {
		System.out.println("Running testCompare()");
		assertTrue("testing lexical case insensitive test", testCompare.compare("Dates", "eliachi") < 0);
		assertTrue("testing lexical case insensitive test", testCompare.compare("dates", "DATES") == 0);
		assertFalse("testing lexical case insensitive test", testCompare.compare("apple", "Grapes") > 0);
		assertTrue("testing Null value case", testCompare.compare("", "") == 0);
	}

	@Test
	public void testToArray() {
		System.out.println("Running testToArray()");
		String expectedOutput[] = new String[] { "apple", "Apple", "banana", "dates", "Fig", "Grapefruit", "mango",
				"pears", "raisins" };
		assertTrue("Arrays not the same length", several.toArray().length == expectedOutput.length);
		for (int i = 0; i < several.toArray().length; i++)
			assertEquals(expectedOutput[i], (String) several.toArray()[i]);
	}
}
