import java.util.*;

class Solution {
    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();
        Map<Integer, String> values = new HashMap<>();
        Map<Integer, List<int[]>> positions = new HashMap<>();
        int[][] map = new int[51][51];
        int idx = 1;
        
        for(int i = 1; i < 51; i++) {
            for(int j = 1; j < 51; j++) {
                values.put(idx, "EMPTY");
                List<int[]> temp = new ArrayList<>();
                temp.add(new int[]{i, j});
                positions.put(idx, temp);
                map[i][j] = idx++;
            }
        }
        
        for(String command : commands) {
            String[] arr = command.split(" ");
            int r;
            int c;
            int v;
            switch(arr[0]) {
                case "UPDATE" :
                    if(arr.length == 4) {
                        r = Integer.parseInt(arr[1]);
                        c = Integer.parseInt(arr[2]);
                        values.put(map[r][c], arr[3]);
                    } else {
                        for(int i : values.keySet()) {
                            if(values.get(i).equals(arr[1])) {
                                values.put(i, arr[2]);
                            }
                        }
                    }
                    break;
                case "MERGE" :
                    r = Integer.parseInt(arr[1]);
                    c = Integer.parseInt(arr[2]);
                    int r2 = Integer.parseInt(arr[3]);
                    int c2 = Integer.parseInt(arr[4]);
                    if(map[r][c] == map[r2][c2]) {
                        continue;
                    }
                    String s1 = values.get(map[r][c]);
                    String s2 = values.get(map[r2][c2]);
                    int v2;
                    if(s1.equals("EMPTY") && !s2.equals("EMPTY")) {
                        v = map[r2][c2];
                        v2 = map[r][c];
                    } else {
                        v = map[r][c];
                        v2 = map[r2][c2];   
                    }
                    List<int[]> merge = positions.getOrDefault(v, new ArrayList<>());
                    List<int[]> list = positions.getOrDefault(v2, new ArrayList<>());
                    for(int[] p : list) {
                        map[p[0]][p[1]] = v;
                        merge.add(p);
                    }
                    values.remove(v2);
                    positions.remove(v2);
                    positions.put(v, merge);
                    break;
                case "UNMERGE" :
                    r = Integer.parseInt(arr[1]);
                    c = Integer.parseInt(arr[2]);
                    v = map[r][c];
                    for(int[] p : positions.getOrDefault(v, new ArrayList<>())) {
                        map[p[0]][p[1]] = idx;
                        List<int[]> temp = new ArrayList<>();
                        temp.add(p);
                        positions.put(idx, temp);
                        values.put(idx++, "EMPTY");
                    }
                    map[r][c] = v;
                    List<int[]> temp = new ArrayList<>();
                    temp.add(new int[] {r, c});
                    positions.put(v, temp);
                    break;
            
                case "PRINT":
                    r = Integer.parseInt(arr[1]);
                    c = Integer.parseInt(arr[2]);
                    answer.add(values.get(map[r][c]));
            }
        }
        //System.out.println(Arrays.deepToString(map));
        return answer.stream().toArray(String[]::new);
    }
}