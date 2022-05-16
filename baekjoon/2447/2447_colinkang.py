# https://www.acmicpc.net/problem/2447
#재귀적인 패턴으로 별을 찍어 보자. N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.

#크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.

#***
#* *
#***
#N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다.
# 예를 들어 크기 27의 패턴은 예제 출력 1과 같다.

import sys
input = sys.stdin.readline

class Solution:

    def star(self, i, j, num):
        if i // num % 3 == 1 and j // num % 3 == 1:
            print(" ", end="", flush=True)
        else:
            if num // 3 == 0:
                print("*", end="", flush=True)
            else:
                self.star(i,j,num/3)



import unittest

class TestSum(unittest.TestCase):

    def test_make_star(self):
        print(self)
        solution = Solution()
        input_1 = 27
        n = int(input_1)

        for i in range(n):
            for j in range(n):
                solution.star(i, j, n)
            print("")

if __name__ == '__main__':
    unittest.main()