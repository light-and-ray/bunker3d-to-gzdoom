import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;

public class ResourcesLoaderL3D {
   public String ROOT_JAR = "../jars/l3d.d";
   public ArrayList<Integer> DOORS_START_LINE_IDX = new ArrayList<>();
   public ArrayList<Integer> CRATES_START_LINE_IDX = new ArrayList<>();
   public ArrayList<Byte> CRATES_CONTENT = new ArrayList<>();
   public ArrayList<Byte> CRATES_ANGLE = new ArrayList<>();
   public ArrayList<Integer> TEXTURES_W = new ArrayList<>();
   public ArrayList<Integer> TEXTURES_H = new ArrayList<>();
   public ArrayList<int[]> TEXTURES_DATA = new ArrayList<>();
   public short[] FOOTER;
   public ArrayList<ArrayList<Integer>> CIRCLES_IDX = new ArrayList<>();
   public short[] SPRITES_W;
   public short[] SPRITES_H;
   public ArrayList<int[]> SPRITES_DATA_COLOR_1 = new ArrayList<>();
   public ArrayList<int[]> SPRITES_DATA_COLOR_2 = new ArrayList<>();
   public ArrayList<Short> FOE_SPRITES_W = new ArrayList<>();
   public ArrayList<Short> FOE_SPRITES_H = new ArrayList<>();
   public ArrayList<int[]> FOE_SPRITES_DATA_COLOR_1 = new ArrayList<>();
   public ArrayList<int[]> FOE_SPRITES_DATA_COLOR_2 = new ArrayList<>();



   private byte[][] loadedMap;
   private byte[] lumpsSizes = new byte[]{5, 82, 10, 8};
   private String dataExt = ".b3d";
   private String[] mapFiles = new String[]{"/b", "/t", "/s", "/h", "/c", "/m", "/x", "/y", "/z"};
   private String[] spriteFiles = new String[]{"/p", "/r", "/pp", "/rr"};
   private short[] h;
   private short[] i;
   private short[] j;
   private byte[] k;
   private byte[] l;
   private byte[] m;
   private byte[] n;
   private byte[] o;
   private byte[] p;
   private byte[] q;
   private byte[] r;
   byte[] a;
   private int selectedMap;
   private boolean hD;
   private short[] g;
   private byte[][][][] A;
   private int[] I;

   private int[] bf;
   private int[][] dg;
   private byte[] bv;
   private byte[] bw;
   private int fF;
   private byte[] dh;
   private int aS;
   private int aT;




   public ResourcesLoaderL3D() {
   }


   public BufferedImage readImage(String filePath) {
      try (FileInputStream fileInputStream = new FileInputStream(new File(ROOT_JAR + filePath))) {
          byte[] header = new byte[2];
          fileInputStream.read(header);

          int lengthLowByte = header[0] & 255;
          int lengthHighByte = header[1] & 255;
          int imageDataLength = lengthLowByte | lengthHighByte << 8;

          byte[] imageData = new byte[imageDataLength + 4];
          fileInputStream.read(imageData, 4, imageDataLength);
          imageData[0] = -119; // 0x89
          imageData[1] = 80;   // 'P'
          imageData[2] = 78;   // 'N'
          imageData[3] = 71;   // 'G'

          return ImageIO.read(new ByteArrayInputStream(imageData));
      } catch (IOException e) {
          return null;
      }
  }

   public byte[] readBinary(String fileName) {
      try (FileInputStream fileStream = new FileInputStream(new File(ROOT_JAR + fileName))) {
         // Read the file length (2 bytes)
         int lengthLowByte = fileStream.read();
         int lengthHighByte = fileStream.read();
         int fileLength = (lengthHighByte << 8) | (lengthLowByte & 0xFF);

         byte[] fileData = new byte[fileLength];
         fileStream.read(fileData, 0, fileData.length);
         return fileData;
      } catch (IOException e) {
         return null;
      }
   }

   public static short readShort(byte[] data, int offset) {
      return (short)(data[offset] & 255 | (data[offset + 1] & 255) << 8);
   }



