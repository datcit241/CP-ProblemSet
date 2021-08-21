import java.io.*;
import java.util.*;

public class Subordinates {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int n = ni();

		Vertex[] vertices = new Vertex[n + 1];

		for (int i = 1; i <= n; i++) {
			vertices[i] = new Vertex();
		}

		for (int i = 2; i <= n; i++) {
			vertices[ni()].add(vertices[i]);
		}
		
		dfs(vertices[1]);
		
		for (int i = 1; i <= n; i++) {
			sb.append(vertices[i].subordinates).append(' ');
		}
		System.out.print(sb);

	}
	
	static int dfs(Vertex v) {
		v.visited = true;
		
		if (v.queue.size() == 1) {
			Vertex next = v.queue.poll();
			
			if (!next.visited) {
				v.subordinates = dfs(next);
				return 1 + v.subordinates;
			}
			
			return 1;
		}
		
		while (v.queue.size() != 0) {
			Vertex next = v.queue.poll();
			
			if (!next.visited) {
				v.subordinates += dfs(next);
			}
		}
		
		
		return 1 + v.subordinates;
	}

	static class Vertex {
		boolean visited = false;
		Queue<Vertex> queue = new ArrayDeque<>();

		int subordinates = 0;

		public void add(Vertex v) {
			queue.offer(v);
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
