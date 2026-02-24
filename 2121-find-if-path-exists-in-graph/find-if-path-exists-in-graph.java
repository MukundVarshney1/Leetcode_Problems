class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
       Map<Integer,Set<Integer>> map=new HashMap<>();
       for(int i=0;i<n;i++){
        map.put(i,new HashSet<>());
       }
       for(int i=0;i<edges.length;i++){
        int a=edges[i][0];
        int b=edges[i][1];
        map.get(a).add(b);
        map.get(b).add(a);
       }
       Queue<Integer> q=new LinkedList<>();
       Set<Integer> visited=new HashSet<>();
       q.add(source);
       while(!q.isEmpty()){
        int r=q.poll();
        if(visited.contains(r)){
            continue;
        }
        if(r==destination){
            return true;
        }
        visited.add(r);
        for(int nbrs:map.get(r)){
            if(!visited.contains(nbrs)){
                q.add(nbrs);
            }
        }
       }
       return false;
    }
}