class Solution {
    public int findFinalValue(int[] n, int o) {
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<n.length;i++){
            set.add(n[i]);
        }
        for(int i=0;i<=n.length;i++){
            if(set.contains(o)){
                o*=2;
            }
            else{
                return o;
            }
        }
        return o;
    }
}