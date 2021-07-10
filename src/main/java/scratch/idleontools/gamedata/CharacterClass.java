package scratch.idleontools.gamedata;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** Enumeration of all character classes. */
@Generated(
    value = "Generated with FreeMarker (version 2.3.31) using template character-class.ftl.",
    date = "Jul 10, 2021, 3:31:01 PM"
)
public enum CharacterClass {

    BEGINNER(1, "BEGINNER"),
    JOURNEYMAN(2, "JOURNEYMAN"),
    MAESTRO(3, "MAESTRO"),
    VIRTUOSO(4, "VIRTUOSO"),
    INFINILYTE(5, "INFINILYTE"),
    WARRIOR(7, "MINING"),
    BARBARIAN(8, "FISHING"),
    SQUIRE(9, "TOWN3LEFT"),
    BLOOD_BERSERKER(10, "TOWN4LEFT"),
    DEATH_BRINGER(11, "TOWN6LEFT"),
    DIVINE_KNIGHT(12, "TOWN5LEFT"),
    ROYAL_GUARDIAN(13, "TOWN7LEFT"),
    ARCHER(19, "ARCHER"),
    BOWMAN(20, "BOWMAN"),
    HUNTER(21, "HUNTER"),
    SIEGE_BREAKER(22, "SIEGE_BREAKER"),
    MAYHEIM(23, "MAYHEIM"),
    WIND_WALKER(24, "WIND_WALKER"),
    BEAST_MASTER(25, "BEAST_MASTER"),
    MAGE(31, "MAGE"),
    WIZARD(32, "FILLER"),
    SHAMAN(33, "FILLER"),
    ELEMENTAL_SORCERER(34, "FILLER"),
    SPIRITUAL_MONK(35, "FILLER"),
    BUBONIC_CONJUROR(36, "FILLER"),
    ARCANE_CULTIST(37, "FILLER");

    private static final Map<Integer, CharacterClass> classIdToCharacterClassMap = new HashMap<>();

    static {
        Arrays.stream(CharacterClass.values()).forEach(characterClass -> classIdToCharacterClassMap.put(characterClass.classId, characterClass));
    }

    public final int classId;
    public final String classSpecializeSkill;

    CharacterClass(int classId, String classSpecializeSkill) {
        this.classId = classId;
        this.classSpecializeSkill = classSpecializeSkill;
    }

    public static CharacterClass getById(int classId) {
        return Objects.requireNonNull(classIdToCharacterClassMap.get(classId));
    }
}
