package dictionaryelev;

public class DictionaryBST<K extends Comparable<K>, V> implements Dictionary<K, V> {

	private Node root;

	public DictionaryBST() {
		root = null;
	}

	@Override
	public V get(K key) {
		if (root != null) {
			return get(key, root);
		}

		return null;
	}

	private V get(K key, Node root) {
		int comp = root.key.compareTo(key);

		if (comp == 0) {
			return root.value;
		} else if (comp > 0) {
			if (root.left != null) return get(key, root.left);
		} else {
			if (root.right != null) return get(key, root.right);
		}
		return null;
	}

	private NodePair find(K key) {
		boolean found = false;
		Node parent = null;
		Node current = root; // Start from the root
		while (!found && current != null) {
			int d = current.key.compareTo(key);
			if (d == 0) {
				found = true;
			} else if (d > 0) {
				parent = current;
				current = current.left;
			} else {
				parent = current;
				current = current.right;
			}
		}
		return new NodePair(current, parent);
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public V put(K key, V value) {
		Node nyNode = new Node(key, value);

		if (root == null) {
			root = nyNode;
		}

		return put(nyNode, root);
	}

	private V put(Node node, Node root) {
		int comp = root.key.compareTo(node.key);

		if (comp == 0) {
			V result = root.value;
			root.key = node.key;
			root.value = node.value;
			return result;
		}

		if (comp > 0) {
			if (root.left != null) return put(node, root.left);
			else root.left = node;
		}

		if (comp < 0) {
			if (root.right != null) return put(node, root.right);
			else root.right = node;
		}

		return null;
	}

	@Override
	public V remove(K key) {
		NodePair pair = find(key);
		V del = null;
		boolean found = true;
		if (pair.current == null) {
			found = false;
		} else {
			Node current = pair.current;
			Node parent = pair.parent; // may be null
			del = current.value;
			// Case 1: current has no left child
			if (current.left == null) {
				// Connect the parent with the right child of the current node
				if (parent == null) {
					root = current.right;
				} else {
					if (key.compareTo(parent.key) < 0)
						parent.left = current.right;
					else
						parent.right = current.right;
				}
			} else {
				// Case 2: The current node has a left child
				// Locate the rightmost(biggest) node in the left subtree of
				// the current node and also its parent
				Node parentOfRightMost = current;
				Node rightMost = current.left;

				if (rightMost.right == null) { // special case: no node to the right of rightMost
					current.value = rightMost.value;
					current.key = rightMost.key;
					current.left = rightMost.left;
				} else {
					while (rightMost.right != null) {
						parentOfRightMost = rightMost;
						rightMost = rightMost.right; // keep going to the right
					}
					// Replace the element in current by the element in rightMost.
					current.value = rightMost.value;
					current.key = rightMost.key;
					// Eliminate rightmost node.
					parentOfRightMost.right = rightMost.left;
				}
			}
		}
		return del;
	}

	@Override
	public int size() {
		return size(root);
	}

	private int size(Node root) {
		if (root != null) {
			int left = size(root.left);
			int right = size(root.right);
			return left + right + 1;
		}
		return 0;
	}

	private class Node {
		private K key;
		private V value;
		private Node left;
		private Node right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}


	}
	private class NodePair {
		private Node current;
		private Node parent;

		public NodePair(Node current, Node parent) {
			this.current = current;
			this.parent = parent;
		}
	}
}
