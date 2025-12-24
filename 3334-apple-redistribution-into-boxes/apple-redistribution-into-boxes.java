class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int c=0;
        for(int i=0;i<apple.length;i++){
            c+=apple[i];
        }
        Arrays.sort(capacity);
        int ans=0;
        for(int i=capacity.length-1;i>=0;i--){
            if(c<=0){
                return ans;
            }
            c-=capacity[i];
            ans++;
        }
        return ans;
    }
}