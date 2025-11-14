import java.util.*;

class Solution {

    public String[] solution(String[] expressions) {
        List<Integer> bases = findCandidateBases(expressions);

        List<String> result = new ArrayList<>();

        for (String exp : expressions) {
            String[] parts = exp.split(" ");

            if (!parts[4].equals("X")) {
                continue;
            }

            String aStr = parts[0];
            String op = parts[1];
            String bStr = parts[2];

            Set<String> answers = new HashSet<>();

            for (int base : bases) {
                if (!isValidNumber(aStr, base) || !isValidNumber(bStr, base)) {
                    continue;
                }

                int a = toDecimal(aStr, base);
                int b = toDecimal(bStr, base);

                int val = op.equals("+") ? a + b : a - b;
                if (val < 0) 
                    continue;  

                String repr = fromDecimal(val, base);
                answers.add(repr);
            }

            String rhs;
            if (answers.size() == 1) {
                rhs = answers.iterator().next();
            } else {
                rhs = "?";
            }

            result.add(aStr + " " + op + " " + bStr + " = " + rhs);
        }

        return result.toArray(new String[0]);
    }

    private List<Integer> findCandidateBases(String[] expressions) {
        List<Integer> bases = new ArrayList<>();

        for (int base = 2; base <= 9; base++) {
            boolean ok = true;

            for (String exp : expressions) {
                String[] parts = exp.split(" ");
                String aStr = parts[0];
                String op = parts[1];
                String bStr = parts[2];
                String cStr = parts[4];

                if (!isValidNumber(aStr, base) || !isValidNumber(bStr, base)) {
                    ok = false;
                    break;
                }

                if (!cStr.equals("X")) {
                    if (!isValidNumber(cStr, base)) {
                        ok = false;
                        break;
                    }
                    
                    int a = toDecimal(aStr, base);
                    int b = toDecimal(bStr, base);
                    int c = toDecimal(cStr, base);

                    int res = op.equals("+") ? a + b : a - b;
                    if (res != c) {
                        ok = false;
                        break;
                    }
                }
            }

            if (ok) {
                bases.add(base);
            }
        }

        return bases;
    }

    private boolean isValidNumber(String s, int base) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') 
                return false;
            int d = ch - '0';
            if (d >= base) 
                return false;
        }
        return true;
    }

    private int toDecimal(String s, int base) {
        int v = 0;
        for (int i = 0; i < s.length(); i++) {
            int d = s.charAt(i) - '0';
            v = v * base + d;
        }
        return v;
    }

    private String fromDecimal(int value, int base) {
        if (value == 0) 
            return "0";
        StringBuilder sb = new StringBuilder();
        int v = value;
        while (v > 0) {
            int d = v % base;
            sb.append((char) ('0' + d));
            v /= base;
        }
        return sb.reverse().toString();
    }
}
