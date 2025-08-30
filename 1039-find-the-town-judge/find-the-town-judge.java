class Solution {
    public int findJudge(int n, int[][] trust) {
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<n+1;i++){
            ans.add(i);
        }
        for(int i=0;i<trust.length;i++){
            ans.remove(Integer.valueOf(trust[i][0]));
        }
        int x=ans.size()>0?ans.get(0):0;
        if(x==0){
            return -1;
        }
        int m=0;
        for(int i=0;i<trust.length;i++){
            if(trust[i][1]==x){
                m++;
            }
        }
        if(m!=n-1){
            return -1;
        }
        return x;
    }
}