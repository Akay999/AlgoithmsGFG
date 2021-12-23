// Minimum sum of product of two arrays.
// Given two arrays of same lenght we have to minimize the sum of the product of the elements 
// we can perform k operation on any elements which is decreasing or increadsing the element by 2

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
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr1[i] = scan.nextInt();
		}
		for(int i = 0;i < n; i++ ) {
			arr2[i] = scan.nextInt();
		}
		
		int a = 1, b = 1, maxProduct = -1, sum = 0;
		for(int i = 0;i < n; i++) {
			int temp = arr1[i] * arr2[i];
			sum += temp;
			if(temp > 0 && temp > maxProduct) {
				a = arr1[i];
				b = arr2[i];
				maxProduct = temp;
			}
		}
		
		if(maxProduct == -1) {
			System.out.println(sum);
			return;
		}
		
		sum -= (a * b);
		
		if( a > 0) {
			int min = Math.min(a, b);
			min -= (k * 2);
			sum += (min * Math.max(a, b));
		}
		
		else {
			int min = Math.max(a, b);
			min += (k * 2);
			sum += (min * Math.min(a , b));
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
