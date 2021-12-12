// Topic - Minimum Product Subset of an Array.
// Given an array of Integers we have to find out the minimum product possible
// with the subset of the element of the array.

package GeeksForGeeks.GreedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class MaximumProductSubset {

	static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
 
        long nextLong() { return Long.parseLong(next()); }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

	public static void main(String[] args) throws IOException{

		FastReader scan = new FastReader();

		// Driver Code.
		int n = scan.nextInt();
		int[] arr = new int[n];
		
		// getting the value of minimum +ve maximum -ve
		int pCounter = 0, nCounter = 0, maxNum = Integer.MIN_VALUE, nProduct = 1, pProduct = 1, nMax = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
			
			if(arr[i] > 0) {
				pCounter++;
				pProduct *= arr[i];
			}
			else if(arr[i] < 0){
				nProduct *= arr[i];
				nCounter++;
				nMax = Math.max(nMax, arr[i]);
			}
			maxNum = Math.max(maxNum, arr[i]);
		}
		
		if(n == 1){
			System.out.println(arr[0]);
			return;
		}
		
		if(pCounter == 0 && nCounter <= 1){
			System.out.println(maxNum);
		}
		else if (nCounter % 2 == 0) {
			System.out.println(nProduct * pProduct);
		}
		else {
			System.out.println((nProduct / nMax) * pProduct);
		}
			
		
	}

	private static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }

        System.out.println();
    }

}
