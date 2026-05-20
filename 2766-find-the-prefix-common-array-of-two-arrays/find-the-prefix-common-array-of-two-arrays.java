class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] arr=new int[A.length];
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<A.length;i++){
            set.add(A[i]);
            int c=0;
            for(int j=i;j>=0;j--){
                if(set.contains(B[j])){
                    c++;
                }
            }
            arr[i]=c;
        }
        return arr;
    }
}