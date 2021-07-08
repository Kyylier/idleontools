package scratch.idleontools.parser;

import com.google.common.collect.ImmutableSet;
import scratch.idleontools.parser.interfaces.AccountDataParser;
import scratch.idleontools.parser.interfaces.CharacterDataParser;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public final class IdleonParsingRegistry {

    private static final HashMap<String, AccountDataParser> accountDataParsers = new HashMap<>();
    private static final HashMap<String, CharacterDataParser> characterDataParsers = new HashMap<>();

    static {
        accountDataParsers.put(MiscAccountDataParser.KEY, MiscAccountDataParser.INSTANCE);
        accountDataParsers.put(AlchemyAccountDataParser.KEY, AlchemyAccountDataParser.INSTANCE);
        accountDataParsers.put(AnvilRecipeStatusParser.KEY, AnvilRecipeStatusParser.INSTANCE);

        characterDataParsers.put(CharacterClassParser.KEY, CharacterClassParser.INSTANCE);
        characterDataParsers.put(CharacterStatsParser.KEY, CharacterStatsParser.INSTANCE);
        characterDataParsers.put(CharacterExpParser.KEY, CharacterExpParser.INSTANCE);
        characterDataParsers.put(CharacterTalentsParser.KEY, CharacterTalentsParser.INSTANCE);
        characterDataParsers.put(CharacterEquipmentParser.KEY, CharacterEquipmentParser.INSTANCE);
        characterDataParsers.put(AfkTargetParser.KEY, AfkTargetParser.INSTANCE);
        characterDataParsers.put(MoneyParser.KEY, MoneyParser.INSTANCE);

        characterDataParsers.put(IgnoredCharacterFields.KEY, IgnoredCharacterFields.INSTANCE);
    }

    public static Collection<AccountDataParser> getAccountDataParsers() {
        return Collections.unmodifiableCollection(accountDataParsers.values());
    }

    public static Collection<CharacterDataParser> getCharacterDataParsers() {
        return Collections.unmodifiableCollection(characterDataParsers.values());
    }

    /** Parser that does nothing - ignores fields we've looked into and decided to ignore. */
    private static final class IgnoredCharacterFields extends CharacterDataParser {

        private static final String KEY = IgnoredCharacterFields.class.getName();
        private static final IgnoredCharacterFields INSTANCE = new IgnoredCharacterFields();

        private static final String FIELD_NAME__UNUSED__EQUIPMENT_MAP_MODIFIER_LENGTH_0 = "EMmLENGTH0";
        private static final String FIELD_NAME__UNUSED__EQUIPMENT_MAP_MODIFIER_LENGTH_1 = "EMmLENGTH1";
        private static final String FIELD_NAME__UNUSED__CHAR_SAVED = "CharSAVED";

        @Override
        public ImmutableSet<String> getHandledFields(int characterIdx) {
            return ImmutableSet.of(
                    FIELD_NAME__UNUSED__EQUIPMENT_MAP_MODIFIER_LENGTH_0 + "_" + characterIdx,
                    FIELD_NAME__UNUSED__EQUIPMENT_MAP_MODIFIER_LENGTH_1 + "_" + characterIdx,
                    FIELD_NAME__UNUSED__CHAR_SAVED + "_" + characterIdx
            );
        }

        @Override
        public void parseInternal(IdleonParsingContext context, int characterIdx) {}
    }
}
