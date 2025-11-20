class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]==0?a[0]-b[0]:a[1]-b[1]);
        HashSet<Integer> set=new HashSet<>();
        int a=-1;
        int b=-1;
        for(int i=0;i<intervals.length;i++){
            if(a<intervals[i][0]){
                if(b==intervals[i][1]){
                    a=intervals[i][1]-1;
                }
                else{
                    a=intervals[i][1];
                }
                set.add(a);
            }
            if(b<intervals[i][0]){
                if(a==intervals[i][1]){
                    b=intervals[i][1]-1;
                }
                else{
                    b=intervals[i][1];
                }
                set.add(b);
            }
        }
        return set.size();
    }
}