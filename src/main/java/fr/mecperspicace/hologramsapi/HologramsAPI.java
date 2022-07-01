package fr.mecperspicace.hologramsapi;

import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HologramsAPI {

    private static List<Holograms> holograms;

    /**
     * Create the ArrayList for holograms.
     */

    public static void register(Plugin plugin){

        holograms = new ArrayList<Holograms>();
    }

    /**
     * @return Holograms list.
     */

    public static List<Holograms> getHologramsList() {
        return holograms;
    }

    /**
     * @param name Hologram's name.
     * @return (Optional) The holograms who match with name.
     */

    public static Optional<Holograms> getHologram(String name){
        return new ArrayList<>(holograms).stream().filter(h -> h.getName().equalsIgnoreCase(name)).findFirst();
    }
}
