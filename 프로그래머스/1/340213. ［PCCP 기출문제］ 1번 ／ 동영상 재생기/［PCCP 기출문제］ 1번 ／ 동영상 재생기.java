class Solution {
    public int p, len, start, end;
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] arr = pos.split(":");
        p = Integer.parseInt(arr[0]) * 60;
        p += Integer.parseInt(arr[1]);
        arr = video_len.split(":");
        len = Integer.parseInt(arr[0]) * 60;
        len += Integer.parseInt(arr[1]);
        arr = op_start.split(":");
        start = Integer.parseInt(arr[0]) * 60;
        start += Integer.parseInt(arr[1]);
        arr = op_end.split(":");
        end = Integer.parseInt(arr[0]) * 60;
        end += Integer.parseInt(arr[1]);
        for(String command : commands) {
            command(command);
        }
        check();
        StringBuilder answer = new StringBuilder();
        int m = p / 60;
        int s = p % 60;
        if(m < 10) {
            answer.append(0);
        }
        answer.append(m).append(":");
        if(s < 10) {
            answer.append(0);
        }
        answer.append(s);
        return answer.toString();
    }
    public void command(String command) {
        check();
        if(command.equals("prev")) {
            prev();
        } else {
            next();
        }
    }
    public void check() {
        if(p >= start && p < end) {
            p = end;
        }
    }
    public void prev() {
        p -= 10;
        if(p < 0) {
            p = 0;
        }
    }
    public void next() {
        p += 10;
        if(p > len) {
            p = len;
        }
    }
}