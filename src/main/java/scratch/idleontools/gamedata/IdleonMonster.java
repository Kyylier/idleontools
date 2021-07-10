package scratch.idleontools.gamedata;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** Enumeration of all Idleon monsters. */
@Generated(
    value = "Generated with FreeMarker (version 2.3.31) using template idleon-monster.ftl.",
    date = "Jul 10, 2021, 3:31:01 PM"
)
public enum IdleonMonster {

    CHESTD4("ChestD4", "Legendary_Chest", "error", 345600, 100000, 0, 0, 1, 0),
    CHESTD3("ChestD3", "Legendary_Chest", "error", 345600, 100000, 0, 0, 1, 0),
    CHESTD6("ChestD6", "Legendary_Chest", "error", 345600, 100000, 0, 0, 1, 0),
    CHESTD5("ChestD5", "Legendary_Chest", "error", 345600, 100000, 0, 0, 1, 0),
    CHESTD8("ChestD8", "Legendary_Chest", "error", 345600, 100000, 0, 0, 1, 0),
    CHESTD7("ChestD7", "Legendary_Chest", "error", 345600, 100000, 0, 0, 1, 0),
    PLAT("Plat", "Plat", "MINING", 180, 5, 1, 30, 16000, 0),
    SHOVELR("shovelR", "Dig_Doug", "FIGHTING", 40, 14000, 0, 420, 228, 2),
    EYE("eye", "Neyeptune", "FIGHTING", 45, 350000, 0, 1900, 3400, 2000),
    PENGUIN("penguin", "Penguin", "FIGHTING", 40, 160000, 0, 1250, 2000, 800),
    BUGNEST3("BugNest3", "Sentient_Bowl", "FIGHTING", 86400, 999999999, 6, 2, 1, 6),
    MOONMAN("moonman", "Moonmoon", "FIGHTING", 40, 26500, 0, 380, 330, 170),
    SHOVELY("shovelY", "Plasti_Doug", "FIGHTING", 40, 14000, 0, 420, 1, 2),
    BUGNEST2("BugNest2", "Butterfly_Bar", "FIGHTING", 86400, 999999999, 6, 2, 1, 6),
    BUGNEST1("BugNest1", "Fly_Nest", "FIGHTING", 86400, 999999999, 6, 2, 1, 6),
    BUGNEST6("BugNest6", "Icicle_Nest", "FIGHTING", 86400, 999999999, 6, 2, 1, 6),
    BUGNEST5("BugNest5", "Snowden", "FIGHTING", 86400, 999999999, 6, 2, 1, 6),
    MIMICA("mimicA", "Mimic", "FIGHTING", 50, 5500, 0, 180, 132, 62),
    BUGNEST4("BugNest4", "Grocery_Bag", "FIGHTING", 86400, 999999999, 6, 2, 1, 6),
    NOTHING("Nothing", "_", "Nothing", 1, 42, 0, 69, 1, 0),
    CHESTD2("ChestD2", "Legendary_Chest", "error", 345600, 100000, 0, 0, 1, 0),
    CHESTD1("ChestD1", "Legendary_Chest", "error", 345600, 100000, 0, 0, 1, 0),
    FISH4("Fish4", "Bloach", "FIGHTING", 86400, 750000, 0, 12000, 600, 1000),
    BIRCHTREE("BirchTree", "Birch_Tree", "CHOPPIN", 0, 5, 3, 6, 80, 0),
    STARLIGHT("Starlight", "Error", "error", 12, 50000, 1, 1, 1, 0),
    FROGG("frogG", "Frog", "FIGHTING", 40, 50, 0, 7, 2, 5),
    POTATO("potato", "Mashed_Potato", "FIGHTING", 40, 18500, 0, 310, 260, 125),
    FISH1("Fish1", "Goldfish", "FIGHTING", 86400, 750000, 0, 12000, 600, 1000),
    ROCKS("rockS", "Skeleton_Rune", "FIGHTING", 55, 20000, 0, 10, 1, 50),
    FISH2("Fish2", "Hermit_Can", "FIGHTING", 86400, 750000, 0, 12000, 600, 1000),
    FISH3("Fish3", "Jellyfish", "FIGHTING", 86400, 750000, 0, 12000, 600, 1000),
    FORGEA("ForgeA", "Fire_Forge", "FIGHTING", 86400, 420, 0, 12000, 600, 1000),
    FLAKE("flake", "Frost_Flake", "FIGHTING", 40, 67000, 0, 700, 700, 360),
    FORGEB("ForgeB", "Cinder_Forge", "FIGHTING", 86400, 420, 0, 12000, 600, 1000),
    ROCKG("rockG", "Healing_Rune", "FIGHTING", 55, 3000, 0, 150, 1, 50),
    SNAKEG("snakeG", "Baby_Boa", "FIGHTING", 45, 450, 0, 34, 18, 18),
    SNAKEB("snakeB", "Cryosnake", "FIGHTING", 45, 260000, 0, 1690, 2900, 1425),
    SKELE2("skele2", "Bloodbone", "FIGHTING", 60, 10000000, 0, 6000, 100, 3000),
    SNAKEY("snakeY", "Shell_Snake", "FIGHTING", 45, 450, 0, 34, 18, 22),
    BLANK0RAMAFILLER("Blank0ramaFiller", "Nightmare_Amarok", "FIGHTING", 86400, 750000, 0, 12000, 600, 1000),
    SANDGIANT("sandgiant", "Sand_Giant", "FIGHTING", 40, 30000, 0, 410, 365, 195),
    MAMOTH("mamoth", "Mamooth", "FIGHTING", 40, 115000, 0, 1030, 1400, 580),
    PALMTREE("PalmTree", "Palm_Tree", "CHOPPIN", 0, 5, 3, 32, 1250, 0),
    GOBLING("goblinG", "Glublin", "FIGHTING", 52, 1250, 0, 60, 52, 30),
    BUG3("Bug3", "Sentient_Cereal", "CATCHING", 0, 5, 6, 10, 2500, 6),
    GOLD("Gold", "Gold", "MINING", 120, 5, 1, 10, 1250, 0),
    BUG2("Bug2", "Butterflies", "CATCHING", 0, 5, 6, 6, 600, 6),
    BUG1("Bug1", "Flies", "CATCHING", 0, 5, 6, 2, 50, 6),
    CRITTERCARD1("CritterCard1", "Froge", "FIGHTING", 86400, 420, 0, 12000, 600, 1000),
    CRITTERCARD2("CritterCard2", "Crabbo", "FIGHTING", 86400, 420, 0, 12000, 600, 1000),
    CRITTERCARD5("CritterCard5", "Owlio", "FIGHTING", 86400, 420, 0, 12000, 600, 1000),
    CRITTERCARD6("CritterCard6", "Pingy", "FIGHTING", 86400, 420, 0, 12000, 600, 1000),
    CRITTERCARD3("CritterCard3", "Scorpie", "FIGHTING", 86400, 420, 0, 12000, 600, 1000),
    CRITTERCARD4("CritterCard4", "Mousey", "FIGHTING", 86400, 420, 0, 12000, 600, 1000),
    GLASS("glass", "Quenchie", "FIGHTING", 45, 225000, 0, 1570, 2600, 1150),
    CRABCAKE("crabcake", "Crabcake", "FIGHTING", 40, 7500, 0, 210, 150, 70),
    BEANG("beanG", "Bored_Bean", "FIGHTING", 50, 150, 0, 15, 4, 11),
    SUMMEREVENT2("SummerEvent2", "Summer_Spirit", "FIGHTING", 86400, 750000, 0, 12000, 600, 1000),
    SUMMEREVENT1("SummerEvent1", "Coastiolyte", "FIGHTING", 86400, 750000, 0, 12000, 600, 1000),
    SLIMER("slimeR", "Valentslime", "FIGHTING", 42, 500, 0, 20, 9, 1),
    BOSS2A("Boss2A", "Efaunt", "FIGHTING", 86400, 1000000, 0, 12000, 775, 1000),
    BOSS2B("Boss2B", "Chaotic_Efaunt", "FIGHTING", 86400, 100000000, 0, 12000, 4000, 1000),
    BOSS2C("Boss2C", "Nightmare_Amarok", "FIGHTING", 86400, 750000, 0, 12000, 600, 1000),
    GHOST("ghost", "Ghost", "FIGHTING", 100, 1000, 0, 1, 1, 5),
    TOILETTREE("ToiletTree", "Toilet_Tree", "CHOPPIN", 0, 5, 3, 50, 3500, 0),
    DEMONPTUTORIAL("demonPtutorial", "Error", "error", 600, 10000, 0, 5000, 1, 150),
    SLIMEG("slimeG", "Slime", "FIGHTING", 42, 250, 0, 23, 9, 15),
    BABAMUMMY("babaMummy", "King_Doot", "FIGHTING", 86400, 3000000, 0, 50000, 1000, 800),
    CRITTERCARD9("CritterCard9", "Honker", "FIGHTING", 86400, 420, 0, 12000, 600, 1000),
    COCONUT("coconut", "Mafioso", "FIGHTING", 40, 11000, 0, 240, 180, 90),
    CRITTERCARD7("CritterCard7", "Bunny", "FIGHTING", 86400, 420, 0, 12000, 600, 1000),
    CRITTERCARD8("CritterCard8", "Dung_Beat", "FIGHTING", 86400, 420, 0, 12000, 600, 1000),
    BABAHOUR("babaHour", "Biggie_Hours", "FIGHTING", 86400, 800000, 0, 12500, 600, 500),
    BUG6("Bug6", "Flycicle", "CATCHING", 0, 5, 6, 75, 40000, 6),
    SANDCASTLE("sandcastle", "Sand_Castle", "FIGHTING", 40, 13000, 0, 265, 205, 99),
    BUG5("Bug5", "Mosquisnow", "CATCHING", 0, 5, 6, 40, 18000, 6),
    BABAYAGA("babayaga", "Baba_Yaga", "FIGHTING", 86400, 150000, 0, 1750, 300, 400),
    BUG4("Bug4", "Fruitflies", "CATCHING", 0, 5, 6, 20, 7000, 6),
    DEMENTIA("Dementia", "Dementia", "MINING", 180, 5, 1, 55, 150000, 0),
    ALIENTREETUTORIAL("AlienTreetutorial", "Error", "error", 0, 5, 3, 1, 1, 0),
    BANDIT_BOB("Bandit_Bob", "Bandit_Bob", "FIGHTING", 86400, 420, 0, 12000, 600, 1000),
    SHEEP("sheep", "Sheepie", "FIGHTING", 40, 55000, 0, 620, 550, 300),
    SOULCARD4("SoulCard4", "Frigid_Soul", "FIGHTING", 86400, 420, 0, 12000, 600, 1000),
    SOULCARD3("SoulCard3", "Rooted_Soul", "FIGHTING", 86400, 420, 0, 12000, 600, 1000),
    SOULCARD6("SoulCard6", "Bandit_Bob", "FIGHTING", 86400, 420, 0, 12000, 600, 1000),
    MUSHG("mushG", "Green_Mushroom", "FIGHTING", 35, 10, 0, 2, 1, 1),
    SOULCARD5("SoulCard5", "Squiddy_Soul", "FIGHTING", 86400, 420, 0, 12000, 600, 1000),
    LOVEEVENT("loveEvent", "Loveulyte", "FIGHTING", 86400, 750000, 0, 12000, 600, 1000),
    MUSHR("mushR", "Red_Mushroom", "FIGHTING", 45, 1000, 0, 47, 25, 30),
    MUSHPTUTORIAL("mushPtutorial", "Error", "error", 22, 200, 0, 200, 1, 5),
    SOULCARD2("SoulCard2", "Dune_Soul", "FIGHTING", 86400, 420, 0, 12000, 600, 1000),
    SKELE("skele", "Xylobone", "FIGHTING", 40, 200000, 0, 2000, 100, 200),
    SOULCARD1("SoulCard1", "Forest_Soul", "FIGHTING", 86400, 420, 0, 12000, 600, 1000),
    BOSSPART("BossPart", "Error", "FIGHTING", 22, 69420, 0, 0, 1, 20),
    STARFIRE("Starfire", "Starfire", "MINING", 240, 5, 1, 500, 5000000, 0),
    STEAK("steak", "Tyson", "FIGHTING", 40, 23000, 0, 350, 300, 150),
    CRYSTAL2("Crystal2", "Crystal_Cattle", "FIGHTING", 252000, 1000000, 0, 210, 180, 1),
    SNAILZ("snailZ", "Snelbie", "FIGHTING", 40, 35000, 0, 460, 400, 225),
    CRYSTAL1("Crystal1", "Crystal_Crabal", "FIGHTING", 40, 7500, 0, 210, 180, 1),
    MUSHW("mushW", "Wood_Mushroom", "FIGHTING", 50, 10000, 0, 300, 500, 75),
    CRYSTAL0("Crystal0", "Crystal_Carrot", "FIGHTING", 35, 1, 0, 2, 150, 0),
    TREE7("Tree7", "Wispy_Tree", "CHOPPIN", 0, 5, 3, 275, 50000, 0),
    EASTEREVENT1("EasterEvent1", "Egggulyte", "FIGHTING", 86400, 750000, 0, 12000, 600, 1000),
    CHESTA1("ChestA1", "Bronze_Chest", "error", 18000, 10, 0, 0, 1, 0),
    CHESTA3("ChestA3", "Bronze_Chest", "error", 18000, 10, 0, 0, 1, 0),
    EASTEREVENT2("EasterEvent2", "Egg_Capsule", "FIGHTING", 86400, 750000, 0, 12000, 600, 1000),
    CHESTA2("ChestA2", "Bronze_Chest", "error", 18000, 10, 0, 0, 1, 0),
    CHESTA5("ChestA5", "Bronze_Chest", "error", 18000, 10, 0, 0, 1, 0),
    CHESTA4("ChestA4", "Bronze_Chest", "error", 18000, 10, 0, 0, 1, 0),
    CHESTA7("ChestA7", "Bronze_Chest", "error", 18000, 10, 0, 0, 1, 0),
    CHESTA6("ChestA6", "Bronze_Chest", "error", 18000, 10, 0, 0, 1, 0),
    POOPD("poopD", "Boop", "FIGHTING", 74500, 200000, 0, 1000, 120, 250),
    CHESTA8("ChestA8", "Bronze_Chest", "error", 18000, 10, 0, 0, 1, 0),
    FISHSMALL("FishSmall", "Small_Fish", "FISHING", 0, 5, 4, 2, 40, 6),
    STUMPTREE("StumpTree", "Stump_Tree", "CHOPPIN", 0, 5, 3, 90, 10000, 0),
    PINCERMIN("pincermin", "Pincermin", "FIGHTING", 50, 15500, 0, 290, 240, 112),
    EFAUNTARM("EfauntArm", "Error", "FIGHTING", 22, 69420, 0, 0, 1, 20),
    BOSS3A("Boss3A", "Chizoar", "FIGHTING", 86400, 20000000, 0, 12000, 775, 1000),
    BOSS3B("Boss3B", "Chaotic_Chizoar", "FIGHTING", 86400, 750000000, 0, 12000, 4000, 1000),
    VOID("Void", "Void", "MINING", 240, 5, 1, 185, 600000, 0),
    BOSS3C("Boss3C", "Nightmare_Chizoar", "FIGHTING", 86400, 750000, 0, 12000, 600, 1000),
    XMASEVENT("xmasEvent", "Giftmas_Blobulyte", "FIGHTING", 86400, 750000, 0, 12000, 600, 1000),
    WOLFA("wolfA", "Amarok", "FIGHTING", 86400, 25000, 0, 12000, 105, 1000),
    CHESTB2("ChestB2", "Silver_Chest", "error", 36000, 500, 0, 0, 1, 0),
    SAHARANFOAL("SaharanFoal", "Saharan_Foal", "CHOPPIN", 0, 5, 3, 150, 20000, 0),
    CHESTB1("ChestB1", "Silver_Chest", "error", 36000, 500, 0, 0, 1, 0),
    CHESTB4("ChestB4", "Silver_Chest", "error", 36000, 500, 0, 0, 1, 0),
    CHESTB3("ChestB3", "Silver_Chest", "error", 36000, 500, 0, 0, 1, 0),
    CHESTB6("ChestB6", "Silver_Chest", "error", 36000, 500, 0, 0, 1, 0),
    CHESTB5("ChestB5", "Silver_Chest", "error", 36000, 500, 0, 0, 1, 0),
    CHESTB8("ChestB8", "Silver_Chest", "error", 36000, 500, 0, 0, 1, 0),
    CHESTB7("ChestB7", "Silver_Chest", "error", 36000, 500, 0, 0, 1, 0),
    PLANK("plank", "Wode_Board", "FIGHTING", 45, 1800, 0, 75, 70, 35),
    COPPER("Copper", "Copper", "MINING", 120, 5, 1, 2, 30, 0),
    SPEAKER("speaker", "Bop_Box", "FIGHTING", 45, 310000, 0, 1780, 3200, 1700),
    BLOQUE("bloque", "Bloque", "FIGHTING", 40, 100000, 0, 940, 1150, 500),
    LOVEEVENT2("loveEvent2", "Chocco_Box", "FIGHTING", 86400, 750000, 0, 12000, 600, 1000),
    ALIENTREE("AlienTree", "Alien_Tree", "CHOPPIN", 0, 5, 3, 6, 20000, 0),
    ROCKB("rockB", "Shielding_Rune", "FIGHTING", 55, 3000, 0, 150, 1, 50),
    JUNGLETREE("JungleTree", "Jungle_Tree", "CHOPPIN", 0, 5, 3, 12, 250, 0),
    CRABCAKEB("crabcakeB", "Mr_Blueberry", "FIGHTING", 40, 500, 0, 20, 1, 22),
    LUSTRE("Lustre", "Lustre", "MINING", 240, 5, 1, 250, 2000000, 0),
    ACORN("acorn", "Nutto", "FIGHTING", 60, 4000, 0, 190, 200, 40),
    JARSAND("jarSand", "Sandy_Pot", "FIGHTING", 50, 4000, 0, 150, 115, 55),
    SNOWBALL("snowball", "Snowman", "FIGHTING", 40, 135000, 0, 1130, 1700, 690),
    DREADLO("Dreadlo", "Dreadlo", "MINING", 300, 5, 1, 850, 25000000, 0),
    WOLFC("wolfC", "Nightmare_Amarok", "FIGHTING", 86400, 750000, 0, 12000, 600, 1000),
    SHEEPB("sheepB", "Floofie", "FIGHTING", 40, 500, 0, 1, 1, 0),
    GODSHARD("Godshard", "Godshard", "MINING", 600, 5, 1, 1250, 100000000, 0),
    WOLFB("wolfB", "Chaotic_Amarok", "FIGHTING", 86400, 15000000, 0, 12000, 1750, 1200),
    XMASEVENT2("xmasEvent2", "Meaning_of_Giftmas", "FIGHTING", 86400, 750000, 0, 12000, 600, 1000),
    FROGBIG("frogBIG", "Gigafrog", "FIGHTING", 55, 2500, 0, 95, 110, 45),
    BRANCH("branch", "Walking_Stick", "FIGHTING", 60, 1500, 0, 120, 150, 20),
    STACHE("stache", "Sir_Stache", "FIGHTING", 40, 81000, 0, 800, 900, 420),
    CHESTC3("ChestC3", "Golden_Chest", "error", 86400, 20000, 0, 0, 1, 0),
    CHESTC2("ChestC2", "Golden_Chest", "error", 86400, 20000, 0, 0, 1, 0),
    POOPSMALL("poopSmall", "Poop", "FIGHTING", 60, 9000, 0, 220, 100, 150),
    CHESTC5("ChestC5", "Golden_Chest", "error", 86400, 20000, 0, 0, 1, 0),
    CHESTC4("ChestC4", "Golden_Chest", "error", 86400, 20000, 0, 0, 1, 0),
    CHESTC7("ChestC7", "Golden_Chest", "error", 86400, 20000, 0, 0, 1, 0),
    CHESTC6("ChestC6", "Golden_Chest", "error", 86400, 20000, 0, 0, 1, 0),
    CHESTC8("ChestC8", "Golden_Chest", "error", 86400, 20000, 0, 0, 1, 0),
    OAKTREE("OakTree", "Oak_Tree", "CHOPPIN", 0, 5, 3, 2, 20, 0),
    IRON("Iron", "Iron", "MINING", 120, 5, 1, 5, 180, 0),
    FORESTTREE("ForestTree", "Forest_Tree", "CHOPPIN", 0, 5, 3, 20, 600, 0),
    CARROTO("carrotO", "Carrotman", "FIGHTING", 50, 800, 0, 45, 30, 22),
    THERMOSTAT("thermostat", "Thermister", "FIGHTING", 40, 185000, 0, 1370, 2250, 950),
    RATB("ratB", "Rat", "FIGHTING", 60, 20000, 0, 330, 180, 220),
    CHESTC1("ChestC1", "Golden_Chest", "error", 86400, 20000, 0, 0, 1, 0),
    RAM("ram", "Dedotated_Ram", "FIGHTING", 35, 1250000, 0, 3500, 1500, 3000),
    POOPBIG("poopBig", "Dr_Defecaus", "FIGHTING", 74500, 750000, 0, 12000, 600, 1000),
    BEHEMOTH("behemoth", "Error", "error", 1, 50000000, 0, 69, 20, 0);

