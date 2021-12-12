// Maximum Sum of Increasing elements from n arrays.
// Given n arrays with m elements each we have to output the maximum sum taking an element from
// each array but with a condition that each element from ith array must be grater than the i-1th array.

package GeeksForGeeks.GreedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class MaximumSumIncreasing {

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
		
		int n = scan.nextInt(), m = scan.nextInt();
		int arr[][] = new int[n][m];
		for(int i = 0; i < n; i++){
			for(int j = 0;j < m; j++){
				arr[i][j] = scan.nextInt();
			}
		}
		
		boolean isPossible = true;
		int prevMax = Integer.MAX_VALUE, curMax = Integer.MIN_VALUE, totalSum = 0;
		for(int i = n - 1; i >= 0; i--){
			for(int j = 0; j < m; j++) {
				if(arr[i][j] < prevMax) curMax = Math.max(arr[i][j], curMax);
			}
			if(curMax == Integer.MIN_VALUE) {
				System.out.println(0);
				isPossible = false;
				break;
			}
			
			prevMax = curMax;
			totalSum += curMax;
			curMax = Integer.MIN_VALUE;
		}
		
		if(isPossible) System.out.println(totalSum);

	}

	private static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }

        System.out.println();
    }

}
