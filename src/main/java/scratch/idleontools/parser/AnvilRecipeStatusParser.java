package scratch.idleontools.parser;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import scratch.idleontools.model.AnvilRecipeStatus;
import scratch.idleontools.gamedata.AnvilRecipe;
import scratch.idleontools.model.DataUtil;
import scratch.idleontools.parser.interfaces.AccountDataParser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.logging.Logger;

public final class AnvilRecipeStatusParser extends AccountDataParser {

    public static final String TAG = AnvilRecipeStatusParser.class.getName();
    public static final String KEY = AnvilRecipeStatusParser.class.getName();
    public static final String FIELD_NAME = "AnvilCraftStatus";
    public static final AnvilRecipeStatusParser INSTANCE = new AnvilRecipeStatusParser();

    private AnvilRecipeStatusParser() {
    }

    @Override
    public ImmutableSet<String> getHandledFields() {
        return ImmutableSet.of(FIELD_NAME);
    }

    @Override
    public void parseInternal(IdleonParsingContext context) {
        JsonObject rootDocument = context.getRootDocument();
        JsonObject mainFields = DataUtil.getDocumentMainFields(rootDocument);

        String anvilCraftStatusStr = DataUtil.getFieldAsString(mainFields, FIELD_NAME);
        JsonArray anvilCraftStatusArr = JsonParser.parseString(anvilCraftStatusStr).getAsJsonArray();

        HashSet<AnvilRecipe> unlocked = new HashSet<>();
        HashSet<AnvilRecipe> locked = new HashSet<>();
        Arrays.stream(AnvilRecipe.values()).forEach(anvilRecipe -> {
            int statusVal = anvilCraftStatusArr.get(anvilRecipe.page).getAsJsonArray().get(anvilRecipe.slot).getAsInt();
            switch (statusVal) {
                case -1 -> locked.add(anvilRecipe);
                case 0 -> unlocked.add(anvilRecipe);
                default -> Logger.getLogger(TAG).warning("Unrecognized AnvilCraftStatus recipe value: %d".formatted(statusVal));
            }
        });

        AnvilRecipeStatus result = new AnvilRecipeStatus(unlocked, locked);
        context.getResultBuilder().setAnvilCraftStatus(result);
        Logger.getLogger(TAG).info("[%s] Unlocked recipes: %d/%d".formatted(TAG, unlocked.size(), unlocked.size() + locked.size()));
    }
}
