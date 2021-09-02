package Probelm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DPProblem {
	private static InputStreamReader isr = new InputStreamReader(System.in);
	private static BufferedReader br = new BufferedReader(isr);
	private static long answer = 0;
	//https://www.acmicpc.net/problem/11726
	public void twoTileProblem() {
		isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);
		try {
			int n = Integer.parseInt(br.readLine());
			twoTileSolution(n);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void twoTileSolution(int n) {
		if(n == 0) {
			answer++;
			return;
		}
		
		if(n >= 2) {
			twoTileSolution(n-2);
		}
		if(n >= 1) {
			twoTileSolution(n-1);
		}
		
		return;
	}
	
	public void twoTileSolution2(int n) {
		int[] arr = new int[1001];
		
		arr[0] = 1;
        arr[1] = 1;
        
        for(int j = 2; j <= n; j++) {
            arr[j] = (arr[j-1] + arr[j-2])%10007;
        }

        System.out.println(arr[n]);
		
		return;
	}
	
	private int n;
    private int target;
    private int answer2 = Integer.MAX_VALUE;
    
	public void representationN() {
		System.out.println(representationS(5,12));
	}
	
	private int representationS(int N, int number) {
		n = N;
		target = number;
		dfs(0,0);
        return answer2 == Integer.MAX_VALUE ? -1 : answer2;
	}
	
	private void dfs(int count, int prev) {
        if (count > 8) {
            answer2 = -1;
            return;
        }

        if (prev == target) {
            answer2 = Math.min(answer2, count);
            return;
        }

        int tempN = n;
        for (int i = 0; i < 8 - count; i++) {
            int newCount = count + i + 1;
            dfs(newCount, prev + tempN);
            dfs(newCount, prev - tempN);
            dfs(newCount, prev / tempN);
            dfs(newCount, prev * tempN);

            tempN = tempN * 10 + n;
        }
    }
	
	public void triangleProblem() {
		System.out.println(triangleSolution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
	}
	
	private int triangleSolution(int[][] triangle) {
        int answer = 0;
        int bottomlen = triangle[triangle.length-1].length;
        int[] result = new int[bottomlen];
        result[0] = triangle[0][0];
        
        for(int i = 1; i < triangle.length; i++) { //트리의 높이
        	for(int j = i; j >= 0 ; j--) { //트리 바닥의 길이
        		int temp = 0;
        		if(j < triangle[i-1].length) {
        			temp = result[j] + triangle[i][j];
        			result[j] = Math.max(temp, result[j]);
        		}
        		if((j-1) >= 0) {
        			temp = result[j-1] + triangle[i][j];
        			result[j] = Math.max(temp, result[j]);
        		}
        	}
        }
        
        for(int i = 0; i < result.length; i++) {
        	answer = Math.max(answer, result[i]);
        }
        
        return answer;
    }
}
