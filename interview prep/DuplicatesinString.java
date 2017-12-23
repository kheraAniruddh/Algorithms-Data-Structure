import java.util.*;

class DuplicatesinString {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		String in1 = sc.nextLine();

		char[] newin1 = in1.toCharArray();
		int [] intin1 = new int[256];
		StringBuilder sb = new StringBuilder();
		for(int i =0;i<newin1.length;i++) {
			if(intin1[newin1[i]]==0) {
				sb.append(newin1[i]);
				intin1[newin1[i]]+=1;
			}

		}

		System.out.println(sb);
	

	}
}