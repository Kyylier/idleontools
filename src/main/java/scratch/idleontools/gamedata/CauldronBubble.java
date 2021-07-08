package scratch.idleontools.gamedata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Cauldron bubbles - includes both active and passive bubbles.
 *
 * Data generated using {@link _AlchemyData.CauldronBubbleHelper}.
 */
public enum CauldronBubble {

    ROID_RAGIN("ROID_RAGIN", "_0", false),
    WARRIORS_RULE("WARRIORS_RULE", "_1", false),
    HEARTY_DIGGY("HEARTY_DIGGY", "_2", false),
    WYOMING_BLOOD("WYOMING_BLOOD", "_3", true),
    REELY_SMART("REELY_SMART", "_4", false),
    BIG_MEATY_CLAWS("BIG_MEATY_CLAWS", "_5", false),
    SPLOOSH_SPLOOSH("SPLOOSH_SPLOOSH", "_6", true),
    STRONK_TOOLS("STRONK_TOOLS", "_7", false),
    FMJ("FMJ", "_8", false),
    BAPPITY_BOOPITY("BAPPITY_BOOPITY", "_9", false),
    BRITTLEY_SPEARS("BRITTLEY_SPEARS", "_10", false),
    CALL_ME_BOB("CALL_ME_BOB", "_11", true),
    CARPENTER("CARPENTER", "_12", false),
    BUFF_BOI_TALENT("BUFF_BOI_TALENT", "_13", false),
    ORANGE_BARGAIN("ORANGE_BARGAIN", "_14", false),

    SWIFT_STEPPIN("SWIFT_STEPPIN", "a0", false),
    ARCHER_OR_BUST("ARCHER_OR_BUST", "a1", false),
    HAMMER_HAMMER("HAMMER_HAMMER", "a2", true),
    LIL_BIG_DAMAGE("LIL_BIG_DAMAGE", "a3", false),
    ANVILNOMICS("ANVILNOMICS", "a4", false),
    QUICK_SLAP("QUICK_SLAP", "a5", false),
    SANIC_TOOLS("SANIC_TOOLS", "a6", false),
    BUG_("BUG]", "a7", true),
    SHAQURACY("SHAQURACY", "a8", false),
    CHEAP_SHOT("CHEAP_SHOT", "a9", false),
    BOW_JACK("BOW_JACK", "a10", false),
    CALL_ME_ASH("CALL_ME_ASH", "a11", true),
    CUZ_I_CATCH_EM_ALL("CUZ_I_CATCH_EM_ALL", "a12", false),
    FAST_BOI_TALENT("FAST_BOI_TALENT", "a13", false),
    GREEN_BARGAIN("GREEN_BARGAIN", "a14", false),

    STABLE_JENIUS("STABLE_JENIUS", "b0", false),
    MAGE_IS_BEST("MAGE_IS_BEST", "b1", false),
    HOCUS_CHOPPUS("HOCUS_CHOPPUS", "b2", false),
    MOLTO_LOGGO("MOLTO_LOGGO", "b3", true),
    NOODUBBLE("NOODUBBLE", "b4", false),
    NAME_I_GUESS("NAME_I_GUESS", "b5", false),
    LE_BRAIN_TOOLS("LE_BRAIN_TOOLS", "b6", false),
    COOKIN_ROADKILL("COOKIN_ROADKILL", "b7", true),
    BREWSTACHIO("BREWSTACHIO", "b8", false),
    ALL_FOR_KILL("ALL_FOR_KILL", "b9", false),
    MATTY_STAFFORD("MATTY_STAFFORD", "b10", false),
    CALL_ME_POPE("CALL_ME_POPE", "b11", true),
    GOSPEL_LEADER("GOSPEL_LEADER", "b12", false),
    SMART_BOI_TALENT("SMART_BOI_TALENT", "b13", false),
    PURPLE_BARGAIN("PURPLE_BARGAIN", "b14", false),

    LOTTO_SKILLS("LOTTO_SKILLS", "c0", false),
    DROPPIN_LOADS("DROPPIN_LOADS", "c1", false),
    STARTUE_EXP("STARTUE_EXP", "c2", false),
    LEVEL_UP_GIFT("LEVEL_UP_GIFT", "c3", true),
    PROWESESSARY("PROWESESSARY", "c4", false),
    STAMP_TRAMP("STAMP_TRAMP", "c5", false),
    UNDEVELOPED_COSTS("UNDEVELOPED_COSTS", "c6", false),
    DA_DAILY_DRIP("DA_DAILY_DRIP", "c7", false),
    GRIND_TIME("GRIND_TIME", "c8", true),
    LAAARRRRYYYY("LAAARRRRYYYY", "c9", false),
    COGS_FOR_HANDS("COGS_FOR_HANDS", "c10", false),
    SAMPLE_IT("SAMPLE_IT", "c11", false),
    BIG_GAME_HUNTER("BIG_GAME_HUNTER", "c12", true),
    IGNORE_OVERDUES("IGNORE_OVERDUES", "c13", false),
    YELLOW_BARGAIN("YELLOW_BARGAIN", "c14", false);

    private static final Map<String, CauldronBubble> bubbleIdToCauldronBubbleMap = new HashMap<>();

    static {
        Arrays.stream(CauldronBubble.values()).forEach(cauldronBubble -> bubbleIdToCauldronBubbleMap.put(cauldronBubble.bubbleId, cauldronBubble));
    }

    public final String name;

    /**
     * The ID of this bubble.
     *
     * Contains 2 components:
     * First character is which cauldron it belongs to: {_, a, b, c}.
     * Then the index of the bubble in that cauldron(starting at 0).
     */
    public final String bubbleId;

    /** Whether this is an active bubble (i.e. must be equipped for its effect). */
    public final boolean isActive;

    CauldronBubble(String name, String bubbleId, boolean isActive) {
        this.name = name;
        this.bubbleId = bubbleId;
        this.isActive = isActive;
    }

    public Cauldron getCauldron() {
        return Cauldron.getByIdPrefix(bubbleId.substring(0, 1));
    }

    public static CauldronBubble getById(String bubbleId) {
        return Objects.requireNonNull(bubbleIdToCauldronBubbleMap.get(bubbleId));
    }
}
