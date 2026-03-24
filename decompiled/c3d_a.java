// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
final class c3d_a {
   private short a;
   private c3d_a b;
   private c3d_a c;
   private final b d;

   private c3d_a(b var1, short var2) {
      this.d = var1;
      this.a = var2;
      this.b = null;
      this.c = null;
   }

   private void a(short var1) {
      if (this.b(var1)) {
         if (this.c != null) {
            this.c.a(var1);
         } else {
            this.c = new c3d_a(this.d, var1);
         }
      } else if (this.b != null) {
         this.b.a(var1);
      } else {
         this.b = new c3d_a(this.d, var1);
      }
   }

   private boolean b(short var1) {
      long var2 = (long)(b.a(this.d)[1][this.a] - b.a(this.d)[3][this.a]);
      long var4 = (long)(b.a(this.d)[2][this.a] - b.a(this.d)[0][this.a]);
      long var6 = (var2 * (long)b.a(this.d)[0][var1] >> 16) + (var4 * (long)b.a(this.d)[1][var1] >> 16) + (long)b.b(this.d)[this.a];
      long var8 = (var2 * (long)b.a(this.d)[2][var1] >> 16) + (var4 * (long)b.a(this.d)[3][var1] >> 16) + (long)b.b(this.d)[this.a];
      return var6 <= 0L && var8 <= 0L;
   }

   private boolean a() {
      return ((long)(b.a(this.d)[1][this.a] - b.a(this.d)[3][this.a]) * b.c(this.d)[0] >> 16) + ((long)(b.a(this.d)[2][this.a] - b.a(this.d)[0][this.a]) * b.c(this.d)[1] >> 16) + ((long)b.b(this.d)[this.a] * 75000L >> 16) <= 0L;
   }

   c3d_a(b var1, short var2, d var3) {
      this(var1, var2);
   }

   static void a(c3d_a var0, short var1) {
      var0.a(var1);
   }

   static boolean a(c3d_a var0) {
      return var0.a();
   }

   static c3d_a b(c3d_a var0) {
      return var0.c;
   }

   static short c(c3d_a var0) {
      return var0.a;
   }

   static c3d_a d(c3d_a var0) {
      return var0.b;
   }
}
