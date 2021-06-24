import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class CreatingStrings2 {
	static int n;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = 1;

		String s = ns();
		n = s.length();
		if (n == 1) {
			sb.append(s);
		} else {
			char[] currentArray = s.toCharArray();
			Arrays.sort(currentArray);
			String initialString = arrayToString(currentArray);

			String currentString = initialString;

			while (true) {
				sb.append(currentString + "\n");
				currentArray = nextPermutation(currentArray);
				currentString = arrayToString(currentArray);

				if (currentString.equals(initialString)) {
					break;
				}
				count++;

			}
		}

		out.write(String.valueOf(count) + "\n" + sb.toString());
		out.flush();

	}

	static String arrayToString(char[] array) {
		String s = "";
		for (char ch : array) {
			s += ch;
		}
		return s;
	}

	static char[] nextPermutation(char[] currentArray) {
		int mark = -1;
		char ch = ' ';
		for (int i = n - 2; i >= 0; i--) {
			if (currentArray[i] < currentArray[i + 1]) {
				mark = i;
				ch = currentArray[i];
				break;
			}
		}

		if (mark != -1) {
			// swap
			for (int i = n - 1; i >= 0; i--) {
				if (currentArray[i] > ch) {
					char temp = currentArray[i];
					currentArray[i] = ch;
					currentArray[mark] = temp;
					break;
				}
			}
		}

		// reverse
		int i = mark + 1;
		int j = n - 1;
		while (i < j) {
			char temp = currentArray[i];
			currentArray[i] = currentArray[j];
			currentArray[j] = temp;
			i++;
			j--;
		}

		return currentArray;
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
