// This program is to implement the fibonacci search
// It uses fibonacci numbers to deal and eleminate the numbers.
// the main principle of this search is that fib(m - 2) is approx of 1/3rd of fib(m) and fib(m - 1) is approx of 2/3rd of fib(m).

package GeeksForGeeks.SearchingAlgorithms;

import java.io.*;

class FibonacciSearch {
	private static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	private static PrintWriter wr = new PrintWriter(System.out, true);
	public static void main(String[] args) throws IOException{

		//Driver Code.
		int n = Integer.parseInt(rd.readLine());
		int[] arr = GetIntArray();
		int element = Integer.parseInt(rd.readLine());

		int m = 2, fibm1 = 1, fibm2 = 0,fibm = fibm1 + fibm2;

		//Searching for fibonacchi number greater than or equal to the length of the array.
		while(n < fibm){
			fibm2 = fibm1;
			fibm1 = fibm;
			fibm = fibm1 + fibm2;
			m++;
		}

		int offset = -1;
		while(fibm2 > 0){
			int index = Math.min(offset + fibm2, n - 1);
			if(arr[index] == element){
				wr.println(index);
				break;
			}
			else if(arr[index] > element){
				fibm = fibm2;
				fibm1 = fibm1 - fibm2;
				fibm2 = fibm - fibm1;
			}
		}

		printArray(arr);
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
