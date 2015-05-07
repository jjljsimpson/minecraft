package com.jjsimpson.john.mod.examples;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BiggerTntNoFuse
{
	public BiggerTntNoFuse()
	{
		
	}
	
	@SubscribeEvent
	public void explode(EntityJoinWorldEvent event)
	{
		//Power of explosions
		float power = 32.0f;
		
		//Get entity
		Entity entity = event.entity;
		
		//Only do this for TNT
		if(entity instanceof EntityTNTPrimed)
		{
			entity.worldObj.createExplosion(entity, entity.posX, entity.posY, entity.posZ, power, true);
		}
	}
}
