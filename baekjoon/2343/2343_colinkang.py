#https://www.acmicpc.net/problem/2343
#강토는 자신의 기타 강의 동영상을 블루레이로 만들어 판매하려고 한다.
# 블루레이에는 총 N개의 강의가 들어가는데, 블루레이를 녹화할 때, 강의의 순서가 바뀌면 안 된다.
# 순서가 뒤바뀌는 경우에는 강의의 흐름이 끊겨, 학생들이 대혼란에 빠질 수 있기 때문이다.
# 즉, i번 강의와 j번 강의를 같은 블루레이에 녹화하려면 i와 j 사이의 모든 강의도 같은 블루레이에 녹화해야 한다.

#강토는 이 블루레이가 얼마나 팔릴지 아직 알 수 없기 때문에,
# 블루레이의 개수를 가급적 줄이려고 한다.
# 오랜 고민 끝에 강토는 M개의 블루레이에 모든 기타 강의 동영상을 녹화하기로 했다.
# 이때, 블루레이의 크기(녹화 가능한 길이)를 최소로 하려고 한다.
# 단, M개의 블루레이는 모두 같은 크기이어야 한다.

#강토의 각 강의의 길이가 분 단위(자연수)로 주어진다.
# 이때, 가능한 블루레이의 크기 중 최소를 구하는 프로그램을 작성하시오.

#9 3 : total num of lectures | num of disk
#1 2 3 4 5 6 7 8 9 : size of each lecture



from typing import List
import os


class Main:

    def max_time_of_disks(self, n, m, play_time_list: List[int]) -> int:
        # n : total size of play
        # m : given disk

        # left 조건
        max_one_of_play = max(play_time_list)
        # right 조건
        sum_all_of_play = sum(play_time_list)
        max_sub_sum_one_disk = 1
        num_play_list = n
        limit_of_disk = m

        while (max_sub_sum_one_disk <= sum_all_of_play) :
            bar_of_disk = (max_sub_sum_one_disk+sum_all_of_play)//2

            # 중간값이 가장 긴것보다 작다는 것은 1, 1, 1, 1, 5 이런 경우
            if (bar_of_disk < max_one_of_play):
                max_sub_sum_one_disk = bar_of_disk + 1
                continue

            # 각 디스크 벼로
            count_of_disk = 1
            play_time = 0
            for i in range(num_play_list):

                # 하나 더 넣었는데 중간 값보다 작거나 같으면 : play 추가 else 디스크 추가
                if((play_time + play_time_list[i]) <= bar_of_disk):
                    play_time += play_time_list[i]
                else:
                    count_of_disk += 1
                    play_time = play_time_list[i]

                if (count_of_disk > limit_of_disk):
                    break

            if (count_of_disk > limit_of_disk):
                max_sub_sum_one_disk = bar_of_disk + 1
            else:
                sum_all_of_play = bar_of_disk - 1

        return max_sub_sum_one_disk


import unittest

class TestSum(unittest.TestCase):

    def test_divide_disk(self):
        if (self.isMacOS() == False) :
            n, m = map(int, input().split())  # N: 레슨 수, M: 블루레이 수
            input_list = list(map(int, input().split()))  # 레슨들
        else :
            n = 9
            m = 3
            input_str = "1 2 3 4 5 6 7 8 9"
            input_list = list(map(int, input_str.split()))
            expected_result = 17

        main = Main()
        result = main.max_time_of_disks(n, m, input_list)
        if (self.isMacOS() == False) :
            print(result)
        else:
            self.assertEqual(expected_result, result, "The result is incorrect")

    def isMacOS(self) -> bool:
        return os.path.isdir("/Library")

if __name__ == '__main__':
    unittest.main()