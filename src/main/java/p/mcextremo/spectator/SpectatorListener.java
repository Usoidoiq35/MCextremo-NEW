package p.mcextremo.spectator;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class SpectatorListener implements Listener {

    private final SpectatorManager spectatorManager;

    public SpectatorListener(SpectatorManager spectatorManager) {
        this.spectatorManager = spectatorManager;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        // Detect right-click or left-click
        if (event.getAction().name().contains("RIGHT_CLICK") || event.getAction().name().contains("LEFT_CLICK")) {
            // Prevent changing to spectator mode
            event.setCancelled(true);
            // Optionally, you can notify the player that they cannot switch perspectives
            player.sendMessage("No puedes cambiar de perspectiva mientras estás en modo espectador.");
        }
    }
}


