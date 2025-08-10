class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> reversedGraph = new ArrayList<>();
        int[] inDegree= new int[graph.length]; 
        for(int i = 0; i < graph.length; i++) {
            reversedGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            for (int neighbour : graph[i]) {
                reversedGraph.get(neighbour).add(i);
                inDegree[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            safeNodes.add(node);
            for(int neighbor : reversedGraph.get(node)){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
}