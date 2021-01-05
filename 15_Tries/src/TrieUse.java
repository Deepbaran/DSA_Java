
public class TrieUse {

	public static void main(String[] args) {
		Trie t = new Trie();
		t.add("this");
		t.add("news");
		System.out.println(t.search("news")); // true
		System.out.println(t.search("new")); // false
		t.remove("news");
		t.remove("new");
		System.out.println(t.search("news")); // false
		System.out.println(t.search("new")); // false
	}

}
