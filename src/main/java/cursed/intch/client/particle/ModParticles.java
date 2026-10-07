package cursed.intch.client.particle;

import cursed.intch.IntercrusTechMod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, IntercrusTechMod.MOD_ID);

    public static final RegistryObject<SimpleParticleType> ENERGY_ORB =
            PARTICLE_TYPES.register("photon_pulse", () -> new SimpleParticleType(true));
}