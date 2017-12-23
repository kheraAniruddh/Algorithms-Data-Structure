import java.util.List;
import java.util.ArrayList;
class Palindrome {
  public static boolean is_numeric_palindrome(long number) {
    List<Long> list = new ArrayList<>();
    while(number!=0) {
        list.add(number%10);
        number/=10;
    }
  int i =0;
  int size = list.size();
  while(i<size/2) {
    if(list.get(i) == list.get(size-i-1))
        i++;
    else
        return false;
 }
 return true;
  }

  public static void main(String[] args) {
    System.out.println(Palindrome.is_numeric_palindrome(010));
  }  
}  
