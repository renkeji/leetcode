/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * For example,
 *  Given nums = [0, 1, 3] return 2.
 *
 * Note:
 *  Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 *
 * @param nums
 * @returns {number}
 */

var missingNumber = function(nums) {
    var expectedSum = parseInt((nums.length + 1) * nums.length / 2);
    var actualSum = 0;
    nums.forEach(function (num) {
        actualSum += num;
    });
    return expectedSum - actualSum;
};
