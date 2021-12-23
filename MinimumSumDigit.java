// Minimum sum of two numbers formed from digits of an array.
// Given an array of digis we have to find the minimum sum of two numbers formed
// using those digits and we have to use all digits.

package GeeksForGeeks.Templates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;



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
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		
		Arrays.sort(arr);
		
		boolean flag = true;
		String num1 = "", num2 = "";
		for(int i = 0; i < n; i++) {
			if(flag) {
				num1 += Integer.toString(arr[i]);
				flag = !flag;
			}
			else {
				num2 += Integer.toString(arr[i]);
				flag = !flag;
			}
		}
		
		System.out.println(Integer.parseInt(num1) + Integer.parseInt(num2));
				
		
	}

	private static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }

        System.out.println();
    }

}
