import java.util.Scanner;

public class DepthFirstSearch {
    private static void printDepthFirstSearch(boolean[][] graph, boolean[] visited, int currentNode) {
        int totalNodes = graph.length;
        boolean[] nodeConnections = graph[currentNode];
        visited[currentNode] = true;
        System.out.print(currentNode + " ");
        for (int i = 0; i < totalNodes; i++) {
            if (nodeConnections[i] && !visited[i]) {
                printDepthFirstSearch(graph, visited, i);
            }
        }
    }

    private static void printDepthFirstSearch(boolean[][] graph, int startNode) {
        int totalNodes = graph.length;

        boolean[] visited = new boolean[totalNodes];

        for (int i = 0; i < totalNodes; i++) {
            int currentNode = startNode + i < totalNodes ? startNode + i : startNode + i - totalNodes;
            if (!visited[currentNode]) {
                printDepthFirstSearch(graph, visited, currentNode);
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
        System.out.println("Depth First Search Traversal is:");
        printDepthFirstSearch(adjacencyMatrix.graph, startNode);
    }
}
