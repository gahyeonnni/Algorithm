class Solution {
    fun solution(arr1: IntArray, arr2: IntArray): Int {
        var answer: Int = 0
        if (arr1.size > arr2.size) answer = 1
        else if (arr2.size > arr1.size) answer = -1 
        else {
            var asum = 0
            for (i in 0 until arr1.size step 1) {
                asum += arr1[i]
            }
            var arr2sum = 0 
            for (i in arr2)
                arr2sum += i
            if (asum > arr2sum) {
                answer = 1
            }
            else if (arr2sum > asum) {
                answer = -1
            }
            else
                answer = 0
        }
        return answer
    }
}