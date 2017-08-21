package Code_chef;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Breadth_First_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int AM[][] = new int[N+1][N+1];
		int E = scn.nextInt();
		int val[] = new int[N+1];
		for(int i=1;i<=N;i++)
			val[i] = scn.nextInt();
		
		for(int i=1;i<=E;i++)
		{
			int A = scn.nextInt();
			int B = scn.nextInt();
			AM[A][B] = 1;
			AM[B][A] = 1; //undirected
		}
		BFS(AM,val,1);
	}

	/*7 7
	21 7 100 15 95 13 81
	1 2
	1 3
	1 5
	3 5
	2 7
	2 6
	2 4
	*/

	public static void BFS(int AM[][],int val[],int S)
	{
		Queue<Integer> Que = new LinkedList<>();
		Que.add(S);
		boolean visited[] = new boolean[AM.length];
		Integer NODE = S;
		while(NODE != null)
		{
			int X = Que.poll();
			//visited[NODE] = true; Not here or it can be pushed twice in queue 
			System.out.print(val[X]+" ");
			int i = NODE;
			for(int j=1;j<=AM.length-1;j++)
			{
				if(AM[i][j] != 0 && !visited[j])
					{
					Que.add(j);
					visited[j] = true;
					}
				
			}
			NODE = Que.peek();
		}
	}
}
