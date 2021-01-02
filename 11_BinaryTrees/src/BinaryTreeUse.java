import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse {

	// Recursive Input
	private static BinaryTreeNode<Integer> takeInput(Scanner s) {
		int rootData;
		System.out.println("Enter root data ");
		rootData = s.nextInt();
		if(rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		root.left = takeInput(s);
		root.right = takeInput(s);	
		return root;
	}
	
	// Recursive Print
	private static void printTree(BinaryTreeNode<Integer> root) {
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
	
	// Levelwise Input (Iterative)
	private static BinaryTreeNode<Integer> takeInputLevelWise(Scanner s) {
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		System.out.println("Enter root");
		int rootData = s.nextInt();
		if(rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> front = pendingNodes.poll();
			System.out.println("Enter left child of " + front.data);
			int leftChild = s.nextInt();
			if(leftChild != -1) {
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(leftChild);
				pendingNodes.add(child);
				front.left = child;
			}
			System.out.println("Enter right child of " + front.data);
			int rightChild = s.nextInt();
			if(rightChild != -1) {
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(rightChild);
				pendingNodes.add(child);
				front.right = child;
			}
		}
		return root;
	}
	
	// Levelwise Print (Iterative)
	private static void printTreeLevelWise(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			BinaryTreeNode<Integer> node = q.poll();
			String output = node.data + " ";
			if(node.left != null) {
				output += "L:" + node.left.data + ",";
				q.add(node.left);
			}
			if(node.right != null) {
				output += "R:" + node.right.data;
				q.add(node.right);
			}
			System.out.println(output);
		}
	}
	
	// Height of Binary Tree
	private static int height(BinaryTreeNode<Integer> root) { // O(n)
		if(root == null) {
			return 0;
		}
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	// Diameter of a Binary Tree [Brute Force]
	public static int diameter(BinaryTreeNode<Integer> root) { // O(n * h) [n->number of nodes; h->height of the tree]
		if (root == null) {
			return 0;
		}
		
		int option1 = height(root.left) + height(root.right); // O(h)
		int option2 = diameter(root.left); // diameter of the left subtree
		int option3 = diameter(root.right); // diameter of the right subtree
		return Math.max(option1, Math.max(option2, option3));
	}
	
	// Diameter of a Binary Tree [Optimised]
	public static Pair<Integer, Integer> heightDiameter(BinaryTreeNode<Integer> root) { // O(n)
		if(root == null) {
			Pair<Integer, Integer> output = new Pair<>();
			output.first = 0;
			output.second = 0;
			return output;
		}
		Pair<Integer,Integer> lo = heightDiameter(root.left);
		Pair<Integer,Integer> ro = heightDiameter(root.right);
		int height = 1 + Math.max(lo.first, ro.first);
		int option1 = lo.first + ro.first;
		int option2 = lo.second;
		int option3 = ro.second;
		int diameter = Math.max(option1, Math.max(option2, option3));
		Pair<Integer, Integer> output = new Pair<>();
		output.first = height;
		output.second = diameter;
		return output;
	}
	
	// Inorder Traversal
	private static void inorder(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	// Preorder Traversal
	private static void preorder(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}
	
	// Postorder Traversal
	private static void postorder(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");
	}
	
	public static void main(String[] args) {
		
//		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
//		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(2);
//		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(3);
//		root.left = node1;
//		root.right = node2;
		
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInputLevelWise(s);
		printTreeLevelWise(root);
		System.out.println("Height: " + height(root));
		System.out.println("Diameter: " + diameter(root));
		System.out.println("Height: " + heightDiameter(root).first);
		System.out.println("Diameter: " + heightDiameter(root).second);
		s.close();
	}

}
