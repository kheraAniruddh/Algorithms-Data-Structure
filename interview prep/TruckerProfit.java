import java.io.*;
import java.util.*;

class TruckerProfit {

	class Cargo {
		private int cargoNo;
		private int weight;
		private int profit;

		public Cargo(int cargoNo, int weight, int profit) {
			this.cargoNo = cargoNo;
			this.weight = weight;
			this.profit = profit;
		}

	}

	public static List<Integer> maxProfit(List<Cargo> cargos, int maxWt) {
		/*
		Maximize profit such that it is within constraint of maxwt.
		Order the output as per the input
		else -1
		*/
		
		List<Integer> result = new ArrayList<>();
		int dp[][] = new int[cargos.size()+1][maxWt+1];

		for(int i=0;i<dp.length;i++){
			for(int j=0;j<dp[0].length;j++){
				if(i==0||j==0)
					dp[i][j]=0;
				else if(cargos.get(i-1).weight <= j)
					dp[i][j] = Math.max(dp[i-1][j], cargos.get(i-1).profit+dp[i-1][j-cargos.get(i-1).weight]);
				else
					dp[i][j] =dp[i-1][j];
			}
		}
		int maxProfit = dp[dp.length-1][dp[0].length-1];
		int wt = maxWt;
		for(int i= dp.length-1;i>0 && maxProfit>0;i--) {
			if(maxProfit==dp[i-1][wt])
				continue;
			else {
				result.add(cargos.get(i-1).cargoNo);
				maxProfit -= cargos.get(i-1).profit;
				wt-= cargos.get(i-1).weight;
			}
		}
		if (result.size() == 0) 
			result.add(0);
		else
			result.add(dp[dp.length-1][dp[0].length-1]);
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int maxWt = sc.nextInt();
		int noOfItems = sc.nextInt();
		int entries = sc.nextInt();
		List<Cargo> cargos = new ArrayList<>();
		sc.nextLine();
		for(int i=0;i<noOfItems;i++) {
			String entry = sc.nextLine();
			String[] tokens = entry.split(" ");
			cargos.add(new TruckerProfit().new Cargo(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2])));
		}
		List<Integer> res = maxProfit(cargos, maxWt);
		int[] output = new int[res.size()]; 
		int j= res.size()-1;
		if(res.size()>1) {
			for(int i: res) 
				output[j--] = i;
			for(int i=1;i<output.length;i++)
				System.out.println(output[i]);
			System.out.println(output[0]);
		}
		else 
			System.out.println(res.get(0));	
	}

	}