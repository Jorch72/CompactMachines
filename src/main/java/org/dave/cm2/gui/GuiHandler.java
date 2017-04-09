package org.dave.cm2.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.dave.cm2.CompactMachines2;
import org.dave.cm2.init.Blockss;
import org.dave.cm2.init.Itemss;
import org.dave.cm2.reference.GuiIds;

public class GuiHandler implements IGuiHandler {
    public static void init() {
        NetworkRegistry.INSTANCE.registerGuiHandler(CompactMachines2.instance, new GuiHandler());
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == GuiIds.PSD_WELCOME.ordinal()) {
            GuiPSDSelector welcomeScreen = new GuiPSDSelector("welcome");
            welcomeScreen.setDisplayIntro(true);
            welcomeScreen.addEntry(new GuiPSDSelectorEntry(new ItemStack(Itemss.miniFluidDrop, 1), "Miniaturization Fluid") {
                @Override
                public void performAction() {
                    player.openGui(CompactMachines2.instance, GuiIds.PSD_MINIATURIZATION_FLUID.ordinal(), world, x, y, z);
                }
            });

            welcomeScreen.addEntry(new GuiPSDSelectorEntry(new ItemStack(Blockss.machine, 1), "Compact Machines") {
                @Override
                public void performAction() {
                    player.openGui(CompactMachines2.instance, GuiIds.PSD_MACHINES.ordinal(), world, x, y, z);
                }
            });

            welcomeScreen.addEntry(new GuiPSDSelectorEntry(new ItemStack(Blockss.tunnel, 1), "Tunnels") {
                @Override
                public void performAction() {
                    player.openGui(CompactMachines2.instance, GuiIds.PSD_TUNNELS.ordinal(), world, x, y, z);
                }
            });

            return welcomeScreen;
        } else if(ID == GuiIds.PSD_MINIATURIZATION_FLUID.ordinal()) {
            GuiPSDSelector fluidScreen = new GuiPSDSelector("fluid");
            fluidScreen.setDisplayIntro(true);
            return fluidScreen;
        } else if(ID == GuiIds.PSD_MACHINES.ordinal()) {
            GuiPSDSelector machinesScreen = new GuiPSDSelector("machines");
            machinesScreen.setDisplayIntro(true);
            return machinesScreen;
        } else if(ID == GuiIds.PSD_TUNNELS.ordinal()) {
            GuiPSDSelector tunnelsScreen = new GuiPSDSelector("tunnels");
            tunnelsScreen.setDisplayIntro(true);
            return tunnelsScreen;
        }

        return null;
    }
}
