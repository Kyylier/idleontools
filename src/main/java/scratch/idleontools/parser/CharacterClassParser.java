package scratch.idleontools.parser;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;
import scratch.idleontools.gamedatadeprecated.CharacterClass;
import scratch.idleontools.model.DataUtil;
import scratch.idleontools.parser.interfaces.CharacterDataParser;

public final class CharacterClassParser extends CharacterDataParser {

    public static final String TAG = CharacterClassParser.class.getName();
    public static final String KEY = CharacterClassParser.class.getName();
    public static final String FIELD_NAME = "CharacterClass";
    public static final CharacterClassParser INSTANCE = new CharacterClassParser();

    private CharacterClassParser() {}

    @Override
    public ImmutableSet<String> getHandledFields(int characterIdx) {
        return ImmutableSet.of(FIELD_NAME + "_" + characterIdx);
    }

    @Override
    protected void parseInternal(IdleonParsingContext context, int characterIdx) {
        JsonObject rootDocument = context.getRootDocument();
        JsonObject mainFields = DataUtil.getDocumentMainFields(rootDocument);

        int characterClassInt = DataUtil.getFieldAsInt(mainFields, FIELD_NAME + "_" + characterIdx);
        context.getResultBuilder().getCharacterBuilder(characterIdx).setCharacterClass(CharacterClass.getById(characterClassInt));
    }
}
