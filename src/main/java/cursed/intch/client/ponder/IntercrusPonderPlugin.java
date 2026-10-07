package cursed.intch.client.ponder;

import cursed.intch.IntercrusTechMod;
import net.createmod.ponder.api.registration.PonderPlugin;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.createmod.ponder.foundation.PonderIndex;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class IntercrusPonderPlugin implements PonderPlugin {
    @Override
    public @NotNull String getModId() {
        return IntercrusTechMod.MOD_ID;
    }
    @Override
    public void registerScenes(@NotNull PonderSceneRegistrationHelper<ResourceLocation> helper) {
        IntercrusPonders.register(helper);
    }

    public static void registerPlugin() {
        PonderIndex.addPlugin(new IntercrusPonderPlugin());
    }
}
