package Probelm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GreedyProblem {
	private static InputStreamReader isr = new InputStreamReader(System.in);
	private static BufferedReader br = new BufferedReader(isr);
	
	public void baekjoon2875() {
		isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);
		try {
			int[] input= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			System.out.println(solution2875(input[0], input[1], input[2]));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int solution2875(int n,int m,int k) {
		int limit = n + m - k;
	    int x = 1;
		
	    while(true) {
	        int tempn = x * 2;
	        int tempm = x;
	        if (tempn + tempm > limit || tempn > n || tempm > m) break;
	        x++;
	    }
		return --x;
	}
}
