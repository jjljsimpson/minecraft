package com.jjsimpson.john.mod.examples;

import java.util.Random;

import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.jjsimpson.john.mod.util.ChatHelper;

public class PigDiamond extends ChatHelper
{
	public PigDiamond()
	{
		
	}
	
	@SubscribeEvent
	public void dropDiamond(LivingDeathEvent event)
	{
		//Only do if entity is a pig
		if( !(event.entity instanceof EntityPig) ) {
			return;
		}
		
		Random random = new Random();
			
		if(!event.entity.worldObj.isRemote)
		{
			event.entity.dropItem(Items.diamond, random.nextInt(3));
			
			if(event.source.getEntity() instanceof EntityPlayer)
			{
				sendMessage((EntityPlayer)event.source.getEntity(), "Killed pig");
			}
		}
	}
	
		
}
