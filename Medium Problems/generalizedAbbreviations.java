import java.util.*;
public class Solution {

     public static List<String> generateAbbreviations(String word) {
         List<String> result = new ArrayList<>();
         result.add(word);
         backtrack(result, new StringBuilder(), word.toCharArray(), 0, 0);
         return result;
     }
     
     static void backtrack(List<String> result, StringBuilder sb, char[] word, int i, int num) {
         int len = sb.length();
         if(i == word.length) {
            if(num != 0)
                sb.append(num);
            System.out.println(sb.toString());
            result.add(sb.toString());
         } else {
             backtrack(result, sb, word, i+1, num+1);
             if(num != 0)
                sb.append(num);
            backtrack(result, sb.append(word[i]), word, i+1, 0);
         }
         sb.setLength(len);
     }
     public static void main(String []args){
        generateAbbreviations("word");
        
     }
}
