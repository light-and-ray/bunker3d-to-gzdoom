// Source code is decompiled from a .class file using FernFlower decompiler.
package GlomoReg;

import java.util.Hashtable;
import java.util.Vector;

public final class g extends a {
   public static final Vector a = new Vector(0);
   public static final Hashtable d = new Hashtable(0);
   public static final Hashtable e = new Hashtable(0);
   public static final Hashtable f = new Hashtable(0);
   public static final Hashtable g = new Hashtable(4);

   public g() {
      String[] var1 = new String[]{"name", "prefix", "numReg", "priceReg", "prefix_bonus1", "numBonus1", "priceBonus1", "prefix_spec", "numSpec", "priceSpec", "prefix_subscribe_type1", "numSubscribeType1", "priceSubscribeType1", "durationSubscribeType1", "prefix_subscribe_type2", "numSubscribeType2", "priceSubscribeType2", "durationSubscribeType2", "prefix_subscribe_type3", "numSubscribeType3", "priceSubscribeType3", "durationSubscribeType3", "prefix_subscribe_type4", "numSubscribeType4", "priceSubscribeType4", "durationSubscribeType4", "specParam1", "specParam2", "specParam3", "specParam4"};
      String var2 = "name,pfxReg,snReg,priceReg,pfxBns1,snBns1,priceBns1,pfxSpec,snSpec,priceSpec,pfxSub1,snSub1,priceSub1,prmSub1,pfxSub2,snSub2,priceSub2,prmSub2,pfxSub3,snSub3,priceSub3,prmSub3,pfxSub4,snSub4,priceSub4,prmSub4,param1,param2,param3,param4";
      String[] var3 = new String[]{"name", "code", "prefix", "numReg", "priceReg", "paramReg", "prefix_bonus1", "numBonus1", "priceBonus1", "paramBonus1", "prefix_bonus2", "numBonus2", "priceBonus2", "paramBonus2", "prefix_bonus3", "numBonus3", "priceBonus3", "paramBonus3", "prefix_bonus4", "numBonus4", "priceBonus4", "paramBonus4", "prefix_subscribe_type1", "numSubscribeType1", "priceSubscribeType1", "durationSubscribeType1", "prefix_subscribe_type2", "numSubscribeType2", "priceSubscribeType2", "durationSubscribeType2", "prefix_subscribe_type3", "numSubscribeType3", "priceSubscribeType3", "durationSubscribeType3", "prefix_subscribe_type4", "numSubscribeType4", "priceSubscribeType4", "durationSubscribeType4", "prefix_spec", "numSpec", "priceSpec", "paramSpec", "specParam1", "specParam2", "specParam3", "specParam4"};
      String var4 = "name,code,pfxReg,snReg,priceReg,prmReg,pfxBns1,snBns1,priceBns1,prmBns1,pfxBns2,snBns2,priceBns2,prmBns2,pfxBns3,snBns3,priceBns3,prmBns3,pfxBns4,snBns4,priceBns4,prmBns4,pfxSub1,snSub1,priceSub1,prmSub1,pfxSub2,snSub2,priceSub2,prmSub2,pfxSub3,snSub3,priceSub3,prmSub3,pfxSub4,snSub4,priceSub4,prmSub4,pfxSpec,snSpec,priceSpec,prmSpec,param1,param2,param3,param4";
      if (!g.contains("CFG_1")) {
         g.put("CFG_1", var1);
      }

      if (!g.contains("JAD_1")) {
         g.put("JAD_1", GlomoReg.d.a(",", var2));
      }

      if (!g.contains("CFG_2")) {
         g.put("CFG_2", var3);
      }

      if (!g.contains("JAD_2")) {
         g.put("JAD_2", GlomoReg.d.a(",", var4));
      }

      this.d("-1");
      this.e("Russia");
      this.f("");
      this.g("BOMB");
      this.i("1132");
      this.k("94.00 RUR ex. VAT");
      this.m("");
      this.a(1, (String)"BOMB");
      this.c(1, "1132");
      this.e(1, "7.50 RUR ex. VAT");
      this.h(1, "");
      this.h("SPEC");
      this.j("1136");
      this.l("50 RUR ex.VAT");
      this.n("");
      this.b(5, "SUB1");
      this.d(5, "1133");
      this.f(5, "5.00 RUR ex. VAT");
      this.g(5, "1");
      this.b(6, "SUB2");
      this.d(6, "1134");
      this.f(6, "25.00 RUR ex. VAT");
      this.g(6, "7");
      this.b(7, "SUB3");
      this.d(7, "1135");
      this.f(7, "50.00 RUR ex. VAT");
      this.g(7, "14");
      this.b(8, "SUB4");
      this.d(8, "1137");
      this.f(8, "100.00 RUR ex. VAT");
      this.g(8, "30");
      this.o("");
      this.p("");
      this.q("");
      this.r("");
   }

   public final String a() {
      return this.a("id");
   }

   public final int b() {
      return this.b("id");
   }

