from src.main.python.Solution import Solution

# Given a string containing only digits, restore it by returning all possible valid IP address combinations.
#
# For example:
#   Given "25525511135",
#
#   return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)


class Q093(Solution):
    def restoreIpAddresses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        def is_valid(s):
            if len(s) > 1 and s[0] == '0':
                return False
            else:
                return 0 <= int(s) <= 255

        def restore_ip_addresses(s, path, num_dots, ans):
            if s:
                if num_dots == 0:
                    if is_valid(s):
                        ans.append(path + s)
                else:
                    i = 1
                    while i <= 3 and i <= len(s):
                        if is_valid(s[:i]):
                            restore_ip_addresses(s[i:], path+s[:i]+".", num_dots-1, ans)
                        i += 1

        ans = []
        if s and 4 <= len(s) <= 12:
            restore_ip_addresses(s, "", 3, ans)
        return ans
