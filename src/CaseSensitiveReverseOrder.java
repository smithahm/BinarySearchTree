/**
 * ConcreteStrategy class used to maintain the reverse order comparison, without
 * ignoring the case differences
 * 
 */
public class CaseSensitiveReverseOrder<E> implements IComparisonStrategy<E> {

	@Override
	public int compare(E currentValue, E newValue) {
		if (currentValue instanceof String && newValue instanceof String) {
			return ((String) newValue).compareTo((String) currentValue);
		}
		return 0;

	}

}
