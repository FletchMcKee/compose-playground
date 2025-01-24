package com.example.composeplayground

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test

class LeetCodeTest {

    @Test
    fun `Find First and Last Position of Element in Sorted Array`() {
        val nums = intArrayOf(5,7,7,8,8,10)
        val target = 8

        val expected = intArrayOf(3, 4)
        val actual = searchRange(nums, target)
        assertThat(actual).isEqualTo(expected)
    }

    private fun searchRange(nums: IntArray, target: Int): IntArray {
        val ans = IntArray(2)
        ans[0] = helper(nums, target, false)
        ans[1] = helper(nums, target, true)
        return ans
    }

    private fun helper(nums: IntArray, target: Int, upper: Boolean): Int {
        var left = 0
        var right: Int = nums.size - 1
        var result: Int = -1
        while (left <= right) {
            val mid: Int = left + (right - left) / 2
            if (nums[mid] == target) {
                result = mid
            }
            if (nums[mid] < target || (nums[mid] == target && upper)) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return result
    }
}