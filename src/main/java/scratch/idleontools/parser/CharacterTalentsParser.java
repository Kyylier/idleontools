package scratch.idleontools.parser;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import scratch.idleontools.gamedatadeprecated.CharacterTalent;
import scratch.idleontools.model.DataUtil;
import scratch.idleontools.parser.interfaces.CharacterDataParser;

import java.util.HashMap;

public final class CharacterTalentsParser extends CharacterDataParser {

    public static final String TAG = CharacterTalentsParser.class.getName();
    public static final String KEY = CharacterTalentsParser.class.getName();
    public static final String FIELD_NAME_LEVEL = "SL";
    public static final String FIELD_NAME_MAX_LEVEL = "SM";
    public static final CharacterTalentsParser INSTANCE = new CharacterTalentsParser();

    private CharacterTalentsParser() {}

    @Override
    public ImmutableSet<String> getHandledFields(int characterIdx) {
        return ImmutableSet.of(
                FIELD_NAME_LEVEL + "_" + characterIdx,
                FIELD_NAME_MAX_LEVEL + "_" + characterIdx);
    }

    @Override
    protected void parseInternal(IdleonParsingContext context, int characterIdx) {
        JsonObject rootDocument = context.getRootDocument();
        JsonObject mainFields = DataUtil.getDocumentMainFields(rootDocument);

        JsonObject talentLevels = JsonParser.parseString(DataUtil.getFieldAsString(mainFields, FIELD_NAME_LEVEL + "_" + characterIdx)).getAsJsonObject();
        JsonObject talentMaxLevels = JsonParser.parseString(DataUtil.getFieldAsString(mainFields, FIELD_NAME_MAX_LEVEL + "_" + characterIdx)).getAsJsonObject();

        HashMap<CharacterTalent, Integer> talentLevelMap = new HashMap<>();
        HashMap<CharacterTalent, Integer> talentMaxLevelMap = new HashMap<>();

        talentLevels.entrySet().forEach(
                entry -> talentLevelMap.put(
                        CharacterTalent.getByTalentIdx(Integer.parseInt(entry.getKey())),
                        entry.getValue().getAsInt()));
        talentMaxLevels.entrySet().forEach(
                entry -> talentMaxLevelMap.put(
                        CharacterTalent.getByTalentIdx(Integer.parseInt(entry.getKey())),
                        entry.getValue().getAsInt()));
        context.getResultBuilder().getCharacterBuilder(characterIdx)
                .setTalentLevelMaps(talentLevelMap, talentMaxLevelMap);
    }
}
