class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<isConnected.length;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1 && i!=j){
                    graph.get(i).add(j);
                }
            }
        }
        int ans=0;
        Set<Integer> visited=new HashSet<>();
        for(int i=0;i<isConnected.length;i++){
            if(!visited.contains(i)){
                ans++;
                Stack<Integer> st=new Stack<>();
                st.push(i);
                while(!st.isEmpty()){
                    int r=st.pop();
                    if(visited.contains(r)){
                        continue;
                    }
                    visited.add(r);
                    for(int a:graph.get(r)){
                        if(!visited.contains(a)){
                            st.push(a);
                        }
                    }
                }
            }
        }
        return ans;
    }
}