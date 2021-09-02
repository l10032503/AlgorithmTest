package Probelm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

class Graph {
    private int V; // 노드의 개수
    private LinkedList<Integer> adj[]; // 인접 리스트
    private int count;
    private boolean answerFlag = true;
    private boolean visited[];
    
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        visited = new boolean[v];
        for (int i=0; i<v; ++i) // 인접 리스트 초기화
            adj[i] = new LinkedList();
        count = 0;
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        //Collections.sort(adj[v]);
        //Collections.sort(adj[w]);
    }
    
    int getCount() { return count; }
    
    boolean getVisited(int n) { return visited[n]; }
    
    boolean getAnswer() { return answerFlag; }
    
    public void DFS(int v) {
        DFS(v, visited);
    }

    private void DFS(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print((v+1) + " ");

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFS(n, visited);
        }
    }

    void BFS(int s) {
        count = 0;
        for (int i=0; i<V; ++i)
            visited[i] = false;

        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            count++;
            //System.out.print((s+1) + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
            //System.out.println();
        }
        count--;
    }
    
    public void bipartiteDFS(int v) {
        int colors[] = new int[V];
        colors[v] = 1;
        bipartiteDFS(v, visited, colors);
    }

    private void bipartiteDFS(int v, boolean visited[], int[] colors) {
        visited[v] = true;
        System.out.print((v+1)+" color=>" +colors[v] + " / ");

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
            	if(colors[n] == 0) {
            		if(colors[v] == 1) {
            			colors[n] = 2;
            		}else if(colors[v] == 2){
            			colors[n] = 1;
            		}
            	}else {
            	}
            	bipartiteDFS(n, visited, colors);
            }else {
            	if(colors[v] == colors[n]) {
        			answerFlag = false;
        			break;
        		}
            }
            
        }
    }

}

public class DFSBFSProblem {
	private static InputStreamReader isr = new InputStreamReader(System.in);
	private static BufferedReader br = new BufferedReader(isr);
	int min = Integer.MAX_VALUE;
	
	public void keyProblem() {
		String[][] relation = {
				{"100","ryan","music","2"},
				{"200","apeach","math","2"},
				{"300","tube","computer","3"},
				{"400","con","computer","4"},
				{"500","muzi","music","3"},
				{"600","apeach","music","2"}
		};
		keySolution(relation);
	}
	
	public int keySolution(String[][] relation) {
		int answer = 0;
		//bit(new int[] {1,2,3,4}, 4);
		/*for(int i = 0; i < relation.length; i++) {
			ArrayList<String> setList = new ArrayList<String>();
			bit(relation[i], relation[i].length);
		}*/
		// bit(relation, relation[0].length);
		return answer;
	}
	
