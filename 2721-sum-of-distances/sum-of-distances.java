class Solution {
    public long[] distance(int[] nums) {
        Map<Integer,long[]> map = new HashMap<>();
        long[][] pre=new long[nums.length][2];
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new long[2]);
            }
            map.get(nums[i])[0]+=i;
            map.get(nums[i])[1]++;
            pre[i][0]+=map.get(nums[i])[0];
            pre[i][1]+=map.get(nums[i])[1];
        }
        map=new HashMap<>();
        long[][] suf=new long[nums.length][2];
        for(int i=nums.length-1;i>=0;i--){
             if(!map.containsKey(nums[i])){
                map.put(nums[i],new long[2]);
            }
            map.get(nums[i])[0]+=i;
            map.get(nums[i])[1]++;
            suf[i][0]+=map.get(nums[i])[0];
            suf[i][1]+=map.get(nums[i])[1];
        }
        long[] ans=new long[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]+=(i*pre[i][1])-pre[i][0];
            ans[i]+=suf[i][0]-(i*suf[i][1]);
        }
        return ans;
    }
}