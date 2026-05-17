class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        Set<Integer> set=new HashSet<>();
        while(!q.isEmpty()){
            int r=q.poll();
            if(set.contains(r)){
                continue;
            }
            set.add(r);
            if(arr[r]==0){
                return true;
            }
            if(r+arr[r]<arr.length){
                q.add(r+arr[r]);
            }
            if(r-arr[r]>=0){
                q.add(r-arr[r]);
            }
        }
        return false;
    }
}