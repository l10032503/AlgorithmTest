package Probelm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class SortProblem {
	public void baekjoon11004() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

	        quickSort(arr, 0, input[0] - 1);
	        System.out.println(arr[input[1] - 1]);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void quickSort(int[] arr, int left, int right) {
        Stack<Integer> lstack = new Stack<Integer>();
        Stack<Integer> rstack = new Stack<Integer>();
        
        lstack.push(left);
        rstack.push(right);
        
        while(lstack.isEmpty() != true) {
        	int pl = left = lstack.pop();
        	int pr = right = rstack.pop();
        	int pivot = arr[(left + right)/2];
        	
        	do {
        		while(arr[pl] < pivot) pl++;
        		while(arr[pr] > pivot) pr--;
        		if(pl <= pr)
        			arr = swap(arr, pl++, pr--);
        	}while(pl <= pr);
        	
        	if(left < pr) {
        		lstack.push(left);
        		rstack.push(pr);
        	}
        	
        	if(pl < right) {
        		lstack.push(pl);
        		rstack.push(right);
        	}
        	System.out.println(Arrays.toString(arr));
        }
    }

	public static int[] swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		return arr;
	}
}
