
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		int[][] testCase = new int[N][];
		testCase[0] = new int[]{5,4,3,2,1};
		testCase[1] = new int[]{3,3,3,3,3};
		testCase[2] = new int[]{2};
		testCase[3] = new int[]{1,20,1000,30,40,100000,50};
		testCase[4] = new int[]{1,2,3,4,5};
		int[][] result = new int[N][];
		result[0] = new int[]{1,2,3,4,5};
		result[1] = new int[]{3,3,3,3,3};;
		result[2] = new int[]{2};
		result[3] = new int[]{1,20,30,40,50,1000,100000};
		result[4] = new int[]{1,2,3,4,5};
		Solution s = new Solution();
		boolean flag = isOk(testCase,result);
		System.out.println("最终结果： "+ flag);
		
	}
	//测试多组测试数据是否正确
	static boolean isOk(int[][] testCase,int [][] result){
		if(testCase==null && result==null) return true;
		if(testCase==null || result==null) return false;
		if(testCase.length!=result.length) return  false;
		for(int i=0; i<result.length;i++){
			//冒泡排序算法
			//new Solution().bubbleSort(testCase[i]);
			//插入排序算法
			//new Solution().insertSort(testCase[i]);
			//选择排序
			//new Solution().selectSort(testCase[i]);
			//快速排序
			new Solution().quickSort(testCase[i]);
			boolean flag = isSame(testCase[i],result[i]);
			System.out.println("case:   "+ i);
			if(flag){
				
				System.out.println("flag:   "+ flag);
				System.out.print("正确结果：");
				print(testCase[i]);
			}else{
				System.out.println("flag:   "+flag);
				System.out.print("期待结果：");
				print(result[i]);
				System.out.print("你的结果：");
				print(testCase[i]);
				return false;
			}
			System.out.println("-------------------------------");
		}
			
		return true;
	}
	//判断一组测试数据是否正确
    static boolean isSame(int A[],int B[]){
    	if(B==null && A==null) return true;
    	if(B==null || A==null) return false;
    	if(A.length!=B.length){
    		return false;
    	}
    	for(int i=0;i<A.length;i++){
    		if(A[i]!=B[i]) return false;
    	}
    	return true;
    }
    static void print(int[] A){
    	for(int i=0;i<A.length;i++){
    		System.out.print(A[i]+" ");
    	}
    	System.out.println();
    }

}
