package com.ni_coni_coni.coordonateconverter;
import org.bukkit.World.Environment;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ConvertPosition implements CommandExecutor {

    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            Location playerLocation =  player.getLocation();
            int x = (int) playerLocation.getX();
            int z = (int) playerLocation.getZ();
            String message = "";
            if(player.getWorld().getEnvironment().equals(Environment.NETHER))
            {
                message += "Overworld Coordonate: ";
                x *= 8;
                z *= 8;
            }
            else if (player.getWorld().getEnvironment().equals(Environment.NORMAL))
            {
                message += "Nether Coordonate: ";
                x /= 8;
                z /= 8;
            }

            message += "X=" + String.valueOf(x) + ", Y=" + String.valueOf(playerLocation.getY()) + ", Z=" + String.valueOf(z);

            player.sendMessage(message);
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}
