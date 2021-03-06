package mrtjp.projectred.api;

import net.minecraft.world.World;

public interface ITransmissionAPI
{
    /**
     * Queries the block on side of this block for the bundled signal being
     * emitted to this block.
     *
     * @param world The world containing the block
     * @param x The x coordinate of the block/tile querying signal
     * @param y The y coordinate of the block/tile querying signal
     * @param z The z coordinate of the block/tile querying signal
     * @param side The side of the block
     * @return A bundled signal {@link IBundledEmitter}
     */
    public byte[] getBundledInput(World world, int x, int y, int z, int side);

    /**
     * Used to register a IBundledTileInteraction to allow PR wiring to use
     * your block's signals without having to implement an interface on your
     * tile entity.
     *
     * @param interaction The interaction class you want to register
     */
    public void registerBundledTileInteraction(IBundledTileInteraction interaction);
}