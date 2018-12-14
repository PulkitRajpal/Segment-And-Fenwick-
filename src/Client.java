
public class Client {

	public static void main(String[] args) {
		int[] arr = { 2,-5, 4, 11, -7, 6, 3, 8 };

		FenwickTree st = new FenwickTree(arr);
		
//		st.display();
		System.out.println("----------------------------");
//		st.update(4, 13);
//		st.display();
		System.out.println(st.query(2, 4));
	}
	private static class SumrangeOperator implements Irangeoperator{
		@Override
		public int operation(int op1,int op2){
			return op1+op2;
		}
		@Override
		public int identityvalue(){
			return 0;
		}
	}

	private static class Min implements Irangeoperator{
		@Override
		public int operation(int op1,int op2){
			return Math.min(op1, op2);
		}
		@Override
		public int identityvalue(){
			return Integer.MAX_VALUE;
		}
	}

}
