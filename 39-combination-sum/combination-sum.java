class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }
        Arrays.sort(candidates);
        findCombinations(results, new ArrayList<>(), candidates, target, 0);
        return results;
    }
    private void findCombinations(List<List<Integer>> results,List<Integer> currentCombination,int[] candidates,int remainingTarget,int startIndex) {
        if(remainingTarget == 0){
            results.add(new ArrayList<>(currentCombination));
            return;
        }
        if(remainingTarget<0){
            return;
        }
        for(int i = startIndex; i < candidates.length; i++){
            int currentCandidate = candidates[i];
            if(currentCandidate> remainingTarget){
                break;
            }
            currentCombination.add(currentCandidate);
            findCombinations(results, currentCombination, candidates, remainingTarget -currentCandidate, i);
            currentCombination.remove(currentCombination.size()-1);//Backtrack
        }
    }
}