class Solution {
    public int numberOfBeams(String[] bank) {
        int p=0;
        int ans=0;
        for(int i=0;i<bank.length;i++){
            int c=0;
            for (char ch : bank[i].toCharArray()) {
                if(ch=='1'){
                    c++;
                }
            }
            if(c!=0){
                ans+=p*c;
                p=c;
            }
        }
        return ans;
    }
}