// Topic - Minimum Product Subset of an Array.
// Given an array of Integers we have to find out the minimum product possible
// with the subset of the element of the array.

package GeeksForGeeks.GreedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class MinimumProductSubset {

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
		int miniPos = Integer.MAX_VALUE, maxiNeg = Integer.MIN_VALUE, nProduct = 1, pProduct = 1, counter = 0;
		for(int i = 0;i < n; i++) {
			arr[i] = scan.nextInt();
			//settleling the minimum and maximums.
			if(arr[i] >= 0){
				miniPos = Math.min(miniPos, arr[i]);
				if(arr[i] != 0) pProduct *= arr[i];
			}
					
			else {
				maxiNeg = Math.max(maxiNeg, arr[i]);
				nProduct *= arr[i];
				counter++;
			}
			
		}
		
		if(n == 1) System.out.println(arr[0]);
		else if(counter == 0) System.out.println(miniPos);
		else if(counter % 2 == 0) {
			System.out.println((nProduct / maxiNeg) * pProduct);
		}
		else System.out.println(nProduct * pProduct);
		

	}

	private static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }

        System.out.println();
    }

}
