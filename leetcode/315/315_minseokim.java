// 다른 사람 submission 참고
// Merge sort 풀이
// O(nlogn) time complexity
// Runtime: 206 ms, faster than 45.51% of Java online submissions
// Memory Usage: 121.1 MB, less than 66.70% of Java online submissions

public class Solution {
    
    public List<Integer> countSmaller(int[] nums) {
        int len = (nums == null? 0 : nums.length);
        
        int[] idxs = new int[len];
        int[] count = new int[len];
        
        for (int i = 0; i < len; i++) idxs[i] = i;
        
        mergeSort(nums, idxs, 0, len, count);
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : count) list.add(i);
        
        return list;
    }
    
    private void mergeSort(int[] nums, int[] idxs, int start, int end, int[] count) {
        if (start + 1 >= end) return;
        
        int mid = (end - start) / 2 + start;
        mergeSort(nums, idxs, start, mid, count);
        mergeSort(nums, idxs, mid, end, count);
        
        merge(nums, idxs, start, end, count);
    }
    
    private void merge(int[] nums, int[] idxs, int start, int end, int[] count) {
        int mid = (end - start) / 2 + start;
        
        int[] tmp = new int[end - start];
        int[] tmpidx = new int[end - start];
        int i = start, j = mid, k = 0;
        while (k < end - start) {
            if (i < mid) {
                if (j < end && nums[j] < nums[i]) {
                    tmpidx[k] = idxs[j];
                    tmp[k++] = nums[j++];
                } else {
                    count[idxs[i]] += j - mid; // add those already counted
                    tmpidx[k] = idxs[i];
                    tmp[k++] = nums[i++];
                }
                
            } else {
                tmpidx[k] = idxs[j];
                tmp[k++] = nums[j++];
            }
        }
        
        System.arraycopy(tmpidx, 0, idxs, start, end - start);
        System.arraycopy(tmp, 0, nums, start, end - start);
    }
}
