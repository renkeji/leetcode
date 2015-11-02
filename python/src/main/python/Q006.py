from src.main.python.Solution import Solution

# The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
# (you may want to display this pattern in a fixed font for better legibility)
#
# P   A   H   N
# A P L S I I G
# Y   I   R
# And then read line by line: "PAHNAPLSIIGYIR"
# Write the code that will take a string and make this conversion given a number of rows:
#
# string convert(string text, int nRows);
# convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".


class Q006(Solution):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        rows = [""] * numRows
        index, step = -1, 1
        for i in range(len(s)):
            index += step
            if index == numRows:
                index, step = numRows-2, -1
            elif index == -1:
                index = step = 1
            rows[index] += s[i]
        return "".join(rows)
