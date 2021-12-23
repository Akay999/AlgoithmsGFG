// Minimum Increment / Decrement to make array non Increasing
// Given an array a we have to convert it into a non increasing array with minimum nubmer of
// Operation by incrementing or decrementing by 1.

package GeeksForGeeks.GreedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class MinimumIncDec {

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
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		
		int start = 0, end = n - 1, sop = 0, eop = 0, startPrev = arr[0], endPrev = arr[n - 1];
		for(int i = 1; i < n; i++) {
			if(arr[start + i] > startPrev)	sop += arr[start + i] - startPrev;
			else startPrev = arr[start + i];
			
			if(arr[end - i] < endPrev) eop += endPrev - arr[end - i];
			else endPrev = arr[end - i];
		}
		
		System.out.println(Math.min(sop, eop));

	}

	private static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }

        System.out.println();
    }

}
