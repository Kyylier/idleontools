package scratch.idleontools.codegen;

import freemarker.template.Configuration;
import org.mozilla.javascript.NativeArray;
import org.mozilla.javascript.NativeFunction;
import scratch.idleontools.jsbridge.IdleonJsContext;

import java.util.List;
import java.util.Map;

public final class ItemStatGenerator extends IdleonJavaCodeGenerator {

    public ItemStatGenerator(Configuration config) {
        super(config, "item-stat.ftl", "ItemStat");
    }

    @Override
    protected void populateDataModel(Map<String, Object> dataModel, IdleonJsContext idleonJsContext) {
        NativeFunction itemDefinitionsFunc = ((NativeFunction) idleonJsContext.getGodObject().get("scripts.ItemDefinitions"));
        addStatArrToDataModel(dataModel, (NativeArray) itemDefinitionsFunc.get("COMMON_STATS"), "common");
        addStatArrToDataModel(dataModel, (NativeArray) itemDefinitionsFunc.get("EQUIP_STATS"), "equip");
        addStatArrToDataModel(dataModel, (NativeArray) itemDefinitionsFunc.get("CONSUMABLE_STATS"), "consumable");
        addStatArrToDataModel(dataModel, (NativeArray) itemDefinitionsFunc.get("QUEST_STATS"), "quest");
    }

    @Override
    protected void populateEnumLookupMapSpecifications(List<EnumLookupMapSpecification> lookupMaps) {}

    private static void addStatArrToDataModel(Map<String, Object> dataModel, NativeArray statArr, String statType) {
        dataModel.put(statType + "StatNames", statArr);
        dataModel.put(statType + "StatEnumNames", statArr.stream().map(e -> CodegenUtils.formatAsEnumFieldName((String) e)).toList());
    }
}
