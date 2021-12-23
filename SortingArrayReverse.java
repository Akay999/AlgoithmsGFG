// Sorting array with reverse around middle.
// given array arr we have to find if we can sort it with following operation or not.
// operation - choose a subarray such that the middle elements of original is same as the middle
// of subarray and then reverse it.


package GeeksForGeeks.GreedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class SortingArrayReverse {

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
		
		for(int i = 0; i < n / 2; i++) {
			int min = Math.min(arr[i], arr[n - i - 1]);
			int max = Math.max(arr[i], arr[n - i - 1]);
			arr[i] = min;
			arr[n - 1 - i] = max;
		}
		
		boolean flag = true;
		for(int i = 1; i < n; i++) {
			if(arr[i] < arr[i - 1]) {
				flag = false;
				break;
			}
		}
		
		if(!flag) {
			System.out.println("NO");
		}else System.out.println("YES");
		

	}

	private static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }

        System.out.println();
    }

}
