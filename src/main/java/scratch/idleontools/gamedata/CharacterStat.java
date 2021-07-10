package scratch.idleontools.gamedata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// Not worth code-genning.
public enum CharacterStat {

    STR(0),
    AGI(1),
    WIS(2),
    LUK(3),
    LVL(4);

    /** Index of this stat in PVStatList_{*}. Starts at 0.  */
    public final int statListIdx;

    CharacterStat(int statListIdx) {
        this.statListIdx = statListIdx;
    }

    private static final Map<Integer, CharacterStat> statListIdxToCharacterStatMap = new HashMap<>();

    static {
        Arrays.stream(CharacterStat.values()).forEach(characterStat -> statListIdxToCharacterStatMap.put(characterStat.statListIdx, characterStat));
    }

    public static CharacterStat getByStatListIdx(int statListIdx) {
        return Objects.requireNonNull(statListIdxToCharacterStatMap.get(statListIdx));
    }
}
