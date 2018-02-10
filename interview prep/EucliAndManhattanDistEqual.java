import java.util.*;
public class EucliAndManhattanDistEqual {


public static void calcDist(int arr[][]) {
	int count=0;
	for(int i=0;i<arr.length;i++) {
		for(int j=i+1;j<arr.length;j++) {
			double a2 = Math.pow((arr[i][0]-arr[j][0]),2);
			double b2 = Math.pow((arr[i][1]-arr[j][1]),2);
			double a1= Math.abs(arr[i][0]-arr[j][0]);
			double b1 = Math.abs(arr[i][1]-arr[j][1]);
			if((a2+b2) ==Math.pow(a1+b1,2))
				count++;
		}
	}
	System.out.println(count);
}
public static void main(String [] args) {
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
int arr[][] = new int[n][2]; 
for(int i=0; i<n;i++) {
	arr[i][0] = sc.nextInt();
	arr[i][1] = sc.nextInt();
}
 calcDist(arr);
}
}