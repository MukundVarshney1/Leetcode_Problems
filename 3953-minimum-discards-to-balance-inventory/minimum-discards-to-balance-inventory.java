class Solution {
    public int minArrivalsToDiscard(int[] a, int w, int m) {
        Map<Integer,Integer> map=new HashMap<>();
        int si=0;
        int ei=0;
        int ans=0;
        while(si<=ei && ei<a.length){
            if(ei-si==w){
                if(a[si]!=-1 && map.get(a[si])>0){
                    map.put(a[si],map.getOrDefault(a[si],0)-1);
                }
                si++;
            }
            if(map.getOrDefault(a[ei],0)<m){
                map.put(a[ei],map.getOrDefault(a[ei],0)+1);
            }
            else{
                a[ei]=-1;
                ans++;
            }
            ei++;
        }
        return ans;
    }
}