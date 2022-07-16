import java.util.*;
import java.lang.Math;

class UndirectedGraph {
    private LinkedList<Integer> adj[];

    public UndirectedGraph(int vertices) {
        adj = new LinkedList[vertices];
        for(int i = 0; i<vertices; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int source, int destination) {
        adj[source].add(destination);
        adj[destination].add(source);
    }

    public int bfs(int source, int destination) {
        boolean vis[] = new boolean[adj.length];
        int parent[] = new int[adj.length];
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(source);
        vis[source] = true;
        parent[source] = -1;

        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr == destination) break;

            for(int neighbour: adj[source]){
                if(!vis[neighbour]){
                    vis[neighbour] = true;
                    q.add(neighbour);
                    parent[neighbour] = curr;
                }
            }
        } 

        int curr = destination;
        int distance = 0;

        while(parent[curr] != -1){
            System.out.print(curr + " --> ");
            curr = parent[curr];
            distance++;
        }

        return distance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices and edges: ");
        int v = sc.nextInt();
        int e = sc.nextInt();

        UndirectedGraph graph = new UndirectedGraph(v);
        for(int i = 0; i< v; i++){
            int source = sc.nextInt();
            int destination = sc.nextInt();
            graph.addEdge(source,destination);
        }


        System.out.println(graph.bfs(0,4));
    }
}