import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FerrisWheel {

	public static void main(String[] args) throws Exception {
		FastIO scan = new FastIO(System.in);

		int n = scan.nextInt();
		int weight = scan.nextInt();

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			list.add(scan.nextInt());
		}

		Collections.sort(list);

		int left = 0;
		int right = n - 1;
		int count = 0;

		while (right > left) {
			if (list.get(left) + list.get(right) <= weight) {
				count++;
				left++;
				right--;
			} else {
				count++;
				right--;
			}
		}

		if (left == right && list.get(left) < weight) {
			count++;
		}

		System.out.println(count);

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
