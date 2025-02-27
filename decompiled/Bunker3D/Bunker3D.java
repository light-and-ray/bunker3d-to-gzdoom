// Source code is decompiled from a .class file using FernFlower decompiler.
import GlomoReg.i;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

public class Bunker3D extends MIDlet {
   private b3d_a b3d_a;
   private static Bunker3D b;
   private i c;

   public final i a() {
      return this.c;
   }

   public static Bunker3D b() {
      return b;
   }

   public Bunker3D() {
      b = this;
      this.c = new i(this);
   }

   public void startApp() {
      this.b3d_a = new b3d_a();
      Display.getDisplay(this).setCurrent(this.b3d_a);
   }

   public void pauseApp() {
   }

   public void destroyApp(boolean var1) {
      this.notifyDestroyed();
   }
}
