import java.io.*;
import java.util.*;

public class CreatingStrings {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		char[] charArray = ns().toCharArray();
		
		if (charArray.length == 1) {
			System.out.println("1");
			System.out.print(charArray[0]);
			return;
		}
		
		Arrays.sort(charArray);
		
		char[] initialArray = charArray.clone();
		
		int count = 1;
		
		while (true) {
			append(charArray);
			
			nextPermutation(charArray);
			
			if (equals(charArray, initialArray)) {
				break;
			}
			
			count++;
		}
		
		System.out.println(count);
		System.out.print(sb);
		
	}
	
	static void nextPermutation(char[] charArray) {
		int mark = -1;
		
		for (int i = charArray.length - 2; i >=0; i--) {
			if (charArray[i] < charArray[i + 1]) {
				mark = i;
				break;
			}
		}
		
		if (mark != -1) {
			for (int i = charArray.length - 1; i >= mark; i--)	{
				if (charArray[i] > charArray[mark]) {
					char temp = charArray[i];
					charArray[i] = charArray[mark];
					charArray[mark] = temp;
					break;
				}
			}
		}
		
		int left = mark + 1;
		int right = charArray.length - 1;
		
		while (left < right) {
			char temp = charArray[left];
			charArray[left] = charArray[right];
			charArray[right] = temp;
			
			left++;
			right--;
		}

	}
	
	static void append(char[] arr) {
		for (char ch: arr) {
			sb.append(ch);
		}
		
		sb.append('\n');
	}
	
	static boolean equals (char[] arr1, char[] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
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

}
