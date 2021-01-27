/**
 * @author AbsolutelySaurabh
 */
package string;

import java.util.Scanner;
import java.util.stream.IntStream;

public class SmallestWindowItself {

    static int countUnique(String str){
        int freq[] = new int[26];
        for(int i = 0; i<26; i++){
            freq[i]  =0;
        }
        int count = 0;
        for(int i = 0; i<str.length(); i++){
            if(freq[i] == 0){
                freq[i]++;
                count++;
            }
        }
        return count;
    }

    public static String smallestWindow(String input){

        int uniqueCount = countUnique(input);
        int start = 0, end = 0;
        int map[] = new int[26];
        for(int i = 0; i<26; i++){
            map[i] = 0;
        }
        int count = 0;
        int maxWindow = -1;
        String ans = "";
        while(end < input.length()){

            int i = input.charAt(start) - 'a';
            map[i]++;

            if(map[i] == 1){
                count++;
            }
            if(count == uniqueCount){

                //start = 0
                while(start < end && map[input.charAt(start) - 'a'] > 1){
                    map[input.charAt(start) - 'a']--;
                    start++;
                }

                //capture the window
                if(end - start > maxWindow){
                    maxWindow = end-start;
                    ans = input.substring(start, end+1);
                }

            }
            end++;
        }
        return ans;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);


    }

}
