import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt){
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   
   //dfs
   public static boolean hasPathusingDfs(int src ,int dest , ArrayList<Edge> []graph , int vtces,int[] visited){
       
       if(src==dest){
           return true;
       }
       
       ArrayList<Edge> nbrs=graph[src];
       visited[src]=1;
       
       for(int i=0;i<nbrs.size();i++){
           
           if(visited[nbrs.get(i).nbr]==0){
           if(hasPathusingDfs(nbrs.get(i).nbr,dest,graph,vtces,visited)){
               return true;
           }
           }
           
           
       }
       return false;
       
       
       
       
       
       
   }
   
   
   
   
   
   
   
   
   //bfs
   public static boolean hasPath(int src ,int dest , ArrayList<Edge>[] graph,int vtces){
         Queue<Integer> my=new LinkedList();
      int visited[] =new int[vtces];
      if(src==dest){
          return true;
      }
      my.add(src);
      while(my.isEmpty()==false){
          
          int curr=my.remove();
          visited[curr]=1;
          ArrayList<Edge> nb=graph[curr];
          for(int i=0;i<nb.size();i++){
              Edge a=nb.get(i);
              if(visited[a.nbr]==0){
                  
              my.add(a.nbr);
              }
              if(a.nbr==dest){
                  return true;
              }
              
          }
          
          
          
      }
      return false;
      
      
      
       
   }
   
   
   
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for(int i = 0; i < vtces; i++){
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for(int i = 0; i < edges; i++){
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
      int dest = Integer.parseInt(br.readLine());
    
    
      //System.out.println(hasPath(src,dest,graph,vtces));
      
     int visited[]=new int[vtces];
          System.out.println(hasPathusingDfs(src,dest,graph,vtces,visited));
    }

}