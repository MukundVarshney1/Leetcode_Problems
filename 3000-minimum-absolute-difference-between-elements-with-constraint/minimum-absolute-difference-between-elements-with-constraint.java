class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int ans=Integer.MAX_VALUE;
        TreeMap<Integer,Integer> tmap=new TreeMap<>();
        for(int i=x;i<nums.size();i++){
            tmap.put(nums.get(i),tmap.getOrDefault(nums.get(i),0)+1);
        }
        for(int i=0;i<nums.size()-x;i++){
            int target=nums.get(i);
            if(tmap.floorKey(target)!=null){
                ans=Math.min(ans,Math.abs(target-tmap.floorKey(target)));
            }
            if(tmap.ceilingKey(target)!=null){
                ans=Math.min(ans,Math.abs(target-tmap.ceilingKey(target)));
            }
            tmap.put(nums.get(i+x),tmap.get(nums.get(i+x))-1);
            if(tmap.get(nums.get(i+x))==0){
                tmap.remove(nums.get(i+x));
            }
        }
        return ans;
    }
}