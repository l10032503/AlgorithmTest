package Probelm;

public class KakaoBlind2020 {
	public void keyLock() {
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		keyLockSolution(key, lock);
	}
	
	private boolean keyLockSolution(int[][] keySet, int[][] lockSet) {
        boolean answer = false;
        int len = keySet.length;
        for(int i = 0; i < 3; i++) {
        	for(int a = 0; a < len; a++) {
        		for(int b = 0; b < len; b++) {
        			for(int c = 0; c < len; c++) {
        				for(int d = 0; d < len; d++) {
        					System.out.println("left : "  + a + " right : " + b + "  up : " + c + " down : " + d);
        					int[][] tempKey = copyArray(keySet);
        					tempKey = keyMoveLeft(a, tempKey);
        					tempKey = keyMoveRight(b, tempKey);
        					tempKey = keyMoveUp(c, tempKey);
        					tempKey = keyMoveDown(d, tempKey);
        					printArray(tempKey);
        					answer = unlock(tempKey, lockSet);
        					System.out.println(answer);
        					System.out.println("-----------------------------------------------");
        					if(answer)
        						return answer;
        				}
        			}
        		}
        	}
        	
        	keySet = keyRightRotation(keySet);
        }
        return answer;
    }
	
	private int[][] copyArray(int[][] originKey) {
		int len = originKey.length;
		int[][] tempKey = new int[len][len];
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len; j++) {
				tempKey[i][j] = originKey[i][j];
			}
		}
		return tempKey;
	}
	
	private boolean unlock(int[][] tempkey, int[][] lockSet) {
		boolean answer = true;
		for(int i = 0; i < tempkey.length; i++) {
			for(int j = 0; j < tempkey[i].length; j++) {
				if( (tempkey[i][j] + lockSet[i][j]) != 1) {
					answer = false;
				}
			}
		}
		return answer;
	}
	
	private int[][] keyRightRotation(int[][] originKey) {
		int len = originKey.length;
		int[][] tempKey = new int[len][len];
		
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len; j++) {
				if( i%len == 0  || j%len == 0 ) {
					tempKey[i][j] = originKey[len-j-1][i];
				}else {
					
				}
			}
		}
		
		return tempKey;
	}
	
	private int[][] keyMoveRight(int n, int[][] originKey) {
		int[][] tempKey = originKey;
		while(n > 0) {
			for(int i = 0; i < originKey.length; i++) {
				for(int j = originKey[i].length-1; j > 0; j--) {
					tempKey[i][j] = originKey[i][j-1];
				}
				tempKey[i][0] = 0;
			}
			n--;
		}
		
		return tempKey;
	}
	
	private int[][] keyMoveLeft(int n, int[][] originKey) {
		int[][] tempKey = originKey;
		while(n > 0) {
			for(int i = 0; i < originKey.length; i++) {
				for(int j = 0; j < originKey[i].length-1; j++) {
					tempKey[i][j] = originKey[i][j+1];
				}
				tempKey[i][originKey[i].length-1] = 0;
			}
			n--;
		}
		return tempKey;
	}
	
	private int[][] keyMoveUp(int n, int[][] originKey) {
		int[][] tempKey = originKey;
		while(n > 0) {
			for(int j = 0; j < originKey[0].length; j++) {
				for(int i = 0; i < originKey.length-1; i++) {
					tempKey[i][j] = originKey[i+1][j];
				}
				tempKey[originKey.length-1][j] = 0;
			}
			n--;
		}
		return tempKey;
	}
	
	private int[][] keyMoveDown(int n, int[][] originKey) {
		int[][] tempKey = originKey;
		while(n > 0) {
			for(int j = 0; j < originKey[0].length; j++) {
				for(int i = originKey.length-1; i > 0; i--) {
					tempKey[i][j] = originKey[i-1][j];
				}
				tempKey[0][j] = 0;
			}
			n--;
		}
		return tempKey;
	}
	
	private void printArray(int[][] tempKey) {
		for(int i = 0; i < tempKey.length; i++) {
			System.out.print("[");
			for(int j = 0; j < tempKey[i].length; j++) {
				System.out.print(tempKey[i][j] + ",");
			}
			System.out.println("]");
		}
	}
}
