package scratch.idleontools.parser;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;
import scratch.idleontools.model.DataUtil;
import scratch.idleontools.parser.interfaces.AccountDataParser;

public final class MiscAccountDataParser extends AccountDataParser {

    public static final String TAG = MiscAccountDataParser.class.getName();
    public static final String KEY = MiscAccountDataParser.class.getName();
    public static final String FIELD_NAME_MONEY_BANK = "MoneyBANK";
    public static final MiscAccountDataParser INSTANCE = new MiscAccountDataParser();

    private MiscAccountDataParser() {}

    @Override
    public ImmutableSet<String> getHandledFields() {
        return ImmutableSet.of(FIELD_NAME_MONEY_BANK);
    }

    @Override
    protected void parseInternal(IdleonParsingContext context) {
        JsonObject rootDocument = context.getRootDocument();
        JsonObject mainFields = DataUtil.getDocumentMainFields(rootDocument);

        parseBankMoney(context, mainFields);
    }

    private static void parseBankMoney(IdleonParsingContext context, JsonObject mainFields) {
        Integer bankMoney = DataUtil.getFieldAsInt(mainFields, FIELD_NAME_MONEY_BANK);
        context.getResultBuilder().setBankMoney(bankMoney);
    }
}
