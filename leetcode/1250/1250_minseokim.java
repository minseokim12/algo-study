// Runtime: 2 ms, faster than 98.60% of Java online submissions for Check If It Is a Good Array.
// Memory Usage: 60.2 MB, less than 24.65% of Java online submissions for Check If It Is a Good Array.
//
// O(n) solution

// 배수의 정의를 이용하면 될 것 같다.
// [3, 6] 은 서로 배수관계이다. [3, 3*2] 로도 표현할 수 있다. 그러니까 우리가 풀고자 하는 문제인 3*a + 3*2b == -1 ? 을 다시 적어보면 3*(a+2b) == -1 인데, a 와 b 는 정수로 정해져있기 때문에, 무조건 3*(a+2b) == 0 이 되고, 문제의 답은 false 가 된다.
// 즉, 받은 array 가 서로 공배수관계로만 존재하면 false 를 리턴하고 아니면 true 를 리턴하면 될 듯하다.

class Solution {
    public boolean isGoodArray(int[] nums) {
            int x = 0;

            for (int num : nums){
                x = gcd(x, num);
            }

            return x == 1;
     }
    
    
    public int gcd(int a, int b){
        if (a==0){
            return b;
        }
        return gcd(b%a, a);
    }
}
