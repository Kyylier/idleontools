package scratch.idleontools.gamedatadeprecated;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum CauldronVial {

    COPPER_CORONA("COPPER_CORONA", 0),
    SIPPY_SPLINTERS("SIPPY_SPLINTERS", 1),
    MUSHROOM_SOUP("MUSHROOM_SOUP", 2),
    SPOOL_SPRITE("SPOOL_SPRITE", 3),
    BARIUM_MIXTURE("BARIUM_MIXTURE", 4),
    DIETER_DRINK("DIETER_DRINK", 5),
    SKINNY_0_CAL("SKINNY_0_CAL", 6),
    THUMB_POW("THUMB_POW", 7),
    JUNGLE_JUICE("JUNGLE_JUICE", 8),
    BARLEY_BREW("BARLEY_BREW", 9),
    ANEARFUL("ANEARFUL", 10),
    TEA_WITH_PEA("TEA_WITH_PEA", 11),
    GOLD_GUZZLE("GOLD_GUZZLE", 12),
    RAMIFICOCTION("RAMIFICOCTION", 13),
    SEAWATER("SEAWATER", 14),
    TAIL_TIME("TAIL_TIME", 15),
    FLY_IN_MY_DRINK("FLY_IN_MY_DRINK", 16),
    MIMICRAUGHT("MIMICRAUGHT", 17),
    BLUE_FLAV("BLUE_FLAV", 18),
    SLUG_SLURP("SLUG_SLURP", 19),
    PICKLE_JAR("PICKLE_JAR", 20),
    FUR_REFRESHER("FUR_REFRESHER", 21),
    SIPPY_SOUL("SIPPY_SOUL", 22),
    CRAB_JUICE("CRAB_JUICE", 23),
    VOID_VIAL("VOID_VIAL", 24),
    RED_MALT("RED_MALT", 25),
    EW_GROSS_GROSS("EW_GROSS_GROSS", 26),
    THE_SPANISH_SAHARA("THE_SPANISH_SAHARA", 27),
    POISON_TINCTURE("POISON_TINCTURE", 28),
    ETRUSCAN_LAGER("ETRUSCAN_LAGER", 29),
    CHONKER_CHUG("CHONKER_CHUG", 30),
    BUBONIC_BURP("BUBONIC_BURP", 31),
    VISIBLE_INK("VISIBLE_INK", 32),
    ORANGE_MALT("ORANGE_MALT", 33),
    SNOW_SLURRY("SNOW_SLURRY", 34),
    SLOWERGY_DRINK("SLOWERGY_DRINK", 35),
    SIPPY_CUP("SIPPY_CUP", 36),
    BUNNY_BREW("BUNNY_BREW", 37),
    _40_40_PURITY("40-40_PURITY", 38),
    SPOOK_PINT("SPOOK_PINT", 39),
    GOOSEY_GLUG("GOOSEY_GLUG", 40),

    // There's hints of this vial in the data, but it's not fully implemented yet.
    __INVALID_FILLER_VIAL("", 41);

    private static final Map<Integer, CauldronVial> vialIdxToCauldronVialMap = new HashMap<>();

    static {
        Arrays.stream(CauldronVial.values()).forEach(cauldronVial -> vialIdxToCauldronVialMap.put(cauldronVial.vialIdx, cauldronVial));
    }

    public final String name;
    public final int vialIdx;

    CauldronVial(String name, int vialIdx) {
        this.name = name;
        this.vialIdx = vialIdx;
    }

    public static CauldronVial getByIdx(Integer vialIdx) {
        return Objects.requireNonNull(vialIdxToCauldronVialMap.get(vialIdx));
    }
}
