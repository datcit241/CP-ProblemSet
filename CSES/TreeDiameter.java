import java.io.*;
import java.util.*;

public class TreeDiameter {
	static int diameter;

	public static void main(String[] args) {
		int n = ni();
		
		if (n == 1) {
			System.out.print(0);
			return;
		}

		Node[] nodes = new Node[n + 1];

		for (int i = 1; i <= n; i++) {
			nodes[i] = new Node();
		}

		for (int i = 1; i < n; i++) {
			int u = ni(), v = ni();
			
			nodes[u].add(nodes[v]);
			nodes[v].add(nodes[u]);
		}
		
		int height = dfs(nodes[1]);
		diameter = Math.max(diameter, height);
		
		System.out.print(diameter);

	}
	
	static int dfs(Node node) {
		node.visited = true;
		
		if (node.children.size() == 1) {
			Node next = node.children.poll();
			if (next.visited) {
				return 1;
			}
			
			return dfs(next);
		}
		
		int max1 = 0, max2 = 0;
		
		while (node.children.size() != 0) {
			Node next = node.children.poll();
			if (!next.visited) {
				int maxHeight = dfs(next);
				if (maxHeight > max1) {
					max2 = max1;
					max1 = maxHeight;
				}
			}
			
		}
		
		diameter = Math.max(diameter, max1 + max2);
		return 1 + max1;
		
	}

	static class Node {
		boolean visited = false;
		Queue<Node> children = new ArrayDeque<>();

		public void add(Node node) {
			children.add(node);
		}
	}

	static InputStream is = System.in;
	static byte[] inbuf = new byte[1 << 24];
	static int lenbuf = 0, ptrbuf = 0;

	static int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	static boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	static boolean isSpaceChar2(int c) {
		return !(c >= 32 && c <= 126);
	}

	static int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	static double nd() {
		return Double.parseDouble(ns());
	}

	static char nc() {
		return (char) skip();
	}

	static String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static String nextLine() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar2(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

}
