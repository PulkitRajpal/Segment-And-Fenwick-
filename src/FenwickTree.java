
public class FenwickTree {
	public int farr[];

	public FenwickTree(int[] arr) {
		farr = new int[arr.length+1];
		for(int i = 0;i<arr.length;i++){
			update(i,arr[i]);
		}
	}
	private void update(int idx, int delta) {
		idx++;
		while(idx<farr.length){
			farr[idx]+=delta;
			idx+=(idx&-idx);
		}
	}
	public int query(int si,int ei){
		return prefixsum(ei)-prefixsum(si-1);
	}
	public int prefixsum(int si) {
		si++;
		int sum = 0;
		while (si > 0) {
			sum += farr[si];
			si -= (si &-si);
		}
		return sum;
	}
}
