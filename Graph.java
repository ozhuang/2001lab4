package lab4;

import java.util.ArrayList;
import java.util.Scanner;

public class Graph {

	public static ArrayList<Integer>[] Graphlist = null;
	public int Vertix;
	int i;

	public Graph(int Vertix) {
		Graphlist = (ArrayList<Integer>[]) new ArrayList[Vertix + 1];
		this.Vertix = Vertix + 1;
		for (i = 0; i < Vertix; i++) {
			Graphlist[i] = new ArrayList<Integer>();
		}

	}

	public boolean checke(int o, int n) {
		if (Graphlist[o] == null)
			Graphlist[o] = new ArrayList<Integer>();

		if (Graphlist[n] == null)
			Graphlist[n] = new ArrayList<Integer>();
		if (o == n) {
			return false;
		}

		for (int j : Graphlist[o]) {
			if (j == n) {
				return false;
			}
		}

		for (int v : Graphlist[n])
			if (v == o)
				return false;

		return true;
	}

	public void addE(int o, int n) {
		if (Graphlist[o] == null) {
			Graphlist[o] = new ArrayList<Integer>();
		}
		Graphlist[o].add(n);

		if (Graphlist[n] == null)
			Graphlist[n] = new ArrayList<Integer>();
		Graphlist[n].add(o);
	}

	public boolean checkneighbour(int o, int n) {
		if (Graphlist[o] == null) {
			return false;
		}
		for (int j : Graphlist[o]) {
			if (j == n)
				return true;

		}
		return false;
	}

	public ArrayList<Integer> getneighbour(int o) {
		return Graphlist[o];
	}

	public void print() {
		int i;
		for (i = 0; i < Vertix; i++) {
			if (Graphlist[i] != null) {
				System.out.println("Oringinal point:" + i);
				for (int j : Graphlist[i]) {
					System.out.println("Neighbour:" + j);

				}
			}
		}
	}

}