package scratch.idleontools.templating;

import freemarker.template.Configuration;
import org.mozilla.javascript.NativeArray;
import scratch.idleontools.jsbridge.IdleonJsContext;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public final class CharacterGenderGenerator extends IdleonJavaCodeGenerator {

    public CharacterGenderGenerator(Configuration config) {
        super(config, "character-gender.ftl", "CharacterGender");
    }

    @Override
    protected void populateDataModel(Map<String, Object> dataModel, IdleonJsContext idleonJsContext) {
        NativeArray genderNames = idleonJsContext.getCustomListsMap().get("Genders");
        dataModel.put("genderEnumNames", genderNames.stream().map(e -> TemplatingUtils.formatAsEnumFieldName((String) e)).toList());
        dataModel.put("genderNames", genderNames);
        dataModel.put("genderIds", IntStream.range(0, genderNames.size()).toArray());
    }

    @Override
    protected void populateEnumLookupMapSpecifications(List<EnumLookupMapSpecification> lookupMaps) {
        lookupMaps.add(new EnumLookupMapSpecification("String", "genderName", "getByName"));
        lookupMaps.add(new EnumLookupMapSpecification("int", "genderId", "getById"));
    }
}
