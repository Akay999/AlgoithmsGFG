// Making elements of two arrays same with minimum inc/ dec;
// given two arrays of same lenght we have to make those elements same with minimum numbers of operations
// i.e inc/dec Note:- order may not be same.

package GeeksForGeeks.GreedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;


public class MakingElementsSame {

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
		int arr1[] = new int[n];
		int[] arr2 = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr1[i] = scan.nextInt();
		}
		for(int i = 0; i < n; i++) {
			arr2[i] = scan.nextInt();
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		long sum = 0;
		for(int i = 0; i < n; i++) {
			sum += (long) Math.abs(arr1[i] - arr2[i]);
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
