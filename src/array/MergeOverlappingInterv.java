/**
 * @author AbsolutelySaurabh
 */
package array;

import javafx.util.Pair;

import java.util.*;

public class MergeOverlappingInterv {

    public static ArrayList<int[]> merge(ArrayList<int[]> list){

        //sort by start
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int index = 0;
        int temp[] = new int[2];
        ArrayList<int[]> ans = new ArrayList<>();

        int first[] = new int[2];
        int second[] = new int[2];

        int secondIndex = 1;

        first = list.get(0);

        while(secondIndex < list.size()){

            second = list.get(secondIndex);

            if(first[1] > second[0] && first[1] >= second[1]){
                ans.add(first);
            }else
                if(first[1] > second[0] && first[1] < second[1]){
                    int a[] = new int[2];
                    a[0] = first[0];
                    a[1] = second[1];
                    ans.add(a);
                }else{
                    //both different ranges
                    ans.add(first);
                    ans.add(second);
                }
            first = ans.get(ans.size()-1);
            if(secondIndex < list.size()-1) {
                ans.remove(ans.size() - 1);
            }
            secondIndex++;
        }
        return ans;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while(test > 0){

            int n = scanner.nextInt();
            ArrayList<int[]> list = new ArrayList<>();

            while(n > 0) {
                int a[] = new int[2];
                a[0] = scanner.nextInt();
                a[1] = scanner.nextInt();
                list.add(a);
                n--;
            }

            list = merge(list);

            for(int i = 0; i<list.size(); i++){
                System.out.print(list.get(i)[0] + " " + list.get(i)[1] + " ");
            }
            System.out.println();

            test--;
        }
    }
}
