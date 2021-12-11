// Topic - Acitivity Selection Problem
// In this problem we are given a set of n activities with their start time and finish
// times. we have to find the largest set of compatible activities.

package GeeksForGeeks.GreedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;



public class ActivitySelection {

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
		
		// Getting the number of activities
		int n = scan.nextInt();
		
		Activity[] activities = new Activity[n];
		
		for(int i = 0; i < n; i++) {
			activities[i] = new Activity(scan.nextInt(), scan.nextInt());
		}
		
		// creating an arraylist for the compatible activities.
		ArrayList<Integer> list = new ArrayList<>();
		
		int subStart = activities[0].startTime, counter = 0;
		
		while(counter < n) {
			if(activities[counter].startTime >= subStart) {
				list.add(counter);
				subStart = activities[counter].finishTime;
			}
			counter++;
		}
		
		System.out.println(list);
	}
	
	static class Activity {
		int startTime;
		int finishTime;
		
		Activity(int start, int end) {
			startTime = start;
			finishTime = end;
		}
	}

	private static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }

        System.out.println();
    }

}
