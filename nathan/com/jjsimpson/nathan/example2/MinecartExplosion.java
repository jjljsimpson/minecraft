package com.jjsimpson.nathan.example2;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraftforge.event.entity.minecart.MinecartCollisionEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MinecartExplosion {
	@SubscribeEvent	
	public void explode(MinecartCollisionEvent event){
		//First get the cart
		EntityMinecart cart = event.minecart;
		
		//Explode the cart
		cart.worldObj.createExplosion(	cart, 		/* The thing that explodes */
										cart.posX,	/* x where it explodes */
										cart.posY,
										cart.posZ, 
										36, 		/* How big to explode (max 36) */
										false		/* Don't break blocks */
										);
	}
	
	
	
}
