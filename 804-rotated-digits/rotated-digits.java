class Solution {
    public int rotatedDigits(int n) {
        int ans=0;
        for(int i=2;i<=n;i++){
            int temp=i;
            int f=0;
            while(temp>0){
                int r=temp%10;
                temp/=10;
                if(r==0 || r==1 || r==8){
                    continue;
                }
                else if(r==3 || r==4 || r==7){
                    f=0;
                    break;
                }
                else{
                    f=1;
                }
            }
            if(f==1){
                ans++;
            }
        }
        return ans;
    }
}