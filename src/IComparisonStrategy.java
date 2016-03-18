
/**
 * Strategy Pattern Interface to have subclasses based on the type of comparison
 * done when ordering the tree objects.
 */
public interface IComparisonStrategy<E> {
	public int compare(E o1, E o2);
}
