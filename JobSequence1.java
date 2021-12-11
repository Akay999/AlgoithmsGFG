// Topic Job Sequencing - where job size is 1 unit.
// given a set of jobs and their deadline as well as their profit we have to maximize their
// profit by making a sequence of executing jobs.


package GeeksForGeeks.GreedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class JobSequence1 {

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
		
		//getting number of jobs.
		int n = scan.nextInt();
		
		Job[] jobs = new Job[n];
		
		// variable for max deadline.
		int maxDeadline = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			jobs[i] = new Job(scan.nextInt(), scan.nextInt());
			maxDeadline = Math.max(jobs[i].deadline, maxDeadline);
		}
		
		//sorting the array by profit.
		mergesort(0, n - 1, jobs);
		
		//printing the jobs after sorting.
		//for(int i = 0;i < n; i++) {
			//System.out.println("deadline = " + jobs[i].deadline + " profit = " + jobs[i].profit);
		//}
		
		int[] timeline = new int[maxDeadline];
		
		int i = 0, totalProfit = 0;
		while(i < n) {
			//checking for ith job.
			int j = jobs[i].deadline - 1;
			while(j >= 0 && timeline[j] != 0) {
				j--;
			}
			if(j >= 0) {
				totalProfit += jobs[i].profit;
				timeline[j] = 1;
			}
			i++;
			
		}
		
		
		System.out.println(totalProfit);

	}
	
	static void mergesort(int left , int right, Job[] j) {
		if( right <= left) return;
		
		int mid = (left + right) / 2;
		
		mergesort(left, mid, j);
		mergesort(mid + 1, right, j);
		
		// merging the array.
		Job[] temp = new Job[right - left + 1];
		int leftPtr = left, rightPtr = mid + 1, tempPtr = 0;
		
		while(leftPtr <= mid && rightPtr <= right) {
			if(j[leftPtr].profit > j[rightPtr].profit) {
				temp[tempPtr] = j[leftPtr];
				leftPtr++;
			}
			else {
				temp[tempPtr] = j[rightPtr];
				rightPtr++;
			}
			tempPtr++;
		}
		
		while(leftPtr <= mid){
			temp[tempPtr] = j[leftPtr];
			tempPtr++;
			leftPtr++;
		}
		
		while(rightPtr <= right){
			temp[tempPtr] = j[rightPtr];
			tempPtr++;
			rightPtr++;
		}
		
		// copying from temp to original.
		tempPtr = 0;
		for(int i = left; i <= right; i++, tempPtr++){
			j[i] = temp[tempPtr];
		}
		
		return;
	}
			
	
	static class Job {
		int deadline;
		int profit;
		Job(int deadline, int profit){
			this.deadline = deadline;
			this.profit = profit;
		}
	}

	private static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }

        System.out.println();
    }

}

