package net.ncpbails.culturaldelights.tileentity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.ncpbails.culturaldelights.data.recipes.BambooMatRecipe;
import net.ncpbails.culturaldelights.data.recipes.ModRecipeTypes;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class BambooMatTile extends TileEntity implements ITickableTileEntity {

    private final ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    public BambooMatTile(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public BambooMatTile() {
        this(ModTileEntities.BAMBOO_MAT_TILE.get());
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        itemHandler.deserializeNBT(nbt.getCompound("inv"));
        super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("inv", itemHandler.serializeNBT());
        return super.write(compound);
    }


    private ItemStackHandler createHandler() {
        return new ItemStackHandler(7)
        {
            @Override
            protected void onContentsChanged(int slot) {
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return true;
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if(!isItemValid(slot, stack)) {
                    return stack;
                }

                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }

        return super.getCapability(cap, side);
    }

    public void craft() {
        Inventory inv = new Inventory(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setInventorySlotContents(i, itemHandler.getStackInSlot(i));
        }

        Optional<BambooMatRecipe> recipe = world.getRecipeManager()
                .getRecipe(ModRecipeTypes.MAT_ROLLING_RECIPE, inv, world);

        recipe.ifPresent(iRecipe -> {
            ItemStack output = iRecipe.getRecipeOutput();

            craftTheItem(output);
            outcomeTaken();

            markDirty();
        });
    }

    private void craftTheItem(ItemStack output) {
        itemHandler.insertItem(5, output, false);
        itemHandler.insertItem(6, output, false);
    }

    private void outcomeTaken() {
        itemHandler.extractItem(0, 1, false);
        itemHandler.extractItem(1, 1, false);
        itemHandler.extractItem(2, 1, false);
        itemHandler.extractItem(3, 1, false);
        itemHandler.extractItem(4, 1, false);
        giveBowls();
    }

    private void giveBowls() {
        if(!this.world.isRemote()) {
            ItemEntity entityToSpawn = new ItemEntity((World) world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.BOWL));
            entityToSpawn.setPickupDelay((int) 10);
            world.addEntity(entityToSpawn);
        }
    }

    //private void ingredientTaken() {
    //    itemHandler.extractItem(5, 1, false);
    //    itemHandler.extractItem(6, 1, false);
    //}

    @Override
    public void tick() {
        if(world.isRemote)
            return;

            craft();
    }
}
