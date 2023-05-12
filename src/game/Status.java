package game;

/**
 * Use this enum class to give `buff` or `debuff`.
 * Created by:
 * @author Riordan D. Alfredo
 */
public enum Status {
    /**
     * Player identity
     */
    HOSTILE_TO_ENEMY, //player
    /**
     * Enemy identity
     */
    HOSTILE_TO_PLAYER, // enemy

    /**
     * Actor that can respawn
     */
    RESPAWNABLE,

    /**
     * Resting
     */
    RESTING,

    /**
     * Has an aoe attack skill
     */
    HAS_AOE_ATTACK_SKILL,

    /**
     * Has skill
     */
    HAS_SKILL,

    /**
     * Has an attack skill
     */
    HAS_ATTACK_SKILL,

    /**
     * Can sell
     */
    SELLABLE,

    /**
     * In combat
     */
    IN_COMBAT,

    /**
     * Can drop runes
     */
    CAN_DROP_RUNES,

    /**
     * Can reset
     */
    RESET,

    /**
     * Heal
     */
    HEAL,
    /**
     * Can exchange
     */
    EXCHANGEABLE,
    /**
     * Can have golden runes
     */
    CAN_HAVE_GOLDEN_RUNES,
    /**
     * Is in inventory
     */
    IN_INVENTORY,

    /**
     * Is cursed
     */
    CURSED,
    /**
     * Can purchase
     */
    PURCHASABLE,

    /**
     * Is a boss
     */
    BOSS

}
