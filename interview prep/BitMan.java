import java.util.BitSet;

class BitMan {
	public static void main(String[] args) {
	BitSet bs = new BitSet(3);
	BitSet bs2 = new BitSet(1);
	bs.set(1000);
	bs.set(11231);
	bs.set(1234453);
	bs2.set(134543);
	bs.xor(bs2);
	System.out.println(bs2);
}
}