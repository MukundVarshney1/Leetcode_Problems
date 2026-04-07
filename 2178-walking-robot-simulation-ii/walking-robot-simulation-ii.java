class Robot {
    int w;
    int h;
    int c = 0;
    int[] dir = { 1, 1, -1, -1 };
    int row = 0;
    int col = 0;

    public Robot(int width, int height) {
        w = width;
        h = height;
    }

    public void step(int num) {
        int cycle = 2 * (w + h) - 4;
        num %= cycle;
        if (num == 0) {
            num = cycle;
        }
        while (num > 0) {
            if (c == 0 || c == 2) {
                int newcol = col + dir[c];
                if (newcol < 0 || newcol == w) {
                    c = (c + 1) % 4;
                    continue;
                }
                col = newcol;
            } else {
                int newrow = row + dir[c];
                if (newrow < 0 || newrow == h) {
                    c = (c + 1) % 4;
                    continue;
                }
                row = newrow;
            }
            num--;
        }
    }

    public int[] getPos() {
        int[] ans = new int[2];
        ans[0] = col;
        ans[1] = row;
        return ans;
    }

    public String getDir() {
        return c == 0 ? "East" : c == 1 ? "North" : c == 2 ? "West" : "South";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */