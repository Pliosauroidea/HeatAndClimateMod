package defeatedcrow.hac.main.packet;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

import defeatedcrow.hac.core.util.DCUtil;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

// biome reset
public class MessageConveyor implements IMessage {

	public int x;
	public int y;
	public int z;
	public byte i1;
	public String n1;
	public short m1;

	public MessageConveyor() {}

	public MessageConveyor(BlockPos pos, byte f1, ItemStack item1) {
		this.x = pos.getX();
		this.y = pos.getY();
		this.z = pos.getZ();
		i1 = f1;
		n1 = DCUtil.isEmpty(item1) ? "null" : item1.getItem().delegate.name().toString();
		m1 = (short) (DCUtil.isEmpty(item1) ? 0 : item1.getItemDamage());
	}

	// read
	@Override
	public void fromBytes(ByteBuf buf) {
		Charset utf = StandardCharsets.UTF_8;
		CharsetDecoder dec = utf.newDecoder();
		this.x = buf.readInt();
		this.y = buf.readInt();
		this.z = buf.readInt();
		i1 = buf.readByte();
		m1 = buf.readShort();
		int l1 = buf.readInt();
		ByteBuf nb1 = buf.readBytes(l1);
		try {
			CharBuffer cb1 = dec.decode(ByteBuffer.wrap(nb1.array()));
			n1 = cb1.toString();
		} catch (CharacterCodingException e) {
			e.printStackTrace();
		}
	}

	// write
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
		buf.writeByte(i1);
		buf.writeShort(m1);
		byte[] nb1 = n1.getBytes(StandardCharsets.UTF_8);
		int l1 = nb1.length;
		buf.writeInt(l1);
		buf.writeBytes(nb1);
	}
}
