

   private void loadTextures_subfunction1(int[] var1, byte[][][] var2, byte[][][] var3, int var4) {
      byte var5 = var2[2][var4][0];
      byte var6 = var2[2][var4][1];
      byte var7 = var2[2][var4][2];
      byte var8 = var2[2][var4][3];
      byte var9 = var2[2][var4][4];
      boolean var10 = var3[9][var4][0] == 1 || var3[9][var4][0] == 11 || var3[9][var4][0] == 15;
      if (var5 != 0 || var6 != 0 || var7 != 0 || var8 != 0 || var9 != 0) {
         this.loadTextures_subfunction8(var1, var5, var6, var7, var8, var9, var10);
      }

   }

   private void loadTextures_subfunction2(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var11 = var4 * var5 + var3;
      int var10 = 0;
      int var14 = var4 + var7;

      for(int var9 = var4; var9 < var14; ++var9) {
         int var12 = var11 + var6;

         for(int var8 = var11; var8 < var12; ++var8) {
            int var13;
            if ((var13 = var2[var10]) != this.backgroundColor) {
               var1[var8] = var13;
            }

            ++var10;
         }

         var11 += var5;
      }

   }


   private void loadTextures_subfunction3(byte[][][] var1, byte[][][] var2, int var3, int var4, int var5, int var6, int var7) {
      byte var8 = var2[9][var3][0];
      byte var9 = var1[2][var3][5];
      byte var10 = this.q[6 * var8];
      Image var11;
      if (this.P != var3 && var5 != var6) {
         if (var4 == 0) {
            if (var9 != 12) {
               this.C = this.readImage("/" + String.valueOf(var10) + this.dataExt);
            } else {
               var11 = this.readImage("/" + String.valueOf(var10) + this.dataExt);
               this.C = Image.createImage(var11, 0, 0, var11.getWidth(), var11.getHeight(), 5);
            }
         } else {
            this.D = this.readImage("/" + String.valueOf(var10) + this.dataExt);
         }
      }

      if (this.P != var3) {
         Image var10000;
         int[] var10001;
         if (var4 == 0) {
            var10000 = this.C;
            var10001 = this.I;
         } else {
            this.G = new int[this.K * this.L];
            var10000 = this.D;
            var10001 = this.G;
         }

         var10000.getRGB(var10001, 0, this.K, var1[4][var3][0], var1[4][var3][1], this.K, this.L);
         if (!this.gB) {
            a var15;
            if (var4 != 0) {
               var15 = this;
               var10001 = this.G;
            } else {
               var15 = this;
               var10001 = this.I;
            }

            var15.a(var10001, var1, var2, var3);
         }

         if (this.q[6 * var2[9][var3][0] + 5] == 2) {
            var11 = this.readImage("/" + String.valueOf(var10) + var10 + this.dataExt);
            int[] var14 = new int[9216];
            var11.getRGB(var14, 0, 96, 0, 0, 96, 96);
            this.loadTextures_subfunction2(this.I, var14, 0, 0, 96, 96, 96);
         }

         if (var4 == 0 && var7 == var3) {
            this.P = var3;
            this.H = new int[this.K * this.L];
            this.loadTextures_subfunction2(this.H, this.I, 0, 0, this.K, this.K, this.L);
         }

      } else {
         int var13 = this.H.length;

         for(int var12 = 0; var12 < var13; ++var12) {
            this.I[var12] = this.H[var12];
         }

      }
   }



   private void loadTextures_subfunction4(int[] var1, int var2, int var3, int var4, byte var5, int var6, int var7) {
      if (var5 == 0) {
         if (this.Q != 15 && this.Q != 60) {
            this.loadTextures_subfunction2(this.I, var1, var6, var7, var2, var3, var4);
         } else {
            this.loadTextures_subfunction9(this.I, var1, var6, var7, var2, var3, var4);
         }
      } else if (var5 == 1) {
         this.loadTextures_subfunction10(this.I, var1, var6, var7, var2, var3, var4);
      } else if (var5 == 2) {
         this.loadTextures_subfunction11(this.I, var1, var6, var7, var2, var3, var4);
      } else if (var5 == 3) {
         this.loadTextures_subfunction12(this.I, var1, var6, var7, var2, var3, var4);
      } else {
         if (var5 != 5) {
            if (var5 == 6) {
               this.loadTextures_subfunction13(this.I, var1, var6, var7, var2, var3, var4);
               return;
            }

            if (var5 == 10) {
               this.loadTextures_subfunction14(this.I, var1, var6, var7, var2, var3, var4);
               return;
            }

            if (var5 != 11) {
               return;
            }
         }

         this.loadTextures_subfunction15(this.I, var1, var6, var7, var2, var3, var4, var5);
      }
   }



   private int loadTextures_subfunction5(byte var1, byte var2, byte var3, byte var4, byte var5, short var6, int var7, short var8, byte var9) {
      this.bk[var3] = var7;
      int var10 = this.loadTextures_subfunction6((byte)0, var1, (short)var8, var7);
      var10 = this.loadTextures_subfunction6(var9, var2, (short)0, var10);
      var10 = this.loadTextures_subfunction6((byte)(var9 + var5), var1, (short)((byte)(var4 + var5)), var10);
      this.bk[var3 + 1] = var10;
      this.bs[var3] = var6;
      return var10;
   }


    private int loadTextures_subfunction6(byte var1, byte var2, short var3, int var4) {
      this.br[var4] = (short)var1;
      int var5 = var4 + 1;
      this.br[var5] = (short)var2;
      ++var5;
      this.br[var5] = var3;
      ++var5;
      return var5;
   }



   private static void loadTextures_subfunction7(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int[] var8, boolean var9) {
      int var17 = var3 + var4;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      if (var9) {
         int var18 = (var13 = var6 * var5) + var5;
         var15 = var3 + var13 * var7;
         var16 = var7 * var5;
         var12 = 0;

         for(var10 = var3; var10 < var17; ++var10) {
            var14 = var15;

            for(var11 = var13; var11 < var18; ++var11) {
               var0[var2 + var12] = (int)((long)var8[var14] | 0L);
               var1[var2 + var12] = (int)((long)var8[var14 + var16] | 0L);
               ++var12;
               var14 += var7;
            }

            ++var15;
         }
      } else {
         var13 = (var6 + 2) * var5 - 1;
         boolean var19 = false;
         var15 = var3 + var13 * var7;
         var16 = var7 * var5;
         var12 = 0;

         for(var10 = var3; var10 < var3 + var4; ++var10) {
            var14 = var15;

            for(var11 = var13; var11 > var13 - var5; --var11) {
               var0[var2 + var12] = (int)((long)var8[var14] | 0L);
               var1[var2 + var12] = (int)((long)var8[var14 - var16] | 0L);
               ++var12;
               var14 -= var7;
            }

            ++var15;
         }
      }

   }




   private void loadTextures_subfunction8(int[] var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      int var10 = 1;
      boolean var11 = false;
      int var12 = var1.length;
      int[] var13 = new int[257];
      int[] var14 = new int[257];

      for(int var8 = 0; var8 < var12; ++var8) {
         int var16;
         if ((var16 = var1[var8]) != this.backgroundColor) {
            int var9 = var16 & 255;
            int var17;
            if ((var17 = var13[var9]) > 0) {
               var1[var8] = var14[var17];
            } else {
               var13[var9] = var10;
               var1[var8] = this.loadTextures_subfunction16(var2, var3, var4, var5, var6, var9, var7);
               var14[var10] = var1[var8];
               ++var10;
            }
         }
      }

   }


   private void loadTextures_subfunction9(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var11 = var4 * var5 + var3;
      int var10 = 0;
      int var14 = var4 + var7;

      for(int var9 = var4; var9 < var14; ++var9) {
         int var12 = var11 + var6;

         for(int var8 = var11; var8 < var12; ++var8) {
            int var13;
            int[] var10000;
            int var10001;
            int var10002;
            if ((var13 = var2[var10]) != this.backgroundColor) {
               var10000 = var1;
               var10001 = var8;
               var10002 = var13;
            } else {
               var10000 = var1;
               var10001 = var8;
               var10002 = this.aW & 16777215;
            }

            var10000[var10001] = var10002;
            ++var10;
         }

         var11 += var5;
      }

   }



   private void loadTextures_subfunction10(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var12 = var4 * var5 + var3;
      int var13 = 2 * var6 - 1;
      int var11 = 0;
      int var16 = var4 + var7;

      for(int var10 = var4; var10 < var16; ++var10) {
         int var14 = var12 + var6;
         int var9 = var12 + var13;

         for(int var8 = var12; var8 < var14; ++var8) {
            int var15;
            if ((var15 = var2[var11]) != this.backgroundColor) {
               var1[var8] = var15;
               var1[var9] = var15;
            }

            ++var11;
            --var9;
         }

         var12 += var5;
      }

   }



   private void loadTextures_subfunction11(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var12 = (var4 + var7 - 1) * var5 + var3;
      int var13 = 2 * var6 - 1;
      int var11 = 0;

      for(int var10 = var4 + var7 - 1; var10 >= var4; --var10) {
         int var14 = var12 + var6;
         int var9 = var12 + var13;

         for(int var8 = var12; var8 < var14; ++var8) {
            int var15;
            if ((var15 = var2[var11]) != this.backgroundColor) {
               var1[var8] = var15;
               var1[var9] = var15;
            }

            ++var11;
            --var9;
         }

         var12 -= var5;
      }

   }

   private void loadTextures_subfunction12(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var11 = var4 * var5 + var3;
      int var10 = 0;
      int var14 = var4 + var7;

      for(int var9 = var4; var9 < var14; ++var9) {
         int var12 = var11 + var6;

         for(int var8 = var11; var8 < var12; ++var8) {
            int var13;
            if ((var13 = var2[var10]) != this.backgroundColor) {
               var1[var8] = var13;
               var1[var8 + var6] = var13;
            }

            ++var10;
         }

         var11 += var5;
      }

   }



   private void loadTextures_subfunction13(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var12 = var4 * var5 + var3;
      int var9 = var5 * var7;
      int var11 = 0;
      int var15 = var4 + var7;

      for(int var10 = var4; var10 < var15; ++var10) {
         int var13 = var12 + var6;

         for(int var8 = var12; var8 < var13; ++var8) {
            int var14;
            if ((var14 = var2[var11]) != this.backgroundColor) {
               var1[var8] = var14;
               var1[var8 + var9] = var14;
            }

            ++var11;
         }

         var12 += var5;
      }

   }

   private void loadTextures_subfunction14(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var11 = var4 * var5 + (var3 + var5 - 1);
      int var10 = 0;
      int var14 = var4 + var7;

      int var8;
      int var9;
      int var12;
      int var13;
      for(var9 = var4; var9 < var14; ++var9) {
         var12 = var11 - var6;

         for(var8 = var11; var8 > var12; --var8) {
            if ((var13 = var2[var10]) != this.backgroundColor) {
               var1[var8] = var13;
            }

            ++var10;
         }

         var11 += var5;
      }

      var11 = var4 * var5 + var3;
      var10 = 0;

      for(var9 = var4; var9 < var14; ++var9) {
         var12 = var11 + var6;

         for(var8 = var11; var8 < var12; ++var8) {
            if ((var13 = var2[var10]) != this.backgroundColor) {
               var1[var8] = var13;
            }

            ++var10;
         }

         var11 += var5;
      }

   }


   private void loadTextures_subfunction15(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int var15;
      int var16;
      int var17;
      int var18;
      label34: {
         var16 = 0;
         var17 = 0;
         var18 = 0;
         var15 = var4 * var5 + var3;
         int var10000;
         int var10001;
         if (var8 == 5) {
            var17 = (var16 = var15 + (2 * var6 - 1)) + (2 * var7 - 1) * var5;
            var10000 = var15;
            var10001 = 2 * var7;
         } else {
            if (var8 != 11) {
               break label34;
            }

            var17 = (var16 = var15 + (var7 - 1)) + (var7 - 1) * var5;
            var10000 = var15;
            var10001 = var7;
         }

         var18 = var10000 + (var10001 - 1) * var5;
      }

      int var14 = 0;
      int var21 = var4 + var7;

      for(int var13 = var4; var13 < var21; ++var13) {
         int var19 = var15 + var6;
         int var10 = var16;
         int var11 = var17;
         int var12 = var18;

         for(int var9 = var15; var9 < var19; ++var9) {
            int var20;
            if ((var20 = var2[var14]) != this.backgroundColor) {
               var1[var9] = var20;
               var1[var10] = var20;
               var1[var11] = var20;
               var1[var12] = var20;
            }

            ++var14;
            var10 += var5;
            --var11;
            var12 -= var5;
         }

         var15 += var5;
         --var16;
         var17 -= var5;
         ++var18;
      }

   }


   private int loadTextures_subfunction16(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      int[] var9 = new int[3];
      byte var11;
      byte var12;
      byte var13;
      short var14;
      short var16;
      int var10000;
      if (var7) {
         var16 = 255;
         var9[0] = var6 + (var1 << 4);
         var9[1] = var6 + (var2 << 4);
         var9[2] = var6 + (var3 << 4);
         var11 = 16;
         var12 = 8;
         var13 = 0;
         var14 = 128;
         var10000 = var5 << 4;
      } else {
         var16 = 15;
         var9[0] = (var6 >> 4) + var1;
         var9[1] = (var6 >> 4) + var2;
         var9[2] = (var6 >> 4) + var3;
         var11 = 20;
         var12 = 12;
         var13 = 4;
         var14 = 7;
         var10000 = var5;
      }

      int var15 = var10000;
      int var10 = (var9[0] + var9[1] + var9[2]) / 3;

      for(int var8 = 0; var8 <= 2; ++var8) {
         var9[var8] = clampValue((int)(var9[var8] + var15), var16);
         var9[var8] = clampValue((int)(var10 + (var9[var8] - var10) * (var4 + var14) / var14), var16);
      }

      return var9[0] << var11 | var9[1] << var12 | var9[2] << var13;
   }

   private static int clampValue(int value, int maxValue) {
      if (value > maxValue) {
          return maxValue;
      } else {
          return value < 0? 0 : value;
      }
   }





   private void loadTextures(byte[][][] bigLump0, byte[][][] bigLump1, short[] footer) {
      int var20 = 0;
      this.N = new int[bigLump1[9].length][];
      this.O = new int[bigLump1[9].length];
      int length = bigLump1.length;

      int i;
      for(i = 0; i < length; ++i) {
         if (i != 9 && i != 32) {
            bigLump1[i] = (byte[][])null;
         }
      }

      bigLump0[0] = (byte[][])null;
      System.gc();
      length = bigLump0[4].length;

      for(i = 0; i < length; ++i) {
         byte var24 = bigLump1[9][i][0];
         if (bigLump0[4][i][2] == 0) {
            bigLump0[4][i][2] = this.q[6 * var24 + 3];
         }

         if (bigLump0[4][i][3] == 0) {
            bigLump0[4][i][3] = this.q[6 * var24 + 4];
         }
      }

      length = bigLump1[9].length;

      int j;
      int[] var10001;
      int var10004;
      byte var10006;
      for(i = 0; i <= 1; ++i) {
         Image layer1 = this.readImage("/" + String.valueOf(i) + this.dataExt);
         Image layer2 = null;
         if (i == 0) {
            layer2 = this.readImage("/" + String.valueOf(i) + i + this.dataExt);
            int[] tmp = new int[1];
            layer1.getRGB(tmp, 0, 1, 0, 0, 1, 1);
            this.backgroundColor = tmp[0];
         }

         for(j = 0; j < length; ++j) {
            byte var36 = bigLump1[9][j][0];
            byte var21 = this.q[6 * var36];
            int var22 = bigLump0[4][j][2] * 2;
            int var23 = bigLump0[4][j][3] * 2;
            if (var21 == i) {
               int var27;
               int var28;
               label153: {
                  this.N[var20] = new int[var22 * var23];
                  this.O[j] = var20;
                  var27 = (this.q[6 * var36 + 1] + bigLump0[4][j][0]) * 2;
                  var28 = (this.q[6 * var36 + 2] + bigLump0[4][j][1]) * 2;
                  layer1.getRGB(this.N[var20], 0, var22, var27, var28, var22, var23);
                  Image var10000;
                  byte var10002;
                  byte var10003;
                  int var10005;
                  byte var10007;
                  boolean var29;
                  if (bigLump1[9][j][0] == 44) {
                     var29 = false;
                     this.fA = new int[840];
                     var10000 = layer1;
                     var10001 = this.fA;
                     var10002 = 0;
                     var10003 = 28;
                     var10004 = var27 + 2;
                     var10005 = var28;
                     var10006 = 28;
                     var10007 = 30;
                  } else {
                     if (bigLump1[9][j][0] != 39) {
                        break label153;
                     }

                     var29 = false;
                     this.fB = new int[676];
                     var10000 = layer1;
                     var10001 = this.fB;
                     var10002 = 0;
                     var10003 = 26;
                     var10004 = var27 + 4;
                     var10005 = var28 + 4;
                     var10006 = 26;
                     var10007 = 26;
                  }

                  var10000.getRGB(var10001, var10002, var10003, var10004, var10005, var10006, var10007);
               }

               if (!this.gB) {
                  this.loadTextures_subfunction1(this.N[var20], bigLump0, bigLump1, j);
               }

               if (this.q[6 * bigLump1[9][j][0] + 5] == 2) {
                  int[] var37 = new int[var22 * var23];
                  layer2.getRGB(var37, 0, var22, var27, var28, var22, var23);
                  this.loadTextures_subfunction2(this.N[var20], var37, 0, 0, var22, var22, var23);
               }

               ++var20;
            }
         }
      }

      this.bl = new int[bigLump0[3].length + 1];
      int var17 = 0;
      this.bl[0] = 0;
      this.bk = new int[bigLump0[3].length + 1];
      this.br = new short[bigLump0[3].length * 9];
      int var10 = footer[6] * 2 * 2;
      int var11 = footer[7] * 2 * 2;
      this.d(var10, var11);
      int var14 = 0;
      this.P = -1;
      byte var7 = -1;
      boolean var9 = false;
      length = bigLump0[3].length;

      for(i = 0; i < length; ++i) {
         byte var8 = var7;
         byte var6 = bigLump1[32][i][0];
         this.Q = bigLump1[9][var6][0];
         byte var31 = i != length - 1 ? bigLump1[32][i + 1][0] : -1;
         var7 = bigLump1[9][var6][0];
         this.K = bigLump0[4][var6][2] * 2;
         this.L = bigLump0[4][var6][3] * 2;
         this.J = bigLump0[2][var6][5];
         if (this.J >= 1 && this.J <= 5) {
            this.K *= 2;
         }

         if (this.J >= 4 && this.J <= 9) {
            this.L *= 2;
         }

         int var15 = this.K;
         int var16 = this.L;
         this.I = new int[var15 * var16];
         if (bigLump0[3][i][3] != 1 && bigLump0[3][i][3] != 2) {
            if (this.q[6 * var7] > 1) {
               this.loadTextures_subfunction3((byte[][][])bigLump0, (byte[][][])bigLump1, var6, 0, var8, var7, var31);
            } else {
               this.loadTextures_subfunction4(this.N[this.O[var6]], var15, bigLump0[4][var6][2] * 2, bigLump0[4][var6][3] * 2, bigLump0[2][var6][5], 0, 0);
            }
         }

         int var12 = bigLump0[3][i][1] * 2;
         int var13 = bigLump0[3][i][2] == 0 ? this.K : bigLump0[3][i][2] * 2;
         boolean var33 = false;
         int var34 = bigLump0[3][i][0] == bigLump0[3][i][1] ? var13 : (bigLump0[3][i][3] != 2 ? this.K : 96);
         byte var35 = bigLump0[3][i][0];
         if (bigLump0[3][i][3] == 1) {
            var14 = this.loadTextures_subfunction5(bigLump1[32][i][0], bigLump1[32][i][1], (byte)i, (byte)var12, (byte)var13, (short)140, var14, (short)26, (byte)(var12 + 23));
         } else if (bigLump0[3][i][3] == 2) {
            var14 = this.loadTextures_subfunction5(bigLump1[32][i][0], bigLump1[32][i][1], (byte)i, (byte)var12, (byte)var13, (short)((byte)var34), var14, (short)0, (byte)var12);
         } else {
            var14 = this.loadTextures_subfunction5((byte)var35, (byte)i, (byte)i, (byte)var12, (byte)var13, (short)((byte)var34), var14, (short)0, (byte)var12);

            for(j = 1; j <= 3 && bigLump1[32][i][j] != var6; ++j) {
               var6 = bigLump1[32][i][j];
               this.K = bigLump0[4][var6][2] * 2;
               this.L = bigLump0[4][var6][3] * 2;
               this.J = bigLump0[2][var6][5];
               if (this.J >= 1 && this.J <= 5) {
                  this.K *= 2;
               }

               if (this.J >= 4 && this.J <= 9) {
                  this.L *= 2;
               }

               a var38;
               if (this.q[6 * bigLump1[9][var6][0]] > 1) {
                  this.loadTextures_subfunction3((byte[][][])bigLump0, (byte[][][])bigLump1, var6, j, -1, -2, -1);
                  var38 = this;
                  var10001 = this.G;
               } else {
                  var38 = this;
                  var10001 = this.N[this.O[var6]];
               }

               this.loadTextures_subfunction4(var10001, var15, bigLump0[4][var6][2] * 2, bigLump0[4][var6][3] * 2, bigLump0[2][var6][5], bigLump0[2][var6][6] * 2, bigLump0[2][var6][7] * 2);
            }

            this.bl[i] = this.bl[var17];
            this.bl[var17 + 1] = this.bl[var17] + var13 * 12;
            ++var17;
            int[] var10008;
            boolean var10009;
            int[] var39;
            int var40;
            int var41;
            byte var42;
            int var43;
            if (bigLump0[3][i][3] != 0) {
               loadTextures_subfunction7(this.cI, this.cJ, this.bl[i], var12, var13, 12, 0, var15, this.I, true);
               var39 = this.cK;
               var10001 = this.cL;
               var40 = this.bl[i];
               var41 = var12;
               var10004 = var13;
               var42 = 12;
               var10006 = 2;
               var43 = var15;
               var10008 = this.I;
               var10009 = true;
            } else {
               loadTextures_subfunction7(this.cI, this.cJ, this.bl[i], var12, var13, 12, 0, var15, this.I, true);
               loadTextures_subfunction7(this.cK, this.cL, this.bl[i], var12, var13, 12, 2, var15, this.I, true);
               loadTextures_subfunction7(this.cM, this.cN, this.bl[i], var12, var13, 12, 6, var15, this.I, false);
               var39 = this.cO;
               var10001 = this.cP;
               var40 = this.bl[i];
               var41 = var12;
               var10004 = var13;
               var42 = 12;
               var10006 = 4;
               var43 = var15;
               var10008 = this.I;
               var10009 = false;
            }

            loadTextures_subfunction7(var39, var10001, var40, var41, var10004, var42, var10006, var43, var10008, var10009);
         }
      }

      this.G = null;
      this.H = null;
      this.I = null;
      this.N = (int[][])null;
      this.O = null;
      this.C = null;
      this.D = null;
      System.gc();
   }




   private void d(int var1, int var2) {
      this.cI = new int[var1];
      this.cJ = new int[var1];
      this.cK = new int[var1];
      this.cL = new int[var1];
      this.cM = new int[var2];
      this.cN = new int[var2];
      this.cO = new int[var2];
      this.cP = new int[var2];
   }

   private void a(int[] var1, int[] var2, int[] var3, int[] var4) {
      if (this.bc && !this.aZ) {
         this.bn[this.aG] = var1[this.aE];
      }

      if (this.bd && !this.ba) {
         this.bn[this.aH] = var2[this.aE];
      }

      if (!this.bb) {
         this.bn[this.aI] = var3[this.aE];
      }

      int[] var10000;
      int var10001;
      if (this.aJ == this.bK + 25920) {
         var10000 = this.bn;
         var10001 = this.aJ;
      } else {
         var10000 = this.bn;
         var10001 = this.aJ - 240;
      }

      var10000[var10001] = var4[this.aE];
   }




