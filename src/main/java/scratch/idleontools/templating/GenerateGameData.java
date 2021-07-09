package scratch.idleontools.templating;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import scratch.idleontools.jsbridge.IdleonJsContext;

import java.io.File;
import java.io.IOException;

public final class GenerateGameData {

    public static void main(String[] args) throws IOException, TemplateException {
        IdleonJsContext idleonJsContext = IdleonJsContext.initFromSource();

        Configuration config = new Configuration(Configuration.VERSION_2_3_30);
        config.setDirectoryForTemplateLoading(new File("src/main/freemarker/template"));
        config.setDefaultEncoding("UTF-8");


        (new CharacterClassGenerator(config)).generate(idleonJsContext);
        (new CharacterGenderGenerator(config)).generate(idleonJsContext);
        (new CharacterSkillGenerator(config)).generate(idleonJsContext);
    }

    private GenerateGameData() {}
}
