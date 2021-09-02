package Probelm;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


class InfoLinkedIn{
	private String info;
	private LinkedList<InfoLinkedIn> infoLink;
	
	InfoLinkedIn(String info, LinkedList<InfoLinkedIn> infoLink){
		this.info = info;
		this.infoLink = infoLink;
	}
	
	public String getInfo() {
		return this.info;
	}
	
	public LinkedList<InfoLinkedIn> getNextLink() {
		return this.infoLink;
	}
	
	public void setNextInfo(InfoLinkedIn infoLink) {
		this.infoLink.add(infoLink);
	}
}

class RoadGraph{
    private int n;
    private HashMap<Integer,Integer>[] maps;
    private int distance[];
    public RoadGraph(int n){
        this.n = n;
        maps = new HashMap[n+1];
        for(int i = 0; i < n+1; i++) {
        	maps[i] = new HashMap<Integer,Integer>();
        }
         
    }
    public void input(int s,int d,int c){
        maps[s].put(d, c);
        maps[d].put(s, c);
    }
 
    public int dijkstra(int src, int dst){
        distance = new int[n+1];          //최단 거리를 저장할 변수
        for(int i = 0 ; i< distance.length; i++) {
        	distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;
        
        LinkedList<int[]> priorityQueue = new LinkedList<int[]>();
        
        priorityQueue.add(new int[] {src,0});
        
        while(priorityQueue.size()>0) {
        	int[] temp = priorityQueue.pop();
        	
        	if(distance[temp[0]] < temp[1])
        		continue;
        	for(Integer node : maps[temp[0]].keySet()) {
        		int cost = maps[temp[0]].get(node);
        		cost += temp[1];
        		if(cost < distance[node]) {
        			distance[node] = cost;
        			priorityQueue.push(new int[] {node, cost});
        		}
        		
        	}
        }
        
        return distance[dst];
    }
    
    public int[] getDistance(){
        return distance;
    }
}

public class KakaoBlind2021 {
	
	private HashMap<String,Integer> menuList;
	private static int[][] board;
	private static LinkedList<int[]> cardPos;
	private int count;
	public void renewalMenu() {
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] courses = {2,3,4};
		System.out.println(Arrays.toString(renewalMenuSolution(orders, courses)));
	}
	
	private String[] renewalMenuSolution(String[] orders, int[] courses) {
        LinkedList<String> answerList = new LinkedList<String>();
        
        for(int i = 0; i < courses.length; i++) {
        	menuList = new HashMap<String,Integer>();
        	LinkedList<String> tempList = new LinkedList<String>();
        	int max = 0;
        	for(String order : orders) {
        		boolean[] visited = new boolean[order.length()];
            	combination(order, visited, 0, order.length(), courses[i]);
        	}
        	
        	for(String menu : menuList.keySet()) {
        		int menuCnt = menuList.get(menu);
        		if(menuCnt > 1) {
        			if(max < menuCnt) {
        				max = menuCnt;
        				tempList.removeAll(tempList);
        				tempList.add(menu);
        			}else if(max == menuList.get(menu)){
        				tempList.add(menu);
        			}
        		}
        	}
        	answerList.addAll(tempList);
        }
        
        Collections.sort(answerList);
        String[] answer = answerList.toArray(new String[answerList.size()]);
        return answer;
    }
	
	private void combination(String order, boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
        	addMenuList(order, visited, n);
            return;
        }
        
        if (depth == n) {
            return;
        }

        visited[depth] = true;
        combination(order, visited, depth + 1, n, r - 1);

