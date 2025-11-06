class Solution {
    public boolean canFinish(int numCourses, int[][] p) {
        // using topological sort
        Queue<Integer> q=new LinkedList<>();
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<numCourses;i++){
            map.put(i,new ArrayList<>());
        }
        int[] a=indegree(numCourses,p,map);
        int c=0;
        for(int i=0;i<a.length;i++){
            if(a[i]==0){
                q.add(i);
                c++;
            }
        }
        while(!q.isEmpty()){
            int temp=q.poll();
            for(int v:map.get(temp)){
                a[v]--;
                if(a[v]==0){
                    q.add(v);
                    c++;
                }
            }
        }
        return c==numCourses;
    }
    public int[] indegree(int n,int[][] arr,HashMap<Integer,List<Integer>> map){
        int[] a=new int[n];
        for(int i=0;i<arr.length;i++){
            a[arr[i][0]]++;
            map.get(arr[i][1]).add(arr[i][0]);
        }
        return a;
    }
}