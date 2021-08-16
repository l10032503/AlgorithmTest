package Probelm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackProblem {
	public void bracketProblem() {
		System.out.println(bracketSolution("(()())()"));
		System.out.println(bracketSolution(")("));
		System.out.println(bracketSolution("()))((()"));
	}
	
	public String bracketSolution(String p) {
		String answer = "";
		if(p.length() == 0) {
			return p;
		}else {
			int idx = getBalancedIdx(p);
			String u = p.substring(0, idx + 1);
			String v = p.substring(idx + 1);
			if (isValid(u)) {
				return u+bracketSolution(v);
			}else {
				answer = "(" + bracketSolution(v) + ")";
				for (int i = 1; i < u.length()-1; i++) {
	                char c = u.charAt(i);
	                if(c==')')
	                	answer+='(';
	                else
	                	answer+=')';
	            }
			}
				
		}
		return answer;
	}
	
	public int getBalancedIdx(String p) {
		int idx = 0;
		for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '(')
            	idx++;
            else {
            	idx--;
            }
            if (idx == 0)
                return i;
        }
        return -1;
	}
	
	public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(')
                s.push(c);
            else if (!s.isEmpty() && c == ')')
                s.pop();
            else {
                return false;
            }
        }
        return s.isEmpty();
    }
	
	public void baekjoon4949() {
		solution4949();
	}
	
	public void solution4949() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			while(true) {
				
		        String input = null;
				try {
					input = br.readLine();
				} catch (IOException e) {
					throw e;
				}
				if(input.equals(".")) {
					break;
				}
				Stack<Character> bracket = new Stack<Character> ();
				boolean answer = true;
				for(int i = 0; i < input.length(); i++) {
					char c = input.charAt(i);
					char top;
					switch (c){
					case '(':
						bracket.push(c);
						break;
					case ')':
						if(bracket.isEmpty()) {
							answer = false;
						}else {
							top = bracket.peek();
							if(top == '(') {
								answer = true;
								bracket.pop();
							} else {
								answer = false;
							}
						}
						break;
					case '[':
						bracket.push(c);
						break;
					case ']':
						if(bracket.isEmpty()) {
							answer = false;
						}else {
							top = bracket.peek();
							if(top == '[') {
								answer = true;
								bracket.pop();
							} else {
								answer = false;
							}
						}
						break;
					default:
							break;
					}
					
					if(!answer)
						break;
				}
				if(answer) {
					if(bracket.size() > 0) {
						System.out.println("no");
					} else {
						System.out.println("yes");
					}
				}else {
					System.out.println("no");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
