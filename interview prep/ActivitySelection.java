import java.util.*;

class ActivitySelection {

	public static void select(int start[], int finish[]) {
		int last = 0;
		for(int i =0;i< finish.length;i++) {
			if(i==0 || start[i]>=last) {
				last =finish[i];
				System.out.println("Activity: "+start[i] +"-> "+ finish[i]);
			}
		}
	}
	public static void main(String[] args) {
		
		int start[] = {1,3,0,5,8,5};
		int finish[] = {2,4,6,7,9,9};
		System.out.println("Activities selected");
		select(start, finish);
	}
}