package com.omicron.bullethell;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.function.Predicate;

public class OrbEntity extends Entity implements IRendersAsItem {

    public OrbEntity(EntityType<?> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void tick() {
        if(this.level.getNearestPlayer(this, Configuration.ORB_LIFE_TIME.get()) == null)
            this.kill();
        /*
        if (!this.isNoGravity()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.04D, 0.0D));
        }


         */
        this.move(MoverType.SELF, this.getDeltaMovement());

        RayTraceResult raytraceresult = getHitResult(this, this::canHitEntity);
        if (raytraceresult.getType() != RayTraceResult.Type.MISS && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, raytraceresult)) {
            this.onHit(raytraceresult);
        }
        /*
        this.setDeltaMovement(this.getDeltaMovement().scale(0.98D));
        if (this.onGround) {
            this.setDeltaMovement(this.getDeltaMovement().multiply(0.7D, -0.5D, 0.7D));
        }
         */
    /*
            this.updateInWaterStateAndDoFluidPushing();
            if (this.level.isClientSide) {
                this.level.addParticle(ParticleTypes.SMOKE, this.getX(), this.getY() + 0.5D, this.getZ(), 0.0D, 0.0D, 0.0D);
            }


     */
    }

    public static RayTraceResult getHitResult(Entity p_234618_0_, Predicate<Entity> p_234618_1_) {
        Vector3d vector3d = p_234618_0_.getDeltaMovement();
        World world = p_234618_0_.level;
        Vector3d vector3d1 = p_234618_0_.position();
        Vector3d vector3d2 = vector3d1.add(vector3d).add(0.3, 0.3, 0.3);
        RayTraceResult raytraceresult = world.clip(new RayTraceContext(vector3d1, vector3d2, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, p_234618_0_));
        if (raytraceresult.getType() != RayTraceResult.Type.MISS) {
            vector3d2 = raytraceresult.getLocation();
        }

        RayTraceResult raytraceresult1 = ProjectileHelper.getEntityHitResult(world, p_234618_0_, vector3d1, vector3d2, p_234618_0_.getBoundingBox().expandTowards(p_234618_0_.getDeltaMovement()).inflate(1.0D), p_234618_1_);
        if (raytraceresult1 != null) {
            raytraceresult = raytraceresult1;
        }

        return raytraceresult;
    }

    @Override
    public IPacket<?> getAddEntityPacket()
    {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack((Items.FIRE_CHARGE));
    }

    protected boolean canHitEntity(Entity entity) {
        if (!entity.isSpectator() && entity.isAlive() && entity.isPickable()) {
            return true;
        } else {
            return false;
        }
    }

    protected void onHit(RayTraceResult pResult) {
        RayTraceResult.Type raytraceresult$type = pResult.getType();
        if (raytraceresult$type == RayTraceResult.Type.ENTITY) {
            this.onHitEntity((EntityRayTraceResult)pResult);
        } else if (raytraceresult$type == RayTraceResult.Type.BLOCK) {
            this.onHitBlock((BlockRayTraceResult)pResult);
        }
        this.kill();
    }

    protected void onHitEntity(EntityRayTraceResult pResult)
    {
        pResult.getEntity().hurt(DamageSource.LAVA, 5);

    }

    protected void onHitBlock(BlockRayTraceResult p_230299_1_)
    {
        this.kill();
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundNBT pCompound) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundNBT pCompound) {

    }
}
