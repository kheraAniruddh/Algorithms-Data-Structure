import java.util.*;

class BinarySearch {


	static int binarySearch(int arr[], int key,int l, int r) {	
    if (r>=l) {
            int mid = l + (r - l)/2;
            if (arr[mid] == key)
               return mid;
            if (arr[mid] > key)
               return binarySearch(arr,key, l, mid-1);
            return binarySearch(arr, key,mid+1, r);
    }
        return -1;
    }

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		int flag = binarySearch(arr,6, 0, arr.length-1);
		if(flag ==-1)
			System.out.println("Not Found");
		else
			System.out.println("Found at index "+flag);
	}	
}