package nl.edm_programming.voodoo;

import nl.edm_programming.voodoo.Models.Global;
import nl.edm_programming.voodoo.Models.Hex;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Random;

public class Voodoo {

    public void Transplace(Player caster){
        //Retrieve the other Hex
        Player target = getTarget(caster);

        //Retrieve Locations
        Location targetLocation = target.getLocation();
        Location casterLocation = caster.getLocation();

        //Switch locations
        target.teleport(casterLocation);
        caster.teleport(targetLocation);
    }

    public void Famine(Player caster){
        //Retrieve the other Hex
        Player target = getTarget(caster);

        target.setFoodLevel(0);
    }

    public void Cripple(Player caster){
        //Retrieve the other Hex
        Player target = getTarget(caster);

        target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,1200,0));
    }

    public void ForceForward(Player caster){
        //Retrieve the other Hex
        Player target = getTarget(caster);

        Vector vector = target.getLocation().getDirection().multiply(2.0D);
        vector.setY(0.5);

        target.setVelocity(vector);
    }

    public void ForceBackward(Player caster){
        Player target = getTarget(caster);

        Vector vector = target.getLocation().getDirection().multiply(-2.0D);
        vector.setY(0.5);

        target.setVelocity(vector);
    }

    public void Crumble(Player caster,String ItemName){
        //Retrieve the other Hex
        Player target = getTarget(caster);

        //Acquire the ItemStack, if it exists
        ItemStack targetStack = null;
        for(ItemStack i : target.getInventory()){
            if(i == null) continue;
            if(i.getType() == Material.AIR) continue;
            if(i.getItemMeta().hasDisplayName() && ItemName.equals(i.getType().name())) continue;

            if(i.getItemMeta().getLocalizedName().equals(ItemName) || i.getItemMeta().getDisplayName().equals(ItemName) || i.getType().name().equals(ItemName.toUpperCase())){
                targetStack = i;
                break;
            }
        }

        //Return if null
        if(targetStack == null) {
            caster.sendMessage(ChatColor.DARK_PURPLE + "You sense the Voodoo had no effect.");
            return;
        }

        //Crumble item
        int amount = targetStack.getAmount();
        target.getInventory().removeItem(targetStack);
        if (amount > 1) {
            targetStack.setAmount(amount - 1);
            target.getInventory().addItem(targetStack);
        }
    }

    public void SummonC(Player caster){
        //Retrieve the other Hex
        Player target = getTarget(caster);

        target.getWorld().spawnEntity(target.getLocation(), EntityType.CREEPER);
    }

    public void SummonS(Player caster){
        //Retrieve the other Hex
        Player target = getTarget(caster);

        target.getWorld().spawnEntity(target.getLocation(), EntityType.SKELETON);
    }

    public void SummonZ(Player caster){
        //Retrieve the other Hex
        Player target = getTarget(caster);

        target.getWorld().spawnEntity(target.getLocation(), EntityType.ZOMBIE);
    }

    public void Rewind(Player caster){
        //Retrieve the other Hex
        Player target = getTarget(caster);

        target.teleport(target.getWorld().getSpawnLocation());
    }

    public void Grasp(Player caster){
        //Retrieve the other Hex
        Player target = getTarget(caster);

        //Loop through all items and only filter the not empty ones
        ArrayList<ItemStack> itemStacks = new ArrayList<>();
        for(ItemStack i : target.getInventory()) {
            if (i == null) continue;
            if (i.getType() == Material.AIR) continue;

            itemStacks.add(i);
        }

        //Select random item
        Random random = new Random();
        int iNum = random.nextInt(itemStacks.size());
        ItemStack stackToSteal = itemStacks.get(iNum);

        //Remove from target inventory
        target.getInventory().removeItem(stackToSteal);
        if(stackToSteal.getAmount() > 1){
            stackToSteal.setAmount(stackToSteal.getAmount() - 1);
            target.getInventory().addItem(stackToSteal);
        }

        //Add to Caster inventory
        stackToSteal.setAmount(1);
        caster.getInventory().addItem(stackToSteal);
    }

    public void Steal(Player caster){
        //Retrieve the other Hex
        Player target = getTarget(caster);

        //Locate item in target hand
        ItemStack stealItem = target.getInventory().getItemInMainHand();

        //Check if it exists
        if(stealItem.getType() != Material.AIR){

            //If only 1, remove the item, else subtract 1 and update
            if(stealItem.getAmount() > 1){
                stealItem.setAmount(stealItem.getAmount() - 1);
                target.getInventory().setItemInMainHand(stealItem);
            }
            else{
                target.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
            }

            //Add to casters inventory
            stealItem.setAmount(1);
            caster.getWorld().dropItemNaturally(caster.getLocation(),stealItem);
        }
        else{
            caster.sendMessage(ChatColor.DARK_PURPLE + "You sense the Voodoo had no effect.");
        }
    }

    public void SummonB(Player caster){
        //Retrieve the other Hex
        Player target = getTarget(caster);

        target.getWorld().spawnEntity(target.getLocation(), EntityType.BLAZE);
    }

    public void Crush(Player caster){
        //Retrieve the other Hex
        Player target = getTarget(caster);

        Location targetLocation = target.getLocation();
        targetLocation.setY(targetLocation.getY() + 10);

        target.getWorld().getBlockAt(targetLocation).setType(Material.ANVIL);
    }

    public void Fall(Player caster){
        //Retrieve the other Hex
        Player target = getTarget(caster);

        Location targetLocation = target.getLocation();
        targetLocation.setY(target.getLocation().getY() - 1);
        Location tpLocation = target.getWorld().getBlockAt(targetLocation).getLocation();
        tpLocation.setDirection(targetLocation.getDirection());
        tpLocation.setY(targetLocation.getY());

        if(target.getWorld().getBlockAt(targetLocation).getType().equals(Material.BEDROCK)){ caster.sendMessage(ChatColor.DARK_PURPLE + "Your magic cannot pierce this block."); return;}
        target.getWorld().getBlockAt(targetLocation).setType(Material.AIR);

        target.teleport(tpLocation);
    }

    public void Panic(Player caster){
        //Retrieve the other Hex
        Player target = getTarget(caster);

        ItemStack[] items = target.getInventory().getContents();
        for(ItemStack item : items){

            if(item == null) continue;
            if(item.getType() == Material.AIR) continue;

            target.getInventory().removeItem(item);
            Item itemDropped = target.getWorld().dropItemNaturally(target.getLocation(), item);
            itemDropped.setPickupDelay(40);
        }
    }

    public void SummonArmy(Player caster){
        //Retrieve the other Hex
        Player target = getTarget(caster);

        Location targetLocation = target.getLocation();

        target.getWorld().spawnEntity(targetLocation,Util.generateRandomMobs());
        target.getWorld().spawnEntity(targetLocation,Util.generateRandomMobs());
        target.getWorld().spawnEntity(targetLocation,Util.generateRandomMobs());
    }

    public void Degrade(Player caster){
        //Retrieve the other Hex
        Player target = getTarget(caster);

        ArrayList<Material> equipment = new ArrayList<>();

        //Check boots
        ItemStack boots = target.getInventory().getBoots();
        if(boots != null) equipment.add(Material.IRON_BOOTS);

        //Check Leggings
        ItemStack leggings = target.getInventory().getLeggings();
        if(leggings != null) equipment.add(Material.IRON_LEGGINGS);

        //Check Chestplate
        ItemStack chestplate = target.getInventory().getChestplate();
        if(chestplate != null) equipment.add(Material.IRON_CHESTPLATE);

        //Check Helmet
        ItemStack helmet = target.getInventory().getHelmet();
        if(helmet != null) equipment.add(Material.IRON_HELMET);

        //Check if any equips equipped
        if(equipment.size() == 0){
            caster.sendMessage(ChatColor.DARK_PURPLE + "You sense the Voodoo had no effect.");
            return;
        }

        //Choose random equip
        Random random = new Random();
        int num = random.nextInt(equipment.size());
        Material itemToDestroy = equipment.get(num);

        //Break equip
        if(itemToDestroy.equals(Material.IRON_HELMET)){
            target.getInventory().setHelmet(new ItemStack(Material.AIR));
        }else if(itemToDestroy.equals(Material.IRON_CHESTPLATE)){
            target.getInventory().setChestplate(new ItemStack(Material.AIR));
        }
        else if(itemToDestroy.equals(Material.IRON_BOOTS)){
            target.getInventory().setBoots(new ItemStack(Material.AIR));
        }
        else if(itemToDestroy.equals(Material.IRON_LEGGINGS)){

        }target.getInventory().setLeggings(new ItemStack(Material.AIR));

        target.playSound(target.getLocation(), Sound.ENTITY_ITEM_BREAK,1,1);
    }

    public void Sink(Player caster){
        //Retrieve the other Hex
        Player target = getTarget(caster);

        Location targetLocation = target.getLocation();
        target.getWorld().getBlockAt(targetLocation).setType(Material.WATER);
    }

    public void Ward(Player caster){
        caster.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION,60,10));
    }

    private Player getTarget(Player Caster){
        if(Global.debug) return Caster;

        Hex tempHex = Global.Hexes.get(0);
        Player target;
        if(tempHex.getUUID().equals(Caster.getUniqueId())) target = Bukkit.getPlayer(Global.Hexes.get(1).getUUID());
        else target = Bukkit.getPlayer(Global.Hexes.get(0).getUUID());
        return target;
    }
}
