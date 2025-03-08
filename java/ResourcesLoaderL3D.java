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



   public byte[][] loadedMap;
   public byte[] lumpsSizes = new byte[]{5, 82, 10, 8};
   public String dataExt = ".b3d";
   public String[] mapFiles = new String[]{"/b", "/t", "/s", "/h", "/c", "/m", "/x", "/y", "/z"};
   public String[] spriteFiles = new String[]{"/p", "/r", "/pp", "/rr"};
   public short[] h;
   public short[] i;
   public short[] j;
   public byte[] k;
   public byte[] l;
   public byte[] m;
   public byte[] n;
   public byte[] o;
   public byte[] p;
   public byte[] q;
   public byte[] r;
   byte[] a;
   public int selectedMap;
   public boolean hD;
   public short[] g;
   public byte[][][][] A;
   public int[] I;

   public int[] bf;
   public int[][] dg;
   public byte[] bv;
   public byte[] bw;
   public int fF;
   public byte[] dh;
   public int aS;
   public int aT;

   public short[][] cN;
   public short[][] cO;
   public int fI;
   public int fJ;
   public int fK;
   public int cL;
   public byte cM;
   public int fG;
   public byte[] cq;
   public byte[] cr;
   public int[][] cb;
   public boolean[] cw;
   public byte[] cn;
   public int fH;
   public int[][] dH;
   public int[][] dI;
   public byte[] dJ;
   public byte[] dK;
   public byte[] dL;
   public byte[] dM;
   public int[] dN;
   public int[] dO;
   public int[] dP;
   public int[] dQ;
   public int[] dR;
   public int[] dS;
   public int[] dT;
   public int dV;
   public int dW;
   public int dX;
   public byte[] bx;
   public short[] bp;
   public byte[][] gx;
   public byte[][] gy;
   public short[] gu;
   public short[][] gv;
   public int[] gs;
   public int gE;
   public int fL;
   public int[] be;
   public byte[][] cs;
   public int[] eg;
   public long[] gn;
   public int fU;
   public int fz;
   public int fA;
   public byte[][] x = new byte[][]{{1, 1, -1, 1}, {-1, 1, -1, -1}, {-1, -1, 1, -1}, {1, -1, 1, 1}};

   public byte[] cj;
   public byte[] ck;
   public byte[] cl;
   public byte[] cm;
   public byte[] co;
   public byte[] cp;
   public boolean[] ct;
   public boolean[] cu;
   public short[] cg;
   public int[] eX;
   public short[] ch;
   public boolean[] cv;
   public int[] ce;
   public int fx;
   public byte fW;
   public byte fX;
   public byte fY;
   public byte fZ;
   public byte ga;
   public int fy;
   public int[][] cc;
   public int bV;
   public long[] gY;

   public int N;
   public int O;
   public short[][] bn;
   public short[] ci;
   public short[] bq;
   public short[] br;
   public int[] bg;
   public short[] bs;
   public short[] bt;
   public int[][] bm;
   public int[] bj;
   public byte[] di;
   public byte[] dj;
   public byte[] dk;
   public byte[] dl;
   public byte[] dm;
   public byte[] dn;
   public byte[] do_;
   public byte[] dp;
   public byte[] dq;
   public byte[] dr;
   public byte[] ds;
   public byte[] dt;
   public byte[] du;
   public byte[] dv;
   public byte[] dw;
   public byte[] dx;
   public byte[] dy;
   public byte[] dz;
   public byte[] dA;
   public byte[] dB;
   public byte[] dC;
   public byte[] dD;
   public byte[] dE;
   public byte[] dF;
   public byte[][][] B;

   public int[][] J;
   public int[] K;
   public int[] go;
   public int[] gp;
   public int[] gq;
   public int[] bh;
   public int[] bi;
   public short[] bo;
   public int L;
   public int M;
   public byte F;
   public int G;
   public int H;
   public int[] E;
   public int[] C;
   public int[] cS;
   public int[] cT;
   public int[] cU;
   public int[] cV;
   public int[] cW;
   public int[] cX;
   public int[] cY;
   public int[] cZ;
   public int[] D;
   public BufferedImage y;
   public BufferedImage z;




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



   public void readMetadata() {
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

   public void loadMap() {
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

   public void loadMapInner(short[] footer) {
      this.FOOTER = footer;
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

   public void loadMapPart(byte[] lumpA, byte[] lumpB, byte[] mapMetadata, int A_idx) {
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


   public void initFloorCeilingColor(short[] footer) {
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

   public void initMapArrays(int var1) {
      this.dg = new int[4][var1];
      this.bv = new byte[var1];
   }


   public void modifyBigLumps01(byte[][][] bigLump0, byte[][][] bigLump1) {
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



   public void modifyBigLump1(byte[][][] bigLump1) {
      this.cN = new short[7][];
      this.cO = new short[7][];
      this.fI = this.fF;
      this.fJ = this.fI + 4 * bigLump1[12].length;
      this.fK = this.fJ + 3 * bigLump1[20].length;

      int var2;
      int var3;
      int var6;
      int var10;
      int var12;
      int var13;
      int var14;
      int var10001;
      int var10002;
      for(var2 = 0; var2 < 7; ++var2) {
         var12 = bigLump1[var2].length + bigLump1[var2 + 13].length + bigLump1[var2 + 21].length + bigLump1[var2 + 42].length + bigLump1[var2 + 52].length;
         this.cN[var2] = new short[var12];
         this.cO[var2] = new short[var12];
         var10 = bigLump1[var2].length;

         for(var3 = 0; var3 < var10; ++var3) {
            this.cN[var2][var3] = (short)(bigLump1[var2][var3][0] + 128);
            this.cO[var2][var3] = (short)(bigLump1[var2][var3][1] + 128);
         }

         var10 = bigLump1[var2 + 13].length + var3;

         short[] var10000;
         for(var6 = var3; var6 < var10; ++var6) {
            var13 = bigLump1[var2 + 13][var6 - var3][0];
            this.cN[var2][var6] = (short)(this.fI + var13 * 4);
            this.cO[var2][var6] = (short)(this.cN[var2][var6] + 3);
            if (abs(var14 = bigLump1[12][var13][3] % 90) <= 3) {
               var10000 = this.cO[var2];
               var10001 = var6;
               var10002 = var10000[var6] - abs(var14);
            } else {
               if (abs(var14) > 6) {
                  continue;
               }

               var10000 = this.cN[var2];
               var10001 = var6;
               var10002 = var10000[var6] + (abs(var14) - 3);
            }

            var10000[var10001] = (short)var10002;
            bigLump1[12][var13][3] = (byte)(bigLump1[12][var13][3] - var14);
         }

         var10 = bigLump1[var2 + 21].length + var6;

         int var7;
         for(var7 = var6; var7 < var10; ++var7) {
            this.cN[var2][var7] = (short)(this.fJ + abs(bigLump1[var2 + 21][var7 - var6][0]) % 60 * 3);
            this.cO[var2][var7] = (short)(this.cN[var2][var7] + 2);
            if (bigLump1[var2 + 21][var7 - var6][0] < 0) {
               var10000 = this.cN[var2];
               var10001 = var7;
               var10002 = var10000[var7] + 2;
            } else {
               if (bigLump1[var2 + 21][var7 - var6][0] < 60) {
                  continue;
               }

               var10000 = this.cO[var2];
               var10001 = var7;
               var10002 = var10000[var7] - 2;
            }

            var10000[var10001] = (short)var10002;
         }

         var10 = bigLump1[var2 + 42].length + var7;

         int var8;
         for(var8 = var7; var8 < var10; ++var8) {
            var13 = bigLump1[var2 + 42][var8 - var7][0];
            this.cN[var2][var8] = (short)(this.fK + var13 * 4);
            this.cO[var2][var8] = (short)(this.cN[var2][var8] + 3);
            if (abs(var14 = bigLump1[41][var13][2] % 90) <= 3) {
               var10000 = this.cO[var2];
               var10001 = var8;
               var10002 = var10000[var8] - abs(var14);
            } else {
               if (abs(var14) > 6) {
                  continue;
               }

               var10000 = this.cN[var2];
               var10001 = var8;
               var10002 = var10000[var8] + (abs(var14) - 3);
            }

            var10000[var10001] = (short)var10002;
            bigLump1[41][var13][2] = (byte)(bigLump1[41][var13][2] - var14);
         }

         var10 = bigLump1[var2 + 52].length + var8;

         for(int var9 = var8; var9 < var10; ++var9) {
            this.cN[var2][var9] = (short)this.bf[bigLump1[var2 + 52][var9 - var8][0]];
            this.cO[var2][var9] = (short)(this.bf[bigLump1[var2 + 52][var9 - var8][0] + 1] - 1);
         }
      }

      ResourcesLoaderL3D var25;
      byte var26;
      long var28;
      if (this.selectedMap != 11) {
         var25 = this;
         var26 = bigLump1[8][0][0];
         var28 = (long)bigLump1[8][0][1] * 75000L;
      } else {
         var25 = this;
         var26 = bigLump1[8][0][0];
         var28 = (long)bigLump1[8][0][1] * 75000L + 32768L;
      }

      var25.initStartingPos(var26, var28, (long)bigLump1[8][0][2] * 75000L, bigLump1[8][0][3] * 2, bigLump1[8][0][7]);
      this.cM = (byte)(13 + bigLump1[8][0][5]);
      this.cL = bigLump1[8][0][6];
      var12 = this.fF;
      this.fG = bigLump1[12].length;
      var13 = 106 + this.fG;
      this.cq = new byte[var13];
      this.cb = new int[var13][2];
      this.cw = new boolean[var13];
      this.cn = new byte[var13];
      this.cr = new byte[var13];
      var10 = bigLump1[12].length;

      byte[] var27;
      for(var3 = 0; var3 < var10; ++var3) {
         var14 = 128 + bigLump1[12][var3][0] << 16 >> 2;
         int var15 = 128 + bigLump1[12][var3][1] << 16 >> 2;
         var6 = 106 + var3;
         this.cb[var6][0] = var14;
         this.cb[var6][1] = var15;
         this.cq[var6] = (byte)(this.cM - 1);
         this.cw[var6] = false;
         this.cn[var6] = (byte)(this.cM + 2 + bigLump1[12][var3][4]);
         if (bigLump1[12][var3][4] > 4) {
            var27 = this.cn;
            var27[var6] = (byte)(var27[var6] - 4);
            this.cr[var6] = 1;
         }
         CRATES_START_LINE_IDX.add(var12);
         CRATES_CONTENT.add(bigLump1[12][var3][4]);
         CRATES_ANGLE.add(bigLump1[12][var3][3]);
         var12 = this.modifyBigLump1_subfunction1((long)var14, (long)var15, 16384L, 16384L, bigLump1[12][var3][3], var12, bigLump1[12][var3][2], bigLump1[12][var3][2], bigLump1[12][var3][2], bigLump1[12][var3][2], (byte)1, (byte)0);
      }

      this.fH = bigLump1[20].length;
      this.dH = new int[this.fH][2];
      this.dJ = new byte[this.fH];
      this.dK = new byte[this.fH];
      this.dN = new int[this.fH];
      this.dO = new int[this.fH];
      this.dL = new byte[this.fH];
      this.dP = new int[this.fH];
      this.dQ = new int[this.fH];
      this.dR = new int[this.fH];
      this.dS = new int[this.fH];
      this.dI = new int[this.fH][2];
      this.dT = new int[this.fH];
      this.dM = new byte[this.fH];
      var10 = bigLump1[20].length;

      for(var3 = 0; var3 < var10; ++var3) {
         this.dH[var3][0] = 128 + bigLump1[20][var3][0] << 16 >> 2;
         this.dH[var3][1] = 128 + bigLump1[20][var3][1] << 16 >> 2;
         byte var30;
         if (bigLump1[20][var3][2] * bigLump1[20][var3][3] >= 0) {
            this.dJ[var3] = 0;
            var27 = this.dK;
            var10001 = var3;
            var30 = 1;
         } else {
            this.dJ[var3] = 1;
            var27 = this.dK;
            var10001 = var3;
            var30 = 0;
         }

         var27[var10001] = var30;
         this.dN[var3] = (bigLump1[20][var3][2] << 16) / 127;
         this.dO[var3] = (bigLump1[20][var3][3] << 16) / 127;
         this.dV = this.dO[var3];
         this.dL[var3] = bigLump1[59][var3][3];
         this.dR[var3] = 0;
         this.dS[var3] = 6225920;
         int[] var29;
         if (this.dO[var3] > 0) {
            var29 = this.dP;
            var10001 = var3;
            var10002 = 65536;
         } else {
            var29 = this.dP;
            var10001 = var3;
            var10002 = -65536;
         }

         var29[var10001] = var10002;
         this.dW = this.dP[var3];
         this.dQ[var3] = (this.dP[var3] - this.dO[var3]) / this.dL[var3];
         this.dX = this.dQ[var3];
         this.dI[var3][this.dJ[var3]] = this.dH[var3][this.dJ[var3]] + this.dP[var3];
         this.dI[var3][this.dK[var3]] = this.dH[var3][this.dK[var3]];
         this.dT[var3] = -1;
         this.dM[var3] = bigLump1[28][var3][0];
         DOORS_START_LINE_IDX.add(var12);
         this.modifyBigLump1_subfunction2(bigLump1[59][var3][0], bigLump1[59][var3][1], bigLump1[59][var3][2], var12);
         this.modifyBigLump1_subfunction3(this.dH[var3], (long)this.dN[var3], (long)this.dP[var3], this.dJ[var3], this.dK[var3], var12, 0);
         var12 = this.modifyBigLump1_subfunction3(this.dH[var3], (long)this.dN[var3], (long)this.dO[var3], this.dJ[var3], this.dK[var3], var12, 1);
      }

      this.fF = var12;
      this.bx = new byte[bigLump1[30].length * 7];
      this.bp = new short[32 + bigLump1[30].length];
      int var5 = 0;
      var10 = bigLump1[30].length;

      int var11;
      for(var3 = 0; var3 < var10; ++var3) {
         this.bp[32 + var3] = 96;
         var11 = bigLump1[30][var3].length;

         for(int var4 = 0; var4 < var11; ++var4) {
            this.bx[var5] = bigLump1[30][var3][var4];
            ++var5;
         }
      }

      var12 = this.fF;
      var10 = bigLump1[41].length;

      long var16;
      long var24;
      for(var3 = 0; var3 < var10; ++var3) {
         var24 = (long)(128 + bigLump1[41][var3][0] << 16 >> 2);
         var16 = (long)(128 + bigLump1[41][var3][1] << 16 >> 2);
         long var18 = (long)((bigLump1[60][var3][0] << 16) / 42 >> 1);
         long var20 = (long)((bigLump1[60][var3][1] << 16) / 42 >> 1);
         var12 = this.modifyBigLump1_subfunction1(var24, var16, var18, var20, bigLump1[41][var3][2], var12, bigLump1[61][var3][0], bigLump1[61][var3][1], bigLump1[61][var3][2], bigLump1[61][var3][3], bigLump1[62][var3][0], bigLump1[62][var3][1]);
      }

      this.fF = var12;
      this.gx = new byte[7][];
      this.gy = new byte[7][];
      this.gv = new short[7][];
      this.gu = new short[15];
      this.gs = new int[7];
      this.modifyBigLump1_subfunction4(0, 49, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(1, 70, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(2, 72, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(3, 74, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(4, 76, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(5, 78, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(6, 80, (byte[][][])bigLump1);
      this.gE = 0;
      var12 = this.fF;
      this.fL = var12;
      var10 = bigLump1[51].length;
      this.be = new int[var10];

      for(var3 = 0; var3 < var10; ++var3) {
         var24 = (long)(128 + bigLump1[51][var3][0] << 16 >> 2);
         var16 = (long)(128 + bigLump1[51][var3][1] << 16 >> 2);
         long var22 = (long)((bigLump1[51][var3][3] << 16) / 60);
         this.be[var3] = bigLump1[51][var3][6];
         var12 = this.modifyBigLump1_subfunction5(var24, var16, bigLump1[51][var3][2], var22, var12, bigLump1[51][var3][4], bigLump1[51][var3][5], bigLump1[51][var3][7], bigLump1[51][var3][8]);
      }

      this.fF = var12;
      this.cs = new byte[7][];

      for(var2 = 63; var2 < 70; ++var2) {
         var10 = bigLump1[var2].length;
         var11 = bigLump1[var2 - 50].length;
         this.cs[var2 - 63] = new byte[var10 + var11];

         for(var3 = 0; var3 < var10; ++var3) {
            this.cs[var2 - 63][var3] = bigLump1[var2][var3][0];
         }

         var6 = var3;

         for(var3 = 0; var3 < var11; ++var3) {
            this.cs[var2 - 63][var6] = (byte)(106 + bigLump1[var2 - 50][var3][0]);
            ++var6;
         }
      }

   }

   public void modifyBigLump1_subfunction4(int var1, int var2, byte[][][] var3) {
      int var4 = var2;
      if (var3[var2].length != 0) {
         int var7 = var3[var2][0].length;
         this.gx[var1] = new byte[var7];

         for(int var6 = 0; var6 < var7; ++var6) {
            this.gx[var1][var6] = var3[var4][0][var6];
         }

         int[] var10000;
         int var10001;
         byte var10002;
         if (this.gx[var1][1] != this.gx[var1][2]) {
            var10000 = this.gs;
            var10001 = var1;
            var10002 = 2;
         } else {
            var10000 = this.gs;
            var10001 = var1;
            var10002 = 1;
         }

         var10000[var10001] = var10002;
         var4 = var2 + 1;
         this.gv[var1] = new short[var3[var4].length];
         this.gy[var1] = new byte[var3[var4].length];
         var7 = var3[var4].length;

         for(int var5 = 0; var5 < var7; ++var5) {
            this.gv[var1][var5] = (short)(var3[var4][var5][0] + 128);
            this.gy[var1][var5] = 0;
         }

      }
   }


   public void initCosTable() {
      this.eg = new int[91];
      this.eg[1] = 1146;
      int var1 = 1146;

      for(int var2 = 2; var2 <= 90; ++var2) {
         var1 += this.a[var2 - 2];
         this.eg[var2] = this.eg[var2 - 1] + var1;
      }

      this.a = null;
   }

   public long cos(int var1) {
      if (var1 < 0) {
         return -this.cos(-var1);
      } else if (var1 >= 90 & var1 < 180) {
         return (long)this.eg[180 - var1];
      } else if (var1 >= 180 & var1 < 270) {
         return (long)(-this.eg[var1 - 180]);
      } else if (var1 >= 270 & var1 < 360) {
         return (long)(-this.eg[90 - (var1 - 270)]);
      } else {
         return var1 >= 360 ? this.cos(var1 % 360) : (long)this.eg[var1];
      }
   }

   public long sin(int var1) {
      return this.cos(90 - var1);
   }

   public static int abs(int var0) {
      return var0 > 0 ? var0 : -var0;
   }


   public void initStartingPos(int var1, long var2, long var4, int var6, int var7) {
      this.gn = new long[2];
      this.fU = var1;
      this.gn[0] = var2 / 75000L;
      this.gn[1] = var4 / 75000L;
      this.fz = var6;
      this.fA = var7;
   }



   public int modifyBigLump1_subfunction1(long var1, long var3, long var5, long var7, int var9, int var10, byte var11, byte var12, byte var13, byte var14, byte var15, byte var16) {
      int var19 = 0;

      int var18;
      for(var18 = var10; var18 < var10 + 4; ++var18) {
         this.bv[var18] = var15;
         if (var16 != 6) {
            this.bw[var18] = var16;
         }

         for(int var17 = 0; var17 < 4; var17 += 2) {
            int[] var10000;
            int var10001;
            long var10002;
            if (var9 == 0) {
               this.dg[var17][var18] = (int)((long)this.x[var19][var17] * var7 + var1);
               var10000 = this.dg[var17 + 1];
               var10001 = var18;
               var10002 = (long)this.x[var19][var17 + 1] * var5;
            } else {
               this.dg[var17][var18] = (int)(((long)this.x[var19][var17] * var7 * this.sin(var9) >> 16) - ((long)this.x[var19][var17 + 1] * var5 * this.cos(var9) >> 16) + var1);
               var10000 = this.dg[var17 + 1];
               var10001 = var18;
               var10002 = ((long)this.x[var19][var17] * var7 * this.cos(var9) >> 16) + ((long)this.x[var19][var17 + 1] * var5 * this.sin(var9) >> 16);
            }

            var10000[var10001] = (int)(var10002 + var3);
         }

         ++var19;
      }

      this.dh[var10] = var11;
      var18 = var10 + 1;
      this.dh[var18] = var12;
      ++var18;
      this.dh[var18] = var13;
      ++var18;
      this.dh[var18] = var14;
      if (var16 == 6) {
         this.bw[var18] = 3;
      }

      return var18 + 1;
   }



   public int modifyBigLump1_subfunction5(long var1, long var3, int var5, long var6, int var8, int var9, byte var10, byte var11, int var12) {
      int var15 = 360 / var5;
      int var14 = var12 * 4;
      ArrayList<Integer> indexes = new ArrayList<>();

      int var13;
      for(var13 = var8; var13 < var8 + var5; ++var13) {
         indexes.add(var13);
         this.dg[0][var13] = (int)((var6 * this.cos(var14) >> 16) + var1);
         this.dg[1][var13] = (int)((var6 * this.sin(var14) >> 16) + var3);
         var14 -= var15;
         this.dg[2][var13] = (int)((var6 * this.cos(var14) >> 16) + var1);
         this.dg[3][var13] = (int)((var6 * this.sin(var14) >> 16) + var3);
         this.bv[var13] = var10;
         this.dh[var13] = (byte)var9;
         this.bw[var13] = var11;
      }
      this.CIRCLES_IDX.add(indexes);

      return var13;
   }

   public void modifyBigLump1_subfunction2(byte var1, byte var2, byte var3, int var4) {
      this.dh[var4] = var1;
      int var5 = var4 + 1;
      this.dh[var5] = var2;
      ++var5;
      this.dh[var5] = var3;
      this.bw[var5] = 3;
   }



   public int modifyBigLump1_subfunction3(int[] var1, long var2, long var4, int var6, int var7, int var8, int var9) {
      char var10 = 0;
      if (this.selectedMap == 1 || this.selectedMap == 2) {
         var10 = '耀';
      }

      if (var9 == 0) {
         this.dg[var6][var8] = var1[var6] + var10;
         this.dg[var7][var8] = (int)((long)var1[var7] - (var2 >> 1));
         this.dg[var6 + 2][var8] = (int)((long)var1[var6] + var4 + (long)var10);
         this.dg[var7 + 2][var8] = (int)((long)var1[var7] - (var2 >> 1));
      }

      int var11 = var8 + 1;
      this.dg[var6][var11] = this.dg[var6 + 2][var11 - 1];
      this.dg[var7][var11] = this.dg[var7 + 2][var11 - 1];
      this.dg[var6 + 2][var11] = this.dg[var6][var11];
      this.dg[var7 + 2][var11] = (int)((long)this.dg[var7][var11 - 1] + var2);
      ++var11;
      if (var9 == 0) {
         this.dg[var6][var11] = this.dg[var6 + 2][var11 - 1];
         this.dg[var7][var11] = this.dg[var7 + 2][var11 - 1];
         this.dg[var6 + 2][var11] = (int)((long)this.dg[var6][var11] - var4);
         this.dg[var7 + 2][var11] = this.dg[var7][var11];
      }

      return var11 + 1;
   }




   public void loadSpritesPart1(byte[][][] bigLump2) {
      int var6 = bigLump2[4].length;
      this.cj = new byte[var6];
      this.cg = new short[var6];
      this.ck = new byte[64];
      this.eX = new int[32];
      this.ch = new short[var6];
      this.cl = new byte[var6];
      this.ct = new boolean[var6];
      this.cm = new byte[var6];
      this.cv = new boolean[106 + this.fG];
      this.ce = new int[64 + this.fG];
      this.co = new byte[var6];
      this.cu = new boolean[var6];
      this.cp = new byte[var6];

      int var3;
      for(var3 = 0; var3 < var6; ++var3) {
         byte[] var10000;
         int var10001;
         byte var10002;
         if (bigLump2[4][var3][2] == -1) {
            var10000 = this.cq;
            var10001 = var3;
            var10002 = 10;
         } else {
            var10000 = this.cq;
            var10001 = var3;
            var10002 = 0;
         }

         var10000[var10001] = var10002;
         this.cb[var3][0] = 128 + bigLump2[4][var3][0] << 16 >> 2;
         this.cb[var3][1] = 128 + bigLump2[4][var3][1] << 16 >> 2;
         this.cj[var3] = bigLump2[4][var3][2];
         this.cg[var3] = (short)(bigLump2[4][var3][3] * 2);
         this.ck[var3] = bigLump2[4][var3][4];
         if (this.ck[var3] > 0) {
            this.cq[var3] = this.ck[var3];
         }

         this.eX[var3] = -1;
         this.ch[var3] = (short)(bigLump2[4][var3][5] + 128);
         this.ct[var3] = true;
         this.cm[var3] = 1;
         this.cl[var3] = 1;
         this.cv[var3] = false;
         this.cw[var3] = true;
         this.cr[var3] = bigLump2[4][var3][6];
         this.cp[var3] = bigLump2[4][var3][7];
         this.cu[var3] = false;
         if (this.ck[var3] > 0 && (this.ck[var3] != 41 || this.selectedMap != 5 && this.selectedMap != 8)) {
            var10000 = this.co;
            var10001 = var3;
            var10002 = 0;
         } else {
            var10000 = this.co;
            var10001 = var3;
            var10002 = 100;
         }

         var10000[var10001] = var10002;
      }

      this.fx = bigLump2[4].length;
      this.fW = bigLump2[8][0][0];
      this.fX = bigLump2[8][0][1];
      this.fY = bigLump2[8][0][2];
      this.ga = bigLump2[8][0][3];
      this.fZ = bigLump2[8][0][4];
      this.fy = bigLump2[7].length;
      int var4 = 32;
      int var5 = bigLump2[7].length;

      for(var3 = 0; var3 < var5; ++var3) {
         this.cq[var4] = this.fW;
         this.cb[var4][0] = 128 + bigLump2[7][var3][0] << 16 >> 2;
         this.cb[var4][1] = 128 + bigLump2[7][var3][1] << 16 >> 2;
         this.ck[var4] = bigLump2[7][var3][2];
         this.cw[var4] = true;
         this.cr[var4] = bigLump2[7][var3][3];
         ++var4;
      }

      var4 = 64;
      var5 = bigLump2[9].length;
      this.cc = new int[var5][4];
      this.bV = var5;
      this.gY = new long[var5];

      for(int var2 = 0; var2 < var5; ++var2) {
         this.gY[var2] = 0L;
      }

      for(var3 = 0; var3 < var5; ++var3) {
         this.cq[var4] = bigLump2[9][var3][0];
         this.cb[var4][0] = 128 + bigLump2[9][var3][1] << 16 >> 2;
         this.cb[var4][1] = 128 + bigLump2[9][var3][2] << 16 >> 2;
         this.cc[var3][0] = var4;
         this.cc[var3][1] = 1;
         this.cc[var3][2] = bigLump2[9][var3][3];
         this.cc[var3][3] = bigLump2[9][var3][4] * 25;
         this.cw[var4] = true;
         ++var4;
      }

   }



   public void loadSpritesPart2(byte[][][] bigLump2) {
      BufferedImage var7 = null;
      BufferedImage var8 = null;
      var7 = this.readImage("/e" + this.dataExt);
      ResourcesLoaderL3D var10000;
      StringBuffer var10001;
      String var10002;
      if (this.selectedMap != 7) {
         var10000 = this;
         var10001 = new StringBuffer();
         var10002 = "/ee";
      } else {
         var10000 = this;
         var10001 = new StringBuffer();
         var10002 = "/eeeee";
      }

      var8 = var10000.readImage(var10001.append(var10002).append(this.dataExt).toString());
      int[] var9 = new int[2];
      var7.getRGB(0, 0, 2, 1, var9, 0, 2);
      this.N = var9[0];
      this.O = var9[1];
      this.bn = new short[7][];
      this.I = new int[this.bn.length];
      int var2 = this.bn.length;
      int var3 = (13 + bigLump2[5].length + 2) * 2;

      int var10;
      for(var10 = 0; var10 < var2; ++var10) {
         this.bn[var10] = new short[var3];
         this.I[var10] = 13 + bigLump2[5].length + 2;
         int var4 = this.bn[var10].length;

         for(int var11 = 0; var11 < var4; ++var11) {
            this.bn[var10][var11] = 0;
         }
      }

      int var14 = 13 + bigLump2[5].length;
      this.ci = new short[var14];
      this.bq = new short[var14];
      this.br = new short[var14];
      this.bg = new int[var14];
      this.bs = new short[var14];
      this.bt = new short[var14];
      int var13 = 0;
      var2 = this.h.length;

      for(var10 = 0; var10 < var2; var10 += 7) {
         this.loadSprites_subfunction1(this.h, var13, var10);
         this.ci[var13] = this.h[var10 + 6];
         ++var13;
      }

      var13 = 13;
      var2 = bigLump2[5].length;

      for(int var12 = 0; var12 < var2; ++var12) {
         var10 = (bigLump2[5][var12][0] < 0 ? -bigLump2[5][var12][0] : bigLump2[5][var12][0]) * 7;
         this.loadSprites_subfunction1(this.i, var13, var10);
         this.ci[var13] = this.i[var10 + 6];
         ++var13;
      }

      int var16 = this.bn[0][this.I[0]] + 10;
      int var17 = this.bn[1][this.I[1]] + 10;
      int var18 = this.bn[2][this.I[2]] + 10;
      int var19 = this.bn[3][this.I[3]] + 10;
      int var20 = this.bn[4][this.I[4]] + 10;
      int var21 = this.bn[6][this.I[6]] + 10;
      this.loadSprites_subfunction2(var16, var17, bigLump2[1].length, var18, var19, var20, var21);
      var13 = 0;
      short var22 = 0;
      var2 = this.h.length;

      for(var10 = 0; var10 < var2; var10 += 7) {
         this.FOE_SPRITES_W.add(this.h[var10 + 2]);
         this.FOE_SPRITES_H.add(this.h[var10 + 3]);
         int[] var5 = new int[this.h[var10 + 2] * this.h[var10 + 3]];
         int[] var6 = new int[this.h[var10 + 2] * this.h[var10 + 3]];
         var7.getRGB(this.h[var10 + 0], this.h[var10 + 1], this.h[var10 + 2], this.h[var10 + 3], var5, 0, this.h[var10 + 2]);
         var8.getRGB(this.h[var10 + 0], this.h[var10 + 1], this.h[var10 + 2], this.h[var10 + 3], var6, 0, this.h[var10 + 2]);
         int[] layer1CutColor2 = new int[var5.length];
         this.combineLayers(var5, var6, this.bm, var22, bigLump2[0][0], bigLump2[0][1], layer1CutColor2);
         this.FOE_SPRITES_DATA_COLOR_1.add(var5);
         this.FOE_SPRITES_DATA_COLOR_2.add(layer1CutColor2);
         var22 = (short)(var22 + 50);
         // int var15 = this.bt[var13] / this.br[var13];
         // if (this.bq[var13] == 0) {
         //    this.b(var13, var15, var5);
         // } else if (this.bq[var13] == 1) {
         //    this.a(var13, var15, var5);
         // }

         ++var13;
      }

   }


   public void loadSprites_subfunction1(short[] var1, int var2, int var3) {
      this.bs[var2] = var1[var3 + 2];
      this.bt[var2] = var1[var3 + 3];
      int var4 = this.bt[var2] / var1[var3 + 5];
      this.bn[var1[var3 + 4]][var2] = this.bn[var1[var3 + 4]][this.I[var1[var3 + 4]]];
      this.bn[var1[var3 + 4]][this.I[var1[var3 + 4]] + 1] = (short)(this.bn[var1[var3 + 4]][this.I[var1[var3 + 4]]] + this.bs[var2] * var4);
      int var10002 = this.I[var1[var3 + 4]]++;
      this.bq[var2] = var1[var3 + 4];
      this.br[var2] = var1[var3 + 5];
      this.bg[var2] = (var1[var3 + 5] << 16 >> 3) * this.bs[var2] / this.bt[var2];
      int[] var10000 = this.bg;
      var10000[var2] >>= 1;
   }


   public void loadSprites_subfunction2(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.bm = new int[2][(13 + var3) * 50];
      this.bj = new int[50];
      this.di = new byte[var1];
      this.dj = new byte[var1];
      this.dk = new byte[var1];
      this.dl = new byte[var1];
      this.dm = new byte[var1];
      this.dn = new byte[var1];
      this.do_ = new byte[var2];
      this.dp = new byte[var2];
      this.dq = new byte[var4];
      this.dr = new byte[var4];
      this.ds = new byte[var5];
      this.dt = new byte[var5];
      this.du = new byte[var5];
      this.dv = new byte[var5];
      this.dw = new byte[var6];
      this.dx = new byte[var6];
      this.dy = new byte[var7];
      this.dz = new byte[var7];
      this.dA = new byte[var7];
      this.dB = new byte[var7];
      this.dC = new byte[var7];
      this.dD = new byte[var7];
      this.dE = new byte[var7];
      this.dF = new byte[var7];
   }


   // public void combineLayers(int[] var1, int[] var2, int[][] var3, short var4, byte[] var5, byte[] var6) {
   //    boolean var11 = false;
   //    byte var12 = 1;
   //    int var13 = var1.length;
   //    byte[] var14 = new byte[256];
   //    int[] var15 = new int[50];
   //    short var17 = var4;
   //    short var18 = 0;

   //    int var7;
   //    int var10;
   //    int var16;
   //    byte var21;
   //    for(var7 = 0; var7 < var13; ++var7) {
   //       if ((var16 = var1[var7]) == this.N) {
   //          var1[var7] = -1;
   //       } else {
   //          var10 = var16 & 255;
   //          if ((var21 = var14[var10]) > 0) {
   //             var1[var7] = var15[var21];
   //          } else {
   //             var14[var10] = var12;
   //             var15[var12] = var18;
   //             ++var12;
   //             int var19 = this.loadTextures_subfunction4(var5[0], var5[1], var5[2], var5[3], var5[4], var10, false);
   //             int var20 = this.loadTextures_subfunction4(var6[0], var6[1], var6[2], var6[3], var6[4], var10, false);
   //             var3[0][var17] = (int)((long)var19 | 0L);
   //             var3[1][var17] = (int)((long)var20 | 0L);
   //             var1[var7] = var18++;
   //             ++var17;
   //          }
   //       }
   //    }

   //    this.B = new byte[32][32][32];
   //    var15 = new int[50];

   //    for(var7 = 0; var7 < var13; ++var7) {
   //       if ((var16 = var2[var7]) != this.N) {
   //          int var8 = (var16 & 16711680) >> 19;
   //          int var9 = (var16 & '\uff00') >> 11;
   //          var10 = (var16 & 255) >> 3;
   //          if ((var21 = this.B[var8][var9][var10]) > 0) {
   //             var1[var7] = var15[var21];
   //          } else {
   //             this.B[var8][var9][var10] = var12;
   //             var15[var12] = var18;
   //             ++var12;
   //             if (var2[var7] != this.N) {
   //                var3[0][var17] = (int)((long)var16 | 0L);
   //                var3[1][var17] = (int)((long)var16 | 0L);
   //             }

   //             var1[var7] = var18++;
   //             ++var17;
   //          }
   //       }
   //    }

   // }

   private void combineLayers(int[] layer1, int[] layer2, int[][] colorData, short startIndex, byte[] palette1, byte[] palette2, int[] layer1Color2) {
      int layerLength = layer1.length;

      int i;
      int colorValue;
      int pixel;

      for(i = 0; i < layerLength; ++i) {
         pixel = layer1[i];
         if (pixel == this.N) {
            layer1[i] = this.N;
            if (layer1Color2 != null) {
               layer1Color2[i] = this.N;
            }
         } else {
            colorValue = pixel & 255;
               int color1 = this.loadTextures_subfunction4(palette1[0], palette1[1], palette1[2], palette1[3], palette1[4], colorValue, false);
               int color2 = this.loadTextures_subfunction4(palette2[0], palette2[1], palette2[2], palette2[3], palette2[4], colorValue, false);
               layer1[i] = color1;
               if (layer1Color2 != null) {
                  layer1Color2[i] = color2;
               }
         }
      }

      for(i = 0; i < layerLength; ++i) {
         if ((pixel = layer2[i]) != this.N) {
            layer1[i] = pixel;
            if (layer1Color2 != null) {
               layer1Color2[i] = pixel;
            }
         }
      }

   }



   public void loadSpritesPart3(byte[][][] bigLump2) {
      int[][] var8 = new int[bigLump2[5].length][];
      int[][] var9 = new int[bigLump2[5].length][];
      boolean var2 = false;
      int var7 = bigLump2[5].length;
      this.SPRITES_W = new short[var7];
      this.SPRITES_H = new short[var7];

      int var4;
      for(int var5 = 0; var5 <= 1; ++var5) {
         BufferedImage var10 = this.readImage(this.spriteFiles[var5] + this.dataExt);
         BufferedImage var11 = this.readImage(this.spriteFiles[var5 + 2] + this.dataExt);

         for(var4 = 0; var4 < var7; ++var4) {
            if (var5 == 0) {
               if (bigLump2[5][var4][0] < 0) {
                  continue;
               }
            } else {
               if (bigLump2[5][var4][0] >= 0) {
                  continue;
               }

               bigLump2[5][var4][0] = (byte)(-bigLump2[5][var4][0]);
            }

            int var3 = bigLump2[5][var4][0] * 7;
            var8[var4] = new int[this.i[var3 + 2] * this.i[var3 + 3]];
            var9[var4] = new int[this.i[var3 + 2] * this.i[var3 + 3]];
            this.SPRITES_W[var4] = this.i[var3 + 2];
            this.SPRITES_H[var4] = this.i[var3 + 3];
            var10.getRGB(this.i[var3 + 0], this.i[var3 + 1], this.i[var3 + 2], this.i[var3 + 3], var8[var4], 0, this.i[var3 + 2]);
            var11.getRGB(this.i[var3 + 0], this.i[var3 + 1], this.i[var3 + 2], this.i[var3 + 3], var9[var4], 0, this.i[var3 + 2]);
         }
      }

      short var13 = 650;
      var7 = bigLump2[5].length;

      for(var4 = 0; var4 < var7; ++var4) {
         int[] layer1Color2 = new int[var8[var4].length];
         this.combineLayers(var8[var4], var9[var4], this.bm, var13, bigLump2[6][var4], bigLump2[1][var4], layer1Color2);
         this.SPRITES_DATA_COLOR_1.add(var8[var4]);
         this.SPRITES_DATA_COLOR_2.add(layer1Color2);
         var13 = (short)(var13 + 50);
      }

      // var7 = 13 + bigLump2[5].length;

      // for(int var12 = 13; var12 < var7; ++var12) {
      //    int var6 = this.bt[var12] / this.br[var12];
      //    if (this.bq[var12] == 0) {
      //       this.b(var12, var6, var8[var12 - 13]);
      //    } else if (this.bq[var12] == 1) {
      //       this.a(var12, var6, var8[var12 - 13]);
      //    } else if (this.bq[var12] == 2) {
      //       this.c(var12, var6, var8[var12 - 13]);
      //    } else if (this.bq[var12] == 3) {
      //       this.d(var12, var6, var8[var12 - 13]);
      //    } else if (this.bq[var12] == 4) {
      //       this.e(var12, var6, var8[var12 - 13]);
      //    } else if (this.bq[var12] == 6) {
      //       this.f(var12, var6, var8[var12 - 13]);
      //    }
      // }

      // this.B = (byte[][][])null;
      // System.gc();
   }
















   public void loadTextures(byte[][][] bigLump0, byte[][][] bigLump1, short[] footer) {
      int var20 = 0;
      this.J = new int[bigLump1[9].length][];
      this.K = new int[bigLump1[9].length];
      int var19 = bigLump1.length;

      int var4;
      for(var4 = 0; var4 < var19; ++var4) {
         if (var4 != 9 && var4 != 32) {
            bigLump1[var4] = (byte[][])null;
         }
      }

      bigLump0[0] = (byte[][])null;
      System.gc();
      var19 = bigLump0[4].length;

      int var24;
      for(var4 = 0; var4 < var19; ++var4) {
         var24 = bigLump1[9][var4][0];
         if (bigLump0[4][var4][2] == 0) {
            bigLump0[4][var4][2] = (byte)(this.n[6 * var24 + 3] + 128);
         }

         if (bigLump0[4][var4][3] == 0) {
            bigLump0[4][var4][3] = (byte)(this.n[6 * var24 + 4] + 128);
         }
      }

      var19 = bigLump1[9].length;

      int var5;
      int[] var10001;
      int var10002;
      int var10003;
      int var10004;
      byte var10006;
      int var10007;
      for(var4 = 0; var4 <= 2; ++var4) {
         BufferedImage var32 = this.readImage("/" + String.valueOf(var4) + this.dataExt);

         for(var5 = 0; var5 < var19; ++var5) {
            byte var26 = bigLump1[9][var5][0];
            int var21 = this.n[6 * var26] + 128;
            int var22 = bigLump0[4][var5][2] * 2;
            int var23 = bigLump0[4][var5][3] * 2;
            if (var21 == var4) {
               label154: {
                  this.J[var20] = new int[var22 * var23];
                  this.K[var5] = var20;
                  int var27 = var26 != 125 ? (this.n[6 * var26 + 1] + 128 + bigLump0[4][var5][0]) * 2 : 548;
                  int var28 = (this.n[6 * var26 + 2] + 128 + bigLump0[4][var5][1]) * 2;
                  var32.getRGB(var27, var28, var22, var23, this.J[var20], 0, var22);
                  BufferedImage var10000;
                  int var10005;
                  if (bigLump1[9][var5][0] == 79) {
                     this.go = new int[784];
                     var10000 = var32;
                     var10001 = this.go;
                     var10002 = 0;
                     var10003 = 28;
                     var10004 = var27 + 4;
                     var10005 = var28 + 2;
                     var10006 = 28;
                     var10007 = 28;
                  } else if (bigLump1[9][var5][0] == 78) {
                     this.gp = new int[676];
                     var10000 = var32;
                     var10001 = this.gp;
                     var10002 = 0;
                     var10003 = 26;
                     var10004 = var27 + 4;
                     var10005 = var28 + 4;
                     var10006 = 26;
                     var10007 = 26;
                  } else if (bigLump1[9][var5][0] == 80) {
                     this.gq = new int[784];
                     var10000 = var32;
                     var10001 = this.gq;
                     var10002 = 0;
                     var10003 = 28;
                     var10004 = var27 + 4;
                     var10005 = var28 + 2;
                     var10006 = 28;
                     var10007 = 28;
                  } else {
                     if (bigLump1[9][var5][0] != 55) {
                        break label154;
                     }

                     this.gp = new int[1152];
                     var10000 = var32;
                     var10001 = this.gp;
                     var10002 = 0;
                     var10003 = 48;
                     var10004 = var27;
                     var10005 = var28;
                     var10006 = 48;
                     var10007 = 24;
                  }

                  var10000.getRGB(var10004, var10005, var10006, var10007, var10001, var10002, var10003);
               }

               this.loadTextures_subfunction1(this.J[var20], bigLump0, bigLump1, var5);
               ++var20;
            }
         }
      }

      this.bi = new int[bigLump0[3].length + 1];
      int var17 = 0;
      this.bi[0] = 0;
      this.bh = new int[bigLump0[3].length + 1];
      this.bo = new short[bigLump0[3].length * 9];
      int var10 = footer[6] * 2 * 2;
      int var11 = footer[7] * 2 * 2;
      this.loadTextures_subfunction2(var10, var11);
      int var14 = 0;
      this.L = -1;
      byte var7 = -1;
      boolean var9 = false;
      var19 = bigLump0[3].length;

      for(var4 = 0; var4 < var19; ++var4) {
         byte var8 = var7;
         byte var6 = bigLump1[32][var4][0];
         this.M = bigLump1[9][var6][0];
         byte var31 = var4 != var19 - 1 ? bigLump1[32][var4 + 1][0] : -1;
         var7 = bigLump1[9][var6][0];
         this.G = bigLump0[4][var6][2] * 2;
         this.H = bigLump0[4][var6][3] * 2;
         this.F = bigLump0[2][var6][5];
         if (this.F >= 1 && this.F <= 5) {
            this.G *= 2;
         }

         if (this.F >= 4 && this.F <= 9) {
            this.H *= 2;
         }

         int var15 = this.G;
         int var16 = this.H;
         this.E = new int[var15 * var16];
         ResourcesLoaderL3D var34;
         if (bigLump0[3][var4][3] != 1 && bigLump0[3][var4][3] != 2) {
            if (this.n[6 * var7] + 128 > 2) {
               this.loadTextures_subfunction6((byte[][][])bigLump0, (byte[][][])bigLump1, var6, 0, var8, var7, var31);
               var34 = this;
               var10001 = this.E;
            } else {
               var34 = this;
               var10001 = this.J[this.K[var6]];
            }

            var34.loadTextures_subfunction8(var10001, var15, bigLump0[4][var6][2] * 2, bigLump0[4][var6][3] * 2, bigLump0[2][var6][5], 0, 0);
         }

         int var12 = bigLump0[3][var4][1] * 2;
         int var13 = bigLump0[3][var4][2] == 0 ? this.G : bigLump0[3][var4][2] * 2;
         boolean var33 = false;
         var24 = bigLump0[3][var4][0] == bigLump0[3][var4][1] ? var13 : (bigLump0[3][var4][3] != 2 ? this.G : 96);
         byte var25 = bigLump0[3][var4][0];
         if (bigLump0[3][var4][3] == 1) {
            var14 = this.loadTextures_subfunction16(bigLump1[32][var4][0], bigLump1[32][var4][1], (byte)var4, (byte)var12, (byte)var13, (short)140, var14, (short)26, (byte)(var12 + 23));
         } else if (bigLump0[3][var4][3] == 2) {
            var14 = this.loadTextures_subfunction16(bigLump1[32][var4][0], bigLump1[32][var4][1], (byte)var4, (byte)var12, (byte)var13, (short)((byte)var24), var14, (short)0, (byte)var12);
         } else {
            var14 = this.loadTextures_subfunction16((byte)var25, (byte)var4, (byte)var4, (byte)var12, (byte)var13, (short)((byte)var24), var14, (short)0, (byte)var12);

            for(var5 = 1; var5 <= 3 && bigLump1[32][var4][var5] != var6; ++var5) {
               var6 = bigLump1[32][var4][var5];
               this.G = bigLump0[4][var6][2] * 2;
               this.H = bigLump0[4][var6][3] * 2;
               this.F = bigLump0[2][var6][5];
               if (this.F >= 1 && this.F <= 5) {
                  this.G *= 2;
               }

               if (this.F >= 4 && this.F <= 9) {
                  this.H *= 2;
               }

               if (this.n[6 * bigLump1[9][var6][0]] + 128 > 2) {
                  this.loadTextures_subfunction6((byte[][][])bigLump0, (byte[][][])bigLump1, var6, var5, -1, -2, -1);
                  var34 = this;
                  var10001 = this.C;
               } else {
                  var34 = this;
                  var10001 = this.J[this.K[var6]];
               }

               var34.loadTextures_subfunction8(var10001, var15, bigLump0[4][var6][2] * 2, bigLump0[4][var6][3] * 2, bigLump0[2][var6][5], bigLump0[2][var6][6] * 2, bigLump0[2][var6][7] * 2);
            }

            this.bi[var4] = this.bi[var17];
            this.bi[var17 + 1] = this.bi[var17] + var13 * 12;
            ++var17;
            int[] var10008;
            boolean var10009;
            int[] var35;
            byte var36;
            if (bigLump0[3][var4][3] != 0) {
               loadTextures_subfunction18(this.cS, this.cT, this.bi[var4], var12, var13, 12, 0, var15, this.E, true);
               var35 = this.cU;
               var10001 = this.cV;
               var10002 = this.bi[var4];
               var10003 = var12;
               var10004 = var13;
               var36 = 12;
               var10006 = 2;
               var10007 = var15;
               var10008 = this.E;
               var10009 = true;
            } else {
               loadTextures_subfunction18(this.cS, this.cT, this.bi[var4], var12, var13, 12, 0, var15, this.E, true);
               loadTextures_subfunction18(this.cU, this.cV, this.bi[var4], var12, var13, 12, 2, var15, this.E, true);
               loadTextures_subfunction18(this.cW, this.cX, this.bi[var4], var12, var13, 12, 6, var15, this.E, false);
               var35 = this.cY;
               var10001 = this.cZ;
               var10002 = this.bi[var4];
               var10003 = var12;
               var10004 = var13;
               var36 = 12;
               var10006 = 4;
               var10007 = var15;
               var10008 = this.E;
               var10009 = false;
            }

            loadTextures_subfunction18(var35, var10001, var10002, var10003, var10004, var36, var10006, var10007, var10008, var10009);
            this.TEXTURES_W.add(var15);
            this.TEXTURES_H.add(var16);
            this.TEXTURES_DATA.add(this.E);

         }
      }

      // this.C = null;
      // this.D = null;
      // this.E = null;
      // this.J = (int[][])null;
      // this.K = null;
      // this.y = null;
      // this.z = null;
      // System.gc();
   }

   public static void loadTextures_subfunction18(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int[] var8, boolean var9) {
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



   public void loadTextures_subfunction1(int[] var1, byte[][][] var2, byte[][][] var3, int var4) {
      byte var5 = var2[2][var4][0];
      byte var6 = var2[2][var4][1];
      byte var7 = var2[2][var4][2];
      byte var8 = var2[2][var4][3];
      byte var9 = var2[2][var4][4];
      boolean var10 = var3[9][var4][0] == 1 || var3[9][var4][0] == 11 || var3[9][var4][0] == 15;
      if (var5 != 0 || var6 != 0 || var7 != 0 || var8 != 0 || var9 != 0) {
         this.loadTextures_subfunction3(var1, var5, var6, var7, var8, var9, var10);
      }

   }


   public void loadTextures_subfunction2(int var1, int var2) {
      this.cS = new int[var1];
      this.cT = new int[var1];
      this.cU = new int[var1];
      this.cV = new int[var1];
      this.cW = new int[var2];
      this.cX = new int[var2];
      this.cY = new int[var2];
      this.cZ = new int[var2];
   }


   public void loadTextures_subfunction6(byte[][][] var1, byte[][][] var2, int var3, int var4, int var5, int var6, int var7) {
      byte var8 = var2[9][var3][0];
      byte var9 = var1[2][var3][5];
      int var10 = this.n[6 * var8] + 128;
      if (this.L != var3 && var5 != var6) {
         if (var4 == 0) {
            if (var9 != 12) {
               this.y = this.readImage("/" + String.valueOf(var10) + this.dataExt);
            } else {
               BufferedImage var11 = this.readImage("/" + String.valueOf(var10) + this.dataExt);
               int width = var11.getWidth();
               int height = var11.getHeight();
               BufferedImage transformedImage = new BufferedImage(height, width, BufferedImage.TYPE_INT_RGB);
               Graphics2D g2d = transformedImage.createGraphics();
               g2d.translate(height / 2, width / 2); // move to the center of the new image
               g2d.rotate(Math.PI / 2); // rotate 90 degrees clockwise
               g2d.scale(-1, 1); // reflect about vertical center
               g2d.translate(-width / 2, -height / 2); // adjust translation
               g2d.drawImage(var11, 0, 0, null);
               g2d.dispose();
               this.y = transformedImage;  // assign the transformed image to y
            }
         } else {
            this.z = this.readImage("/" + String.valueOf(var10) + this.dataExt);
         }
      }

      if (this.L != var3) {
         BufferedImage var10000;
         int[] var10001;
         if (var4 == 0) {
            var10000 = this.y;
            var10001 = this.E;
         } else {
            this.C = new int[this.G * this.H];
            var10000 = this.z;
            var10001 = this.C;
         }

         var10000.getRGB(var1[4][var3][0], var1[4][var3][1], this.G, this.H, var10001, 0, this.G);
         ResourcesLoaderL3D var14;
         if (var4 != 0) {
            var14 = this;
            var10001 = this.C;
         } else {
            var14 = this;
            var10001 = this.E;
         }

         var14.loadTextures_subfunction1(var10001, var1, var2, var3);
         if (var4 == 0 && var7 == var3) {
            this.L = var3;
            this.D = new int[this.G * this.H];
            this.loadTextures_subfunction7(this.D, this.E, 0, 0, this.G, this.G, this.H);
         }

      } else {
         int var13 = this.D.length;

         for(int var12 = 0; var12 < var13; ++var12) {
            this.E[var12] = this.D[var12];
         }

      }
   }



   public void loadTextures_subfunction8(int[] var1, int var2, int var3, int var4, byte var5, int var6, int var7) {
      if (var5 == 0) {
         if (this.M != 26 && this.M != 27 && this.M != 28 && this.M != 1 && this.M != 91 && this.M != 114 && this.M != 15 && this.M != 99 && this.M != 100 && this.M != 11 && this.M != 10 && this.M != 22 && this.M != 23 && this.M != 39 && this.M != 38 && this.M != 40 && this.M != 41 && this.M != 42 && this.M != 43 && this.M != 44 && this.M != 46 && this.M != 39 && this.M != 37 && this.M != 12) {
            this.loadTextures_subfunction7(this.E, var1, var6, var7, var2, var3, var4);
         } else {
            this.loadTextures_subfunction7(this.E, var1, var6, var7, var2, var3, var4);
            this.loadTextures_subfunction9((int[])this.E, (int[])this.E, 0, 0, var2, var3, var4);
         }
      } else if (var5 == 1) {
         if (this.M == 103 || this.M == 104) {
            this.loadTextures_subfunction9((int[])var1, (int[])var1, 0, 0, var3, var3, var4);
         }

         this.loadTextures_subfunction10(this.E, var1, var6, var7, var2, var3, var4);
      } else if (var5 == 2) {
         this.loadTextures_subfunction11(this.E, var1, var6, var7, var2, var3, var4);
      } else if (var5 == 3) {
         this.loadTextures_subfunction12(this.E, var1, var6, var7, var2, var3, var4);
      } else {
         if (var5 != 5) {
            if (var5 == 6) {
               this.loadTextures_subfunction13(this.E, var1, var6, var7, var2, var3, var4);
               return;
            }

            if (var5 == 10) {
               this.loadTextures_subfunction14(this.E, var1, var6, var7, var2, var3, var4);
               return;
            }

            if (var5 != 11) {
               return;
            }
         }

         this.loadTextures_subfunction15(this.E, var1, var6, var7, var2, var3, var4, var5);
      }
   }


   public int loadTextures_subfunction16(byte var1, byte var2, byte var3, byte var4, byte var5, short var6, int var7, short var8, byte var9) {
      this.bh[var3] = var7;
      int var10 = this.loadTextures_subfunction17((byte)0, var1, (short)var8, var7);
      var10 = this.loadTextures_subfunction17(var9, var2, (short)0, var10);
      var10 = this.loadTextures_subfunction17((byte)(var9 + var5), var1, (short)((byte)(var4 + var5)), var10);
      this.bh[var3 + 1] = var10;
      this.bp[var3] = var6;
      return var10;
   }

   public int loadTextures_subfunction17(byte var1, byte var2, short var3, int var4) {
      this.bo[var4] = (short)var1;
      int var5 = var4 + 1;
      this.bo[var5] = (short)var2;
      ++var5;
      this.bo[var5] = var3;
      ++var5;
      return var5;
   }


   public void loadTextures_subfunction3(int[] var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      int var10 = 1;
      boolean var11 = false;
      int var12 = var1.length;
      int[] var13 = new int[257];
      int[] var14 = new int[257];

      for(int var8 = 0; var8 < var12; ++var8) {
         int var16;
         if ((var16 = var1[var8]) != this.N) {
            int var9 = var16 & 255;
            int var20;
            if ((var20 = var13[var9]) > 0) {
               var1[var8] = var14[var20];
            } else {
               var13[var9] = var10;
               var1[var8] = this.loadTextures_subfunction4(var2, var3, var4, var5, var6, var9, var7);
               var14[var10] = var1[var8];
               ++var10;
            }
         }
      }

   }

   public int loadTextures_subfunction4(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
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
         var9[var8] = loadTextures_subfunction5((int)(var9[var8] + var15), var16);
         var9[var8] = loadTextures_subfunction5((int)(var10 + (var9[var8] - var10) * (var4 + var14) / var14), var16);
      }

      return var9[0] << var11 | var9[1] << var12 | var9[2] << var13;
   }

   public static int loadTextures_subfunction5(int var0, int var1) {
      if (var0 > var1) {
         return var1;
      } else {
         return var0 < 0 ? 0 : var0;
      }
   }


   public void loadTextures_subfunction7(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var11 = var4 * var5 + var3;
      int var10 = 0;
      int var14 = var4 + var7;

      for(int var9 = var4; var9 < var14; ++var9) {
         int var12 = var11 + var6;

         for(int var8 = var11; var8 < var12; ++var8) {
            int var13;
            if ((var13 = var2[var10]) != this.N) {
               var1[var8] = var13;
            }

            ++var10;
         }

         var11 += var5;
      }

   }


   public void loadTextures_subfunction9(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var11 = var4 * var5 + var3;
      int var10 = 0;
      int var14 = var4 + var7;

      for(int var9 = var4; var9 < var14; ++var9) {
         int var12 = var11 + var6;

         for(int var8 = var11; var8 < var12; ++var8) {
            int[] var10000;
            int var10001;
            int var10002;
            label25: {
               int var13;
               if ((var13 = var2[var10]) != this.N) {
                  if (var13 != this.O) {
                     var10000 = var1;
                     var10001 = var8;
                     var10002 = var13;
                     break label25;
                  }

                  var10000 = var1;
                  var10001 = var8;
                  var10002 = this.aS;
               } else {
                  var10000 = var1;
                  var10001 = var8;
                  var10002 = this.aT;
               }

               var10002 &= 16777215;
            }

            var10000[var10001] = var10002;
            ++var10;
         }

         var11 += var5;
      }

   }


   public void loadTextures_subfunction10(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var12 = var4 * var5 + var3;
      int var13 = 2 * var6 - 1;
      int var11 = 0;
      int var16 = var4 + var7;

      for(int var10 = var4; var10 < var16; ++var10) {
         int var14 = var12 + var6;
         int var9 = var12 + var13;

         for(int var8 = var12; var8 < var14; ++var8) {
            int var15;
            if ((var15 = var2[var11]) != this.N) {
               var1[var8] = var15;
               var1[var9] = var15;
            }

            ++var11;
            --var9;
         }

         var12 += var5;
      }

   }

   public void loadTextures_subfunction11(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var12 = (var4 + var7 - 1) * var5 + var3;
      int var13 = 2 * var6 - 1;
      int var11 = 0;

      for(int var10 = var4 + var7 - 1; var10 >= var4; --var10) {
         int var14 = var12 + var6;
         int var9 = var12 + var13;

         for(int var8 = var12; var8 < var14; ++var8) {
            int var15;
            if ((var15 = var2[var11]) != this.N) {
               var1[var8] = var15;
               var1[var9] = var15;
            }

            ++var11;
            --var9;
         }

         var12 -= var5;
      }

   }

   public void loadTextures_subfunction12(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var11 = var4 * var5 + var3;
      int var10 = 0;
      int var14 = var4 + var7;

      for(int var9 = var4; var9 < var14; ++var9) {
         int var12 = var11 + var6;

         for(int var8 = var11; var8 < var12; ++var8) {
            int var13;
            if ((var13 = var2[var10]) != this.N) {
               var1[var8] = var13;
               var1[var8 + var6] = var13;
            }

            ++var10;
         }

         var11 += var5;
      }

   }

   public void loadTextures_subfunction15(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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
            if ((var20 = var2[var14]) != this.N) {
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

   public void loadTextures_subfunction13(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var12 = var4 * var5 + var3;
      int var9 = var5 * var7;
      int var11 = 0;
      int var15 = var4 + var7;

      for(int var10 = var4; var10 < var15; ++var10) {
         int var13 = var12 + var6;

         for(int var8 = var12; var8 < var13; ++var8) {
            int var14;
            if ((var14 = var2[var11]) != this.N) {
               var1[var8] = var14;
               var1[var8 + var9] = var14;
            }

            ++var11;
         }

         var12 += var5;
      }

   }

   public void loadTextures_subfunction14(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
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
            if ((var13 = var2[var10]) != this.N) {
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
            if ((var13 = var2[var10]) != this.N) {
               var1[var8] = var13;
            }

            ++var10;
         }

         var11 += var5;
      }

   }







}









