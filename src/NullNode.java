
class NullNode<T extends Comparable<? super T>> extends Node<T> {

	public NullNode() {
		super(null, null, null, null, null);
	}

	@Override
	public boolean add(T value, IComparisonStrategy<T> strategy, INode<T> parent) {
		return false;
	}

	@Override
	public boolean contains(T value) {
		return false;
	}

	@Override
	public boolean isNull() {
		return true;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}
}