   private String f() {
      return this.a("name");
   }

   private String g() {
      return this.a("code");
   }

   public final String c() {
      return this.a("prefix");
   }

   public final String d() {
      return this.a("numReg");
   }

   public final String e() {
      return this.a("priceReg");
   }

   public final String a(int var1) {
      String var10001;
      if (var1 != 5) {
         if (var1 == 6) {
            var10001 = "durationSubscribeType2";
            return this.a(var10001);
         }

         if (var1 == 7) {
            var10001 = "durationSubscribeType3";
            return this.a(var10001);
         }

         if (var1 == 8) {
            var10001 = "durationSubscribeType4";
            return this.a(var10001);
         }
      }

      var10001 = "durationSubscribeType1";
      return this.a(var10001);
   }

   public final String d(String var1) {
      return this.a("id", var1);
   }

   private String e(String var1) {
      return this.a("name", var1);
   }

   private String f(String var1) {
      return this.a("code", var1);
   }

   private String g(String var1) {
      return this.a("prefix", var1);
   }

   private String h(String var1) {
      return this.a("prefix_spec", var1);
   }

   private String a(int var1, String var2) {
      return this.a(!GlomoReg.f.a("1") && var1 != 1 ? (var1 == 2 ? "prefix_bonus2" : (var1 == 3 ? "prefix_bonus3" : (var1 == 4 ? "prefix_bonus4" : "prefix_bonus1"))) : "prefix_bonus1", var2);
   }

   private String b(int var1, String var2) {
      String var10001;
      if (var1 != 5) {
         if (var1 == 6) {
            var10001 = "prefix_subscribe_type2";
            return this.a(var10001, var2);
         }

         if (var1 == 7) {
            var10001 = "prefix_subscribe_type3";
            return this.a(var10001, var2);
         }

         if (var1 == 8) {
            var10001 = "prefix_subscribe_type4";
            return this.a(var10001, var2);
         }
      }

      var10001 = "prefix_subscribe_type1";
      return this.a(var10001, var2);
   }

   private String i(String var1) {
      return this.a("numReg", var1);
   }

   private String c(int var1, String var2) {
      return this.a(!GlomoReg.f.a("1") && var1 != 1 ? (var1 == 2 ? "numBonus2" : (var1 == 3 ? "numBonus3" : (var1 == 4 ? "numBonus4" : "numBonus1"))) : "numBonus1", var2);
   }

   private String j(String var1) {
      return this.a("numSpec", var1);
   }

   private String d(int var1, String var2) {
      String var10001;
      if (var1 != 5) {
         if (var1 == 6) {
            var10001 = "numSubscribeType2";
            return this.a(var10001, var2);
         }

         if (var1 == 7) {
            var10001 = "numSubscribeType3";
            return this.a(var10001, var2);
         }

         if (var1 == 8) {
            var10001 = "numSubscribeType4";
            return this.a(var10001, var2);
         }
      }

      var10001 = "numSubscribeType1";
      return this.a(var10001, var2);
   }

   private String k(String var1) {
      return this.a("priceReg", var1);
   }

   private String e(int var1, String var2) {
      return this.a(!GlomoReg.f.a("1") && var1 != 1 ? (var1 == 2 ? "priceBonus2" : (var1 == 3 ? "priceBonus3" : (var1 == 4 ? "priceBonus4" : "priceBonus1"))) : "priceBonus1", var2);
   }

   private String l(String var1) {
      return this.a("priceSpec", var1);
   }

   private String f(int var1, String var2) {
      String var10001;
      if (var1 != 5) {
         if (var1 == 6) {
            var10001 = "priceSubscribeType2";
            return this.a(var10001, var2);
         }

         if (var1 == 7) {
            var10001 = "priceSubscribeType3";
            return this.a(var10001, var2);
         }

         if (var1 == 8) {
            var10001 = "priceSubscribeType4";
            return this.a(var10001, var2);
         }
      }

      var10001 = "priceSubscribeType1";
      return this.a(var10001, var2);
   }

   private String g(int var1, String var2) {
      String var10001;
      if (var1 != 5) {
         if (var1 == 6) {
            var10001 = "durationSubscribeType2";
            return this.a(var10001, var2);
         }

         if (var1 == 7) {
            var10001 = "durationSubscribeType3";
            return this.a(var10001, var2);
         }

         if (var1 == 8) {
            var10001 = "durationSubscribeType4";
            return this.a(var10001, var2);
         }
      }

      var10001 = "durationSubscribeType1";
      return this.a(var10001, var2);
   }

   private String m(String var1) {
      return this.a("paramReg", var1);
   }

   private String h(int var1, String var2) {
      return this.a(!GlomoReg.f.a("1") && var1 != 1 ? (var1 == 2 ? "paramBonus2" : (var1 == 3 ? "paramBonus3" : (var1 == 4 ? "paramBonus4" : "paramBonus1"))) : "paramBonus1", var2);
   }

