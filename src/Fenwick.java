
public class Fenwick {
	int[] farr;
	public Fenwick(int[]arr){
		farr = new int [arr.length+1];
		for(int i = 0;i<arr.length;i++){
			update(i, arr[i]);
		}
		
	}
	public void update(int idx,int delta){
		idx+=1;
		while(idx<farr.length){
			farr[idx] += delta;
			idx+=getLastSetBit(idx);
		}
	}
	public int getsum(int i , int j){
		int rt = getPrefixSum(j);
		int im1 = getPrefixSum(i-1);
		return rt - im1;
	}
	
	private int getPrefixSum(int idx){
		idx+=1;
		int sum =0;
		while(idx!=0){
			sum+=farr[idx];
			idx-= getLastSetBit(idx);
		}
		return sum;
	}
	private int getLastSetBit(int a){
		return a&-a;
	}
}
