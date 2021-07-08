package scratch.idleontools.gamedata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum CauldronUpgrade {

    SPEED(0),
    LUCK(1),
    COST(2),
    EXTRA(3);

    public final int cauldronUpgradeIdx;

    private static final Map<Integer, CauldronUpgrade> cauldronIdxToCauldronMap = new HashMap<>();

    static {
        Arrays.stream(CauldronUpgrade.values()).forEach(cauldronUpgrade -> cauldronIdxToCauldronMap.put(cauldronUpgrade.cauldronUpgradeIdx, cauldronUpgrade));
    }

    CauldronUpgrade(int cauldronUpgradeIdx) {
        this.cauldronUpgradeIdx = cauldronUpgradeIdx;
    }

    public static CauldronUpgrade getByIdx(Integer cauldronIdx) {
        return Objects.requireNonNull(cauldronIdxToCauldronMap.get(cauldronIdx));
    }
}
