package scratch.idleontools.gamedata;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** Enumeration of all character classes. */
@Generated(
    value = "Generated with FreeMarker (version ${.version}) using template ${.current_template_name}.",
    date = "${.now}"
)
public enum ${javaClassName} {

    <#list classNames as characterClass>${characterClass}(${classIds[characterClass?index]}, "${classSpecializeSkills[classIds[characterClass?index]]}")<#sep>,
    </#sep></#list>;
    <#if lookupMaps?size gt 0 >

    <#list lookupMaps as lookupMap>
    private static final Map<${lookupMap.mapKeyTypeName}, ${javaClassName}> ${lookupMap.fieldName}To${javaClassName}Map = new HashMap<>();
    </#list>
    </#if>
    <#if hasStaticInitialization>

    static {
        <#list lookupMaps as lookupMap>
        Arrays.stream(${javaClassName}.values()).forEach(${javaClassNameAsParam} -> ${lookupMap.fieldName}To${javaClassName}Map.put(${javaClassNameAsParam}.${lookupMap.fieldName}, ${javaClassNameAsParam}));
        </#list>
    }
    </#if>
    <#if lookupMaps?size gt 0 >

    <#list lookupMaps as lookupMap>
    public final ${lookupMap.fieldTypeName} ${lookupMap.fieldName};
    </#list>
    </#if>
    public final String classSpecializeSkill;

    ${javaClassName}(<#list lookupMaps as lookupMap>${lookupMap.fieldTypeName} ${lookupMap.fieldName}<#sep>,</#sep></#list>, String classSpecializeSkill) {
        <#list lookupMaps as lookupMap>
        this.${lookupMap.fieldName} = ${lookupMap.fieldName};
        </#list>
        this.classSpecializeSkill = classSpecializeSkill;
    }

    <#list lookupMaps as lookupMap>
    public static ${javaClassName} ${lookupMap.lookupMethodName}(${lookupMap.fieldTypeName} ${lookupMap.fieldName}) {
        return Objects.requireNonNull(${lookupMap.fieldName}To${javaClassName}Map.get(${lookupMap.fieldName}));
    }
    </#list>
}
