package de.domi1819.extramagicalcrops;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import powercrystals.minefactoryreloaded.api.HarvestType;
import powercrystals.minefactoryreloaded.api.IFactoryHarvestable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCrops extends Block implements IFactoryHarvestable
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
        setTickRandomly(true);
        setBlockBounds(0.1F, 0, 0.1F, 0.9F, 0.5F, 0.9F);
    }
    
    @Override
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        this.updateTick(par1World, par2, par3, par4, par1World.rand);
        return true;
    }
    
    @Override
    public void updateTick(World world, int x, int y, int z, Random random)
    {
        if (!world.isRemote && world.getBlockLightValue(x, y + 1, z) >= 9)
            if ((world.getBlockMetadata(x, y, z) - 3) % 4 != 0 && random.nextInt(20) == 0)
                world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 1, 3);
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
    
    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
        int meta = world.getBlockMetadata(x, y, z);
        
        if (random.nextInt(5) > 0) return;
        
        if (meta % 4 >= 3) world.spawnParticle("instantSpell", x + random.nextFloat(), y + 0.6F, z + random.nextFloat(), 0.0D, 0.0D, 0.0D);
        else world.spawnParticle("enchantmenttable", x + random.nextFloat(), y + 0.9F, z + random.nextFloat(), 0.0D, 0.0D, 0.0D);
    }
    
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, int neighborID) 
    {
        if (!world.isRemote && world.getBlockId(x, y - 1, z) != Block.tilledField.blockID)
        {
            this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlockToAir(x, y, z);
        }
    }
    
    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        return false;
    }

    @Override
    public int getPlantId()
    {
        // TODO Auto-generated method stub
        return blockID;
    }

    @Override
    public HarvestType getHarvestType()
    {
        return HarvestType.Normal;
    }

    @Override
    public boolean breakBlock()
    {
        return true;
    }

    @Override
    public boolean canBeHarvested(World world, Map<String, Boolean> harvesterSettings, int x, int y, int z)
    {
        return (world.getBlockMetadata(x, y, z) - 3) % 4 == 0;
    }

    @Override
    public List<ItemStack> getDrops(World world, Random rand, Map<String, Boolean> harvesterSettings, int x, int y, int z)
    {   
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        
        int metadata = world.getBlockMetadata(x, y, z);        
        drops.add(new ItemStack(ExtraMagicalCrops.itemSeeds.itemID, 1 + (world.rand.nextInt(100) < ExtraMagicalCrops.secondSeedDropChance ? 1 : 0), (blockType * 4) + ((metadata - (metadata % 4)) / 4)));
        drops.add(new ItemStack(ExtraMagicalCrops.itemEssences.itemID, 1, (blockType * 4) + ((metadata - (metadata % 4)) / 4)));
        
        return drops;
    }

    @Override
    public void preHarvest(World world, int x, int y, int z)
    {
    }

    @Override
    public void postHarvest(World world, int x, int y, int z)
    {
    }
}
