//HelloWorld.java

public class HelloWorld {
	public native void cfunction();//Declaring the native function
                           
	static
	{
		System.loadLibrary("Q2");//Linking the native library
	}                                      //which we will be creating.

	public static void main(String args[]) 
	{
		new HelloWorld().cfunction();//Calling the native function
	}
}