class Solution {
    final int mod=1000000007;
    public int countNicePairs(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int ans=0;
        for(int a:nums){
            int r=rev(a);
            ans=((ans+map.getOrDefault(a-r,0))%mod);
            map.put(a-r,map.getOrDefault(a-r,0)+1);
        }
        return ans;
    }
    public int rev(int num){
        int ans=0;
        while(num>0){
            ans*=10;
            ans+=num%10;
            num/=10;
        }
        return ans;
    }
}