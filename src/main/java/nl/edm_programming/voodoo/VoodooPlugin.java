package nl.edm_programming.voodoo;

import nl.edm_programming.voodoo.Command.VoodooCommands;
import nl.edm_programming.voodoo.Recipe.VoodooRecipes;
import nl.edm_programming.voodoo.listeners.EventListener;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class VoodooPlugin extends JavaPlugin {

    private Listener listener;
    private VoodooRecipes recipes;

    public VoodooPlugin() {
        listener = new EventListener(new Voodoo());
        recipes = new VoodooRecipes(this);
    }

    @Override
    public void onEnable() {
        recipes.registerRecipes();
        getCommand("voodoo").setExecutor(new VoodooCommands());
        getServer().getPluginManager().registerEvents(listener, this);
        getLogger().info("Enabled!");
    }

    @Override
    public void onDisable(){
        getLogger().info("onDisable is called!");
        HandlerList.unregisterAll(listener);
    }

}
