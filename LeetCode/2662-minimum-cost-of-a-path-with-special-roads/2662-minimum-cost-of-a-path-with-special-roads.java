class Solution {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int answer = Math.abs(target[0] - start[0]) + Math.abs(target[1] - start[1]);
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        Map<String, Integer> map = new HashMap<>();
        pq.offer(new Pos(start[0], start[1], 0));
        while(!pq.isEmpty()){
            Pos now = pq.poll();
            for(int[] road : specialRoads) {
                int cost = now.cost + Math.abs(road[0] - now.x) + Math.abs(road[1] - now.y) + road[4];
                String des = String.valueOf(road[2]) + " " + String.valueOf(road[3]);
                if(map.containsKey(des) && map.get(des) > cost) {
                    map.put(des, cost);
                    pq.offer(new Pos(road[2], road[3], cost));
                }
                else if(!map.containsKey(des)) {
                    map.put(des, cost);
                    pq.offer(new Pos(road[2], road[3], cost));
                }
            }
        }
        for(String key : map.keySet()) {
            int cost = map.get(key);
            String[] s = key.split(" ");
            cost += Math.abs(target[0] - Integer.parseInt(s[0])) + Math.abs(target[1] - Integer.parseInt(s[1]));
            answer = Math.min(cost, answer);
        }
        return answer;
    }
    class Pos implements Comparable<Pos> {
        int x;
        int y;
        int cost;

        public Pos(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pos p) {
            return Integer.compare(this.cost, p.cost);
        }
    }
}