// Sum of Areas Of Rectangles Possible For An array.
// Given an array of lengths of sides we have to find the maximum area formed by the 
// rectangle possible from those sides.


package GeeksForGeeks.GreedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;


public class SumOfAreaRect {

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
		
		boolean isNew = true;
		int totalArea = 0, length = 0;
		
		Arrays.sort(arr);
		
		for(int i = n - 1; i > 0; i--) {
			if(arr[i] == arr[i - 1] || arr[i] - 1 == arr[i - 1]) {
				if(isNew) {
					length = (arr[i] - 1 == arr[i - 1]) ? arr[i] - 1: arr[i];
				}
				else {
					totalArea += ((arr[i] - 1 == arr[i - 1]) ? length * arr[i - 1] : length * arr[i]);
				}
				i--;
				isNew = !isNew;
			}
		}
		
		System.out.println(totalArea);
		

	}

	private static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }

        System.out.println();
    }

}
