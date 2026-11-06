class Solution {
    public int findJudge(int n, int[][] trust) {
        
        int score[] = new int[n+1];

        for(int[] relation : trust){
            int a = relation[0];
            int b = relation[1];

            score[a]--;
            score[b]++;
        }

        for(int i = 0;i<=n;i++){
            if(score[i] == n-1){
                return i;
            }
        }

        return -1;



    }
}