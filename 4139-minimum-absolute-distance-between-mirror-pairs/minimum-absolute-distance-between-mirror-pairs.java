class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int ans=Integer.MAX_VALUE;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=nums.length-1;i>=0;i--){
            int rev=reverse(nums[i]);
            if(map.containsKey(rev)){
                ans=Math.min(ans,map.get(rev)-i);
            }
            map.put(nums[i],i);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public int reverse(int a){
        int ans=0;
        while(a>0){
            ans*=10;
            ans+=a%10;
            a/=10;
        }
        return ans;
    }
}