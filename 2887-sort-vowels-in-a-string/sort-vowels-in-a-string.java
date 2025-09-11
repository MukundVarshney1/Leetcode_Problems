class Solution {
    public String sortVowels(String s) {
        ArrayList<Character> charList = new ArrayList<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            if(isvow(s.charAt(i))){
                charList.add(s.charAt(i));
            }
        }
        Collections.sort(charList);
        System.out.println(charList);
        int k=0;
        StringBuilder str=new StringBuilder();
        for(int i=0;i<n;i++){
            if(isvow(s.charAt(i))){
                str.append(charList.get(k++));
            }
            else{
                str.append(s.charAt(i));
            }
        }
        return str.toString();
        
    }
    public boolean isvow(char ch){
        return ch=='a' || ch=='e'||ch=='i'||ch=='o' ||ch=='u' || ch=='A'||ch=='E'||ch=='I' ||ch=='O' || ch=='U';
    }
}