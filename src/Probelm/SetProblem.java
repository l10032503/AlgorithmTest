package Probelm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SetProblem {
	public void baekjoon1717() {
		//solution1717();
		solution1717_2();
	}
	
	public static void solution1717() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			boolean[][] arr = new boolean[input[0] + 1][input[0] + 1];
			
			for(int i = 0; i < input[1]; i++) {
				int[] command = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				if(command[0] == 0) {
					arr[command[1]][command[2]] = true;
					arr[command[2]][command[1]] = true;
				} else if(command[0] == 1) {
					if(arr[command[1]][command[2]] == true || arr[command[2]][command[1]] == true) {
						System.out.println("yes");
					}else {
						System.out.println("no");
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void solution1717_2() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int n = input[0];
	        int m = input[1];

	        parent = new int[n+1];

	        for (int i=0 ; i<=n ; i++){
	            parent[i] = i;
	        }

	        for (int i =0; i<m; i++){
	            String[] s1 = br.readLine().split(" ");
	            int div = Integer.parseInt(s1[0]);
	            int u = Integer.parseInt(s1[1]);
	            int v = Integer.parseInt(s1[2]);

	            if(div == 1) {
	                if(find(u) == find(v)){
	                    System.out.println("YES");
	                }else{
	                    System.out.println("NO");
	                }
	            }else if(div == 0){
	                merge(u , v);
	            }
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	static int [] parent ;

    public static int find(int u) {
        if (u == parent[u]) {
            return u;
        }
        return parent[u] = find(parent[u]); // 압축
        // return find(parent[u]) // 압축x
    }
    public static void merge(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) {
            return;
        }
        parent[u] = v;
    }
}
