package com.jjsimpson.nathan.example1;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockBreakMessage {
	
	
	@SubscribeEvent
	public void SendMessage(BreakEvent event){
		
		//Get the player
		EntityPlayer nathanPlayer = event.getPlayer();
		
		//Create the text
		ChatComponentText txt = new ChatComponentText(EnumChatFormatting.DARK_PURPLE + "You Broke a Block:" + event.state.getBlock().getLocalizedName());

		//Output the text
		nathanPlayer.addChatComponentMessage(txt);
	
	}
	
	
	
	
}
