package mods.tesseract.endex.mod.enchants;

import mods.tesseract.endex.Reference;
import mods.tesseract.endex.mod.entity.EntityChronologist;
import mods.tesseract.endex.mod.entity.EntityWatcher;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.DamageSource;

public class EnchantEnder extends Enchantment {

    public EnchantEnder() {
        super(Rarity.RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
        setRegistryName(Reference.MODID, "ender_killer");
        setName("ender_killer");
    }


    public void onEntityDamaged(EntityLivingBase user, Entity target, int level) {
        if ((target instanceof EntityEnderman) || (target instanceof EntityWatcher) || (target instanceof EntityChronologist) || (target instanceof EntityEndermite)) {
            target.attackEntityFrom(DamageSource.causeMobDamage(user), level * 20);
        }
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }
}

