package com.jjsimpson.john.mod.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockHelper
{

	
	/************************* Set block *************************/
	
	public static void drawOneDimensional(Random random, World world, List<IBlockState> states, BlockPos startPosition, BlockPos direction, int length)
	{
		//Loop through the length
		while(length > 0)
		{
			//Add / Clear block at this position
			if(states == null)
			{
				world.setBlockToAir(startPosition);
			}
			else
			{
				world.setBlockState(startPosition, getRandomState(random, states));
			}
			
			//Move to the next position
			startPosition = startPosition.add(direction.getX(), direction.getY(), direction.getZ());
			
			length--;
		}
	}
	
	
	public static void drawTwoDimensional(Random random, World world, List<IBlockState> states, BlockPos startPosition, int xdim, int ydim)
	{
		int xstep = xdim > 0 ? 1 : -1;
		xdim = xdim < 0 ? xdim * -1 : xdim;
		BlockPos fauxDirection = new BlockPos(xstep, 0, 0);
		
		int ystep = ydim > 0 ? 1 : -1;
		ydim = ydim < 0 ? ydim * -1 : ydim;
		
		//Loop through and draw lines
		while(ydim > 0)
		{
			//Draw line on x axis
			drawOneDimensional(random, world, states, startPosition, fauxDirection, xdim);		
			
			//move on the y axis
			startPosition = startPosition.add(0, ystep, 0);
			
			ydim--;
		}
	}
	
	
	public static void drawThreeDimensional(Random random, World world, List<IBlockState> states, BlockPos startPosition, BlockPos dimensions)
	{
		int zstep = dimensions.getZ() > 0 ? 1 : -1;
		int zdim = dimensions.getZ() < 0 ? dimensions.getZ() * -1 : dimensions.getZ();
		
		//Loop through z axis
		while(zdim > 0)
		{
			//Draw Two dimensional
			drawTwoDimensional(random, world, states, startPosition, dimensions.getX(), dimensions.getY());
			
			//Move on the z axis
			startPosition = startPosition.add(0, 0, zstep);
			
			zdim--;
		}
	}
	
	
	/************************* helpers *************************/
	
	protected static IBlockState getRandomState(Random random, List<IBlockState> states)
	{
		IBlockState result;
		
		if(states.size() == 1 || random == null)
		{
			result = states.get(0);
		}
		else
		{
			result = states.get(random.nextInt(states.size()));
		}
		
		return result;
	}
	
	
	
	
	public static void addStairs(World world, IBlockState stairBlock, BlockPos startPoint, BlockPos dir, int length)
	{		
		//Add direction to the stairs
		if(dir.getZ() > 0) {
			stairBlock = stairBlock.withProperty(BlockStairs.FACING, EnumFacing.SOUTH);
		}
		else if(dir.getZ() > 0) {
			stairBlock = stairBlock.withProperty(BlockStairs.FACING, EnumFacing.NORTH);
		}
		else if(dir.getX() > 0) {
			stairBlock = stairBlock.withProperty(BlockStairs.FACING, EnumFacing.EAST);
		}
		else {
			stairBlock = stairBlock.withProperty(BlockStairs.FACING, EnumFacing.WEST);
		}
		
		List<IBlockState> states = new ArrayList<IBlockState>();
		states.add(stairBlock);
		drawOneDimensional(null, world, states, startPoint, dir, length);	
	}
	
	
	/************************* Torches *************************/
	
	
	protected static void addTorchesOneDimensional(World world, BlockPos startPoint, BlockPos dir, int length, int maxHeight)
	{
		boolean force = maxHeight < 0;	//if less than 0, then force the block placement
		int maxY = startPoint.getY();
		if(!force) {
			maxY += maxHeight;
		}
		
		//Loop through the length
		while(length > 0)
		{
			int hValue = (force) ? startPoint.getY() : world.getChunkFromBlockCoords(startPoint).getHeight(startPoint);
			
			if(hValue <= maxY)
			{
				BlockPos torchPosition = new BlockPos(startPoint.getX(), hValue-1, startPoint.getZ());
				//Set the torch if possible
				Block block = world.getBlockState(torchPosition).getBlock();
				if(block.canPlaceTorchOnTop(world, torchPosition))
				{
					//world.setBlockState(new BlockPos(startPoint.getX(), hValue, startPoint.getZ()), Blocks.glowstone.getDefaultState());
					world.setBlockState(new BlockPos(startPoint.getX(), hValue, startPoint.getZ()), Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, EnumFacing.UP));
				}
			}
			
			startPoint = startPoint.add(dir.getX(), dir.getY(), dir.getZ());
			
			length--;
		}
	}
	
	
	
	
	public static void addTorchesTwoDimensional(World world, BlockPos startPoint, BlockPos dir, int width, int length, int maxHeight)
	{
		BlockPos updatedDir = new BlockPos(0, 0, dir.getZ());
		dir = new BlockPos(dir.getX(), dir.getY(), 0);
		
		while(length > 0)
		{
			//Add along the x axis
			addTorchesOneDimensional(world, startPoint, dir, width, maxHeight);
			
			startPoint = startPoint.add(updatedDir.getX(), updatedDir.getY(), updatedDir.getZ());
			
			length--;
		}
	}
	
	

	
	

	
	
}
