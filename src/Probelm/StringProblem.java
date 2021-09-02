package Probelm;

public class StringProblem {
	public void stringCompact() {
		//System.out.println(solutionCompact("aabbaccc"));
		//System.out.println(solutionCompact("ababcdcdababcdcd"));
		//System.out.println(solutionCompact("abcabcdede"));
		//System.out.println(solutionCompact("abcabcabcabcdededededede"));
		//System.out.println(solutionCompact("xababcdcdababcdcd"));
	}
	
	/*public int solutionCompact(String s) {
        int answer = 0;
        StringBuffer compact = new StringBuffer();
        for(int i = 1; i < s.length()-1; i++) {
        	StringBuffer temp = new StringBuffer();
        	String leftover = s;
        	while(leftover.length() > i) {
        		String leftover2 = leftover;
        		String key = leftover.substring(0,i);
        		int cnt = 0;
        		while(leftover.length() <= i+i) {
        			String compare = leftover2.substring(i,i+i);
        			if(key.equals(compare)) {
        				cnt++;
        			}
        			
        		}
        		if(cnt > 0) {
        			
        		}
        		
            }
        	temp.append(leftover);
        	if(compact.length() == 0 || temp.length() < compact.length()) {
        		compact = temp;
        	}
        }
        System.out.println(compact.toString());
        answer = compact.length();
        return answer;
    }*/
	
}
