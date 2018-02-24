import java.util.*;
public class MinDist1d {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int arr[] =new int[n];
		sc.nextLine();
		String input = sc.nextLine(); 
		int temp= Integer.MAX_VALUE;
		int j=0;
		String[] tokens = input.split(" ");
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(tokens[i]);
			j+=2;
		}
		for(int i=0;i<n;i++) {
			if(arr[i] !=0 && arr[i] <=k) {
				if(temp > Math.abs(i-(m-1)))
					temp = Math.abs(i-(m-1));
			}
		//	System.out.print(arr[i]+" ");
		}
		System.out.println(temp*10);
	}
}