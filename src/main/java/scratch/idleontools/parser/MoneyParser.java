package scratch.idleontools.parser;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;
import scratch.idleontools.model.DataUtil;
import scratch.idleontools.parser.interfaces.CharacterDataParser;

public final class MoneyParser extends CharacterDataParser {

    public static final String TAG = MoneyParser.class.getName();
    public static final String KEY = MoneyParser.class.getName();
    public static final String FIELD_NAME = "Money";
    public static final MoneyParser INSTANCE = new MoneyParser();

    private MoneyParser() {}

    @Override
    public ImmutableSet<String> getHandledFields(int characterIdx) {
        return ImmutableSet.of(FIELD_NAME + "_" + characterIdx);
    }

    @Override
    protected void parseInternal(IdleonParsingContext context, int characterIdx) {
        JsonObject rootDocument = context.getRootDocument();
        JsonObject mainFields = DataUtil.getDocumentMainFields(rootDocument);

        int moneyInt = DataUtil.getFieldAsInt(mainFields, FIELD_NAME + "_" + characterIdx);
        context.getResultBuilder().getCharacterBuilder(characterIdx).setMoney(moneyInt);
    }

}