   private String n(String var1) {
      return this.a("paramSpec", var1);
   }

   private String o(String var1) {
      return this.a("specParam1", var1);
   }

   private String p(String var1) {
      return this.a("specParam2", var1);
   }

   private String q(String var1) {
      return this.a("specParam3", var1);
   }

   private String r(String var1) {
      return this.a("specParam4", var1);
   }

   private int a(g var1, int var2) {
      return this.a(var1.b(), var2, var1.f(), var1.g());
   }

   private int a(int var1, int var2, String var3, String var4) {
      int var5 = a.size();
      a.setSize(var5 + 1);
      a.setElementAt(new c(this, var1, var3, var4), var5);
      d.put(new Integer(GlomoReg.f.e() ? var2 : var1), new Integer(var5));
      return var5;
   }

   private static int d(int var0) {
      if (var0 >= 0 && var0 < a.size()) {
         c var1 = (c)a.elementAt(var0);
         e.put(var1.a(), new Integer(var1.c()));
         f.put(var1.b(), new Integer(var1.c()));
         return var0;
      } else {
         return -1;
      }
   }

   private g a(int var1, String[] var2) {
      this.d(String.valueOf(var1));
      this.a((String[])((String[])g.get("CFG_" + GlomoReg.f.a())), var2);
      return this;
   }

   private int b(String[] var1) {
      this.c(var1);
      h();
      String var2 = null;
      String var3 = null;

      for(int var4 = 0; ((var2 = this.c("c_" + String.valueOf(var4) + "_code")) + (var3 = this.c("c_" + String.valueOf(var4) + "_name"))).compareTo("") != 0; ++var4) {
         int var6 = -1;
         g var5;
         if (null != (var5 = this.a(var1, var3, var2))) {
            var6 = var5.b();
         }

         if (var3.compareTo("") == 0) {
            var3 = var5 != null ? var5.f() : var2;
         } else if (var2.compareTo("") == 0) {
            var2 = var5 != null ? var5.g() : var3;
         }

         ((c)a.elementAt(this.a(var4, var6, var3, var2))).a(var6);
      }

      return a.size();
   }

   private int c(String[] var1) {
      g var2 = new g();
      h();
      i();

      for(int var5 = 1; var5 < var1.length; ++var5) {
         String[] var3 = GlomoReg.d.a(";", var1[var5]);
         var2.a(var5, var3);
         if (var3.length > 1) {
            d(this.a(var2, var2.b()));
         }
      }

      return a.size();
   }

   public final int a(String[] var1) {
      return GlomoReg.f.e() ? this.b(var1) : this.c(var1);
   }

   private g a(String[] var1, String var2, String var3) {
      int var4 = -1;
      Hashtable var10000;
      String var10001;
      if (var3.compareTo("") != 0 && f.containsKey(var3)) {
         var10000 = f;
         var10001 = var3;
      } else {
         if (var2.compareTo("") == 0 || !e.containsKey(var2)) {
            return var4 >= 0 ? this.c(var1, var4) : null;
         }

         var10000 = e;
         var10001 = var2;
      }

      var4 = (Integer)var10000.get(var10001);
      return var4 >= 0 ? this.c(var1, var4) : null;
   }

   private static c e(int var0) {
      return (c)a.elementAt((Integer)d.get(new Integer(var0)));
   }

   private g b(String[] var1, int var2) {
      if (var2 < 0) {
         return null;
      } else {
         g var3 = this.c(var1, e(var2).d());
         String[] var4 = (String[])((String[])g.get("JAD_" + GlomoReg.f.a()));
         String[] var5 = (String[])((String[])g.get("CFG_" + GlomoReg.f.a()));

         for(int var6 = 0; var6 < var4.length; ++var6) {
            String var7;
            if ((var7 = this.c("c_" + String.valueOf((Integer)d.get(new Integer(var2))) + "_" + var4[var6])).compareTo("") != 0) {
               var3.a(var5[var6], var7);
            }
         }

         return var3;
      }
   }

   private g c(String[] var1, int var2) {
      if (var2 < var1.length && var2 >= 0) {
         g var3;
         (var3 = new g()).a(this.c);
         var3.a(var2, GlomoReg.d.a(";", var1[var2]));
         return var3;
      } else {
         return null;
      }
   }

   public final g a(String[] var1, int var2) {
      return GlomoReg.f.e() ? this.b(var1, var2) : this.c(var1, var2);
   }

   public static final int b(int var0) {
      if (var0 >= 0 && var0 < a.size()) {
         return GlomoReg.f.e() ? ((c)a.elementAt(var0)).d() : ((c)a.elementAt(var0)).c();
      } else {
         return -1;
      }
   }

   public static final int c(int var0) {
      Integer var1;
      return (var1 = (Integer)d.get(new Integer(var0))) == null ? -1 : var1;
   }

   private static void h() {
      a.setSize(0);
      d.clear();
   }

   private static void i() {
      f.clear();
      e.clear();
   }
}
