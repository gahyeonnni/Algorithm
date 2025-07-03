class Solution {
    fun solution(num_list: IntArray): IntArray {
        var odd = 0 
        var d = 0
        for (num in num_list) {
            if (num % 2 == 0) {
                d++
            }
            else 
                odd++
        }
        val answer = IntArray(2)
        answer[0] = d
        answer[1] = odd

        return answer
    }
}
