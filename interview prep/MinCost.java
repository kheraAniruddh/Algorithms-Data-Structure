class MinCost {

	// Non-dynamic programming, recomputing same sub-paths for different routes
	public static int findMinCost(int m[][],int i,int j) {
		if(i==0 && j==0)
			return m[i][j];
		if(i==0)
			return m[i][j] += findMinCost(m,i,j-1);
		if(j==0)
			return m[i][j] += findMinCost(m,i-1,j);

		if(m[i-1][j] < m[i][j-1]) {
			if(m[i-1][j] <m[i-1][j-1])
				return m[i][j] += findMinCost(m,i-1,j);
			else
				return m[i][j] += findMinCost(m,i-1,j-1);
		}
		else {

			if(m[i][j-1] < m[i-1][j-1])
				return m[i][j] += findMinCost(m,i,j-1);
			else
				return m[i][j] += findMinCost(m,i-1,j-1);
		}
	}	

	// Dynamic Programming
	public static int findMinCost(int m[][]) {
		 int cost[][] = new int[3][3];
		 cost[0][0] = m[0][0];
		 for(int i=1;i<3;i++)
		 	cost[i][0] += cost[i-1][0] + m[i][0];

		 for(int j=1;j<3;j++)
		 	cost[0][j] += cost[0][j-1]+ m[0][j];

		 // These 2 are sufficient to construct the entire matrix

		 for(int i=1;i<3;i++){
		 	for(int j=1;j<3;j++) {
		 		cost[i][j] = min(cost[i-1][j],cost[i][j-1],cost[i-1][j-1])+ m[i][j];
		 	}
		 }
		 return cost[2][2];		  
		}

	public static int min(int a, int b, int c) {
		if(a<b && a<c)
			return a;
		if(b<a && b<c)
			return b;
		else
			return c;
	}	

	public static void main(String[] args) {
		int m[][] = { {1, 2, 3},
                      {4, 8, 2},
                      {1, 5, 3} };             
		System.out.println(findMinCost(m));
	}
}