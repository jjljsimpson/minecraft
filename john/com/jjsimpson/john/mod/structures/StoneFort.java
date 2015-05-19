package com.jjsimpson.john.mod.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class StoneFort
{	
	protected static final int FORT_WIDTH = 31;		//x
	protected static final int FORT_HEIGHT = 15;	//y
	protected static final int FORT_LENGTH = 31;	//z
	
	protected static final int SPACER = 3;
	protected static final int WALL_WIDTH = 2;
	protected static final int WALL_HEIGHT = 3;
	protected static final int TORCH_SPACE = 3;
	protected static final int WALL_STAIR_SIZE = 3;
	
	protected World				world;
	protected BlockPos			position;
	protected Random			random;
	protected List<IBlockState>	blockMaterial;
	protected boolean			showTorches;
	
	public StoneFort(World world, BlockPos position, boolean showTorches)
	{
		random = new Random();
		this.world = world;
		this.position = position;
		blockMaterial = new ArrayList<IBlockState>();
		this.showTorches = showTorches;
		
		createBlockMaterial();
	}
	
	
	public void build()
	{
		int midx = FORT_WIDTH / 2;
		int midy = FORT_LENGTH / 2;
		int maxx = FORT_WIDTH - (WALL_WIDTH+1);
		int maxy = FORT_LENGTH - (WALL_WIDTH+1);		
		
		//Move to the south west corner
		BlockPos southWest = position.add(FORT_WIDTH / -2, 0, FORT_LENGTH / -2);
		
		//clear
		BlockHelper.drawThreeDimensional(null, world, null, southWest.add(-SPACER, 0, -SPACER),
				new BlockPos(FORT_WIDTH + SPACER + SPACER, FORT_HEIGHT, FORT_LENGTH + SPACER + SPACER));

		//Build Floor
		BlockHelper.drawThreeDimensional(random, world, blockMaterial, southWest.add(0,-1,0), new BlockPos (FORT_WIDTH, 1, FORT_LENGTH));
		world.setBlockState(position.add(0, -1, 0), Blocks.lapis_block.getDefaultState());
		
		//Build the towers
		buildTowers(southWest);
				
		//Build Walls
		buildWalls(southWest);
				
		//Create North Stairs		
		createWallStairs(southWest.add(midx, 0, maxy), true);
		createWallStairs(southWest.add(midx, 0, WALL_WIDTH), true);
		createWallStairs(southWest.add(WALL_WIDTH, 0, midy), false);
		createWallStairs(southWest.add(maxy, 0, midy), false);
		
		//add entrance
		createEntrance(southWest);						
		
		if(showTorches)
		{
			BlockHelper.addTorchesTwoDimensional(world, southWest, new BlockPos(SPACER, 0, SPACER), FORT_WIDTH / SPACER, FORT_LENGTH / SPACER, 0);
		}		
	}
	
	
	protected void buildWalls(BlockPos southWest)
	{
		BlockHelper.drawThreeDimensional(random, world, blockMaterial, southWest.add(0,-1,0), new BlockPos (FORT_WIDTH, WALL_HEIGHT, WALL_WIDTH));
		BlockHelper.drawThreeDimensional(random, world, blockMaterial, southWest.add(0,-1,0), new BlockPos (WALL_WIDTH, WALL_HEIGHT, FORT_LENGTH));
		BlockHelper.drawThreeDimensional(random, world, blockMaterial, southWest.add(FORT_WIDTH-WALL_WIDTH,-1,0), new BlockPos (WALL_WIDTH, WALL_HEIGHT, FORT_LENGTH));
		BlockHelper.drawThreeDimensional(random, world, blockMaterial, southWest.add(0,-1,FORT_LENGTH-WALL_WIDTH), new BlockPos (FORT_WIDTH, WALL_HEIGHT, WALL_WIDTH));
		
		//Add torches to the walls
		if(showTorches)
		{
			BlockHelper.addTorchesOneDimensional(world, southWest.add(0, WALL_HEIGHT-1, 0), new BlockPos(0, 0, TORCH_SPACE), FORT_LENGTH/TORCH_SPACE, 0);
			BlockHelper.addTorchesOneDimensional(world, southWest.add(FORT_WIDTH-1, WALL_HEIGHT-1, 0), new BlockPos(0, 0, TORCH_SPACE), FORT_LENGTH/TORCH_SPACE, 0);
			BlockHelper.addTorchesOneDimensional(world, southWest.add(0, WALL_HEIGHT-1, FORT_LENGTH-1), new BlockPos(TORCH_SPACE, 0, 0), FORT_WIDTH/TORCH_SPACE, 0);
			BlockHelper.addTorchesOneDimensional(world, southWest.add(0, WALL_HEIGHT-1, 0), new BlockPos(TORCH_SPACE, 0, 0), FORT_WIDTH/TORCH_SPACE, 0);
		}
	}
	
		
	protected void buildTowers(BlockPos southWest)
	{
		//Build south west tower (2 for stone wall)
		MultipleStoryStoneTower swTower = new MultipleStoryStoneTower(world, southWest.add(WALL_WIDTH, -1, WALL_WIDTH), showTorches);
		swTower.build(2, MultipleStoryStoneTower.DOOR_NORTH_EAST);
		
		//Build south east tower (4 for two walls)
		MultipleStoryStoneTower seTower = new MultipleStoryStoneTower(world, southWest.add(FORT_WIDTH - (StoneTower.TOWER_WIDTH+WALL_WIDTH), -1, WALL_WIDTH), showTorches);
		seTower.build(2, MultipleStoryStoneTower.DOOR_NORTH_WEST);
		
		//Build north west tower
		MultipleStoryStoneTower nwTower = new MultipleStoryStoneTower(world, southWest.add(WALL_WIDTH, -1, FORT_LENGTH - (StoneTower.TOWER_LENGTH+WALL_WIDTH)), showTorches);
		nwTower.build(2, MultipleStoryStoneTower.DOOR_SOUTH_EAST);
		
		//Build north east tower
		MultipleStoryStoneTower neTower = new MultipleStoryStoneTower(world, southWest.add(FORT_WIDTH - (StoneTower.TOWER_WIDTH+WALL_WIDTH), -1, FORT_LENGTH - (StoneTower.TOWER_LENGTH+WALL_WIDTH)), showTorches);
		neTower.build(2, MultipleStoryStoneTower.DOOR_SOUTH_WEST);				
	}
	
	
	protected void createEntrance(BlockPos southWest)
	{
		ArrayList<IBlockState> st = new ArrayList<IBlockState>();		
		int xpos = FORT_WIDTH / 2;
		int zpos = FORT_LENGTH;
		int adjustedHeight = WALL_HEIGHT-1;
		int stairWidth = WALL_WIDTH + 1;
		int stairStart = adjustedHeight + 1;
						
		//Block about the head
		BlockHelper.drawThreeDimensional(random, world, blockMaterial, southWest.add(xpos, 2, zpos-1), new BlockPos(1,1,-(WALL_WIDTH+1)));

		//add stairs for overhead
		st.add(Blocks.stone_stairs.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.WEST));
		BlockHelper.drawThreeDimensional(random, world, st, southWest.add(xpos+1, adjustedHeight, zpos-1), new BlockPos(1,1,-stairWidth));
		BlockHelper.drawOneDimensional(random, world, st, southWest.add(xpos+stairStart,0,zpos-(WALL_WIDTH+1)), new BlockPos(-1,1,0), adjustedHeight);		
		
		//Opening for door
		BlockHelper.drawThreeDimensional(null, world, null, southWest.add(xpos, 0, zpos-1), new BlockPos(1,adjustedHeight,-(WALL_WIDTH+1)));
		
		st.clear();
		st.add(Blocks.stone_stairs.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.EAST));
		BlockHelper.drawThreeDimensional(random, world, st, southWest.add(xpos-1, adjustedHeight, zpos-1), new BlockPos(1,1,-stairWidth));
		BlockHelper.drawOneDimensional(random, world, st, southWest.add(xpos-stairStart,0,zpos-(WALL_WIDTH+1)), new BlockPos(1,1,0), adjustedHeight);		
	}
	
	
	protected void createWallStairs(BlockPos position, boolean xaxis)
	{
		ArrayList<IBlockState> st = new ArrayList<IBlockState>();
		st.add(Blocks.glowstone.getDefaultState());
		int len = WALL_STAIR_SIZE;	//length of this level
		int floorHeight = position.getY() + (WALL_HEIGHT - 2);
		int pos = (len / 2);
		pos = (xaxis) ? position.getX() - pos : position.getZ() - pos;
				
		int minHeight = position.getY();
		BlockPos dir = (xaxis) ? new BlockPos(1, 0, 0) : new BlockPos(0,0,1);
		BlockPos floorPosition;
		while(floorHeight >= minHeight)
		{
			if(xaxis) {
				floorPosition = new BlockPos(pos, floorHeight, position.getZ());
			}
			else {
				floorPosition = new BlockPos(position.getX(), floorHeight, pos);
			}
			
			BlockHelper.drawOneDimensional(random, world, blockMaterial, floorPosition, dir, len);
			
			if(xaxis) {
				world.setBlockState(floorPosition.add(-1, 0, 0), Blocks.stone_stairs.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.EAST));
				world.setBlockState(floorPosition.add(len, 0, 0), Blocks.stone_stairs.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.WEST));
			}
			else {
				world.setBlockState(floorPosition.add(0, 0, -1), Blocks.stone_stairs.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.SOUTH));
				world.setBlockState(floorPosition.add(0, 0, len), Blocks.stone_stairs.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.NORTH));
			}
			
			floorHeight--;
			pos--;
			len += 2;
		}
		
	}
	
		
			
	//This creates the material used for the fort
	protected void createBlockMaterial()
	{
		//Clear whatever was set before
		blockMaterial.clear();
		
		blockMaterial.add(Blocks.stonebrick.getDefaultState());
		blockMaterial.add(Blocks.stonebrick.getDefaultState());
		blockMaterial.add(Blocks.stonebrick.getDefaultState());
		blockMaterial.add(Blocks.stonebrick.getStateFromMeta(BlockStoneBrick.MOSSY_META));
		blockMaterial.add(Blocks.stonebrick.getStateFromMeta(BlockStoneBrick.MOSSY_META));
		blockMaterial.add(Blocks.stonebrick.getStateFromMeta(BlockStoneBrick.CRACKED_META));		
	}	
	
}
