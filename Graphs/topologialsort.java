
 class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }





class Solution {
    
/* intuition -> find indegree of all nodes , then start with 0 indegree nodes and simulate their removal by changing the indegree of other nodes ,( keep in queue the nodes with 0 indegree) process them on e by one by simulating their removal , do this untill queue is not empty 

If after this process you have removed all the vertices then there is a topological sort otherwise there is a cycle because if there is a cycle then those vertices who are in cycle will never have indegree as 0 , never added to queue thus never processed */





    
    public int [] topologicalSortusingKahns(ArrayList<Edge> [] graph, int vtces){
       
        int  indegreeforvertex[]= new int[vtces];
        int arr[]= new int[vtces];
        int k=0;
        
        for(int i=0;i<graph.length;i++){
            
            ArrayList<Edge> adjacent= graph[i];
            
            
            for( int j=0;j<adjacent.size();j++){
                
                Edge ob= adjacent.get(j);
                indegreeforvertex[ob.nbr]=indegreeforvertex[ob.nbr]+1;
                
            }
            
            
        }
        Queue<Integer> processnode = new LinkedList<>();
        
       for(int i=0;i<indegreeforvertex.length;i++){
           if(indegreeforvertex[i]==0){
               processnode.add(i);
           }
           
           
       }
        int processedno=0;
       while(processnode.size()>0){
           
         int removed=processnode.remove(); 
         processedno+=1;
         arr[k]=removed;
           k+=1;
         //adjust graph
         
         for(int i=0;i<graph[removed].size();i++){
             Edge rem= graph[removed].get(i);
             indegreeforvertex[rem.nbr]-=1;
             if(indegreeforvertex[rem.nbr]==0){
                 
                 processnode.add(rem.nbr);
             }
             
             
         }
           
           
           
       }
     
       if(processedno==vtces){
           return arr;
       }
        else{
            int ar[]= new int[0];
            return ar;
        }
   }
   
   
   
    
    
    
    
    
   public int[] findOrder(int numCourses, int[][] prerequisites) { 
        
         ArrayList<Edge> [] graph=makegraph( numCourses,prerequisites);
        return  topologicalSortusingKahns(graph, numCourses); 
         
    
        
    }
    
    
    public ArrayList<Edge> [] makegraph(int vtces, int [][] pair){
        
        ArrayList<Edge> [] graph= new ArrayList [vtces]; 
        
        for(int i=0;i<vtces;i++){
            
            graph[i]= new ArrayList<Edge>();
        }
        
        
        for(int i=0;i<pair.length;i++){
            
            int sr, dst;
            sr=pair[i][1];
            dst=pair[i][0];

                Edge a= new Edge(sr,dst);
                graph[sr].add(a);
              
        }
        return graph;
        
        
        
    }
    
    
    
    
}