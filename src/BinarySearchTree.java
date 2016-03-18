
/**
 *  This program supports Binary search tree insertion, node contains strings, 
 * inorderTraversal() method is used to print the elements in the tree in the alphabetic order. 
 * Duplicate elements are allowed and if found will be inserted in the left subtree. Empty strings are not allowed
 */

import java.util.AbstractCollection;
import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<? super T>> extends AbstractCollection<T> implements Iterable<T> {
	public static void main(String[] args) {

		System.out.println("************************************ Ding ****************************************");
		BinarySearchTree<String> bst = new BinarySearchTree<>();
		BinarySearchTree<String> bst1 = new BinarySearchTree<>();
		System.out.println("empty node" + bst1.contains("Grapefruit"));

		System.out.println("One: Added - " + bst.add("Grapefruit"));
		System.out.println("Two: Added - " + bst.add("pears"));
		System.out.println("Three: Added - " + bst.add("banana"));
		System.out.println("Four: Added - " + bst.add("apple"));
		System.out.println("Five: Added - " + bst.add("Apple"));
		System.out.println("Six: Added - " + bst.add("Fig"));
		System.out.println("Seven: Added - " + bst.add("mango"));
		System.out.println("Seven: Added - " + bst.add("dates"));
		System.out.println("Seven: Added - " + bst.add("raisins"));

		// System.out.println(bst.toString());
		// System.out.println(bst.toString());
		// System.out.println(bst.contains("Seven"));

		System.out.println(bst.toString());
		String[] s = bst.toArray();
		for (String s1 : s) {
			System.out.println("print toArray values" + s1);
		}
		Iterator<String> iterator1 = bst.iterator();
		while (iterator1.hasNext()) {
			System.out.println(iterator1.next());
		}
	}

	INode<T> leaf = new LeafNode<T>();
	INode<T> root;
	int size;

	/**
	 * Comparator used to order the items in the tree. If null, the natural
	 * order of the items will be used.
	 */
	IComparisonStrategy<T> comparator;

	public BinarySearchTree() {
		root = new HeadNode<T>();
		root.setLeft(leaf);
		root.setRight(leaf);
	}

	public BinarySearchTree(IComparisonStrategy<T> comparator) {
		root = new HeadNode<T>();
		root.setLeft(leaf);
		root.setRight(leaf);
		this.root.setComparator(comparator);
		this.comparator = comparator;
	}

	@Override
	public int size() {
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(Object object) {
		if (object == null) {
			return false;
		}
		try {
			T data = (T) object;
			return root.contains(data);
		} catch (ClassCastException e) {
			return false;
		}
	}

	/**
	 * Adds element starting from the root inserting in the list in order.
	 * 
	 * @param element
	 *            to be inserted
	 * @return true if successfully inserted
	 */

	@Override
	public boolean add(T data) {
		if (data instanceof String) {
			if (data.toString().isEmpty())
				return false;
		}
		boolean isAdded = this.root.add(data, this.comparator, this.root);
		if (isAdded) {
			++size;
		}
		return isAdded;
	}

	@Override
	public Iterator<T> iterator() {
		return new BinarySearchTreeIterator<T>(this.root);
	}

	/**
	 * Returns string representation of this Binary search tree
	 */
	@Override
	public String toString() {
		StringBuffer objects = new StringBuffer();
		objects.append("[");
		Iterator<T> iterator = this.iterator();
		while (iterator.hasNext()) {
			objects.append(iterator.next().toString());
			if (iterator.hasNext()) {
				objects.append(", ");
			}
		}
		objects.append("]");
		return objects.toString();
	}

	/**
	 * Returns an array containing all the elements in this tree in the order
	 * returned by in-order traversal of the iterator
	 */
	@Override
	public String[] toArray() {
		String[] result = new String[size];
		Iterator<T> iterator = this.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			result[i++] = (String) iterator.next();
		}
		return result;
	}

}
