import java.io.FileInputStream;
import java.io.InputStream;

public class BitStrings {

	public static void main(String[] args) throws Exception {
		FastIO scan = new FastIO(System.in);

		int n = scan.nextInt();
		long bits = 1;

		for (int i = 1; i <= n; i++) {
			bits *= 2;
			if (bits / 1000000007 > 0) {
				bits %= 1000000007;
			}
		}
		System.out.println(bits);

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
