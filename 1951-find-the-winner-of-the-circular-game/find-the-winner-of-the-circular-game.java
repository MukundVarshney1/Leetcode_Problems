class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            q.add(i);
        }
        int pos=0;
        while(q.size()>1){
            int rem=(pos+k-1)%q.size();
            q.remove(((LinkedList<Integer>) q).get(rem));
            pos=rem;
        }
        return q.poll();
    }
}