import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class CaseSensitiveLexicalOrderTest extends TestCase {
	private BinarySearchTree<String> several;
	CaseSensitiveLexicalOrder<String> testCompare = new CaseSensitiveLexicalOrder<>();

	@Before
	public void setUp() {
		several = new BinarySearchTree<String>(new CaseSensitiveLexicalOrder<String>());
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
		String expectedValue = "[Apple, Fig, Grapefruit, apple, banana, dates, mango, pears, raisins]";
		assertEquals(expectedValue, several.toString());
	}

	@Test
	public void testCompare() {
		System.out.println("Running testCompare()");
		assertFalse("testing lexical case sensitive test", testCompare.compare("eliachi", "Dates") < 0);
		assertTrue("testing lexical case sensitive test", testCompare.compare("eliachi", "Apple") > 0);
		assertFalse("testing lexical case sensitive test", testCompare.compare("eliachi", "Eliachi") == 0);
		assertTrue("testing Null value case", testCompare.compare("", "") == 0);
	}

	@Test
	public void testToArray() {
		System.out.println("Running testToArray()");
		String expectedOutput[] = new String[] { "Apple", "Fig", "Grapefruit", "apple", "banana", "dates", "mango",
				"pears", "raisins" };
		assertTrue("Arrays not the same length", several.toArray().length == expectedOutput.length);
		for (int i = 0; i < several.toArray().length; i++)
			assertEquals(expectedOutput[i], (String) several.toArray()[i]);
	}
}
