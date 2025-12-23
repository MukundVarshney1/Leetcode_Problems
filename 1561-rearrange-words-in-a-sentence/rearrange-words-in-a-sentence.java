class Solution {
    public String arrangeWords(String text) {
        String[] s=text.split(" ");
        if(s[0].charAt(0)>=65 && s[0].charAt(0)<=92){
            s[0]=(char)(s[0].charAt(0)+32)+s[0].substring(1);
        }
        Arrays.sort(s,(a,b)->a.length()-b.length());
        s[0]=(char)(s[0].charAt(0)-32)+s[0].substring(1);
        return String.join(" ", s);
    }
}