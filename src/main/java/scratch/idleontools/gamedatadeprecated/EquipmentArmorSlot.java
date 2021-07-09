package scratch.idleontools.gamedatadeprecated;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** These are the slots in the "Equips" tab in the inventory, including subsequent pages. */
public enum EquipmentArmorSlot {

    /*
        aHelmet aWeapon aShirt aPendant aPants aRing aShoes aRing aHelmetMTX aTrophy2 aTrophy aTrophy4 aTrophy5 aChatRingMTX aTrophy7 aTrophy8
     */

    // Page 1
    HELMET(0),
    WEAPON(1),
    SHIRT(2),
    PENDANT(3),
    PANTS(4),
    RING_1(5),
    SHOES(6),
    RING_2(7),

    // Page 2
    HELMET_MTX(8),
    UNUSED_TROPHY_2(9),
    TROPHY(10),
    UNUSED_TROPHY_4(11),
    UNUSED_TROPHY_5(12),
    CHAT_RING_MTX(13),
    UNUSED_TROPHY_7(14),
    UNUSED_TROPHY_8(15);

    /** Id of this armor slot. */
    public final int slotId;

    EquipmentArmorSlot(int slotId) {
        this.slotId = slotId;
    }

    private static final Map<Integer, EquipmentArmorSlot> slotIdToEquipmentSlotMap = new HashMap<>();

    static {
        Arrays.stream(EquipmentArmorSlot.values()).forEach(slotId -> slotIdToEquipmentSlotMap.put(slotId.slotId, slotId));
    }

    public static EquipmentArmorSlot getBySlotId(int slotId) {
        return Objects.requireNonNull(slotIdToEquipmentSlotMap.get(slotId), "Unrecognized EquipmentArmorSlot ID: %d".formatted(slotId));
    }
}
