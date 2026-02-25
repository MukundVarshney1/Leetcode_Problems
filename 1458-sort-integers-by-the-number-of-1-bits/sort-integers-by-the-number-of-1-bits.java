class Solution {
    class pair{
        int val;
        int co;
        pair(int val){
            this.val=val;
        }
    }
    public int[] sortByBits(int[] arr) {
        
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.co-b.co!=0?a.co-b.co:a.val-b.val);
        for(int i=0;i<arr.length;i++){
            pair p=new pair(arr[i]);
            p.co=co(arr[i]);
            pq.add(p);
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=pq.poll().val;
        }
        return arr;
    }
    public int co(int a){
        int co=0;
        while(a!=0){
            a=a&(a-1);
            co++;
        }
        return co;
    }
}