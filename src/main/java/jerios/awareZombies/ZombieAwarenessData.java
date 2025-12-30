package jerios.awareZombies;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldSavedData;

public class ZombieAwarenessData extends WorldSavedData{
	
	private static final String PROP_NAME = AwareZombies.MODID + "_" + "WorldData";
	
    public ZombieAwarenessData() {
		super(PROP_NAME);
		// TODO Auto-generated constructor stub
	}

	public int zombieCount = 0;
	
	public static final ZombieAwarenessData INSTANCE = new ZombieAwarenessData();

	@Override
	public void readFromNBT(NBTTagCompound p_76184_1_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeToNBT(NBTTagCompound p_76187_1_) {
		// TODO Auto-generated method stub
		
	}

}
