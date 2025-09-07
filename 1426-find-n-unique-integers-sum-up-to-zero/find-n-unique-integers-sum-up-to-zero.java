class Solution {
    public int[] sumZero(int n) {
        int[] arr=new int[n];
        int c=-n/2;
        for(int i=0;i<n;i++){
            if(n%2==0 && i==n/2){
                c++;
            }
            arr[i]=c++;
        }
        return arr;
    }
}