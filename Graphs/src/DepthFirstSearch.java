import java.util.LinkedList;
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

    private static void printDepthFirstSearch(LinkedList<Integer>[] graph, boolean[] visited, int currentNode) {
        LinkedList<Integer> nodeConnections = graph[currentNode];
        visited[currentNode] = true;
        System.out.print(currentNode + " ");
        for (int next : nodeConnections) {
            if (!visited[next]) {
                printDepthFirstSearch(graph, visited, next);
            }
        }
    }

    private static void printDepthFirstSearch(LinkedList<Integer>[] graph, int startNode) {
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

    private static void depthFirstSearchUsingAdjacencyMatrix(Scanner scanner) {
        AdjacencyMatrixGraph adjacencyMatrix = new AdjacencyMatrixGraph();
        adjacencyMatrix.inputAdjacencyMatrix(scanner);
        System.out.println("Adjacency Matrix is:");
        adjacencyMatrix.printAdjacencyMatrix();
        System.out.println("Enter start node");
        int startNode = scanner.nextInt();
        System.out.println("Depth First Search Traversal is:");
        printDepthFirstSearch(adjacencyMatrix.graph, startNode);
    }

    private static void depthFirstSearchUsingAdjacencyList(Scanner scanner) {
        AdjacencyListGraph adjacencyList = new AdjacencyListGraph();
        adjacencyList.inputAdjacencyList(scanner);
        System.out.println("Adjacency List is:");
        adjacencyList.printAdjacencyList();
        System.out.println("Enter start node");
        int startNode = scanner.nextInt();
        System.out.println("Depth First Search Traversal is:");
        printDepthFirstSearch(adjacencyList.graph, startNode);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the DS to use\n1 - AdjacencyList\n2 - Adjacency Matrix");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                depthFirstSearchUsingAdjacencyList(scanner);
                break;
            case 2:
                depthFirstSearchUsingAdjacencyMatrix(scanner);
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }
}
