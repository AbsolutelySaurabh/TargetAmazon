/**
 * @author AbsolutelySaurabh
 */
package string;

import java.util.Scanner;

public class AllPossibleStringWithSpaces {

    /*
    Eg: ABC --> ABC; AB, C; A, BC; A, B, C
     */
    public static void allPossibleStringsWithSpaces(String string, int index, int strIndex, char buf[]){

        if(strIndex == string.length()){
            //print buf[]
            for(int i = 0; i<index; i++){
                System.out.print(buf[i] + " ");
            }
            System.out.println();
            return;
        }

        buf[index] = string.charAt(strIndex);
        allPossibleStringsWithSpaces(string, index+1, strIndex+1, buf);

        index++;
        buf[index] = ' ';

        if(strIndex == string.length()-1){
            //to avoid repetitive steps
            return;
        }

        allPossibleStringsWithSpaces(string, index+1, strIndex+1, buf);

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        s.nextLine();
        while(test > 0){

            String str = s.nextLine();
            allPossibleStringsWithSpaces(str, 0, 0, new char[2*str.length()]);

            test--;
        }
    }

}
