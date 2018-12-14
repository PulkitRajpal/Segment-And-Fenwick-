
public class SegmentTree {
	private class Node {
		int data;
		int rsi;
		int rei;
		Node left;
		Node right;
	}

	Node root;

	public SegmentTree(int[] arr) {
		this.root = this.construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int low, int high) {
		if (low == high) {
			Node bnode = new Node();
			bnode.rei = high;
			bnode.rsi = low;
			bnode.data = arr[low];
			return bnode;
		}
		Node node = new Node();
		int mid = (low + high) / 2;
		node.rsi = low;
		node.rei = high;
		node.left = this.construct(arr, low, mid);
		node.right = this.construct(arr, mid + 1, high);
		node.data = node.left.data + node.right.data;
		return node;
	}

	public void update(int idx, int delta) {
		updata(root, idx, delta);
	}

	private void updata(Node node, int idx, int delta) {
		if (idx <= node.rei && idx >= node.rsi) {
			if (node.rsi == node.rei) {
				node.data += delta;
			} else {
				updata(node.left, idx, delta);
				updata(node.right, idx, delta);
				node.data = node.left.data + node.right.data;
			}
		}
	}
	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}
		String str = " ";
		if (node.left == null) {
			str += " =>";

		} else {
			str += node.left.data + "=>";
		}
		str += node.data;
		if (node.right == null) {
			str += " <=";

		} else {
			str += "<=" + node.right.data;
		}
		System.out.println(str);

		display(node.left);
		display(node.right);
	}
	public int query(int si,int ei){
		return aquery(root, si, ei);
	}
	private int aquery(Node node ,int si, int ei){
		if(node.rei<si||node.rsi>ei){
			return 0;
		}else if(node.rsi>=si&&node.rei<=ei){
			return node.data;
		}else{
		
			int leftans = aquery(node.left, si, ei);
			int rightans = aquery(node.right, si, ei);
			return leftans+rightans;
		//overlap
		}
	}
}
