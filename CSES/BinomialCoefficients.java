import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BinomialCoefficients {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		int limit = 1000000, mod = 1000000007;
		long[] factorials = new long[limit + 1];
		factorials[0] = 1;
		
		for (int i = 1; i <= limit; i++) {
			factorials[i] = factorials[i - 1] * i % mod;
		}
		
		int t = ni();
		
		while (t-- > 0) {
			int a = ni(), b = ni();
			long result = factorials[a];
			result *= modInverse2((int) factorials[b], mod);
			result %= mod;
			
			result *= modInverse2((int) factorials[a - b], mod);
			result %= mod;
			
			sb.append(result).append('\n');
		}
		System.out.println(sb);

	}
	
    public static int modInverse2(int a, int m) {
        return mod((int) euclid(a, m)[1], m);
    }
    
    public static int mod(int a, int m) {
        a %= m;
        return a >= 0 ? a : a + m;
    }
    
    public static long[] euclid(long a, long b) {
        long x = 1, y = 0, x1 = 0, y1 = 1;
        // invariant: a=a_orig*x+b_orig*y, b=a_orig*x1+b_orig*y1
        while (b != 0) {
            long q = a / b;
            long _x1 = x1;
            long _y1 = y1;
            long _b = b;
            x1 = x - q * x1;
            y1 = y - q * y1;
            b = a - q * b;
            x = _x1;
            y = _y1;
            a = _b;
        }
        return a > 0 ? new long[] {a, x, y} : new long[] {-a, -x, -y};
    }

    public static long[] euclid2(long a, long b) {
        if (b == 0)
            return a > 0 ? new long[] {a, 1, 0} : new long[] {-a, -1, 0};
        long[] r = euclid2(b, a % b);
        return new long[] {r[0], r[2], r[1] - a / b * r[2]};
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

	static float nf() {
		return Float.parseFloat(ns());
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

	static int[] na(int n) {
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = ni();
		}
		return arr;
	}

}
