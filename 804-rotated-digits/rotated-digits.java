class Solution {
    public int rotatedDigits(int n) {
        int ans=0;
        for(int i=2;i<=n;i++){
            int temp=i;
            int f=0;
            int idx=0;
            int c=0;
            while(temp>0){
                int r=temp%10;
                temp/=10;
                c++;
                if(r==0 || r==1 || r==8){
                    continue;
                }
                else if(r==3 || r==4 || r==7){
                    idx=c-1;
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
            else if(idx>0){
                i+=Math.pow(10,idx)-1;
            }
        }
        return ans;
    }
}