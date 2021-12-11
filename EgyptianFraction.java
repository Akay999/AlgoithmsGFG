// Topic Egyptian fraction Using Greedy Algorithm.
// Given a Positive Fraction represent it as a sum of Egyptian Fraction.
// an Egyptian Fraction is a fraction whose numerator is 1 and denomiator is unique.

package GeeksForGeeks.GreedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class EgyptianFraction {

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
		// getting the numerator and denominator as an input.
		int num = scan.nextInt();
		int den = scan.nextInt();
		
		printEgyp(num, den);
		System.out.println();
		
		
	}
	
	static void printEgyp(int num, int den) {
		
		if(num == 0 || den == 0){
			return;
		}
		
		// if numerator divides denominator just give the remainer.
		if(den % num == 0) {
			System.out.print(" 1/" + (den / num));
			return;
		}
		
		// if numerator is more than denominator.
		if(num > den) {
			System.out.print((num / den) + " + ");
			printEgyp(num % den, den);
			return;
		}
		
		int n = den / num + 1;
		System.out.print(" 1/" + n + " + ");
		printEgyp( num * n - den, den * n);
		
	}

	private static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }

        System.out.println();
    }

}
