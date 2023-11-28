class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int lux = wallpaper[0].length(), luy = wallpaper.length, rdx = 0, rdy = 0;
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    if(j < lux)
                        lux = j;
                    if(i < luy)
                        luy = i;
                    if(j > rdx)
                        rdx = j;
                    if(i > rdy)
                        rdy = i; 
                }
            }
        }
        answer[0] = luy; answer[1] = lux; answer[2] = rdy+1; answer[3] = rdx+1;
        return answer;
    }
}