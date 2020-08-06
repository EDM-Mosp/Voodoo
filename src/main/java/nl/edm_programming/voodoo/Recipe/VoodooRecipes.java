package nl.edm_programming.voodoo.Recipe;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class VoodooRecipes {

    private Plugin plugin;

    public VoodooRecipes(Plugin plugin) {
        this.plugin = plugin;
    }

    public void registerRecipes(){

        addTransplaceRecipe();
        addFamineRecipe();
        addCrippleRecipe();
        addForceForwardRecipe();
        addForceBackwardRecipe();
        addCrumbleRecipe();
        addSummonCRecipe();
        addSummonSRecipe();
        addSummonZRecipe();
        addRewindRecipe();
        addGraspRecipe();
        addStealRecipe();
        addSummonBRecipe();
        addCrushRecipe();
        addFallRecipe();
        addPanicRecipe();
        addSummonArmyRecipe();
        addDegradeRecipe();
        addSinkRecipe();
        addWardRecipe();

    }

    private void addTransplaceRecipe(){
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin,"Transplace"),getBasicItem("Transplace"));
        recipe.addIngredient(Material.DIAMOND_BLOCK);
        Bukkit.getServer().addRecipe(recipe);
    }
    private void addFamineRecipe(){
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin,"FamineBeef"),getBasicItem("Famine"));
        recipe.shape("xxx","xxx","xxx");
        recipe.setIngredient('x',Material.COOKED_BEEF);
        Bukkit.getServer().addRecipe(recipe);

        recipe = new ShapedRecipe(new NamespacedKey(plugin,"FamineChicken"),getBasicItem("Famine"));
        recipe.shape("xxx","xxx","xxx");
        recipe.setIngredient('x',Material.COOKED_CHICKEN);
        Bukkit.getServer().addRecipe(recipe);

        recipe = new ShapedRecipe(new NamespacedKey(plugin,"FaminePork"),getBasicItem("Famine"));
        recipe.shape("xxx","xxx","xxx");
        recipe.setIngredient('x',Material.COOKED_PORKCHOP);
        Bukkit.getServer().addRecipe(recipe);
    }
    private void addCrippleRecipe(){
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin,"Cripple"),getBasicItem("Cripple"));
        recipe.addIngredient(Material.SLIME_BALL);
        recipe.addIngredient(Material.SLIME_BALL);
        recipe.addIngredient(Material.SLIME_BALL);
        recipe.addIngredient(Material.SLIME_BALL);
        recipe.addIngredient(Material.SLIME_BALL);
        Bukkit.getServer().addRecipe(recipe);
    }
    private void addForceForwardRecipe(){
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin,"ForceForward"),getBasicItem("Force Forward"));
        recipe.addIngredient(Material.GOLDEN_BOOTS);
        Bukkit.getServer().addRecipe(recipe);
    }
    private void addForceBackwardRecipe(){
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin,"ForceBackward"),getBasicItem("Force Backward"));
        recipe.addIngredient(Material.IRON_BOOTS);
        Bukkit.getServer().addRecipe(recipe);
    }
    private void addCrumbleRecipe(){

    }
    private void addSummonCRecipe(){
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin,"SummonC"),getBasicItem("Summon Creeper"));
        recipe.addIngredient(Material.TNT);
        recipe.addIngredient(Material.TNT);
        recipe.addIngredient(Material.TNT);
        Bukkit.getServer().addRecipe(recipe);
    }
    private void addSummonSRecipe(){
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin,"SummonS"),getBasicItem("Summon Skeleton"));
        recipe.addIngredient(Material.BONE);
        recipe.addIngredient(Material.BONE);
        recipe.addIngredient(Material.BONE);
        Bukkit.getServer().addRecipe(recipe);
    }
    private void addSummonZRecipe(){
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin,"SummonZ"),getBasicItem("Summon Zombie"));
        recipe.addIngredient(Material.ROTTEN_FLESH);
        recipe.addIngredient(Material.ROTTEN_FLESH);
        recipe.addIngredient(Material.ROTTEN_FLESH);
        Bukkit.getServer().addRecipe(recipe);
    }
    private void addRewindRecipe(){
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin,"Rewind"),getBasicItem("Rewind"));
        recipe.addIngredient(Material.ENDER_PEARL);
        recipe.addIngredient(Material.ENDER_PEARL);
        recipe.addIngredient(Material.ENDER_PEARL);
        recipe.addIngredient(Material.ENDER_PEARL);
        Bukkit.getServer().addRecipe(recipe);
    }
    private void addGraspRecipe(){
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin,"Grasp"),getBasicItem("Grasp"));
        recipe.addIngredient(Material.TRAPPED_CHEST);
        Bukkit.getServer().addRecipe(recipe);
    }
    private void addStealRecipe(){
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin,"Steal"),getBasicItem("Steal"));
        recipe.addIngredient(Material.TRAPPED_CHEST);
        recipe.addIngredient(Material.ENDER_PEARL);
        Bukkit.getServer().addRecipe(recipe);
    }
    private void addSummonBRecipe(){
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin,"SummonB"),getBasicItem("Summon Blaze"));
        recipe.addIngredient(Material.GOLD_BLOCK);
        Bukkit.getServer().addRecipe(recipe);
    }
    private void addCrushRecipe(){
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin,"Crush"),getBasicItem("Crush"));
        recipe.addIngredient(Material.ANVIL);
        recipe.addIngredient(Material.ENDER_PEARL);
        Bukkit.getServer().addRecipe(recipe);
    }
    private void addFallRecipe(){
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin,"Fall"),getBasicItem("Fall"));
        recipe.addIngredient(Material.IRON_PICKAXE);
        recipe.addIngredient(Material.IRON_SHOVEL);
        Bukkit.getServer().addRecipe(recipe);
    }
    private void addPanicRecipe(){
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin,"Panic"),getBasicItem("Panic"));
        recipe.addIngredient(Material.OBSIDIAN);
        recipe.addIngredient(Material.OBSIDIAN);
        recipe.addIngredient(Material.OBSIDIAN);
        recipe.addIngredient(Material.OBSIDIAN);
        recipe.addIngredient(Material.OBSIDIAN);
        Bukkit.getServer().addRecipe(recipe);
    }
    private void addSummonArmyRecipe(){
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin,"SummonArmy"),getBasicItem("Summon Army"));
        recipe.addIngredient(3,Material.ROTTEN_FLESH);
        recipe.addIngredient(3,Material.ENDER_PEARL);
        recipe.addIngredient(3,Material.TNT);

        Bukkit.getServer().addRecipe(recipe);
    }
    private void addDegradeRecipe(){
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin,"DegradeBoots"),getBasicItem("Degrade"));
        recipe.addIngredient(Material.GOLDEN_BOOTS);
        recipe.addIngredient(Material.ROTTEN_FLESH);
        Bukkit.getServer().addRecipe(recipe);

        recipe = new ShapelessRecipe(new NamespacedKey(plugin,"DegradeLeggings"),getBasicItem("Degrade"));
        recipe.addIngredient(Material.GOLDEN_LEGGINGS);
        recipe.addIngredient(Material.ROTTEN_FLESH);
        Bukkit.getServer().addRecipe(recipe);

        recipe = new ShapelessRecipe(new NamespacedKey(plugin,"DegradeHelmet"),getBasicItem("Degrade"));
        recipe.addIngredient(Material.GOLDEN_HELMET);
        recipe.addIngredient(Material.ROTTEN_FLESH);
        Bukkit.getServer().addRecipe(recipe);

        recipe = new ShapelessRecipe(new NamespacedKey(plugin,"DegradeChestplate"),getBasicItem("Degrade"));
        recipe.addIngredient(Material.GOLDEN_CHESTPLATE);
        recipe.addIngredient(Material.ROTTEN_FLESH);
        Bukkit.getServer().addRecipe(recipe);
    }
    private void addSinkRecipe(){
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin,"Sink"),getBasicItem("Sink"));
        recipe.addIngredient(Material.WATER_BUCKET);
        recipe.addIngredient(Material.WATER_BUCKET);
        Bukkit.getServer().addRecipe(recipe);
    }
    private void addWardRecipe(){
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin,"Ward"),getBasicItem("Ward"));
        recipe.addIngredient(Material.GOLDEN_APPLE);
        Bukkit.getServer().addRecipe(recipe);
    }


    private ItemStack getBasicItem(String name){
        ItemStack voodoo = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = voodoo.getItemMeta();
        itemMeta.setLocalizedName(ChatColor.DARK_PURPLE + name);
        itemMeta.setDisplayName(ChatColor.DARK_PURPLE + name);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        voodoo.setItemMeta(itemMeta);
        voodoo.addUnsafeEnchantment(Enchantment.ARROW_INFINITE,1);
        return voodoo;
    }
}
