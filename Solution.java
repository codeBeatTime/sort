
public class Solution {

	//------------冒泡排序算法---------------------------------
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

	//------------插入排序---------------------------------
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

	//------------选择排序---------------------------------
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
	
	//------------快速排序---------------------------------
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

	//------------选择随机主元

	public int partition2(int[] testCase,int start,int end){
		//获取随机index
		int randIndex = (int)Math.random()*(end-start+1) + start;
		//首先与首位换一下
		swap(testCase,start,randIndex);
		return  partition(testCase,start,end);
	}

	//------------选择最后一个元素作为主元

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
	
	//------------堆排序---------------------------------
	public void heapSort(int[] testCase){
		if(testCase==null) return;
		int N = testCase.length;
		//构造堆
		for(int i=0;i<=N-1;i++){
			//第i个位置已经插入了
			//上浮
			swim(testCase,i,i);
		}
		//不断取出大顶放在末尾
		for(int i=N-1;i>=1;i--){
			swap(testCase,0,i);
			//长度此时改为i-1
			sink(testCase,0,i-1);
		}
	}
	//上浮函数
	public void swim(int[] testCase,int k,int N){
		while((k-1)/2>=0 && testCase[k]>testCase[(k-1)/2]){
			swap(testCase,k,(k-1)/2);
			k = (k-1)/2;
		}
		
	}
	//下沉
	public void sink(int[] testCase,int k,int N){
		while(2*k+1<=N){
			int j = 2*k+1;
			if(j+1<=N && testCase[j]<testCase[j+1]) j++;
			if(testCase[k]>testCase[j]){
				break;
			}else{
				swap(testCase,k,j);
				k = j;
			}
		}
	}
	//------------归并排序---------------------------------
	public void mergeSort(int[] testCase){
		if(testCase==null) return;
		int N = testCase.length;
		int l =0,r = N-1;
	    mergeSort(testCase,l,r);
	}
	//每一次将数组分为两部分[l,m][m+1,r],然后合并
	public void mergeSort(int[] testCase,int l,int r){
		if(l>=r)return;
		int middle = (l+r)/2;
		mergeSort(testCase,l,middle);
		mergeSort(testCase,middle+1,r);
		merge(testCase,l,middle,r);
	}
	//合并数组[l,m][m+1,r]
	public void merge(int[] testCase,int l,int m,int r){
		int N = r-l+1;
		if(N==1) return ;
		int index1 = l;
		int index2 = m+1;
		int indexT = 0;
		int[] temp = new int[N];
		while(index1<=m && index2<=r){
			if(testCase[index1]<testCase[index2]){
				temp[indexT++] = testCase[index1++];
			}else{
				temp[indexT++] = testCase[index2++];
			}
		}
		while(index1<=m){
			temp[indexT++] = testCase[index1++];
		}
		while(index2<=r){
			temp[indexT++] = testCase[index2++];
		}
		for(int i=0;i<N;i++){
			testCase[l+i] = temp[i];
		}
	}
	
	public void swap(int[] A,int i,int j){
		int temp = A[j];
		A[j] = A[i];
		A[i] = temp;
	}
}
