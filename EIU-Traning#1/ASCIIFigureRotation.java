import java.io.*;
import java.util.*;

public class ASCIIFigureRotation {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        int n;
        while ((n = ni()) != 0) {
            char[][] arr = new char[n][0];
            int length = 0;
            
            for (int i = 0; i < n; i++) {
                arr[i] = nextLine().toCharArray(); // modify isSpaceChar() so that heading spaces are not skipped
                length = Math.max(length, arr[i].length);
            }
            
            for (int j = 0; j < length; j++) {
            	int lastCharIndex = n; //(1)
            	//int count = 0; //(2)
                for (int i = n - 1; i > -1; i--) {
                    try {
                    	if (arr[i][j] != ' ') {
                    		int count = lastCharIndex - i - 1; //(1)
                    		for (int k = 0; k < count; k++) {
                    			sb.append(' ');
                    		}
                            sb.append((arr[i][j] == '|' ? '-' : (arr[i][j] == '-' ? '|' : arr[i][j])));
                            
                            lastCharIndex = i; //(1)
                    	} /* else {
                    		count++; //(2)
                    	} */
                    } catch (Exception e) { // String[i] doesn't have any char at j
                    	//count++; //(2)
                    }
                }
                sb.append('\n');
            }
            sb.append('\n');
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1)); // must keep only one \n at the end of the output
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
		return !(c >= 32 && c <= 126);
	}

	static int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;

		return b;
	}

	static float nf() {
		return Float.parseFloat(ns());
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
		while (b >= 33 && b <= 126) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static String nextLine() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (b >= 32 && b <= 126) {
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
		long num = 0, b;
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
