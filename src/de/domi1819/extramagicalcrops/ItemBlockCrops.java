package de.domi1819.extramagicalcrops;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockCrops extends ItemBlock
{
    public ItemBlockCrops(int itemID)
    {
        super(itemID);
        setHasSubtypes(true);
    }
    
    @Override
    public int getMetadata(int meta)
    {
        return meta;
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return super.getUnlocalizedName() + "." + stack.getItemDamage();
    }
}
