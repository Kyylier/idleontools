package scratch.idleontools.codegen;

import freemarker.template.Configuration;
import org.mozilla.javascript.NativeArray;
import scratch.idleontools.jsbridge.IdleonJsContext;

import java.util.List;
import java.util.Map;

public class AnvilProductGenerator extends IdleonJavaCodeGenerator {

    public AnvilProductGenerator(Configuration configuration) {
        super(configuration, "anvil-product.ftl", "AnvilProduct");
    }

    @Override
    protected void populateDataModel(Map<String, Object> dataModel, IdleonJsContext idleonJsContext) {
        NativeArray anvilProductionInfoArr = idleonJsContext.getCustomListsMap().get("AnvilProductionInfo");

    }

    @Override
    protected void populateEnumLookupMapSpecifications(List<EnumLookupMapSpecification> lookupMaps) {

    }
}
