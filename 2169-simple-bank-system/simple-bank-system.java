class Bank {

    private long[] bal;
    private int n;

    public Bank(long[] balance) {
        bal=balance;
        n=balance.length;
    }

    public boolean transfer(int a1, int a2, long m) {
        if(a1<1 || a1>n || a2<1 || a2>n || bal[a1-1]<m){
            return false;
        }
        bal[a1-1]-=m;
        bal[a2-1]+=m;
        return true;
    }
    
    public boolean deposit(int a, long m) {
        if(a<1 || a>n){
            return false;
        }
        bal[a-1]+=m;
        return true;
    }
    
    public boolean withdraw(int a, long m) {
        if(a<1 || a>n || bal[a-1]<m){
            return false;
        }
        bal[a-1]-=m;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */