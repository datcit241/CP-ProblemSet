
import java.io.*;
import java.util.*;

class City {
	int id;
	boolean visited;
	List<City> adjoiningCities;
	
	public City(int id) {
		this.id = id;
		visited = false;
		adjoiningCities = new ArrayList<>();
	}
	
	public void addCity(City city) {
		adjoiningCities.add(city);
	}
}

public class BuildingRoads {
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		int n = ni(), m = ni();
		City[] cities = new City[n + 1];
		
		for (int i = 1; i <= n; i++) {
			cities[i] = new City(i);
		}
		
		for (int i = 0; i < m; i++) {
			int u = ni();
			int v = ni();
			
			City city1 = cities[u];
			City city2 = cities[v];
			
			city1.addCity(city2);
			city2.addCity(city1);
		}
		
		dfs(cities[1]);
		
		int count = 0;
		
		for (int i = 2; i <= n; i++) {
			if (!cities[i].visited) {
				count++;
				dfs(cities[i]);
				sb.append("1 ").append(i).append("\n");
			}
		}
		
		System.out.println(count);
		System.out.print(sb);

	}
	
	static void dfs (City city) {
		city.visited = true;
		
		for (City destination: city.adjoiningCities) {
			if (!destination.visited) {
				dfs(destination);
			}
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
