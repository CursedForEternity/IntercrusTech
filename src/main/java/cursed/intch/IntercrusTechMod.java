package cursed.intch;

import cursed.intch.ship.IntercrusShipAttachment;
import cursed.intch.block.MyBlockEntities;
import cursed.intch.network.ModPackets;
import cursed.intch.block.ModBlocks;
import cursed.intch.block.droidcore.DroidAttachment;
import cursed.intch.client.ponder.IntercrusPonderPlugin;
import cursed.intch.config.ZPLConfig;
import cursed.intch.entity.ModEntities;
import cursed.intch.item.ModCreativeTabs;
import cursed.intch.item.ModItems;
import cursed.intch.menu.ModMenuTypes;
import cursed.intch.client.particle.ModParticles;
import cursed.intch.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.mod.api.ValkyrienSkies;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

import java.util.Optional;

@Mod(IntercrusTechMod.MOD_ID)
public final class IntercrusTechMod {
    public static final String MOD_ID = "intch";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public IntercrusTechMod(FMLJavaModLoadingContext context) {
        IEventBus eventBus = context.getModEventBus();

        context.registerConfig(ModConfig.Type.SERVER, ZPLConfig.CONFIG_SPEC);

        ModBlocks.BLOCKS.register(eventBus);
        MyBlockEntities.BLOCK_ENTITIES.register(eventBus);
        ModItems.ITEMS.register(eventBus);
        ModMenuTypes.MENU_TYPES.register(eventBus);
        ModCreativeTabs.register(eventBus);
        ModParticles.PARTICLE_TYPES.register(eventBus);
        ModEntities.ENTITY_TYPES.register(eventBus);
        ModSounds.SOUND_EVENTS.register(eventBus);

        ValkyrienSkies.api().registerAttachment(IntercrusShipAttachment.class);

        ValkyrienSkies.api().registerAttachment(ValkyrienSkies.api()
                .newAttachmentRegistrationBuilder(DroidAttachment.class)
                .useTransientSerializer()
                .build()
        );

        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> IntercrusPonderPlugin::registerPlugin);

        ModPackets.register();
    }

    public static double getDimensionScale(Level level) {
        ResourceLocation dimension = level.dimension().location();
        if (
                dimension.equals(ResourceLocation.fromNamespaceAndPath("genesis", "great_unknown")) ||
                dimension.equals(ResourceLocation.fromNamespaceAndPath("genesis", "nowhere")) ||
                dimension.equals(ResourceLocation.fromNamespaceAndPath("genesis", "great_unknown"))
        ) {
            return 1.0 / 16.0;
        } else {
            return 1.0;
        }
    }

    public static ResourceLocation asResource(String id) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, id);
    }



    public static Optional<LoadedServerShip> getShipAt(ServerLevel serverLevel, BlockPos pos) {

        ServerShip ship = VSGameUtilsKt.getShipObjectManagingPos(serverLevel, pos);
        if (ship == null){
            ship = VSGameUtilsKt.getShipManagingPos(serverLevel, pos);
        }
        if (ship instanceof LoadedServerShip loadedServerShip) {
            return Optional.of(loadedServerShip);
        }
        return Optional.empty();
    }
}
