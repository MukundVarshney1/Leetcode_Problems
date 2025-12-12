class Solution {
    public int[] countMentions(int n, List<List<String>> e) {
        int[] a=new int[n];
        Arrays.fill(a,1);
        Queue<Pair> q=new LinkedList<>();
        Collections.sort(e,(x,y)->Integer.parseInt(x.get(1))-Integer.parseInt(y.get(1))==0?y.get(0).compareTo(x.get(0)):Integer.parseInt(x.get(1))-Integer.parseInt(y.get(1)));
        for(int i=0;i<e.size();i++){
            while(!q.isEmpty() && q.peek().time+60<=Integer.parseInt(e.get(i).get(1))){
                int y=q.poll().val;
                a[y]*=-1;
            }
            if(e.get(i).get(0).equals("MESSAGE")){
                String s=e.get(i).get(2);
                if(s.equals("ALL")){
                    for(int j=0;j<n;j++){
                        if(a[j]<0){
                            a[j]--;
                        }
                        else{
                            a[j]++;
                        }
                    }
                }
                else if(s.equals("HERE")){
                    for(int j=0;j<n;j++){
                        if(a[j]>=0){
                            a[j]++;
                        }
                }
                }
                else{
                    String[] arr=s.split(" ");
                    for(int j=0;j<arr.length;j++){
                        int m=Integer.parseInt(arr[j].substring(2));
                        if(a[m]<0){
                            a[m]--;
                        }
                        else{
                            a[m]++;
                        }
                    }
                }
            }
            else{
                q.add(new Pair(Integer.parseInt(e.get(i).get(2)),Integer.parseInt(e.get(i).get(1))));
                a[Integer.parseInt(e.get(i).get(2))]*=-1;
            }
        }
        for(int i=0;i<a.length;i++){
            if(a[i]<0){
                a[i]*=-1;
            }
            a[i]--;
        }
        return a;
    }
    public class Pair{
        int val;
        int time;
        Pair(int x,int y){
            val=x;
            time=y;
        }
    }
}