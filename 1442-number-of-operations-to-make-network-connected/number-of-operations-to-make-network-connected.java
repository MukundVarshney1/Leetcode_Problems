class Solution {
    public int makeConnected(int n, int[][] connections) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<connections.length;i++){
            int a=connections[i][0];
            int b=connections[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int c=0;
        int cc=0;
        Set<Integer> visited=new HashSet<>();
        for(int i=0;i<n;i++){
            if(visited.contains(i)){
                continue;
            }
            c++;
            Stack<Integer> st=new Stack<>();
            st.add(i);
            while(!st.isEmpty()){
                int r=st.pop();
                if(visited.contains(r)){
                    cc++;
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
        if(c-1>cc){
            return -1;
        }
        return c-1;
    }
}