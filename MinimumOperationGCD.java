// Minimum Operation to make GCD of array a mulitple of k
// Given an array arr of length n and a number k we need to find minimum number of operation to
// make the gcd of an array = k.

package GeeksForGeeks.Templates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Template {

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
		 
		 int sum = 0;
		 for(int i : arr) {
			 sum += Math.min((i % k) ,(k - (i % k)));
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
