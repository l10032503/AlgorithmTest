package Probelm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class QueueProblem {
	public int cacheProblem() {
		int answer = 0;
		String[] cities = {
			"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"
	    };
		String[] cities2 = {
	    	"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"
	    };
		
		answer = cacheSolution(5, cities2);
	    System.out.println(answer);
        return answer;
	}
	
	public static int cacheSolution(int cacheSize, String[] cities) {
		int runtime = 0;
		Queue<String> cache = new LinkedList<String>();
		
		if(cacheSize == 0){
            return cities.length*5;
        }
        if(cities.length == 0){
            return 0;
        }
        
		for(int i = 0; i < cities.length; i++) {
			String tempCity = cities[i].toLowerCase();
			if(cache.contains(tempCity)) {
				cache.poll();
				cache.offer(tempCity);
				runtime += 1;
			}else {
				if(cache.size() >= cacheSize) {
					cache.poll();
				}
				cache.offer(tempCity);
				runtime += 5;
			}
		}
		return runtime;
	}
	
	public void baekjoon1966() {
		solution1966();
	}
	
	public void solution1966() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			int docCnt = Integer.parseInt(br.readLine());
			for(int i = 0; i< docCnt ; i++) {
				int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				int[] docs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				//LinkedList<Integer> printQueue = sortQueue(docs);
				//System.out.println(printOrder(arr, printQueue));
				System.out.println(printOrder(arr, docs));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int printOrder(int[] arr, int[] docs) {
		LinkedList<int[]> queue = new LinkedList<int[]>();
		int cnt = 0;
		for(int i = 0; i < docs.length; i++) {
			int[] job = new int[2];
			job[0] = docs[i];
			if(i == arr[1]) {
				job[1] = 1;
			}
			queue.add(job);
		}
		while(queue.size() > 0) {
			int[] job = queue.getFirst();
			boolean isPrint = true;
			for(int j = 1; j < queue.size(); j++) {
				if(job[0] < queue.get(j)[0]) {
					isPrint = false;
					break;
				}
			}
			if(isPrint) {
				cnt++;
				if(job[1] == 1) {
					return cnt;
				}
			}else {
				queue.addLast(job);
			}
			queue.removeFirst();
		}
		
		return cnt;
	}
	
	public int printOrder (int[] arr, LinkedList<int[]> queue) {
		int order = 0;
		int target = arr[1];
		
		for(int i = 0; i < queue.size(); i++) {
			if(target == queue.get(i)[1]) {
				order = i+1;
				break;
			}
		}
		
		return order;
	}
	
}
