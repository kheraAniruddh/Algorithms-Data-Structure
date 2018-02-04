import java.util.*;
class LCS {

	public static int findLCS(char[] x, char[] y) {
		int tab[][] = new int[x.length+1][y.length+1];
		List<Character> rev = new ArrayList<>();
		for(int i=0;i<tab.length;i++){
			for(int j=0;j<tab[0].length;j++) {
				if(i==0 || j==0)
					tab[i][j] = 0;
				else if(x[i-1] == y[j-1])
					tab[i][j] = tab[i-1][j-1]+1;
				else
					tab[i][j] = Math.max(tab[i-1][j], tab[i][j-1]);

			} 
		}

		return tab[x.length][y.length];
	}	
	public static void main(String[] args) {
		String s1 = "AGGTAB";
    	String s2 = "GXTXAYB";
    	char[] x=s1.toCharArray();
    	char[] y=s2.toCharArray();
    	System.out.println(findLCS(x,y));
	}
}