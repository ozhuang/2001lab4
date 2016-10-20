package lab4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.HashMap;

public class BFSshortestpath {
	public static Graph Graphinput() {
		int v, e;
		Scanner sc = new Scanner(System.in);
		System.out.println("How many Vertix you want:");
		v = sc.nextInt();
		System.out.println("How many Edges you want:");
		e = sc.nextInt();
		if(e>((v*(v-1))/2)){
			System.out.println("Vertix is out of range!!!");
		}
   
		int i;
		int rand1, rand2;

		Graph graph = new Graph(v);
		for (i = 0; i < e; i++) {
			rand1 = (int) (Math.random() * v + 1);
			rand2 = (int) (Math.random() * v + 1);
			if (graph.checke(rand1, rand2)) {
				graph.addE(rand1, rand2);
			} else {
				i--;
			}

		}
		graph.print();
		return graph;

	}

	public static void main(String[] args) {
		Graph graph = Graphinput();
		if (graph == null)
			System.out.println("no significant graph");
		int start, end;
		char choice='c';

		Scanner sc = new Scanner(System.in);
		
			System.out.println("which number you want to start:");
			start = sc.nextInt();
			System.out.println("Number you want to connect to:");
			end = sc.nextInt();
			
			

			BFSshortestpath.Shortestpath(graph, end, start);
		
	}

	public static void Shortestpath(Graph graph, int start, int end) {

		ArrayList<Integer> shortestPath = BFS(graph, start, end);

		if (shortestPath != null) {
			System.out.print("ShortestPath from"+" " + end + " " + "to" + " " + start + " is [ ");
			for (int i : shortestPath) {
				System.out.print(i + " ");

			}
			System.out.println("]");
			System.out.println("The shortest path level is:" + " " + (shortestPath.size() - 1));

		}
	}

	public static ArrayList<Integer> BFS(Graph graph, int start, int finish) {
		ArrayList<Integer> directions = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> visited = new ArrayList<Integer>();
		HashMap<Integer, Integer> pre = new HashMap<Integer, Integer>();

		int current = start;
		q.add(current);
		while (!q.isEmpty()) {
			current = q.remove();

			if (current == finish) {
				break;
			} else {
				ArrayList<Integer> neighbour = graph.getneighbour(current);
				if (neighbour == null) {
					System.out.println("can't reach destination");
					return null;
				} else {
					for (int j : neighbour) {
						if (!visited.contains(j)) {
							q.add(j);
							visited.add(j);
							pre.put(j, current);
						}
					}
				}
			}
		}
		if (current != finish) {
			System.out.println("can't reach destination");
			return null;
		}
		for (int i = finish; i != start; i = pre.get(i)) {
			directions.add(i);
		}
		directions.add(start);

		return directions;

	}
}
