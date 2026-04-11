class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        int ans=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            if(map.get(nums[i]).size()>2){
                ans=Math.min(ans,i-map.get(nums[i]).get(map.get(nums[i]).size()-3));
            }
        }
        return ans==Integer.MAX_VALUE?-1:2*ans;
    }
}