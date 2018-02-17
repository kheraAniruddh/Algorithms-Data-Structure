import java.util.*;

class Account implements Comparable<Account> {
			String accno;
			int count;

		public int compareTo(Account that) {
			if(this.count <that.count)
				return -1;
			if(this.count == that.count)
				return 0;
			else
				return 1;
		}	
}

public class BankAccountSort {

		public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		List<List<Account>> fina = new ArrayList<>();
		for(int i=0;i <t;i++) {
			int n = sc.nextInt();
			Map<String, Integer> map = new HashMap<>();
			for(int j=0;j<n;j++) {
				String acc = sc.nextLine();
				if(map.containsKey(acc))
					map.put(acc,map.get(acc)+1);
				else
					map.put(acc,1);
			}
			List<Account> list = new ArrayList<>(); 
			for(String s: map.keySet()) {
				Account acc = new Account();
				acc.accno = s;
				acc.count = map.get(s);
				list.add(acc);
			}
		fina.add(list);
		sc.nextLine();
	}
	for(List<Account> list: fina) {
			Collections.sort(list);
			for(Account acc: list) 
				System.out.println(acc.accno+ " "+acc.count);
			System.out.println();
	}
}
}

