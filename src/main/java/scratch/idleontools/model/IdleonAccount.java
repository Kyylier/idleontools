package scratch.idleontools.model;

import com.google.common.base.Preconditions;
import scratch.idleontools.gamedatadeprecated.Cauldron;
import scratch.idleontools.gamedatadeprecated.CauldronBubble;
import scratch.idleontools.gamedatadeprecated.CauldronUpgrade;
import scratch.idleontools.gamedatadeprecated.CauldronVial;

import java.util.*;

public final class IdleonAccount {

    private final int bankMoney;
    private final AnvilRecipeStatus anvilRecipeStatus;

    private final Map<Cauldron, Double> cauldronExpMap;
    private final Map<CauldronBubble, Integer> cauldronBubbleLevelsMap;
    private final Map<CauldronVial, Integer> cauldronVialLevelsMap;
    private final Map<Cauldron, Map<CauldronUpgrade, Integer>> cauldronUpgradeLevelsMap;
    private final int[] talentPointsFromCauldronLiquidShop;

    private final IdleonCharacter[] characters;

    public IdleonAccount(
            Integer bankMoney,
            AnvilRecipeStatus anvilRecipeStatus,
            Map<Cauldron, Double> cauldronExpMap,
            Map<CauldronBubble, Integer> cauldronBubbleLevelsMap,
            Map<CauldronVial, Integer> cauldronVialLevelsMap,
            Map<Cauldron, Map<CauldronUpgrade, Integer>> cauldronUpgradeLevelsMap,
            int[] talentPointsFromCauldronLiquidShop,
            IdleonCharacter[] characters) {
        this.bankMoney = bankMoney;
        this.anvilRecipeStatus = Preconditions.checkNotNull(anvilRecipeStatus);
        this.cauldronExpMap = Collections.unmodifiableMap(cauldronExpMap);
        this.cauldronBubbleLevelsMap = Collections.unmodifiableMap(cauldronBubbleLevelsMap);
        this.cauldronVialLevelsMap = Collections.unmodifiableMap(cauldronVialLevelsMap);
        this.cauldronUpgradeLevelsMap = Collections.unmodifiableMap(cauldronUpgradeLevelsMap);
        this.talentPointsFromCauldronLiquidShop = Preconditions.checkNotNull(talentPointsFromCauldronLiquidShop);
        for (IdleonCharacter character : characters) {
            Preconditions.checkNotNull(character);
        }
        this.characters = Preconditions.checkNotNull(characters);
    }

    public int getBankMoney() {
        return bankMoney;
    }

    public AnvilRecipeStatus getAnvilRecipeStatus() {
        return anvilRecipeStatus;
    }

    public List<IdleonCharacter> getCharacters() {
        return List.of(characters);
    }

    public static Builder builder(int numCharacters) {
        return new Builder(numCharacters);
    }

    public static class Builder {

        private final IdleonCharacter.Builder[] characters;

        private Integer bankMoney;
        private AnvilRecipeStatus anvilRecipeStatus;
        private Map<Cauldron, Double> cauldronExpMap;
        private Map<CauldronBubble, Integer> cauldronBubbleLevelsMap;
        private Map<CauldronVial, Integer> cauldronVialLevelsMap;
        private Map<Cauldron, Map<CauldronUpgrade, Integer>> cauldronUpgradeLevelsMap;
        private int[] talentPointsFromCauldronLiquidShop ;

        private Builder(int numCharacters) {
            this.characters = new IdleonCharacter.Builder[numCharacters];
        }

        public Builder setBankMoney(Integer bankMoney) {
            this.bankMoney = bankMoney;
            return this;
        }

        public Builder setAnvilCraftStatus(AnvilRecipeStatus anvilRecipeStatus) {
            this.anvilRecipeStatus = anvilRecipeStatus;
            return this;
        }

        public Builder setCauldronInfo(
                Map<Cauldron, Double> cauldronExpMap,
                Map<CauldronBubble, Integer> cauldronBubbleLevelsMap,
                Map<CauldronVial, Integer> cauldronVialLevelsMap) {
            this.cauldronExpMap = cauldronExpMap;
            this.cauldronBubbleLevelsMap = cauldronBubbleLevelsMap;
            this.cauldronVialLevelsMap = cauldronVialLevelsMap;
            return this;
        }

        public Builder setCauldronUpgradeLevelsMap(Map<Cauldron, Map<CauldronUpgrade, Integer>> cauldronUpgradeLevelsMap) {
            this.cauldronUpgradeLevelsMap = cauldronUpgradeLevelsMap;
            return this;
        }

        public Builder setTalentPointsFromCauldronLiquidShop(int[] talentPointsFromCauldronLiquidShop) {
            this.talentPointsFromCauldronLiquidShop = talentPointsFromCauldronLiquidShop;
            return this;
        }

        public IdleonCharacter.Builder getCharacterBuilder(int characterIdx) {
            if (characters[characterIdx] == null) {
                characters[characterIdx] = IdleonCharacter.builder();
            }
            return characters[characterIdx];
        }

        public IdleonAccount build() {
            return new IdleonAccount(
                    bankMoney,
                    anvilRecipeStatus,
                    cauldronExpMap,
                    cauldronBubbleLevelsMap,
                    cauldronVialLevelsMap,
                    cauldronUpgradeLevelsMap,
                    talentPointsFromCauldronLiquidShop,
                    Arrays.stream(characters).map(IdleonCharacter.Builder::build).toArray(IdleonCharacter[]::new));
        }
    }
}
