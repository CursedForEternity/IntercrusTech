package cursed.intch.client.ponder;

import g_mungus.zpl.block.ModBlocks;
import g_mungus.zpl.block.thruster.ThrusterExhaustBlock;
import net.createmod.ponder.api.element.ElementLink;
import net.createmod.ponder.api.element.WorldSectionElement;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.createmod.ponder.api.scene.Selection;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.Vec3;

public class IntercrusPonderScenes {
    public static void thrusterTutorial(SceneBuilder builder, SceneBuildingUtil util) {
        int size = 13;
        builder.configureBasePlate(0, 0, size);
        builder.setSceneOffsetY(-1.5f);
        builder.title("thruster", "Solar Impulse Drive");

        Selection exhaust = util.select().position(2, 4, 6);

        Selection allExhausts = exhaust
                .add(util.select().position(2, 2, 6))
                .add(util.select().position(2, 3, 4))
                .add(util.select().position(2, 3, 8));

        Selection modulator = util.select().position(3, 4, 6);

        Selection floor = util.select().fromTo(0, 0, 0, 12, 1, 12);
        builder.removeShadow();

        Selection ship = util.select().everywhere().substract(floor);
        ElementLink<WorldSectionElement> shipElement = null;

        builder.world().showSection(ship, Direction.UP);

        for (int i = 0; i < 275; i++) {
            if (i == 10) {
                builder.overlay().showText(55).text("Solar Drives can be used to propel a ship.");
                builder.overlay().showText(55).text("Direct upgrade to Ion Thrusters.");
            } else if (i == 70) {
                builder.overlay().showOutlineWithText(exhaust.add(modulator), 65).text("To set one up, place an Solar Impulse Drive in front of an Solar Impulse Magnet.");
            } else if (i == 150) {
                builder.overlay().showOutlineWithText(modulator, 65).text("Activate the drive by providing FE and a Redstone Signal to the Solar Impulse Drive block.");
                shipElement = builder.world().makeSectionIndependent(ship);
            }

            int moveStart = 230;
            if (i >= moveStart) {

                int power = Math.min(Math.max(i - moveStart, 0), 15);
                if (i < moveStart + 16) {
                    builder.world().setBlocks(allExhausts, ModBlocks.THRUSTER_EXHAUST_BLOCK.get().defaultBlockState().setValue(ThrusterExhaustBlock.FACING, Direction.WEST).setValue(ThrusterExhaustBlock.POWER, power), false);
                }

                assert shipElement != null;
                builder.world().moveSection(shipElement, new Vec3((i - moveStart) / 15f, 0, 0), 1);
            }
            builder.idle(1);
        }
    }
}
