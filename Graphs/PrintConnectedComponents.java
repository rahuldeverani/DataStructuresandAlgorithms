import java.io.*;
import java.util.*;


/* can be used to check if graph is connected or not. How??
 if a graph has more than one connected component, then it will not be a connected graph */ 



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


	static ArrayList<ArrayList<Integer>> connectedComponents(ArrayList<Edge>[] graph) {

		ArrayList<ArrayList<Integer>> x = new ArrayList();
		int visited[] = new int[graph.length];

		for (int i = 0; i < graph.length; i++) {
			if (visited[i] == 0) {
				int visited2[] = new int[graph.length];
				ArrayList<Integer> smallComponent = dfs(i, graph, visited2);
				x.add(smallComponent);
				for (int j = 0; j < smallComponent.size(); j++) {
					int ret = smallComponent.get(j);
					visited[ret] = 1;
				}

			}
		}
		return x;

	}

	public static ArrayList<Integer> dfs(int src, ArrayList<Edge>[] graph, int visited[]) {

		ArrayList<Integer> components = new ArrayList();
		ArrayList<Edge> neighbors = graph[src];
		components.add(src);
		visited[src]=1;
	    for(int i=0;i<neighbors.size();i++) {
	    	
	    	int neighbor= neighbors.get(i).nbr;
	    	if(visited[neighbor]==0) {
	    		
	    		visited[neighbor]=1;
	    		ArrayList<Integer> rec= dfs(neighbor,graph,visited);
	    	
	    		for(int j=0;j<rec.size();j++) {
	    			components.add(rec.get(j));
	    		}
	    		
	    		
	    	}
	    	
	    }
	
		return components;
		
		
		

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

  ArrayList<ArrayList<Integer>> comps=connectedComponents(graph);

      System.out.println(comps);
   }
}