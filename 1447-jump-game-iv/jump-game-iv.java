class Solution {
    public int minJumps(int[] arr) {
        Map<Integer,Stack<Integer>> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],new Stack<>());
            }
            map.get(arr[i]).push(i);
        }
        int ans=arr.length;
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        Set<Integer> set=new HashSet<>();
        int c=0;
        int size=1;
        while(!q.isEmpty()){
            if(size==0){
                size=q.size();
                c++;
            }
            int r=q.poll();
            size--;
            if(set.contains(r)){
                continue;
            }
            set.add(r);
            if(r==arr.length-1){
                ans=Math.min(ans,c);
            }
            if(r+1<arr.length){
                q.add(r+1);
            }
            if(r-1>=0){
                q.add(r-1);
            }
            while(!map.get(arr[r]).isEmpty()){
                q.add(map.get(arr[r]).pop());
            }
        }
        return ans;
    }
}
