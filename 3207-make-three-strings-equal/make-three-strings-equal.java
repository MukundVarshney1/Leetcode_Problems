class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
       int a=s1.length();
       int b=s2.length();
       int c=s3.length();
       int min=a;
       if(min>b){
        min=b;
       }
       if(min>c){
        min=c;
       }
       int max=a;
       if(max<b){
        max=b;
       }
       if(max<c){
        max=c;
       }
       for(int i=0;i<min;i++){
        if(s1.charAt(i)!=s2.charAt(i) || s2.charAt(i)!=s3.charAt(i)){
            if(i==0){
                return -1;
            }
            return Math.abs(a-i)+Math.abs(b-i)+Math.abs(c-i);
        }
       }
       return Math.abs(a-min)+Math.abs(b-min)+Math.abs(c-min);
    }
}