   private void readMetadata() {
      int var2 = 0;
      byte[] var4 = this.readBinary("/a" + this.dataExt);
      short[] var5 = new short[12];

      int var1;
      for(var1 = 0; var1 < 12; ++var1) {
         var5[var1] = readShort(var4, var2);
         var2 += 2;
      }

      short var3 = var5[0];
      this.h = new short[var3];

      for(var1 = 0; var1 < var3; ++var1) {
         this.h[var1] = readShort(var4, var2);
         var2 += 2;
      }

      var3 = var5[1];
      this.i = new short[var3];

      for(var1 = 0; var1 < var3; ++var1) {
         this.i[var1] = readShort(var4, var2);
         var2 += 2;
      }

      var3 = var5[2];
      this.k = new byte[var3];

      for(var1 = 0; var1 < var3; ++var1) {
         this.k[var1] = var4[var2];
         ++var2;
      }

      var3 = var5[3];
      this.l = new byte[var3];

      for(var1 = 0; var1 < var3; ++var1) {
         this.l[var1] = var4[var2];
         ++var2;
      }

      var3 = var5[4];
      this.m = new byte[var3];

      for(var1 = 0; var1 < var3; ++var1) {
         this.m[var1] = var4[var2];
         ++var2;
      }

      var3 = var5[5];
      this.n = new byte[var3];

      for(var1 = 0; var1 < var3; ++var1) {
         this.n[var1] = (byte)(readShort(var4, var2) - 128);
         var2 += 2;
      }

      var3 = var5[6];
      this.j = new short[var3];

      for(var1 = 0; var1 < var3; ++var1) {
         short[] var10000;
         int var10001;
         int var10002;
         if (var4[var2] >= 0) {
            var10000 = this.j;
            var10001 = var1;
            var10002 = var4[var2];
         } else {
            var10000 = this.j;
            var10001 = var1;
            var10002 = 256 + var4[var2];
         }

         var10000[var10001] = (short)(var10002 * 2);
         ++var2;
      }

      var3 = var5[7];
      this.o = new byte[var3];

      for(var1 = 0; var1 < var3; ++var1) {
         this.o[var1] = var4[var2];
         ++var2;
      }

      var3 = var5[8];
      this.p = new byte[var3];

      for(var1 = 0; var1 < var3; ++var1) {
         this.p[var1] = var4[var2];
         ++var2;
      }

      var3 = var5[9];
      this.q = new byte[var3];

      for(var1 = 0; var1 < var3; ++var1) {
         this.q[var1] = var4[var2];
         ++var2;
      }

      var3 = var5[10];
      this.r = new byte[var3];

      for(var1 = 0; var1 < var3; ++var1) {
         this.r[var1] = var4[var2];
         ++var2;
      }

      var3 = var5[11];
      this.a = new byte[var3];

      for(var1 = 0; var1 < var3; ++var1) {
         this.a[var1] = var4[var2];
         ++var2;
      }

   }

   private void loadMap() {
      boolean var3 = false;
      int var5 = this.selectedMap == 0 ? 1 : this.selectedMap;
      ResourcesLoaderL3D var10000;
      StringBuffer var10001;
      String var10002;
      if (!this.hD) {
         var10000 = this;
         var10001 = new StringBuffer();
         var10002 = this.mapFiles[var5 - 1];
      } else {
         var10000 = this;
         var10001 = new StringBuffer();
         var10002 = "/o";
      }

      byte[] var6;
      short var7 = readShort((byte[])(var6 = var10000.readBinary(var10001.append(var10002).append(this.dataExt).toString())), (int)0);
      short var8 = readShort((byte[])var6, (int)2);
      short var9 = readShort((byte[])var6, (int)4);
      this.loadedMap = new byte[6][];
      int var4 = var7 * 4;
      this.loadedMap[0] = new byte[var4];
      int var11 = 6;

      int var2;
      for(var2 = 0; var2 < var4; var2 += 4) {
         this.loadedMap[0][var2] = (byte)((var6[var11 + 1] & 240) >> 4);
         this.loadedMap[0][var2 + 1] = (byte)(var6[var11 + 1] & 15);
         this.loadedMap[0][var2 + 2] = (byte)((var6[var11] & 240) >> 4);
         this.loadedMap[0][var2 + 3] = (byte)(var6[var11] & 15);
         var11 += 2;
      }

      this.loadedMap[1] = new byte[this.lumpsSizes[0]];
      this.g = new short[5];
      byte var12 = this.lumpsSizes[0];

      for(var2 = 0; var2 < var12; ++var2) {
         short var1 = readShort(var6, var11);
         this.g[var2] = var1;
         byte[] var13;
         int var14;
         int var15;
         if (var1 >= 128) {
            var13 = this.loadedMap[1];
            var14 = var2;
            var15 = 127 - var1;
         } else {
            var13 = this.loadedMap[1];
            var14 = var2;
            var15 = var1;
         }

         var13[var14] = (byte)var15;
         var11 += 2;
      }

      this.loadedMap[2] = new byte[var8];

      for(var2 = 0; var2 < var8; ++var2) {
         this.loadedMap[2][var2] = var6[var11];
         ++var11;
      }

      var12 = this.lumpsSizes[1];
      this.loadedMap[3] = new byte[var12];

      for(var2 = 0; var2 < var12; ++var2) {
         this.loadedMap[3][var2] = var6[var11];
         ++var11;
      }

      this.loadedMap[4] = new byte[var9];

      for(var2 = 0; var2 < var9; ++var2) {
         this.loadedMap[4][var2] = var6[var11];
         ++var11;
      }

      var12 = this.lumpsSizes[2];
      this.loadedMap[5] = new byte[var12];

      for(var2 = 0; var2 < var12; ++var2) {
         this.loadedMap[5][var2] = var6[var11];
         ++var11;
      }

      short[] footer = new short[var12 = this.lumpsSizes[3]];

      for(var2 = 0; var2 < var12; ++var2) {
         footer[var2] = readShort(var6, var11);
         var11 += 2;
      }

      this.loadMapInner(footer);
      // this.n = null;
      // this.A = (byte[][][][])null;
      // this.I = null;
      // System.gc();
   }

