// Topic - Maximum Array Sum after k Neagations.
// Given an Array of n Integers we have to maximize the sum of elements by performing
// k negation operations i.e arr[i] = -arr[i].

// Approach 2 can be firstly sorting the array. and then performing the k operations from left till we found 0 or a +ve Integer.
// Another optimized Solution can be using priority queues.

package GeeksForGeeks.GreedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class MaximumArraySum {

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
		int k = scan.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		
		while(k-- > 0){
			int minCur = Integer.MAX_VALUE, index = -1;
			for(int i = 0; i < n; i++){
				if(arr[i] < minCur){
					index = i;
					minCur = arr[i];
				}
			}
			if(minCur == 0) break;
			
			arr[index] = - arr[index];
		}
		
		int sum = 0;
		for(int i = 0; i < n; i++){
			sum += arr[i];
		}
		System.out.println(sum);

	}

	private static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }

        System.out.println();
    }

}
