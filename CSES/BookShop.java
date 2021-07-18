
import java.io.*;
import java.util.*;

public class BookShop {

	public static void main(String[] args) {
		improvedSolution();
	}
	
	static void originalSolution() {
		int n = ni();
		int x = ni();

		int[] prices = new int[n + 1];
		int[] numbersOfPages = new int[n + 1];
		int[][] maxNumPages = new int[n + 1][x + 1];
		
		for (int i = 1; i <= n ;i++) {
			prices[i] = ni();
		}
		
		for (int i = 1; i <= n ;i++) {
			numbersOfPages[i] = ni();
		}
		
		for (int i = 1; i <= n; i++) {
			int price = prices[i];
			int numberOfPages = numbersOfPages[i];
			
			for (int j = 1; j <= x; j++) {
				int prevMax = maxNumPages[i - 1][j];
				
				maxNumPages[i][j] = Math.max(prevMax, maxNumPages[i][j - 1]);
				
				if (j >= price) {
					maxNumPages[i][j] = Math.max(prevMax, maxNumPages[i - 1][j - price] + numberOfPages);
				}

			}
		}
		System.out.println(maxNumPages[n][x]);

	}
	
	static void improvedSolution() {
		int n = ni(), x = ni();
		int[] prices = new int[n + 1];
		int[] numbersOfPages = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			prices[i] = ni();
		}
		
		for (int i = 1; i <= n; i++) {
			numbersOfPages[i] = ni();
		}
		
		int[] maxPages = new int[x + 1];
		for (int i = 1; i <= n; i++) {
			int price = prices[i];
			int numPages = numbersOfPages[i];
			
			for (int j = x; j >= price; j--) {
				maxPages[j] = Math.max(maxPages[j], maxPages[j - 1]);
				
				if (j >= price) {
					maxPages[j] = Math.max(maxPages[j], maxPages[j - price] + numPages);
				}
			}
		}
		System.out.println(maxPages[x]);
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
