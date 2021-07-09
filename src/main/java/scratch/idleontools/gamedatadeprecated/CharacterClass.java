package scratch.idleontools.gamedatadeprecated;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum CharacterClass {
    /*
    ["0", "BEGINNER", "JOURNEYMAN", "MAESTRO", "VIRTUOSO", "INFINILYTE", "RAGE_BASICS", "WARRIOR", "BARBARIAN", "SQUIRE",
    "BLOOD_BERSERKER", "DEATH_BRINGER", "DIVINE_KNIGHT", "ROYAL_GUARDIAN", "FILLER", "FILLER", "FILLER", "FILLER", "CALM_BASICS", "ARCHER",
    "BOWMAN", "HUNTER", "SIEGE_BREAKER", "MAYHEIM", "WIND_WALKER", "BEAST_MASTER", "FILLER", "FILLER", "FILLER", "FILLER",
    "SAVVY_BASICS", "MAGE", "WIZARD", "SHAMAN", "ELEMENTAL_SORCERER", "SPIRITUAL_MONK", "BUBONIC_CONJUROR", "ARCANE_CULTIST", "FILLER", "FILLER",
    "FILLER", "FILLER", "MINING", "SMITHING", "CHOPPING", "FISHING", "ALCHEMY", "BUG_CATCHING", "TRAPPING", "CONSTRUCTION", "WORSHIP"]
     */

    BEGINNER(1),
    JOURNEYMAN(2),
    MAESTRO(3),
    VIRTUOSO(4),
    INFINILYTE(5),

    WARRIOR(7),
    BARBARIAN(8),
    SQUIRE(9),
    BLOOD_BERSERKER(10),
    DEATH_BRINGER(11),
    DIVINE_KNIGHT(12),
    ROYAL_GUARDIAN(13),

    ARCHER(19),
    BOWMAN(20),
    HUNTER(21),
    SIEGE_BREAKER(22),
    MAYHEIM(23),
    WIND_WALKER(24),
    BEAST_MASTER(25),

    MAGE(31),
    WIZARD(32),
    SHAMAN(33),
    ELEMENTAL_SORCERER(34),
    SPIRITUAL_MONK(35),
    BUBONIC_CONJUROR(36),
    ARCANE_CULTIST(37);

    private static final Map<Integer, CharacterClass> idToCharacterClassMap = new HashMap<>();

    static {
        Arrays.stream(CharacterClass.values()).forEach(characterClass -> idToCharacterClassMap.put(characterClass.classId, characterClass));
    }

    public final int classId;

    CharacterClass(int classId) {
        this.classId = classId;
    }

    public static CharacterClass getById(int classId) {
        return Objects.requireNonNull(idToCharacterClassMap.get(classId));
    }
}
