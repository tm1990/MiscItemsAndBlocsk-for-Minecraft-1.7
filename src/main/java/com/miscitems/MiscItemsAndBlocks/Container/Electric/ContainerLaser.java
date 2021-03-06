package com.miscitems.MiscItemsAndBlocks.Container.Electric;

import MiscUtils.GuiObjects.Slots.ModSlotItemsOnly;
import MiscUtils.Utils.ContainerBase;
import com.miscitems.MiscItemsAndBlocks.GuiObjects.Slots.ModSlotBatterySlot;
import com.miscitems.MiscItemsAndBlocks.Main.ModItems;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityLaser;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;

public class ContainerLaser  extends ContainerBase {

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tile.isUseableByPlayer(entityplayer);
	}
	
    int LastPower;
    int LastMaxPower;
    public TileEntityLaser tile;

	
    public ContainerLaser(InventoryPlayer InvPlayer, TileEntityLaser tile)
    {
    	this.tile = tile;
    	
    	for(int x = 0; x < 9; x++){
    		
    		addSlotToContainer(new Slot(InvPlayer, x, 8 + 18 * x, 142));
    	}
    	
    	for(int y = 0; y < 3; y++){
    		for(int x = 0; x < 9; x++){
    			
    			addSlotToContainer(new Slot(InvPlayer, x + y * 9 + 9, 8 + 18 * x, 84 + y * 18));
    		}
    	
    	}
    	
    	
    	addSlotToContainer(new ModSlotItemsOnly(tile, 0, 80, 30, new Item[]{ModItems.Lens}));

    	addSlotToContainer(new ModSlotBatterySlot(tile, 1, 146, 29));

}


    @Override
    public IInventory getTile() {
        return tile;
    }


    
    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, (int)this.tile.GetPower());
        par1ICrafting.sendProgressBarUpdate(this, 1, (int)this.tile.GetMaxPower());
		
    }

    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.LastPower != this.tile.GetPower())
            {
                icrafting.sendProgressBarUpdate(this, 0, (int)this.tile.GetPower());
            }
            
            if (this.LastMaxPower != this.tile.GetMaxPower())
{
    icrafting.sendProgressBarUpdate(this, 1, (int)this.tile.GetMaxPower());
}
            
            
            
            
        }

        this.LastPower = (int)this.tile.GetPower();
        this.LastMaxPower = (int)this.tile.GetMaxPower();
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.tile.SetPower(par2);
        }

        if (par1 == 1)
    {
        this.tile.SetMaxPower(par2);
    }
        
        

    }
}