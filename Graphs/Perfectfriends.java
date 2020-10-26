// given some friends which belong to some club , find the ways to choose a pair such that items in pair belong to different clubs.

/* find connected components , in this way we will have all the clubs separated, then the no of ways can be easily calculated.

ex - 

0-1
2-3 
4-5-6 

lets say these are 3 clubs , ways are -

choose 1 from club one and then choose any other club student - 
ways -> 2 x 5 =10
choose 1 from club 2 , and choose 1 from club 3
wayse -> 2 x 3 =6

*/


import java.io.*;
import java.util.*;

class Edge {
    int src;
    int nbr;
 
    Edge(int src, int nbr){
       this.src = src;
       this.nbr = nbr;
       
    }
 }



public class Main {
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

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());
      
      ArrayList<Edge>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {

			graph[i] = new ArrayList();
		}
		for (int i = 0; i < k; i++) {
			String[] parts = br.readLine().split(" ");

			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);

			graph[v1].add(new Edge(v1, v2));
			graph[v2].add(new Edge(v2, v1));
		}

		ArrayList<ArrayList<Integer>> my = connectedComponents(graph);
           
           int ways=0;
           int sum=0;
           		for(int i=0;i<my.size();i++){
           		    sum+=my.get(i).size();
           		    
           		}
		for(int i=0;i<my.size()-1;i++){
		    
		    int len1=my.get(i).size();
		    
		    int x=len1*(sum-len1);
		    ways+=x;
		    sum=sum-len1;
		}
		
		System.out.println(ways);
		
		
		
		

   }

}