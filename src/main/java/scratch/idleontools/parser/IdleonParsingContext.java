package scratch.idleontools.parser;

import com.google.common.base.Preconditions;
import com.google.gson.JsonObject;
import scratch.idleontools.model.DataUtil;
import scratch.idleontools.model.IdleonAccount;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public final class IdleonParsingContext {

    private static final String TAG = IdleonParsingContext.class.getName();

    private final JsonObject firebaseDocument;

    private boolean initialized = false;

    private Set<String> allFields;
    private HashSet<String> unhandledFields;
    private Integer numCharacters;
    private IdleonAccount.Builder resultBuilder;

    public IdleonParsingContext(JsonObject firebaseDocument) {
        this.firebaseDocument = firebaseDocument;
    }

    public void initialize() {
        Preconditions.checkState(!this.initialized);
        this.allFields = Collections.unmodifiableSet(DataUtil.getDocumentMainFields(firebaseDocument).keySet());
        this.unhandledFields = new HashSet<>(this.allFields);

        this.numCharacters = countCharacters();
        Logger.getLogger(TAG).info("Found %d characters.".formatted(this.numCharacters));

        this.resultBuilder = IdleonAccount.builder(this.numCharacters);
        this.initialized = true;
    }

    public boolean isInitialized() {
        return this.initialized;
    }

    public JsonObject getRootDocument() {
        return firebaseDocument;
    }

    public Integer getNumCharacters() {
        return  numCharacters;
    }

    public IdleonAccount.Builder getResultBuilder() {
        return resultBuilder;
    }

    public void markMainFieldHandled(String field) {
        this.unhandledFields.remove(field);
    }

    public List<String> getUnhandledMainFields() {
        return unhandledFields.stream().sorted().toList();
    }

    public IdleonAccount getResult() {
        return resultBuilder.build();
    }

    private Integer countCharacters() {
        int num = 0;
        while (this.allFields.contains("CharacterClass_" + num)) {
            num++;
        }
        return num;
    }
}
