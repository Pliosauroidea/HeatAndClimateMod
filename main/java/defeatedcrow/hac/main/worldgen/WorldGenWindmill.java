package defeatedcrow.hac.main.worldgen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import defeatedcrow.hac.api.blockstate.DCState;
import defeatedcrow.hac.api.blockstate.EnumSide;
import defeatedcrow.hac.core.energy.TileTorqueBase;
import defeatedcrow.hac.core.util.BiomeCatchDC;
import defeatedcrow.hac.machine.MachineInit;
import defeatedcrow.hac.magic.MagicInit;
import defeatedcrow.hac.main.MainInit;
import defeatedcrow.hac.main.config.ModuleConfig;
import defeatedcrow.hac.main.config.WorldGenConfig;
import defeatedcrow.hac.main.util.LootTablesDC;
import defeatedcrow.hac.main.worldgen.vein.OreGenPos;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenWindmill implements IWorldGenerator {

	private final boolean isForced;
	private int range = -1;
	private int forceX = 0;
	private int forceZ = 0;

	private static Random pRandom;

	public WorldGenWindmill(boolean force) {
		super();
		isForced = force;
	}

	public void setForcePos(int x, int z) {
		forceX = x;
		forceZ = z;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		if (!ModuleConfig.world)
			return;
		generateWindmill(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
	}

	public boolean generateWindmill(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {

		pRandom = new Random(world.getSeed() + chunkX + chunkZ * 31);
		pRandom.nextInt(8);
		pRandom.nextInt(8);

		int genDim1 = world.provider.getDimension();
		if ((genDim1 == 1 || genDim1 == -1))
			return false;

		if (!canGenerate(chunkX, chunkZ, world))
			return false;

		int X = chunkX << 4;
		int Z = chunkZ << 4;
		int posX = X + 8;
		int posZ = Z + 8;
		if (isForced && forceX != 0 & forceZ != 0) {
			posX = forceX;
			posZ = forceZ;
		}
		BlockPos pos = new BlockPos(posX, 60, posZ);
		Biome biome = BiomeCatchDC.getBiome(pos, world);

		if (world.villageCollection.getNearestVillage(pos, 32) != null)
			return false;

		if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.HILLS) || BiomeDictionary
				.hasType(biome, BiomeDictionary.Type.HOT) || BiomeDictionary.hasType(biome, BiomeDictionary.Type.COLD))
			return false;

		if (isForced || BiomeDictionary.hasType(biome, BiomeDictionary.Type.PLAINS) || BiomeDictionary
				.hasType(biome, BiomeDictionary.Type.FOREST)) {
			// 高度選定
			int h = -1;
			for (int y = 2; y < 255; y++) {
				BlockPos p1 = new BlockPos(posX, y, posZ);
				if (!isReplaceable(world, p1) && isReplaceable(world, p1.up()) && (world.canSeeSky(p1.up()) || world
						.getBlockState(p1).getMaterial() == Material.GRASS)) {
					h = y;
					break;
				}
			}

			if (h > 40 && h < 100) {
				// 補正
				int i1 = 0; // 傾斜確認
				int adj = 0;
				for (int i = -3; i < 4; i++) {
					for (int j = -3; j < 4; j++) {
						BlockPos c1 = new BlockPos(posX + i, h, posZ + j);
						if (!isReplaceable(world, c1.up(2)) || isReplaceable(world, c1.down(2))) {
							i1 += 1;
						} else {
							if (isReplaceable(world, c1.down())) {
								adj += -1;
							} else if (!isReplaceable(world, c1) && !isReplaceable(world, c1.up())) {
								adj += 1;
							}
						}
					}
				}

				// 平地にしか生成しない
				if (i1 < 6) {
					if (adj < -13) {
						h -= 1;
					} else if (adj > 12) {
						h += 1;
					}

					// DCLogger.debugInfoLog("Windmill House target pos2: " + posX + ", " + h + "," + posZ);
					BlockPos main = new BlockPos(posX, h, posZ);
					generate(world, main);
					return true;
				}
			}
		}
		return false;
	}

	// 西向き固定
	public void generate(World world, BlockPos pos) {
		// クリア
		for (int i1 = -5; i1 < 6; i1++) {
			for (int j1 = -5; j1 < 6; j1++) {
				for (int k1 = 1; k1 < 15; k1++) {
					world.setBlockToAir(pos.add(i1, k1, j1));
				}
			}
		}

		// 土台から
		// brick
		for (int i = -5; i < 0; i++) {
			if (!isGround(world, pos.add(-3, i, -3))) {
				world.setBlockState(pos.add(-3, i, -3), Blocks.BRICK_BLOCK.getDefaultState(), 2);
			}
			if (!isGround(world, pos.add(-3, i, 3))) {
				world.setBlockState(pos.add(-3, i, 3), Blocks.BRICK_BLOCK.getDefaultState(), 2);
			}
			if (!isGround(world, pos.add(3, i, -3))) {
				world.setBlockState(pos.add(3, i, -3), Blocks.BRICK_BLOCK.getDefaultState(), 2);
			}
			if (!isGround(world, pos.add(3, i, 3))) {
				world.setBlockState(pos.add(3, i, 3), Blocks.BRICK_BLOCK.getDefaultState(), 2);
			}
		}
		for (int i1 = -3; i1 < 4; i1++) {
			for (int j1 = -3; j1 < 4; j1++) {
				world.setBlockState(pos.add(i1, 0, j1), Blocks.BRICK_BLOCK.getDefaultState(), 2);
			}
		}
		for (int k1 = 1; k1 < 3; k1++) {
			for (int j1 = -3; j1 < 4; j1++) {
				world.setBlockState(pos.add(-3, k1, j1), Blocks.BRICK_BLOCK.getDefaultState(), 2);
				world.setBlockState(pos.add(3, k1, j1), Blocks.BRICK_BLOCK.getDefaultState(), 2);
			}
			for (int i1 = -2; i1 < 3; i1++) {
				world.setBlockState(pos.add(i1, k1, -3), Blocks.BRICK_BLOCK.getDefaultState(), 2);
				world.setBlockState(pos.add(i1, k1, 3), Blocks.BRICK_BLOCK.getDefaultState(), 2);
			}
		}
		// plank
		for (int i2 = -5; i2 < 6; i2++) {
			for (int j2 = -5; j2 < 6; j2++) {
				world.setBlockState(pos.add(i2, 3, j2), Blocks.PLANKS.getDefaultState(), 2);
			}
		}
		for (int i2 = -5; i2 < 6; i2++) {
			world.setBlockState(pos.add(i2, 4, -5), Blocks.OAK_FENCE.getDefaultState(), 2);
			world.setBlockState(pos.add(i2, 4, 5), Blocks.OAK_FENCE.getDefaultState(), 2);
		}
		for (int i2 = -4; i2 < 5; i2++) {
			world.setBlockState(pos.add(5, 4, i2), Blocks.OAK_FENCE.getDefaultState(), 2);
		}
		world.setBlockState(pos.add(-5, 4, 4), Blocks.OAK_FENCE.getDefaultState(), 2);
		world.setBlockState(pos.add(-5, 4, -4), Blocks.OAK_FENCE.getDefaultState(), 2);

		// 柱と壁
		IBlockState strO = Blocks.OAK_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.EAST);
		for (int k3 = 0; k3 < 3; k3++) {
			IBlockState logY = Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y);
			world.setBlockState(pos.add(-2, 4 + k3, -2), logY, 2);
			world.setBlockState(pos.add(-2, 4 + k3, 2), logY, 2);
			world.setBlockState(pos.add(2, 4 + k3, -2), logY, 2);
			world.setBlockState(pos.add(2, 4 + k3, 2), logY, 2);
			for (int i3 = -1; i3 < 2; i3++) {
				world.setBlockState(pos.add(i3, 4 + k3, -2), Blocks.PLANKS.getDefaultState(), 2);
				world.setBlockState(pos.add(i3, 4 + k3, 2), Blocks.PLANKS.getDefaultState(), 2);
				world.setBlockState(pos.add(2, 4 + k3, i3), Blocks.PLANKS.getDefaultState(), 2);
			}
			world.setBlockState(pos.add(-2, 4 + k3, -1), Blocks.PLANKS.getDefaultState(), 2);
			world.setBlockState(pos.add(-2, 4 + k3, 1), Blocks.PLANKS.getDefaultState(), 2);
		}
		for (int k3 = 0; k3 < 4; k3++) {
			for (int i3 = -1; i3 < 2; i3++) {
				if (!isGround(world, pos.add(-9 + k3, k3, i3))) {
					world.setBlockState(pos.add(-9 + k3, k3, i3), strO, 2);
				}
			}
		}
		world.setBlockState(pos.add(-2, 4, 0), Blocks.OAK_DOOR.getDefaultState()
				.withProperty(BlockDoor.FACING, EnumFacing.EAST)
				.withProperty(BlockDoor.HINGE, BlockDoor.EnumHingePosition.LEFT), 2);
		world.setBlockState(pos.add(-2, 5, 0), Blocks.OAK_DOOR.getDefaultState()
				.withProperty(BlockDoor.FACING, EnumFacing.EAST)
				.withProperty(BlockDoor.HINGE, BlockDoor.EnumHingePosition.LEFT)
				.withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER), 2);
		world.setBlockState(pos.add(-2, 6, 0), Blocks.PLANKS.getDefaultState(), 2);
		world.setBlockState(pos.add(2, 7, -1), Blocks.PLANKS.getDefaultState(), 2);
		world.setBlockState(pos.add(2, 7, 1), Blocks.PLANKS.getDefaultState(), 2);
		world.setBlockState(pos.add(2, 8, 0), Blocks.PLANKS.getDefaultState(), 2);
		world.setBlockState(pos.add(-2, 7, -1), Blocks.PLANKS.getDefaultState(), 2);
		world.setBlockState(pos.add(-2, 7, 0), Blocks.PLANKS.getDefaultState(), 2);
		world.setBlockState(pos.add(-2, 7, 1), Blocks.PLANKS.getDefaultState(), 2);
		world.setBlockState(pos.add(-2, 8, 0), Blocks.PLANKS.getDefaultState(), 2);

		// 屋根
		IBlockState slab = Blocks.STONE_SLAB.getDefaultState()
				.withProperty(BlockStoneSlab.VARIANT, BlockStoneSlab.EnumType.BRICK);
		world.setBlockState(pos.add(-3, 6, -1), slab, 2);
		world.setBlockState(pos.add(-3, 6, 1), slab, 2);
		world.setBlockState(pos.add(-3, 6, 0), slab, 2);

		IBlockState strL = Blocks.BRICK_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.SOUTH);
		IBlockState strR = Blocks.BRICK_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.NORTH);
		for (int j3 = -2; j3 < 3; j3++) {
			world.setBlockState(pos.add(j3, 6, -3), strL, 2);
			world.setBlockState(pos.add(j3, 7, -2), strL, 2);
			world.setBlockState(pos.add(j3, 8, -1), strL, 2);
			world.setBlockState(pos.add(j3, 6, 3), strR, 2);
			world.setBlockState(pos.add(j3, 7, 2), strR, 2);
			world.setBlockState(pos.add(j3, 8, 1), strR, 2);
			world.setBlockState(pos.add(j3, 9, 0), slab, 2);
		}
		world.setBlockState(pos.add(0, 9, 0), Blocks.BRICK_BLOCK.getDefaultState(), 2);
		world.setBlockState(pos.add(0, 10, 0), MainInit.windvane.getDefaultState(), 2);

		// 内装
		for (int i4 = 0; i4 < 3; i4++) {
			world.setBlockState(pos.add(-1, 1 + i4, -2), Blocks.PLANKS.getDefaultState(), 2);
			world.setBlockState(pos.add(-1, 1 + i4, -1), Blocks.LADDER.getDefaultState()
					.withProperty(BlockLadder.FACING, EnumFacing.SOUTH), 2);
		}

		world.setBlockState(pos.add(-1, 6, 0), MainInit.wallLamp.getDefaultState()
				.withProperty(DCState.FACING, EnumFacing.EAST).withProperty(DCState.TYPE4, 3), 2);
		world.setBlockState(pos.add(-2, 2, 0), MainInit.wallLamp.getDefaultState()
				.withProperty(DCState.FACING, EnumFacing.EAST).withProperty(DCState.TYPE4, 3), 2);

		// マシン
		if (ModuleConfig.machine) {
			world.setBlockState(pos.add(1, 4, 0), MachineInit.stonemill.getDefaultState(), 2);
			if (pRandom.nextInt(8) > 0) {
				world.setBlockState(pos.add(1, 5, 0), MachineInit.shaft_s.getDefaultState()
						.withProperty(DCState.SIDE, EnumSide.UP), 2);
			}
			if (pRandom.nextInt(8) > 0) {
				world.setBlockState(pos.add(1, 6, 0), MachineInit.shaft_s.getDefaultState()
						.withProperty(DCState.SIDE, EnumSide.UP), 2);
			}
			world.setBlockState(pos.add(1, 7, 0), MachineInit.shaft_l.getDefaultState()
					.withProperty(DCState.SIDE, EnumSide.EAST), 2);
			TileEntity shaft = world.getTileEntity(pos.add(1, 7, 0));
			if (shaft != null) {
				((TileTorqueBase) shaft).setFaceSide(EnumFacing.SOUTH);
			}
			world.setBlockState(pos.add(2, 7, 0), MachineInit.gearbox.getDefaultState()
					.withProperty(DCState.SIDE, EnumSide.EAST), 2);
			world.setBlockState(pos.add(3, 7, 0), MachineInit.windmill_l.getDefaultState()
					.withProperty(DCState.SIDE, EnumSide.WEST), 2);
		}
		// 宝箱
		world.setBlockState(pos.add(2, 1, -2), Blocks.CHEST.getDefaultState()
				.withProperty(BlockChest.FACING, EnumFacing.WEST), 2);
		TileEntity chest = world.getTileEntity(pos.add(2, 1, -2));
		if (chest != null && chest instanceof TileEntityChest) {
			((TileEntityChest) chest).setLootTable(LootTablesDC.WINDMILL_CHEST_LOOT, world.rand.nextLong());
		}
	}

	// 1/200
	private boolean canGenerate(int chunkX, int chunkZ, World world) {
		if (isForced)
			return true;
		int i = WorldGenConfig.windmillGen;
		pRandom.nextFloat();
		pRandom.nextFloat();
		float r = pRandom.nextFloat() * 10000F;
		int ri = MathHelper.floor(r);
		if (ri > 0 && ri < i) {
			if (OreGenPos.INSTANCE.canWindmillGenChunk(chunkX, chunkZ)) {
				// DCLogger.debugInfoLog("WindmillGen:" + chunkX + ", " + chunkZ);
				return true;
			}
		}
		return false;
	}

	public boolean isReplaceable(World world, BlockPos pos) {
		net.minecraft.block.state.IBlockState state = world.getBlockState(pos);
		if (state.getMaterial().isLiquid())
			return false;
		return state.getBlock().isAir(state, world, pos) || state.getMaterial().isReplaceable() || state
				.getMaterial() == Material.LEAVES;
	}

	public boolean isGround(World world, BlockPos pos) {
		net.minecraft.block.state.IBlockState state = world.getBlockState(pos);
		if (state.getMaterial().isLiquid())
			return false;
		return state.getMaterial() == Material.GROUND || state.getMaterial() == Material.GRASS || state
				.getMaterial() == Material.SAND;
	}

	public static List<ItemStack> loot = new ArrayList<ItemStack>();

	public static void initLoot() {
		if (ModuleConfig.machine) {
			loot.add(new ItemStack(MachineInit.shaft_s, 1, 0));
			loot.add(new ItemStack(MachineInit.shaft_s, 1, 0));
			loot.add(new ItemStack(MachineInit.shaft_l, 1, 0));
		}
		if (ModuleConfig.magic) {
			loot.add(new ItemStack(MagicInit.colorDrop, 1, 0));
			loot.add(new ItemStack(MagicInit.colorDrop, 1, 1));
			loot.add(new ItemStack(MagicInit.colorDrop, 1, 2));
			loot.add(new ItemStack(MagicInit.colorDrop, 1, 3));
			loot.add(new ItemStack(MagicInit.colorDrop, 1, 4));
		}
		if (ModuleConfig.tool) {
			loot.add(new ItemStack(MainInit.dcScythe[1], 1, 0));
			loot.add(new ItemStack(MainInit.dcPickaxe[0], 1, 0));
			loot.add(new ItemStack(MainInit.dcAxe[0], 1, 0));
		}
	}

}
