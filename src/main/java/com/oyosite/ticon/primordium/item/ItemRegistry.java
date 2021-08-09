package com.oyosite.ticon.primordium.item;

import com.oyosite.ticon.primordium.Primordium;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ItemRegistry {
    public static final Map<Identifier, Item> ITEM_STUFF = new HashMap<>();




    public static Item r(String id, Item item){
        ITEM_STUFF.put(new Identifier(Primordium.MODID, id), item);
        return item;
    }
    public static void r(Identifier... items){
        Arrays.stream(items).forEach(i->Registry.register(Registry.ITEM, i, ITEM_STUFF.get(i)));
    }
    public static void register(){
        r(ITEM_STUFF.keySet().toArray(new Identifier[]{}));
    }
}
