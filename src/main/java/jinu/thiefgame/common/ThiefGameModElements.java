package jinu.thiefgame.common;

import jinu.thiefgame.ThiefGame;
import net.minecraft.item.Item;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.forgespi.language.ModFileScanData;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ThiefGameModElements {
    public final List<ModElement> elements = new ArrayList<>();
    public final List<Supplier<Item>> items = new ArrayList<>();
    public static Map<ResourceLocation, SoundEvent> sounds = new HashMap<>();

    public ThiefGameModElements() {
        try {
            ModFileScanData modFileInfo = ModList.get().getModFileById("thiefgame").getFile().getScanResult();
            Set<ModFileScanData.AnnotationData> annotations = modFileInfo.getAnnotations();
            for (ModFileScanData.AnnotationData annotationData : annotations) {
                if (annotationData.getAnnotationType().getClassName().equals(ModElement.Tag.class.getName())) {
                    Class<?> clazz = Class.forName(annotationData.getClassType().getClassName());
                    if (clazz.getSuperclass() == ThiefGameModElements.ModElement.class)
                        elements.add((ThiefGameModElements.ModElement) clazz.getConstructor(this.getClass()).newInstance(this));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.sort(elements);
        elements.forEach(ThiefGameModElements.ModElement::initElements);
    }

    public void registerSounds(RegistryEvent.Register<SoundEvent> event) {
        for (Map.Entry<ResourceLocation, SoundEvent> sound : sounds.entrySet())
            event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
    }

    private int messageID = 0;

    public <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, PacketBuffer> encoder, Function<PacketBuffer, T> decoder,
                                      BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
        ThiefGame.PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
        messageID++;
    }

    public List<ModElement> getElements() {
        return elements;
    }

    public List<Supplier<Item>> getItems() {
        return items;
    }

    public static class ModElement implements Comparable<ModElement> {
        @Retention(RetentionPolicy.RUNTIME)
        public @interface Tag {}

        protected final ThiefGameModElements elements;
        protected final int sortid;

        public ModElement(ThiefGameModElements elements, int sortid) {
            this.elements = elements;
            this.sortid = sortid;
        }

        public void initElements() {}

        public void init(FMLCommonSetupEvent event) {}

        public void serverLoad(FMLServerStartingEvent event) {}

        @OnlyIn(Dist.CLIENT)
        public void clientLoad(FMLClientSetupEvent event) {}

        @Override
        public int compareTo(ModElement other) {
            return this.sortid - other.sortid;
        }
    }
}
