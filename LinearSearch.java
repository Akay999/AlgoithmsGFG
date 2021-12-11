// This program contains simple linear search algorithm and an improved version of the
// linear search algorithm which has improved worst case time complexity to O(1) - when element is at last
// and when the element is at middle to O(n/2)

package GeeksForGeeks.SearchingAlgorithms;

import java.io.*;

public class LinearSearch {
	public static void main(String[] args) throws IOException{
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out, true);

		//Driver Code.
		int[] arr = {1, 2,3, 4,5 ,6 };
		wr.println("from linSearch = " + linSearch(arr, 7));
		wr.println("from ImplinSearch = " + impLinSearch(arr, 7));


	}

	private static int linSearch(int[] arr, int element){
		int len = arr.length;
		for(int i = 0; i < len; i++){
			if(arr[i] == element){
				return i;
			}
		}

		//when the element is not found.
		return -1;
	}

	private static int impLinSearch(int[] arr, int element){

		int len = arr.length;
		int left = 0;
		int right = len - 1;
		for(int i = 0; i <= len/2; i++, left++, right--){
			//checking with the left pointer.
			if(arr[left] == element){
				return left;
			}


			//checking with the right pointer.
			if(arr[right] == element){
				return right;
			}
		}

		//when the element is not found.
		return -1;
	}

}
