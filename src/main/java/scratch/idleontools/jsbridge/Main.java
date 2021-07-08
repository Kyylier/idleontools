package scratch.idleontools.jsbridge;

import com.google.api.client.util.StringUtils;
import com.google.common.base.Preconditions;
import io.opencensus.trace.Link;
import org.mozilla.javascript.*;
import org.mozilla.javascript.ast.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public final class Main {

    private static final String JS_RESOURCE_LOCATION = "scratch/idleontools/Z.js";

    public static void main(String[] args) throws IOException {
        IdleonJsContext idleonJsContext = IdleonJsContext.initFromSource(JS_RESOURCE_LOCATION);

        //processItemDatabase(idleonJsContext);
        //processMonsterDatabase(idleonJsContext);
        //processCustomLists(idleonJsContext);
        //processActorEvents(idleonJsContext); // WIP
    }

    private static final Set<String> CUSTOMLISTS_IDS_FILTER = Set.of(
            "__name__", "arguments", "prototype", "name", "arity", "length");

    private static void processCustomLists(IdleonJsContext idleonJsContext) {
        NativeFunction f = (NativeFunction) idleonJsContext.getGodObject().get("scripts.CustomLists");

        List<String> customListNames = Arrays.stream(f.getIds())
                .map(Object::toString)
                .filter(e -> !CUSTOMLISTS_IDS_FILTER.contains(e))
                .collect(Collectors.toList());
        HashMap<String, NativeArray> customListMap = new HashMap<>();
        customListNames.forEach(listFuncName -> {
            Preconditions.checkArgument(f.get(listFuncName) instanceof NativeFunction);
            NativeFunction listFunc = (NativeFunction) f.get(listFuncName);
            Preconditions.checkArgument(listFunc.getArity() == 0);
            Object result = listFunc.call(idleonJsContext.getContext(), idleonJsContext.getGlobalScope(), listFunc, new Object[]{});
            customListMap.put(listFuncName, (NativeArray) result);
        });
        System.out.println(customListMap.keySet());
    }

    private static void processActorEvents(IdleonJsContext idleonJsContext) {
        List<String> actorEventScripts = idleonJsContext.getGodObject().keySet().stream()
                .map(objKey -> (String) objKey)
                .filter(objKeyStr -> objKeyStr.startsWith("scripts.ActorEvents_"))
                .sorted(Comparator.comparingInt(objKeyStr -> Integer.parseInt(objKeyStr.substring("scripts.ActorEvents_".length()))))
                .collect(Collectors.toList());
        System.out.println(actorEventScripts);
    }

    private static void processMonsterDatabase(IdleonJsContext idleonJsContext) {
        NativeFunction f = (NativeFunction) idleonJsContext.getGodObject().get("scripts.MonsterDefinitions");
        ((NativeFunction) f.get("get")).call(idleonJsContext.getContext(), idleonJsContext.getGlobalScope(), f, new Object[] {});

        LinkedHashSet<String> allMonsterProps = new LinkedHashSet<>();
        NativeObject monsterData = flattenOnce((NativeObject) f.get("monsterDefs"));
        monsterData.keySet().forEach(itemName -> flattenOnce((NativeObject) monsterData.get(itemName)).keySet().forEach(itemProp -> allMonsterProps.add((String) itemProp)));

        System.out.println("\n\n\n=== Monster Database ===");
        System.out.println(
                "codeName\t" + Arrays.stream(allMonsterProps.toArray()).map(Object::toString).collect(Collectors.joining("\t")));

        monsterData.keySet().forEach(itemName -> {
            System.out.print(itemName + "\t");
            NativeObject itemProps = flattenOnce((NativeObject) monsterData.get(itemName));
            for (String itemProp : allMonsterProps) {
                if (itemProps.containsKey(itemProp)) {
                    Object itemPropObj = itemProps.get(itemProp);
                    if (itemPropObj instanceof NativeArray) {
                        System.out.print(Arrays.toString(((NativeArray) itemPropObj).toArray()) + "\t");
                    } else {
                        System.out.print(itemPropObj + "\t");
                    }
                } else {
                    System.out.print("-\t");
                }
            }
            System.out.println();
        });
    }

    private static void processItemDatabase(IdleonJsContext idleonJsContext) {
        NativeFunction f = (NativeFunction) idleonJsContext.getGodObject().get("scripts.ItemDefinitions");
        ((NativeFunction) f.get("get")).call(idleonJsContext.getContext(), idleonJsContext.getGlobalScope(), f, new Object[] {});

        LinkedHashSet<String> allItemProps = new LinkedHashSet<>();
        NativeObject itemData = flattenOnce((NativeObject) f.get("itemDefs"));
        itemData.keySet().forEach(itemName -> flattenOnce((NativeObject) itemData.get(itemName)).keySet().forEach(itemProp -> allItemProps.add((String) itemProp)));
        System.out.println("\n\n\n=== Item Database ===");
        System.out.println(
                "codeName\t" + Arrays.stream(allItemProps.toArray()).map(Object::toString).collect(Collectors.joining("\t")));
        itemData.keySet().forEach(itemName -> {
            System.out.print(itemName + "\t");
            NativeObject itemProps = flattenOnce((NativeObject) itemData.get(itemName));
            for (String itemProp : allItemProps) {
                if (itemProps.containsKey(itemProp)) {
                    System.out.print(itemProps.get(itemProp) + "\t");
                } else {
                    System.out.print("-\t");
                }
            }
            System.out.println();
        });
    }

    private static NativeObject flattenOnce(NativeObject o) {
        Preconditions.checkArgument(o.keySet().size() == 1);
        String extraLayer = (String) o.keySet().stream().findFirst().get();
        return (NativeObject) o.get(extraLayer);
    }

    private Main() {}
}
