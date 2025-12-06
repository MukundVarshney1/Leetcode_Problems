class Solution {
    public int countWays(int[][] arr) {
        Arrays.sort(arr,(a,b)->a[0]-b[0]==0?a[1]-b[1]:a[0]-b[0]);
        int max=arr[0][1];
        long c=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i][0]<=max){
                max=Math.max(max,arr[i][1]);
            }
            else{
                c++;
                max=arr[i][1];
            }
        }
        int ans=1;
        while(c-->0){
            ans=ans*2 %1000000007;
        }
        return ans;
    }
}