package cursed.intch.item;

import cursed.intch.IntercrusTechMod;
import cursed.intch.block.ModBlocks;
import cursed.intch.item.tooltip.FERedstoneBlockItem;
import cursed.intch.item.tooltip.RedstoneBlockItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(Registries.ITEM, IntercrusTechMod.MOD_ID);

    public static final RegistryObject<Item> THRUSTER_EXHAUST_ITEM = ITEMS.register("ion_thruster_exhaust",
        () -> new BlockItem(ModBlocks.THRUSTER_EXHAUST_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> ION_MODULATOR_ITEM = ITEMS.register("ion_thrust_modulator",
            () -> new FERedstoneBlockItem(ModBlocks.ION_MODULATOR_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> MASS_SUSPENSION_MATRIX_ITEM = ITEMS.register("mass_suspension_matrix",
            () -> new RedstoneBlockItem(ModBlocks.MASS_SUSPENSION_MATRIX_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> ENERGY_ORB_LAUNCHER_ITEM = ITEMS.register("photon_pulse_blaster",
            () -> new FERedstoneBlockItem(ModBlocks.ENERGY_ORB_LAUNCHER.get(), new Item.Properties()));

} 
