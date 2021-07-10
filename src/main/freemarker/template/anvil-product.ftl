package scratch.idleontools.gamedata;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** Enumeration of all Anvil products (i.e. those in the "Produce" tab). */
@Generated(
        value = "Generated with FreeMarker (version ${.version}) using template ${.current_template_name}.",
        date = "${.now}"
)
public enum ${javaClassName} {

    <#list monstersMap as monsterEnumName, monsterProps>${monsterEnumName}("${monsterProps.codeName}", "${monsterProps.Name}", "${monsterProps.AFKtype}", ${monsterProps.RespawnTime?c}, ${monsterProps.MonsterHPTotal?c}, ${monsterProps.ExpGiven?c}, ${monsterProps.Defence?c}, ${monsterProps.Damages[0]?c})<#sep>,
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
    public final String afkType;
    public final int respawnTime;
    public final int monsterHpTotal;
    public final int expGiven;
    public final int defence;
    public final int damage;

${javaClassName}(
            <#list lookupMaps as lookupMap>
                ${lookupMap.fieldTypeName} ${lookupMap.fieldName},
            </#list>
        String afkType,
        int respawnTime,
        int monsterHpTotal,
        int expGiven,
        int defence,
        int damage) {
        <#list lookupMaps as lookupMap>
        this.${lookupMap.fieldName} = ${lookupMap.fieldName};
        </#list>
        this.afkType = afkType;
        this.respawnTime = respawnTime;
        this.monsterHpTotal = monsterHpTotal;
        this.expGiven = expGiven;
        this.defence = defence;
        this.damage = damage;
        }

<#list lookupMaps as lookupMap>
    public static ${javaClassName} ${lookupMap.lookupMethodName}(${lookupMap.fieldTypeName} ${lookupMap.fieldName}) {
        return Objects.requireNonNull(${lookupMap.fieldName}To${javaClassName}Map.get(${lookupMap.fieldName}));
    }
</#list>
}
