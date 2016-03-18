/**
 * ConcreteStrategy class used to maintain the lexicographical comparison,
 * ignoring the case differences
 * 
 */
public class CaseInsensitiveLexicalOrder<E> implements IComparisonStrategy<E> {

	@Override
	public int compare(E currentValue, E newValue) {
		if (currentValue instanceof String && newValue instanceof String) {
			return ((String) currentValue).compareToIgnoreCase((String) newValue);
		}
		return 0;

	}

}