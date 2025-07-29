class Solution {
    private static final int[] dy = {0, -1, 1, 0};
    private static final int[] dx = {-1, 0, 0, 1};
    
    private boolean checkNeighbor(char[][] room, int y, int x, int pass) {
        for(int i = 0; i < 4; i++) {
            if(i == pass) {
                continue;
            }
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= 5 || nx < 0 || nx >= 5) {
                continue;
            }
            if(room[ny][nx] == 'P') {
                return true;
            }
        }
        return false;
    }
    
    private boolean isDistanced(char[][] room, int y, int x) {      
        for(int i = 0; i < 4 ; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= 5 || nx < 0 || nx >= 5) {
                continue;
            }
            switch(room[ny][nx]) {
                case 'P' :
                    return false;
                case 'O' :
                    if(checkNeighbor(room, ny ,nx, 3-i)) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
    
    private boolean isDistanced(char[][] room) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(room[i][j] != 'P') {
                    continue;
                }
                if(!isDistanced(room, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i = 0; i < places.length; i++) {
            char[][] room = new char[5][];
            for(int j = 0; j < 5; j++) {
                room[j] = places[i][j].toCharArray();
            }
            if(isDistanced(room)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }
}