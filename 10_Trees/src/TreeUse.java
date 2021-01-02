import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeUse {

	// Recursive Input
	private static TreeNode<Integer> takeInput(Scanner s) {
		int n;
		System.out.println("Enter next node data: ");
		n = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(n);
		System.out.println("Enter number of children for " + n);
		int childCount = s.nextInt();
		for(int i = 0; i < childCount; i++) {
			TreeNode<Integer> child = takeInput(s);
			root.children.add(child);
		}
		return root;
	}
	
	// Recursive Output
	private static void print(TreeNode<Integer> root) {
		String s = root.data + ": ";
		for(int i = 0; i < root.children.size(); i++) {
			s = s + root.children.get(i).data + ", ";
		}
		System.out.println(s);
		for(int i = 0; i < root.children.size(); i++) {
			print(root.children.get(i));
		}
	}

	// Levelwise Input
	private static TreeNode<Integer> takeInputLevelWise() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Root Data: ");
		int rootData = s.nextInt();
		Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
		TreeNode<Integer> root = new TreeNode<>(rootData);
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()) {
			TreeNode<Integer> frontNode = pendingNodes.poll();
			System.out.println("Enter number of children of " + frontNode.data);
			int numChildren = s.nextInt();
			for(int i = 1; i <= numChildren; i++) {
				System.out.println("Enter " + i + "th child of " + frontNode.data);
				int child = s.nextInt();
				TreeNode<Integer> childNode = new TreeNode<Integer>(child);
				frontNode.children.add(childNode);
				pendingNodes.add(childNode);
			}
		}
		return root;
	}
	
	// Levelwise Print
	private static void printLevelWise(TreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		Queue<TreeNode<Integer>> q = new LinkedList<TreeNode<Integer>>();
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode<Integer> node = q.poll();
			System.out.println(node.data);
			for(int i = 0; i < node.children.size(); i++) {
				q.add(node.children.get(i));
			}
		}
	}
	
	// Height of a tree [height of null tree = 0 and height of root = 1]: Level of the node
	// Ask whether root's height is 0 or 1
	private static int height(TreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int h = 0;
		for(int i = 0; i < root.children.size(); i++) {
			h = Math.max(h, height(root.children.get(i)));
		}
		return 1 + h;
	} 
	
	// Print Nodes at a given depth(k)
	private static void printAtK(TreeNode<Integer> root, int k) {
		if(k < 0) {
			return;
		}
		if(k == 0) {
			System.out.print(root.data + " ");
			return;
		}
		for(int i = 0; i < root.children.size(); i++) {
			printAtK(root.children.get(i), k - 1);
		}
	}
	
	// Pre-Order Traversal
	private static void preorder(TreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		for(int i = 0; i < root.children.size(); i++) {
			preorder(root.children.get(i));
		}
	}
	
	// Post-Order Traversal
	private static void postorder(TreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		for(int i = 0; i < root.children.size(); i++) {
			postorder(root.children.get(i));
		}
		System.out.print(root.data + " ");
	}
	
	public static void main(String[] args) {

//		TreeNode<Integer> root = new TreeNode<>(4);
//		TreeNode<Integer> node1 = new TreeNode<>(2);
//		TreeNode<Integer> node2 = new TreeNode<>(3);
//		TreeNode<Integer> node3 = new TreeNode<>(5);
//		TreeNode<Integer> node4 = new TreeNode<>(6);
//		root.children.add(node1);
//		root.children.add(node2);
//		root.children.add(node3);
//		node2.children.add(node4);
//		System.out.println(root);

//		Scanner s = new Scanner(System.in);
//		TreeNode<Integer> root = takeInput(s);
//		print(root);
//		s.close();
		
		TreeNode<Integer> root = takeInputLevelWise();
		printLevelWise(root);
		System.out.println(height(root));
		printAtK(root, 2);
		System.out.println();
		preorder(root);
		System.out.println();
		postorder(root);
		System.out.println();
	}

}

/*
 * Depth of a node:  Distance of the node from root
 * Height Belongs to a Tree but depth belongs to a node.
 * Depth of root is 0
 * 
 * Traversals:
 * Inorder -> L-RT-R
 * Preorder -> RT-L-R
 * Postorder -> L-R-RT
 */