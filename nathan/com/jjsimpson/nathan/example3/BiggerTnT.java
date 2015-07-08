package com.jjsimpson.nathan.example3;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BiggerTnT {

	
	@SubscribeEvent 
	public void explode(EntityJoinWorldEvent event)
	{
		float power = 32.0f;
		
		//Get the entity
		Entity entity = event.entity;
		
		if(entity instanceof EntityTNTPrimed)
		{
			entity.worldObj.createExplosion(entity, entity.posX, entity.posY, entity.posZ, power, true);
		}
	}
	
	
}
