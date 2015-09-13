var missingNumber = function(nums) {
    var expectedSum = parseInt((nums.length + 1) * nums.length / 2);
    var actualSum = 0;
    nums.forEach(function (num) {
        actualSum += num;
    });
    return expectedSum - actualSum;
};