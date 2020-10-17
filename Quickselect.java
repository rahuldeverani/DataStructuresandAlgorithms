import java.util.*;

public class Quickselect{

  public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[]={1,8,7,3,2,5,4,-1,83};
	
	        for(int i=0;i<arr.length;i++)
	         System.out.print(arr[i]+" ");    
            int k=4;
            int r=quickselect(arr,k,0,arr.length-1);
 
            System.out.println("Kth largest is"+r);
            
            
	     }

	    static int quickselect(int arr[],int k,int st, int end) {
	    	
	    	
	    	int pi=partition(arr,st,end);
	    	if(pi==k-1) {
	    		return arr[pi];
	    	}
	    	else if(pi<k-1) {
	    	return 	quickselect(arr,k,pi+1,end);
	    		
	    	}
	    	else {
	    	return 	quickselect(arr, k, st,pi-1);
	    	}
	    	
	    	
	    	
	    	
	    	
	    }
	

	
	
	
	     static int partition(int arr[],int st, int en){
	            int partind=st;
	            int j=st;
	            while(j<en){
	              if(arr[j]<arr[en]){
	                int temp=arr[j];
	                arr[j]=arr[partind];
	                arr[partind]=temp;
	                  partind++;

	                }
	               j++;

	            }
	            int temp =arr[en];
	            arr[en]=arr[partind];
	            arr[partind]=temp;
	     
               return partind;


	     }



	}
