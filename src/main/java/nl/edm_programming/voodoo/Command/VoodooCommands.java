package nl.edm_programming.voodoo.Command;

import nl.edm_programming.voodoo.Models.Global;
import nl.edm_programming.voodoo.Models.Hex;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

import static org.bukkit.Sound.ENTITY_LIGHTNING_BOLT_IMPACT;

public class VoodooCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (command.getName().toLowerCase().equals("voodoo")) {
            if (args.length > 1) {
                if (args[0].toLowerCase().equals("add")) {
                    addHex(args[1]);
                    sender.sendMessage(ChatColor.GREEN + "Player Added");
                    return true;
                } else if (args[0].toLowerCase().equals("remove")) {
                    RemoveHex(args[1]);
                    sender.sendMessage(ChatColor.GREEN + "Player Removed");
                    return true;
                }
            }else if(args[0].toLowerCase().equals("list")){
                sender.sendMessage("Current: ");
                Global.Hexes.stream().forEach(p -> sender.sendMessage(Bukkit.getPlayer(p.getUUID()).getDisplayName()));
                return true;
            }
            else if(args[0].toLowerCase().equals("start")){
                StartMatch(sender);
                return true;
            }
            else if(args[0].toLowerCase().equals("stop")){
                StopMatch();
                return true;
            }
            else if(args[0].toLowerCase().equals("debug")){
                Global.debug = true;
                sender.sendMessage(ChatColor.YELLOW + "Debug mode enabled");
                return true;
            }
            else if(args[0].toLowerCase().equals("crumble")){
                generateCrumbleVoodoo(sender);
                return true;
            }
        } else if(command.getName().toLowerCase().equals("crumble")){
            generateCrumbleVoodoo(sender);
            return true;
        }
        printErrorMessage(sender);
        return false;
    }

    private void generateCrumbleVoodoo(CommandSender sender) {
        Player player = Bukkit.getPlayer(sender.getName());
        ItemStack hand = player.getInventory().getItemInMainHand();

        if(hand == null) {sender.sendMessage(ChatColor.DARK_PURPLE + "I have to hold an item for this Voodoo."); return;}
        if(hand.getType() == Material.AIR) {sender.sendMessage(ChatColor.DARK_PURPLE + "I have to hold an item for this Voodoo."); return;}

        ItemStack voodoo = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = voodoo.getItemMeta();
        if(!hand.getItemMeta().getDisplayName().isEmpty()) itemMeta.setDisplayName(ChatColor.DARK_PURPLE + "Crumble " + hand.getItemMeta().getDisplayName());
        itemMeta.setDisplayName(ChatColor.DARK_PURPLE + "Crumble " + hand.getType().name());
        itemMeta.setLocalizedName(ChatColor.DARK_PURPLE + "Crumble " + hand.getType().name());
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        voodoo.setItemMeta(itemMeta);
        voodoo.addUnsafeEnchantment(Enchantment.ARROW_INFINITE,1);
        voodoo.setAmount(hand.getAmount());

        sender.sendMessage(ChatColor.DARK_PURPLE + "The item morphs into a Voodoo scroll.");
        player.getInventory().setItemInMainHand(voodoo);
    }

    private void StopMatch() {
        Global.started = true;
        Bukkit.broadcastMessage(ChatColor.GREEN + "Match cancelled! All are safe, for now...");
    }

    private void printErrorMessage(CommandSender sender){
        sender.sendMessage(ChatColor.RED + "Invalid arguments. Please use /Voodoo [add]/[remove] <player>. ");
    }

    private void addHex(String name){
        Player player = Bukkit.getPlayer(name);
        UUID uuid = player.getUniqueId();
        if(Global.Hexes.stream().noneMatch(h -> h.getUUID().equals(uuid))) {
            Global.Hexes.add(new Hex(uuid));
        }
    }
    private void RemoveHex(String name){
        Player player = Bukkit.getPlayer(name);
        UUID uuid = player.getUniqueId();
        Object[] hex = Global.Hexes.stream().filter(h -> h.getUUID().equals(uuid)).toArray();

        if(hex.length > 0) {
            Global.Hexes.remove(hex[0]);
        }
    }

    private void StartMatch(CommandSender sender){
        if(!Global.debug) {
            if (Global.Hexes.size() <= 1) {
                sender.sendMessage(ChatColor.RED + "Not enough hexes to start a Match");
                sender.sendMessage("Current: ");
                Global.Hexes.stream().forEach(p -> sender.sendMessage(Bukkit.getPlayer(p.getUUID()).getDisplayName()));
                return;
            }
            if (Global.started) sender.sendMessage(ChatColor.GREEN + "Match already in progress!");
        }

        Bukkit.getOnlinePlayers().forEach(p -> p.playSound(p.getLocation(),ENTITY_LIGHTNING_BOLT_IMPACT,1.0f,1.0f));
        Global.started = true;
        Bukkit.broadcastMessage(ChatColor.GREEN + "Match Started! May the best Hex survive...");
        Bukkit.broadcastMessage(ChatColor.GREEN + "Hexes are: ");
        Global.Hexes.stream().forEach(p -> Bukkit.broadcastMessage(ChatColor.GREEN + Bukkit.getPlayer(p.getUUID()).getDisplayName()));
    }
}
