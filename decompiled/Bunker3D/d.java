// Source code is decompiled from a .class file using FernFlower decompiler.
final class d {
    private short a;
    private d b;
    private d c;
    private final b3d_a d;

    private d(b3d_a var1, short var2) {
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
             this.c = new d(this.d, var1);
          }
       } else if (this.b != null) {
          this.b.a(var1);
       } else {
          this.b = new d(this.d, var1);
       }
    }

    private boolean b(short var1) {
       long var2 = (long)(b3d_a.a(this.d)[1][this.a] - b3d_a.a(this.d)[3][this.a]);
       long var4 = (long)(b3d_a.a(this.d)[2][this.a] - b3d_a.a(this.d)[0][this.a]);
       long var6 = (var2 * (long)b3d_a.a(this.d)[0][var1] >> 16) + (var4 * (long)b3d_a.a(this.d)[1][var1] >> 16) + (long)b3d_a.b(this.d)[this.a];
       long var8 = (var2 * (long)b3d_a.a(this.d)[2][var1] >> 16) + (var4 * (long)b3d_a.a(this.d)[3][var1] >> 16) + (long)b3d_a.b(this.d)[this.a];
       return var6 <= 0L && var8 <= 0L;
    }

    private boolean a() {
       return ((long)(b3d_a.a(this.d)[1][this.a] - b3d_a.a(this.d)[3][this.a]) * b3d_a.c(this.d)[0] >> 16) + ((long)(b3d_a.a(this.d)[2][this.a] - b3d_a.a(this.d)[0][this.a]) * b3d_a.c(this.d)[1] >> 16) + ((long)b3d_a.b(this.d)[this.a] * 75000L >> 16) <= 0L;
    }

    d(b3d_a var1, short var2, c var3) {
       this(var1, var2);
    }

    static void a(d var0, short var1) {
       var0.a(var1);
    }

    static boolean a(d var0) {
       return var0.a();
    }

    static d b(d var0) {
       return var0.c;
    }

    static short c(d var0) {
       return var0.a;
    }

    static d d(d var0) {
       return var0.b;
    }
 }
