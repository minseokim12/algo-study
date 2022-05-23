#https://www.acmicpc.net/problem/2805
#상근이는 나무 M미터가 필요하다. 근처에 나무를 구입할 곳이 모두 망해버렸기 때문에,
# 정부에 벌목 허가를 요청했다. 정부는 상근이네 집 근처의 나무 한 줄에 대한 벌목 허가를 내주었고,
# 상근이는 새로 구입한 목재절단기를 이용해서 나무를 구할것이다.

#목재절단기는 다음과 같이 동작한다. 먼저, 상근이는 절단기에 높이 H를 지정해야 한다.
# 높이를 지정하면 톱날이 땅으로부터 H미터 위로 올라간다. 그 다음, 한 줄에 연속해있는 나무를 모두 절단해버린다.
# 따라서, 높이가 H보다 큰 나무는 H 위의 부분이 잘릴 것이고, 낮은 나무는 잘리지 않을 것이다.
# 예를 들어, 한 줄에 연속해있는 나무의 높이가 20, 15, 10, 17이라고 하자. 상근이가 높이를 15로 지정했다면,
# 나무를 자른 뒤의 높이는 15, 15, 10, 15가 될 것이고, 상근이는 길이가 5인 나무와 2인 나무를 들고 집에 갈 것이다.
# (총 7미터를 집에 들고 간다) 절단기에 설정할 수 있는 높이는 양의 정수 또는 0이다.

#상근이는 환경에 매우 관심이 많기 때문에, 나무를 필요한 만큼만 집으로 가져가려고 한다.
# 이때, 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값을 구하는 프로그램을 작성하시오.




from typing import List
import os


class Main:

    def max_height_of_cutting(self, n, m, tree_height_list: List[int]) -> int:
        # n : total size of play
        # m : given disk

        target_length_tree = m
        # low : low_limit
        # high : high_limit
        low, high = 1, max(tree_height_list)

        while low <= high: #적절한 벌목 높이를 찾는 알고리즘
            mid_height = (low+high) // 2

            sum_of_cut = 0 #벌목된 나무 총합
            for tree_height in tree_height_list:
                if tree_height >= mid_height:
                    sum_of_cut += tree_height - mid_height

            #벌목 높이를 이분탐색
            if sum_of_cut >= target_length_tree:
                low = mid_height + 1
            else:
                high = mid_height - 1

        return high


import unittest

class TestSum(unittest.TestCase):

    def test_max_height(self):
        if (self.isMacOS() == False) :
            n, m = map(int, input().split())  # N: 레슨 수, M: 블루레이 수
            input_list = list(map(int, input().split()))  # 레슨들
        else :
            n = 4
            m = 7
            input_str = "20 15 10 17"
            input_list = list(map(int, input_str.split()))
            expected_result = 15

        main = Main()
        result = main.max_height_of_cutting(n, m, input_list)
        if (self.isMacOS() == False) :
            print(result)
        else:
            self.assertEqual(result, expected_result, "The result is incorrect")

    def isMacOS(self) -> bool:
        return os.path.isdir("/Library")

if __name__ == '__main__':
    unittest.main()
