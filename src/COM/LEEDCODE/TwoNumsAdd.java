package COM.LEEDCODE;

import java.util.HashMap;
import java.util.Map;

/**
 * 1两数之合
 *
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 *
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoNumsAdd {
    //暴力穷举
//    暴力法很简单。遍历每个元素 xxx，并查找是否存在一个值与 target−xtarget - xtarget−x 相等的目标元素。
    public int[] twoSumFor(int[] nums,int target){
       for (int i = 0;i<nums.length;i++){
            for (int k = 0; k<nums.length;k++){
                if (target == nums[i] + nums[k]){
                    return new int[]{i,k};
                }
            }
        }
//        throw new IllegalAccessException("没有能相加成功的");
       throw new IllegalArgumentException("没有能相加成功的");
    }

    /**两遍哈希表
     * 为了对运行时间复杂度进行优化，我们需要一种更有效的方法来检查数组中是否存在目标元素。如果存在，我们需要找出它的索引。保持数组中的每个元素与其索引相互对应的最好方法是什么？哈希表。
     *
     * 通过以空间换取速度的方式，我们可以将查找时间从 O(n)O(n)O(n) 降低到 O(1)O(1)O(1)。哈希表正是为此目的而构建的，它支持以 近似 恒定的时间进行快速查找。我用“近似”来描述，是因为一旦出现冲突，查找用时可能会退化到 O(n)O(n)O(n)。但只要你仔细地挑选哈希函数，在哈希表中进行查找的用时应当被摊销为 O(1)O(1)O(1)。
     *
     * 一个简单的实现使用了两次迭代。在第一次迭代中，我们将每个元素的值和它的索引添加到表中。然后，在第二次迭代中，我们将检查每个元素所对应的目标元素（target−nums[i]target - nums[i]target−nums[i]）是否存在于表中。注意，该目标元素不能是 nums[i]nums[i]nums[i] 本身！
     * @param nums
     * @param target
     * @return
     */
        public int[] twoHash(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<nums.length;i++){
            map.put(nums[i] ,i);
        }
        for (int i = 0;i<nums.length;i++){
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement)!=i){
                return new int[]{ i,map.get(complement)};
            }
        }
        throw new IllegalArgumentException("没有相加相同的");
    }

    /**
     * 一遍哈希表
     *
     * 事实证明，我们可以一次完成。在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。如果它存在，那我们已经找到了对应解，并立即将其返回。
     * @param args
     */
    public int[] oneHash(int[] nums,int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("没有两个相同");
    }

    public static void main(String[] args) {
        int[] a= {1,2,3,4,5,6,23,21,3,4};
        int b = 10;
        TwoNumsAdd TN = new TwoNumsAdd();

        //暴力法(穷举)
        int[] tFor = TN.twoSumFor(a,b);
        System.out.println(a[tFor[0]]+"和"+a[tFor[1]]);

        //两遍哈希
        int[] tHash = TN.twoHash(a,b);
        System.out.println(a[tHash[0]]+"和"+a[tHash[1]]);

        //一遍哈希
        int[] oHash = TN.oneHash(a,b);
        System.out.println(a[tHash[0]]+"和"+a[tHash[1]]);

    }
}