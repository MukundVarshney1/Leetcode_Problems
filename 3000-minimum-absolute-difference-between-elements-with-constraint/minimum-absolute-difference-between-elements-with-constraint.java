class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int ans=Integer.MAX_VALUE;
        TreeSet<Integer> tset=new TreeSet<>();
        tset.add(nums.get(nums.size()-1));
        for(int i=nums.size()-1-x;i>=0;i--){
            int target=nums.get(i);
            if(tset.floor(target)!=null){
                ans=Math.min(ans,Math.abs(target-tset.floor(target)));
            }
            if(tset.ceiling(target)!=null){
                ans=Math.min(ans,Math.abs(target-tset.ceiling(target)));
            }
            if(i+x-1>=0){
                tset.add(nums.get(i+x-1));
            }
        }
        return ans;
    }
}