
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

public class Solution {
	//Ã°ÅÝÅÅÐòËã·¨
	public void bubbleSort(int[] testCase){
		if(testCase==null) return;
		int N = testCase.length;
		for(int i=N-1;i>=1;i--){
			//Ã°ÅÝµ½´ïµÄÎ»ÖÃ
			for(int j=0;j<i;j++){
				//Èç¹ûË³Ðò²»¶ÔÔò½»»»
				if(testCase[j]>testCase[j+1]){
					swap(testCase,j,j+1);
				}
			}
		}
		
	}
	
	//²åÈëÅÅÐò
	public void insertSort(int[] testCase){
		if(testCase==null) return;
		int N = testCase.length;
		for(int i=1;i<N;i++){
			int j =i-1;
			int temp = testCase[i];
			for(j=i-1 ;j>=0;j--){
				if(temp<=testCase[j]){
					testCase[j+1] = testCase[j];
				}else{
					break;
				}
			}
			testCase[j+1] = temp;	
		}
	}
	//Ñ¡ÔñÅÅÐò
	public void selectSort(int[] testCase){
		if(testCase==null) return;
		int N = testCase.length;
		for(int i=0;i<N-1;i++){
			//ÉèÖÃµÚi¸öÎ»ÖÃÎªÖ®ºó×îÐ¡Öµ
			int min = testCase[i];
			int index = i;
			for(int j=i+1;j<N;j++){
				if(testCase[j]<min){
					min = testCase[j];
					index = j;
				}
			}
			swap(testCase,i,index);
		}
	}
	
	//¿ìËÙÅÅÐò
	public void quickSort(int[] testCase){
		if(testCase==null) return;
		int N = testCase.length;
		quickSort(testCase,0,N-1);
	}
	public void quickSort(int[] testCase,int start,int end){
		if(start>=end){
			return ;
		}
		int p = partition3(testCase,start,end);
		quickSort(testCase,start,p-1);
		quickSort(testCase,p+1,end);
	}
	//ÕÒµ½·Ö¸îÏßµÄÎ»ÖÃ
	public int partition(int[] testCase,int start,int end){
		int l = start,r=end;
		//ÒÔµÚÒ»¸öÔªËØ×÷ÎªÖ÷Ôª
		int temp = testCase[start];
		
		while(l<r){
			//´ÓÓÒµ½×óÕÒµ½µÚÒ»¸öÐ¡ÓÚtempµÄÖµ¸øl
			while(l<r){
				if(testCase[r]>=temp){
					r--;
				}else{
					testCase[l] = testCase[r];
					break;
				}
			}
			
			//´Ó×óµ½ÓÒÕÒµ½µÚÒ»¸ö´óÓÚtenpµÄÖµ¸ør
			while(l<r){
				if(testCase[l]<=temp){
					l++;
				}else{
					testCase[r] = testCase[l];
					break;
				}
			}
		}
		testCase[l] = temp;
		return l;
	}
	//ÒÔËæ»úÒ»¸öÔªËØ×÷ÎªÖ÷Ôª
	public int partition2(int[] testCase,int start,int end){
		//»ñÈ¡Ëæ»úindex
		int randIndex = (int)Math.random()*(end-start+1) + start;
		//Ê×ÏÈÓëÊ×Î»»»Ò»ÏÂ
		swap(testCase,start,randIndex);
		return  partition(testCase,start,end);
	}
	//Ñ¡Ôñ×îºóÒ»¸öÔªËØ×÷ÎªÖ÷Ôª
	public int partition3(int[] testCase,int start,int end){
		int l = start-1,r = start;
		int value = testCase[end];
		for(;r<end;r++){
			if(testCase[r]<value){//ÕÒµ½Ã¿Ò»¸öÐ¡ÓÚvalue
				l++;
				swap(testCase,l,r);
			}
		}
		//×îºó°Ñvalue·ÅÖÐ¼ä
		swap(testCase,l+1,end);
		return l+1;
	}
	
	public void swap(int[] A,int i,int j){
		int temp = A[j];
		A[j] = A[i];
		A[i] = temp;
	}
}
