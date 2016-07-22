
public class Solution {
	//冒泡排序算法
	public void bubbleSort(int[] testCase){
		if(testCase==null) return;
		int N = testCase.length;
		for(int i=N-1;i>=1;i--){
			//冒泡到达的位置
			for(int j=0;j<i;j++){
				//如果顺序不对则交换
				if(testCase[j]>testCase[j+1]){
					swap(testCase,j,j+1);
				}
			}
		}
		
	}
	
	//插入排序
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
	//选择排序
	public void selectSort(int[] testCase){
		if(testCase==null) return;
		int N = testCase.length;
		for(int i=0;i<N-1;i++){
			//设置第i个位置为之后最小值
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
	
	//快速排序
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
	//找到分割线的位置
	public int partition(int[] testCase,int start,int end){
		int l = start,r=end;
		//以第一个元素作为主元
		int temp = testCase[start];
		
		while(l<r){
			//从右到左找到第一个小于temp的值给l
			while(l<r){
				if(testCase[r]>=temp){
					r--;
				}else{
					testCase[l] = testCase[r];
					break;
				}
			}
			
			//从左到右找到第一个大于tenp的值给r
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
	//以随机一个元素作为主元
	public int partition2(int[] testCase,int start,int end){
		//获取随机index
		int randIndex = (int)Math.random()*(end-start+1) + start;
		//首先与首位换一下
		swap(testCase,start,randIndex);
		return  partition(testCase,start,end);
	}
	//选择最后一个元素作为主元
	public int partition3(int[] testCase,int start,int end){
		int l = start-1,r = start;
		int value = testCase[end];
		for(;r<end;r++){
			if(testCase[r]<value){//找到每一个小于value
				l++;
				swap(testCase,l,r);
			}
		}
		//最后把value放中间
		swap(testCase,l+1,end);
		return l+1;
	}
	
	public void swap(int[] A,int i,int j){
		int temp = A[j];
		A[j] = A[i];
		A[i] = temp;
	}
}
