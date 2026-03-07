class Solution {
    public char findKthBit(int n, int k) {
        if(n==1){
            return '0';
        }
        int length=(1<<n)-1; //power of two
        int req=length/2;//Math.ceil(length/2);
        if(length%2==1){
            req++;
        }
        if(k<req){
            return findKthBit(n-1,k);
        }
        else if(k==req){
            return '1';
        }
        else{
            char ch=findKthBit(n-1,length-k+1);
            ch=ch=='0'?'1':'0';
            return ch;
        }
    }
}