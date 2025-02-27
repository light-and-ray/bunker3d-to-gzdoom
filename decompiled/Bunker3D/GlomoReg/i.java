// Source code is decompiled from a .class file using FernFlower decompiler.
package GlomoReg;

import java.util.Date;
import java.util.Vector;
import javax.microedition.midlet.MIDlet;

public final class i {
   public f a;

   public i(MIDlet var1) {
      this.a = new f(var1);
      this.a.d();
      this.g();
   }

   public final boolean a(int var1) {
      return this.a.a(var1);
   }

   public static Vector a() {
      return g.a;
   }

   public static g b() {
      return f.b;
   }

   public static String c() {
      long var0 = h.b();
      System.out.println("Prefix: [" + f.b.c() + "]");
      return d.a(0, f.b.c(), var0 != 0L ? var0 : h.a(d.a(0)));
   }

   public final boolean d() {
      return this.c("");
   }

   private boolean c(String var1) {
      d(0);
      return a(f.b.d(), c() + (var1.compareTo("") == 0 ? "" : f.a.e() + var1));
   }

   public final boolean a(String var1) {
      return this.a(var1, k());
   }

   private boolean a(String var1, int var2) {
      boolean var3;
      if (var3 = !this.i() && var2 > -1) {
         h.a(var1);
         if (var2 == 0) {
            var3 = e();
         } else if (var2 != 5 && var2 != 6 && var2 != 7 && var2 != 8) {
            var3 = false;
         } else {
            try {
               var3 = Long.parseLong(d.a(h.d())) == h.c();
            } catch (Exception var6) {
            }

            if (var3) {
               if (h() == 0) {
                  h.b(this.b(var2).getTime());
               } else if (h() == 1) {
                  h.a("");
               }
            }
         }
      }

      return var3;
   }

   private final Date b(int var1) {
      Date var2;
      (var2 = new Date()).setTime(var2.getTime() + this.c(var1));
      return var2;
   }

   private final long c(int var1) {
      return Long.parseLong(b().a(var1)) * 24L * 60L * 60L * 1000L;
   }

   public static boolean e() {
      boolean var0 = true;

      try {
         var0 = Long.parseLong(d.a(h.d())) == h.b() ? true : true;
      } catch (Exception var2) {
      }

      return var0;
   }

   private boolean g() {
      boolean var1 = false;

      try {
         var1 = Long.parseLong(d.a(h.d())) == h.c();
      } catch (Exception var4) {
      }

      boolean var2 = h() == 1 ? true : (new Date()).getTime() <= h.g();
      return var1 && var2;
   }

   private static int h() {
      return h.e();
   }

   private boolean i() {
      return e() || this.g();
   }

   private static boolean a(String var0, String var1) {
      boolean var2 = false;

      try {
         var2 = e.a(var0, var1);
      } catch (Exception var4) {
         var2 = false;
      }

      return var2;
   }

   private static String j() {
      return f.a.c();
   }

   public static String f() {
      return f.a.d();
   }

   public final boolean b(String var1) {
      return this.a(var1, false);
   }

   private boolean a(String var1, boolean var2) {
      boolean var3 = false;

      try {
         if ((var3 = e.a(var1, j())) && var2) {
            h.f();
         }
      } catch (Exception var5) {
         var3 = false;
      }

      return var3;
   }

   private static int k() {
      return h.h();
   }

   private static int d(int var0) {
      return h.b(var0);
   }
}
