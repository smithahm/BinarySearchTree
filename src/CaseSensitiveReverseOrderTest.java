import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class CaseSensitiveReverseOrderTest extends TestCase {
	private BinarySearchTree<String> several;
	CaseSensitiveReverseOrder<String> testCompare = new CaseSensitiveReverseOrder<>();

	@Before
	public void setUp() {
		several = new BinarySearchTree<String>(new CaseSensitiveReverseOrder<String>());
		several.add("Grapefruit");
		several.add("pears");
		several.add("Grapefruit");
		several.add("apple");
		several.add("Apple");
		several.add("Fig");
		several.add("dates");
		several.add("raisins");
	}

	@Test
	public void testToString() {
		System.out.println("Running testToString()");
		String expectedValue = "[pears, raisins, dates, apple, Grapefruit, Grapefruit, Fig, Apple]";
		assertEquals(expectedValue, several.toString());
	}

	@Test
	public void testCompare() {
		System.out.println("Running testCompare()");
		assertTrue("testing reverse order case sensitive test", testCompare.compare("eliachi", "Dates") < 0);
		assertFalse("testing reverse order case sensitive test", testCompare.compare("eliachi", "Apple") > 0);
		assertFalse("testing reverse order case sensitive test", testCompare.compare("eliachi", "Eliachi") == 0);
		assertTrue("testing Null value case", testCompare.compare("", "") == 0);
	}

	@Test
	public void testToArray() {
		System.out.println("Running testToArray()");
		String expectedOutput[] = new String[] { "pears", "raisins", "dates", "apple", "Grapefruit", "Grapefruit",
				"Fig", "Apple" };
		assertTrue("Arrays not the same length", several.toArray().length == expectedOutput.length);
		for (int i = 0; i < several.toArray().length; i++)
			assertEquals(expectedOutput[i], (String) several.toArray()[i]);
	}
}
