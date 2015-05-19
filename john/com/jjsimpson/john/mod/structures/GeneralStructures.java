package com.jjsimpson.john.mod.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;


public class GeneralStructures
{
	public static void hollowBox(World world, List<IBlockState> states, BlockPos startPoint, BlockPos dim)
	{
		Random random = new Random();
		
		//Fill area
		BlockHelper.drawThreeDimensional(random, world, states, startPoint, dim);
		
		//clear interior
		int xoff = dim.getX() > 0 ? 1 : -1;
		int yoff = dim.getY() > 0 ? 1 : -1;
		int zoff = dim.getZ() > 0 ? 1 : -1;
		BlockHelper.drawThreeDimensional(random, world, null, startPoint.add(xoff, yoff, zoff), dim.add(xoff * -2, yoff * -2, zoff * -2));		
	}
	
		
	public static void addStairsToBox(World world, BlockPos startPoint, BlockPos dim, int zpos)
	{
		//Add the stairs
		BlockHelper.addStairs(world, Blocks.stone_brick_stairs.getDefaultState(), startPoint.add(2, 1, zpos), new BlockPos(1,1,0), dim.getY()-1);
	}
	
	
	public static void addTorchesToBox(World world, BlockPos startPoint, BlockPos dim)
	{
		//Add two lines of torches inside
		BlockPos botNorth = startPoint.add(1, 1, 1);
		BlockHelper.addTorchesOneDimensional(world, botNorth, new BlockPos(0, 0, 1), dim.getZ()-2, -1);

		BlockPos botSouth = startPoint.add(dim.getX()-2, 1, 1);
		BlockHelper.addTorchesOneDimensional(world, botSouth, new BlockPos(0, 0, 1), dim.getZ()-2, -1);
		
		//Add two lines of torches on top
		BlockPos topNorth = startPoint.add(0, dim.getY(), 0);
		BlockHelper.addTorchesOneDimensional(world, topNorth, new BlockPos(0, 0, 1), dim.getZ(), -1);
			
		BlockPos topSouth = startPoint.add(dim.getX()-1, dim.getY(), 0);
		BlockHelper.addTorchesOneDimensional(world, topSouth, new BlockPos(0, 0, 1), dim.getZ(), -1);
	}
	
}
