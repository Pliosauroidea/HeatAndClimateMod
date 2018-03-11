package defeatedcrow.hac.main.packet;

import defeatedcrow.hac.core.ClimateCore;
import defeatedcrow.hac.core.fluid.FluidIDRegisterDC;
import defeatedcrow.hac.food.block.TileFluidProcessorBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MHandlerFluidProcessor implements IMessageHandler<MessageFluidProcessor, IMessage> {

	@Override
	// IMessageHandlerのメソッド
	public IMessage onMessage(MessageFluidProcessor message, MessageContext ctx) {
		EntityPlayer player = ClimateCore.proxy.getPlayer();
		if (player != null) {
			int x = message.x;
			int y = message.y;
			int z = message.z;
			int id1 = message.id1;
			int amo1 = message.amo1;
			int id2 = message.id2;
			int amo2 = message.amo2;
			BlockPos pos = new BlockPos(x, y, z);
			TileEntity tile = player.worldObj.getTileEntity(pos);
			if (tile instanceof TileFluidProcessorBase) {
				TileFluidProcessorBase te = (TileFluidProcessorBase) tile;
				Fluid f1 = FluidIDRegisterDC.getFluid(id1);
				if (f1 != null) {
					FluidStack stack1 = new FluidStack(f1, amo1);
					te.inputT.setFluid(stack1);
				}
				Fluid f2 = FluidIDRegisterDC.getFluid(id2);
				if (f2 != null) {
					FluidStack stack2 = new FluidStack(f2, amo2);
					te.outputT.setFluid(stack2);
				}
			}
		}
		return null;
	}
}
