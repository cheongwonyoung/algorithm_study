package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



public class BOJ1991 {
	
	static class Node{
		String left;
		String right;
		
		public Node( String left, String right) {
			this.left = left;
			this.right = right;
		}
		
	}
	static List<Node>[] list;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		list = new ArrayList[n];
		for(int i=0; i<n; i++) {
			list[i] = new ArrayList<>();
			
		}
		for(int i=0; i<n; i++) {
			String[] temp = in.readLine().split(" ");
			list[temp[0].charAt(0)-'A'].add(new Node(temp[1],temp[2]));
		}
		preorder(0);
		sb.append("\n");
		inorder(0);
		sb.append("\n");
		postorder(0);
		
		System.out.println(sb.toString());
	}
	static void preorder(int start) {
		for(Node node : list[start]) {
			int l = (int)node.left.charAt(0)-'A';
			int r = (int)node.right.charAt(0)-'A';
			
			sb.append((char)(start+'A'));
			if(l>=0) preorder(l);
			if(r>=0) preorder(r);
		}
	}
	static void inorder(int start) {
		for(Node node : list[start]) {
			int l = (int)node.left.charAt(0)-'A';
			int r = (int)node.right.charAt(0)-'A';
			
			if(l>=0) inorder(l);
			sb.append((char)(start+'A'));
			if(r>=0) inorder(r);
		}
	}
	static void postorder(int start) {
		for(Node node : list[start]) {
			int l = (int)node.left.charAt(0)-'A';
			int r = (int)node.right.charAt(0)-'A';
			
			if(l>=0) postorder(l);
			if(r>=0) postorder(r);
			sb.append((char)(start+'A'));
		}
	}
	
	
}
