class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int a=helper(hBars);
        int b=helper(vBars);
        int length=Math.min(a,b);
        return (length+1)*(length+1);
        
    }
    public int helper(int[] arr){
        int a=1;
        int max=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[i-1]+1){
                a++;
            }
            else{
                a=1;
            }
            max=Math.max(a,max);
        }
        return max;
    }
}