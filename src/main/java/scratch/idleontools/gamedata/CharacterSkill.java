package scratch.idleontools.gamedata;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** Enumeration of all character skills. */
@Generated(
    value = "Generated with FreeMarker (version 2.3.31) using template character-skill.ftl.",
    date = "Jul 10, 2021, 3:31:01 PM"
)
public enum CharacterSkill {

    MINING("Mining", 0),
    SMITHING("Smithing", 1),
    CHOPPING("Chopping", 2),
    FISHING("Fishing", 3),
    ALCHEMY("Alchemy", 4),
    CATCHING("Catching", 5),
    TRAPPING("Trapping", 6),
    CONSTRUCTION("Construction", 7),
    WORSHIP("Worship", 8),
    _10("10", 9),
    _11("11", 10),
    _12("12", 11),
    _13("13", 12),
    _14("14", 13),
    _15("15", 14),
    _16("16", 15),
    _17("17", 16),
    _18("18", 17),
    _19("19", 18),
    _20("20", 19),
    _21("21", 20),
    _22("22", 21),
    _23("23", 22),
    _24("24", 23);

    private static final Map<String, CharacterSkill> skillNameToCharacterSkillMap = new HashMap<>();
    private static final Map<Integer, CharacterSkill> skillIdToCharacterSkillMap = new HashMap<>();

    static {
        Arrays.stream(CharacterSkill.values()).forEach(characterSkill -> skillNameToCharacterSkillMap.put(characterSkill.skillName, characterSkill));
        Arrays.stream(CharacterSkill.values()).forEach(characterSkill -> skillIdToCharacterSkillMap.put(characterSkill.skillId, characterSkill));
    }

    public final String skillName;
    public final int skillId;

    CharacterSkill(String skillName,int skillId) {
        this.skillName = skillName;
        this.skillId = skillId;
    }

    public static CharacterSkill getByName(String skillName) {
        return Objects.requireNonNull(skillNameToCharacterSkillMap.get(skillName));
    }
    public static CharacterSkill getById(int skillId) {
        return Objects.requireNonNull(skillIdToCharacterSkillMap.get(skillId));
    }
}
