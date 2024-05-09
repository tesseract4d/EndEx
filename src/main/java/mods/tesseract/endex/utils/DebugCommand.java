package mods.tesseract.endex.utils;

import com.google.common.collect.Lists;
import mods.tesseract.endex.Reference;
import mods.tesseract.endex.init.BlockInit;
import mods.tesseract.endex.world.feature.WorldGenDune;
import mods.tesseract.endex.world.feature.WorldGenLormyte;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DebugCommand extends CommandBase {
    private final List<String> aliases;
    private static WorldGenLormyte tree = new WorldGenLormyte(1,1);

    public DebugCommand() {
        aliases = Lists.newArrayList(Reference.MODID, "debugDeco", "dd");
    }

    @Override
    @Nonnull
    public String getName() {
        return "thisbiome";
    }

    @Override
    @Nonnull
    public List<String> getAliases() {
        return aliases;
    }

    @Override
    public void execute(@Nonnull MinecraftServer server, @Nonnull ICommandSender sender, @Nonnull String[] args) {
        if (sender instanceof EntityPlayer) {
            double x = ((EntityPlayer) sender).posX;
            double z = ((EntityPlayer) sender).posZ;
            tree.generate(server.getEntityWorld(), new Random(), new BlockPos(x, 4, z));
        }

    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    @Nonnull
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        return Collections.emptyList();
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "debugDeco";
    }

}