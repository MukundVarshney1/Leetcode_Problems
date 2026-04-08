class Solution {
    public String getHint(String secret, String guess) {
        Map<Character,Integer> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        int x=0;
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                set.add(i);
                x++;
                continue;
            }
            map.put(secret.charAt(i),map.getOrDefault(secret.charAt(i),0)+1);
        }
        int y=0;
        for(int i=0;i<guess.length();i++){
            if(!set.contains(i)){
                if(map.containsKey(guess.charAt(i)) && map.get(guess.charAt(i))>0){
                    y++;
                    map.put(guess.charAt(i),map.get(guess.charAt(i))-1);
                }
            }
        }
        return x+"A"+y+"B";
    }
}