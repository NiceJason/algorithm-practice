import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int maxLength = 0;
        int nowLength = 0;
        Set<Character> wordSet= new HashSet<>();
        for(int i =0;i<str.length();i++){
            char word = str.charAt(i);

            if(!wordSet.contains(word)){
                ++nowLength;
                wordSet.add(word);
            }else{
                if(nowLength>maxLength){
                    maxLength = nowLength;
                }
                nowLength = 0;
                wordSet.clear();
            }
        }
        //最后判断
        if(nowLength>maxLength){
            maxLength = nowLength;
        }
        System.out.println(maxLength);
    }
}