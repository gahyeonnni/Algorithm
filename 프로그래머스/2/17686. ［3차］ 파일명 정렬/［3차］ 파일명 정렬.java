import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator <String>() {
            @Override
            public int compare(String s1, String s2){
                String head1 = s1.split("[0-9]")[0];
                String head2 = s2.split("[0-9]")[0];
                
                int x = head1.toUpperCase().compareTo(head2.toUpperCase());
                
                if (x == 0){
                    s1 = s1.substring(head1.length());
                    s2 = s2.substring(head2.length());
                    String number1 = "";
                    for (char c : s1.toCharArray()){
                        if (Character.isDigit(c))
                            number1 += c;
                        else
                            break;
                    }
                    String number2 = "";
                    for (char c : s2.toCharArray()){
                        if (Character.isDigit(c))
                            number2 += c;
                        else
                            break;
                    }
                    return Integer.parseInt(number1) - Integer.parseInt(number2);
                }
                else
                    return x;
            }
        });
        return files;
    }
}