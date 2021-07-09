package scratch.idleontools.gamedatadeprecated;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** These are stats belonging to equipment items. */
public enum EquipmentStat {

    /*
        lvReqToEquip Class Speed Reach Weapon_Power STR AGI WIS LUK Defence UQ1txt UQ1val UQ2txt UQ2val Upgrade_Slots_Left
     */

    LVL_REQ_TO_EQUIP(0, "lvReqToEquip"),
    CLASS(1, "Class"),
    SPEED(2, "Speed"),
    REACH(3, "Reach"),
    WEAPON_OR_TOOL_POWER(4, "Weapon_Power"),
    STR(5, "STR"),
    AGI(6, "AGI"),
    WIS(7, "WIS"),
    LUK(8, "LUK"),
    DEFENCE(9, "Defence"),
    UQ1TXT(10, "UQ1txt"),
    UQ1VAL(11, "UQ1val"),
    UQ2TXT(12, "UQ2txt"),
    UQ2VAL(13, "UQ2val"),
    UPGRADE_SLOTS_LEFT(14, "Upgrade_Slots_Left"),

    // Code has references to this equipment stat. Unknown what this does.
    POWER(-1, "Power");

    public final int idx;
    public final String name;

    EquipmentStat(int idx, String name) {
        this.idx = idx;
        this.name = name;
    }

    private static final Map<Integer, EquipmentStat> idxToEquipmentSlotMap = new HashMap<>();
    private static final Map<String, EquipmentStat> nameToEquipmentSlotMap = new HashMap<>();

    static {
        Arrays.stream(EquipmentStat.values()).filter(stat -> stat.idx != -1).forEach(stat -> idxToEquipmentSlotMap.put(stat.idx, stat));
        Arrays.stream(EquipmentStat.values()).forEach(stat -> nameToEquipmentSlotMap.put(stat.name, stat));
    }

    public static EquipmentStat getBySlotIdx(int idx) {
        return Objects.requireNonNull(idxToEquipmentSlotMap.get(idx));
    }

    public static EquipmentStat getByName(String name) {
        return Objects.requireNonNull(nameToEquipmentSlotMap.get(name), "Unrecognized EquipmentStat: %s".formatted(name));
    }
}
