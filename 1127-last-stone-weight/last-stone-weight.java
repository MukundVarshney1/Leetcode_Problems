class Solution {
    public int lastStoneWeight(int[] a) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((c,b)->b-c);
        for(int i=0;i<a.length;i++){
            pq.add(a[i]);
        }
        while(pq.size()>1){
            int x=pq.poll();
            int y=pq.poll();
            if(x==y){
                continue;
            }
            pq.add(Math.abs(x-y));
        }
        return pq.size()==1?pq.poll():0;
    }
}