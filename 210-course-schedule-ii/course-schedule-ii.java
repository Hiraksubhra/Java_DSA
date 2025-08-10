class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for(int[] prerequisite : prerequisites){
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            inDegree[course]++;
            graph.get(prerequisiteCourse).add(course);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        int count = 0;
        int[] order = new int[numCourses];

        while(!queue.isEmpty()){
            int currentCourse = queue.poll();
            order[count++] = currentCourse;
            for (int neighbor : graph.get(currentCourse)) {
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0){
                    queue.add(neighbor);
                }
            }
        }
        if(count == numCourses) return order;
        else return new int[0];
    }
}