
import java.util.*;
class Move0 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i =0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int i=0, j=n-1;
		while(i<j) {
			if(arr[i]==0 && arr[j]!=0) {
				arr[i] = arr[j];
				arr[j] =0;
				i++;
				j--;
			}
			else {
				if(arr[j]==0)
					j--;
				else	
					i++;
			}
		}
		int k =0;
		while(k<n){
			System.out.print(arr[k]+" ");
			k++;
	}
}
}