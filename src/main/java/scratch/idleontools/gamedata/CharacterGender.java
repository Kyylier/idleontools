package scratch.idleontools.gamedata;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** Enumeration of all character genders. */
@Generated(
    value = "Generated with FreeMarker (version 2.3.31) using template character-gender.ftl.",
    date = "Jul 10, 2021, 3:31:01 PM"
)
public enum CharacterGender {

    MALE("Male", 0),
    FEMALE("Female", 1),
    OTHER("Other", 2),
    NEITHER("Neither", 3),
    STICK_FIGURE("Stick-Figure", 4);

    private static final Map<String, CharacterGender> genderNameToCharacterGenderMap = new HashMap<>();
    private static final Map<Integer, CharacterGender> genderIdToCharacterGenderMap = new HashMap<>();

    static {
        Arrays.stream(CharacterGender.values()).forEach(characterGender -> genderNameToCharacterGenderMap.put(characterGender.genderName, characterGender));
        Arrays.stream(CharacterGender.values()).forEach(characterGender -> genderIdToCharacterGenderMap.put(characterGender.genderId, characterGender));
    }

    public final String genderName;
    public final int genderId;

    CharacterGender(String genderName,int genderId) {
        this.genderName = genderName;
        this.genderId = genderId;
    }

    public static CharacterGender getByName(String genderName) {
        return Objects.requireNonNull(genderNameToCharacterGenderMap.get(genderName));
    }
    public static CharacterGender getById(int genderId) {
        return Objects.requireNonNull(genderIdToCharacterGenderMap.get(genderId));
    }
}
