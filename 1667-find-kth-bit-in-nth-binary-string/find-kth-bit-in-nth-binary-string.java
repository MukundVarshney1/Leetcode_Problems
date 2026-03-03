class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb=new StringBuilder();
        sb.append('0');
        for(int i=1;i<n && sb.length()<k;i++){
            String s=helper(sb);
            sb.append('1');
            sb.append(s);
        }
        return sb.charAt(k-1);
    }
    public String helper(StringBuilder sb){
        StringBuilder d=new StringBuilder();
        d.append(sb);
        for(int i=0;i<(d.length()+1)/2;i++){
            if(i==d.length()-1-i){
                d.setCharAt(i,d.charAt(i)=='0'?'1':'0');
                break;
            }
            char a=d.charAt(i);
            char b=d.charAt(d.length()-1-i);
            if(a=='0'){
                d.setCharAt(d.length()-1-i,'1');
            }
            else{
                d.setCharAt(d.length()-1-i,'0');
            }
            if(b=='0'){
                d.setCharAt(i,'1');
            }
            else{
                d.setCharAt(i,'0');
            }
        }
        return d.toString();
    }
}