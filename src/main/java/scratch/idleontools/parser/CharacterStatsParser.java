package scratch.idleontools.parser;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;
import scratch.idleontools.gamedatadeprecated.CharacterStat;
import scratch.idleontools.model.DataUtil;
import scratch.idleontools.parser.interfaces.CharacterDataParser;

import java.util.Arrays;
import java.util.HashMap;

public final class CharacterStatsParser extends CharacterDataParser {

    public static final String TAG = CharacterStatsParser.class.getName();
    public static final String KEY = CharacterStatsParser.class.getName();
    public static final String FIELD_NAME = "PVStatList";
    public static final CharacterStatsParser INSTANCE = new CharacterStatsParser();

    private CharacterStatsParser() {}

    @Override
    public ImmutableSet<String> getHandledFields(int characterIdx) {
        return ImmutableSet.of(FIELD_NAME + "_" + characterIdx);
    }

    @Override
    protected void parseInternal(IdleonParsingContext context, int characterIdx) {
        JsonObject rootDocument = context.getRootDocument();
        JsonObject mainFields = DataUtil.getDocumentMainFields(rootDocument);

        int[] statArr = DataUtil.parseIntegerArray(DataUtil.getFieldAsArray(mainFields, FIELD_NAME + "_" + characterIdx));

        HashMap<CharacterStat, Integer> statMap = new HashMap<>();
        Arrays.stream(CharacterStat.values()).forEach(characterStat ->
            statMap.put(characterStat, statArr[characterStat.statListIdx])
        );
        context.getResultBuilder().getCharacterBuilder(characterIdx)
                .setStatMap(statMap);
    }
}
