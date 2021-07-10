package scratch.idleontools.codegen;

import freemarker.template.Configuration;
import org.mozilla.javascript.NativeObject;
import scratch.idleontools.jsbridge.IdleonJsContext;
import scratch.idleontools.jsbridge.JsBridgeUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class IdleonMonsterGenerator extends IdleonJavaCodeGenerator {

    public IdleonMonsterGenerator(Configuration config) {
        super(config, "idleon-monster.ftl", "IdleonMonster");
    }

    @Override
    protected void populateDataModel(Map<String, Object> dataModel, IdleonJsContext idleonJsContext) {
        Map<String, NativeObject> monstersMapObj = idleonJsContext.getMonstersMap();
        HashMap<String, Map<String, Object>> monstersMap = new HashMap<>();
        monstersMapObj.forEach((key, value) -> {
            Map<String, Object> convertedProperties = JsBridgeUtil.convertToMap(value);
            convertedProperties.put("codeName", key);
            monstersMap.put(CodegenUtils.formatAsEnumFieldName(key), convertedProperties);
        });
        dataModel.put("monstersMap", monstersMap);
    }

    @Override
    protected void populateEnumLookupMapSpecifications(List<EnumLookupMapSpecification> lookupMaps) {
        lookupMaps.add(new EnumLookupMapSpecification("String", "codeName", "getByCodeName"));
        lookupMaps.add(new EnumLookupMapSpecification("String", "displayName", "getByDisplayName"));
    }
}
