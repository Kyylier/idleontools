package scratch.idleontools;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import scratch.idleontools.model.DataUtil;
import scratch.idleontools.parser.IdleonParsingContext;
import scratch.idleontools.parser.IdleonParsingRegistry;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/** Tool for parsing account save data. */
public class Decode {

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT %4$s %2$s | %5$s%6$s%n");
    }

    public static void main(String[] args) throws IOException {
        String accountData = new String(Objects.requireNonNull(Decode.class.getClassLoader()
                .getResourceAsStream("scratch/idleontools/data.txt")).readAllBytes(), StandardCharsets.UTF_8);
        JsonObject jsonObject = JsonParser.parseString(accountData).getAsJsonObject();

        IdleonParsingContext parsingContext = new IdleonParsingContext(jsonObject);
        parsingContext.initialize();

        IdleonParsingRegistry.getAccountDataParsers().forEach(parser -> parser.parse(parsingContext));
        IntStream.range(0, parsingContext.getNumCharacters())
                .forEach(i -> IdleonParsingRegistry.getCharacterDataParsers()
                        .forEach(characterDataParser -> characterDataParser.parse(parsingContext, i)));

        System.out.printf("Unhandled fields: %s%n", parsingContext.getUnhandledMainFields().toString().replaceAll("(.{150})", "$1\n"));
        parsingContext.getResult();
        //parsingContext.getResult().getCharacters().forEach(System.out::println);
    }

}
