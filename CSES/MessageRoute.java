import java.io.*;
import java.util.*;

public class MessageRoute {
	static int n, m;
	static int[] prev;
	static Vertex[] vertices;
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		n = ni(); m = ni();

		vertices = new Vertex[n + 1];
		prev = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			vertices[i] = new Vertex(i);
		}

		for (int i = 0; i < m; i++) {
			int u = ni(), v = ni();

			vertices[u].addVertex(vertices[v]);
			vertices[v].addVertex(vertices[u]);
		}

//		bfs(vertices[1], vertices[n], prev);
		bfs2(vertices[1]);
		

		if (vertices[n].visited) {
			int count = 0;
			int id = n;
 
			while (id != 0) {
				count++;
				id = prev[id];
			}
 
			sb.append(count).append("\n");
 
			int[] arr = new int[count];
 
			count = 0;
			id = n;
 
			while (id != 0) {
				arr[count] = id;
				count++;
				id = prev[id];
			}
 
			for (int i = count - 1; i >= 0; i--) {
				sb.append(arr[i]).append(" ");
			}

		} else {
			sb.append("IMPOSSIBLE");
		}
		System.out.print(sb);

	}

	static void bfs2(Vertex v) {
		Queue<Vertex> queue = new ArrayDeque<>();
		queue.offer(v);

		while (queue.size() != 0) {
			v = queue.poll();
			v.visited = true;
			
			if (v.equals(vertices[n])) {
				return;
			}

			for (Vertex next : v.adjacentComputers) {
				if (!queue.contains(next) && !next.visited) {
					queue.offer(next);
					prev[next.id] = v.id;
				}
				
			}

		}
	}

//	static Queue<Vertex> queue = new ArrayDeque<>();
//
//	static void bfs(Vertex v, Vertex destinationVertex, int[] prev) {
//		v.visited = true;
//
//		if (v.equals(destinationVertex)) {
//			return;
//		}
//
//		for (Vertex vertex : v.adjacentComputers) {
//			if (!vertex.visited && !queue.contains(vertex)) {
//				prev[vertex.id] = v.id;
//
//				queue.offer(vertex);
//			}
//		}
//
//		if (queue.size() == 0) {
//			return;
//		}
//		bfs(queue.poll(), destinationVertex, prev);
//	}

	static class Vertex {
		int id;
		boolean visited;
		List<Vertex> adjacentComputers;
		int totalDistance;

		public Vertex(int id) {
			this.id = id;
			visited = false;
			adjacentComputers = new ArrayList<>();
		}

		public void addVertex(Vertex v) {
			adjacentComputers.add(v);
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
