package scratch.idleontools.jsbridge;

import org.mozilla.javascript.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public final class GameDataToTSV {

    private static final String JS_RESOURCE_LOCATION = "scratch/idleontools/Z.js";

    public static void main(String[] args) throws IOException {
        IdleonJsContext idleonJsContext = IdleonJsContext.initFromSource(JS_RESOURCE_LOCATION);

        processItemDatabase(idleonJsContext);
        processMonsterDatabase(idleonJsContext);
        //processActorEvents(idleonJsContext); // WIP
    }

    private static void processActorEvents(IdleonJsContext idleonJsContext) {
        List<String> actorEventScripts = idleonJsContext.getGodObject().keySet().stream()
                .map(objKey -> (String) objKey)
                .filter(objKeyStr -> objKeyStr.startsWith("scripts.ActorEvents_"))
                .sorted(Comparator.comparingInt(objKeyStr -> Integer.parseInt(objKeyStr.substring("scripts.ActorEvents_".length()))))
                .collect(Collectors.toList());
        System.out.println(actorEventScripts);
    }

    /** Dumps all monster definitions into TSV format. */
    private static void processMonsterDatabase(IdleonJsContext idleonJsContext) {
        System.out.println("\n\n\n=== Monster Database ===");
        System.out.println("codeName\t" + String.join("\t" , idleonJsContext.getAllMonsterProperties()));

        Map<String, NativeObject> monsterData = idleonJsContext.getMonstersMap();
        monsterData.keySet().forEach(monsterName -> {
            System.out.print(monsterName + "\t");
            NativeObject monsterProps = monsterData.get(monsterName);
            for (String monsterProp : idleonJsContext.getAllMonsterProperties()) {
                if (monsterProps.containsKey(monsterProp)) {
                    Object monsterPropObj = monsterProps.get(monsterProp);
                    if (monsterPropObj instanceof NativeArray) {
                        System.out.print(Arrays.toString(((NativeArray) monsterPropObj).toArray()) + "\t");
                    } else {
                        System.out.print(monsterPropObj + "\t");
                    }
                } else {
                    System.out.print("-\t");
                }
            }
            System.out.println();
        });
    }

    /** Dumps all item definitions into TSV format. */
    private static void processItemDatabase(IdleonJsContext idleonJsContext) {
        System.out.println("\n\n\n=== Item Database ===");
        System.out.println("codeName\t" + String.join("\t" , idleonJsContext.getAllItemProperties()));

        Map<String, NativeObject> itemData = idleonJsContext.getItemsMap();
        itemData.keySet().forEach(itemName -> {
            System.out.print(itemName + "\t");
            NativeObject itemProps = itemData.get(itemName);
            for (String itemProp : idleonJsContext.getAllItemProperties()) {
                if (itemProps.containsKey(itemProp)) {
                    System.out.print(itemProps.get(itemProp) + "\t");
                } else {
                    System.out.print("-\t");
                }
            }
            System.out.println();
        });
    }

    private GameDataToTSV() {}
}
