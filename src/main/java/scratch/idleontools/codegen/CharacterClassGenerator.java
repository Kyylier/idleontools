package scratch.idleontools.codegen;

import freemarker.template.Configuration;
import org.mozilla.javascript.NativeArray;
import scratch.idleontools.jsbridge.IdleonJsContext;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class CharacterClassGenerator extends IdleonJavaCodeGenerator {

    public CharacterClassGenerator(Configuration config) {
        super(config, "character-class.ftl", "CharacterClass");
    }

    @Override
    protected void populateDataModel(Map<String, Object> dataModel, IdleonJsContext idleonJsContext) {
        NativeArray classNames = idleonJsContext.getCustomListsMap().get("ClassNames");
        NativeArray classSpecializeSkills = idleonJsContext.getCustomListsMap().get("ClassSpecializeSkills");

        List<Integer> validClassIdxs = new ArrayList<>();
        validClassIdxs.add(1);
        idleonJsContext.getCustomListsMap().get("ClassFamilyBonusDISPorder")
                .forEach(e -> validClassIdxs.add(((Double) e).intValue()));
        validClassIdxs.removeIf(id -> ((String) classNames.get(id)).equalsIgnoreCase("FILLER"));
        Collections.sort(validClassIdxs);

        List<String> classNamesFiltered = validClassIdxs.stream().map(id -> (String) classNames.get(id)).toList();

        dataModel.put("classNames", classNamesFiltered);
        dataModel.put("classIds", validClassIdxs);
        dataModel.put("classSpecializeSkills", classSpecializeSkills);
    }

    @Override
    protected void populateEnumLookupMapSpecifications(List<EnumLookupMapSpecification> lookupMaps) {
        lookupMaps.add(new EnumLookupMapSpecification("int", "classId", "getById"));
    }
}
