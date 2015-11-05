from src.main.python.Solution import Solution

# Given a digit string, return all possible letter combinations that the number could represent.
#
# A mapping of digit to letters (just like on the telephone buttons) is given below.
#
# Input:    Digit string "23"
# Output:   ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

# Note:
#   Although the above answer is in lexicographical order, your answer could be in any order you want.


class Q017(Solution):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        digit_to_letters = {'1': "",
                            '2': "abc",
                            '3': "def",
                            '4': "ghi",
                            '5': "jkl",
                            '6': "mno",
                            '7': "pqrs",
                            '8': "tuv",
                            '9': "wxyz",
                            '0': ""}

        if not digits:
            return []
        else:
            letters = digit_to_letters[digits[0]]
            subs = self.letterCombinations(digits[1:])
            ans = []
            for letter in letters:
                if subs:
                    for sub in subs:
                        ans.append(letter+sub)
                else:
                    ans.append(letter)
            return ans
