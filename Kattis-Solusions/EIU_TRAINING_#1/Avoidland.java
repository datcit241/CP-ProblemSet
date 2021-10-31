import java.io.*;
import java.util.*;

public class Avoidland {
	static int n;

    public static void main(String[] args) {
        n = ni();
        long moves = 0L;
        
        int[][] arr = new int[2][n + 1];
        
        for (int i = 0; i < n; i++) {
        	arr[0][ni()]++;
        	arr[1][ni()]++;
        }
        
        for (int i = 0; i < 2; i++) {
        	Queue<Integer> toMovePawns = new ArrayDeque<>(), emptyLines = new ArrayDeque<>();
        	
        	for (int j = 1; j <= n; j++) {
        		if (arr[i][j] == 0) {
        			emptyLines.offer(j);
        		} else if (arr[i][j] > 1) {
        			while (arr[i][j]-- > 1) {
        				toMovePawns.offer(j);
        			}
        		}
        	}
        	
        	while (!toMovePawns.isEmpty()) {
        		moves += Math.abs(toMovePawns.poll() - emptyLines.poll());
        	}
        }
        
        System.out.print(moves);
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
