package com.jjsimpson.john.mod.examples;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraftforge.event.entity.minecart.MinecartCollisionEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MinecartExplosion
{
	public MinecartExplosion()
	{
		
	}
	
	@SubscribeEvent
	public void explode(MinecartCollisionEvent event)
	{
		//Get the minecart
		EntityMinecart cart = event.minecart;
		
		//Create the explosion
		cart.worldObj.createExplosion(	cart,	/*target of explosion*/
										cart.posX,	/* x position of explosion */
										cart.posY,	/* y position of explosion */
										cart.posZ,	/* z position of explosion */
										2,		/* radius of explosion (Max = 16) */
										false);	/* break blocks */
	}
	
}
