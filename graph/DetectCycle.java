package graph;

public class DetectCycle {
        public static boolean detectCycle(Graph g){
            if(g.vertices < 1){
                return false;
            }
            boolean[] visited = new boolean[g.vertices];
            boolean[] flag = new boolean[g.vertices];
            for(int i = 0; i < g.vertices; i++){
                if(isCyclic(g, i, visited, flag)){
                    return true;
                }
            }
            return false;
        }

        public static boolean isCyclic(Graph g, int source, boolean[] visited, boolean[] flag){
            if(flag[source]){
                return true;
            }
            if(visited[source]){
                return false;
            }
            visited[source] = true;
            flag[source] = true;
            DoublyLinkedList<Integer>.Node temp = null;
            if(g.adjacencyList[source] != null){
                temp = g.adjacencyList[source].headNode;
            }

            while(temp != null){
                if(isCyclic(g, temp.data, visited, flag)){
                    return true;
                }
                temp = temp.nextNode;
            }

            flag[source] = false;

            return false;
        }

        public static void main(String args[]) {
        Graph g1 = new Graph(4);
        g1.addEdge(0,1);
        g1.addEdge(1,2);
        g1.addEdge(1,3);
        g1.addEdge(3,0);
        g1.printGraph();
        System.out.println(detectCycle(g1));

        System.out.println();
        Graph g2 = new Graph(3);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.printGraph();
        System.out.println(detectCycle(g2));
  }
}