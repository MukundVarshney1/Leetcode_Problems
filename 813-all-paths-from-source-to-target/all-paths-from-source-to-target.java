class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        ll.add(0);
        Set<Integer> set=new HashSet<>();
        helper(graph,0,ans,ll);
        return ans;
    }
    public void helper(int[][] graph,int idx,List<List<Integer>> ans,List<Integer>ll){
        if(idx==graph.length-1){
            ans.add(new ArrayList<>(ll));
            return;
        }
        for(int i=0;i<graph[idx].length;i++){
            ll.add(graph[idx][i]);
            helper(graph,graph[idx][i],ans,ll);
            ll.remove(ll.size()-1);
        }
        return;
    }
}