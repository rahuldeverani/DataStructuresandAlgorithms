package june;

import java.io.*;
import java.util.*;

class ListPoint implements Comparable<ListPoint> {
	int listNumber, val, curInd;

	public ListPoint(int listNumber, int val, int curInd) {
		this.listNumber = listNumber;
		this.val = val;
		this.curInd = curInd;
	}

	public int compareTo(ListPoint obj) {

		return this.val - obj.val;
	}

}
// made a priority queue which will hold all the 0th index elemets of all arrays , remove the smallest and add it too sorted list , and add the next element of that list to priority queue, do this until the queue gets empty , in this way queue will have at most k elements only , so all operations in logk time , for all elements nlogk , space k
public class MergeKSortedList {
	public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
		ArrayList<Integer> rv = new ArrayList<>();
		int k = lists.size();
		PriorityQueue<ListPoint> pointsToCompare = new PriorityQueue();
		for (int i = 0; i < k; i++) {
			int val = lists.get(i).get(0);
			ListPoint obj = new ListPoint(i, val, 0);
			pointsToCompare.add(obj);
		}
		while (pointsToCompare.size() > 0) {
			ListPoint smallest = pointsToCompare.remove();
			rv.add(smallest.val);
			int removedFromWhichList = smallest.listNumber;
			int nextIndex = smallest.curInd + 1;
			if (lists.get(removedFromWhichList).size() > nextIndex) {
				int val = lists.get(removedFromWhichList).get(nextIndex);
				pointsToCompare.add(new ListPoint(smallest.listNumber, val, nextIndex));
			}

		}

		return rv;
	}

	// time complexity of normal solution will be O(k*n) , using merge logic form
	// merge sort , as k elements will be compared for smallest to add in main list
	// it will be k time for all n , O(k*n)
	// we can use a heap to store the k elements to find smallest element using
	// priority queue, this will be done in log k time thus total time - O(logk *n)

	// driver
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			ArrayList<Integer> list = new ArrayList<>();

			int n = Integer.parseInt(br.readLine());
			String[] elements = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				list.add(Integer.parseInt(elements[j]));
			}

			lists.add(list);
		}

		ArrayList<Integer> mlist = mergeKSortedLists(lists);
		for (int val : mlist) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

}
