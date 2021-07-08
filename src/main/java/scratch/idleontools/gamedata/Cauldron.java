package scratch.idleontools.gamedata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum Cauldron {

    POWER(0, "_"),
    QUICC(1, "a"),
    HIGH_IQ(2, "b"),
    KAZAM(3, "c");

    public final int cauldronIdx;
    public final String idPrefix;

    private static final Map<String, Cauldron> idPrefixToCauldronMap = new HashMap<>();
    private static final Map<Integer, Cauldron> cauldronIdxToCauldronMap = new HashMap<>();

    static {
        Arrays.stream(Cauldron.values()).forEach(cauldron -> idPrefixToCauldronMap.put(cauldron.idPrefix, cauldron));
        Arrays.stream(Cauldron.values()).forEach(cauldron -> cauldronIdxToCauldronMap.put(cauldron.cauldronIdx, cauldron));
    }

    Cauldron(int cauldronIdx, String idPrefix) {
        this.cauldronIdx = cauldronIdx;
        this.idPrefix = idPrefix;
    }

    public static Cauldron getByIdPrefix(String idPrefix) {
        return Objects.requireNonNull(idPrefixToCauldronMap.get(idPrefix));
    }

    public static Cauldron getByIdx(Integer cauldronIdx) {
        return Objects.requireNonNull(cauldronIdxToCauldronMap.get(cauldronIdx));
    }
}
