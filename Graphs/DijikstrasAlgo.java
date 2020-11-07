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
	   
	    static class Pair implements Comparable<Pair>{
	       int weight;
	       int dest;
	       String pathtillnow;
	       
	       Pair(int w, int d, String path){
	           weight =w;
	           dest=d;
	           pathtillnow=""+path;
	       }
	       
	   
	   public  int compareTo(Pair obj){
	       return this.weight-obj.weight;
	       
	   } 
	}
	   
	   public static void Dijikstra(ArrayList<Edge> [] graph , int vtces , int src ){
	        
	        PriorityQueue<Pair> pq= new PriorityQueue();
	        
	        Pair initial= new Pair(0,src,src+"");
	        pq.add(initial);
	        boolean visited[]= new boolean [vtces];
	        while(pq.size()>0){
	            
	            Pair ret=pq.remove();
	            int currentvtx=ret.dest;
	          if(visited[currentvtx]==false) {
	            System.out.println(ret.dest+" via "+ret.pathtillnow+" @ "+ret.weight);
	           
	          }
	          visited[currentvtx]=true;
	            for(int i=0;i<graph[currentvtx].size();i++){
	                
	                Edge ce= graph[currentvtx].get(i);
	                int nbr=ce.nbr;
	                int edgeweight=ce.wt;
	                if(visited[nbr]==false){
	                    String pathx= ret.pathtillnow+""+nbr;
	                    Pair neibr= new Pair(ce.wt+ret.weight,nbr,pathx);
	                    pq.add(neibr);
	                    
	                }
	                
	                
	                
	            }
	            
	            
	            
	            
	        }
	        
	        
	        
	       
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

	      int src = Integer.parseInt(br.readLine());
	      // write your code here
	      
	      Dijikstra(graph , vtces , src);
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	   }
	}