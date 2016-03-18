
class Node<T extends Comparable<? super T>> implements INode<T> {

	private INode<T> left, right, parent;
	private T data;
	protected IComparisonStrategy<T> comparator;

	public Node(T value, IComparisonStrategy<T> comparator, INode<T> left, INode<T> right, INode<T> parent) {
		this.data = value;
		this.comparator = comparator;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}

	@Override
	public boolean add(T value, IComparisonStrategy<T> comparator, INode<T> parent) {
		setComparator(comparator);
		while (true) {
			int comparisionResult = compare(this.getData(), data);
			if (comparisionResult > 0) {
				return this.getLeft().add(value, comparator, this);
			} else {
				return this.getRight().add(value, comparator, this);
			}
		}
	}

	boolean privateAdd(T value, IComparisonStrategy<T> comparator, INode<T> parent) {
		setComparator(comparator);
		if (value == null || contains(value))
			return false;
		int comparisionResult = compare(parent.getData(), value);
		if (comparisionResult > 0) {
			if (parent.getLeft().isLeaf()) {
				INode<T> node = new Node<T>(value, comparator, this, this, parent);
				parent.setLeft(node);
			} else {
				parent.getLeft().add(value, comparator, parent.getLeft());
			}
		} else {

			if (parent.getRight().isLeaf()) {
				INode<T> node = new Node<T>(value, comparator, this, this, parent);
				parent.setRight(node);
			} else {
				parent.getRight().add(value, comparator, parent.getLeft());
			}
		}

		return true;
	}

	@Override
	public boolean contains(T data) {
		return find(data) != null;
	}

	@Override
	public INode<T> find(T data) {
		INode<T> current = this;
		while (!current.isNull()) {
			int comparisionResult = compare(current.getData(), data);
			if (comparisionResult == 0) {
				return current;
			} else if (comparisionResult > 0) {
				current = current.getLeft();
			} else {
				current = current.getRight();
			}
		}
		return null;
	}

	public INode<T> getLeft() {
		return left;
	}

	public void setLeft(INode<T> left) {
		this.left = left;
	}

	public INode<T> getRight() {
		return right;
	}

	public void setRight(INode<T> right) {
		this.right = right;
	}

	public INode<T> getParent() {
		return parent;
	}

	public void setParent(INode<T> parent) {
		this.parent = parent;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	protected int compare(T x, T y) {
		if (comparator == null) {
			return x.compareTo(y);
		} else {
			return comparator.compare(x, y);
		}
	}

	@Override
	public boolean isNull() {
		return false;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

	@Override
	public IComparisonStrategy<T> getComparator() {
		return comparator;
	}

	@Override
	public void setComparator(IComparisonStrategy<T> comparator) {
		this.comparator = comparator;
	}

}
