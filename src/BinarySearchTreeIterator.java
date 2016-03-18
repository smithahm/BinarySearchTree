
/**
  * Iterator implementation for this binary search tree.  The elements
  * are returned in ascending order according to their natural ordering.In-order traversal
  */
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BinarySearchTreeIterator<T extends Comparable<? super T>> implements Iterator<T> {

	private Stack<INode<T>> stack = new Stack<>();
	/**
	 * Node to be returned by next call to next().
	 */
	private INode<T> current;
	/**
	 * Node returned by last call to next() and available for removal. This
	 * field is null when no node is available to be removed.
	 */
	private INode<T> pending;

	BinarySearchTreeIterator(INode<T> root) {

		if (root == null) {
			throw new IllegalArgumentException("Root cannot be null");
		}
		current = root;

		while (!root.isLeaf()) {
			stack.push(root);
			root = root.getLeft();
		}
	}

	@Override
	public T next() {
		if (!hasNext())
			throw new NoSuchElementException();
		pending = stack.pop();
		current = pending.getRight();
		while (!current.isNull()) {
			stack.push(current);
			current = current.getLeft();
		}
		return pending.getData();
	}

	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();

	}
}
