package Probelm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
	
	public void baekjoon10814() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		ArrayList<Member> memberList = new ArrayList<Member>();
		
		try {
			int N = Integer.parseInt(br.readLine());
			
			for(int i = 0; i<N; i++) {
	            String[] Input = br.readLine().split(" ");
	            Member tempMember = new Member(Integer.valueOf(Input[0]), Input[1]);
	            memberList.add(tempMember); //tempMember를 memberList에 추가
	        }
			
			Collections.sort(memberList); //age를 기준으로 정렬

	        for(Member member : memberList){
	            System.out.println(member.getAge()+ " " + member.getName());
	        }
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

class Member implements Comparable<Member> {
	// 참고 : Compare과 Comparator의 차이점
	// https://gmlwjd9405.github.io/2018/09/06/java-comparable-and-comparator.html
	    private int age;
	    private String name;

	    public Member(int age, String name){
	        this.age=age;
	        this.name=name;
	    }

	    public int getAge(){
	        return this.age;
	    }

	    public String getName(){
	        return this.name;
	    }

	    @Override //age를 기준으로 비교하기 위해서 Override
	    public int compareTo(Member member) {
	        return this.age - member.age;
	    }
	}

