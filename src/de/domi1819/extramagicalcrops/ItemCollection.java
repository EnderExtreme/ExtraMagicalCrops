package de.domi1819.extramagicalcrops;

import java.util.List;

import powercrystals.minefactoryreloaded.api.IFactoryPlantable;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class ItemCollection extends Item implements IFactoryPlantable
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
        if (type == "misc") textures = new Icon[1];
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return getUnlocalizedName() + "." + stack.getItemDamage();
    }
    
    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        if (side != 1 || world.getBlockId(x, y, z) == 0 || Block.blocksList[world.getBlockId(x, y, z)] == null || world.getBlockId(x, y, z) != Block.tilledField.blockID || !world.isAirBlock(x, y + 1, z)) return false;
        else if (itemType == "seed")
        {
            if (world.isRemote)
            {
                world.playSound(x, y + 1, z, Block.soundGrassFootstep.getBreakSound(), 1, 0.75F, true);
                return true;
            }
            
            int meta = stack.getItemDamage();
            world.setBlock(x, y + 1, z, ExtraMagicalCrops.crops[(meta - (meta % 4)) / 4].blockID, (meta % 4) * 4, 3);
            stack.stackSize--;
            return true;
        }
        return false;
    }
    
    @Override
    public void registerIcons(IconRegister iconReg)
    {
        if (itemType.equals("seed") || itemType.equals("essence"))
            for (int i = 0; i < textures.length; i++)
                textures[i] = iconReg.registerIcon("emc:" + itemType + "/" + itemType + ExtraMagicalCrops.ident[i]);
        else
            textures[0] = iconReg.registerIcon("emc:essencePulsating");          
    }
    
    @Override
    public Icon getIconFromDamage(int dmg)
    {
        return dmg < textures.length ? textures[dmg] : textures[0];
    }
    
    @Override
    public void getSubItems(int id, CreativeTabs tab, List list)
    {
        if (itemType.equals("seed") || itemType.equals("essence"))
            for (int i = 0; i < textures.length; i++)
                list.add(new ItemStack(id, 1, i));
        else list.add(new ItemStack(id, 1, 0));
    }

    @Override
    public int getSeedId()
    {
        return ExtraMagicalCrops.itemSeeds.itemID;
    }

    @Override
    public int getPlantedBlockId(World world, int x, int y, int z, ItemStack stack)
    {
        int meta = stack.getItemDamage();
        return ExtraMagicalCrops.crops[(meta - (meta % 4)) / 4].blockID;
    }

    @Override
    public int getPlantedBlockMetadata(World world, int x, int y, int z, ItemStack stack)
    {
        return (stack.getItemDamage() % 4) * 4;
    }

    @Override
    public boolean canBePlantedHere(World world, int x, int y, int z, ItemStack stack)
    {
        return world.getBlockId(x, y - 1, z) == Block.tilledField.blockID || world.getBlockId(x, y - 1, z) == Block.dirt.blockID;
    }

    @Override
    public void prePlant(World world, int x, int y, int z, ItemStack stack)
    {
        if (world.getBlockId(x, y - 1, z) == Block.dirt.blockID)
            world.setBlock(x, y - 1, z, Block.tilledField.blockID);
    }

    @Override
    public void postPlant(World world, int x, int y, int z, ItemStack stack)
    {
    }
}
