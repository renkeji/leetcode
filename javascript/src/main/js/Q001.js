/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 * @param nums
 * @param target
 * @returns []
 */

var twoSum = function(nums, target) {
    var numbers = nums.map(function (value, index) {
        return {
            value: value,
            index: index
        };
    }).sort(function (o1, o2) {
        return o1.value - o2.value;
    });
    var i = 0, j = numbers.length - 1;
    while (i < j) {
        var sum = numbers[i].value + numbers[j].value;
        if (sum === target) {
            return numbers[i].index < numbers[j].index ?
                [numbers[i].index + 1, numbers[j].index + 1] : [numbers[j].index + 1, numbers[i].index + 1];
        } else if (sum < target) {
            i++;
        } else {
            j--;
        }
    }
    return [];
};