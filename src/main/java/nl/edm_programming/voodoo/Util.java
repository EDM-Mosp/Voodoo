package nl.edm_programming.voodoo;

import org.bukkit.entity.EntityType;
import java.util.Random;


public class Util {

    public static EntityType generateRandomMobs(){
        Random random = new Random();
        int i = random.nextInt(31);
        EntityType mob;
        switch (i) {
            case 1:
                mob = EntityType.ZOMBIE;
                break;
            case 2:
                mob = EntityType.SKELETON;
                break;
            case 3:
                mob = EntityType.CREEPER;
                break;
            case 4:
                mob = EntityType.WITCH;
                break;
            case 5:
                mob = EntityType.WITHER_SKELETON;
                break;
            case 6:
                mob = EntityType.CHICKEN;
                break;
            case 7:
                mob = EntityType.PIG;
                break;
            case 8:
                mob = EntityType.COW;
                break;
            case 9:
                mob = EntityType.MUSHROOM_COW;
                break;
            case 10:
                mob = EntityType.COD;
                break;
            case 11:
                mob = EntityType.BEE;
                break;
            case 12:
                mob = EntityType.BAT;
                break;
            case 13:
                mob = EntityType.CAVE_SPIDER;
                break;
            case 14:
                mob = EntityType.DOLPHIN;
                break;
            case 15:
                mob = EntityType.DROWNED;
                break;
            case 16:
                mob = EntityType.GUARDIAN;
                break;
            case 17:
                mob = EntityType.ELDER_GUARDIAN;
                break;
            case 18:
                mob = EntityType.ENDERMAN;
                break;
            case 19:
                mob = EntityType.ENDERMITE;
                break;
            case 20:
                mob = EntityType.DOLPHIN;
                break;
            case 21:
                mob = EntityType.BLAZE;
                break;
            case 22:
                mob = EntityType.GHAST;
                break;
            case 23:
                mob = EntityType.ILLUSIONER;
                break;
            case 24:
                mob = EntityType.WOLF;
                break;
            case 25:
                mob = EntityType.SLIME;
                break;
            case 26:
                mob = EntityType.PILLAGER;
                break;
            case 27:
                mob = EntityType.RAVAGER;
                break;
            case 28:
                mob = EntityType.VEX;
                break;
            case 29:
                mob = EntityType.SQUID;
                break;
            case 30:
                mob = EntityType.POLAR_BEAR;
                break;
            case 31:
                mob = EntityType.PANDA;
                break;
            default:
                    mob = EntityType.ZOMBIE;
        }
        return mob;
    }
}
