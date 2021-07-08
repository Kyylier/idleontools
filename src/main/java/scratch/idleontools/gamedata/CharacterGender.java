package scratch.idleontools.gamedata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum CharacterGender {
    /*
    ["Male", "Female", "Other", "Neither", "Stick-Figure"]
     */

    MALE(1),
    FEMALE(2),
    OTHER(3),
    NEITHER(4),
    STICK_FIGURE(5);

    private static final Map<Integer, CharacterGender> idToCharacterGenderMap = new HashMap<>();

    static {
        Arrays.stream(CharacterGender.values()).forEach(characterGender -> idToCharacterGenderMap.put(characterGender.genderId, characterGender));
    }

    public final int genderId;

    CharacterGender(int genderId) {
        this.genderId = genderId;
    }

    public static CharacterGender getById(int genderId) {
        return Objects.requireNonNull(idToCharacterGenderMap.get(genderId));
    }
}
