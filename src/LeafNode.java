
public class LeafNode<T extends Comparable<? super T>> extends NullNode<T> {

	public LeafNode() {
		super();
	}

	@Override
	public boolean add(T value, IComparisonStrategy<T> strategy, INode<T> parent) {
		return privateAdd(value, strategy, parent);
	}

	@Override
	public boolean contains(T value) {
		return false;
	}

	@Override
	public INode<T> find(T data) {
		return this;
	}

	@Override
	public boolean isLeaf() {
		return true;
	}
}
