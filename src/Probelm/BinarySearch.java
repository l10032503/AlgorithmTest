package Probelm;
import java.util.HashMap;
import java.util.Map;

import Util.Input;

public class BinarySearch {
	public void baekjoon1920() {
		try {
			int n = Input.inputInteger();
			int nArray[] = Input.inputIntegerArray();
			int m = Input.inputInteger();
			int mArray[] = Input.inputIntegerArray();
			baekjoon1920Solution(n,nArray,m,mArray);
		} catch (NumberFormatException e) {
			throw e;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	// O(N)
    public void baekjoon1920Solution(int n, int[] nArray, int m, int[] mArray) {
        Map<Integer, Integer> check = new HashMap<>();
        // if n<m, n==m, n>m case °í·Á
        for(int i=0 ; i<n ; i++) {
            check.put(nArray[i], check.getOrDefault(nArray[i], 0) + 1);
        }

        for(int i=0 ; i<m ; i++) {
            if(check.containsKey(mArray[i])) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
	
}
