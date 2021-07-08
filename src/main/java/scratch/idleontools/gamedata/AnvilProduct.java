package scratch.idleontools.gamedata;

public enum AnvilProduct {

    THREAD(0),
    TRUSTY_NAILS(1),
    BORING_BRICK(2),
    CHAIN_LINK(3),
    LEATHER_HIDE(4),
    PINION_SPUR(5),
    LUGI_BRACKET(6),
    UNKNOWN_7(7),
    UNKNOWN_8(8),
    UNKNOWN_9(9),
    UNKNOWN_10(10),
    UNKNOWN_11(11),
    UNKNOWN_12(12),
    UNKNOWN_13(13);

    /** The slot in the Anvil "Produce" tab for this item. First item is 0. */
    public final int productionIdx;

    AnvilProduct(int productionIdx) {
        this.productionIdx = productionIdx;
    }

}
