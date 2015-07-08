package com.jjsimpson.jonathan.example2;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraftforge.event.entity.minecart.MinecartCollisionEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MinecartExplosion {

	@SubscribeEvent
	public void explode(MinecartCollisionEvent event)
	{
		//Create the cart
		EntityMinecart cart = event.minecart;
		
		cart.worldObj.createExplosion(	cart,	//What explodes
										cart.posX,	//Where to explode x
										cart.posY,
										cart.posZ,
										36,		//How big to explode (36 max)
										false	//Don't break blocks when explode
										);
		
		
		
	}
	
	
	
}
