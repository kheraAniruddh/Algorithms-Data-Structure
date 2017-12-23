import java.io.*;

class Serializer implements Serializable{
	int i;
	String s;
	Serializer(int i, String s) {
		this.i = i;
		this.s =s;
	}
	public static void main(String[] args) throws Exception{
		//Marshal
		FileOutputStream fo =  new FileOutputStream("F.ser");
		Serializer s  = new Serializer(1,"Ani");
		ObjectOutputStream os = new ObjectOutputStream(fo);
		os.writeObject(s);
		os.flush();
		//Unmarshal
		FileInputStream fi = new FileInputStream("F.ser");
		ObjectInputStream is = new ObjectInputStream(fi);
		Serializer snew = (Serializer) is.readObject(); 
		System.out.println(snew.i+" "+snew.s);
		System.out.println("Success");
	}
}