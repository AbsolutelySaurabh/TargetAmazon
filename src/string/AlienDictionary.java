/**
 * @author AbsolutelySaurabh
 */
package string;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.Math.min;

public class AlienDictionary {

    /*
    Algorithm:
    form a graph out of each subsequent arr[i], make graph until arr[i] char == arr[i+1] char
    topological sort.
     */

    static class Graph{
        LinkedList<Integer> list[];

        public Graph(int vertices){
            list = new LinkedList[vertices];
            for(int i = 0; i<list.length; i++){
                list[i] = new LinkedList<>();
            }
        }

        void addEdge(int a, int b){
            list[a].add(b);
        }

    }

    static Stack<Integer> stack;
    static boolean visited[];
    static Graph graph;

    public static void dfs(int src){

        System.out.println("src: " + src);
        visited[src] = true;
        for(int child: graph.list[src]){
            if(!visited[child]){
                dfs(child);
            }
        }
        stack.push(src);
    }

    public static void topologicalSort(Graph graph){

        for(int i = 0; i<graph.list.length; i++){
            if(!visited[i]){
                dfs(i);
            }
        }

        //print stack
        System.out.println("Alien Dictionary: ");
        while(!stack.isEmpty()){
            System.out.print((char)('a' + stack.pop()) + " ");
        }
    }

    public static void alienLang(String[] arr, int alphabet){

        stack = new Stack<>();
        visited = new boolean[26];
        graph = new Graph(alphabet);

        for(int i = 0; i<arr.length-1; i++){

            String a = arr[i];
            String b = arr[i+1];

            for(int j = 0; j<min(a.length(), b.length()); j++){

                if(a.charAt(j)!=b.charAt(j)){
                    graph.addEdge(a.charAt(j) - 'a', b.charAt(j)- 'a');
                    break;
                }
            }
        }
        topologicalSort(graph);

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        while(test > 0){

            int n = s.nextInt();
            s.nextLine();
            String arr[] = new String[n];

            for(int i = 0; i<n; i++){
                arr[i] = s.nextLine();
            }

            int alphabet = s.nextInt();

            System.out.println("test: " + test + " n: " + n + " arr[i]: " + arr[0] + " alphabet: " + alphabet);
            alienLang(arr, alphabet);

            test--;
        }    }


}
