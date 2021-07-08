package scratch.idleontools.parser.interfaces;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import scratch.idleontools.parser.IdleonParsingContext;

public abstract class CharacterDataParser {

    public abstract ImmutableSet<String> getHandledFields(int characterIdx);

    public abstract void parseInternal(IdleonParsingContext context, int characterIdx);

    public final void parse(IdleonParsingContext context, int characterIdx) {
        Preconditions.checkState(context.isInitialized());
        parseInternal(context, characterIdx);
        getHandledFields(characterIdx).forEach(context::markMainFieldHandled);
    }
}
