package scratch.idleontools.model;

import com.google.common.collect.ImmutableSet;
import scratch.idleontools.gamedata.AnvilRecipe;

import java.util.Set;

/** Anvil crafting unlocks. */
public final class AnvilRecipeStatus {

    public final ImmutableSet<AnvilRecipe> unlocked;
    public final ImmutableSet<AnvilRecipe> locked;

    public AnvilRecipeStatus(Set<AnvilRecipe> unlocked, Set<AnvilRecipe> locked) {
        this.unlocked = ImmutableSet.copyOf(unlocked);
        this.locked = ImmutableSet.copyOf(locked);
    }
}
