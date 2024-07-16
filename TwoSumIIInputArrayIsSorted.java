
public class TwoSumIIInputArrayIsSorted{
    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int l = 0, r = numbers.length - 1;
        while(l < r){
            if(numbers[l] + numbers[r] == target){
                res[0] = l + 1;
                res[1] = r + 1;
                break;
            }
            else if(numbers[l] + numbers[r] < target){
                l++;
            }
            else{
                r--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(numbers, target);
        System.out.println(result[0] + " " + result[1]);
    }

}