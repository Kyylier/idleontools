package scratch.idleontools.gamedata;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** Contains enumerations of all item stats. */
@Generated(
        value = "Generated with FreeMarker (version ${.version}) using template ${.current_template_name}.",
        date = "${.now}"
)
public interface ItemStat {

    public enum Common implements ItemStat {
         <#list commonStatNames as commonStatName>${commonStatEnumNames[commonStatName?index]}("${commonStatName}")<#sep>,
         </#sep></#list>;

         public final String statName;

         Common(String statName) {
             this.statName = statName;
         }

         @Override
         public ItemStatType getStatType() {
             return ItemStatType.COMMON;
         }
    }

    public enum Equip implements ItemStat {
         <#list equipStatNames as equipStatName>${equipStatEnumNames[equipStatName?index]}("${equipStatName}")<#sep>,
         </#sep></#list>;

        public final String statName;

        Equip(String statName) {
            this.statName = statName;
        }

        @Override
        public ItemStatType getStatType() {
            return ItemStatType.EQUIP;
        }
    }

    public enum Consumable implements ItemStat {
         <#list consumableStatNames as consumableStatName>${consumableStatEnumNames[consumableStatName?index]}("${consumableStatName}")<#sep>,
         </#sep></#list>;

        public final String statName;

        Consumable(String statName) {
            this.statName = statName;
        }

        @Override
        public ItemStatType getStatType() {
            return ItemStatType.CONSUMABLE;
        }
    }

    public enum Quest implements ItemStat {
         <#list questStatNames as questStatName>${questStatEnumNames[questStatName?index]}("${questStatName}")<#sep>,
         </#sep></#list>;

        public final String statName;

        Quest(String statName) {
            this.statName = statName;
        }

        @Override
        public ItemStatType getStatType() {
            return ItemStatType.QUEST;
        }
    }

    ItemStatType getStatType();

    static final Map<String, ItemStat> statNameToItemStatMap = new HashMap<>();

    public static ItemStat getByName(String statName) {
        if (statNameToItemStatMap.isEmpty()) {
            Arrays.stream(Common.values()).forEach(e -> statNameToItemStatMap.put(e.statName, e));
            Arrays.stream(Equip.values()).forEach(e -> statNameToItemStatMap.put(e.statName, e));
            Arrays.stream(Consumable.values()).forEach(e -> statNameToItemStatMap.put(e.statName, e));
            Arrays.stream(Quest.values()).forEach(e -> statNameToItemStatMap.put(e.statName, e));
        }
        return Objects.requireNonNull(statNameToItemStatMap.get(statName));
    }
}
