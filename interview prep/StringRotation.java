import java.util.*;
class StringRotation {
    public static boolean rotateString(String A, String B) {
        if(A.length() == B.length()) {
            if(A.equals(B))
                return true;
            int rotations = A.length()-1;
            String temp = A;
            for(int i=0;i<rotations;i++){
                temp = temp.substring(1,temp.length())+(temp.charAt(0));
                System.out.println(temp);
                if(temp.equals(B))
                    return true;
            }
        }
        return false; 
    }
    public static void main(String[] args) {
        System.out.println(rotateString("ABCDE","CDEAB"));
    }

}