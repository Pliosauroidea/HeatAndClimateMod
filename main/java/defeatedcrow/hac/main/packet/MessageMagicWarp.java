package defeatedcrow.hac.main.packet;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

// biome reset
public class MessageMagicWarp implements IMessage {

	public double x;
	public double y;
	public double z;
	public float face;

	public MessageMagicWarp() {}

	public MessageMagicWarp(float f, double x1, double y1, double z1) {
		this.x = x1;
		this.y = y1;
		this.z = z1;
		face = f;
	}

	// read
	@Override
	public void fromBytes(ByteBuf buf) {
		this.x = buf.readDouble();
		this.y = buf.readDouble();
		this.z = buf.readDouble();
		face = buf.readFloat();
	}

	// write
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeDouble(x);
		buf.writeDouble(y);
		buf.writeDouble(z);
		buf.writeFloat(face);
	}
}
