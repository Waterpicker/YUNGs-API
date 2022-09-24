package com.yungnickyoung.minecraft.yungsapi.world.condition;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.Optional;

/**
 * Condition for constraining y-value.
 */
public class AltitudeCondition extends StructureCondition {
    public static final Codec<AltitudeCondition> CODEC = RecordCodecBuilder.create((builder) -> builder
            .group(
                    Codec.DOUBLE.optionalFieldOf("bottom_cutoff_y").forGetter(conditon -> conditon.bottomCutoffY),
                    Codec.DOUBLE.optionalFieldOf("top_cutoff_y").forGetter(conditon -> conditon.topCutoffY))
            .apply(builder, AltitudeCondition::new));

    /**
     * The minimum allowed y-value.
     */
    private Optional<Double> bottomCutoffY;

    /**
     * The maximum allowed y-value.
     */
    private Optional<Double> topCutoffY;

    public AltitudeCondition(Optional<Double> bottomCutoffY,
                             Optional<Double> topCutoffY) {
        this.bottomCutoffY = bottomCutoffY;
        this.topCutoffY = topCutoffY;
    }

    @Override
    public StructureConditionType<?> type() {
        return StructureConditionType.ALTITUDE;
    }

    @Override
    public boolean passes(ConditionContext ctx) {
        if (bottomCutoffY.isPresent() && ctx.pieceMinY() < bottomCutoffY.get()) return false;
        if (topCutoffY.isPresent() && ctx.pieceMaxY() > topCutoffY.get()) return false;
        return true;
    }
}
