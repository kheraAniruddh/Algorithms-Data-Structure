import java.util.List;
import java.util.ArrayList;

class Solution {

    public static int jump_over_numbers(List<Integer> list) {
        int count =0;
        int pos=0;
    while(pos<list.size()) {
        if(list.get(pos) == 0)
            return -1;
        count++;
        pos += list.get(pos); 
    }
    return count;
}
public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(3);
    list.add(4);
    list.add(1);
    list.add(2);
    list.add(5);
    list.add(6);
    list.add(9);
    list.add(0);
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(1);
    System.out.println(Solution.jump_over_numbers(list));
}
}