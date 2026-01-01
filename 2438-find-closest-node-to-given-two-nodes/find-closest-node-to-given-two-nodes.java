class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<edges.length;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            if(edges[i]==-1){
                continue;
            }
            graph.get(i).add(edges[i]);
        }
        Queue<Integer> q=new LinkedList<>();
        int[] a=new int[edges.length];
        Arrays.fill(a,-1);
        q.add(node1);
        int c=0;
        while(!q.isEmpty()){
            int s=q.size();
            while(s-->0){
                int r=q.poll();
                if(a[r]!=-1){
                    continue;
                }
                a[r]=c;
                for(int nbrs:graph.get(r)){
                    if(a[nbrs]==-1){
                        q.add(nbrs);
                    }
                }
            }
            c++;
        }
        int[] b=new int[edges.length];
        Arrays.fill(b,-1);
        q.add(node2);
        c=0;
        while(!q.isEmpty()){
            int s=q.size();
            while(s-->0){
                int r=q.poll();
                if(b[r]!=-1){
                    continue;
                }
                b[r]=c;
                for(int nbrs:graph.get(r)){
                    if(b[nbrs]==-1){
                        q.add(nbrs);
                    }
                }
            }
            c++;
        }
        a[node1]=0;
        b[node2]=0;
        int ans=-1;
        int cc=Integer.MAX_VALUE;
        for(int i=0;i<edges.length;i++){
            if(a[i]>=0 && b[i]>=0){
                if(cc>Math.max(a[i],b[i])){
                    cc=Math.max(a[i],b[i]);
                    ans=i;
                }
            }
        }
        return ans;
    }
}