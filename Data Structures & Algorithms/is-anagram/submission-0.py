class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        s_store = {}
        for char in s:
            if char in s_store:
                s_store[char] += 1
            else:
                s_store[char] = 1

        t_store = {}
        for char in t:
            if char in t_store:
                t_store[char] += 1
            else:
                t_store[char] = 1

        return s_store == t_store
    
        