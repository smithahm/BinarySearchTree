
/**
 * ConcreteDecorator class to decorate the Java Iterators 
 * and return only strings that starts with Vowel
*/
import java.util.Iterator;

public class VowelsDecorator implements IStringIteratorDecorator<String> {

	protected final Iterator<String> iterator;
	private String value;

	VowelsDecorator(Iterator<String> iterator) {
		super();
		this.iterator = iterator;
	}

	@Override
	public boolean hasNext() {
		while (iterator.hasNext()) {
			value = iterator.next();
			if (startsWithVowel(value))
				return true;
		}
		return false;
	}

	private boolean startsWithVowel(String value2) {
		char firstLetter = Character.toLowerCase(value2.charAt(0));
		return firstLetter == 'a' || firstLetter == 'e' || firstLetter == 'i' || firstLetter == 'o'
				|| firstLetter == 'u';
	}

	@Override
	public String next() {
		return value;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
