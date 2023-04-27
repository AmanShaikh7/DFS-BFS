import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt();
        int[][] island = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                island[i][j] = sc.nextInt();
            }
        }
        sc.close();
        System.out.println(islandPerimeter(island));
    }

	static int count =0;
	public static void dfs(int arr[][],int i,int j){
		if(i<0 || i>=arr.length || j<0 || j>=arr[0].length || arr[i][j]==0){
			// in valid cell i.e our cell has exposure to water from this side or it is out of grid
			count++;
			return;
		}
		if(arr[i][j]==-1) return;
		arr[i][j]=-1;
		int row[] = {-1,0,+1,0};
		int col[] = {0,+1,0,-1};
		for(int k=0;k<row.length;k++){
			int newi = i+row[k];
			int newj = j+col[k];
			dfs(arr,newi,newj);
		}
	}
    public static int islandPerimeter(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
	        for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					if(grid[i][j]==1){
						dfs(grid,i,j);
						return count;
					}
				}
			}
		return -1;
    }
}