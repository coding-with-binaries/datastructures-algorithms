import java.util.Scanner;

public class AdjacencyMatrixGraph {
    boolean[][] graph;

    public void inputGraph(Scanner scanner) {
        System.out.println("Enter the number of vertices");
        int V = scanner.nextInt();
        graph = new boolean[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.println("Is edge present between vertices: " + i + "," + j);
                graph[i][j] = scanner.nextInt()!=0;
            }
        }
    }

    public void printGraph() {
        int V = graph.length;
        for (int i = 0; i < V; i++) {
            System.out.print(i + " ->");
            for (int j = 0; j < V; j++) {
                if (graph[i][j]) {
                    System.out.print(" " + j);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdjacencyMatrixGraph adjacencyMatrixGraph = new AdjacencyMatrixGraph();
        adjacencyMatrixGraph.inputGraph(scanner);
        System.out.println("Entered Graph is:");
        adjacencyMatrixGraph.printGraph();
    }
}
