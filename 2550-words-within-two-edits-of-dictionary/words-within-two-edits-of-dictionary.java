class Solution {
    public List<String> twoEditWords(String[] q, String[] d) {
        List<String> ll=new LinkedList<>();
        for(int i=0;i<q.length;i++){
            for(int j=0;j<d.length;j++){
                int c=0;
                for(int k=0;k<q[i].length();k++){
                    if(q[i].charAt(k)!=d[j].charAt(k)){
                        c++;
                    }
                }
                if(c<3){
                    ll.add(q[i]);
                    break;
                }
            }
        }
        return ll;
    }
}