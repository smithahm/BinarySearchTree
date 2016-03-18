
/**
 * ConcreteDecorator class to decorate the Java Iterators 
 * and capitalizes all the strings it returns in the next() method.
 */

import java.util.Iterator;

public class UpperCaseDecorator implements IStringIteratorDecorator<String> {

	protected final Iterator<String> iterator;
	private String value;

	UpperCaseDecorator(Iterator<String> iterator) {
		super();
		this.iterator = iterator;
	}

	@Override
	public boolean hasNext() {
		if (iterator.hasNext()) {
			value = iterator.next().toUpperCase();
			return true;
		}
		return false;
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
