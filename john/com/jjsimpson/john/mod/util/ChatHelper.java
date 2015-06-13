package com.jjsimpson.john.mod.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class ChatHelper
{
		
	public static void sendMessage(EntityPlayer player, String message)
	{
		//Create Chat Text
		ChatComponentText txt = new ChatComponentText(EnumChatFormatting.GOLD + message);
		
		//Send text to player
		player.addChatComponentMessage(txt);
	}
}
