
public class Segment {
	private class Node {
		int sei;
		int ssi;
		int data;
		Node left;
		Node right;
	}

	private Node root;
	private int size;
	Irangeoperator rop;// segment tree dependency

	public Segment(int[] arr, Irangeoperator rop) {
		this.rop = rop;
		this.root = construct(arr, 0, arr.length - 1);

	}

	// dependency injection by making it in construct
	private Node construct(int[] arr, int ssi, int sei) {
		if (ssi == sei) {
			Node node = new Node();
			this.size++;
			node.ssi = ssi;
			node.sei = sei;
			node.data = arr[ssi];
			return node;
		}
		Node node = new Node();
		this.size++;
		int mid = (ssi + sei) / 2;
		node.left = construct(arr, ssi, mid);
		node.right = construct(arr, mid + 1, sei);
		node.ssi = ssi;
		node.sei = sei;
		node.data = rop.operation(node.left.data, node.right.data);
		return node;
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}
		String str = "";
		str += node.left == null ? "." : node.left.data;
		str += "->" + node.data + "[" + node.ssi + " , " + node.sei + "] <-";
		str += node.right == null ? "." : node.right.data;
		System.out.println(str);
		display(node.left);
		display(node.right);
	}

	public void update(int idx, int nv) {
		update(idx, nv, root);
	}

	private void update(int idx, int nv, Node node) {
		if (node == null) {
			return;
		}
		if (idx <= node.sei && idx >= node.ssi) {
			if (node.sei == node.ssi) {
				node.data = nv;
			} else {
				update(idx, nv, node.left);
				update(idx, nv, node.right);
				node.data = rop.operation(node.left.data, node.right.data);
			}
		}
	}

	public int query(int qsi, int qei) {
		return query(qsi, qei, root);
	}

	private int query(int qsi, int qei, Node node) {
		if (node == null) {
			return rop.identityvalue();
		}
		if (node.sei <= qei && node.ssi >= qsi) {
			return node.data;
		} else if (node.ssi > qei || node.sei < qsi) {
			return rop.identityvalue();
		} else {
			int lans = query(qsi, qei, node.left);
			int rans = query(qsi, qei, node.right);
			return rop.operation(lans, rans);
		}
	}

}
