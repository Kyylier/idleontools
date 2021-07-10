package scratch.idleontools.codegen;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import scratch.idleontools.jsbridge.IdleonJsContext;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class IdleonJavaCodeGenerator {

    private static final String OUTPUT_DIRECTORY = "src/main/java/scratch/idleontools/gamedata/";

    protected final Configuration config;
    protected final String templateName;
    protected final String outputClassName;

    protected IdleonJavaCodeGenerator(Configuration config, String templateName, String outputClassName) {
        this.config = config;
        this.templateName = templateName;
        this.outputClassName = outputClassName;
    }

    public final void generate(IdleonJsContext idleonJsContext) throws IOException, TemplateException {
        Template template = config.getTemplate(templateName);

        HashMap<String, Object> dataModel = new HashMap<>();
        // The string that will be used in the Class declaration as well as the file name (e.g. CharacterClass).
        dataModel.put("javaClassName", outputClassName);
        dataModel.put("hasStaticInitialization", false);
        populateDataModel(dataModel, idleonJsContext);

        List<EnumLookupMapSpecification> lookupMaps = new ArrayList<>();
        populateEnumLookupMapSpecifications(lookupMaps);
        // Add some supporting items for generating the lookup maps.
        if (!lookupMaps.isEmpty()) {
            dataModel.put("hasStaticInitialization", true);
            // Camel-cased version of javaClassName (for usage in local variables, e.g. characterClass)
            dataModel.put("javaClassNameAsParam", Character.toLowerCase(outputClassName.charAt(0)) + outputClassName.substring(1));
        }
        dataModel.put("lookupMaps", lookupMaps);

        File outputFile = new File(OUTPUT_DIRECTORY + outputClassName + ".java");
        outputFile.getParentFile().mkdirs();
        template.process(dataModel, new PrintWriter(outputFile));
    }

    protected abstract void populateDataModel(Map<String, Object> dataModel, IdleonJsContext idleonJsContext);

    protected abstract void populateEnumLookupMapSpecifications(List<EnumLookupMapSpecification> lookupMaps);

    /** Specification for creating a Map<T, Enum> to lookup an Enum by the specified field value. */
    public static class EnumLookupMapSpecification {

        private String fieldTypeName;
        private String fieldName;
        private String lookupMethodName;

        protected EnumLookupMapSpecification(String fieldTypeName, String fieldName, String lookupMethodName) {
            this.fieldTypeName = fieldTypeName;
            this.fieldName = fieldName;
            this.lookupMethodName = lookupMethodName;
        }

        public String getFieldTypeName() {
            return fieldTypeName;
        }

        public String getMapKeyTypeName() {
            return switch (fieldTypeName) {
                case "int" -> "Integer";
                case "float" -> "Float";
                default -> fieldTypeName;
            };
        }

        public String getFieldName() {
            return fieldName;
        }

        public String getLookupMethodName() {
            return lookupMethodName;
        }
    }
}
