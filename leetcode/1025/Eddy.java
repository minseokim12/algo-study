class Solution {
    public boolean divisorGame(int n) {
        boolean[] ALICE_CAN_WIN = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0 && !ALICE_CAN_WIN[i - j]) {
                    ALICE_CAN_WIN[i] = true;
                    break;
                }
            }
        }
        return ALICE_CAN_WIN[n];
    }
}
