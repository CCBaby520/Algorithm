package com.stu.leetcode.dsl.medium;

/**
 * @desc: 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 *
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 */
public class MinEatingSpeed {

    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        int i = minEatingSpeed(piles, 1);
        System.out.println(i);
    }

    /**
     * 思路分析：
     *
     * 根据题意可以知道：珂珂吃香蕉的速度越小，耗时越多。反之，速度越大，耗时越少，这是题目的 单调性；
     * 我们要找的是速度。因为题目限制了珂珂一个小时之内只能选择一堆香蕉吃，因此速度最大值就是这几堆香蕉中，数量最多的那一堆。速度的最小值是 11，其实还可以再分析一下下界是多少，由于二分搜索的时间复杂度很低，严格的分析不是很有必要；
     * 还是因为珂珂一个小时之内只能选择一堆香蕉吃，因此：每堆香蕉吃完的耗时 = 这堆香蕉的数量 / 珂珂一小时吃香蕉的数量。根据题意，这里的 / 在不能整除的时候，需要 上取整。
     * 注意：当「二分查找」算法猜测的速度恰好使得珂珂在规定的时间内吃完香蕉的时候，还应该去尝试更小的速度是不是还可以保证在规定的时间内吃完香蕉。
     *
     * 这是因为题目问的是「最小速度 」。
     *
     * @param piles
     * @param H
     * @return
     */
    public static int minEatingSpeed(int[] piles, int H) {
        int maxVal = 1;
        for (int pile : piles) {
            maxVal = Math.max(maxVal, pile);
        }

        // 速度最小的时候，耗时最长
        int left = 1;
        // 速度最大的时候，耗时最短
        int right = maxVal;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (calculateSum(piles, mid) > H) {
                // 耗时太多，说明速度太慢了，下一轮搜索区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 如果返回的小时数严格大于 H，就不符合题意
     *
     * @param piles
     * @param speed
     * @return 需要的小时数
     */
    private static int calculateSum(int[] piles, int speed) {
        int sum = 0;
        for (int pile : piles) {
            // 上取整可以这样写
            sum += (pile + speed - 1) / speed;
        }
        return sum;
    }
}
