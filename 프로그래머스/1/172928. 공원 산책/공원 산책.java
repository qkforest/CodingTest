class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int x, y;
        boolean obs;
        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[0].length(); j++){
                if(park[i].charAt(j) == 'S'){
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }   
            }
        }
        for(int i = 0; i < routes.length; i++){
            obs = true;
            switch(routes[i].charAt(0)){
                case 'N':
                    y = answer[0] - (routes[i].charAt(2) - '0');
                    if(y >= 0 && y < park.length){
                        for(int j = 1; j <= routes[i].charAt(2) - '0' ; j++){
                            if(park[answer[0] - j].charAt(answer[1]) == 'X'){
                                obs = false;
                                break;
                            }    
                        }
                        if(obs)
                            answer[0] = y;
                    }
                    break;
                case 'S':
                    y = answer[0] + (routes[i].charAt(2) - '0');
                    if(y >= 0 && y < park.length){
                        for(int j = 1; j <= routes[i].charAt(2) - '0' ; j++){
                            if(park[answer[0] + j].charAt(answer[1]) == 'X'){
                                obs = false;
                                break;
                            }    
                        }
                        if(obs)
                            answer[0] = y;
                    }
                    break;
                case 'W':
                    x = answer[1] - (routes[i].charAt(2) - '0');
                    if(x >= 0 && x < park[0].length()){
                        for(int j = 1; j <= routes[i].charAt(2) - '0' ; j++){
                            if(park[answer[0]].charAt(answer[1] - j) == 'X'){
                                obs = false;
                                break;
                            }    
                        }
                        if(obs)
                            answer[1] = x;
                    }
                    break;
                case 'E':
                   x = answer[1] + (routes[i].charAt(2) - '0');
                    if(x >= 0 && x < park[0].length()){
                        for(int j = 1; j <= routes[i].charAt(2) - '0' ; j++){
                            if(park[answer[0]].charAt(answer[1] + j) == 'X'){
                                obs = false;
                                break;
                            }    
                        }
                        if(obs)
                            answer[1] = x;
                    }
                    break;
            }
        }
        return answer;
    }
}