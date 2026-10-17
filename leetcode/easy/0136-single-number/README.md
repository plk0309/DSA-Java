# Single Number

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a  **non-empty**  array of integers `nums`, every element appears  *twice*  except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 

 **Example 1:** 

 **Input:**  nums = [2,2,1]

 **Output:**  1

 **Example 2:** 

 **Input:**  nums = [4,1,2,1,2]

 **Output:**  4

 **Example 3:** 

 **Input:**  nums = [1]

 **Output:**  1

 

 **Constraints:** 

- 1 <= nums.length <= 3 * 104
- -3  *104 <= nums[i] <= 3*  104
- Each element in the array appears twice except for one element which appears only once.

## Solution

**Language:** Java  
**Runtime:** 537 ms (beats 5.08%)  
**Memory:** 46.2 MB (beats 99.08%)  
**Submitted:** 2026-10-17T17:29:49.226Z  

```java
class Solution {
    public int singleNumber(int[] nums) {
        for(int i =0;i<nums.length;i++){
            int count=0;
            for(int j =0;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    count++;
                    
                }
               
            }
             if (count ==1){
            return nums[i];
        }
        }
        
        return -1;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/single-number/)