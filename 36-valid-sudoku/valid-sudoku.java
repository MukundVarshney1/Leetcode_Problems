class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(!isitsafe(board,i,j,board[i][j])){
                        return false;
                    }
                }
            }
        }
        return true;
    }
		public static boolean isitsafe(char[][]grid,int row,int col,char val) {
//			row
			for(int i=col+1;i<9;i++) {
				if(grid[row][i]==val) {
					return false;
				}
			}
//			col
			for(int i=row+1;i<9;i++) {
				if(grid[i][col]==val) {
					return false;
				}
			}
			// 3*3 Matrix
			int r=row-row%3;
			int c=col-col%3;
            int flip=0;
			for(int i=r;i<r+3;i++) {
				for(int j=c;j<c+3;j++) {
					if(grid[i][j]==val) {
                        if(flip==1){
						    return false;
                        }
                        flip++;
					}
				}
			}
			return true;
			
		}
}