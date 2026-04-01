class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int[][] arr=new int[positions.length][3];
        for(int i=0;i<positions.length;i++){
            arr[i][0]=positions[i];
            arr[i][1]=healths[i];
            arr[i][2]=directions.charAt(i)=='L'?0:1;
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        Stack<Integer> st=new Stack<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(positions[i],i);
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i][2]==0){
                int h=arr[i][1];
                int c=0;
                while(!st.isEmpty() && c==0){
                    if(arr[st.peek()][1]==h){
                        arr[st.pop()][1]=0;
                        arr[i][1]=0;
                        h=0;
                        c=1;
                    }
                    else if(arr[st.peek()][1]>h){
                        arr[st.peek()][1]--;
                        arr[i][1]=0;
                        c=1;
                    }
                    else{
                        arr[st.pop()][1]=0;
                        h--;
                    }
                }
                if(c==0 && st.isEmpty()){
                    arr[i][1]=h;
                }
            }
            else{
                st.push(i);
            }
        }
        int[] a=new int[positions.length];
        List<Integer> ll=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int pos = arr[i][0];
            int he = arr[i][1];
            a[map.get(pos)]=he;
        }
        for(int i=0;i<a.length;i++){
            if(a[i]!=0) ll.add(a[i]);
        }
        return ll;
    }
}