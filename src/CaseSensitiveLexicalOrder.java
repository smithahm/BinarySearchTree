/**
 * ConcreteStrategy class used to maintain the lexicographical comparison,
 * without ignoring the case differences
 * 
 */
public class CaseSensitiveLexicalOrder<E> implements IComparisonStrategy<E> {

	@Override
	public int compare(E currentValue, E newValue) {
		if (currentValue instanceof String && newValue instanceof String) {
			return ((String) currentValue).compareTo((String) newValue);
		}
		return 0;

	}

}