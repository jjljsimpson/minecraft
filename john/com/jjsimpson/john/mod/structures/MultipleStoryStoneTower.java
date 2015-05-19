package com.jjsimpson.john.mod.structures;

import java.util.ArrayList;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class MultipleStoryStoneTower extends StoneTower
{
	public static final int DOOR_SOUTH_WEST = 0;
	public static final int DOOR_SOUTH_EAST = 1;
	public static final int DOOR_NORTH_WEST = 2;
	public static final int DOOR_NORTH_EAST = 3;
	
	
	public MultipleStoryStoneTower(World world, BlockPos position, boolean showTorches)
	{
		super(world, position, showTorches);		
	}
	
		
	@Override
	public void build()
	{
		//Build with 2 stories
		build(2, MultipleStoryStoneTower.DOOR_NORTH_EAST);
	}	
	
	public void build(int stories, int doorPosition)
	{
		BlockPos dim = new BlockPos(TOWER_WIDTH,TOWER_HEIGHT,TOWER_LENGTH);
		BlockPos pos = position;
		
		//Loop through and build with stories
		int i;
		for(i=0; i<stories; i++)
		{
			//Build the room with stairs
			buildRoom(dim);

			//Move up a floor
			//-1 because we use the ceiling as a floor
			position = position.add(0, TOWER_HEIGHT-1, 0);
		}
		
		//reset position and add stairs
		position = pos;
		for(i=0; i<stories-1; i++)
		{
			buildStairs(dim, i % 2 == 0);
			
			//Move up a floor
			//-1 because we use the ceiling as a floor
			position = position.add(0, TOWER_HEIGHT-1, 0);			
		}
		
		//Reset position
		position = pos;
		
		//Add Door
		int xpos = 0;
		int zpos = 0;
		switch(doorPosition)
		{
			case DOOR_NORTH_WEST:
				xpos = 1;
				zpos = TOWER_LENGTH - 1;
				break;
			case DOOR_NORTH_EAST:
				xpos = TOWER_WIDTH-2;
				zpos = TOWER_LENGTH-1;
				break;
			case DOOR_SOUTH_WEST:
				xpos = 1;	//TODO
				break;
			case DOOR_SOUTH_EAST:				
			default:
				xpos = TOWER_WIDTH-2;
				zpos = 0;
		}
		BlockHelper.drawOneDimensional(null, world, null, position.add(xpos,1,zpos), new BlockPos(0,1,0), 2);				
	}
	
}
