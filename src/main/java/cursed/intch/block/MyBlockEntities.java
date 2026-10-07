package cursed.intch.block;

import cursed.intch.IntercrusTechMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MyBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
        DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, IntercrusTechMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<ThrusterExhaustBlockEntity>> THRUSTER_EXHAUST_BLOCK_ENTITY =
        BLOCK_ENTITIES.register("ion_thruster_exhaust_block_entity",
            () -> BlockEntityType.Builder.of(ThrusterExhaustBlockEntity::new, ModBlocks.THRUSTER_EXHAUST_BLOCK.get()).build(null));

    public static final RegistryObject<BlockEntityType<IonModulatorBlockEntity>> ION_MODULATOR_BLOCK_ENTITY =
        BLOCK_ENTITIES.register("ion_modulator_block_entity",
            () -> BlockEntityType.Builder.of(IonModulatorBlockEntity::new, ModBlocks.ION_MODULATOR_BLOCK.get()).build(null));

    public static final RegistryObject<BlockEntityType<MassSuspensionMatrixBlockEntity>> MASS_SUSPENSION_MATRIX_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("mass_suspension_matrix_block_entity",
                    () -> BlockEntityType.Builder.of(MassSuspensionMatrixBlockEntity::new, ModBlocks.MASS_SUSPENSION_MATRIX_BLOCK.get()).build(null));

    public static final RegistryObject<BlockEntityType<EnergyOrbLauncherBlockEntity>> ENERGY_ORB_LAUNCHER =
            BLOCK_ENTITIES.register("photon_pulse_blaster_block_entity",
                    () -> BlockEntityType.Builder.of(EnergyOrbLauncherBlockEntity::new, ModBlocks.ENERGY_ORB_LAUNCHER.get()).build(null));}
