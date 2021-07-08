package scratch.idleontools.parser;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import scratch.idleontools.gamedata.CharacterClass;
import scratch.idleontools.gamedata.CharacterSkill;
import scratch.idleontools.model.DataUtil;
import scratch.idleontools.parser.interfaces.CharacterDataParser;

import java.util.Arrays;
import java.util.HashMap;

public final class CharacterExpParser extends CharacterDataParser {

    public static final String TAG = CharacterExpParser.class.getName();
    public static final String KEY = CharacterExpParser.class.getName();
    public static final String FIELD_NAME_EXP = "Exp0";
    public static final String FIELD_NAME_EXP_REQ = "ExpReq0";
    public static final CharacterExpParser INSTANCE = new CharacterExpParser();

    private CharacterExpParser() {}

    @Override
    public ImmutableSet<String> getHandledFields(int characterIdx) {
        return ImmutableSet.of(FIELD_NAME_EXP + "_" + characterIdx, FIELD_NAME_EXP_REQ + "_" + characterIdx);
    }

    @Override
    public void parseInternal(IdleonParsingContext context, int characterIdx) {
        JsonObject rootDocument = context.getRootDocument();
        JsonObject mainFields = DataUtil.getDocumentMainFields(rootDocument);

        double[] expArr = DataUtil.parseNumericArray(DataUtil.getFieldAsArray(mainFields, FIELD_NAME_EXP + "_" + characterIdx));
        double[] expReqArr = DataUtil.parseNumericArray(DataUtil.getFieldAsArray(mainFields, FIELD_NAME_EXP_REQ + "_" + characterIdx));

        HashMap<CharacterSkill, Double> skillExpMap = new HashMap<>();
        HashMap<CharacterSkill, Double> skillExpReqMap = new HashMap<>();
        Arrays.stream(CharacterSkill.values()).forEach(characterSkill -> {
            skillExpMap.put(characterSkill, expArr[characterSkill.expIdx]);
            skillExpReqMap.put(characterSkill, expReqArr[characterSkill.expIdx]);
        });
        context.getResultBuilder().getCharacterBuilder(characterIdx)
                .setClassExp(expArr[0], expReqArr[0])
                .setSkillExpMaps(skillExpMap, skillExpReqMap);
    }
}
