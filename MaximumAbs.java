// Topic - Maximum sum of absolute difference of any permutation.
// given an array of size n integers we have to find out the maximum sum of absolute difference
// of the consecutive element from various permutation of the elements of the array

package GeeksForGeeks.GreedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;


public class MaximumAbs {

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
		
		for(int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		
		Arrays.sort(arr);
		
		int leftPtr = 0 , rightPtr = n -1, totalSum = 0;
		boolean isLeft = true;
		while(leftPtr != rightPtr) {
			if(isLeft) {
				totalSum += (int) Math.abs(arr[leftPtr] - arr[rightPtr]);
				leftPtr++;
				isLeft = !isLeft;
			}
			else {
				totalSum += (int) Math.abs(arr[rightPtr] - arr[leftPtr]);
				rightPtr--;
				isLeft = !isLeft;
			}
		}
		
		//System.out.println(totalSum);
		totalSum += Math.abs(arr[rightPtr] - arr[0]);
		
		System.out.println(totalSum);		

	}

	private static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }

        System.out.println();
    }

}
