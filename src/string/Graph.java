/**
 * @author AbsolutelySaurabh
 */
package string;

// A Java program to order of
// characters in an alien language
import java.util.*;



public class Graph
{
    // This function fidns and prints order
    // of characer from a sorted array of words.
    // alpha is number of possible alphabets
    // starting from 'a'. For simplicity, this
    // function is written in a way that only
    // first 'alpha' characters can be there
    // in words array. For example if alpha
    // is 7, then words[] should contain words
    // having only 'a', 'b','c' 'd', 'e', 'f', 'g'
    private static void printOrder(String[] words, int alpha)
    {
        // Create a graph with 'aplha' edges
        Graph1 graph = new Graph1(alpha);

        for (int i = 0; i < words.length - 1; i++)
        {
            // Take the current two words and find the first mismatching
            // character
            String word1 = words[i];
            String word2 = words[i+1];
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++)
            {
                // If we find a mismatching character, then add an edge
                // from character of word1 to that of word2
                if (word1.charAt(j) != word2.charAt(j))
                {
                    graph.addEdge(word1.charAt(j) - 'a', word2.charAt(j)- 'a');
                    break;
                }
            }
        }

        // Print topological sort of the above created graph
        graph.topologicalSort();
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        printOrder(words, 4);
    }

    // Class to represent a graph
    static class Graph1
    {

        // An array representing the graph as an adjacency list
        private final LinkedList<Integer>[] adjacencyList;

        Graph1(int nVertices)
        {
            adjacencyList = new LinkedList[nVertices];
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)
            {
                adjacencyList[vertexIndex] = new LinkedList<Integer>();
            }
        }

        void printLL(){
            for(int i = 0; i<adjacencyList.length; i++){
                System.out.print(i + 'a'  + " --> ");
                for(int j = 0; j<adjacencyList[i].size(); j++){
                    System.out.print(adjacencyList[i].get(j) + 'a' + " ");
                }
                System.out.println();
            }
        }

        // function to add an edge to graph
        void addEdge(int startVertex, int endVertex)
        {
            System.out.println("add edge: " + startVertex + " -> " + endVertex);
            adjacencyList[startVertex].add(endVertex);
        }

        private int getNoOfVertices()
        {
            return adjacencyList.length;
        }

        // A recursive function used by topologicalSort
        private void topologicalSortUtil(int currentVertex, boolean[] visited,
                                         Stack<Integer> stack)
        {
            // Mark the current node as visited.
            visited[currentVertex] = true;

            // Recur for all the vertices adjacent to this vertex
            for (int adjacentVertex : adjacencyList[currentVertex])
            {
                if (!visited[adjacentVertex])
                {
                    topologicalSortUtil(adjacentVertex, visited, stack);
                }
            }

            // Push current vertex to stack which stores result
            stack.push(currentVertex);
        }

        // prints a Topological Sort of the complete graph
        void topologicalSort()
        {
            Stack<Integer> stack = new Stack<>();

            // Mark all the vertices as not visited
            boolean[] visited = new boolean[getNoOfVertices()];
            for (int i = 0; i < getNoOfVertices(); i++)
            {
                visited[i] = false;
            }

            // Call the recursive helper function to store Topological
            // Sort starting from all vertices one by one
            for (int i = 0; i < getNoOfVertices(); i++)
            {
                if (!visited[i])
                {
                    topologicalSortUtil(i, visited, stack);
                }
            }

            // Print contents of stack
            while (!stack.isEmpty())
            {
                System.out.print((char)('a' + stack.pop()) + " ");
            }
            printLL();
        }
    }


}

//Contributed by Harikrishnan Rajan
