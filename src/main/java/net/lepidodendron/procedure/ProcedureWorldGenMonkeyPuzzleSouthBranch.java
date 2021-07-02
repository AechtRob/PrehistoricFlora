package net.lepidodendron.procedure;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.block.BlockMonkeypuzzleLeaves;
import net.lepidodendron.block.BlockMonkeypuzzleLog;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;


@ElementsLepidodendronMod.ModElement.Tag
public class ProcedureWorldGenMonkeyPuzzleSouthBranch extends ElementsLepidodendronMod.ModElement {
	public ProcedureWorldGenMonkeyPuzzleSouthBranch(ElementsLepidodendronMod instance) {
		super(instance, 42);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure WorldGenMonkeyPuzzleSouthBranch!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure WorldGenMonkeyPuzzleSouthBranch!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure WorldGenMonkeyPuzzleSouthBranch!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WorldGenMonkeyPuzzleSouthBranch!");
			return;
		}
		if (dependencies.get("TrunkHeight") == null) {
			System.err.println("Failed to load dependency TrunkHeight for procedure WorldGenMonkeyPuzzleSouthBranch!");
			return;
		}
		if (dependencies.get("smalltree") == null) {
			System.err.println("Failed to load dependency smalltree for procedure WorldGenMonkeyPuzzleSouthBranch!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		int xx = (int) dependencies.get("x");
		int yy = (int) dependencies.get("y");
		int zz = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double TrunkHeight = (double) dependencies.get("TrunkHeight");
		
		double randomiser = 0;
		int counter = 0;
		int branchlen = 0;

		boolean smalltree = (boolean) dependencies.get("smalltree");

		double densifier = 1;
		if (smalltree) {
			densifier = 1.25;
		}
		
		zz = z;
		yy = y - 6;
		if (Math.random() > 0.5) {
			xx = x;
		}
		else {
			xx = x + 1;
		}
		counter = 0;
		branchlen = (int) Math.round(TrunkHeight/4)  + (int) Math.round(Math.random() * 2);
		while (counter <= branchlen) {
			ProcedureTreeLog.executeProcedure(xx, yy, (zz + counter), world, BlockMonkeypuzzleLog.block, EnumFacing.WEST);
			ProcedureLeavesAroundLog.executeProcedure(xx, yy, (zz + counter), world, BlockMonkeypuzzleLeaves.block, 1, 0.8 * densifier);
			counter = counter + 1;
		}
		ProcedureLeavesAroundLog.executeProcedure(xx, yy, (zz + counter), world, BlockMonkeypuzzleLeaves.block, 1, 0.2 * densifier);

		counter = 1;
		while ((counter <= (branchlen / 2)) && (Math.round(branchlen/3) > 1)) {
			ProcedureTreeLog.executeProcedure(xx + counter, yy, (zz + (int) Math.round(branchlen/3)), world, BlockMonkeypuzzleLog.block, EnumFacing.UP);
			ProcedureLeavesAroundLog.executeProcedure(xx + counter, yy, (zz + (int) Math.round(branchlen/3)), world, BlockMonkeypuzzleLeaves.block, 1, 0.6 * densifier);
			ProcedureTreeLog.executeProcedure(xx - counter, yy, (zz + (int) Math.round(branchlen/3)), world, BlockMonkeypuzzleLog.block, EnumFacing.UP);
			ProcedureLeavesAroundLog.executeProcedure(xx - counter, yy, (zz + (int) Math.round(branchlen/3)), world, BlockMonkeypuzzleLeaves.block, 1, 0.6 * densifier);
			counter = counter + 1;
		}
		ProcedureLeavesAroundLog.executeProcedure(xx - counter, yy, (zz + (int) Math.round(branchlen/3)), world, BlockMonkeypuzzleLeaves.block, 2, 0.2 * densifier);
		ProcedureTreeLog.executeProcedure(xx, yy + 1, (zz + (int) Math.round(branchlen/3)), world, BlockMonkeypuzzleLog.block, EnumFacing.NORTH);
		ProcedureLeavesAroundLog.executeProcedure(xx, yy + 1, (zz + (int) Math.round(branchlen/3)), world, BlockMonkeypuzzleLeaves.block, 2, 0.1 * densifier);
		
		if (Math.random() > 0.5) {
			zz = z + branchlen - 4;
		}
		else {
			zz = z + branchlen - 3;
		}
		ProcedureTreeLog.executeProcedure(xx + 1, yy, zz, world, BlockMonkeypuzzleLog.block, EnumFacing.UP);
		ProcedureLeavesAroundLog.executeProcedure(xx + 1, yy, zz, world, BlockMonkeypuzzleLeaves.block, 1, 0.8 * densifier);
		ProcedureTreeLog.executeProcedure(xx + 2, yy, zz, world, BlockMonkeypuzzleLog.block, EnumFacing.UP);
		ProcedureLeavesAroundLog.executeProcedure(xx + 2, yy, zz, world, BlockMonkeypuzzleLeaves.block, 1, 0.8 * densifier);
		if (Math.random() > 0.5) {
			ProcedureTreeLog.executeProcedure(xx + 3, yy, zz, world, BlockMonkeypuzzleLog.block, EnumFacing.UP);
			ProcedureLeavesAroundLog.executeProcedure(xx + 3, yy, zz, world, BlockMonkeypuzzleLeaves.block, 1, 0.6 * densifier);
			ProcedureTreeLog.executeProcedure(xx + 3, yy, zz + 1, world, BlockMonkeypuzzleLog.block, EnumFacing.WEST);
			ProcedureLeavesAroundLog.executeProcedure(xx + 3, yy, zz + 1, world, BlockMonkeypuzzleLeaves.block, 2, 0.2 * densifier);
		}
		else {
			ProcedureTreeLog.executeProcedure(xx + 2, yy, zz + 1, world, BlockMonkeypuzzleLog.block, EnumFacing.WEST);
			ProcedureLeavesAroundLog.executeProcedure(xx + 2, yy, zz + 1, world, BlockMonkeypuzzleLeaves.block, 2, 0.2 * densifier);
		}

		if (Math.random() > 0.5) {
			zz = z + branchlen - 4;
		}
		else {
			zz = z + branchlen - 3;
		}
		ProcedureTreeLog.executeProcedure(xx - 1, yy, zz, world, BlockMonkeypuzzleLog.block, EnumFacing.UP);
		ProcedureLeavesAroundLog.executeProcedure(xx - 1, yy, zz, world, BlockMonkeypuzzleLeaves.block, 1, 0.8 * densifier);
		ProcedureTreeLog.executeProcedure(xx - 2, yy, zz, world, BlockMonkeypuzzleLog.block, EnumFacing.UP);
		ProcedureLeavesAroundLog.executeProcedure(xx - 2, yy, zz, world, BlockMonkeypuzzleLeaves.block, 1, 0.8 * densifier);
		if (Math.random() > 0.5) {
			ProcedureTreeLog.executeProcedure(xx - 3, yy, zz, world, BlockMonkeypuzzleLog.block, EnumFacing.UP);
			ProcedureLeavesAroundLog.executeProcedure(xx - 3, yy, zz, world, BlockMonkeypuzzleLeaves.block, 1, 0.6 * densifier);
			ProcedureTreeLog.executeProcedure(xx - 3, yy, zz + 1, world, BlockMonkeypuzzleLog.block, EnumFacing.WEST);
			ProcedureLeavesAroundLog.executeProcedure(xx - 3, yy, zz + 1, world, BlockMonkeypuzzleLeaves.block, 2, 0.2 * densifier);
		}
		else {
			ProcedureTreeLog.executeProcedure(xx - 2, yy, zz + 1, world, BlockMonkeypuzzleLog.block, EnumFacing.WEST);
			ProcedureLeavesAroundLog.executeProcedure(xx - 2, yy, zz + 1, world, BlockMonkeypuzzleLeaves.block, 2, 0.2 * densifier);
		}

		zz = z;
		yy = y - 3;
		if (Math.random() > 0.5) {
			xx = x;
		}
		else {
			xx = x + 1;
		}
		counter = 0;
		branchlen = (int) Math.round(TrunkHeight/10)  + (int) Math.round(Math.random() * 3);
		while (counter <= branchlen) {
			ProcedureTreeLog.executeProcedure(xx, yy, (zz + counter), world, BlockMonkeypuzzleLog.block, EnumFacing.WEST);
			ProcedureLeavesAroundLog.executeProcedure(xx, yy, (zz + counter), world, BlockMonkeypuzzleLeaves.block, 1, 0.8 * densifier);
			counter = counter + 1;
		}
		ProcedureLeavesAroundLog.executeProcedure(xx, yy, (zz + counter), world, BlockMonkeypuzzleLeaves.block, 1, 0.2 * densifier);
		counter = 1;
		while ((counter <= (branchlen / 2)) && (Math.round(branchlen/3) > 1)) {
			ProcedureTreeLog.executeProcedure(xx + counter, yy, (zz + (int) Math.round(branchlen/3)), world, BlockMonkeypuzzleLog.block, EnumFacing.UP);
			ProcedureLeavesAroundLog.executeProcedure(xx + counter, yy, (zz + (int) Math.round(branchlen/3)), world, BlockMonkeypuzzleLeaves.block, 1, 0.6 * densifier);
			ProcedureTreeLog.executeProcedure(xx - counter, yy, (zz + (int) Math.round(branchlen/3)), world, BlockMonkeypuzzleLog.block, EnumFacing.UP);
			ProcedureLeavesAroundLog.executeProcedure(xx - counter, yy, (zz + (int) Math.round(branchlen/3)), world, BlockMonkeypuzzleLeaves.block, 1, 0.6 * densifier);
			counter = counter + 1;
		}
		ProcedureLeavesAroundLog.executeProcedure(xx - counter, yy, (zz + (int) Math.round(branchlen/3)), world, BlockMonkeypuzzleLeaves.block, 2, 0.2 * densifier);
		ProcedureTreeLog.executeProcedure(xx, yy + 1, (zz + (int) Math.round(branchlen/3)), world, BlockMonkeypuzzleLog.block, EnumFacing.NORTH);
		ProcedureLeavesAroundLog.executeProcedure(xx, yy + 1, (zz + (int) Math.round(branchlen/3)), world, BlockMonkeypuzzleLeaves.block, 2, 0.1 * densifier);
		if (Math.random() > 0.5) {
			zz = z + branchlen - 2;
		}
		else {
			zz = z + branchlen - 1;
		}
		ProcedureTreeLog.executeProcedure(xx + 1, yy, zz, world, BlockMonkeypuzzleLog.block, EnumFacing.UP);
		ProcedureLeavesAroundLog.executeProcedure(xx + 1, yy, zz, world, BlockMonkeypuzzleLeaves.block, 1, 0.8 * densifier);
		if (Math.random() > 0.5) {
			ProcedureTreeLog.executeProcedure(xx + 2, yy, zz, world, BlockMonkeypuzzleLog.block, EnumFacing.UP);
			ProcedureLeavesAroundLog.executeProcedure(xx + 2, yy, zz, world, BlockMonkeypuzzleLeaves.block, 1, 0.6 * densifier);
			ProcedureTreeLog.executeProcedure(xx + 2, yy, zz + 1, world, BlockMonkeypuzzleLog.block, EnumFacing.WEST);
			ProcedureLeavesAroundLog.executeProcedure(xx + 2, yy, zz + 1, world, BlockMonkeypuzzleLeaves.block, 2, 0.2 * densifier);
		}
		else {
			ProcedureTreeLog.executeProcedure(xx + 1, yy, zz + 1, world, BlockMonkeypuzzleLog.block, EnumFacing.WEST);
			ProcedureLeavesAroundLog.executeProcedure(xx + 1, yy, zz + 1, world, BlockMonkeypuzzleLeaves.block, 2, 0.2 * densifier);
		}

		if (Math.random() > 0.5) {
			zz = z + branchlen - 2;
		}
		else {
			zz = z + branchlen - 1;
		}
		ProcedureTreeLog.executeProcedure(xx - 1, yy, zz, world, BlockMonkeypuzzleLog.block, EnumFacing.UP);
		ProcedureLeavesAroundLog.executeProcedure(xx - 1, yy, zz, world, BlockMonkeypuzzleLeaves.block, 1, 0.8 * densifier);
		if (Math.random() > 0.5) {
			ProcedureTreeLog.executeProcedure(xx - 2, yy, zz, world, BlockMonkeypuzzleLog.block, EnumFacing.UP);
			ProcedureLeavesAroundLog.executeProcedure(xx - 2, yy, zz, world, BlockMonkeypuzzleLeaves.block, 1, 0.6 * densifier);
			ProcedureTreeLog.executeProcedure(xx - 2, yy, zz + 1, world, BlockMonkeypuzzleLog.block, EnumFacing.WEST);
			ProcedureLeavesAroundLog.executeProcedure(xx - 2, yy, zz + 1, world, BlockMonkeypuzzleLeaves.block, 2, 0.2 * densifier);
		}
		else {
			ProcedureTreeLog.executeProcedure(xx - 1, yy, zz + 1, world, BlockMonkeypuzzleLog.block, EnumFacing.WEST);
			ProcedureLeavesAroundLog.executeProcedure(xx - 1, yy, zz + 1, world, BlockMonkeypuzzleLeaves.block, 2, 0.2 * densifier);
		}

		zz = z;
		yy = y - 1;
		if (Math.random() > 0.5) {
			xx = x;
		}
		else {
			xx = x + 1;
		}
		counter = 0;
		branchlen = (int) Math.round(TrunkHeight/55)  + (int) Math.round(Math.random());
		while (counter <= branchlen) {
			ProcedureTreeLog.executeProcedure(xx, yy, (zz + counter), world, BlockMonkeypuzzleLog.block, EnumFacing.WEST);
			ProcedureLeavesAroundLog.executeProcedure(xx, yy, (zz + counter), world, BlockMonkeypuzzleLeaves.block, 2, 0.8 * densifier);
			counter = counter + 1;
		}
		ProcedureLeavesAroundLog.executeProcedure(xx, yy, (zz + counter), world, BlockMonkeypuzzleLeaves.block, 2, 0.2 * densifier);
		
	}
}