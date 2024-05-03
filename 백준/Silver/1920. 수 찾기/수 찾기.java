import java.util.Scanner;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int[] arr = new int[N];
		
 
		for(int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		
		Arrays.sort(arr);
		
		int M = in.nextInt();
		
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			
			if(binarySearch(arr, in.nextInt()) >= 0) {
				sb.append(1).append('\n');
			}
			else {
				sb.append(0).append('\n');
			}
		}
		System.out.println(sb);
	}
	
	public static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        
        while(start <= end){
            int mid = (start + end) / 2;
            
            if(arr[mid] == target){
               return 1; 
            }else if(arr[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
}