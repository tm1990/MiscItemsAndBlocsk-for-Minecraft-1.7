package com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils.ChatPackets;

import MiscUtils.Network.AbstractPacket;
import MiscUtils.Network.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils.ChannelUtils;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils.ChatChannel;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class ConnectToChannel extends AbstractPacket {

    String name, id;

    public ConnectToChannel(){}
    public ConnectToChannel(String name, String id){
        this.name = name;
        this.id = id;
    }

    @Override
    public void toBytes(ByteBuf buffer, Side side) {
        ByteBufUtils.writeUTF8String(buffer, name);
        ByteBufUtils.writeUTF8String(buffer, id);


    }

    @Override
    public void fromBytes(ByteBuf buffer, Side side) {
        name = ByteBufUtils.readUTF8String(buffer);
        id = ByteBufUtils.readUTF8String(buffer);


    }

    @Override
    public void onMessage(Side side, EntityPlayer pl) {
        ChatChannel channel = ChannelUtils.ChannelIds.get(id);

        EntityPlayer player = null;

        if(pl.getCommandSenderName().equals(name))
            player = pl;

        else{
            player = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().func_152612_a(name);

        }

        if(channel.CanConnectPlayer(player)){
            channel.ConnectPlayer(player);
        }


            if(side == Side.SERVER){
                PacketHandler.sendToAll(new ConnectToChannel(name, id), Main.Utils.channels);
            }



    }
}
