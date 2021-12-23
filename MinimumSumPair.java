// Minimum Sum by choosign the minimum of pair from array.
// We are given an array of n element and we have to minimize the sum of array b.
// firstly choose an adjacent pair and remove the largest and add the smalles to b till the array has 1 element left.

package GeeksForGeeks.GreedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class MinimumSumPair {

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
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
			min = Math.min(arr[i], min);
		}
		
		System.out.println((n - 1) * min);

	}

	private static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }

        System.out.println();
    }

}
