class Solution {
    public int minCost(String s, int[] arr) {
        int ans=0;
        int a=arr[0];
        char c=s.charAt(0);
        for(int i=1;i<arr.length;i++){
            if(s.charAt(i)==c){
                if(a>arr[i]){
                    ans+=arr[i];
                }
                else{
                    ans+=a;
                    a=arr[i];
                }
            }
            else{
                a=arr[i];
                c=s.charAt(i);
            }
        }    
        return ans;    
    }
}