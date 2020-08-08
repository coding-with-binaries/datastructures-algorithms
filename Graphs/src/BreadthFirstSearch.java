import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearch {
    private static void printBreadthFirstSearch(boolean[][] graph, boolean[] visited, int startNode) {
        int totalNodes = graph.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;
        while (!queue.isEmpty()) {
            int currentNode = queue.remove();
            System.out.print(currentNode + " ");
            boolean[] nodeConnections = graph[currentNode];

            for (int j = 0; j < totalNodes; j++) {
                if (nodeConnections[j] && !visited[j]) {
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }
    }

    private static void printBreadthFirstSearch(boolean[][] graph, int startNode) {
        int totalNodes = graph.length;

        boolean[] visited = new boolean[totalNodes];

        for (int i = 0; i < totalNodes; i++) {
            int currentNode = startNode + i < totalNodes ? startNode + i : startNode + i - totalNodes;
            if (!visited[currentNode]) {
                printBreadthFirstSearch(graph, visited, currentNode);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdjacencyMatrixGraph adjacencyMatrix = new AdjacencyMatrixGraph();
        adjacencyMatrix.inputAdjacencyMatrix(scanner);
        System.out.println("Adjacency Matrix is:");
        adjacencyMatrix.printAdjacencyMatrix();
        System.out.println("Enter start node");
        int startNode = scanner.nextInt();
        System.out.println("Breadth First Search Traversal is:");
        printBreadthFirstSearch(adjacencyMatrix.graph, startNode);
    }
}