    private static final Map<String, IdleonMonster> codeNameToIdleonMonsterMap = new HashMap<>();
    private static final Map<String, IdleonMonster> displayNameToIdleonMonsterMap = new HashMap<>();

    static {
        Arrays.stream(IdleonMonster.values()).forEach(idleonMonster -> codeNameToIdleonMonsterMap.put(idleonMonster.codeName, idleonMonster));
        Arrays.stream(IdleonMonster.values()).forEach(idleonMonster -> displayNameToIdleonMonsterMap.put(idleonMonster.displayName, idleonMonster));
    }

    public final String codeName;
    public final String displayName;
    public final String afkType;
    public final int respawnTime;
    public final int monsterHpTotal;
    public final int expType;
    public final int expGiven;
    public final int defence;
    public final int damage;

    IdleonMonster(
            String codeName,
            String displayName,
            String afkType,
            int respawnTime,
            int monsterHpTotal,
            int expType,
            int expGiven,
            int defence,
            int damage) {
        this.codeName = codeName;
        this.displayName = displayName;
        this.afkType = afkType;
        this.respawnTime = respawnTime;
        this.monsterHpTotal = monsterHpTotal;
        this.expType = expType;
        this.expGiven = expGiven;
        this.defence = defence;
        this.damage = damage;
    }

    public static IdleonMonster getByCodeName(String codeName) {
        return Objects.requireNonNull(codeNameToIdleonMonsterMap.get(codeName));
    }
    public static IdleonMonster getByDisplayName(String displayName) {
        return Objects.requireNonNull(displayNameToIdleonMonsterMap.get(displayName));
    }
}
