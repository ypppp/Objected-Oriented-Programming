package game;

/**
 * Use this enum class to give `buff` or `debuff`.
 * Created by:
 * @author Riordan D. Alfredo
 */
public enum Status {
    HOSTILE_TO_ENEMY, //player
    HOSTILE_TO_PLAYER, // enemy
    RESPAWNABLE,
    RESTING,
    HAS_AOE_ATTACK_SKILL,
    HAS_SKILL,
    HAS_ATTACK_SKILL,
    IN_COMBAT
}
