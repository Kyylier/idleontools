package scratch.idleontools.gamedata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** These are the slots in the "Tools" tab in the inventory. */
public enum EquipmentToolSlot {

    /*
        aPick aHatchet aFishingRod aBugNet aTrap aSkull 7 8
     */

    PICK(0),
    HATCHET(1),
    FISHING_ROD(2),
    BUG_NET(3),
    TRAP(4),
    SKULL(5),
    UNUSED_7(6),
    UNUSED_8(7),

    // These slots technically exist since EMmLENGTH1_{*} seems to always be 16.
    UNUSED_9(8),
    UNUSED_10(9),
    UNUSED_11(10),
    UNUSED_12(11),
    UNUSED_13(12),
    UNUSED_14(13),
    UNUSED_15(14),
    UNUSED_16(15);

    /** Id of this tool slot. */
    public final int slotId;

    EquipmentToolSlot(int slotId) {
        this.slotId = slotId;
    }

    private static final Map<Integer, EquipmentToolSlot> slotIdToToolSlotMap = new HashMap<>();

    static {
        Arrays.stream(EquipmentToolSlot.values()).forEach(toolSlot -> slotIdToToolSlotMap.put(toolSlot.slotId, toolSlot));
    }

    public static EquipmentToolSlot getBySlotId(int slotId) {
        return Objects.requireNonNull(slotIdToToolSlotMap.get(slotId), "Unrecognized EquipmentToolSlot ID: %d".formatted(slotId));
    }
}
