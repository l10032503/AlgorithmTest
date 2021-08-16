package Probelm;

public class RecursiveProblem {
	public static int cnt = 0;
	public static void targetNumber() {
		 int[] arr = {1,1,1,1,1};
		 int answer = 0;
			try {
				answer = targetNumberSolution(arr,3);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println(answer);
	}
	
	public static int targetNumberSolution(int[] numbers, int target) {
		int answer = 0;
		recursiveNumber(numbers, target, 0, 0);
		answer = cnt;
		return answer;
	}
	
	public static void recursiveNumber(int[] numbers, int target, int idx, int temp) {
		if(idx == numbers.length) {
			System.out.print(temp);
			if(temp == target)
				cnt++;
			return;
		}else {
			recursiveNumber(numbers, target, idx + 1, temp + numbers[idx]);
			recursiveNumber(numbers, target, idx + 1, temp - numbers[idx]);
		}
		return;
	}
}
