import java.util.*;
import java.io.*;

public class FloydWarshall {
    final static int INF = 99999, V = 7;
    int[][] dist = new int[V][V];

    void floydWarshall(int graph[][]) {
        int i, j, k;

        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        printSolution();
    }

    void printSolution() {
        System.out.println("Following matrix shows the shortest "+
                "distances between every pair of vertices");
        for (int i=0; i<V; ++i) {
            for (int j=0; j<V; ++j) {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }

    public static void main (String[] args) {
        int graph[][] = { {0, 7, 3, INF, INF, INF, INF},
                        {INF, 0, INF, 8, INF, INF, INF},
                        {INF, INF, 0, INF, 2, INF, INF},
                        {INF, INF, INF, 0, INF, 4, INF},
                        {INF, INF, INF, INF, 0, 3, 2},
                        {INF, INF, INF, INF, INF, 0, 6},
                        {INF, INF, INF, INF, INF, INF, 0}
        };
        FloydWarshall a = new FloydWarshall();

        a.floydWarshall(graph);
    }
}
