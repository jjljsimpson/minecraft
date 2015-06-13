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
	protected int				towerWidth;		//x
	protected int				towerHeight;	//y
	protected int				towerLength;	//7
	protected int 				nearWall;
	protected int				farWall;
	
	protected World				world;
	protected BlockPos			position;
	protected Random			random;
	protected List<IBlockState>	blockMaterial;
	protected boolean			showTorches;

	
	public StoneTower(World world, BlockPos position, BlockPos dim, boolean showTorches)
	{
		this.world = world;
		this.position = position;
		this.showTorches = showTorches;
		random = new Random();
		
		blockMaterial = new ArrayList<IBlockState>();
		createBlockMaterial();
		
		//Default values
		setDimensions(dim.getX(), dim.getY(), dim.getZ());
	}
	
	
	public void build()
	{
		BlockPos dim = new BlockPos(towerWidth,towerHeight,towerLength);
		
		//Build the room with stairs
		buildRoomWithStairs(dim);
		
		//Add Door
		BlockHelper.drawOneDimensional(null, world, null, position.add(1,1,0), new BlockPos(0,1,0), 2);		
	}
	
	
	protected void setDimensions(int xdim, int ydim, int zdim)
	{
		towerWidth = xdim;
		towerHeight = ydim;
		towerLength = zdim;
		nearWall = 1;
		farWall = towerLength - 2;
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
	
	protected void buildStairs(BlockPos dim, boolean doNearWall)
	{
		int zoffset = doNearWall ? nearWall : farWall;
		
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
