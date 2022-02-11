package net.ncpbails.culturaldelights.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.OakTree;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.ncpbails.culturaldelights.CulturalDelights;
import net.ncpbails.culturaldelights.block.custom.BambooMatBlock;
import net.ncpbails.culturaldelights.block.custom.WildCropsBlock;
import net.ncpbails.culturaldelights.block.custom.trees.AvocadoTree;
import net.ncpbails.culturaldelights.item.ModItemGroup;
import net.ncpbails.culturaldelights.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CulturalDelights.MOD_ID);

    //blocks                                                                        block id
    public static final RegistryObject<Block> AVOCADO_BUNDLE = registerBlock("avocado_bundle",
            () -> new Block(AbstractBlock.Properties.create(Material.GOURD)
                    .harvestLevel(0).harvestTool(ToolType.HOE).hardnessAndResistance(1f)
                    .sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BAMBOO_MAT = registerBlock("bamboo_mat",
            () -> new BambooMatBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1f)
                    .sound(SoundType.BAMBOO)));

    public static final RegistryObject<Block> WILD_CUCUMBERS = registerBlock("wild_cucumbers",
            () -> new WildCropsBlock(AbstractBlock.Properties.create(Material.PLANTS)
                    .harvestLevel(0).doesNotBlockMovement().notSolid().setOpaque((bs, br, bp) -> false).hardnessAndResistance(0f)
                    .sound(SoundType.PLANT)));

    public static final RegistryObject<Block> AVOCADO_LOG = registerBlock("avocado_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.JUNGLE_LOG)));

    public static final RegistryObject<Block> AVOCADO_WOOD = registerBlock("avocado_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.JUNGLE_WOOD)));

    public static final RegistryObject<Block> AVOCADO_LEAVES = registerBlock("avocado_leaves",
            () -> new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES)
                    .harvestLevel(0).harvestTool(ToolType.HOE).hardnessAndResistance(0.2f)
                    .sound(SoundType.PLANT).notSolid()));

    public static final RegistryObject<Block> AVOCADO_SAPLING = registerBlock("avocado_sapling",
            () -> new SaplingBlock(new AvocadoTree(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));


    //MAKE ITEMS FROM BLOCKS AUTOMATICALLY
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.CULTURAL_GROUP)));
    }




    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
