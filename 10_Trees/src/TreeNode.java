import java.util.ArrayList;

public class TreeNode<T> {
	public T data; // by default 0
	public ArrayList<TreeNode<T>> children; // by default null
	
	public TreeNode(T data) {
		this.data = data;
		children = new ArrayList<>();
	}
}
