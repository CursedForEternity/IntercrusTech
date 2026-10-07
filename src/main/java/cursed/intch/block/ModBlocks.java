package g_mungus.zpl.block;

import cursed.intch.IntercrusTechMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(Registries.BLOCK, IntercrusTechMod.MOD_ID);

    public static final RegistryObject<Block> THRUSTER_EXHAUST_BLOCK = BLOCKS.register("ion_thruster_exhaust",
        () -> new ThrusterExhaustBlock(BlockBehaviour.Properties.of()
            .strength(3.0f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.NETHERITE_BLOCK)
        )
    );

    public static final RegistryObject<Block> ION_MODULATOR_BLOCK = BLOCKS.register("ion_thrust_modulator",
        () -> new IonModulatorBlock(BlockBehaviour.Properties.of()
            .strength(3.0f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.NETHERITE_BLOCK)
        )
    );

    public static final RegistryObject<Block> MASS_SUSPENSION_MATRIX_BLOCK = BLOCKS.register("mass_suspension_matrix",
            () -> new MassSuspensionMatrixBlock(BlockBehaviour.Properties.of()
                    .strength(3.0f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ENERGY_ORB_LAUNCHER = BLOCKS.register("photon_pulse_blaster",
            () -> new EnergyOrbLauncherBlock(BlockBehaviour.Properties.of()
                    .strength(3.0f)
                    .requiresCorrectToolForDrops()));
}
