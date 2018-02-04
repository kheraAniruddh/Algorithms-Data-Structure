//Longest Repeated sup-sebequence with restriction that the index shouldn't be same of a char in the seq

class LCRS {
	public static int findLRS(char[] arr) {
		int tab[][] = new int[arr.length+1][arr.length+1];
		for(int i=0;i<arr.length+1;i++) {
			for(int j=0;j<arr.length+1;j++) {
				if(i==0||j==0) 
					tab[i][j] = 0;
				else {
					if(arr[i-1] == arr[j-1] && i-1!=j-1)
						tab[i][j] = 1+ tab[i-1][j-1];
					else
						tab[i][j] = Math.max(tab[i-1][j], tab[i][j-1]);
				}
			}
		}

		return tab[arr.length][arr.length];
	}
	public static void main(String[] args) {
		 String str = "aab";
		 char [] arr = str.toCharArray();
		 System.out.println(findLRS(arr));
		
	}
}