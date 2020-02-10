/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programsearch;

import static java.lang.Integer.MAX_VALUE;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ganifsusila
 */
public class ProgramSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph g = new Graph(7); 

		g.addEdge(0, 1); 
		g.addEdge(0, 2); 
		g.addEdge(1, 3); 
		g.addEdge(1, 4); 
		g.addEdge(2, 5); 
		g.addEdge(2, 6); 

		
                System.out.println("Breadth First Cost");
		g.BFS(0,3);
                System.out.println("");
                System.out.println("Depth First Cost");
                g.DFS(0);
                
        int adjacency_matrix[][];
        int number_of_vertices;
        int source = 0;
        int destination = 0;
        int distance;
        Scanner scan = new Scanner(System.in);
        try
        {
            System.out.println("");
            System.out.println("Uniform Search Cost");
            System.out.println("Enter the number of vertices");
            number_of_vertices = scan.nextInt();
 
            adjacency_matrix = new int[number_of_vertices + 1][number_of_vertices + 1];
            System.out.println("Enter the Weighted Matrix for the graph");
            for (int i = 1; i <= number_of_vertices; i++)
            {
                for (int j = 1; j <= number_of_vertices; j++)
                {
                    adjacency_matrix[i][j] = scan.nextInt();
                    if (i == j)
                    {
                        adjacency_matrix[i][j] = 0;
                        continue;
                    }
                    if (adjacency_matrix[i][j] == 0)
                    {
                        adjacency_matrix[i][j] = MAX_VALUE;
                    }
                }
            }
 
            System.out.println("Enter the source ");
            source = scan.nextInt();
 
            System.out.println("Enter the destination");
            destination = scan.nextInt();
 
            Uniformcostsearch ucs = new Uniformcostsearch(number_of_vertices);
            distance = ucs.uniformCostSearch(adjacency_matrix,source, destination);
            ucs.printPath();
 
            System.out.println("\nThe Distance between source " + source +
                          " and destination " + destination + " is " + distance);
 
        } catch (InputMismatchException inputMismatch)
        {
            System.out.println("Wrong Input Format");
        }
        scan.close();
    }
}
