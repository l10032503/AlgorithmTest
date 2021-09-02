package Probelm;

public class ListProblem {
	public void nNumberProblem() {
		System.out.println(nNumberSolution(2,4,2,1));
		System.out.println(nNumberSolution(16,16,2,1));
		System.out.println(nNumberSolution(16,16,2,2));
	}
	
	public String nNumberSolution(int n, int t, int m, int p) {
		String answer = "";
		String temp = "";
		int i = 0;
		while(temp.length() < m*(t-1)+p) {
			temp += transNumber(n, i);
			i++;
		}
		
		for(int j = 0; j<t ; j++) {
			answer += temp.charAt(j*m + (p-1));
		}
		return answer;
	}
	
	public static String transNumber(int n, int number){
        String temp = "";
        int q = 0;
        int r = 0;
        char rest;
        do{
            r = number % n;
            q = number / n;
            if(r < 10){
                temp = r + temp;
            }else{
                rest = (char)(r%10 + 'A');
                temp = rest + temp;
            }
            number = q;
        }while(number > 0);
        
        return temp;
    }
}
