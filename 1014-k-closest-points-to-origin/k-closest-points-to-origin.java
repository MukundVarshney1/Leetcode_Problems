class Solution {
    class pair{
        int dist;
        int x;
        int y;
        pair(int dist,int x,int y){
            this.dist=dist;
            this.x=x;
            this.y=y;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->b.dist-a.dist);
        for(int[] p:points){
            int x=p[0];
            int y=p[1];
            int dist=x*x+y*y;
            pq.add(new pair(dist,x,y));
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[][] ans=new int[k][2];
        int c=pq.size();
        for(int i=0;i<c;i++){
            pair temp=pq.poll();
            ans[i][0]=temp.x;
            ans[i][1]=temp.y;
        }
        return ans;
    }
}