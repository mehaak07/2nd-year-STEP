public class FindMinimumRotated {

    static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = (left + right) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum is in the right half
                left = mid + 1;
            } else {
                // Minimum is in the left half, including mid
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, 5, 1, 2};

        int result = findMin(nums);

        System.out.println("Minimum element: " + result);
    }
}