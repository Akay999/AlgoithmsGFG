// This program contains simple linear search algorithm and an improved version of the
// linear search algorithm which has improved worst case time complexity to O(1) - when element is at last
// and when the element is at middle to O(n/2)

package GeeksForGeeks.SearchingAlgorithms;

import java.io.*;

public class BinarySearch {
	public static void main(String[] args) throws IOException{
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out, true);

		//Driver Code.
		
		String[] inparr = rd.readLine().split("\\s");
		int[] array = new int[inparr.length];
		for(int i = 0; i < inparr.length; i++){
			array[i] = Integer.valueOf(inparr[i]);
		}

		int element = Integer.parseInt(rd.readLine());

		wr.println(binSearch(array, 0, inparr.length, element));

	}

	private static int binSearch(int[] arr,int start, int end, int element){

		//when the array has only 1 element.
		if(start >= end)
			return -1;


		// recursive case.
		int mid = (start + end) / 2;
		if(arr[mid] == element)
			return mid;
		else if(arr[mid] > element)
			return binSearch(arr, start, mid, element);
		else
			return binSearch(arr, mid + 1, end, element);

	}
}
