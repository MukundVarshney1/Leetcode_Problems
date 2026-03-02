class Solution {
    public int minSwaps(int[][] grid) {
        int[] mfr=new int[grid.length]; //max from right
        for(int i=0;i<grid.length;i++){
            int f=0;
            for(int j=grid[0].length-1;j>=0;j--){
                if(grid[i][j]==1){
                    mfr[i]=j;
                    f=1;
                    break;
                }
            }
            if(f==0){
                mfr[i]=-1;
            }
        }
        int ans=0;
        for(int i=0;i<mfr.length;){
            if(mfr[i]<=i){
                i++;
                continue;
            }
            int f=0;
            int j=i+1;
            int val=mfr[i];
            for(;j<mfr.length;j++){
                int temp=mfr[j];
                mfr[j]=val;
                val=temp;
                if(val<=i){
                    mfr[i]=val;
                    f=1;
                    break;
                }
            }
            if(f==0){
                return -1;
            }
            ans+=j-i;
        }
        return ans;
    }
}