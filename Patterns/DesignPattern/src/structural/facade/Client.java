/* Complex parts */
// Subsystem class A

class CPU {
        public void freeze() { System.out.println("CPU Freeze."); }
        public void jump(long position) {System.out.println("CPU Jump."); }
        public void execute() { System.out.println("CPU Execute");}
}
 
// Subsystem class B

class Memory {
        public void load(long position, byte[] data) {
                System.out.println("Memory loading.");
        }
}
 
// Subsystem class C

class HardDrive {
        public byte[] read(long lba, int size) {
                 System.out.println("Reading harddrive.");
				 byte obj[] = new byte[10];
				 return obj;
        }
}
 
/* Façade */
 
class Computer {

	private CPU cpu;
	private Memory memory;
	private HardDrive hdd;
	private long BOOT_ADDRESS = 1000l;
	private long BOOT_SECTOR = 2000l;
	private int SECTOR_SIZE = 25;

	Computer()
	{
		cpu = new CPU();
		memory = new Memory();
		hdd = new HardDrive();

	}

        public void startComputer() {
			    System.out.println("facade is invoked.");
                cpu.freeze();
                memory.load(BOOT_ADDRESS, hdd.read(BOOT_SECTOR, SECTOR_SIZE));
                cpu.jump(BOOT_ADDRESS);
                cpu.execute();				
        }
}
 
/* Client */
 
class Client {
        public static void main(String[] args) throws Exception {
                Computer facade = new Computer();
                facade.startComputer();
        }
}
