package com.omicron.bullethell;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.function.Predicate;

public class OrbEntity extends Entity implements IRendersAsItem {

    public OrbEntity(EntityType<?> entityType, World world) {
        super(entityType, world);
    }
    /*
    public void ez()
    {
        Entity entity = Minecraft.getInstance().getCameraEntity();


        float pPartialTicks = Minecraft.getInstance().getFrameTime();

        Minecraft.getInstance().crosshairPickEntity = null;

        double d0 = 0;
        if(Minecraft.getInstance().gameMode != null)
        d0 = (double)Minecraft.getInstance().gameMode.getPickRange();
        //Minecraft.getInstance().hitResult = entity.pick(d0, pPartialTicks, false);
        Vector3d vector3d = entity.getEyePosition(pPartialTicks);
        boolean flag = false;
        int i = 3;
        double d1 = d0;
        if (Minecraft.getInstance().gameMode.hasFarPickRange()) {
            d1 = 6.0D;
            d0 = d1;
        } else {
            if (d0 > 3.0D) {
                flag = true;
            }

            d0 = d0;
        }

        d1 = d1 * d1;
        if (Minecraft.getInstance().hitResult != null) {
            d1 = Minecraft.getInstance().hitResult.getLocation().distanceToSqr(vector3d);
        }

        Vector3d vector3d1 = entity.getViewVector(1.0F);
        Vector3d vector3d2 = vector3d.add(vector3d1.x * d0, vector3d1.y * d0, vector3d1.z * d0);

        AxisAlignedBB axisalignedbb = entity.getBoundingBox().expandTowards(vector3d1.scale(d0)).inflate(1.0D, 1.0D, 1.0D);

        EntityRayTraceResult entityraytraceresult = ProjectileHelper.getEntityHitResult(entity, vector3d, vector3d2, axisalignedbb, (p_215312_0_) -> {
            return !p_215312_0_.isSpectator() && p_215312_0_.isPickable();
        }, d1);

        if(entityraytraceresult != null && entityraytraceresult.getType() == RayTraceResult.Type.ENTITY)
        {
            EntityRayTraceResult a = (EntityRayTraceResult) entityraytraceresult;
            System.out.println(a.getEntity());
        }
    }
     */

    @Override
    public void tick() {
        if(this.level.getNearestPlayer(this, Configuration.ORB_LIFE_TIME.get()) == null)
            this.kill();

        //ez();
        //System.out.println(this.hurt(DamageSource.CACTUS, 1.0F));
        /*
        if (!this.isNoGravity()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.04D, 0.0D));
        }


         */
        this.move(MoverType.SELF, this.getDeltaMovement());
        this.checkInsideBlocks();
        if(this.verticalCollision||this.horizontalCollision)
        {
            this.onHitBlock();
        }
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

    @Override
    public float getPickRadius() {
        return 0.0F;
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        //System.out.println("hurt");
        if (this.isInvulnerableTo(pSource)) {
            return false;
        } else {
            this.markHurt();
            Entity entity = pSource.getEntity();
            if (entity != null && entity instanceof PlayerEntity) {
                //System.out.println("ez");
                this.kill();
                return true;
            } else {
                return false;
            }
        }
    }

    public static RayTraceResult getHitResult(Entity p_234618_0_, Predicate<Entity> p_234618_1_) {
        Vector3d vector3d = p_234618_0_.getDeltaMovement().normalize().scale(0.45);
        World world = p_234618_0_.level;
        Vector3d vector3d1 = p_234618_0_.position();
        Vector3d vector3d2 = vector3d1.add(vector3d);
        RayTraceResult raytraceresult = new RayTraceResult(vector3d1) {
            @Override
            public Type getType() {
                return Type.MISS;
            }
        };// = world.clip(new RayTraceContext(vector3d1, vector3d2, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, p_234618_0_));
        //if (raytraceresult.getType() != RayTraceResult.Type.MISS) {
            //vector3d2 = raytraceresult.getLocation();
        //}

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
            this.onHitBlock();
        }
    }

    protected void onHitEntity(EntityRayTraceResult pResult)
    {
        if(pResult.getEntity() instanceof PlayerEntity)
        {
            pResult.getEntity().hurt(DamageSource.LAVA, 5);
            this.kill();
        }

    }

    protected void onHitBlock()
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

    @Override
    public boolean isPickable() {
        return true;
    }
}
