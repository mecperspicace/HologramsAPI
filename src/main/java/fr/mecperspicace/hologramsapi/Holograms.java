package fr.mecperspicace.hologramsapi;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Holograms {

    private String name;
    private Location location;
    private Map<Integer, String> lines;
    private Map<Integer, ArmorStand> armorStands;

    /**
     * @param name The Holograms name.
     * @param location The location where the Holograms need to spawn.
     * @param lines The line to display.
     */

    public Holograms(String name, Location location, List<String> lines){
        this.name = name;
        this.location = location;
        this.lines = new HashMap<>();
        this.armorStands = new HashMap<>();
        lines.forEach(line -> {
            this.lines.put(this.lines.size(), line);
        });
    }

    /**
     * Create the Holograms.
     */

    public void create(){

        for (int i = 0; i < lines.size(); i++){
            Location armorStand_location = new Location(location.getWorld(), location.getX(), location.getY() - (0.30d * i), location.getZ());
            ArmorStand armorStand = (ArmorStand) location.getWorld().spawnEntity(armorStand_location, EntityType.ARMOR_STAND);
            armorStand.setCustomName(lines.get(i));
            armorStand.setCustomNameVisible(true);
            armorStand.setGravity(false);
            armorStand.setVisible(false);
            armorStands.put(i, armorStand);
        }

        HologramsAPI.getHologramsList().add(this);
    }

    /**
     * Reload the ArmorStand of the Holograms.
     */

    public void reload(){

        armorStands.forEach((integer, armorStand) -> {
            armorStand.remove();
        });

        for (int i = 0; i < lines.size(); i++){
            Location armorStand_location = new Location(location.getWorld(), location.getX(), location.getY() - (0.24 * i), location.getZ());
            ArmorStand armorStand = (ArmorStand) location.getWorld().spawnEntity(armorStand_location, EntityType.ARMOR_STAND);
            armorStand.setCustomName(lines.get(i));
            armorStand.setCustomNameVisible(true);
            armorStand.setGravity(false);
            armorStand.setVisible(false);
            armorStands.put(i, armorStand);
        }

    }

    /**
     * @param location The location where the Holograms need to go.
     */

    public void moveTo(Location location){

        setLocation(location);

        reload();
    }

    /**
     * Destroy the Holograms.
     */

    public void destroy(){

        armorStands.forEach((integer, armorStand) -> {
            armorStand.remove();
        });

        HologramsAPI.getHologramsList().remove(this);
    }

    /**
     * @return The Holograms name.
     */

    public String getName() {
        return name;
    }

    /**
     * @return The Holograms location.
     */

    public Location getLocation() {
        return location;
    }

    /**
     * @return The Holograms line.
     */

    public Map<Integer, String> getLines() {
        return lines;
    }
    
    /**
     * @param name The new Holograms name.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param location the new Holograms location.
     */

    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * @param lines The new Holograms line.
     */

    public void setLine(List<String> lines) {
        lines.forEach(line -> {
            this.lines.put(this.lines.size(), line);
        });
    }

}
