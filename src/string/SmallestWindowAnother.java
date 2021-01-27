/**
 * @author AbsolutelySaurabh
 */
package string;

import java.util.HashMap;
import java.util.Scanner;

public class SmallestWindowAnother {

    public static String shortestWindow(String str, String pat){

        HashMap<Character, Integer> str_map = new HashMap<>();
        HashMap<Character, Integer> pat_map = new HashMap<>();
        HashMap<Character, Integer> temp_pat_map = new HashMap<>();

        int unique;
        for(int i = 0; i<pat.length(); i++){
            if(pat_map.get(pat.charAt(i)) == null){
                pat_map.put(pat.charAt(i), 1);
                temp_pat_map.put(pat.charAt(i), 1);
            }else{
                pat_map.put(pat.charAt(i), pat_map.get(pat.charAt(i)) + 1);
                temp_pat_map.put(pat.charAt(i), temp_pat_map.get(pat.charAt(i)) + 1);
            }
        }
        unique = pat.length();

        int start = 0;
        int count = 0;
        int min_len = Integer.MAX_VALUE;
        String ans = "";

        System.out.println("random: " + pat_map.get('b'));

        for(int i = 0; i<str.length(); i++){

            Integer temp = str_map.get(str.charAt(i));
            if(temp == null){
                str_map.put(str.charAt(i), 1);
            }else{
                str_map.put(str.charAt(i), str_map.get(str.charAt(i)) + 1);
            }
            if(temp_pat_map.get(str.charAt(i)) != null) {
                if (temp_pat_map.get(str.charAt(i)) > 0) {
                    count++;
                    temp_pat_map.put(str.charAt(i), temp_pat_map.get(str.charAt(i)) - 1);
                }
            }

            if(count == unique){

                //window found
                System.out.println("window found: " + start + "  end: " + i);
                //minimise window
                while (pat_map.get(str.charAt(start)) == null || str_map.get(str.charAt(start)) > pat_map.get(str.charAt(start))) {

                    System.out.println("start: " + start + " " +  str.charAt(start) + " str_map: " + str_map.get(str.charAt(start)) + " " + str.charAt(start) + " " + pat_map.get(str.charAt(start)));
                    if(pat_map.get(str.charAt(start))!=null && str_map.get(str.charAt(start)) > pat_map.get(str.charAt(start))) {
                        str_map.put(str.charAt(start), str_map.get(str.charAt(start)) - 1);
                    }
                    start++;
                }
                System.out.println("minimised to: " + start + " end: " + i);

                //capture the min window
                if((i - start) + 1 < min_len){
                    min_len = (i - start) + 1;
                    ans = str.substring(start, i+1);
                    System.out.println("window string: " + ans + " start: " + start + " end: " + i);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        s.nextLine();
        while(test > 0){

            String str = s.nextLine();
            String pat = s.nextLine();
            System.out.println("ans: " + shortestWindow(str, pat));
            test--;

        }

    }


}
