import math
class Solution:
    def countPrimes(self, n: int) -> int:
        if n < 3:
            return 0
        prime_list = [True for _ in range(n)]
        prime_list[0], prime_list[1] = False, False
        for i in range(2, n):
            if math.sqrt(n) < i:
                break
            if prime_list[i] is False:
                continue
            for j in range(2, n // i + 1):
                if n - 1 < i * j:
                    break
                if prime_list[i * j] is True:
                    prime_list[i * j] = False
        return sum(prime_list)
