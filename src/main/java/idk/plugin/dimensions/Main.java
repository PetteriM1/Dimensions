package idk.plugin.dimensions;

import cn.nukkit.network.protocol.ChangeDimensionPacket;
import cn.nukkit.Player;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityLevelChangeEvent;

public class Main extends PluginBase implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onLevelChange(EntityLevelChangeEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (e.getTarget().getName().equals("nether")) {
                ChangeDimensionPacket pk = new ChangeDimensionPacket();
                pk.dimension = 1;
                p.dataPacket(pk);
            } else if (e.getTarget().getName().equals("end")) {
                ChangeDimensionPacket pk = new ChangeDimensionPacket();
                pk.dimension = 2;
                p.dataPacket(pk);
            } else if (e.getOrigin().getName().equals("nether") || e.getOrigin().getName().equals("end")) {
                ChangeDimensionPacket pk = new ChangeDimensionPacket();
                pk.dimension = 0;
                p.dataPacket(pk);
            }
        }
    }
}
