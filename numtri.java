/*
ID: radamat1
LANG: JAVA
TASK: numtri
 */

import java.io.*;
import java.util.*;

class numtri {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("numtri.in"));
		PrintWriter pw = new PrintWriter(new File("numtri.out"));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int[][] tri = new int[n][n];
		for(int i = 0; i < n; i++){
			String[] str = in.readLine().split(" ");
			for(int j = 0; j <= i; j++){
				tri[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		int[] best = new int[n];
		int[] old = new int[n];
		
		best[0] = tri[n-1][0];
		old[0] = tri[n-1][0];
		
		for(int i = 1; i < n; i++){
			best[0] = tri[n-1][i];
		
			for(int j = 1; j <= i; j++){
				best[j] = tri[n-1-j][i-j] + Math.max(best[j-1], old[j-1]);
				old[j-1] = best[j-1];
				
			}
			old[i] = best[i];
		}
		
		pw.println(best[n-1]);
		pw.close();
	}
	
}
