class Solution {
    public List<String> subdomainVisits(String[] arr) {
        List<String> ans=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();
        for(String s:arr){
            int num=0;
            int i=0;
            for(;i<s.length();i++){
                if(s.charAt(i)!=' '){
                    num=num*10+s.charAt(i)-'0';
                }
                else{
                    i++;
                    break;
                }
            }
            while(i<s.length()){
                map.put(s.substring(i),map.getOrDefault(s.substring(i),0)+num);
                for(;i<s.length();i++){
                    if(s.charAt(i)=='.'){
                        i++;
                        break;
                    }
                }
            }
        }
        for(String s:map.keySet()){
            ans.add(map.get(s)+" "+s);
        }
        return ans;
    }
}