package de.domi1819.extramagicalcrops;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.StatCollector;

public class ItemCollection extends Item
{
    String itemType;
    public Icon[] textures = new Icon[40];
    
    public ItemCollection(int itemID, String type)
    {
        super(itemID);
        itemType = type;
        setHasSubtypes(true);
        setCreativeTab(ExtraMagicalCrops.tab);
        setUnlocalizedName(itemType);
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return getUnlocalizedName() + "." + stack.getItemDamage();
    }
    
    @Override
    public void registerIcons(IconRegister iconReg)
    {
        if (itemType.equals("seed") || itemType.equals("essence"))
        {
            for (int i = 0; i < textures.length; i++)
                textures[i] = iconReg.registerIcon("emc:" + itemType + "/" + itemType + ExtraMagicalCrops.ident[i]);
        }
    }
    
    @Override
    public Icon getIconFromDamage(int dmg)
    {
        return dmg < 40 ? textures[dmg] : textures[0];
    }
    
    @Override
    public void getSubItems(int id, CreativeTabs tab, List list)
    {
        for (int i = 0; i < textures.length; i++)
            list.add(new ItemStack(id, 1, i));
    }
}
