import java.util.LinkedList;
import java.util.Scanner;

public class AdjacencyListGraph {
    private LinkedList<Integer>[] graph;

    private void inputAdjacencyList(Scanner scanner) {
        System.out.println("Enter the number of vertices");
        int V = scanner.nextInt();
        graph = new LinkedList[V];

        for (int i = 0; i < V; i++) {
            System.out.println("Enter the connected nodes for vertex: " + i);
            graph[i] = new LinkedList<>();
            int edgeVertex;
            do {
                edgeVertex = scanner.nextInt();
                if (edgeVertex != -1) {
                    graph[i].add(edgeVertex);
                }
            } while (edgeVertex != -1);
        }
    }

    private void printAdjacencyList() {
        int V = graph.length;
        for (int i = 0; i < V; i++) {
            System.out.println(i + " -> " + graph[i].toString());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdjacencyListGraph adjacencyListGraph = new AdjacencyListGraph();
        adjacencyListGraph.inputAdjacencyList(scanner);
        System.out.println("Entered Graph is:");
        adjacencyListGraph.printAdjacencyList();
    }
}
