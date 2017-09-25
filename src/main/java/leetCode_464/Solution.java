package leetCode_464;

import java.util.HashMap;

/**
 * @author dimdark
 * @date 2017-09-25
 * @time 9:51 PM
 */
public class Solution {

    private boolean calculateResult(int currentState, int maxNumber, int desiredTotal,
                                    HashMap<Integer, Boolean> statesMap) {
        if (statesMap.containsKey(currentState)) return statesMap.get(currentState);
        for (int i = 0; i < maxNumber; ++i) {
            if ((currentState & (1 << i)) == 0) { // not contain
                int nextState = currentState | 1 << i;
                if ((i + 1) >= desiredTotal || !calculateResult(nextState, maxNumber,
                        desiredTotal - (i + 1), statesMap)) {
                    statesMap.put(currentState, true);
                    return true;
                }
            }
        }
        statesMap.put(currentState, false);
        return false;
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) >> 1 < desiredTotal) return false;
        return calculateResult(0, maxChoosableInteger, desiredTotal, new HashMap<Integer, Boolean>());
    }

}
