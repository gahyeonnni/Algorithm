import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] oper) {
        int[] answer = new int [2];
        LinkedList <Integer> list = new LinkedList<>();
        for (int i = 0; i < oper.length; i++)
        {
            String x = oper[i];
            Collections.sort(list);
            if (x.charAt(0) == 'D') //삭제하는 연산이 주어진 경우
            {
                if (list.size() == 0) //빈큐에 데이터를 삭제하라는 연산이 주어진 경우
                    continue;
                else //값이 있는 경우
                {
                    if (x.charAt(2) == '1')
                    {
                        list.remove(list.size() - 1);
                    }
                    else
                        list.remove(0);
                }
            }
            else //값 입력하는 연산인경우
            {
                String num = x.substring(2);
                list.add(Integer.parseInt(num));
            }
        }
        if (list.size() == 0)
            return answer;
        else 
        {
            Collections.sort(list);
            answer[0] = list.get(list.size() - 1);
            answer[1] = list.get(0);
        }
        return answer;
    }
}