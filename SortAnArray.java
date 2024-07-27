public class SortAnArray {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }
    
    
    public static void main(String[] args) {
        SortAnArray obj = new SortAnArray();
        int[] nums = {5, 2, 3, 1, 4};
        int[] sortedArray = obj.sortArray(nums);
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
    
}
