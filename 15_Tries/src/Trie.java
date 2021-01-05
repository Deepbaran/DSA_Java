
class TrieNode {
	
	char data;
	boolean isTerminating;
	TrieNode[] children;
	int childCount;
	
	public TrieNode(char data) {
		this.data = data;
		isTerminating = false; // false -> word does not end here. true -> It is the last letter of one word.
		children = new TrieNode[26]; // For 26 letters
		childCount = 0;
	}
	
}

public class Trie {
	
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode('\0'); // root is initiated as null
	}
	
	private void add(TrieNode root, String word) {
		 if(word.isEmpty()) {
			 root.isTerminating = true;
			 return;
		 }
		 int childIndex = word.charAt(0) - 'a';
		 TrieNode child = root.children[childIndex];
		 if(child == null) {
			 child = new TrieNode(word.charAt(0));
			 root.children[childIndex] = child;
			 root.childCount++;
		 }
		 add(child, word.substring(1));
	}
	
	public void add(String word) {
		add(root, word);
	}
	
	
	private boolean search(TrieNode root, String word) {
		if(word.isEmpty()) {
			return root.isTerminating;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null) {
			return false;
		}
		return search(child, word.substring(1));
	}
	
	public boolean search(String word) {
		return search(root, word);
	}
	
	
	private void remove(TrieNode root, String word) {
		if(word.isEmpty()) {
			root.isTerminating = false;
			return;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null) {
			return;
		}
		remove(child, word.substring(1));
		// We can remove child if it is non terminating and it's number of children are 0
		if(!child.isTerminating && child.childCount == 0) {
			root.children[childIndex] = null;
			child = null;
			root.childCount--;
		}
		
//		if(!child.isTerminating) {
//			int numChild = 0;
//			for(int i = 0; i < 26; i++) {
//				numChild++;
//			}
//			if(numChild == 0) {
//				// We can delete child
//				root.children[childIndex] = null;
//				child = null;
//				// If nothing is referring a data in the memory then that data will automatically be removed by the Garbage collector which runs periodically.
//				root.childCount--;
//			}
//		}
	}
	
	public void remove(String word) {
		remove(root, word);
	}
	
}

/*
The main reason of using Trie over hashmap is better Space Complexity and faster searching

Trie is actually a string algorithm

There are two types of tries:
1. Compressed Trie --> better space optimization
2. Suffix Tries (add all possible suffix of the word) --> faster string pattern matching
*/
