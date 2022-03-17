// time: O(n) solution 185 ms, faster than 46.62% of Java online submissions 
// space: O(n) solution 69 MB, less than 20.40% of Java online submissions

// n 이라는 숫자를 받았을 때 n 보다 작은 숫자 n-1 개 중 소수가 몇 개 존재하는지 찾는 문제이다
// n-1 개의 소수판별 집합을 만들고, i가 소수이면 notPrime[i] 는 false, 소수가 아니면 true 를 리턴하게 한다.
// -> O(1) 으로 판별가능
// 0부터 n 까지 가는 과정에서, 처음 만나는 숫자는 소수로 정한다. 그리고 소수의 배수들은 모두 소수가 아니므로 notPrime[i] = true 로 바꿔준다.
// 그러므로 notPrime[i] = 가 true 인 i 는 약수가 존재한다는 뜻이므로 소수가 아닐 것이고, false 인 i 는 i 보다 작은 약수가 없다는 뜻이므로 소수이다.
// 이렇게 계산해 나가면 O(n) 으로 n번만큼만 돌고 Prime 을 찾을 수 있다.

class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
    }
}
