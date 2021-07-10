package scratch.idleontools.gamedata;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** Contains enumerations of all item stats. */
@Generated(
        value = "Generated with FreeMarker (version 2.3.31) using template item-stat.ftl.",
        date = "Jul 10, 2021, 3:31:01 PM"
)
public interface ItemStat {

    public enum Common implements ItemStat {
         DISPLAYNAME("displayName"),
         SELLPRICE("sellPrice"),
         TYPEGEN("typeGen"),
         ID("ID"),
         TYPE("Type"),
         LVREQTOCRAFT("lvReqToCraft");

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
         LVREQTOEQUIP("lvReqToEquip"),
         CLASS("Class"),
         SPEED("Speed"),
         REACH("Reach"),
         WEAPON_POWER("Weapon_Power"),
         STR("STR"),
         AGI("AGI"),
         WIS("WIS"),
         LUK("LUK"),
         DEFENCE("Defence"),
         UQ1TXT("UQ1txt"),
         UQ1VAL("UQ1val"),
         UQ2TXT("UQ2txt"),
         UQ2VAL("UQ2val"),
         UPGRADE_SLOTS_LEFT("Upgrade_Slots_Left");

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
         DESC_LINE1("desc_line1"),
         DESC_LINE2("desc_line2"),
         DESC_LINE3("desc_line3"),
         DESC_LINE4("desc_line4"),
         DESC_LINE5("desc_line5"),
         DESC_LINE6("desc_line6"),
         DESC_LINE7("desc_line7"),
         DESC_LINE8("desc_line8"),
         EFFECT("Effect"),
         TRIGGER("Trigger"),
         AMOUNT("Amount"),
         COOLDOWN("Cooldown");

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
         DESC_LINE1("desc_line1"),
         DESC_LINE2("desc_line2"),
         DESC_LINE3("desc_line3"),
         DESC_LINE4("desc_line4"),
         DESC_LINE5("desc_line5"),
         DESC_LINE6("desc_line6"),
         DESC_LINE7("desc_line7"),
         DESC_LINE8("desc_line8");

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
