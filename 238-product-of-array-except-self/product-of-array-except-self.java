class Solution {
    public int[] productExceptSelf(int[] arr) {
        int n=arr.length;
        int[] left=new int[n];
        left[0]=1;
        int[] right=new int[n];
        right[n-1]=1;
        for(int i=1,j=n-2;i<n && j>=0;i++,j--){
            left[i]=left[i-1]*arr[i-1];
            right[j]=right[j+1]*arr[j+1];
        }
        for(int i=0;i<n;i++){
            arr[i]=left[i]*right[i];
        }
        return arr;
    }
}