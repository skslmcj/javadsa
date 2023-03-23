package graph;

public class CheckPaths {

        public static boolean isPathExists(Graph g, int source, int destination){
            if(source == destination)
                return true;

            boolean[] visited = new boolean[g.vertices];
            Stack<Integer> stack = new Stack(g.vertices);
            stack.push(source);
            visited[source] = true;

            while(!stack.isEmpty()){
                int current_node = stack.pop();

                DoublyLinkedList<Integer>.Node temp = null;
                if(g.adjacencyList[current_node] != null)
                    temp = g.adjacencyList[current_node].headNode;
                
                while(temp != null){
                    if(!visited[temp.data]){
                        if(temp.data == destination)
                            return true;
                        stack.push(temp.data);
                        visited[temp.data] = true;
                    }

                    temp = temp.nextNode;
                }
            }
            return false;
        }


        public static void main(String args[]) {
    
        Graph g1 = new Graph(9);
        g1.addEdge(0,2);
        g1.addEdge(0,5);
        g1.addEdge(2,3);
        g1.addEdge(2,4);
        g1.addEdge(5,3);
        g1.addEdge(5,6);
        g1.addEdge(3,6);
        g1.addEdge(6,7);
        g1.addEdge(6,8);
        g1.addEdge(6,4);
        g1.addEdge(7,8);
        g1.printGraph();
        System.out.println("Path exists: " + isPathExists(g1, 0, 7));
        System.out.println();
        Graph g2 = new Graph(4);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.addEdge(1,3);
        g2.addEdge(2,3);

        g2.printGraph();
        System.out.println("Path exists: " + isPathExists(g2, 3, 0));
  }
}