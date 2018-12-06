import java.util.*;

class StackingBoxes {
	public class Box {
		int len;
		int wid;
		int area;
		public Box(int len, int wid) {
			this.len = len;
			this.wid =wid;
			area = len * wid;
		}
	}
	public class BoxComp implements Comparator<Box> {
		@Override 
		public int compare(Box b1, Box b2) {
			if(b1.area>b2.area) return 1;
			if(b1.area<b2.area) return -1;
			return 0;
		}
	}
	public int stackBoxes(int[][] inp) {
		Box[] boxes = new Box[inp.length];
		for(int i=0;i<inp.length;i++) {
			boxes[i] = new Box(inp[i][0], inp[i][1]);
		}

		Arrays.sort(boxes, new BoxComp());
		int lenMax =0, widMax=0;
		int [] dp = new int[boxes.length];
		for(int i=0;i<dp.length;i++) dp[i]=1;

		for(int i=1;i<dp.length;i++) {
			for(int j=0;j<i;j++) {
				if(boxes[i].len > boxes[j].len)
					dp[i] = dp[j]+1;
			}
		}
			
		lenMax=dp[boxes.length-1];

		System.out.println(lenMax);

		dp = new int[boxes.length];
		for(int i=0;i<dp.length;i++) dp[i]=1;

		for(int i=1;i<dp.length;i++) {
			for(int j=0;j<i;j++) {
				if(boxes[i].wid > boxes[j].wid)
					dp[i] = dp[j]+1;
			}
		}
		widMax=dp[boxes.length-1];

		System.out.println(widMax);
		return Math.min(widMax, lenMax); 
	}

	public static void main(String[] args) {
		System.out.println(new StackingBoxes().stackBoxes(new int[][] {{2,4}, {4,5}, {4,7}, {5,7} ,{6,7}}));
	}
}