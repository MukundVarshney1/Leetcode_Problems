class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count=0;
        for(int i=left;i<=right;i++){
            int a=i;
            int sb=0;
            while(a>0){
                a=a-(a&-a); // a&(a-1) we can use
                sb++;
            }
            if(isprime(sb)){
                count++;
            }
        }
        return count;
    }
    public boolean isprime(int n){
        return n==2 || n==3 || n==5 || n==7 || n==11 || n==13 || n==17 || n==19;
    }
}