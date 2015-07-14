package com.jjsimpson.nathan.example5;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.FoodStats;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Sleepify {
	
	@SubscribeEvent
	public void onSleep(PlayerWakeUpEvent event){
		EntityPlayer player = event.entityPlayer;
		
		player.heal(20);
		player.getFoodStats().setFoodLevel(10);
		
		if(player.worldObj.isRemote == false)
		{
			player.dropItem(Items.poisonous_potato, 1);
		}
		player.setCurrentItemOrArmor(0, new ItemStack(Items.diamond_sword) );
		player.setCurrentItemOrArmor(3, new ItemStack(Items.diamond_chestplate) );
	}
}
