class Solution {
    public long[] sumOfThree(long num) {
        if((num-3)%3!=0){
            return new long[0];
        }
        long[] ans=new long[3];
        num-=3;
        long a=num/3;
        ans[0]=a;
        ans[1]=a+1;
        ans[2]=a+2;
        return ans;
    }
}