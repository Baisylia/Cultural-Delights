package net.ncpbails.culturaldelights.item;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.ncpbails.culturaldelights.CulturalDelights;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CulturalDelights.MOD_ID);


    //Items                                                                  item id
    public static final RegistryObject<Item> AVOCADO = ITEMS.register("avocado", () -> new Item(new Item.Properties().group(ModItemGroup.CULTURAL_GROUP)));

    //Foods
    public static final RegistryObject<Item> CUT_AVOCADO = ITEMS.register("cut_avocado",
            () -> new Item(new Item.Properties().group(ModItemGroup.CULTURAL_GROUP).food(new Food.Builder().hunger(2).saturation(0.4f).build() )));

    public static final RegistryObject<Item> CUCUMBER = ITEMS.register("cucumber",
            () -> new Item(new Item.Properties().group(ModItemGroup.CULTURAL_GROUP).food(new Food.Builder().hunger(2).saturation(0.5f).build() )));

    public static final RegistryObject<Item> PICKLE = ITEMS.register("pickle",
            () -> new Item(new Item.Properties().group(ModItemGroup.CULTURAL_GROUP).food(new Food.Builder().hunger(4).saturation(0.6f).build() )));

    public static final RegistryObject<Item> CUT_CUCUMBER = ITEMS.register("cut_cucumber",
            () -> new Item(new Item.Properties().group(ModItemGroup.CULTURAL_GROUP).food(new Food.Builder().hunger(1).saturation(0.2f).fastToEat().build() )));

    public static final RegistryObject<Item> EGGPLANT = ITEMS.register("eggplant",
            () -> new Item(new Item.Properties().group(ModItemGroup.CULTURAL_GROUP).food(new Food.Builder().hunger(4).saturation(0.8f).build() )));

    public static final RegistryObject<Item> WHITE_EGGPLANT = ITEMS.register("white_eggplant",
            () -> new Item(new Item.Properties().group(ModItemGroup.CULTURAL_GROUP).food(new Food.Builder().hunger(2).saturation(0.4f).build() )));

    public static final RegistryObject<Item> AVOCADO_TOAST = ITEMS.register("avocado_toast",
            () -> new Item(new Item.Properties().group(ModItemGroup.CULTURAL_GROUP).food(new Food.Builder().hunger(8).saturation(1f).build() )));

    public static final RegistryObject<Item> SUSHI = ITEMS.register("sushi",
            () -> new Item(new Item.Properties().group(ModItemGroup.CULTURAL_GROUP).food(new Food.Builder().hunger(3).saturation(1f).fastToEat().build() )));

    public static final RegistryObject<Item> AVOCADO_SUSHI = ITEMS.register("avocado_sushi",
            () -> new Item(new Item.Properties().group(ModItemGroup.CULTURAL_GROUP).food(new Food.Builder().hunger(5).saturation(1f).fastToEat().build() )));

    public static final RegistryObject<Item> CUCUMBER_SUSHI = ITEMS.register("cucumber_sushi",
            () -> new Item(new Item.Properties().group(ModItemGroup.CULTURAL_GROUP).food(new Food.Builder().hunger(5).saturation(1f).fastToEat().build() )));

    public static final RegistryObject<Item> COD_SUSHI = ITEMS.register("cod_sushi",
            () -> new Item(new Item.Properties().group(ModItemGroup.CULTURAL_GROUP).food(new Food.Builder().hunger(4).saturation(1f).fastToEat().build() )));

    public static final RegistryObject<Item> KOI_SUSHI = ITEMS.register("koi_sushi",
            () -> new Item(new Item.Properties().group(ModItemGroup.CULTURAL_GROUP).food(new Food.Builder().hunger(4).saturation(1f).fastToEat().build() )));

    public static final RegistryObject<Item> LIONFISH_SUSHI = ITEMS.register("lionfish_sushi",
            () -> new Item(new Item.Properties().group(ModItemGroup.CULTURAL_GROUP).food(new Food.Builder().hunger(4).saturation(1f).fastToEat()
                    .effect(new EffectInstance(Effects.NAUSEA, 200, 1), 1f).build() )));

    public static final RegistryObject<Item> PERCH_SUSHI = ITEMS.register("perch_sushi",
            () -> new Item(new Item.Properties().group(ModItemGroup.CULTURAL_GROUP).food(new Food.Builder().hunger(4).saturation(1f).fastToEat().build() )));

    public static final RegistryObject<Item> PIKE_SUSHI = ITEMS.register("pike_sushi",
            () -> new Item(new Item.Properties().group(ModItemGroup.CULTURAL_GROUP).food(new Food.Builder().hunger(4).saturation(1f).fastToEat().build() )));

    public static final RegistryObject<Item> PUFFERFISH_SUSHI = ITEMS.register("pufferfish_sushi",
            () -> new Item(new Item.Properties().group(ModItemGroup.CULTURAL_GROUP).food(new Food.Builder().hunger(4).saturation(1f).fastToEat()
                    .effect(new EffectInstance(Effects.NAUSEA, 200, 0), 1f)
                    .effect(new EffectInstance(Effects.HUNGER, 200, 1), 1f).build() )));

    public static final RegistryObject<Item> SALMON_SUSHI = ITEMS.register("salmon_sushi",
            () -> new Item(new Item.Properties().group(ModItemGroup.CULTURAL_GROUP).food(new Food.Builder().hunger(4).saturation(1f).fastToEat().build() )));

    public static final RegistryObject<Item> TROPICAL_SUSHI = ITEMS.register("tropical_sushi",
            () -> new Item(new Item.Properties().group(ModItemGroup.CULTURAL_GROUP).food(new Food.Builder().hunger(4).saturation(1f).fastToEat().build() )));

    public static final RegistryObject<Item> ONIGIRI = ITEMS.register("onigiri",
            () -> new Item(new Item.Properties().group(ModItemGroup.CULTURAL_GROUP).food(new Food.Builder().hunger(4).saturation(1f).fastToEat().build() )));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
