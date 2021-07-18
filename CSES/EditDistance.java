import java.io.*;
import java.util.*;

public class EditDistance {

	public static void main(String[] args) {
	solution1();
 
	}
	
	static void solution1() {
		String s1 = ns();
		String s2 = ns();
 
		int n = s1.length(), m = s2.length();
 
		int[][] edits = new int[n + 1][m + 1];
 
		for (int j = 0; j <= m; j++) {
			edits[0][j] = j;
		}
 
		for (int i = 1; i <= n; i++) {
			edits[i][0] = i;
		}
 
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					edits[i][j] = edits[i - 1][j - 1];
					continue;
				}
				
				int min = Math.min(edits[i - 1][j], edits[i][j - 1]);
				min = Math.min(min, edits[i - 1][j - 1]);
				
				edits[i][j] = min + 1;
			}
		}
		System.out.println(edits[n][m]);
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
