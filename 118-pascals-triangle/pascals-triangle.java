class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        ll.add(1);
        ans.add(new ArrayList<>(ll));
        if(n==1){
            return ans;
        }
        ll.add(1);
        ans.add(new ArrayList<>(ll));
        if(n==2){
            return ans;
        }
        for(int i=2;i<n;i++){
            List<Integer> temp=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    temp.add(1);
                }
                else{    
                    temp.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}