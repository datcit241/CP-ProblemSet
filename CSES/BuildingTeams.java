import java.util.*;
import java.io.*;

public class BuildingTeams {

	public static void main(String[] args) {
		int n = ni(), m = ni();

		Student[] students = new Student[n + 1];

		for (int i = 1; i <= n; i++) {
			students[i] = new Student(i);
		}

		students[1].inTeamOne = true;

		for (int i = 0; i < m; i++) {
			int u = ni(), v = ni();

			students[u].addFriend(students[v]);
			students[v].addFriend(students[u]);
		}

		for (int i = 1; i <= n; i++) {
			if (!students[i].visited) {
				if (!dfs(students[i])) {
					System.out.print("IMPOSSIBLE");
					return;
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			sb.append((students[i].inTeamOne) ? 1 : 2).append(" ");
		}
		System.out.print(sb);

	}

	static boolean dfs(Student student) {
		student.visited = true;

		if (student.friendships.size() != 0) {
			for (Student nextStudent : student.friendships) {
				if (!nextStudent.visited) {
					nextStudent.inTeamOne = !student.inTeamOne;
					if (!dfs(nextStudent)) {
						return false;
					}
				}

				if (student.inTeamOne == nextStudent.inTeamOne) {
					return false;
				}

			}
		}

		return true;

	}

	static class Student {
		int id;
		boolean visited;
		boolean inTeamOne;
		List<Student> friendships;

		public Student(int id) {
			this.id = id;
			visited = false;
			friendships = new ArrayList<>();
			inTeamOne = false;
		}

		public void addFriend(Student stu) {
			friendships.add(stu);
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
