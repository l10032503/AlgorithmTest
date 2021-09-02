package Probelm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class DevMatching2021 {
	
	private int[][] matrix;
	public void rotationMatrix() {
		int[][] queries = {
				{2,2,5,4},{3,3,6,6},{5,1,6,3}
		};
		rotationMatrixSolution(6,6,queries);
	}
	
	private int[] rotationMatrixSolution(int rows, int columns, int[][] queries) {
        int[] answer = new int [queries.length];
        matrix = new int[rows][columns];
        
        for(int i = 0; i <rows; i++) {
        	for(int j = 0; j <columns; j++) {
        		matrix[i][j] = columns*i + (j+1);
        	}
        }
        
        for(int i = 0; i <queries.length; i++) {
        	answer[i] = rotationQuery(queries[i]);
        }
        
        //System.out.println(Arrays.toString(answer));
        return answer;
    }
	
	private int rotationQuery(int[] query) {
		int answer = Integer.MAX_VALUE;
		int startX = query[0]-1;
		int startY = query[1]-1;
		int endX = query[2]-1;
		int endY = query[3]-1;
		int copy = matrix[startX][startY];
		int buffer = 0;
		
		for(int i = startY; i <endY; i++) {
			buffer = matrix[startX][i+1];
			matrix[startX][i+1] =  copy;
			answer = Math.min(copy, answer);
			copy = buffer;
		}
		
		for(int i = startX; i <endX; i++) {
			buffer = matrix[i+1][endY];
			matrix[i+1][endY] =  copy;
			answer = Math.min(copy, answer);
			copy = buffer;
		}
		
		for(int i = endY; i > startY; i--) {
			buffer = matrix[endX][i-1];
			matrix[endX][i-1] =  copy;
			answer = Math.min(copy, answer);
			copy = buffer;
		}
		
		for(int i = endX; i > startX; i--) {
			buffer = matrix[i-1][startY];
			matrix[i-1][startY] =  copy;
			answer = Math.min(copy, answer);
			copy = buffer;
		}
		
		return answer;
	}
	
	public void distanceSociety() {
		distanceSolution(new String[][] {
		{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
		{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
		{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
		{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
		{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
		});
		distanceSolution(new String[][] {
					{"OOPOO", "OPOOO", "OOOOO", "OOOOO", "OOOOO"},
		});
	}
	
	private int[] distanceSolution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i = 0; i < places.length; i++) {
        	String [] place = places[i];
        	System.out.println(i + "¹øÂ°");
			char[][] seats = new char[place.length][place.length];
        	for(int j = 0; j < place.length; j++) {
        		seats[j] = place[j].toCharArray();
        	}
        	answer[i] = findPerson(seats);
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
	
	private int findPerson(char[][] seats) {
		for(int i = 0; i < seats.length; i++) {
			for(int j = 0; j < seats[i].length; j++) {
				char seat = seats[i][j];
				if(seat == 'P') {
					if(!distanceCheck(seats, i, j)) {
						return 0;
					}
				}
			}
		}
		
		return 1;
	}
	
	private boolean distanceCheck(char[][] seats, int i, int j) {
		if((i+1) < seats.length) {
			if(seatsCheck(seats, i+1, j, 'P')) {
				return false;
			}
			
			//System.out.println(seats[i+1].length + " / " + (i+1) + "," + (j+1) + " : " + seats[i+1][j+1]);
			if((j+1) < seats[i+1].length) {
				if(seatsCheck(seats, i+1, j+1, 'P')) {
					if(seatsCheck(seats, i+1, j, 'O')  && seatsCheck(seats, i, j+1, 'O')) {
						return false;
					}
				}
			}
			
			if((j-1) > 0) {
				if(seatsCheck(seats, i+1, j-1, 'P')) {
					if(seatsCheck(seats, i+1, j, 'O')  && seatsCheck(seats, i, j-1, 'O')) {
						return false;
					}
				}
			}
		}
		
		if((i-1) > 0) {
			if(seatsCheck(seats, i-1, j, 'P')) {
				return false;
			}
			
			//System.out.println(seats[i+1].length + " / " + (i+1) + "," + (j+1) + " : " + seats[i+1][j+1]);
			if((j+1) < seats[i-1].length) {
				if(seatsCheck(seats, i-1, j+1, 'P')) {
					if(seatsCheck(seats, i-1, j, 'O')  && seatsCheck(seats, i, j+1, 'O')) {
						return false;
					}
				}
			}
			
			if((j-1) > 0) {
				if(seatsCheck(seats, i-1, j-1, 'P')) {
					if(seatsCheck(seats, i-1, j, 'O')  && seatsCheck(seats, i, j-1, 'O')) {
						return false;
					}
				}
			}
		}
		
		if((j+1) < seats[i].length) {
			if(seatsCheck(seats, i, j+1, 'P')) {
				return false;
			}
		}
		
		if((j-1) > 0) {
			if(seatsCheck(seats, i, j-1, 'P')) {
				return false;
			}
		}
		
		
		if((i+2) < seats.length) {
			if(seatsCheck(seats, i+2, j, 'P')) {
				if(seatsCheck(seats, i+1, j, 'O')) {
					return false;
				}
			}
		}
		
		if((i-2) > 0) {
			if(seatsCheck(seats, i-2, j, 'P')) {
				if(seatsCheck(seats, i-1, j, 'O')) {
					return false;
				}
			}
		}
		
		if((j+2) < seats[i].length) {
			if(seatsCheck(seats, i, j+2, 'P')) {
				if(seatsCheck(seats, i, j+1, 'O')) {
					return false;
				}
			}
		}
		
		if((j-2) > 0) {
			if(seatsCheck(seats, i, j-2, 'P')) {
				if(seatsCheck(seats, i, j-1, 'O')) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	private boolean seatsCheck(char[][] seats, int x, int y, char icon) {
		if(seats[x][y] == icon) {
			return true;
		}else {
			return false;
		}
	}
	
	public void multipleLevel() {
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};
		System.out.println(Arrays.toString(multiLevelSolution(enroll, referral, seller, amount)));
		
	}
	
	private int[] multiLevelSolution(String[] enroll, String[] referral, String[] sellers, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String, String> recommendMap = new HashMap<String, String>();
        HashMap<String, Integer> sellerAccountList = new HashMap<String, Integer>();
        
        for(int i = 0; i < enroll.length; i++) {
        	String recommend = referral[i];
        	String member = enroll[i];
        	if(!recommend.equals("-")) {
        		recommendMap.put(member, recommend);
        	}else {
        		recommendMap.put(member, "center");
        	}
        	sellerAccountList.put(member, 0);
        }
        
        for(int i = 0; i < sellers.length; i++) {
        	String seller = sellers[i];
        	int money = amount[i]*100;
        	HashMap<String, Integer> divideInterest = new HashMap<String, Integer>();
        	divideInterest.put(seller, (int) (money));
    		
    		
        	while(true) {
        		String recommend = recommendMap.get(seller);
        		
        		int sellerInterest = divideInterest.get(seller);
        		int recommendInterest = (int) (sellerInterest*0.1);
        		divideInterest.put(seller, (int) (sellerInterest - recommendInterest));
        		divideInterest.put(recommend, recommendInterest);
        		
        		seller = recommend;
        		if(recommend.equals("center") || recommendInterest < 10) {
        			break;
        		}
        	}
        	
        	for( String member : divideInterest.keySet() ){
        		sellerAccountList.put(member, sellerAccountList.getOrDefault(member, 0) +  divideInterest.get(member));
            }
        }
        
        for(int i = 0; i < enroll.length; i++) {
        	String member = enroll[i];
        	answer[i] = sellerAccountList.getOrDefault(member, 0);
        }
        
        return answer;
    }
	
	public void editTable() {
		String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
		
		System.out.println(editTableSolution(8,2,cmd));
		
		String[] cmd2 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
		
		System.out.println(editTableSolution(8,2,cmd2));
		
	}
	
	private String editTableSolution(int n, int k, String[] cmds) {
        int pointer = 0;
        HashMap<Integer,String> job = new HashMap<Integer,String>();
        LinkedList<Integer> deleteJob = new LinkedList<Integer>();
        int lastNumber = n-1;
        for(int i = 0; i<n; i++) {
        	job.put(i,"O");
        	if(i == k) {
        		pointer = i;
        	}
        }
        
        for(int i = 0; i < cmds.length; i++) {
        	String[] cmd = cmds[i].split(" ");
        	if(cmd[0].equals("U")){
        		pointer = upPointer(pointer, Integer.parseInt(cmd[1]), job);
        	}else if(cmd[0].equals("D")){
        		pointer = downPointer(pointer, Integer.parseInt(cmd[1]), job);
        	}else if(cmd[0].equals("C")){
        		deleteJob.add(pointer);
        		int deletePos = pointer;
        		if(pointer < lastNumber) {
        			pointer = downPointer(pointer, 1, job);
        		}else if(pointer == lastNumber){
        			pointer = upPointer(pointer, 1, job);
        			lastNumber = pointer;
        		}
        		job.put(deletePos,"X");
        	}else if(cmd[0].equals("Z")){
        		int resotreJob = deleteJob.pollLast();
        		job.put(resotreJob,"O");
        		lastNumber = Math.max(resotreJob, lastNumber);
        	}
        	
        	//System.out.print(job.toString());
        	//System.out.println(" " + pointer);
        }
        
        StringBuffer answerBuffer = new StringBuffer();
        for(int key : job.keySet()) {
        	answerBuffer.append(job.get(key));
        }
        
        return answerBuffer.toString();
    }
	
	private int downPointer(int pointer, int distance, HashMap<Integer,String> job) {
		int pos = pointer;
		while(distance > 0){
			if(job.get(++pos).equals("O")) {
				distance--;
			}
		}		
		return pos;
	}
	
	private int upPointer(int pointer, int distance, HashMap<Integer,String> job) {
		int pos = pointer;
		while(distance > 0){
			if(job.get(--pos).equals("O")) {
				distance--;
			}
		}
		return pos;
	}
}
