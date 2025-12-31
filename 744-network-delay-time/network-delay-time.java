class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,Map<Integer,Integer>> graph=new HashMap<>();
        for(int i=0;i<n;i++){
            graph.put(i+1,new HashMap<>());
        }
        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];
            graph.get(u).put(v,w);
        }
        HashSet<Integer> visited=new HashSet<>();
        PriorityQueue<pair> pq=new PriorityQueue<>((x,y)->x.w-y.w);
        int c=0;
        int ans=Integer.MIN_VALUE;
        pq.add(new pair(k,k,0));
        while(!pq.isEmpty()){
            pair rp=pq.poll();
            if(visited.contains(rp.a)) {
				continue;
			}
            c++;
			visited.add(rp.a);
            ans=Math.max(ans,rp.w);
            for(int nbrs:graph.get(rp.a).keySet()){
                int cost=graph.get(rp.a).get(nbrs);
                pq.add(new pair(nbrs,rp.a,rp.w+cost));
            }
        }
        return c==n?ans:-1;
    }
    class pair{
        int a;
        int b;
        int w;
        pair(int a,int b,int w){
            this.a=a;
            this.b=b;
            this.w=w;
        }
    }
}