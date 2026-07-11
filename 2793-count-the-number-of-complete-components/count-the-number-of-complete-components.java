class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer,Set<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new HashSet<>());
        }
        for(int i=0;i<edges.length;i++){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        Set<Integer> set=new HashSet<>();
        int ans=0;
        for(int i=0;i<n;i++){
            if(set.contains(i)){
                continue;
            }
            Queue<Integer> q=new LinkedList<>();
            q.add(i);
            int x=0;
            int v=0;
            while(!q.isEmpty()){
                int r=q.poll();
                if(set.contains(r)){
                    continue;
                }
                set.add(r);
                x++;
                for(int nbrs:map.get(r)){
                    if(set.contains(nbrs)){
                    continue;
                }
                    v++;
                    q.add(nbrs);
                }
            }
            if((x*(x-1))/2==v){
                ans++;
            }
        }
        return ans;
    }
}