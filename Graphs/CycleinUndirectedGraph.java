import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   
     /* Using BFS (DFS can also be  used but algo will be diff)  If cycle is there then one vertex will always be there which will come in the queue twice , lets sya for the first time we process it and mark as visited , so for the second time we will know that it is already visited thus confirming the cycle*/ 
    
     /* This finds cycle in a graph but in case the graph is not connected then we need to run BFS or DFS for every unvisited vertex */
    static boolean isCyclic(ArrayList<Edge>[] graph, int vtces){
        
        //running bfs for every vertex
       boolean visited[]= new boolean[vtces];
       for(int i=0;i<vtces;i++){
           if(visited[i]==false){
               
               if(cycleInComponent(graph,vtces,visited,i)==true){
                   return true;
               }
           }
           
       }
       return false;
        
    }
    
    public static boolean cycleInComponent(ArrayList<Edge>[] graph, int vtces,boolean vis[], int currentVertex){
        
         boolean visited[]= new boolean [vtces];
      Queue<Integer> myqueue= new LinkedList();
       myqueue.add(currentVertex);
       while(myqueue.size()>0){
           
           int ret= myqueue.remove();
            vis[ret]=true;
           if(visited[ret]==true){
               return true;
           }
          
           visited[ret]=true;
           for(int i=0;i<graph[ret].size();i++){
               Edge cur= graph[ret].get(i);
               if(visited[cur.nbr]==false){
               myqueue.add(cur.nbr);
               }
               
           }
           
          
       }
      return false;
        
        
        
    }
    
    
   

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

       System.out.println(isCyclic(graph,vtces));
       
   
   
   
   
   }
}