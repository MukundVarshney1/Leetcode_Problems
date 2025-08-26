class Solution {
    public int areaOfMaxDiagonal(int[][] dimension) {
        double diag=0;
        int idx=0;
        int ans=0;
        for(int i=0;i<dimension.length;i++){
double temp=Math.sqrt(Math.pow(dimension[i][0],2)+Math.pow(dimension[i][1],2));
        if(temp>diag){
            diag=temp;
            idx=i;
            ans=dimension[i][0]*dimension[i][1];
        }
        // this is when diagonal is same but ans is different
        else if(diag==temp){
            ans=Math.max(ans,dimension[i][0]*dimension[i][1]);
        }
        }
        
        return ans;
    }
}