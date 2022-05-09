/**
 * https://leetcode.com/problems/valid-boomerang/
 */
class Solution {

    public boolean isBoomerang(int[][] points) {
        Pair a = new Pair(points[0][0], points[0][1]);
        Pair b = new Pair(points[1][0], points[1][1]);
        Pair c = new Pair(points[2][0], points[2][1]);

       return (b.getY() - a.getY()) * (c.getX() - b.getX()) != (c.getY() - b.getY()) * (b.getX() - a.getX());
    }
        
    class Pair {
        private int x;
        private int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return x;
        }

        public int getY(){
            return y;
        }
    }
}