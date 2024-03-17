package io.github.realyusufismail.tutorialmod;

import io.github.realyusufismail.tutorialmod.core.init.BlockInit;
import io.github.realyusufismail.tutorialmod.core.init.CreativeModeTabInit;
import io.github.realyusufismail.tutorialmod.core.init.ItemInit;
import io.github.realyusufismail.tutorialmod.data.DataGenerators;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(TutorialMod.MOD_ID)
public class TutorialMod {
    public static final String MOD_ID = "tutorialmod";
    public static Logger logger = LoggerFactory.getLogger(TutorialMod.class);

    public TutorialMod(IEventBus bus) {
        // register
        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        CreativeModeTabInit.CREATIVE_MODE_TABS.register(bus);

        // listeners
        bus.addListener(DataGenerators::gatherData);

        bus.addListener(FMLClientSetupEvent.class, (fmlClientSetupEvent -> {
            fmlClientSetupEvent.enqueueWork(() -> {
                ModList.get().getModContainerById(MOD_ID).ifPresent(modContainer -> {
                    logger.info("Loaded {}, using version {}", modContainer.getModInfo().getDisplayName(), modContainer.getModInfo().getVersion());
                });
            });
        }));
    }
}
