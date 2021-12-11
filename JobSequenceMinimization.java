// Topic - JOB Sequence Loss Minimization
// problem Statement - Given a set of N jobs with their their time taken to complete and 
// a loss each job will occur each day for a delay  we have to minimize the loss incur by the
// jobs.

package GeeksForGeeks.GreedyAlgorithms;

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
		
		// making an array of jobs.
		JobLoss[] jobs = new JobLoss[n];
		
		for(int i = 0; i < n; i++) {
			jobs[i] = new JobLoss(scan.nextInt(), scan.nextInt());
		}
		
		mergesort(0, n - 1, jobs);
		
		for(int i = 0; i < n; i++){
			System.out.print(jobs[i].loss + " ");
		}
		System.out.println();
	}
	
	static class JobLoss {
		int timeTaken;
		int loss;
		
		JobLoss(int time, int loss) {
			this.timeTaken = time;
			this.loss = loss;
		}
	}
	
	static void mergesort(int left , int right, JobLoss[] j) {
		if( right <= left) return;
		
		int mid = (left + right) / 2;
		
		mergesort(left, mid, j);
		mergesort(mid + 1, right, j);
		
		// merging the array.
		JobLoss[] temp = new JobLoss[right - left + 1];
		int leftPtr = left, rightPtr = mid + 1, tempPtr = 0;
		
		while(leftPtr <= mid && rightPtr <= right) {
			if(j[leftPtr].loss / j[leftPtr].timeTaken < j[rightPtr].loss / j[rightPtr].timeTaken) {
				temp[tempPtr] = j[rightPtr];
				rightPtr++;
			}
			else {
				temp[tempPtr] = j[leftPtr];
				leftPtr++;
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

	private static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }

        System.out.println();
    }

}