        visited[depth] = false;
        combination(order, visited, depth + 1, n, r);
    }
	
	private void addMenuList(String order, boolean[] visited, int n) {
		LinkedList<Character> tempMenu = new LinkedList<Character>();
		for (int i = 0; i < n; i++) {
            if (visited[i]) {
                tempMenu.add(order.charAt(i));
            }
        }
		Collections.sort(tempMenu);
		String menu = tempMenu.stream().map(String::valueOf).collect(Collectors.joining());
		menuList.put(menu, menuList.getOrDefault(menu, 0) + 1);
	}
	
	public void searchRanking() {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		System.out.println(Arrays.toString(searchRankingSolution(info, query)));
	}
	
	private int[] searchRankingSolution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        HashMap<String,LinkedList<String>> infoMap = getInfoTable(info);
        return answer;
    }
	
	private HashMap<String,LinkedList<String>> getInfoTable(String[] infos){
		HashMap<String,LinkedList<String>> infoMap = new HashMap<String,LinkedList<String>>();
		
		//infoMap.put("cpp", null);
		//infoMap.put("java", null);
		//infoMap.put("null", null);
		
		/*for(String info : infos) {
			String[] applier = info.split(" ");
			String key = applier[0];
			for(int i = 0; i < applier.length-1; i++) {
				LinkedList<String> infoList = infoMap.getOrDefault(key, new LinkedList<String>());
				if(!infoList.contains(key+applier[i+1])) {
					infoList.add(key+applier[i+1]);
					infoMap.put(key, infoList);
					key = key+applier[i+1];
				}
			}
			LinkedList<String> infoList = infoMap.getOrDefault(key, new LinkedList<>(List.of("0")));
			int count = Integer.getInteger(infoList.pop()+1);
			infoList.push(count+"");
			infoMap.put(key, infoList);
		}*/
		return infoMap;
	}
	
	public void carSharing() {
		int [][] fares = {
				{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}	
		};
		
		System.out.println(carSharingSolution(6,4,6,2,fares));
	}
	
	private int carSharingSolution(int n, int s, int a, int b, int[][] fares) {
        RoadGraph roadGraph = new RoadGraph(n);
        
        for(int i = 0; i< fares.length; i++) {
        	roadGraph.input(fares[i][0], fares[i][1], fares[i][2]);
        }
        
        int cost = roadGraph.dijkstra(s, a) + roadGraph.dijkstra(s, b);

        for(int i = 1; i <= n; i++) {
        	if(s!= i)
        		System.out.println("current cost : " + cost + " / " + roadGraph.dijkstra(s, i) + " / " + roadGraph.dijkstra(i, a) + " / " + roadGraph.dijkstra(i, b));
        		cost = Math.min(cost, roadGraph.dijkstra(s, i) + roadGraph.dijkstra(i, a) + roadGraph.dijkstra(i, b));
        }
        
        return cost;
    }

	public void cardMatching() {
		count = 0;
		int[][] board = {
				{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}
		};
		System.out.println(cardMatchingSolution(board, 1, 0));
	}
	
	private int cardMatchingSolution(int[][] board2, int r, int c) {
        int answer = 0;
        board = board2;      
        int cursorRow = r;
        int cursorCol = c;
        cardPos = new LinkedList<int[]>();
        
        getCardPosition();
        
        int enter = cardPos.size();
        
        while(cardPos.size() > 0) {
        	int[] card = getMinMoveCount(cursorRow, cursorCol);
        	cursorRow = card[0];
        	cursorCol = card[1];
        	int targetCard = board[cursorRow][cursorCol];
        	board[cursorRow][cursorCol] = 0;
        	card = getTargetMoveCount(cursorRow, cursorCol, targetCard);
        	cursorRow = card[0];
        	cursorCol = card[1];
        }
        
        answer = count + enter;
        return answer;
    }
	
	private void getCardPosition() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				int cell = board[i][j];
				if(cell != 0) {
					cardPos.add(new int[] {i, j});
				}
			}
		}
	}
	
	private int[] getMinMoveCount(int startRow, int startCol) {
		int[] pos = new int[2];
		int idx = 0;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < cardPos.size(); i++) {
        	int[] card = cardPos.get(i);
        	int distance = getDistance(startRow, startCol, card[0], card[1]);
        	if(min > distance) {
        		min = distance;
        		idx = i;
        		pos[0] = card[0];
        		pos[1] = card[1];
        	}
        }
		count += min;
		cardPos.remove(idx);
		return pos;
	}
	
	private int[] getTargetMoveCount(int startRow, int startCol, int target) {
		int[] pos = new int[2];
		int idx = 0;
		int distance = 0;
		for (int i = 0; i < cardPos.size(); i++) {
        	int[] card = cardPos.get(i);
        	if(board[card[0]][card[1]] == target) {
        		idx = i;
        		distance = getDistance(startRow, startCol, card[0], card[1]);
        		pos[0] = card[0];
        		pos[1] = card[1];
        	}
		}
		count += distance;
		cardPos.remove(idx);
		return pos;
	}
	
	private int getDistance(int srcX, int srcY, int dstX, int dstY) {
		int distance = Integer.MAX_VALUE;
		if(srcX == dstX && srcY == dstY) { //커서 위치에 카드가 있음
    		distance = 0;
    	}else if(srcX == dstX) { // 같은 열에 있음
    		distance = 1;
    	}else if(srcY == dstY) { // 같은 행에 있음
    		distance = 1;
    	}else {
    		int temp = Math.min(Math.abs(srcX - dstX), Math.abs(srcY - dstY));
    		distance = temp+1;
    	}
		
		return distance;
	}
	
	
}

