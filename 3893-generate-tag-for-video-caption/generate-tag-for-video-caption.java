class Solution {
    public String generateTag(String cap) {
        cap=cap.trim();
        StringBuilder sb=new StringBuilder();
        sb.append('#');
        int c=0;
        for(int i=0;i<cap.length();i++){
            if(cap.charAt(i)==' '){
                c=1;
                continue;
            }
            if(c!=0){
                if(cap.charAt(i)>=65 && cap.charAt(i)<=92){
                    sb.append(cap.charAt(i));
                }
                else    sb.append((char)(cap.charAt(i)-32));
                c=0;
            }
            else{
                if(cap.charAt(i)>=65 && cap.charAt(i)<=92){
                    sb.append((char)(cap.charAt(i)+32));
                }
                else    sb.append(cap.charAt(i));
            }
        }
        if(sb.length()<=100){
            return sb.toString();
        }
        return sb.toString().substring(0,100);
    }
}