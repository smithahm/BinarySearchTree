
public interface INode<T extends Comparable<? super T>> {

	public T getData();

	public void setData(T data);

	public INode<T> getLeft();

	public void setLeft(INode<T> left);

	public INode<T> getRight();

	public void setRight(INode<T> right);

	public INode<T> getParent();

	public void setParent(INode<T> parent);

	public boolean add(T value, IComparisonStrategy<T> strategy, INode<T> parent);

	public boolean contains(T value);

	public INode<T> find(T value);

	public boolean isNull();

	public boolean isLeaf();

	public IComparisonStrategy<T> getComparator();

	public void setComparator(IComparisonStrategy<T> strategy);
}
