// This program is to implement the interpolation search program.
// it is best suited when the array is uniformly distributed or close to uniformly distributed.
// its best case time complexity is O(1) and worst case time complexity is O(n) where we have to identify all the position.
// but the best part is its average case time complexity is O(log log n).

package GeeksForGeeks.SearchingAlgorithms;

import java.io.*;

public class InterpolationSearch {
	private static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	private static PrintWriter wr = new PrintWriter(System.out, true);
	public static void main(String[] args) throws IOException{

		//Driver Code.
		int n = Integer.parseInt(rd.readLine());
		int[] arr = GetIntArray();
		int element = Integer.parseInt(rd.readLine());

		System.out.println(intpSearch(arr, 0 , arr.length - 1, element));
		// printArray(arr);
	}

	private static int intpSearch(int[] arr, int low , int high, int element){

		// checking the base condition.
		if(low == high){
			return (arr[low] == element) ? low : -1;
		}

		// calculating the position.
		int pos = low + ((element - low) * (high - low)) / (arr[high] - low);

		// considering invalid postions.
		if(pos < low || pos > high)
			return -1;

		if(arr[pos] == element)
			return pos;
		else if(arr[pos] > element)
			return intpSearch(arr, low, pos - 1, element);
		else
			return intpSearch(arr, pos + 1, high, element);

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
