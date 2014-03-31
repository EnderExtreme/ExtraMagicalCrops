package de.domi1819.extramagicalcrops;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCrops extends Block
{
    public int blockType;
    public static Icon[] stages = new Icon[3];
    public static Icon[] textures = new Icon[40];
    
    public BlockCrops(int blockID, int type)
    {
        super(blockID, Material.plants);
        blockType = type;
        setCreativeTab(ExtraMagicalCrops.tab);
        setUnlocalizedName("blockMagicCrops");
        setStepSound(Block.soundGrassFootstep);
    }
    
    @Override 
    public Icon getIcon(int side, int meta)
    {
        if ((meta - 3) % 4 == 0)
        {
            int texID = (blockType * 4) + ((meta - 3) / 4);
            return texID >= 0 && texID < 40 ? textures[texID] : textures[0];
        }
        else
        {
            return stages[meta % 4];
        }
    }
    
    @Override
    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        
        System.out.println(metadata);
        
        if ((metadata - 3) % 4 != 0)
        {
            drops.add(new ItemStack(ExtraMagicalCrops.itemSeeds.itemID, 1, (blockType * 4) + ((metadata - (metadata % 4)) / 4)));
        }
        else
        {
            drops.add(new ItemStack(ExtraMagicalCrops.itemSeeds.itemID, 1 + (world.rand.nextInt(100) < ExtraMagicalCrops.secondSeedDropChance ? 1 : 0), (blockType * 4) + ((metadata - (metadata % 4)) / 4)));
            drops.add(new ItemStack(ExtraMagicalCrops.itemEssences.itemID, 1, (blockType * 4) + ((metadata - (metadata % 4)) / 4)));
        }
        
        return drops;
    }
    
    @Override
    public void registerIcons(IconRegister iconReg)
    {
        if (blockType != 0) return;
        
        for (int i = 0; i < textures.length; i++)
            textures[i] = iconReg.registerIcon("emc:crop/crop" + ExtraMagicalCrops.ident[i]);

        stages[0] = iconReg.registerIcon("emc:crop/stage0");
        stages[1] = iconReg.registerIcon("emc:crop/stage1");
        stages[2] = iconReg.registerIcon("emc:crop/stage2");
    }
    
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    @Override
    public int getRenderType()
    {
        return 1;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        return null;
    }
}
