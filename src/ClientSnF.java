
public class ClientSnF {

	public static void main(String[] args) {
		int[] arr = { 2, 5, -4, 16, 7, 1, 9 };
		/*
		 * SegmentTree st = new SegmentTree(arr); System.out.println(st.query(2,
		 * 5)); System.out.println(st.query(4, 6)); st.update(3, 9);
		 * System.out.println(st.query(2, 5)); System.out.println(st.query(4,
		 * 6));
		 */
		Fenwick ft = new Fenwick(arr);
		System.out.println(ft.getsum(2, 5));
	}
}
