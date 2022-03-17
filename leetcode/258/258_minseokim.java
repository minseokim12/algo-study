// O(n*len(n)) solution
class Solution {
    public int addDigits(int num) {
        while (num > 9) {
            int tempSum = 0;
            char[] nums = String.valueOf(num).toCharArray();
            for (char i : nums) {
                tempSum += i;
            }
            num = tempSum;
        }
        
        return num;
    }
}


// O(1) solution
// time 62.70% solution
// memory 41.7% solution
class Solution {
    public int addDigits(int num) {
        if(num == 0) return 0;
        else if(num % 9 == 0) return 9;
        else return num % 9;
    }
}
