class Solution {
    public String evaluate(String s, List<List<String>> k) {
        Map<String,String> map=new HashMap<>();
        for(int i=0;i<k.size();i++){
            map.put(k.get(i).get(0),k.get(i).get(1));
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='('){
                sb.append(s.charAt(i));
            }
            else{
                i++;
                StringBuilder ss=new StringBuilder();
                for(;i<s.length();i++){
                    if(s.charAt(i)!=')'){
                        ss.append(s.charAt(i));
                    }
                    else{
                        break;
                    }
                }
                String st=map.get(ss.toString());
                sb.append(st==null?'?':st);
            }
        }
        return sb.toString();
    }
}