package nl.edm_programming.voodoo.listeners;

import nl.edm_programming.voodoo.Models.Global;
import nl.edm_programming.voodoo.Voodoo;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.Sound.ENTITY_LIGHTNING_BOLT_IMPACT;
import static org.bukkit.event.block.Action.RIGHT_CLICK_AIR;
import static org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK;


public class EventListener implements Listener{

    private Voodoo voodoo;

    public EventListener(Voodoo voodoo) {
        super();
        this.voodoo = voodoo;
    }

    @EventHandler
    public void HexDamaged(EntityDamageByEntityEvent event){
        Entity entity = event.getEntity();
        Entity culprit = event.getDamager();
        if(entity instanceof Player){
            if(Global.Hexes.stream().anyMatch(h -> h.getUUID().equals(entity.getUniqueId()))){
                if(Global.Hexes.stream().anyMatch(h -> h.getUUID().equals(culprit.getUniqueId()))){
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void HexLeave(PlayerQuitEvent event){
        if(Global.Hexes.stream().anyMatch(h -> h.getUUID().equals(event.getPlayer().getUniqueId()))){
            Global.started = false;
            Bukkit.getOnlinePlayers().forEach(p -> p.playSound(p.getLocation(),ENTITY_LIGHTNING_BOLT_IMPACT,1.0f,1.0f));
            Bukkit.broadcastMessage(ChatColor.GREEN + event.getPlayer().getDisplayName() + " fled like the coward he is. The match is cancelled!");
        }
    }

    @EventHandler
    public void CheckVoodoo(PlayerInteractEvent event){

        boolean isVoodooItem = false;

        //Check if match started
        if(!Global.started) return;

        //Check if Player is a hex
        if(Global.Hexes.stream().noneMatch(h -> h.getUUID().equals(event.getPlayer().getUniqueId())))return;

        /// Check if item is a Voodoo item
        // Check if holding item
        if(event.getItem() == null) return;

        //Check if item is paper
        if(!event.getItem().getType().equals(Material.PAPER)) return;
        //Check if Click action is right click
        if(!(event.getAction().equals(RIGHT_CLICK_AIR) || event.getAction().equals(RIGHT_CLICK_BLOCK))) return;

        //Check which Voodoo item is used
        if(event.getItem().getItemMeta().getLocalizedName().isEmpty() && !event.getItem().getItemMeta().getDisplayName().isEmpty()) event.getPlayer().sendMessage(ChatColor.RED + "Yeah nice try.");
        String name = event.getItem().getItemMeta().getLocalizedName();
        name = name.replace(ChatColor.DARK_PURPLE.toString(),"");
        switch (name){
            case "test":
                Bukkit.broadcastMessage("Check!");
                isVoodooItem = true;
                break;
            case "Transplace":
                Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getPlayer().getDisplayName() + " used [Transplace]");
                voodoo.Transplace(event.getPlayer());
                isVoodooItem = true;
                break;
            case "Famine":
                Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getPlayer().getDisplayName() + " used [Famine]");
                voodoo.Famine(event.getPlayer());
                isVoodooItem = true;
                break;
            case "Cripple":
                Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getPlayer().getDisplayName() + " used [Cripple]");
                voodoo.Cripple(event.getPlayer());
                isVoodooItem = true;
                break;
            case "Force Forward":
                Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getPlayer().getDisplayName() + " used [Force Forward]");
                voodoo.ForceForward(event.getPlayer());
                isVoodooItem = true;
                break;
            case "Force Backward":
                Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getPlayer().getDisplayName() + " used [Force Backward]");
                voodoo.ForceBackward(event.getPlayer());
                isVoodooItem = true;
                break;
            case "Summon Skeleton":
                Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getPlayer().getDisplayName() + " used [Summon Skeleton]");
                voodoo.SummonS(event.getPlayer());
                isVoodooItem = true;
                break;
            case "Summon Creeper":
                Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getPlayer().getDisplayName() + " used [Summon Creeper]");
                voodoo.SummonC(event.getPlayer());
                isVoodooItem = true;
                break;
            case "Summon Zombie":
                Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getPlayer().getDisplayName() + " used [Summon Zombie]");
                voodoo.SummonZ(event.getPlayer());
                isVoodooItem = true;
                break;
            case "Rewind":
                Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getPlayer().getDisplayName() + " used [Rewind]");
                voodoo.Rewind(event.getPlayer());
                isVoodooItem = true;
                break;
            case "Grasp":
                Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getPlayer().getDisplayName() + " used [Grasp]");
                voodoo.Grasp(event.getPlayer());
                isVoodooItem = true;
                break;
            case "Steal":
                Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getPlayer().getDisplayName() + " used [Steal]");
                voodoo.Steal(event.getPlayer());
                isVoodooItem = true;
                break;
            case "Summon Blaze":
                Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getPlayer().getDisplayName() + " used [Summon Blaze]");
                voodoo.SummonB(event.getPlayer());
                isVoodooItem = true;
                break;
            case "Crush":
                Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getPlayer().getDisplayName() + " used [Crush]");
                voodoo.Crush(event.getPlayer());
                isVoodooItem = true;
                break;
            case "Fall":
                Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getPlayer().getDisplayName() + " used [Fall]");
                voodoo.Fall(event.getPlayer());
                isVoodooItem = true;
                break;
            case "Panic":
                Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getPlayer().getDisplayName() + " used [Panic]");
                voodoo.Panic(event.getPlayer());
                isVoodooItem = true;
                break;
            case "Summon Army":
                Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getPlayer().getDisplayName() + " used [Summon Army]");
                voodoo.SummonArmy(event.getPlayer());
                isVoodooItem = true;
                break;
            case "Degrade":
                Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getPlayer().getDisplayName() + " used [Degrade]");
                voodoo.Degrade(event.getPlayer());
                isVoodooItem = true;
                break;
            case "Sink":
                Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getPlayer().getDisplayName() + " used [Sink]");
                voodoo.Sink(event.getPlayer());
                isVoodooItem = true;
                break;
            case "Ward":
                Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getPlayer().getDisplayName() + " used [Ward]");
                voodoo.Ward(event.getPlayer());
                isVoodooItem = true;
                break;
        }
        //Special case for the Crumble Voodoo, Since it is bound to an item
        if(name.contains("Crumble")){
            Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + event.getPlayer().getDisplayName() + " used [" + name + "]");

            //Retrieve item to Crumble
            String itemName = name.substring(8);

            voodoo.Crumble(event.getPlayer(),itemName);
            isVoodooItem = true;
        }

        if(isVoodooItem) {
            //Make cool partice effects
            event.getPlayer().getWorld().playEffect(event.getPlayer().getLocation(),Effect.ENDER_SIGNAL,10);

            //Remove Voodoo Item
            ItemStack hand = event.getPlayer().getInventory().getItemInMainHand();
            int amount = hand.getAmount();
            if (amount > 1) {
                hand.setAmount(amount - 1);
                event.getPlayer().getInventory().setItemInMainHand(hand);
            } else {
                event.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
            }
            event.setCancelled(true);
        }
    }

}
