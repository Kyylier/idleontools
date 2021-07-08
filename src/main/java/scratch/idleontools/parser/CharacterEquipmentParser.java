package scratch.idleontools.parser;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import scratch.idleontools.gamedata.EquipmentArmorSlot;
import scratch.idleontools.gamedata.EquipmentStat;
import scratch.idleontools.gamedata.EquipmentToolSlot;
import scratch.idleontools.model.DataUtil;
import scratch.idleontools.parser.interfaces.CharacterDataParser;

import java.util.Map;
import java.util.stream.Collectors;

public final class CharacterEquipmentParser extends CharacterDataParser {

    public static final String TAG = CharacterEquipmentParser.class.getName();
    public static final String KEY = CharacterEquipmentParser.class.getName();
    public static final String FIELD_NAME_EQUIPPED_ITEMS = "EquipOrder";
    public static final String FIELD_NAME_EQUIPPED_ITEMS_QTY = "EquipQTY";
    public static final String FIELD_NAME_EQUIPMENT_MAP_MODIFIER_ARMOR = "EMm0";
    public static final String FIELD_NAME_EQUIPMENT_MAP_MODIFIER_TOOLS = "EMm1";

    public static final CharacterEquipmentParser INSTANCE = new CharacterEquipmentParser();

    private CharacterEquipmentParser() {}

    @Override
    public ImmutableSet<String> getHandledFields(int characterIdx) {
        return ImmutableSet.of(
                FIELD_NAME_EQUIPPED_ITEMS + "_" + characterIdx,
                FIELD_NAME_EQUIPPED_ITEMS_QTY + "_" + characterIdx,
                FIELD_NAME_EQUIPMENT_MAP_MODIFIER_ARMOR + "_" + characterIdx,
                FIELD_NAME_EQUIPMENT_MAP_MODIFIER_TOOLS + "_" + characterIdx);
    }

    @Override
    public void parseInternal(IdleonParsingContext context, int characterIdx) {
        JsonObject rootDocument = context.getRootDocument();
        JsonObject mainFields = DataUtil.getDocumentMainFields(rootDocument);

        parseEquippedItems(context, mainFields, characterIdx);
        parseEquippedArmorStatModifiers(context, mainFields, characterIdx);
        parseEquippedToolStatModifiers(context, mainFields, characterIdx);
    }

    /** Parses equipped items (armor, tools, and food), and their quantities. */
    private void parseEquippedItems(IdleonParsingContext context, JsonObject mainFields, int characterIdx) {
        JsonArray allEquippedItems = DataUtil.getFieldAsArray(mainFields, FIELD_NAME_EQUIPPED_ITEMS + "_" + characterIdx);
        Preconditions.checkArgument(allEquippedItems.size() == 3);

        JsonArray allEquippedItemsQty = DataUtil.getFieldAsArray(mainFields, FIELD_NAME_EQUIPPED_ITEMS_QTY + "_" + characterIdx);
        Preconditions.checkArgument(allEquippedItemsQty.size() == 3);

        JsonObject equippedArmor = DataUtil.flattenMapValue(allEquippedItems.get(0).getAsJsonObject());
        Map<EquipmentArmorSlot, String> equippedArmorMap = equippedArmor.entrySet().stream().collect(
                Collectors.toUnmodifiableMap(
                        e -> EquipmentArmorSlot.getBySlotId(Integer.parseInt(e.getKey())),
                        e -> e.getValue().getAsJsonObject().get("stringValue").getAsString()));

        JsonObject equippedTools = DataUtil.flattenMapValue(allEquippedItems.get(1).getAsJsonObject());
        Map<EquipmentToolSlot, String> equippedToolsMap = equippedTools.entrySet().stream().collect(
                Collectors.toUnmodifiableMap(
                        e -> EquipmentToolSlot.getBySlotId(Integer.parseInt(e.getKey())),
                        e -> e.getValue().getAsJsonObject().get("stringValue").getAsString()));

        JsonObject equippedFood = DataUtil.flattenMapValue(allEquippedItems.get(2).getAsJsonObject());
        Map<Integer, String> equippedFoodMap = equippedFood.entrySet().stream().collect(
                Collectors.toUnmodifiableMap(
                        e -> Integer.parseInt(e.getKey()),
                        e -> e.getValue().getAsJsonObject().get("stringValue").getAsString()));


        System.out.println(equippedArmorMap);
        System.out.println(equippedToolsMap);
        System.out.println(equippedFoodMap);
    }

    /** Parses stat modifiers for equipped armor. This usually happens due to upgrade stones. */
    private static void parseEquippedArmorStatModifiers(IdleonParsingContext context, JsonObject mainFields, int characterIdx) {
        JsonObject armorStatModifiers = JsonParser
                .parseString(DataUtil.getFieldAsString(
                        mainFields, FIELD_NAME_EQUIPMENT_MAP_MODIFIER_ARMOR + "_" + characterIdx))
                .getAsJsonObject();
        Map<EquipmentArmorSlot, Map<EquipmentStat, Integer>> armorStatModifierMap =
                armorStatModifiers.entrySet().stream().collect(
                        Collectors.toUnmodifiableMap(
                                e1 -> EquipmentArmorSlot.getBySlotId(Integer.parseInt(e1.getKey())),
                                e1 -> e1.getValue().getAsJsonObject().entrySet().stream().collect(
                                        Collectors.toUnmodifiableMap(
                                                e2 -> EquipmentStat.getByName(e2.getKey()),
                                                e2 -> e2.getValue().getAsInt()))));

        context.getResultBuilder().getCharacterBuilder(characterIdx).setEquippedArmorStatModifierMap(armorStatModifierMap);
    }

    /** Parses stat modifiers for equipped tools. This usually happens due to upgrade stones. */
    private void parseEquippedToolStatModifiers(IdleonParsingContext context, JsonObject mainFields, int characterIdx) {
        JsonObject toolStatModifiers = JsonParser
                .parseString(DataUtil.getFieldAsString(
                        mainFields, FIELD_NAME_EQUIPMENT_MAP_MODIFIER_TOOLS + "_" + characterIdx))
                .getAsJsonObject();
        Map<EquipmentToolSlot, Map<EquipmentStat, Integer>> toolStatModifierMap =
                toolStatModifiers.entrySet().stream().collect(
                        Collectors.toUnmodifiableMap(
                                e1 -> EquipmentToolSlot.getBySlotId(Integer.parseInt(e1.getKey())),
                                e1 -> e1.getValue().getAsJsonObject().entrySet().stream().collect(
                                        Collectors.toUnmodifiableMap(
                                                e2 -> EquipmentStat.getByName(e2.getKey()),
                                                e2 -> e2.getValue().getAsInt()))));

        context.getResultBuilder().getCharacterBuilder(characterIdx).setEquippedToolsStatModifiersMap(toolStatModifierMap);
    }
}
