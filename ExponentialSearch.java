// This program implements the Exponential search algorithm.
// it first identifies the range in the element is possible there.
// its best useful of unbounded search and also better than binary in bounded search.

package GeeksForGeeks.SearchingAlgorithms;

import java.io.*;

public class ExponentialSearch {
	private static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	private static PrintWriter wr = new PrintWriter(System.out, true);
	public static void main(String[] args) throws IOException{

		//Driver Code.
		int n = Integer.parseInt(rd.readLine());
		int[] arr = GetIntArray();
		int element = Integer.parseInt(rd.readLine());
		System.out.println(gfgsolution(arr, element));
		// printArray(arr);
	}

	private static int expSearch(int arr[], int element){
		int subArray = 1, prev = 0;

		// loop to find the range of the element.
		while(subArray <= arr.length){
			if(arr[subArray - 1] == element)
				return subArray - 1;
			else if(arr[subArray - 1] > element){
				return binSearch(arr, prev, subArray, element);
			}
			else
				prev = subArray;
				subArray *= 2;
		}

		// case when some last elements are left and the value of subarray is not = arr.length.
		if(prev < arr.length){
			return binSearch(arr, prev, arr.length, element);
		}

		// when no element is found.
		return -1;
	}

	private static int binSearch(int[] arr,int start, int end, int element){

		//when the array has only 1 element.
		if(start == end -1){
			if(arr[start] == element)
				return start;
			else
				return -1;
		}

		//when the array has no element.
		if(start >= end){
			return -1;
		}


		// recursive case.
		int mid = (start + end) / 2;
		if(arr[mid] == element)
			return mid;
		else if(arr[mid] > element)
			return binSearch(arr, start, mid, element);
		else
			return binSearch(arr, mid, end, element);

	}

	private static int gfgsolution(int[] arr, int element){
		// checking if the element is at first place.
		if(arr[0] == element)
			return 0;

		// iterative condition
		int i = 1;
		while(i < arr.length && arr[i] < element)
			i *= 2;

		return binSearch(arr, i / 2, Math.min(i + 1, arr.length), element);
	}

	private static int[] GetIntArray() throws IOException{
		String[] inpStr = rd.readLine().split("\\s");
		int len = inpStr.length;
		int[] resArray = new int[len];
		for(int i = 0; i < len; i++){
			resArray[i] = Integer.parseInt(inpStr[i]);
		}

		return resArray;
	}


	private static void printArray(int[] arr){
		for(int i : arr){
			wr.print(i + " ");
		}

		wr.println();
	}

}
