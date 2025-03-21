import java.io.*;
import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        StringBuilder sb = new StringBuilder(pos);

        int start_h = Integer.parseInt(op_start.substring(0, 2));
        int start_m = Integer.parseInt(op_start.substring(3));
        int end_h = Integer.parseInt(op_end.substring(0, 2));
        int end_m = Integer.parseInt(op_end.substring(3));

        int pos_h = Integer.parseInt(pos.substring(0, 2));
        int pos_m = Integer.parseInt(pos.substring(3));
        
        if ((pos_h > start_h || (pos_h == start_h && pos_m >= start_m)) &&
            (pos_h < end_h || (pos_h == end_h && pos_m <= end_m))) {
            sb = new StringBuilder(op_end);
        }

        for (int i = 0; i < commands.length; i++) {
            String x = commands[i];
            String hour = sb.substring(0, 2);
            String min = sb.substring(3);

            if (x.equals("next")) {
                    int vh = Integer.parseInt(video_len.substring(0, 2));
                    int vm = Integer.parseInt(video_len.substring(3));
                    int sh = Integer.parseInt(hour);
                    int sm = Integer.parseInt(min);

                    int total_video = vh * 60 + vm;
                    int total_now = sh * 60 + sm;

                    if (total_video - total_now < 10) {
                        sb = new StringBuilder(video_len);
                    } else {
                        if (Integer.parseInt(min) + 10 >= 60) {
                            int m = Integer.parseInt(min) + 10 - 60;
                            int h = Integer.parseInt(hour) + 1;

                            String h_str = "";
                            String m_str = "";

                            if (h < 10) h_str = "0" + String.valueOf(h);
                            else h_str = String.valueOf(h);

                            if (m < 10) m_str = "0" + String.valueOf(m);
                            else m_str = String.valueOf(m);

                            String time = h_str + ":" + m_str;
                            sb = new StringBuilder(time);
                        } else {
                            int m = Integer.parseInt(min) + 10;
                            String m_str = "";
                            if (m < 10) m_str = "0" + String.valueOf(m);
                            else m_str = String.valueOf(m);

                            String time = sb.substring(0, 3) + m_str;
                            sb = new StringBuilder(time);
                        }
                    }
                }

            else if (x.equals("prev")) {
                if (hour.equals("00") && Integer.parseInt(min) < 10) {
                    sb.setCharAt(4, '0');
                } 
                else {
                    if (Integer.parseInt(hour) > 0 && Integer.parseInt(min) < 10) {
                        int b = 60 - (10 - Integer.parseInt(min));
                        int c = Integer.parseInt(hour) - 1;

                        String h_str = "";
                        String m_str = "";

                        if (c < 10) 
                            h_str = "0" + String.valueOf(c);
                        else 
                            h_str = String.valueOf(c);

                        if (b < 10) 
                            m_str = "0" + String.valueOf(b);
                        else 
                            m_str = String.valueOf(b);

                        String xQ = h_str + ":" + m_str;
                        sb = new StringBuilder(xQ);
                    } 
                    else {
                        int a = Integer.parseInt(min) - 10;
                        String a_str = "";
                        if (a < 10) 
                            a_str = "0" + String.valueOf(a);
                        else 
                            a_str = String.valueOf(a);

                        String xo = sb.substring(0, 3) + a_str;
                        sb = new StringBuilder(xo);
                    }
                }
            }

            int sb_h = Integer.parseInt(sb.substring(0, 2));
            int sb_m = Integer.parseInt(sb.substring(3));

            if ((sb_h > start_h || (sb_h == start_h && sb_m >= start_m)) &&
                (sb_h < end_h || (sb_h == end_h && sb_m <= end_m))) {
                sb = new StringBuilder(op_end);
            }
        }

        return sb.toString();
    }
}
