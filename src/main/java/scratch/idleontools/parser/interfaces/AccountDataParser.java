package scratch.idleontools.parser.interfaces;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import scratch.idleontools.parser.IdleonParsingContext;

public abstract class AccountDataParser {

    public abstract ImmutableSet<String> getHandledFields();

    public abstract void parseInternal(IdleonParsingContext context);

    public final void parse(IdleonParsingContext context) {
        Preconditions.checkState(context.isInitialized());
        parseInternal(context);
        getHandledFields().forEach(context::markMainFieldHandled);
    }
}
