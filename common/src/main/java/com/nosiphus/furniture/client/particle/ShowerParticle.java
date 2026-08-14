package com.nosiphus.furniture.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;

public class ShowerParticle extends TextureSheetParticle {

    protected ShowerParticle(ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        super(level, x, y, z, xSpeed, ySpeed, zSpeed);
        this.xd *= 0.3D;
        this.yd = -0.2D;
        this.zd *= 0.3D;
        this.setSize(0.1F, 0.1F);
        this.lifetime = 15 + this.random.nextInt(10);

        this.rCol = 0.2F;
        this.gCol = 0.3F;
        this.bCol = 1.0F;
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;

        if (this.lifetime-- <= 0) {
            this.remove();
            return;
        }

        this.move(this.xd, this.yd, this.zd);
        this.yd = -0.2D;

        if (this.onGround) {
            if (this.random.nextDouble() < 0.5D) {
                this.remove();
            }
            this.xd *= 0.7D;
            this.zd *= 0.7D;
        }

        BlockPos pos = BlockPos.containing(this.x, this.y, this.z);
        double blockHeight = this.level.getBlockState(pos)
                .getCollisionShape(this.level, pos)
                .max(Direction.Axis.Y, this.x - pos.getX(), this.z - pos.getZ());

        double fluidHeight = this.level.getFluidState(pos).getHeight(this.level, pos);
        double collisionY = Math.max(blockHeight, fluidHeight);

        if (collisionY > 0.0D && this.y < pos.getY() + collisionY) {
            this.remove();
        }
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            ShowerParticle particle = new ShowerParticle(level, x, y, z, xSpeed, ySpeed, zSpeed);
            particle.pickSprite(this.sprites);
            return particle;
        }
    }
}