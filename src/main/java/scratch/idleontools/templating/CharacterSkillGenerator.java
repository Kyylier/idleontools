package scratch.idleontools.templating;

import freemarker.template.Configuration;
import org.mozilla.javascript.NativeArray;
import scratch.idleontools.jsbridge.IdleonJsContext;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public final class CharacterSkillGenerator extends IdleonJavaCodeGenerator {

    public CharacterSkillGenerator(Configuration config) {
        super(config, "character-skill.ftl", "CharacterSkill");
    }

    @Override
    protected void populateDataModel(Map<String, Object> dataModel, IdleonJsContext idleonJsContext) {
        NativeArray skillNames = idleonJsContext.getCustomListsMap().get("SkillNames");
        dataModel.put("skillEnumNames", skillNames.stream().map(e -> TemplatingUtils.formatAsEnumFieldName((String) e)).toList());
        dataModel.put("skillNames", skillNames);
        dataModel.put("skillIds", IntStream.range(0, skillNames.size()).toArray());
    }

    @Override
    protected void populateEnumLookupMapSpecifications(List<EnumLookupMapSpecification> lookupMaps) {
        lookupMaps.add(new EnumLookupMapSpecification("String", "skillName", "getByName"));
        lookupMaps.add(new EnumLookupMapSpecification("int", "skillId", "getById"));
    }
}
