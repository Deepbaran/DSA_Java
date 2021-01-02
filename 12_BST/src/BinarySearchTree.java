
public class BinarySearchTree {
	
	private BinaryTreeNode<Integer> root; // null
	
	private BinaryTreeNode<Integer> insertData(int data, BinaryTreeNode<Integer> root) {
		if(root == null) {
			BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(data);
			return newNode;
		}
		if(data > root.data) { // greater than
			root.right = insertData(data, root.right);
			return root;
		} else { // less than or equal to
			root.left = insertData(data, root.left);
			return root;
		}
	}
	
	public void insertData(int data) { // O(h)
		root = insertData(data, root);
	}
	
	private BinaryTreeNode<Integer> deleteData(int data, BinaryTreeNode<Integer> root) {
		if(root == null) {
			return null;
		}
		if(data > root.data) {
			root.right = deleteData(data, root.right);
			return root;
		} else if(data < root.data) {
			root.left = deleteData(data, root.left);
		} else {
			if(root.left == null && root.right == null) {
				return null;
			} else if(root.left == null) {
				return root.right;
			} else if(root.right == null) {
				return root.left;
			} else {
				// Replace root with the left most child of the right subtree from the root
				BinaryTreeNode<Integer> minNode = root.right;
				while(minNode.left != null) {
					minNode = minNode.left;
				}
				root.data = minNode.data;
				root.right = deleteData(minNode.data, root.right);
				return root;
			}
		}
		return root;
	}
	
	public void deleteData(int data) { // O(h)
		root = deleteData(data, root);
	}
	
	private void printTree(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		String toBePrinted = root.data + " ";
		if(root.left != null) {
			toBePrinted += "L:" + root.left.data + ",";
		}
		if(root.right != null) {
			toBePrinted += "R:" + root.right.data;
		}
		System.out.println(toBePrinted);
		printTree(root.left);
		printTree(root.right);
	}
	
	public void printTree() {
		printTree(root);
	}
	
	private boolean hasData(int data, BinaryTreeNode<Integer> root) {
		if(root == null) {
			return false;
		}
		if(root.data == data) {
			return true;
		} else if(data > root.data) {
			// call right
			return hasData(data, root.right);
		} else {
			// call left
			return hasData(data, root.left);
		}
	}
	
	public boolean hasData(BinaryTreeNode<Integer> root, int data) { // O(h)
		return hasData(data, root);
	}
	
}

/*
Balanced Tree:
For every node, |(height of node's left sub tree) - (height of node's right sub tree)| <= 1

For improved performance in a BST, the BST should be balanced

Height of a balanced BST is, h = O(logn) (approx.)
Thus means that for a balanced BST, Search, insertion and deletion, everything will be of O(logn)

Balanced BST:
1. AVL Tree* <- Important
2. Red Black Tree
3. 2 - 4 Tree
*/
