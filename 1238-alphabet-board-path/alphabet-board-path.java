class Solution {
    public String alphabetBoardPath(String target) {
        // creating cordinates
        List<int[]> ll = List.of(
    new int[]{0, 0}, new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{0, 4},
    new int[]{1, 0}, new int[]{1, 1}, new int[]{1, 2}, new int[]{1, 3}, new int[]{1, 4},
    new int[]{2, 0}, new int[]{2, 1}, new int[]{2, 2}, new int[]{2, 3}, new int[]{2, 4},
    new int[]{3, 0}, new int[]{3, 1}, new int[]{3, 2}, new int[]{3, 3}, new int[]{3, 4},
    new int[]{4, 0}, new int[]{4, 1}, new int[]{4, 2}, new int[]{4, 3}, new int[]{4, 4},
    new int[]{5,0});


    StringBuilder sb=new StringBuilder();
    int x=0;
    int y=0;
    for(int i=0;i<target.length();i++){
        int[] loc=ll.get(target.charAt(i)-'a');
        int x1=loc[0];
        int y1=loc[1];
        int dx=x1-x;
        int dy=y1-y;
        // all in if because 'z' does not have a right column
        if(dy<0){
            for(int j=0;j<Math.abs(dy);j++){
                sb.append('L');
            }
        }if(dx<0){
            for(int j=0;j<Math.abs(dx);j++){
                sb.append('U');
            }
        }
        if(dx>0){
            for(int j=0;j<dx;j++){
                sb.append('D');
            }
        }
        if(dy>0){
            for(int j=0;j<dy;j++){
                sb.append('R');
            }
        }
        sb.append('!');
        x=x1;
        y=y1;
    }
    return sb.toString();
    }
}