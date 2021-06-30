import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class GridPaths {
	static int[][] totalPaths;

	public static void main(String[] args) {
		int n = ni();
		totalPaths = new int[n][n];
		int ch = nc();
		if (ch == '*') {
			System.out.println(0);
			return;
		}
		totalPaths[0][0] = 1;

		for (int j = 1; j < n; j++) {
			calc(0, j);
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				calc(i, j);
			}
		}

		System.out.println(totalPaths[n - 1][n - 1] == -1 ? 0 : totalPaths[n - 1][n - 1]);

	}

	static void calc(int i, int j) {
		char ch = nc();
		if (ch == '*') {
			totalPaths[i][j] = -1;
		} else {
			int count = 0;
			if (i != 0) {
				if (totalPaths[i - 1][j] != -1) {
					totalPaths[i][j] = totalPaths[i - 1][j];
					count++;
				}
			}
			if (j != 0) {
				if (totalPaths[i][j - 1] != -1) {
					totalPaths[i][j] = (totalPaths[i][j] + totalPaths[i][j - 1]) % 1000000007;
					count++;
				}
			}
			if (count == 0) {
				totalPaths[i][j] = -1;
			}
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
