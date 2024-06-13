public class CyclicSort {
    /** Find the Missing Number
     * Given an array of n distinct integers from 0 to n 
     * The array only has n out of n + 1 numbers
     */
    public static void sort (int[] nums) {
        int index = 0;

        while (index < nums.length) {
            if (nums[index] != index) 
                swap(nums, nums[index], index);
            else
                index++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                System.out.println("The missing number is: " + i);
        }
    }

    public static void swap(int[] array, int currentValue, int index) {
        int newIndex = currentValue - 1;
        int tempValue = array[newIndex];
        array[newIndex] = array[index];
        array[index] = tempValue;
    }

    public static void main(String[] args) {
        int[] testArray = new int[]{4, 0, 3, 1};

        CyclicSort.sort(testArray);
    }
}
