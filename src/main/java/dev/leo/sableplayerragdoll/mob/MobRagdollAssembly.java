package dev.leo.activeragdolls.mob;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.phys.Vec3;

public class MobRagdollAssembly {
    private final Mob mob;
    private boolean assembled;

    public MobRagdollAssembly(Mob mob) {
        this.mob = mob;
        this.assembled = false;
    }

    public static void assemble(Mob mob) {
        if (mob == null || !mob.isAlive()) {
            return;
        }

        MobRagdollAssembly assembly = new MobRagdollAssembly(mob);
        assembly.buildRigidBodies();
        assembly.applyJointConstraints();
        assembly.assembled = true;
    }

    private void buildRigidBodies() {
        Vec3 velocity = mob.getDeltaMovement();
        double scale = mob.getAttributeValue(Attributes.SCALE);
        mob.setDeltaMovement(velocity.x * scale, velocity.y, velocity.z * scale);
        mob.setNoGravity(false);
    }

    private void applyJointConstraints() {
        mob.hasImpulse = true;
        mob.setOnGround(false);
    }

    public boolean isAssembled() {
        return this.assembled;
    }

    public Mob getMob() {
        return this.mob;
    }
}