import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class AppleDivision2 {
	static List<Integer> list = new ArrayList<>();
	static long minDifference = Integer.MAX_VALUE;
	static int[] mark;
	static int n;
	static int k;
	static long totalSum = 0;
	static long halfSum;

	public static void main(String[] args) throws IOException {
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		n = ni();

		for (int i = 0; i < n; i++) {
			int val = ni();
			list.add(val);
			totalSum += val;
		}
		halfSum = totalSum / 2;

		if (n == 1) {
			out.write(String.valueOf(list.get(0)));
		} else {
			mark = new int[n];
			for (k = 1; k < n; k++) {
				createCombinations(0);
			}
			out.write(String.valueOf(minDifference));
		}

		out.flush();

	}

	static void createCombinations(int i) {

		int previousIndex = (i == 0) ? -1 : mark[i - 1];
		for (int j = previousIndex + 1; j <= n - k + i; j++) {
			mark[i] = j;

			if (i == k - 1) {
				long temp = 0;
				for (int t = 0; t < k; t++) {
					temp += list.get(mark[t]);
				}

				if (temp >= halfSum) {
					long difference = Math.abs((totalSum - temp * 2));
					if (difference < minDifference) {
						minDifference = difference;
					}
				}

			} else {
				createCombinations(i + 1);
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
