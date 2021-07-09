package scratch.idleontools.parser;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;
import scratch.idleontools.model.DataUtil;
import scratch.idleontools.parser.interfaces.CharacterDataParser;

public final class AfkTargetParser extends CharacterDataParser {

    public static final String TAG = AfkTargetParser.class.getName();
    public static final String KEY = AfkTargetParser.class.getName();
    public static final String FIELD_NAME = "AFKtarget";
    public static final AfkTargetParser INSTANCE = new AfkTargetParser();

    private AfkTargetParser() {}

    @Override
    public ImmutableSet<String> getHandledFields(int characterIdx) {
        return ImmutableSet.of(FIELD_NAME + "_" + characterIdx);
    }

    @Override
    protected void parseInternal(IdleonParsingContext context, int characterIdx) {
        JsonObject rootDocument = context.getRootDocument();
        JsonObject mainFields = DataUtil.getDocumentMainFields(rootDocument);

        String afkTargetStr = DataUtil.getFieldAsString(mainFields, FIELD_NAME + "_" + characterIdx);
        context.getResultBuilder().getCharacterBuilder(characterIdx).setAfkTarget(afkTargetStr);
    }
}
