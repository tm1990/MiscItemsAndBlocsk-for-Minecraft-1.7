package com.miscitems.MiscItemsAndBlocks.TileEntity.Machines;

import MiscUtils.TileEntity.TileEntityInvBase;
import MiscUtils.Utils.StackUtils;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemDataChip;
import com.miscitems.MiscItemsAndBlocks.Main.ModItems;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.DimensionManager;

public class TileEntityWirelessItemTrans extends TileEntityInvBase implements ISidedInventory{

	public TileEntityWirelessItemTrans() {
		super(22, "Wireless Item Transfer", 64);
		}

	int CurrentUpdateTick = 0;
	int UpdateTick = 15;
	
	int SendingTick = 0;
	int SendTick = 15;

	public void updateEntity(){
		
		if(IsLinked)
			Mode = 1;
		else 
			Mode = 0;
		
		
		
		if(this.getStackInSlot(0) != null ){
			if(this.getStackInSlot(0).getItem() instanceof ModItemDataChip){
				if(this.getStackInSlot(0).stackTagCompound == null){
				if(this.getStackInSlot(1) == null){
					
					this.setInventorySlotContents(0, null);
					
					ItemStack stack = new ItemStack(ModItems.DataChip, 1, 1);
					
					stack.setTagCompound(new NBTTagCompound());
					
					stack.stackTagCompound.setString("DataType", "Wireless Item Transfer");
					
					stack.stackTagCompound.setInteger("ItemTrans_x", this.xCoord);
					stack.stackTagCompound.setInteger("ItemTrans_y", this.yCoord);
					stack.stackTagCompound.setInteger("ItemTrans_z", this.zCoord);

					stack.stackTagCompound.setInteger("ItemTrans_world", worldObj.provider.dimensionId);
					
					this.setInventorySlotContents(1, stack);
					
					
				}
				}
				
			}

		}


		World world = null;
		
		if(CurrentUpdateTick >= UpdateTick){
		if(this.getStackInSlot(2) != null ){
			if(this.getStackInSlot(2).getItem() instanceof ModItemDataChip){
				if(this.getStackInSlot(2).stackTagCompound != null){
			

					if(this.getStackInSlot(2).stackTagCompound.getString("DataType").equalsIgnoreCase("Wireless Item Transfer")){


						x = this.getStackInSlot(2).stackTagCompound.getInteger("ItemTrans_x");
						y = this.getStackInSlot(2).stackTagCompound.getInteger("ItemTrans_y");
						z = this.getStackInSlot(2).stackTagCompound.getInteger("ItemTrans_z");

						int WorldId = getStackInSlot(2).stackTagCompound.getInteger("ItemTrans_world");
						WorldProvider provider = DimensionManager.getProvider(WorldId);

						if (provider != null) {
							world = provider.worldObj;
						}

						if(world != null)
						if(world.getTileEntity(x,y,z)instanceof TileEntityWirelessItemTrans){

						CardMode = 1;
						
						IsLinked = true;

						Mode = 1;
						
						}else{
							CardMode = 0;
							IsLinked = false;
							
							
							x = 0;
							y = 0;
							z = 0;
						}
					}else{
						CardMode = 2;
					}
			
					
		}else{
			CardMode = 2;
		}
				
			}
			
		}else{
			CardMode = 0;
			IsLinked = false;
			
			
			x = 0;
			y = 0;
			z = 0;
		}
		
			
		}else{
			CurrentUpdateTick++;
		}

		
		boolean Sent = false;
		if(FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER)
		if(Mode == 1 && CardMode == 1 && IsLinked){
			
			
			if(SendingTick > SendTick || this.getStackInSlot(3) == null)
				SendingTick = 0;
			else{
			
			if(SendingTick >= SendTick){
				SendingTick = 0;
				
				
				TileEntityWirelessItemTrans tile_e = (TileEntityWirelessItemTrans)world.getTileEntity(x, y, z);
				if(tile_e != null && this.getStackInSlot(3) != null){


					for(int i = 4; i < tile_e.getSizeInventory(); i++){
						Sent = false;

						ItemStack sending = getStackInSlot(3);
						if(sending != null) {

							if (tile_e.getStackInSlot(i) != null) {
								ItemStack stack = tile_e.getStackInSlot(i);

								if(StackUtils.AreStacksEqual(stack, sending, false, false, true)) {

									if (stack.stackSize < stack.getMaxStackSize()) {
										if (stack.stackSize + 1 <= stack.getMaxStackSize()) {
											ItemStack temp = stack.copy();
											temp.stackSize += 1;

											tile_e.setInventorySlotContents(i, temp);

											Sent = true;
											SendingTick = 0;

											break;
										}
									}

								}else{
									continue;
								}

							}else{
								ItemStack temp = sending.copy();
								temp.stackSize = 1;

								tile_e.setInventorySlotContents(i, temp);

								Sent = true;
								SendingTick = 0;

								break;
							}

						}


			}

					if(Sent && this.getStackInSlot(3) != null){
						this.decrStackSize(3, 1);
					}
					
					
			}else{
				SendingTick = 0;
			}
			
				
				
				
		}else{
			SendingTick++;
		}
		
		}

		}else{
			SendingTick = 0;
		}
        
	}
	
	private static final int[] sidedSlotSides = new int[] { 3 };
	private static final int[] sidedSlotBottom = new int[] { 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21 };
	private static final int[] sidedSlotTop = new int[] { 3 };
	
	public int x = 0;
	public int y = 0;
	public int z = 0;
	
	
	public int GetX(){
		return x;
	}
	
	public int GetY(){
		return y;
	}
	
	public int GetZ(){
		return z;
	}
	
	
	public void SetX(int i){
		x = i;
	}
	
	public void SetY(int i){
		y = i;
	}
	
	public void SetZ(int i){
		z = i;
	}

	public int Mode = 0;
	
	//0 = empty
	//1 = valid
	//2 = invalid
	public int CardMode = 0;
	
	
	public int GetCardMode(){
		return CardMode;
	}
	
	public void SetCardMode(int i){
	
		if(i <= 2)
			CardMode = i;
		else
			CardMode = 0;
	}
	
	public boolean IsLinked;
	
	  public void readFromNBT(NBTTagCompound NBT)
	    {
		  super.readFromNBT(NBT);

		  Mode = NBT.getInteger("Mode");
		  CardMode = NBT.getInteger("CardMode");
		  SendingTick = NBT.getInteger("Tickhandler");

	    }


	    public void writeToNBT(NBTTagCompound NBT)
	    {
	      super.writeToNBT(NBT);

	      NBT.setInteger("Mode", Mode);
	      NBT.setInteger("CardMode", CardMode);
	      NBT.setInteger("Tickhandler", SendingTick);
	      
	    	
	    }
	    
		@Override
		public int[] getAccessibleSlotsFromSide(int var1) {
			return var1 == 0 ? sidedSlotBottom : (var1 == 1 ? sidedSlotTop : sidedSlotSides);
		}

		@Override
		public boolean canInsertItem(int i, ItemStack itemstack, int j) {
			return this.isItemValidForSlot(i, itemstack);
		}

		@Override
		public boolean canExtractItem(int i, ItemStack itemstack, int j) {
			return j != 0 || i != 1 ;
		}
}
