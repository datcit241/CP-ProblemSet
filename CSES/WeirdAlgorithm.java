import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;

public class WeirdAlgorithm {

	public static void main(String[] args) throws Exception {
		FastIO scan = new FastIO(System.in);

		PrintWriter output = new PrintWriter(System.out);
		long n = scan.nextInt();

		while (n != 1) {
			output.print(n + " ");

			if (n % 2 == 0) {
				n /= 2;
			} else {
				n = n * 3 + 1;
			}
		}
		output.print("1");
		output.flush();
		output.close();

	}

	static void executingAlgorithm(int n, StringBuilder sb) {

		if (n == 1) {
			sb.append(1);
			return;
		}

		sb.append(n + " ");

		if (n % 2 == 0) {
			n /= 2;
			executingAlgorithm(n, sb);
		} else {
			n = n * 3 + 1;
			executingAlgorithm(n, sb);
		}
	}

	public static class FastIO {
		InputStream dis;
		byte[] buffer = new byte[1 << 17];
		int pointer = 0;

		public FastIO(String fileName) throws Exception {
			dis = new FileInputStream(fileName);
		}

		public FastIO(InputStream is) {
			dis = is;
		}

		int nextInt() throws Exception {
			int ret = 0;
			byte b;
			do {
				b = nextByte();
			} while (b <= ' ');
			boolean negative = false;
			if (b == '-') {
				negative = true;
				b = nextByte();
			}
			while (b >= '0' && b <= '9') {
				ret = 10 * ret + b - '0';
				b = nextByte();
			}
			return (negative) ? -ret : ret;
		}

		long nextLong() throws Exception {
			long ret = 0;
			byte b;
			do {
				b = nextByte();
			} while (b <= ' ');
			boolean negative = false;
			if (b == '-') {
				negative = true;
				b = nextByte();
			}
			while (b >= '0' && b <= '9') {
				ret = 10 * ret + b - '0';
				b = nextByte();
			}
			return (negative) ? -ret : ret;
		}

		Integer[] readArray(int n) throws Exception {
			Integer[] a = new Integer[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		byte nextByte() throws Exception {
			if (pointer == buffer.length) {
				dis.read(buffer, 0, buffer.length);
				pointer = 0;
			}
			return buffer[pointer++];
		}

		String next() throws Exception {
			StringBuilder ret = new StringBuilder();
			byte b;
			do {
				b = nextByte();
			} while (b <= ' ');
			while (b >= ' ') {
				ret.appendCodePoint(b);
				b = nextByte();
			}
			return ret.toString();
		}

		public void close() throws Exception {
			if (dis == null)
				return;
			dis.close();
		}
	}

}
