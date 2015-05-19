package com.jjsimpson.john.mod.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class StoneTower
{
	public static final int		TOWER_WIDTH = 7;	//x
	public static final int		TOWER_LENGTH = 7;	//z
	public static final int		TOWER_HEIGHT = 5;	//y
	protected static final int	NEAR_WALL = 1;
	protected static final int 	FAR_WALL = TOWER_LENGTH - 2;
	
	protected World				world;
	protected BlockPos			position;
	protected Random			random;
	protected List<IBlockState>	blockMaterial;
	protected boolean			showTorches;

	
	public StoneTower(World world, BlockPos position, boolean showTorches)
	{
		this.world = world;
		this.position = position;
		this.showTorches = showTorches;
		random = new Random();
		
		blockMaterial = new ArrayList<IBlockState>();
		createBlockMaterial();
	}
	
	
	public void build()
	{
		BlockPos dim = new BlockPos(TOWER_WIDTH,TOWER_HEIGHT,TOWER_LENGTH);
		
		//Build the room with stairs
		buildRoomWithStairs(dim);
		
		//Add Door
		BlockHelper.drawOneDimensional(null, world, null, position.add(1,1,0), new BlockPos(0,1,0), 2);		
	}
	
	
	protected void buildRoomWithStairs(BlockPos dim)
	{
		//Build the box
		buildRoom(dim);
		
		//Build the stairs
		buildStairs(dim, true);		
	}
	
	protected void buildRoom(BlockPos dim)
	{
		//Create the Box
		GeneralStructures.hollowBox(world, blockMaterial, position, dim);
		
		if(showTorches)
		{
			//Create the Torches
			GeneralStructures.addTorchesToBox(world, position, dim);
		}
	}
	
	protected void buildStairs(BlockPos dim, boolean nearWall)
	{
		int zoffset = nearWall ? NEAR_WALL : FAR_WALL;
		
		//Create the Stairs
		GeneralStructures.addStairsToBox(world, position, dim, zoffset);
		
		//Open ceiling for stairs
		//3 = 2 for walls, 1 for last step
		BlockHelper.drawOneDimensional(null, world, null, position.add(1,dim.getY()-1,zoffset), new BlockPos(1,0,0), dim.getX()-3);				
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
