package scratch.idleontools.model;

import com.google.common.base.Preconditions;
import scratch.idleontools.gamedatadeprecated.*;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public final class IdleonCharacter {

    private final CharacterClass characterClass;

    private final Map<CharacterStat, Integer> statMap;

    private final double classExp;
    private final double classExpReq;
    private final Map<CharacterSkill, Double> skillExpMap;
    private final Map<CharacterSkill, Double> skillReqExpMap;

    private final Map<CharacterTalent, Integer> talentLevelMap;
    private final Map<CharacterTalent, Integer> talentMaxLevelMap;

    private final Map<EquipmentArmorSlot, Map<EquipmentStat, Integer>> equippedArmorStatModifierMap;
    private final Map<EquipmentToolSlot, Map<EquipmentStat, Integer>> equippedToolsStatModifierMap;

    private final CauldronBubble[] equippedCauldronBubbles;

    private final String afkTarget;
    private final int money;

    private IdleonCharacter(
            CharacterClass characterClass,
            Map<CharacterStat, Integer> statMap,
            Double classExp,
            Double classExpReq,
            Map<CharacterSkill, Double> skillExpMap,
            Map<CharacterSkill, Double> skillReqExpMap,
            Map<CharacterTalent, Integer> talentLevelMap,
            Map<CharacterTalent, Integer> talentMaxLevelMap,
            Map<EquipmentArmorSlot, Map<EquipmentStat, Integer>> equippedArmorStatModifierMap,
            Map<EquipmentToolSlot, Map<EquipmentStat, Integer>> equippedToolsStatModifierMap,
            CauldronBubble[] equippedCauldronBubbles,
            String afkTarget,
            Integer money) {
        this.characterClass = Preconditions.checkNotNull(characterClass);
        this.statMap = Collections.unmodifiableMap(statMap);
        this.classExp = classExp;
        this.classExpReq = classExpReq;
        this.skillExpMap = Collections.unmodifiableMap(skillExpMap);
        this.skillReqExpMap = Collections.unmodifiableMap(skillReqExpMap);
        this.talentLevelMap = Collections.unmodifiableMap(talentLevelMap);
        this.talentMaxLevelMap = Collections.unmodifiableMap(talentMaxLevelMap);
        this.equippedArmorStatModifierMap = Collections.unmodifiableMap(equippedArmorStatModifierMap);
        this.equippedToolsStatModifierMap = Collections.unmodifiableMap(equippedToolsStatModifierMap);
        this.equippedCauldronBubbles = Preconditions.checkNotNull(equippedCauldronBubbles);
        this.afkTarget = Preconditions.checkNotNull(afkTarget);
        this.money = money;
    }

    @Override
    public String toString() {
        return "IdleonCharacter{" +
                "characterClass=" + characterClass +
                ",\n  statMap=" + statMap +
                ",\n  classExp=" + classExp +
                ",\n  classExpReq=" + classExpReq +
                ",\n  skillExpMap=" + skillExpMap +
                ",\n  skillReqExpMap=" + skillReqExpMap +
                ",\n  talentLevelMap=" + talentLevelMap +
                ",\n  talentMaxLevelMap=" + talentMaxLevelMap +
                ",\n  equippedCauldronBubbles=" + Arrays.toString(equippedCauldronBubbles) +
                ",\n  afkTarget='" + afkTarget + '\'' +
                ",\n  money=" + money +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private CharacterClass characterClass;
        private Map<CharacterStat, Integer> statMap;
        private Double classExp;
        private Double classExpReq;
        private Map<CharacterSkill, Double> skillExpMap;
        private Map<CharacterSkill, Double> skillReqExpMap;
        private Map<CharacterTalent, Integer> talentLevelMap;
        private Map<CharacterTalent, Integer> talentMaxLevelMap;
        private Map<EquipmentArmorSlot, Map<EquipmentStat, Integer>> equippedArmorStatModifierMap;
        private Map<EquipmentToolSlot, Map<EquipmentStat, Integer>> equippedToolsStatModifierMap;
        private CauldronBubble[] equippedCauldronBubbles;
        private String afkTarget;
        private Integer money;

        private Builder() {}

        public Builder setCharacterClass(CharacterClass characterClass) {
            this.characterClass = characterClass;
            return this;
        }

        public Builder setStatMap(Map<CharacterStat, Integer> statMap) {
            this.statMap = statMap;
            return this;
        }

        public Builder setClassExp(double classExp, double classExpReq) {
            this.classExp = classExp;
            this.classExpReq = classExpReq;
            return this;
        }

        public Builder setSkillExpMaps(Map<CharacterSkill, Double> skillExpMap, Map<CharacterSkill, Double> skillReqExpMap) {
            this.skillExpMap = skillExpMap;
            this.skillReqExpMap = skillReqExpMap;
            return this;
        }

        public Builder setTalentLevelMaps(Map<CharacterTalent, Integer> talentLevelMap, Map<CharacterTalent, Integer> talentMaxLevelMap) {
            this.talentLevelMap = talentLevelMap;
            this.talentMaxLevelMap = talentMaxLevelMap;
            return this;
        }

        public Builder setEquippedArmorStatModifierMap(Map<EquipmentArmorSlot, Map<EquipmentStat, Integer>> equippedArmorStatModifierMap) {
            this.equippedArmorStatModifierMap = equippedArmorStatModifierMap;
            return this;
        }

        public Builder setEquippedToolsStatModifiersMap(Map<EquipmentToolSlot, Map<EquipmentStat, Integer>> equippedToolsStatModifierMap) {
            this.equippedToolsStatModifierMap = equippedToolsStatModifierMap;
            return this;
        }

        public Builder setEquippedCauldronBubbles(
                @Nullable CauldronBubble first,
                @Nullable CauldronBubble second,
                @Nullable CauldronBubble third) {
            Preconditions.checkArgument(first == null || first.isActive);
            Preconditions.checkArgument(second == null || second.isActive);
            Preconditions.checkArgument(third == null || third.isActive);
            this.equippedCauldronBubbles = new CauldronBubble[] {first, second, third};
            return this;
        }

        public Builder setAfkTarget(String afkTarget) {
            this.afkTarget = afkTarget;
            return this;
        }

        public Builder setMoney(int money) {
            this.money = money;
            return this;
        }

        public IdleonCharacter build() {
            return new IdleonCharacter(
                    characterClass,
                    statMap,
                    classExp,
                    classExpReq,
                    skillExpMap,
                    skillReqExpMap,
                    talentLevelMap,
                    talentMaxLevelMap,
                    equippedArmorStatModifierMap,
                    equippedToolsStatModifierMap,
                    equippedCauldronBubbles,
                    afkTarget,
                    money);
        }
    }
}
