import java.util.*;

class Sort {

	public static int[] selectionSort(int arr[]) {
		for(int i =0;i<arr.length-1;i++) {
			int temp=arr[i];
			for(int j=i+1;j<arr.length;j++) {
				if(temp > arr[j]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		return arr;
	}

	public static int[] bubbleSort(int arr[]) {
		for(int i =0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				int temp=arr[j];
				if(temp > arr[j+1]) {
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

	public static int[] insertionSort(int arr[]) {
		for(int i =1;i<arr.length;i++) {
			int key = arr[i];
			int j =i-1;
			while(j>=0 && arr[j]>key) {
					arr[j+1] = arr[j];
					j--;
				}
			arr[j+1] =key;	
			}
		return arr;
	}

	public static void quickSort(int arr[], int p, int r) {
		if(p<r) {
		int q = partition(arr, p, r);
		quickSort(arr,p,q-1);
		quickSort(arr,q+1,r);
		}
	}


	public static int partition(int arr[], int p , int r) {
		int i =p-1;
		int pivot = arr[r];
		for(int j=p;j<r;j++) {
			if(arr[j]<=pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = pivot;
		arr[r] = temp;
		return i+1;

	}

	public static void mergeSort(int arr[],int p, int r) {
		if(p<r) {
		int q = (p+r)/2;
		mergeSort(arr,p,q);
		mergeSort(arr,q+1,r);
		merge(arr,p,q,r);
		}
	}

	public static void merge(int arr[], int p, int q, int r) {
		int left[] = new int[q-p+1];
		int right[] = new int[r-q];

		for(int i=0;i<left.length;i++)
			left[i] = arr[p+i];

		for(int i=0; i<right.length;i++)
			right[i] = arr[q+1+i];

		int i=0,j=0,k=p;
		while(i<left.length && j<right.length) {
			if(left[i] <= right[j]) {
				arr[k++] = left[i++];
			}
			else {
				arr[k++] = right[j++];
			}
		}
		while(i<left.length) {
			arr[k++] = left[i++];
		}

		while(j<right.length) {
			arr[k++] = right[j++];
		}

	}


	public static void heapSort(int arr[]) {
		for(int i = arr.length/2-1;i>=0;i--) 
			heapify(arr,arr.length,i);
		for(int i =arr.length-1; i>=0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr,i,0);
		}

	}

	public static void heapify(int arr[], int n,int i) {
		int largest= i;  
        int left = 2*i + 1;  
        int right = 2*i + 2; 
 
        if (left < n && arr[left] > arr[largest])
           largest = left;
 
        if (right < n && arr[right] > arr[largest])
            largest = right;
 
        if (largest != i)
        {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr [] =new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}

		// int newarr[] = selectionSort(arr);
		// int newarr[] = bubbleSort(arr);
		// int newarr[] = insertionSort(arr);
		// for(int i=0;i<newarr.length;i++)
		// 	System.out.print(newarr[i]+"\t");
		
		// mergeSort(arr,0,arr.length-1);
		//quickSort(arr,0,arr.length-1);
		heapSort(arr);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
	}
}