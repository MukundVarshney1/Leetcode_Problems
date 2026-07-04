class Solution {
    public int minScore(int n, int[][] r) {
        Map<Integer,Map<Integer,Integer>> map=new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i,new HashMap<>());
        }
        for(int i=0;i<r.length;i++){
            int a=r[i][0];
            int b=r[i][1];
            int c=r[i][2];
            map.get(a).put(b,c);
            map.get(b).put(a,c);
        }
        Set<Integer> set=new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
        int ans=Integer.MAX_VALUE;
        q.add(1);
        while(!q.isEmpty()){
            Integer p=q.poll();
            if(set.contains(p)){
                continue;
            }
            set.add(p);
            for(int nbrs:map.get(p).keySet()){
                if(!set.contains(nbrs)){
                    q.add(nbrs);
                    ans=Math.min(ans,map.get(p).get(nbrs));
                }
            }
        }
        return ans;
    }
}