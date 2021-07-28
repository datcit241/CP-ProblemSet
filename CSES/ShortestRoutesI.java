import java.util.*;
import java.io.*;

public class ShortestRoutesI {

	public static void main(String[] args) {
		int n = ni(), m = ni();

		Vertex[] vertices = new Vertex[n + 1];

		for (int i = 1; i <= n; i++) {
			vertices[i] = new Vertex();
		}

		vertices[1].bestCost = 0;

		for (int i = 0; i < m; i++) {
			int u = ni(), v = ni(), cost = ni();
			vertices[u].add(cost, vertices[v]);
		}

		dijkstraPerformed(vertices[1]);

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			sb.append(vertices[i].bestCost).append(' ');
		}

		System.out.print(sb);

	}

	static void dijkstraPerformed(Vertex v) {
		PriorityQueue<Vertex> queue = new PriorityQueue<>();
		
		queue.offer(v);
		
		while (queue.size() != 0) {
			v = queue.poll();
			v.processed = true;

			while (v.adjacents.size() != 0) {
				Connection connection = v.adjacents.poll();
				Vertex u = connection.vertex;
				long totalCost = v.bestCost + connection.cost;

				if (totalCost < u.bestCost) {
					u.bestCost = totalCost;
					if (!u.processed) {
						queue.offer(u);
					}
				}
			}
		}
	}

	static class Vertex implements Comparable<Vertex> {
		boolean processed = false;
		long bestCost = Long.MAX_VALUE;
		Queue<Connection> adjacents = new ArrayDeque<>();

		public void add(int cost, Vertex v) {
			adjacents.offer(new Connection(cost, v));
		}

		@Override
		public int compareTo(ShortestRoutesI.Vertex o) {
			return Long.compare(this.bestCost, o.bestCost);
		}

	}

	static class Connection {
		long cost;
		Vertex vertex;

		public Connection(int cost, Vertex vertex) {
			this.cost = cost;
			this.vertex = vertex;
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
