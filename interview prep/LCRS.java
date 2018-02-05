//Longest Repeated sup-sebequence with restriction that the index shouldn't be same of a char in the seq

class LCRS {
	public static String findLRS(char[] arr) {
		int tab[][] = new int[arr.length+1][arr.length+1];
		StringBuilder result=new StringBuilder("");
		for(int i=0;i<arr.length+1;i++) {
			for(int j=0;j<arr.length+1;j++) {
				if(i==0||j==0) 
					tab[i][j] = 0;
				else {
					if(arr[i-1] == arr[j-1] && i-1!=j-1) {
						tab[i][j] = 1+ tab[i-1][j-1];
					}
					else
						tab[i][j] = Math.max(tab[i-1][j], tab[i][j-1]);
				}
			}
		}

		int i=arr.length,j=arr.length;
		while(i>0 && j>0) {
			if(tab[i][j]==1+ tab[i-1][j-1]) {
				result.append(arr[i-1]);
				i--;j--;
			}
			else if(tab[i][j]==tab[i-1][j])
				i--;
			else
				j--;
		}

		return result.reverse().toString();
	}
	public static void main(String[] args) {
		 String str = "AABEBCDD";
		 char [] arr = str.toCharArray();
		 System.out.println(findLRS(arr));
		
	}
}