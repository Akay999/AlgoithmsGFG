// Topic - Maximum height of the pyramid form the given array.
// Given an array of n objects , each of which has a width of wi we have to construct a 
// pyramid such that toatal width of ith level is less than i+1th level
// and total objects in ith level is less than i+1 th level.


package GeeksForGeeks.GreedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;



public class MaximumHeightPyramid {

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
		
		Arrays.sort(arr);
		
		int ans = 1;
		int prevWidth = arr[0];
		int prevNum = 1, curWidth = 0, curNum = 0;
		
		for(int i = 1; i < n; i++) {
			
			curWidth += arr[i];
			curNum++;
			
			// checking if another level can be started.
			if( curWidth > prevWidth && curNum > prevNum) {
				ans++;
				prevWidth = curWidth;
				curWidth = 0;
				prevNum = curNum;
				curNum = 0;
			}
		}
		
		System.out.println(ans);
			
		
	}

	private static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }

        System.out.println();
    }

}
