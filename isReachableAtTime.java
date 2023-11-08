class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        // base case 
        if(sx == fx && sy == fy)
            return t!=1;
        // logic
        if(Math.max( Math.abs(sx-fx) , Math.abs(fy - sy)) <= t )
            return true;
        return false;
    }
}
