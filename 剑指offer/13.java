class Solution {
    //避免递归传参，定义全局变量
    int x, y, k;
    //是否已经访问过
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        //初始化
        this.x = m;
        this.y = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }

    public int dfs(int x, int y, int sumX, int sumY) {
        //下标越界，数位和大于指定值以及已经访问过都会直接返回
        if (x >= this.x || y >= this.y || sumX + sumY > this.k || visited[x][y]) return 0;
        //标记此坐标访问过
        visited[x][y] = true;
        //@Krahets 大佬总结的精华，适用范围是[0,100)
        // 1.当x或者y从n9进位成(n+1)0时，数位和减小了8
        //    设进位后数的数位和为n，差值为x，得出方程n=(n-1)+9+x，即x=-8
        // 2.当x或者y在个位数从0到8的范围内加1时，数位和增加了1，这是常识。
        //至于为什么只向右和向下扩张是因为不用回溯已走过的路径，扩张的路径只会向下或者向右
        return 1 + dfs(x + 1, y, (x + 1) % 10 == 0 ? sumX - 8 : sumX + 1, sumY)
                + dfs(x, y + 1, sumX, (y + 1) % 10 == 0 ? sumY - 8 : sumY + 1);
    }
}