/**
 * This is a head Node class and operations which represents root node in the
 * binary search tree
 */
public class HeadNode<T extends Comparable<? super T>> extends NullNode<T> {

	public HeadNode() {
		super();
	}

	@Override
	public boolean add(T value, IComparisonStrategy<T> strategy, INode<T> parent) {
		if (this.getParent() == null && this.getData() == null) {
			this.setData(value);
			return true;
		} else {
			int comparisionResult = compare(this.getData(), value);
			if (comparisionResult > 0) {
				return this.getLeft().add(value, strategy, this);
			} else {
				return this.getRight().add(value, strategy, this);
			}
		}
	}

	@Override
	public boolean contains(T value) {
		if (this.getParent() == null && this.getData() == null) {
			return false;
		}
		int comparisionResult = compare(this.getData(), value);
		if (comparisionResult == 0) {
			return true;
		} else if (comparisionResult > 0) {
			return this.getLeft().contains(value);
		} else {
			return this.getRight().contains(value);
		}
	}

	@Override
	public INode<T> find(T value) {
		if (this.getParent() == null && this.getData() == null) {
			return this;
		}
		int comparisionResult = compare(this.getData(), value);
		if (comparisionResult == 0) {
			return this;
		} else if (comparisionResult > 0) {
			return this.getLeft().find(value);
		} else {
			return this.getRight().find(value);
		}
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

}
