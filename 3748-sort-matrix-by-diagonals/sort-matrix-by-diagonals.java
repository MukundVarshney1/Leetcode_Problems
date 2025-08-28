class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n=grid.length;
        PriorityQueue<Integer> que;
        for(int k=1;k<n;k++){
            helper(grid,0,k,new PriorityQueue<>(Collections.reverseOrder()),0);
        }
        for(int k=0;k<n;k++){
            helper(grid,k,0,new PriorityQueue<>(),1);
        }
        return grid;
    }
    public void helper(int[][] grid,int i,int j,PriorityQueue<Integer> que ,int flip){
        if(i>=grid.length || j>=grid.length){
            return;
        }
        que.add(grid[i][j]);
        helper(grid,i+1,j+1,que,flip);
        grid[i][j]=que.peek();
        que.remove();
    }
}