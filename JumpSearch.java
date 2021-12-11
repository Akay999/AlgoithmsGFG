// This program is a Searching algorithm called as JumpSearch.
// In jump search we jump a fixed number of interval ahead and then traverse linearly
// once the current element is greater than finding element.
// its Complexity is O(root(n)). better than binary in case of finding element is smaller or smaller than smallest element in the array.

package GeeksForGeeks.SearchingAlgorithms;

import java.io.*;

public class JumpSearch {
	private static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	private static PrintWriter wr = new PrintWriter(System.out, true);
	public static void main(String[] args) throws IOException{

		//Driver Code.
		int n = Integer.parseInt(rd.readLine());
		int[] arr = GetIntArray();
		int l = Integer.parseInt(rd.readLine());
		System.out.println(gfgsolution(arr, l));
		// printArray(arr);
	}

	public static int gfgsolution(int[] arr, int x)
    {
        int n = arr.length;
 
        // Finding block size to be jumped
        int step = (int)Math.floor(Math.sqrt(n));
 
        // Finding the block where element is
        // present (if it is present)
        int prev = 0;
        while (arr[Math.min(step, n)-1] < x)
        {
            prev = step;
            step += (int)Math.floor(Math.sqrt(n));
            if (prev >= n)
                return -1;
        }
 
        // Doing a linear search for x in block
        // beginning with prev.
        while (arr[prev] < x)
        {
            prev++;
 
            // If we reached next block or end of
            // array, element is not present.
            if (prev == Math.min(step, n))
                return -1;
        }
 
        // If element is found
        if (arr[prev] == x)
            return prev;
 
        return -1;
    }

	private static int jmpSearch(int[] arr, int element){
		int root = (int) Math.sqrt(arr.length);
		// System.out.print("root = " + root);
		int index = -1;
		for(int i = 0; i < root; i++){
			index += root;
			// System.out.print("Index = " + index);
			int curElement = arr[index];

			//if the element is on the jump.
			if(curElement == element)
				return index;

			// if element is between this and the previous jump.
			else if(curElement > element){

				// looking for the skipped elemnts in between known intervals.
				for(int j = index - 1; j > index - root; j--){
					if(arr[j] == element)
						return j;
				}
				// condition when the element is not in the array.
				return -1;
			}
		}

		// when the root is not a perfect number we are left with certain end elemenets to be checked.
		while(index < arr.length){
			if(arr[index] == element)
				return index;
			index++;
		}

		//when the element is not in the array.
		return -1;

	}

	private static int[] GetIntArray() throws IOException{
		String[] inpStr = rd.readLine().split("\\s");
		int len = inpStr.length;
		int[] resArray = new int[len];
		for(int i = 0; i < len; i++){
			resArray[i] = Integer.parseInt(inpStr[i]);
		}

		return resArray;
	}


	private static void printArray(int[] arr){
		for(int i : arr){
			wr.print(i + " ");
		}

		wr.println();
	}

}
