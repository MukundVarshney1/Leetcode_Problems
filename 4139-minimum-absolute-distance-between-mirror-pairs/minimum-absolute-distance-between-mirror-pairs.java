class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int ans=Integer.MAX_VALUE;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                ans=Math.min(ans,i-map.get(nums[i]));
            }
            map.put(reverse(nums[i]),i);
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