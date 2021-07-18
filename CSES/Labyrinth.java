
import java.io.*;
import java.util.*;

public class Labyrinth {
	static boolean[][] visited;
	static char[][] charMap;
	static int n, m, bi, bj;

	public static void main(String[] args) {
		n = ni();
		m = ni();
		int ai = 0, aj = 0;
		boolean foundA = false;

		charMap = new char[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String s = ns();
			charMap[i] = s.toCharArray();

			if (!foundA) {
				int index = s.indexOf('A');
				if (index != -1) {
					ai = i;
					aj = index;
					foundA = true;
				}
			}

		}

		visited[ai][aj] = true;

		if (bfs(ai, aj)) {
			System.out.println("YES");
			StringBuilder sb = new StringBuilder();

			int i = bi;
			int j = bj;

			while (charMap[i][j] != 'A') {
				char ch = charMap[i][j];
				sb.append(ch);

				switch (ch) {
				case 'R':
					j--;
					break;
				case 'D':
					i--;
					break;
				case 'L':
					j++;
					break;
				case 'U':
					i++;
					break;
				}
			}

			System.out.println(sb.length());
			sb.reverse();
			System.out.print(sb);
		} else {
			System.out.print("NO");
		}

	}

	static Queue<Integer> queue = new ArrayDeque<>();
	static Queue<String> stringQueue = new ArrayDeque<>();

	static boolean bfs(int i, int j) {

		if (addNeighbors(i, j)) {
			return true;
		}

		while (queue.size() != 0) {
			i = queue.poll();
			j = queue.poll();

			if (addNeighbors(i, j)) {
				return true;
			}

			addNeighbors(i, j);

		}
		return false;
	}

	static boolean addNeighbors(int i, int j) {
		// down
		if (i != n - 1 && validMove(i + 1, j)) {
			if (charMap[i + 1][j] == 'B') {
				charMap[i + 1][j] = 'D';
				bi = i + 1;
				bj = j;
				return true;
			}

			charMap[i + 1][j] = 'D';

			queue.offer(i + 1);
			queue.offer(j);

			visited[i + 1][j] = true;
		}

		// right
		if (j != m - 1 && validMove(i, j + 1)) {
			if (charMap[i][j + 1] == 'B') {
				charMap[i][j + 1] = 'R';
				bi = i;
				bj = j + 1;
				return true;
			}

			charMap[i][j + 1] = 'R';

			queue.offer(i);
			queue.offer(j + 1);

			visited[i][j + 1] = true;
		}

		// left
		if (j != 0 && validMove(i, j - 1)) {
			if (charMap[i][j - 1] == 'B') {
				charMap[i][j - 1] = 'L';
				bi = i;
				bj = j - 1;
				return true;
			}

			charMap[i][j - 1] = 'L';

			queue.offer(i);
			queue.offer(j - 1);

			visited[i][j - 1] = true;
		}

		// up
		if (i != 0 && validMove(i - 1, j)) {
			if (charMap[i - 1][j] == 'B') {
				charMap[i - 1][j] = 'U';
				bi = i - 1;
				bj = j;
				return true;
			}

			charMap[i - 1][j] = 'U';

			queue.offer(i - 1);
			queue.offer(j);

			visited[i - 1][j] = true;
		}
		return false;
	}

	static char identifyDirection(int i, int j, int y, int x) {
		int yVector = y - i;
		int xVector = x - j;

		if (yVector > 0) {
			return 'D';
		} else if (yVector < 0) {
			return 'U';
		}

		if (xVector > 0) {
			return 'R';
		} else if (xVector < 0) {
			return 'L';
		}
		return '.';
	}

	static boolean validMove(int i, int j) {
		return charMap[i][j] != '#' && !visited[i][j];
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
