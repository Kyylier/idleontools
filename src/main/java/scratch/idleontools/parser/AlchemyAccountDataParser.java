package scratch.idleontools.parser;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import scratch.idleontools.gamedata.Cauldron;
import scratch.idleontools.gamedata.CauldronBubble;
import scratch.idleontools.gamedata.CauldronUpgrade;
import scratch.idleontools.gamedata.CauldronVial;
import scratch.idleontools.model.DataUtil;
import scratch.idleontools.parser.interfaces.AccountDataParser;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public final class AlchemyAccountDataParser extends AccountDataParser {

    public static final String TAG = AlchemyAccountDataParser.class.getName();
    public static final String KEY = AlchemyAccountDataParser.class.getName();
    public static final String FIELD_NAME_CAULDRON_INFO = "CauldronInfo";
    public static final String FIELD_NAME_CAULDRON_UPGRADE_LEVELS = "CauldUpgLVs";
    public static final String FIELD_NAME_CAULDRON_BUBBLES = "CauldronBubbles";
    public static final String FIELD_NAME_CAULDRON_TALENT_POINTS = "CYTalentPoints";
    public static final AlchemyAccountDataParser INSTANCE = new AlchemyAccountDataParser();

    private AlchemyAccountDataParser() {}

    @Override
    public ImmutableSet<String> getHandledFields() {
        return ImmutableSet.of(
                FIELD_NAME_CAULDRON_INFO,
                FIELD_NAME_CAULDRON_UPGRADE_LEVELS,
                FIELD_NAME_CAULDRON_BUBBLES,
                FIELD_NAME_CAULDRON_TALENT_POINTS);
    }

    @Override
    public void parseInternal(IdleonParsingContext context) {
        JsonObject rootDocument = context.getRootDocument();
        JsonObject mainFields = DataUtil.getDocumentMainFields(rootDocument);

        parseCauldronInfo(context, mainFields);
        parseCauldronUpgradeLevels(context, mainFields);
        parseActiveBubbleInfo(context, mainFields);
        parseCauldronTalentPointsInfo(context, mainFields);
    }

    /**
     * Loads:<br/>
     * 1. Cauldron Bubble levels<br/>
     * 2. Cauldron Vial levels<br/>
     * 3. Cauldron EXP<br/>
     */
    private static void parseCauldronInfo(IdleonParsingContext context, JsonObject mainFields) {
        JsonArray cauldronInfoArr = DataUtil.getFieldAsArray(mainFields, FIELD_NAME_CAULDRON_INFO);

        HashMap<CauldronBubble, Integer> cauldronBubbleLevelsMap = new HashMap<>();
        HashMap<CauldronVial, Integer> cauldronVialLevelsMap = new HashMap<>();
        HashMap<Cauldron, Double> cauldronExpMap = new HashMap<>();

        // 0 = Power Cauldron Bubble Levels
        DataUtil.flattenMapValue(cauldronInfoArr.get(0).getAsJsonObject()).entrySet().forEach(
                entry -> cauldronBubbleLevelsMap.put(
                        CauldronBubble.getById(Cauldron.POWER.idPrefix + entry.getKey()),
                        Integer.parseInt(entry.getValue().getAsJsonObject().get("integerValue").getAsString())));

        // 1 = Quicc Cauldron Bubble Levels
        DataUtil.flattenMapValue(cauldronInfoArr.get(1).getAsJsonObject()).entrySet().forEach(
                entry -> cauldronBubbleLevelsMap.put(
                        CauldronBubble.getById(Cauldron.QUICC.idPrefix + entry.getKey()),
                        Integer.parseInt(entry.getValue().getAsJsonObject().get("integerValue").getAsString())));

        // 2 = High IQ Cauldron Bubble Levels
        DataUtil.flattenMapValue(cauldronInfoArr.get(2).getAsJsonObject()).entrySet().forEach(
                entry -> cauldronBubbleLevelsMap.put(
                        CauldronBubble.getById(Cauldron.HIGH_IQ.idPrefix + entry.getKey()),
                        Integer.parseInt(entry.getValue().getAsJsonObject().get("integerValue").getAsString())));

        // 3 = Kazam Cauldron Bubbles Levels
        DataUtil.flattenMapValue(cauldronInfoArr.get(3).getAsJsonObject()).entrySet().forEach(
                entry -> cauldronBubbleLevelsMap.put(
                        CauldronBubble.getById(Cauldron.KAZAM.idPrefix + entry.getKey()),
                        Integer.parseInt(entry.getValue().getAsJsonObject().get("integerValue").getAsString())));

        // 4 = Vial Levels
        DataUtil.flattenMapValue(cauldronInfoArr.get(4).getAsJsonObject()).entrySet().forEach(
                entry -> cauldronVialLevelsMap.put(
                        CauldronVial.getByIdx(Integer.parseInt(entry.getKey())),
                        Integer.parseInt(entry.getValue().getAsJsonObject().get("integerValue").getAsString())));

        // 5 = Cauldron EXP
        DataUtil.flattenMapValue(cauldronInfoArr.get(5).getAsJsonObject()).entrySet().forEach(
                entry -> cauldronExpMap.put(
                        Cauldron.getByIdx(Integer.parseInt(entry.getKey())),
                        DataUtil.getNumericObjectAsDouble(entry.getValue().getAsJsonObject())));

        // 6 = Current liquid amounts
        // 7 = 0, 2, 0, 1, 0 ???
        // 8 = Empty ???
        // 9 = 0, 0, 0, 0 ???
        // 10 = Times this Liquid shop item was purchased (Resets daily, except for special ones)

        context.getResultBuilder().setCauldronInfo(cauldronExpMap, cauldronBubbleLevelsMap, cauldronVialLevelsMap);
    }

    /** Loads the upgrade levels {@link scratch.idleontools.gamedata.CauldronUpgrade} for each cauldron. */
    private static void parseCauldronUpgradeLevels(IdleonParsingContext context, JsonObject mainFields) {
        int[] cauldronUpgradeLevelsArr = DataUtil.parseIntegerArray(DataUtil.getFieldAsArray(mainFields, FIELD_NAME_CAULDRON_UPGRADE_LEVELS));
        int i = 0;
        HashMap<Cauldron, Map<CauldronUpgrade, Integer>> cauldronUpgradeLevelsMap = new HashMap<>();
        for (Cauldron cauldron : Cauldron.values()) {
            HashMap<CauldronUpgrade, Integer> singleCauldron = new HashMap<>();
            for (CauldronUpgrade cauldronUpgrade : CauldronUpgrade.values()) {
                singleCauldron.put(cauldronUpgrade, cauldronUpgradeLevelsArr[i]);
                i++;
            }
            cauldronUpgradeLevelsMap.put(cauldron, Collections.unmodifiableMap(singleCauldron));
        }

        context.getResultBuilder().setCauldronUpgradeLevelsMap(cauldronUpgradeLevelsMap);
    }

    /** Loads the equipped active bubbles for each character. */
    private static void parseActiveBubbleInfo(IdleonParsingContext context, JsonObject mainFields) {
        // Active bubble info is combined into one main field.
        JsonArray cauldronBubblesArr = JsonParser.parseString(DataUtil.getFieldAsString(mainFields, FIELD_NAME_CAULDRON_BUBBLES)).getAsJsonArray();
        IntStream.range(0, context.getNumCharacters()).forEach(
                characterIdx -> context.getResultBuilder().getCharacterBuilder(characterIdx).setEquippedCauldronBubbles(
                        maybeGetCauldronBubble(cauldronBubblesArr.get(characterIdx).getAsJsonArray().get(0)),
                        maybeGetCauldronBubble(cauldronBubblesArr.get(characterIdx).getAsJsonArray().get(1)),
                        maybeGetCauldronBubble(cauldronBubblesArr.get(characterIdx).getAsJsonArray().get(2))));
    }

    private void parseCauldronTalentPointsInfo(IdleonParsingContext context, JsonObject mainFields) {
        int[] talentPointsFromCauldronLiquidShop = DataUtil.parseIntegerArray(DataUtil.getFieldAsArray(mainFields, FIELD_NAME_CAULDRON_TALENT_POINTS));
        context.getResultBuilder().setTalentPointsFromCauldronLiquidShop(talentPointsFromCauldronLiquidShop);
    }

    @Nullable
    private static CauldronBubble maybeGetCauldronBubble(JsonElement bubbleIdStr_or_zero) {
        try {
            if (bubbleIdStr_or_zero.getAsInt() == 0) {
                return null;
            } else {
                throw new RuntimeException("Unrecognized element in CauldronBubbles: %s".formatted(bubbleIdStr_or_zero));
            }
        } catch (NumberFormatException ignored) {}
        return CauldronBubble.getById(bubbleIdStr_or_zero.getAsString());
    }
}