   private void loadMapInner(short[] footer) {
      this.A = new byte[3][][][];
      this.loadMapPart((byte[])this.loadedMap[0], (byte[])this.loadedMap[1], (byte[])this.l, 0);
      this.loadMapPart((byte[])this.loadedMap[2], (byte[])this.loadedMap[3], (byte[])this.m, 1);
      this.modifyBigLumps01(this.A[0], this.A[1]);
      this.modifyBigLump1(this.A[1]);
      this.loadMapPart((byte[])this.loadedMap[4], (byte[])this.loadedMap[5], (byte[])this.k, 2);
      this.loadSpritesPart1(this.A[2]);
      this.loadSpritesPart2(this.A[2]);
      this.loadSpritesPart3(this.A[2]);
      // this.loadedMap = (byte[][])null;
      // this.A[2] = (byte[][][])null;
      // this.c(false);
      // System.gc();
      this.initFloorCeilingColor(footer);
      this.loadTextures(this.A[0], this.A[1], footer);
      // this.hg = false;
      // this.L();
   }

   private void loadMapPart(byte[] lumpA, byte[] lumpB, byte[] mapMetadata, int A_idx) {
      int var8 = 0;
      int var10 = lumpB.length;
      this.A[A_idx] = new byte[var10][][];

      for(int var5 = 0; var5 < var10; ++var5) {
         int var9 = lumpB[var5] < 0 ? 127 - lumpB[var5] : lumpB[var5];
         this.A[A_idx][var5] = new byte[var9][mapMetadata[var5]];

         for(int var6 = 0; var6 < var9; ++var6) {
            byte var11 = mapMetadata[var5];

            for(int var7 = 0; var7 < var11; ++var7) {
               this.A[A_idx][var5][var6][var7] = lumpA[var8];
               ++var8;
            }
         }
      }

   }


   private void initFloorCeilingColor(short[] footer) {
      ResourcesLoaderL3D var10000;
      int var10001;
      if (!this.hD) {
         this.aS = footer[0] << 16 | footer[1] << 8 | footer[2];
         var10000 = this;
         var10001 = footer[3] << 16 | footer[4] << 8 | footer[5];
      } else {
         this.aS = 1644825;
         var10000 = this;
         var10001 = 2960685;
      }

      var10000.aT = var10001;
      this.aS = (int)((long)this.aS | 0L);
      this.aT = (int)((long)this.aT | 0L);
   }

   private void initMapArrays(int var1) {
      this.dg = new int[4][var1];
      this.bv = new byte[var1];
   }