	//상근이의 여행
	public void travelProblem() {
		travelSolution();
	}
	public void travelSolution() {
		isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);
		try {
			int T = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < T; i++) {
				int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				System.out.println(airplaneLine(input));
			}
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int airplaneLine(int[] input) {
		try {
			Graph g = new Graph(input[0]);
			for(int i = 0; i<input[1]; i++) {
				int[] airplane = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				g.addEdge(airplane[0]-1, airplane[1]-1);
			}
			
			g.BFS(0);
			min = g.getCount();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return min;
	}
	
	//스타트와 링크
	public void startLink() {
		startLinkSolution();
	}
	
	private void startLinkSolution() {
		isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);
		
		try {
			int N = Integer.parseInt(br.readLine());
			int[][] members = new int[N][N];
			for(int i = 0; i < N; i++) {
				members[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			combination(members, new boolean[N], 0, N, N/2);
			System.out.println(min);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void combination(int[][] arr, boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
        	int temp = getStatusGap(arr, visited, n);
        	if(temp < min)
        		min = temp;
            return;
        }
        
        if (depth == n) {
            return;
        }

        visited[depth] = true;
        combination(arr, visited, depth + 1, n, r - 1);

        visited[depth] = false;
        combination(arr, visited, depth + 1, n, r);
    }
	
	private int getStatusGap(int[][] arr, boolean[] visited, int n) {
		int[] team1 = new int [n/2];
		int[] team2 = new int [n/2];
		int team1Status = 0;
		int team2Status = 0;
		int temp1 = 0;
		int temp2 = 0;
		for (int i = 0; i < n; i++) {
            if (visited[i]) {
            	team1[temp1++] = i;
            }else {
            	team2[temp2++] = i;
            }
        }
		
		team1Status = getTeamStatus(arr, team1);
		team2Status = getTeamStatus(arr, team2);
		System.out.println(Arrays.toString(team1) + " -> " + team1Status);
		System.out.println(Arrays.toString(team2) + " -> " + team2Status);
		if(team1Status > team2Status) {
			return team1Status - team2Status;
		}else {
			return team2Status - team1Status;
		}
	}
	
	private int getTeamStatus(int[][] arr, int[] team) {
		int teamStatus = 0;
		for (int i = 0; i < team.length; i++) {
			for (int j = 0; j < team.length; j++) {
				if(i == j) {
					continue;
				}else {
					teamStatus += arr[team[i]][team[j]];
				}
			}
		}
		
		return teamStatus;
	}
	
	private static int count = 0;
	
	public static void onetwothree() {
		isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);
		
		try {
			int T = Integer.parseInt(br.readLine());
			for(int i = 0; i < T; i++) {
				count = 0;
				int n = Integer.parseInt(br.readLine());
				onetwothreeSolution(n);
				System.out.println(count);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void onetwothreeSolution(int n) {
		if(n == 0) {
			count++;
			return;
		}
		if(n >= 3) {
			onetwothreeSolution(n-3);
		}
		if(n >= 2) {
			onetwothreeSolution(n-2);
		}
		if(n >= 1) {
			onetwothreeSolution(n-1);
		}
		return;
	}
	
	//이분그래프
	public static void bipartiteGraph() {
		isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);
		try {
			int K = Integer.parseInt(br.readLine());
			for(int i = 0; i < K; i++) {
				int[] input= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				
				checkGraph(input[0], input[1]);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void checkGraph(int V, int E) {
		Graph g = new Graph(V);
		try {
			for(int i = 0; i < E; i++) {
				int[] line= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				g.addEdge(line[0]-1, line[1]-1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(int i = 0; i < V ; i++) {
			if(!g.getVisited(i))
				g.bipartiteDFS(i);
		}
		if(g.getAnswer()) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
	
	//단어변환
	public void transWord() {
		String[] words = {
				"hot", "dot", "dog", "lot", "log", "cog"
		};
		transWordSolution("hit","cog",words);
		String[] words2 = {
				"dot", "dog", "lot", "log", "cog", "hot"
		};
		transWordSolution("hit","cog",words2);
	}
	
	private int transWordSolution(String begin, String target, String[] words) {
		int answer = Integer.MAX_VALUE;
		
		HashMap<String, LinkedList<String>> map = getWordsMap(words);
		
		String startWord = null; 
        if(!Arrays.asList(words).contains(target))
        	return answer;
        for(int i = 0; i < words.length; i++) {
        	if(checkWords(begin, words[i])) {
        		startWord = words[i];
        		int distance = BFS(startWord, target, words, map);
        		if(distance < answer)
        			answer = distance;
        		System.out.println(distance);
        	}
        }
		
		return answer;
	}
	
    private int BFS(String begin, String target, String[] words, HashMap<String, LinkedList<String>> map) {
    	int count = 0;
    	LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(new Node(begin, 1));
        
        
        while (queue.size() != 0) {
            Node node = queue.poll();
            String s = node.getString();
            int depth = node.getDepth();
            //System.out.print((s) + " ");
            if(s.equals(target)) {
            	count = depth;
            	break;
            }
            LinkedList<String> tempList = map.get(s);  
            map.remove(s);
            
            Iterator<String> i = tempList.listIterator();
            while (i.hasNext()) {
            	String word = i.next();
            	if(map.containsKey(word)) {
            		boolean insertFlag = true;
            		for(Node temp : queue) {
            			if(temp.getString().equals(word)) {
            				insertFlag = false;
            				break;
            			}
            		}
            		if(insertFlag)
            			queue.add(new Node(word, ++depth));
            	}
                /*int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }*/
            }
            //System.out.println();
        }
        
        return count;
    }
	
	private HashMap<String,LinkedList<String>> getWordsMap(String[] words) {
		HashMap<String,LinkedList<String>> map = new HashMap<String,LinkedList<String>>();
		
		for(int i = 0; i < words.length ; i++) {
			LinkedList<String> transList = new LinkedList<String>();
			for(int j = 0; j < words.length ; j++) {
				if(i == j) {
					continue;
				}else {
					if(checkWords(words[i], words[j]))
						transList.add(words[j]);
				}
			}
			map.put(words[i], transList);
		}
		
		return map;
	}
	
	private boolean checkWords(String word1, String word2) {
		int count = 0;
		for(int i = 0; i < word1.length(); i++) {
			char c1 = word1.charAt(i);
			char c2 = word2.charAt(i);
			if(c1 != c2)
				count++;
		}
		
		if(count == 1) {
			return true;
		}else {
			return false;
		}
	}
}

class Node{
    private String s;
    private int depth;

    Node(String _s, int _depth){
        this.s = _s;
        this.depth = _depth;
    }
    
    public String getString() {return s;}
    public int getDepth() {return depth;}
}