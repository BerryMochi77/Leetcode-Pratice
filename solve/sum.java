import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 */

public class sum {
    /**
     *  O(n)
     *
     * @param array
     * @param target
     * @return
     */
    public static int[] twoSum(int[] array, int target){
        Map<Integer, Integer> hashtable = new HashMap<>();
        for(int i = 0 ; i < array.length ; i++){
            if(hashtable.containsKey(target - array[i])){
                return new int[]{hashtable.get(target - array[i]),i};
            }
            hashtable.put(array[i],i);
        }
        return new int[0];
    }

    /**
     * O(n²)
     *
     * @param array
     * @param target
     * @return
     */
    public static int[] getsum(int[] array, int target){
        int[] result = new int[2];
        for(int i = 0 ; i < array.length ; i++){
            for(int j = i+1 ; j < array.length ; j++){
                if(array[i] + array[j] == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int[] r = getsum(nums, 9);
        System.out.println(r[0] + ", " + r[1]);
        int[] r2 = twoSum(nums, 9);
        System.out.println(r2[0] + ", " + r2[1]);
    }
}

