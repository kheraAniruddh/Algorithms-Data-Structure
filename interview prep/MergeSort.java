import java.io.*;
public class MergeSort {
	static int a[] ={6,5,4,3,2,1};
	static int b[] =  new int[a.length];
	static void mergeSort(int p, int r) {
		int q=-1;
		if(p<r) {
			q =(p+r)/2;
			mergeSort(p,q);
			mergeSort(q+1,r);
			merge(p,q,r);	
		}
	}

	static void merge(int p, int q, int r) {
		int i=p, j=q+1, k=p;
		while(i<=q && j<=r) {
			if(a[i]<=a[j])
				b[k++] = a[i++];
			else
				b[k++] = a[j++];
		}
		while(i<=q) b[k++] =a[i++];
		while(j<=r) b[k++] = a[j++];
		for(int x=p;x<=r;x++)
			a[x] = b[x];

	}	
	public static void main(String[] args) {
		MergeSort.mergeSort(0,a.length-1);
			for(int s=0;s<a.length;s++)
			System.out.print(a[s]+"\t");
	}
}