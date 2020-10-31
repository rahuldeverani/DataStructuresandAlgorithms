import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
    // question is we have a source , we know that spread of disease flow from one to other in 1 unit of time , find th no of people having disease after k units of time

  static class Pair{
      
      int src;
      int time;
      Pair(int time , int src){
          this.src=src;
          this.time=time;
      }
      
      
  }
  
  
  
  
  
  static int findInfectedNo(ArrayList<Edge>[] graph, int vtces, int time , int src){
      
        int currTime=1;
        int no=0; 
        Queue<Pair> bfs= new LinkedList();
        
        bfs.add(new Pair(currTime,src));
        boolean visited [] =new boolean[vtces];
        
        while(bfs.size()>0){
            
            Pair ret=bfs.remove();
            
            if(ret.time>time){
                break;
            } //make sure to check if it is already not visited in order to find the closest node from src
            else if(visited[ret.src]==false){
                no++;
            }
             visited[ret.src]=true;
            
            for(int i=0;i<graph[ret.src].size();i++){
                
                int neibr= graph[ret.src].get(i).nbr;
                if(visited[neibr]==false){
                    
                    bfs.add(new Pair(ret.time+1,neibr));
                }
                
            }
            
    
        }
      
      return no;
      
      
      
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      int t = Integer.parseInt(br.readLine());
      
         // can be solved using bfs
         
         System.out.println(findInfectedNo(graph,vtces,t,src));
        
      
      
      
      
   }

}