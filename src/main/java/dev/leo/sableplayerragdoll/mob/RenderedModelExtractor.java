package dev.leo.activeragdolls.mob;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import java.util.HashMap;
import java.util.Map;

public class RenderedModelExtractor {
    private static final Map<Entity, Map<String, ModelPart>> MODEL_CACHE = new HashMap<>();

    public static <T extends Entity> void extractModel(T entity, EntityModel<T> model) {
        if (entity == null || model == null) {
            return;
        }

        Map<String, ModelPart> partsMap = new HashMap<>();
        
        if (model instanceof HierarchicalModel<?> hierarchicalModel) {
            ModelPart rootPart = hierarchicalModel.root();
            rootPart.getAllParts().forEach(part -> partsMap.put(part.toString(), part));
        }

        MODEL_CACHE.put(entity, partsMap);
    }

    public static Map<String, ModelPart> getExtractedParts(Entity entity) {
        return MODEL_CACHE.getOrDefault(entity, Map.of());
    }

    public static void clearCache(Entity entity) {
        MODEL_CACHE.remove(entity);
    }
}