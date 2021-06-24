import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PalindromeReorder2 {

	public static void main(String[] args) throws IOException {
		String s = ns();
		Map<Character, Integer> map = new TreeMap<>();
		int count = 0;
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (map.get(ch) == null) {
				map.put(ch, 1);
				count++;
			} else {
				map.put(ch, map.get(ch) + 1);

				count = (map.get(ch) % 2 == 0 ? count - 1 : count + 1);

			}
		}

		if (count > 1) {
			out.write("NO SOLUTION");
		} else {
			StringBuilder firstHalf = new StringBuilder();
			StringBuilder laterHalf = new StringBuilder();
			List<Character> list = new ArrayList<>();
			StringBuilder mid = new StringBuilder();

			for (Map.Entry<Character, Integer> e : map.entrySet()) {
				char ch = e.getKey();
				int n = e.getValue();

				if (n % 2 == 0) {
					for (int i = 0; i < n / 2; i++) {
						list.add(ch);
					}
				} else {
					for (int i = 0; i < n; i++) {
						mid.append(ch);
					}
				}
			}
			for (int i = 0; i < list.size(); i++) {
				firstHalf.append(list.get(i));
			}
			for (int i = list.size() - 1; i >= 0; i--) {
				laterHalf.append(list.get(i));
			}
			out.write(firstHalf.toString() + mid.toString() + laterHalf.toString());
		}

		out.flush();

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
