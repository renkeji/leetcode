from src.main.python.Solution import Solution

# Given an absolute path for a file (Unix-style), simplify it.
#
# For example,
#   path = "/home/", => "/home"
#   path = "/a/./b/../../c/", => "/c"
#
# Corner Cases:
#   Did you consider the case where path = "/../"?
#   In this case, you should return "/".
#   Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
#   In this case, you should ignore redundant slashes and return "/home/foo".


class Q071(Solution):
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        ans = ""
        if path:
            stack = []
            tokens = path.split("/")
            for t in tokens:
                if not t:
                    continue
                elif t == "..":
                    if not stack:
                        continue
                    else:
                        stack.pop()
                elif t == ".":
                    continue
                else:
                    stack.append(t)
            ans = "/" + "/".join(stack)
        return ans