   private void modifyBigLumps01(byte[][][] bigLump0, byte[][][] bigLump1) {
      boolean var3 = false;
      int var11 = 0;
      int var12 = 0;
      int var17 = bigLump0[0].length + bigLump1[7].length + bigLump1[12].length * 4 + bigLump1[20].length * 3 + bigLump1[33].length * 4 + bigLump1[41].length * 4;
      int var7 = bigLump1[51].length + 1;
      this.bf = new int[var7];
      this.bf[0] = var17;

      int var4;
      for(var4 = 1; var4 < var7; ++var4) {
         this.bf[var4] = this.bf[var4 - 1] + bigLump1[51][var4 - 1][2];
      }

      var17 = this.bf[var4 - 1];
      this.initMapArrays(var17);
      this.bw = new byte[var17];
      var7 = bigLump1[31].length;

      for(var4 = 0; var4 < var7; ++var4) {
         this.bw[bigLump1[31][var4][0] + 128] = bigLump1[31][var4][1];
      }

      var7 = bigLump0[0].length;
      int var8 = bigLump1[7].length;

      for(var4 = 0; var4 < var7; ++var4) {
         if (var11 < var8 && var12 == bigLump1[7][var11][0] + 128) {
            if (var11 != 0) {
               this.dg[2][var12 - 1] = bigLump1[7][var11 - 1][1];
               this.dg[3][var12 - 1] = bigLump1[7][var11 - 1][2];
            }

            this.dg[0][var12] = bigLump1[7][var11][1];
            this.dg[1][var12] = bigLump1[7][var11][2];
            ++var11;
            ++var12;
         }

         long var13 = (long)(bigLump0[0][var4][0] - 7);
         long var15 = (long)(bigLump0[0][var4][1] - 7);
         this.dg[0][var12] = (int)(var13 + (long)this.dg[0][var12 - 1]);
         this.dg[1][var12] = (int)(var15 + (long)this.dg[1][var12 - 1]);
         this.dg[2][var12 - 1] = this.dg[0][var12];
         this.dg[3][var12 - 1] = this.dg[1][var12];
         ++var12;
      }

      this.dg[2][var12 - 1] = bigLump1[7][var11 - 1][1];
      this.dg[3][var12 - 1] = bigLump1[7][var11 - 1][2];

      for(int var18 = 0; var18 < var12; ++var18) {
         for(var4 = 0; var4 < 4; ++var4) {
            int[] var10000 = this.dg[var4];
            var10000[var18] <<= 16;
         }
      }

      this.fF = var12;
      var12 = 0;
      var11 = 0;
      this.dh = new byte[var17];
      var7 = bigLump0[1].length;
      int var9 = bigLump1[7].length;
      int var10 = bigLump1[10].length;

      int var5;
      int var6;
      for(var4 = 0; var4 < var7; ++var4) {
         var8 = bigLump0[1][var4].length;

         label159:
         for(var5 = 0; var5 < var8; ++var5) {
            if (var11 < var9 && var12 == bigLump1[7][var11][0] + 128) {
               if (var11 != 0) {
                  this.dh[var12 - 1] = bigLump1[7][var11 - 1][4];
               }

               this.dh[var12] = bigLump1[7][var11][3];
               ++var11;
               ++var12;
            }

            int var10001;
            byte[] var10002;
            byte[] var19;
            int var10003;
            if (bigLump0[1][var4][var5] == 15) {
               var6 = 0;

               while(true) {
                  if (var6 >= var10) {
                     continue label159;
                  }

                  if (bigLump1[10][var6][0] + 128 == var12) {
                     var19 = this.dh;
                     var10001 = var12;
                     var10002 = bigLump1[10][var6];
                     var10003 = 1;
                     break;
                  }

                  ++var6;
               }
            } else {
               var19 = this.dh;
               var10001 = var12;
               var10002 = bigLump0[1][var4];
               var10003 = var5;
            }

            var19[var10001] = var10002[var10003];
            ++var12;
         }
      }

      this.dh[var12 - 1 - bigLump1[8][0][4]] = bigLump1[7][var11 - 1][4];
      var7 = bigLump0[2].length;
      var8 = bigLump1[29].length;

      for(var4 = 0; var4 < var7; ++var4) {
         for(var5 = 0; var5 < 5; ++var5) {
            if (bigLump0[2][var4][var5] != 15) {
               if (bigLump0[2][var4][var5] == 7) {
                  bigLump0[2][var4][var5] = -7;
               } else if (bigLump0[2][var4][var5] != 0) {
                  bigLump0[2][var4][var5] = (byte)(bigLump0[2][var4][var5] - 7);
               }
            } else {
               for(var6 = 0; var6 < var8; ++var6) {
                  if (bigLump1[29][var6][0] == var4 && bigLump1[29][var6][1] == var5) {
                     bigLump0[2][var4][var5] = bigLump1[29][var6][2];
                     break;
                  }
               }
            }
         }
      }

      for(var4 = 0; var4 < var7; ++var4) {
         var8 = bigLump0[2][var4].length;

         for(var5 = 6; var5 < var8; ++var5) {
            bigLump0[2][var4][var5] = (byte)(bigLump0[2][var4][var5] * 3);
         }
      }

      var7 = bigLump0[3].length;

      for(var4 = 0; var4 < var7; ++var4) {
         for(var5 = 1; var5 <= 2; ++var5) {
            bigLump0[3][var4][var5] = (byte)(bigLump0[3][var4][var5] * 3);
         }
      }

      var7 = bigLump0[4].length;

      for(var4 = 0; var4 < var7; ++var4) {
         var8 = bigLump0[4][var4].length;

         for(var5 = 0; var5 < var8; ++var5) {
            bigLump0[4][var4][var5] = (byte)(bigLump0[4][var4][var5] * 3);
         }
      }

   }



}









