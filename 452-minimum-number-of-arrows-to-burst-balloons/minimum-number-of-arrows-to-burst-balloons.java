class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int count=1;
        int shot=points[0][1];
        for(int i=1;i<points.length;i++){
            if(shot<points[i][0]){
                shot=points[i][1];
                count++;
            }
        }
        return count;
    }
}