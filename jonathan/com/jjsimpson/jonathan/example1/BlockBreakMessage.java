package com.jjsimpson.jonathan.example1;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockBreakMessage {
	
	
	
	@SubscribeEvent
	public void SendMessage(BreakEvent event)
	{
		//Get Player
		EntityPlayer player = event.getPlayer();
		
		//Create text
		ChatComponentText txt = new ChatComponentText(EnumChatFormatting.DARK_BLUE + "Broke Block" + event.state.getBlock().getLocalizedName());
		
		player.addChatComponentMessage(txt);;
	}
	
	
	
}
