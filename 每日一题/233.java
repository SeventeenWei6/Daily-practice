class Solution {
    public int countDigitOne(int n) {
    int count = 0;
    for (long k = 1; k <= n; k *= 10) {
        // xyzdabc
        long abc = n % k;
        long xyzd = n / k;
        long d = xyzd % 10;
        long xyz = (xyzd + 8) / 10;
        count += xyz * k;
        if (d == 1) {
            count += abc + 1;
        }
    }
    return count;
}
}