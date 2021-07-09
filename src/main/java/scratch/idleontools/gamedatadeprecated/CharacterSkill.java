package scratch.idleontools.gamedatadeprecated;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum CharacterSkill {
    /*
    "Mining Smithing Chopping Fishing Alchemy Catching Trapping Construction Worship 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24".split(" ")
     */

    MINING(1),
    SMITHING(2),
    CHOPPING(3),
    FISHING(4),
    ALCHEMY(5),
    CATCHING(6),
    TRAPPING(7),
    CONSTRUCTION(8),
    WORSHIP(9);

    private static final Map<Integer, CharacterSkill> expIdxToCharacterSkillMap = new HashMap<>();

    static {
        Arrays.stream(CharacterSkill.values()).forEach(characterSkill -> expIdxToCharacterSkillMap.put(characterSkill.expIdx, characterSkill));
    }

    /** The index of the skill in the Exp0_{charNum} array. Starts at 1 because Class Exp is at 0. */
    public final int expIdx;

    CharacterSkill(int expIdx) {
        this.expIdx = expIdx;
    }

    public static CharacterSkill getByExpIdx(int expIdx) {
        return Objects.requireNonNull(expIdxToCharacterSkillMap.get(expIdx));
    }
}
