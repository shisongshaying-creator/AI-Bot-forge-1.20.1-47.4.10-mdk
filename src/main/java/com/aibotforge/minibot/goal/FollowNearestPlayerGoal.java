package com.aibotforge.minibot.goal;

import java.util.EnumSet;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;

public class FollowNearestPlayerGoal extends Goal {
    private final PathfinderMob mob;
    private final double speedModifier;
    private final float maxDistance;
    private final float minDistance;
    private Player target;

    public FollowNearestPlayerGoal(PathfinderMob mob, double speedModifier, float maxDistance, float minDistance) {
        this.mob = mob;
        this.speedModifier = speedModifier;
        this.maxDistance = maxDistance;
        this.minDistance = minDistance;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        Player nearest = mob.level().getNearestPlayer(mob, maxDistance);
        if (nearest == null) {
            return false;
        }
        if (mob.distanceTo(nearest) <= minDistance) {
            return false;
        }
        this.target = nearest;
        return true;
    }

    @Override
    public boolean canContinueToUse() {
        if (target == null || !target.isAlive()) {
            return false;
        }
        double distance = mob.distanceTo(target);
        return distance > minDistance && distance <= maxDistance;
    }

    @Override
    public void start() {
        if (target != null) {
            mob.getNavigation().moveTo(target, speedModifier);
        }
    }

    @Override
    public void stop() {
        target = null;
        mob.getNavigation().stop();
    }

    @Override
    public void tick() {
        if (target == null) {
            return;
        }
        mob.getLookControl().setLookAt(target, 30.0f, 30.0f);
        mob.getNavigation().moveTo(target, speedModifier);
    }
}
