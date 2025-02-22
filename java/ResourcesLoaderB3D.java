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

public class ResourcesLoaderB3D {
   public String ROOT_JAR = "../jars/b3d.d";
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

   public byte c;
   public boolean e;
   public int f = 10;
   public int g = 10;
   public int h = 10;
   public final short[] i = new short[]{1, 81, 161};
   public short[] unusedMapRawLump1;
   public short[] FOE_METADATA;       // i +   0  1  2  3  4  5  6
                                       // val   x  y  w  h
   public short[] l;
   public short[] m;
   public byte[] n;
   public byte[] o;
   public byte[] p;
   public byte[] q;
   public byte[] r;
   public byte[] s;
   public byte[] t;
   public byte[] u;
   /*
                  loadedMap
      -----------------------------------
      | header, 3 shorts: A, B, C       |
      -----------------------------------
   0   | 5 shorts, can be negative       |
      -----------------------------------
   1   | A*4 nibbles as bytes            |
      -----------------------------------
   2   | B bytes                         |
      -----------------------------------
   3   | 72 bytes                        |
      -----------------------------------
   4   | C bytes                         |
      -----------------------------------
   5   | 10 bytes                        |
      -----------------------------------
      | footer, 8 shorts                |
      -----------------------------------
   */
   public byte[][] loadedMap;
   public byte[] lumpsSizes = new byte[]{5, 72, 10, 8};
   public String dataExt = ".b3d";
   public String[] mapFiles = new String[]{"/d", "/b", "/o", "/x", "/m", "/t", "/g", "/y", "/l"};
   public byte[] z;
   public String[] spriteFiles = new String[]{"/p", "/r", "/pp", "/rr"};
   public byte[][] B = new byte[][]{{1, 1, -1, 1}, {-1, 1, -1, -1}, {-1, -1, 1, -1}, {1, -1, 1, 1}};
   public byte[][][][] E;
   public byte[][][] F;
   public int[] G;
   public int[] H;
   public int[] I;
   public byte J;
   public int K;
   public int L;
   public int[] M;
   public int[][] N;
   public int[] O;
   public int P;
   public int Q;
   public int selectedMap;
   public boolean gB;
   public int[] bi;
   public int[][] cW;
   public byte[] by;
   public byte[] bz;
   public int eX;
   public byte[] cX;
   public byte[] a;

   public short[][] cD;
   public short[][] cE;
   public int fa;
   public int fb;
   public int fc;
   public int cB;
   public byte cC;
   public int eY;
   public byte[] bZ;
   public byte[] ca;
   public byte[] cb;
   public byte[] cc;
   public byte[] cd;
   public byte[] ce;
   public byte[] cf;
   public byte[] cg;
   public byte[] ch;
   public byte[][] ci;
   public boolean[] cj;
   public boolean[] ck;
   public boolean[] cl;
   public boolean[] cm;
   public int[][] bT;
   public int eZ;
   public int[][] dp;
   public int[][] dq;
   public byte[] dr;
   public byte[] ds;
   public byte[] dt;
   public byte[] du;
   public int[] dv;
   public int[] dw;
   public int[] dx;
   public int[] dy;
   public int[] dz;
   public int[] dA;
   public int[] dB;
   public byte[] bA;
   public short[] bs;
   public short[] fD;
   public short[][] fE;
   public byte[] fF;
   public byte[][] fG;
   public byte[][] fH;
   public int fd;
   public int[] bh;
   public long[] fz;
   public int fk;
   public int eR;
   public int eS;
   public int[] cosTable;
   public int ff;


   public short[] bW;
   public short[] bX;
   public int[] ei;
   public int eP;
   public int eQ;
   public byte fl;
   public byte fm;
   public byte fn;
   public byte fo;
   public byte fp;
   public byte fq;
   public Random dR = new Random();
   public short[][] bq;
   public short[] bY;
   public short[] bt;
   public short[] bu;
   public short[] foeW;
   public short[] foeH;
   public int[] bj;


   public int backgroundColor;
   public BufferedImage C;
   public BufferedImage D;
   public int[] bk;
   public short[] br;
   public int aV;
   public int aW;
   public int[] fA;
   public int[] fB;
   public int[] fC;
   public int[] bl;
   public int[] cI;
   public int[] cJ;
   public int[] cK;
   public int[] cL;
   public int[] cM;
   public int[] cN;
   public int[] cO;
   public int[] cP;

   public int[][] bp;
   public int[] bm;
   public byte[] cY;
   public byte[] cZ;
   public byte[] da;
   public byte[] db;
   public byte[] dc;
   public byte[] dd;
   public byte[] de;
   public byte[] df;
   public byte[] dg;
   public byte[] dh;
   public byte[] di;
   public byte[] dj;
   public byte[] dk;
   public byte[] dl;
   public byte[] dm;
   public byte[] dn;


   public ResourcesLoaderB3D() {
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

   public void initCosTable() {
      this.cosTable = new int[91];
      this.cosTable[1] = 1146;
      int var1 = 1146;

      for(int var2 = 2; var2 <= 90; ++var2) {
         var1 += this.a[var2 - 2];
         this.cosTable[var2] = this.cosTable[var2 - 1] + var1;
      }

      this.a = null;
   }


   public void readMetadata() {
      int pos = 0;
      byte[] metadataFile = this.readBinary("/a" + this.dataExt);
      short[] header = new short[12];

      int i;
      for(i = 0; i < 12; ++i) {
         header[i] = readShort(metadataFile, pos);
         pos += 2;
      }

      short length = header[0];
      this.FOE_METADATA = new short[length];

      for(i = 0; i < length; ++i) {
         this.FOE_METADATA[i] = readShort(metadataFile, pos);
         pos += 2;
      }

      length = header[1];
      this.l = new short[length];

      for(i = 0; i < length; ++i) {
         this.l[i] = (short)metadataFile[pos];
         ++pos;
      }

      length = header[2];
      this.n = new byte[length];

      for(i = 0; i < length; ++i) {
         this.n[i] = metadataFile[pos];
         ++pos;
      }

      length = header[3];
      this.o = new byte[length];

      for(i = 0; i < length; ++i) {
         this.o[i] = metadataFile[pos];
         ++pos;
      }

      length = header[4];
      this.p = new byte[length];

      for(i = 0; i < length; ++i) {
         this.p[i] = metadataFile[pos];
         ++pos;
      }

      length = header[5];
      this.q = new byte[length];

      for(i = 0; i < length; ++i) {
         this.q[i] = metadataFile[pos];
         ++pos;
      }

      length = header[6];
      this.m = new short[length];

      for(i = 0; i < length; ++i) {
         short[] var10000;
         int var10001;
         int var10002;
         if (metadataFile[pos] >= 0) {
            var10000 = this.m;
            var10001 = i;
            var10002 = metadataFile[pos];
         } else {
            var10000 = this.m;
            var10001 = i;
            var10002 = 256 + metadataFile[pos];
         }

         var10000[var10001] = (short)(var10002 * 2);
         ++pos;
      }

      length = header[7];
      this.r = new byte[length];

      for(i = 0; i < length; ++i) {
         this.r[i] = metadataFile[pos];
         ++pos;
      }

      length = header[8];
      this.s = new byte[length];

      for(i = 0; i < length; ++i) {
         this.s[i] = metadataFile[pos];
         ++pos;
      }

      length = header[9];
      this.t = new byte[length];

      for(i = 0; i < length; ++i) {
         this.t[i] = metadataFile[pos];
         ++pos;
      }

      length = header[10];
      this.u = new byte[length];

      for(i = 0; i < length; ++i) {
         this.u[i] = metadataFile[pos];
         ++pos;
      }

      length = header[11];
      this.a = new byte[length];

      for(i = 0; i < length; ++i) {
         this.a[i] = metadataFile[pos];
         ++pos;
      }

   }

   public static int abs(int var0) {
      return var0 > 0 ? var0 : -var0;
   }

   public void loadMap() {
      boolean var3 = false;
      int selectedMapFileIdx = this.selectedMap == 0 ? 1 : this.selectedMap;
      byte[] mapFile = this.readBinary(this.mapFiles[selectedMapFileIdx - 1] + this.dataExt);
      short headerNumberA = readShort((byte[])mapFile, 0);
      short headerNumberB = readShort((byte[])mapFile, 2);
      short headerNumberC = readShort((byte[])mapFile, 4);
      this.loadedMap = new byte[6][];
      int lump0Size = headerNumberA * 4;
      this.loadedMap[0] = new byte[lump0Size];
      int pos = 6;
      int i;

      for (i = 0; i < lump0Size; i += 4) {
         byte highNibble1 = (byte) ((mapFile[pos + 1] & 0xF0) >> 4);
         byte lowNibble1 = (byte) (mapFile[pos + 1] & 0x0F);

         byte highNibble2 = (byte) ((mapFile[pos] & 0xF0) >> 4);
         byte lowNibble2 = (byte) (mapFile[pos] & 0x0F);

         loadedMap[0][i] = highNibble1;
         loadedMap[0][i + 1] = lowNibble1;
         loadedMap[0][i + 2] = highNibble2;
         loadedMap[0][i + 3] = lowNibble2;

         pos += 2;
      }

      // this.lumpsSizes = {5, 72, 10, 8}
      this.loadedMap[1] = new byte[this.lumpsSizes[0]];
      this.unusedMapRawLump1 = new short[5];
      byte size = this.lumpsSizes[0]; // 5

      for(i = 0; i < size; ++i) {
         short rawValue = readShort(mapFile, pos);
         this.unusedMapRawLump1[i] = rawValue;
         int value;
         if (rawValue >= 128) {
            value = 127 - rawValue;
         } else {
            value = rawValue;
         }
         this.loadedMap[1][i] = (byte)value;
         pos += 2;
      }

      this.loadedMap[2] = new byte[headerNumberB];

      for(i = 0; i < headerNumberB; ++i) {
         this.loadedMap[2][i] = mapFile[pos];
         ++pos;
      }

      size = this.lumpsSizes[1]; // 72
      this.loadedMap[3] = new byte[size];

      for(i = 0; i < size; ++i) {
         this.loadedMap[3][i] = mapFile[pos];
         ++pos;
      }

      this.loadedMap[4] = new byte[headerNumberC];

      for(i = 0; i < headerNumberC; ++i) {
         this.loadedMap[4][i] = mapFile[pos];
         ++pos;
      }

      size = this.lumpsSizes[2]; // 10
      this.loadedMap[5] = new byte[size];

      for(i = 0; i < size; ++i) {
         this.loadedMap[5][i] = mapFile[pos];
         ++pos;
      }

      short[] footer = new short[size = this.lumpsSizes[3]]; // 8

      for(i = 0; i < size; ++i) {
         footer[i] = readShort(mapFile, pos);
         pos += 2;
      }

      this.loadMapInner(footer);
      // this.q = null;
      // this.E = (byte[][][][])null;
      // this.M = null;
      // System.gc();
   }

   public void loadMapInner(short[] footer) {
      this.FOOTER = footer;
      this.E = new byte[3][][][];
      this.loadMapPart((byte[])this.loadedMap[0], (byte[])this.loadedMap[1], (byte[])this.o, 0);
      this.loadMapPart((byte[])this.loadedMap[2], (byte[])this.loadedMap[3], (byte[])this.p, 1);
      this.modifyBigLumps01(this.E[0], this.E[1]);
      this.modifyBigLump1(this.E[1]);
      if (!this.gB) {
         this.loadMapPart((byte[])this.loadedMap[4], (byte[])this.loadedMap[5], (byte[])this.n, 2);
         this.readFoePart1(this.E[2]);
         // E[2][0] - palettes ?
         this.readFoePart2(this.E[2]);
         this.loadSprites(this.E[2]);
      }

      // this.loadedMap = (byte[][])null;
      // this.E[2] = (byte[][][])null;
      // this.c(false);
      // System.gc();
      this.initFloorCeilingColor(footer);
      this.loadTextures(this.E[0], this.E[1], footer);
      // this.gf = false;
      // this.M();
      if (this.selectedMap == 9) {
         // this.b();
      }

      // this.eg = 0;
      // this.ee = false;
      // this.ef = 0;
   }



   public void loadMapPart(byte[] lumpA, byte[] lumpB, byte[] mapMetadata, int E_idx) {
      int pos = 0;
      int lumpBSize = lumpB.length;
      this.E[E_idx] = new byte[lumpBSize][][];

      for(int i = 0; i < lumpBSize; ++i) {
         int lumpFragmentSize = lumpB[i] < 0 ? 127 - lumpB[i] : lumpB[i];
         this.E[E_idx][i] = new byte[lumpFragmentSize][mapMetadata[i]];

         for(int j = 0; j < lumpFragmentSize; ++j) {
            byte var11 = mapMetadata[i];

            for(int k = 0; k < var11; ++k) {
               this.E[E_idx][i][j][k] = lumpA[pos];
               ++pos;
            }
         }
      }
   }

   public void initMapArrays(int var1) {
      this.cW = new int[4][var1];
      this.by = new byte[var1];
   }

   public void modifyBigLumps01(byte[][][] bigLump0, byte[][][] bigLump1) {
      boolean var3 = false;
      int lineSeqIdx = 0;
      int lineIdx = 0;
      int totalNumberOfLines = bigLump0[0].length + bigLump1[7].length + bigLump1[12].length * 4 + bigLump1[20].length * 3 + bigLump1[33].length * 4 + bigLump1[41].length * 4;

      int length = bigLump1[51].length + 1;
      this.bi = new int[length];
      this.bi[0] = totalNumberOfLines;

      int i;
      for(i = 1; i < length; ++i) {
         this.bi[i] = this.bi[i - 1] + bigLump1[51][i - 1][2];
      }

      totalNumberOfLines = this.bi[i - 1];
      this.initMapArrays(totalNumberOfLines);
      this.bz = new byte[totalNumberOfLines];
      length = bigLump1[31].length;

      for(i = 0; i < length; ++i) {
         this.bz[bigLump1[31][i][0] + 128] = bigLump1[31][i][1];
      }

      length = bigLump0[0].length;
      int var8 = bigLump1[7].length;

      for(i = 0; i < length; ++i) {
         if (lineSeqIdx < var8 && lineIdx == bigLump1[7][lineSeqIdx][0] + 128) {
            if (lineSeqIdx != 0) {
               this.cW[2][lineIdx - 1] = bigLump1[7][lineSeqIdx - 1][1];
               this.cW[3][lineIdx - 1] = bigLump1[7][lineSeqIdx - 1][2];
            }

            this.cW[0][lineIdx] = bigLump1[7][lineSeqIdx][1];
            this.cW[1][lineIdx] = bigLump1[7][lineSeqIdx][2];
            ++lineSeqIdx;
            ++lineIdx;
         }

         long var13 = (long)(bigLump0[0][i][0] - 7);
         long var15 = (long)(bigLump0[0][i][1] - 7);
         this.cW[0][lineIdx] = (int)(var13 + (long)this.cW[0][lineIdx - 1]);
         this.cW[1][lineIdx] = (int)(var15 + (long)this.cW[1][lineIdx - 1]);
         this.cW[2][lineIdx - 1] = this.cW[0][lineIdx];
         this.cW[3][lineIdx - 1] = this.cW[1][lineIdx];
         ++lineIdx;
      }

      this.cW[2][lineIdx - 1] = bigLump1[7][lineSeqIdx - 1][1];
      this.cW[3][lineIdx - 1] = bigLump1[7][lineSeqIdx - 1][2];

      for(int var18 = 0; var18 < lineIdx; ++var18) {
         for(i = 0; i < 4; ++i) {
            int[] var10000 = this.cW[i];
            var10000[var18] <<= 16;
         }
      }

      this.eX = lineIdx;
      lineIdx = 0;
      lineSeqIdx = 0;
      this.cX = new byte[totalNumberOfLines];
      length = bigLump0[1].length;
      int var9 = bigLump1[7].length;
      int var10 = bigLump1[10].length;

      int var5;
      int var6;
      for(i = 0; i < length; ++i) {
         var8 = bigLump0[1][i].length;

         label159:
         for(var5 = 0; var5 < var8; ++var5) {
            if (lineSeqIdx < var9 && lineIdx == bigLump1[7][lineSeqIdx][0] + 128) {
               if (lineSeqIdx != 0) {
                  this.cX[lineIdx - 1] = bigLump1[7][lineSeqIdx - 1][4];
               }

               this.cX[lineIdx] = bigLump1[7][lineSeqIdx][3];
               ++lineSeqIdx;
               ++lineIdx;
            }

            int var10001;
            byte[] var10002;
            byte[] var19;
            int var10003;
            if (bigLump0[1][i][var5] == 15) {
               var6 = 0;

               while(true) {
                  if (var6 >= var10) {
                     continue label159;
                  }

                  if (bigLump1[10][var6][0] + 128 == lineIdx) {
                     var19 = this.cX;
                     var10001 = lineIdx;
                     var10002 = bigLump1[10][var6];
                     var10003 = 1;
                     break;
                  }

                  ++var6;
               }
            } else {
               var19 = this.cX;
               var10001 = lineIdx;
               var10002 = bigLump0[1][i];
               var10003 = var5;
            }

            var19[var10001] = var10002[var10003];
            ++lineIdx;
         }
      }

      this.cX[lineIdx - 1 - bigLump1[8][0][4]] = bigLump1[7][lineSeqIdx - 1][4];
      length = bigLump0[2].length;
      var8 = bigLump1[29].length;

      for(i = 0; i < length; ++i) {
         for(var5 = 0; var5 < 5; ++var5) {
            if (bigLump0[2][i][var5] != 15) {
               if (bigLump0[2][i][var5] == 7) {
                  bigLump0[2][i][var5] = -7;
               } else if (bigLump0[2][i][var5] != 0) {
                  bigLump0[2][i][var5] = (byte)(bigLump0[2][i][var5] - 7);
               }
            } else {
               for(var6 = 0; var6 < var8; ++var6) {
                  if (bigLump1[29][var6][0] == i && bigLump1[29][var6][1] == var5) {
                     bigLump0[2][i][var5] = bigLump1[29][var6][2];
                     break;
                  }
               }
            }
         }
      }

      for(i = 0; i < length; ++i) {
         var8 = bigLump0[2][i].length;

         for(var5 = 6; var5 < var8; ++var5) {
            bigLump0[2][i][var5] = (byte)(bigLump0[2][i][var5] * 3);
         }
      }

      length = bigLump0[3].length;

      for(i = 0; i < length; ++i) {
         for(var5 = 1; var5 <= 2; ++var5) {
            bigLump0[3][i][var5] = (byte)(bigLump0[3][i][var5] * 3);
         }
      }

      length = bigLump0[4].length;

      for(i = 0; i < length; ++i) {
         var8 = bigLump0[4][i].length;

         for(var5 = 0; var5 < var8; ++var5) {
            bigLump0[4][i][var5] = (byte)(bigLump0[4][i][var5] * 3);
         }
      }

   }





   public void modifyBigLump1(byte[][][] bigLump1) {
      this.cD = new short[7][];
      this.cE = new short[7][];
      this.fa = this.eX;
      this.fb = this.fa + 4 * bigLump1[12].length;
      this.fc = this.fb + 3 * bigLump1[20].length;

      int var2;
      int var3;
      int var6;
      int var10;
      int var12;
      int var14;
      int var10001;
      int var10002;
      for(var2 = 0; var2 < 7; ++var2) {
         var12 = bigLump1[var2].length + bigLump1[var2 + 13].length + bigLump1[var2 + 21].length + bigLump1[var2 + 42].length + bigLump1[var2 + 52].length;
         this.cD[var2] = new short[var12];
         this.cE[var2] = new short[var12];
         var10 = bigLump1[var2].length;

         for(var3 = 0; var3 < var10; ++var3) {
            this.cD[var2][var3] = (short)(bigLump1[var2][var3][0] + 128);
            this.cE[var2][var3] = (short)(bigLump1[var2][var3][1] + 128);
         }

         var10 = bigLump1[var2 + 13].length + var3;

         byte var13;
         short[] var10000;
         for(var6 = var3; var6 < var10; ++var6) {
            var13 = bigLump1[var2 + 13][var6 - var3][0];
            this.cD[var2][var6] = (short)(this.fa + var13 * 4);
            this.cE[var2][var6] = (short)(this.cD[var2][var6] + 3);
            if (abs(var14 = bigLump1[12][var13][3] % 90) <= 3) {
               var10000 = this.cE[var2];
               var10001 = var6;
               var10002 = var10000[var6] - abs(var14);
            } else {
               if (abs(var14) > 6) {
                  continue;
               }

               var10000 = this.cD[var2];
               var10001 = var6;
               var10002 = var10000[var6] + (abs(var14) - 3);
            }

            var10000[var10001] = (short)var10002;
            bigLump1[12][var13][3] = (byte)(bigLump1[12][var13][3] - var14);
         }

         var10 = bigLump1[var2 + 21].length + var6;

         int var7;
         for(var7 = var6; var7 < var10; ++var7) {
            this.cD[var2][var7] = (short)(this.fb + abs(bigLump1[var2 + 21][var7 - var6][0]) % 60 * 3);
            this.cE[var2][var7] = (short)(this.cD[var2][var7] + 2);
            if (bigLump1[var2 + 21][var7 - var6][0] < 0) {
               var10000 = this.cD[var2];
               var10001 = var7;
               var10002 = var10000[var7] + 2;
            } else {
               if (bigLump1[var2 + 21][var7 - var6][0] < 60) {
                  continue;
               }

               var10000 = this.cE[var2];
               var10001 = var7;
               var10002 = var10000[var7] - 2;
            }

            var10000[var10001] = (short)var10002;
         }

         var10 = bigLump1[var2 + 42].length + var7;

         int var8;
         for(var8 = var7; var8 < var10; ++var8) {
            var13 = bigLump1[var2 + 42][var8 - var7][0];
            this.cD[var2][var8] = (short)(this.fc + var13 * 4);
            this.cE[var2][var8] = (short)(this.cD[var2][var8] + 3);
            if (abs(var14 = bigLump1[41][var13][2] % 90) <= 3) {
               var10000 = this.cE[var2];
               var10001 = var8;
               var10002 = var10000[var8] - abs(var14);
            } else {
               if (abs(var14) > 6) {
                  continue;
               }

               var10000 = this.cD[var2];
               var10001 = var8;
               var10002 = var10000[var8] + (abs(var14) - 3);
            }

            var10000[var10001] = (short)var10002;
            bigLump1[41][var13][2] = (byte)(bigLump1[41][var13][2] - var14);
         }

         var10 = bigLump1[var2 + 52].length + var8;

         for(int var9 = var8; var9 < var10; ++var9) {
            this.cD[var2][var9] = (short)this.bi[bigLump1[var2 + 52][var9 - var8][0]];
            this.cE[var2][var9] = (short)(this.bi[bigLump1[var2 + 52][var9 - var8][0] + 1] - 1);
         }
      }

      this.fillTheseFields(bigLump1[8][0][0], (long)bigLump1[8][0][1] * 75000L, (long)bigLump1[8][0][2] * 75000L, bigLump1[8][0][3] * 2, bigLump1[8][0][7]);
      this.cC = (byte)(16 + bigLump1[8][0][5]);
      this.cB = bigLump1[8][0][6];
      var12 = this.eX;
      this.eY = bigLump1[12].length; // number of crates
      int var24 = 48 + this.eY;
      this.cg = new byte[var24];
      this.bT = new int[var24][2];
      this.cm = new boolean[var24];
      this.cd = new byte[var24];
      this.ch = new byte[var24];
      var10 = bigLump1[12].length;

      byte[] var26;
      for(var3 = 0; var3 < var10; ++var3) {
         var14 = 128 + bigLump1[12][var3][0] << 16 >> 2;
         int var15 = 128 + bigLump1[12][var3][1] << 16 >> 2;
         var6 = 48 + var3;
         this.bT[var6][0] = var14;
         this.bT[var6][1] = var15;
         this.cg[var6] = (byte)(this.cC - 1);
         this.cm[var6] = false;
         this.cd[var6] = (byte)(this.cC + 2 + bigLump1[12][var3][4]);
         if (bigLump1[12][var3][4] > 3) {
            var26 = this.cd;
            var26[var6] = (byte)(var26[var6] - 4);
            this.ch[var6] = 1;
         }
         CRATES_START_LINE_IDX.add(var12);
         CRATES_CONTENT.add(bigLump1[12][var3][4]);
         CRATES_ANGLE.add(bigLump1[12][var3][3]);
         var12 = this.modifyBigLump1_subfunction1((long)var14, (long)var15, 16384L, 16384L, bigLump1[12][var3][3], var12, bigLump1[12][var3][2], bigLump1[12][var3][2], bigLump1[12][var3][2], bigLump1[12][var3][2], (byte)1, (byte)0);
      }

      this.eZ = bigLump1[20].length;
      this.dp = new int[this.eZ][2];
      this.dr = new byte[this.eZ];
      this.ds = new byte[this.eZ];
      this.dv = new int[this.eZ];
      this.dw = new int[this.eZ];
      this.dt = new byte[this.eZ];
      this.dx = new int[this.eZ];
      this.dy = new int[this.eZ];
      this.dz = new int[this.eZ];
      this.dA = new int[this.eZ];
      this.dq = new int[this.eZ][2];
      this.dB = new int[this.eZ];
      this.du = new byte[this.eZ];
      var10 = bigLump1[20].length;

      for(var3 = 0; var3 < var10; ++var3) {
         this.dp[var3][0] = 128 + bigLump1[20][var3][0] << 16 >> 2;
         this.dp[var3][1] = 128 + bigLump1[20][var3][1] << 16 >> 2;
         byte var28;
         if (bigLump1[20][var3][2] * bigLump1[20][var3][3] >= 0) {
            this.dr[var3] = 0;
            var26 = this.ds;
            var10001 = var3;
            var28 = 1;
         } else {
            this.dr[var3] = 1;
            var26 = this.ds;
            var10001 = var3;
            var28 = 0;
         }

         var26[var10001] = var28;
         this.dv[var3] = (bigLump1[20][var3][2] << 16) / 127;
         this.dw[var3] = (bigLump1[20][var3][3] << 16) / 127;
         this.dt[var3] = bigLump1[59][var3][3];
         this.dz[var3] = 0;
         this.dA[var3] = 6225920;
         int[] var27;
         if (this.dw[var3] > 0) {
            var27 = this.dx;
            var10001 = var3;
            var10002 = 65536;
         } else {
            var27 = this.dx;
            var10001 = var3;
            var10002 = -65536;
         }

         var27[var10001] = var10002;
         this.dy[var3] = (this.dx[var3] - this.dw[var3]) / this.dt[var3];
         this.dq[var3][this.dr[var3]] = this.dp[var3][this.dr[var3]] + this.dx[var3];
         this.dq[var3][this.ds[var3]] = this.dp[var3][this.ds[var3]];
         this.dB[var3] = -1;
         this.du[var3] = bigLump1[28][var3][0];
         byte var10003;
         byte var30;
         byte var31;
         if (!this.gB || var3 != 0 && var3 != 1) {
            var30 = bigLump1[59][var3][0];
            var31 = bigLump1[59][var3][1];
            var10003 = bigLump1[59][var3][2];
         } else {
            var30 = 7;
            var31 = bigLump1[59][var3][1];
            var10003 = 7;
         }

         DOORS_START_LINE_IDX.add(var12);
         this.modifyBigLump1_subfunction2(var30, var31, var10003, var12);
         this.modifyBigLump1_subfunction3(this.dp[var3], (long)this.dv[var3], (long)this.dx[var3], this.dr[var3], this.ds[var3], var12, 0);
         var12 = this.modifyBigLump1_subfunction3(this.dp[var3], (long)this.dv[var3], (long)this.dw[var3], this.dr[var3], this.ds[var3], var12, 1);
      }

      this.eX = var12;
      this.bA = new byte[bigLump1[30].length * 7];
      this.bs = new short[32 + bigLump1[30].length];
      int var5 = 0;
      var10 = bigLump1[30].length;

      int var11;
      for(var3 = 0; var3 < var10; ++var3) {
         this.bs[32 + var3] = 96;
         var11 = bigLump1[30][var3].length;

         for(int var4 = 0; var4 < var11; ++var4) {
            this.bA[var5] = bigLump1[30][var3][var4];
            ++var5;
         }
      }

      var12 = this.eX;
      var10 = bigLump1[41].length;

      long var16;
      long var25;
      for(var3 = 0; var3 < var10; ++var3) {
         var25 = (long)(128 + bigLump1[41][var3][0] << 16 >> 2);
         var16 = (long)(128 + bigLump1[41][var3][1] << 16 >> 2);
         long var18 = (long)((bigLump1[60][var3][0] << 16) / 42 >> 1);
         long var20 = (long)((bigLump1[60][var3][1] << 16) / 42 >> 1);
         var12 = this.modifyBigLump1_subfunction1(var25, var16, var18, var20, bigLump1[41][var3][2], var12, bigLump1[61][var3][0], bigLump1[61][var3][1], bigLump1[61][var3][2], bigLump1[61][var3][3], bigLump1[62][var3][0], bigLump1[62][var3][1]);
      }

      this.eX = var12;
      this.fG = new byte[2][];
      this.fH = new byte[2][];
      this.fE = new short[2][];
      this.modifyBigLump1_subfunction4(0, 49, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(1, 70, (byte[][][])bigLump1);
      var12 = this.eX;
      this.fd = var12;
      var10 = bigLump1[51].length;
      this.bh = new int[var10];

      for(var3 = 0; var3 < var10; ++var3) {
         var25 = (long)(128 + bigLump1[51][var3][0] << 16 >> 2);
         var16 = (long)(128 + bigLump1[51][var3][1] << 16 >> 2);
         long var22 = (long)((bigLump1[51][var3][3] << 16) / 60);
         this.bh[var3] = bigLump1[51][var3][6];
         var12 = this.modifyBigLump1_subfunction5(var25, var16, bigLump1[51][var3][2], var22, var12, bigLump1[51][var3][4], bigLump1[51][var3][5], bigLump1[51][var3][7], bigLump1[51][var3][8]);
      }

      this.eX = var12;
      this.ci = new byte[7][];

      for(var2 = 63; var2 < 70; ++var2) {
         var10 = bigLump1[var2].length;
         var11 = bigLump1[var2 - 50].length;
         this.ci[var2 - 63] = new byte[var10 + var11];

         for(var3 = 0; var3 < var10; ++var3) {
            this.ci[var2 - 63][var3] = bigLump1[var2][var3][0];
         }

         var6 = var3;

         for(var3 = 0; var3 < var11; ++var3) {
            this.ci[var2 - 63][var6] = (byte)(48 + bigLump1[var2 - 50][var3][0]);
            ++var6;
         }
      }

   }

   public void fillTheseFields(int var1, long var2, long var4, int var6, int var7) {
      this.fz = new long[2];
      this.fk = var1;
      this.fz[0] = var2;
      this.fz[1] = var4;
      this.eR = var6;
      this.eS = var7;
   }


   // Crates + something else
   public int modifyBigLump1_subfunction1(long var1, long var3, long var5, long var7, int var9, int var10, byte var11, byte var12, byte var13, byte var14, byte var15, byte var16) {
      int var19 = 0;

      int var18;
      for(var18 = var10; var18 < var10 + 4; ++var18) {
         this.by[var18] = var15;
         if (var16 != 6) {
            this.bz[var18] = var16;
         }

         for(int var17 = 0; var17 < 4; var17 += 2) {
            int[] var10000;
            int var10001;
            long var10002;
            if (var9 == 0) {
               this.cW[var17][var18] = (int)((long)this.B[var19][var17] * var7 + var1);
               var10002 = (long)this.B[var19][var17 + 1] * var5;
            } else {
               this.cW[var17][var18] = (int)(((long)this.B[var19][var17] * var7 * this.sin(var9) >> 16) - ((long)this.B[var19][var17 + 1] * var5 * this.cos(var9) >> 16) + var1);
               var10002 = ((long)this.B[var19][var17] * var7 * this.cos(var9) >> 16) + ((long)this.B[var19][var17 + 1] * var5 * this.sin(var9) >> 16);
            }
            this.cW[var17 + 1][var18] = (int)(var10002 + var3);
         }

         ++var19;
      }

      this.cX[var10] = var11;
      var18 = var10 + 1;
      this.cX[var18] = var12;
      ++var18;
      this.cX[var18] = var13;
      ++var18;
      this.cX[var18] = var14;
      if (var16 == 6) {
         this.bz[var18] = 3;
      }

      return var18 + 1;
   }

   public void modifyBigLump1_subfunction2(byte var1, byte var2, byte var3, int var4) {
      this.cX[var4] = var1;
      int var5 = var4 + 1;
      this.cX[var5] = var2;
      ++var5;
      this.cX[var5] = var3;
      this.bz[var5] = 3;
   }


   // Doors
   public int modifyBigLump1_subfunction3(int[] var1, long var2, long var4, int var6, int var7, int var8, int var9) {
      if (var9 == 0) {
         this.cW[var6][var8] = var1[var6];
         this.cW[var7][var8] = (int)((long)var1[var7] - (var2 >> 1));
         this.cW[var6 + 2][var8] = (int)((long)var1[var6] + var4);
         this.cW[var7 + 2][var8] = (int)((long)var1[var7] - (var2 >> 1));
      }

      int var10 = var8 + 1;
      this.cW[var6][var10] = this.cW[var6 + 2][var10 - 1];
      this.cW[var7][var10] = this.cW[var7 + 2][var10 - 1];
      this.cW[var6 + 2][var10] = this.cW[var6][var10];
      this.cW[var7 + 2][var10] = (int)((long)this.cW[var7][var10 - 1] + var2);
      ++var10;
      if (var9 == 0) {
         this.cW[var6][var10] = this.cW[var6 + 2][var10 - 1];
         this.cW[var7][var10] = this.cW[var7 + 2][var10 - 1];
         this.cW[var6 + 2][var10] = (int)((long)this.cW[var6][var10] - var4);
         this.cW[var7 + 2][var10] = this.cW[var7][var10];
      }

      return var10 + 1;
   }


   public void modifyBigLump1_subfunction4(int var1, int var2, byte[][][] var3) {
      int var4 = var2;
      if (var3[var2].length != 0) {
         int var7 = var3[var2][0].length;
         this.fG[var1] = new byte[var7];

         for(int var6 = 0; var6 < var7; ++var6) {
            this.fG[var1][var6] = var3[var4][0][var6];
         }

         ResourcesLoaderB3D var10000;
         byte var10001;
         if (this.fG[var1][1] != this.fG[var1][2]) {
            var10000 = this;
            var10001 = 2;
         } else {
            var10000 = this;
            var10001 = 1;
         }

         var10000.ff = var10001;
         int var8 = this.fG[var1][0] < 10 ? 128 : 299;
         var4 = var2 + 1;
         this.fE[var1] = new short[var3[var4].length];
         this.fH[var1] = new byte[var3[var4].length];
         var7 = var3[var4].length;

         for(int var5 = 0; var5 < var7; ++var5) {
            this.fE[var1][var5] = (short)(var3[var4][var5][0] + var8);
            this.fH[var1][var5] = 0;
         }

      }
   }


   public int modifyBigLump1_subfunction5(long var1, long var3, int var5, long var6, int var8, int var9, byte var10, byte var11, int var12) {
      int var15 = 360 / var5;
      int var14 = var12 * 4;
      ArrayList<Integer> indexes = new ArrayList<>();

      int var13;
      for(var13 = var8; var13 < var8 + var5; ++var13) {
         indexes.add(var13);
         this.cW[0][var13] = (int)((var6 * this.cos(var14) >> 16) + var1);
         this.cW[1][var13] = (int)((var6 * this.sin(var14) >> 16) + var3);
         var14 -= var15;
         this.cW[2][var13] = (int)((var6 * this.cos(var14) >> 16) + var1);
         this.cW[3][var13] = (int)((var6 * this.sin(var14) >> 16) + var3);
         this.by[var13] = var10;
         this.cX[var13] = (byte)var9;
         this.bz[var13] = var11;
      }
      this.CIRCLES_IDX.add(indexes);

      return var13;
   }

   public long cos(int var1) {
      if (var1 < 0) {
         return -this.cos(-var1);
      } else if (var1 >= 90 & var1 < 180) {
         return (long)this.cosTable[180 - var1];
      } else if (var1 >= 180 & var1 < 270) {
         return (long)(-this.cosTable[var1 - 180]);
      } else if (var1 >= 270 & var1 < 360) {
         return (long)(-this.cosTable[90 - (var1 - 270)]);
      } else {
         return var1 >= 360 ? this.cos(var1 % 360) : (long)this.cosTable[var1];
      }
   }

   public long sin(int var1) {
      return this.cos(90 - var1);
   }







   public void readFoePart1(byte[][][] bigLump2) {
      int length = bigLump2[4].length;
      this.bZ = new byte[length];
      this.bW = new short[length];
      this.ca = new byte[32];
      this.bX = new short[length];
      this.cb = new byte[length];
      this.cj = new boolean[length];
      this.cc = new byte[length];
      this.cl = new boolean[48 + this.eY];
      this.ce = new byte[length];
      this.ck = new boolean[length];
      this.cf = new byte[length];
      this.z = new byte[length];
      this.ei = new int[length];

      int i;
      for(i = 0; i < length; ++i) {
         byte[] var10000;
         int var10001;
         byte var10002;
         if (bigLump2[4][i][2] == -1) {
            var10000 = this.cg;
            var10001 = i;
            var10002 = 10;
         } else {
            var10000 = this.cg;
            var10001 = i;
            var10002 = 0;
         }

         var10000[var10001] = var10002;
         this.bT[i][0] = 128 + bigLump2[4][i][0] << 16 >> 2;
         this.bT[i][1] = 128 + bigLump2[4][i][1] << 16 >> 2;
         this.ei[i] = -1;
         this.bZ[i] = bigLump2[4][i][2];
         this.bW[i] = (short)(bigLump2[4][i][3] * 2);
         this.ca[i] = bigLump2[4][i][4];
         this.bX[i] = (short)(bigLump2[4][i][5] + 128);
         this.cj[i] = true;
         this.cc[i] = 1;
         this.cb[i] = 1;
         this.cl[i] = false;
         this.cm[i] = true;
         this.ch[i] = bigLump2[4][i][6];
         this.cf[i] = bigLump2[4][i][7];
         this.ck[i] = false;
         byte var6;
         if (this.ca[i] <= 0) {
            var10000 = this.z;
            var10001 = i;
            var6 = (byte)(abs(this.F()) & 1);
         } else {
            var10000 = this.z;
            var10001 = i;
            var6 = 0;
         }

         var10000[var10001] = var6;
         if (this.ca[i] > 0 && (this.ca[i] != 32 || this.selectedMap != 9)) {
            var10000 = this.ce;
            var10001 = i;
            var10002 = 0;
         } else {
            var10000 = this.ce;
            var10001 = i;
            var10002 = 100;
         }

         var10000[var10001] = var10002;
      }

      this.eP = bigLump2[4].length;
      this.fl = bigLump2[8][0][0];
      this.fm = bigLump2[8][0][1];
      this.fn = bigLump2[8][0][2];
      this.fp = bigLump2[8][0][3];
      this.fo = bigLump2[8][0][4];
      this.eQ = bigLump2[7].length;
      int var3 = 16;
      int var4 = bigLump2[7].length;

      for(i = 0; i < var4; ++i) { // lamps
         this.cg[var3] = this.fl;
         this.bT[var3][0] = 128 + bigLump2[7][i][0] << 16 >> 2;
         this.bT[var3][1] = 128 + bigLump2[7][i][1] << 16 >> 2;
         this.ca[var3] = bigLump2[7][i][2];
         this.cm[var3] = true;
         this.ch[var3] = bigLump2[7][i][3];
         ++var3;
      }

      var3 = 32;
      var4 = bigLump2[9].length;

      for(i = 0; i < var4; ++i) { // decorations
         this.cg[var3] = bigLump2[9][i][0];
         this.bT[var3][0] = 128 + bigLump2[9][i][1] << 16 >> 2;
         this.bT[var3][1] = 128 + bigLump2[9][i][2] << 16 >> 2;
         this.cm[var3] = true;
         ++var3;
      }

   }

   public int F() {
      return this.dR.nextInt();
   }



   public void readFoePart2(byte[][][] var1) {
      BufferedImage layer1 = null;
      BufferedImage layer2 = null;
      layer1 = this.readImage("/e" + this.dataExt);
      layer2 = this.readImage("/ee" + this.dataExt);
      int[] tmp = new int[1];
      layer1.getRGB(0, 0, 1, 1, tmp, 0, 1);
      this.backgroundColor = tmp[0];
      this.bq = new short[6][];
      this.M = new int[this.bq.length];
      int length = this.bq.length;
      int var3 = (16 + var1[5].length + 2) * 2;

      int offset;
      for(offset = 0; offset < length; ++offset) {
         this.bq[offset] = new short[var3];
         this.M[offset] = 16 + var1[5].length + 2;
         int var4 = this.bq[offset].length;

         for(int var11 = 0; var11 < var4; ++var11) {
            this.bq[offset][var11] = 0;
         }
      }

      int totalSegments = 16 + var1[5].length;
      this.bY = new short[totalSegments];
      this.bt = new short[totalSegments];
      this.bu = new short[totalSegments];
      this.bj = new int[totalSegments];
      this.foeW = new short[totalSegments];
      this.foeH = new short[totalSegments];
      int segNum = 0;
      length = this.FOE_METADATA.length;

      for(offset = 0; offset < length; offset += 7) {
         this.readFoeSubfunction1(this.FOE_METADATA, segNum, offset);
         this.bY[segNum] = this.FOE_METADATA[offset + 6];
         ++segNum;
      }

      segNum = 16;
      length = var1[5].length;

      for(int var12 = 0; var12 < length; ++var12) {
         if ((offset = (var1[5][var12][0] >= 50 ? var1[5][var12][0] - 50 : var1[5][var12][0]) * 7) / 7 >= 8) {
            short[] var10000 = this.l;
            var10000[offset] = (short)(var10000[offset] << 1);
            var10000 = this.l;
            var10000[offset + 1] = (short)(var10000[offset + 1] << 1);
            var10000 = this.l;
            var10000[offset + 2] = (short)(var10000[offset + 2] << 1);
            var10000 = this.l;
            var10000[offset + 3] = (short)(var10000[offset + 3] << 1);
         }

         this.readFoeSubfunction1(this.l, segNum, offset);
         this.bY[segNum] = this.l[offset + 6];
         ++segNum;
      }

      int var16 = this.bq[0][this.M[0]] + 10;
      int var17 = this.bq[1][this.M[1]] + 10;
      int var18 = this.bq[2][this.M[2]] + 10;
      int var19 = this.bq[3][this.M[3]] + 10;
      int var20 = this.bq[4][this.M[4]] + 10;
      this.readFoeSubfunction2(var16, var17, var1[1].length, var18, var19, var20);
      // segNum = 0;
      // short var21 = 0;
      // length = this.FOE_METADATA.length;

      // for(offset = 0; offset < length; offset += 7) {
      //    int[] layer1Cut = new int[this.FOE_METADATA[offset + 2] * this.FOE_METADATA[offset + 3]];
      //    int[] layer2Cut = new int[this.FOE_METADATA[offset + 2] * this.FOE_METADATA[offset + 3]];
      //    layer1.getRGB(layer1Cut, 0, this.FOE_METADATA[offset + 2], this.FOE_METADATA[offset + 0], this.FOE_METADATA[offset + 1], this.FOE_METADATA[offset + 2], this.FOE_METADATA[offset + 3]);
      //    layer2.getRGB(layer2Cut, 0, this.FOE_METADATA[offset + 2], this.FOE_METADATA[offset + 0], this.FOE_METADATA[offset + 1], this.FOE_METADATA[offset + 2], this.FOE_METADATA[offset + 3]);
      //    this.combineLayers(layer1Cut, layer2Cut, this.bp, var21, var1[0][0], var1[0][1]);
      //    var21 = (short)(var21 + 50);
      //    int var15 = this.foeH[segNum] / this.bu[segNum];
      //    if (this.bt[segNum] == 0) {
      //       this.b(segNum, var15, layer1Cut);
      //    } else if (this.bt[segNum] == 1) {
      //       this.a(segNum, var15, layer1Cut);
      //    }

      //    ++segNum;
      // }

   }

   public void readFoeSubfunction1(short[] foeMData, int segNum, int offset) {
      this.foeW[segNum] = foeMData[offset + 2];
      this.foeH[segNum] = foeMData[offset + 3];
      int var4 = this.foeH[segNum] / foeMData[offset + 5];
      this.bq[foeMData[offset + 4]][segNum] = this.bq[foeMData[offset + 4]][this.M[foeMData[offset + 4]]];
      this.bq[foeMData[offset + 4]][this.M[foeMData[offset + 4]] + 1] = (short)(this.bq[foeMData[offset + 4]][this.M[foeMData[offset + 4]]] + this.foeW[segNum] * var4);
      int var10002 = this.M[foeMData[offset + 4]]++;
      this.bt[segNum] = foeMData[offset + 4];
      this.bu[segNum] = foeMData[offset + 5];
      this.bj[segNum] = (foeMData[offset + 5] << 16 >> 3) * this.foeW[segNum] / this.foeH[segNum];
      int[] var10000 = this.bj;
      var10000[segNum] >>= 1;
   }


   public void readFoeSubfunction2(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.bp = new int[2][(16 + var3) * 50];
      this.bm = new int[50];
      this.cY = new byte[var1];
      this.cZ = new byte[var1];
      this.da = new byte[var1];
      this.db = new byte[var1];
      this.dc = new byte[var1];
      this.dd = new byte[var1];
      this.de = new byte[var2];
      this.df = new byte[var2];
      this.dg = new byte[var4];
      this.dh = new byte[var4];
      this.di = new byte[var5];
      this.dj = new byte[var5];
      this.dk = new byte[var5];
      this.dl = new byte[var5];
      this.dm = new byte[var6];
      this.dn = new byte[var6];
   }












   public void loadTextures_subfunction1(int[] var1, byte[][][] var2, byte[][][] var3, int var4) {
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

   public void loadTextures_subfunction2(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
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


   public void loadTextures_subfunction3(byte[][][] var1, byte[][][] var2, int var3, int var4, int var5, int var6, int var7) {
      byte var8 = var2[9][var3][0];
      byte var9 = var1[2][var3][5];
      byte var10 = this.q[6 * var8];
      BufferedImage var11;
      if (this.P != var3 && var5 != var6) {
         if (var4 == 0) {
            if (var9 != 12) {
               this.C = this.readImage("/" + String.valueOf(var10) + this.dataExt);
            } else {
               var11 = this.readImage("/" + String.valueOf(var10) + this.dataExt);
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
               this.C = transformedImage; // assign the transformed image to C
            }
         } else {
            this.D = this.readImage("/" + String.valueOf(var10) + this.dataExt);
         }
      }

      if (this.P != var3) {
         BufferedImage var10000;
         int[] var10001;
         if (var4 == 0) {
            var10000 = this.C;
            var10001 = this.I;
         } else {
            this.G = new int[this.K * this.L];
            var10000 = this.D;
            var10001 = this.G;
         }

         var10000.getRGB((int)var1[4][var3][0], (int)var1[4][var3][1], this.K, this.L, var10001, 0, this.K);

         if (!this.gB) {
            if (var4 != 0) {
               var10001 = this.G;
            } else {
               var10001 = this.I;
            }

            this.loadTextures_subfunction1(var10001, var1, var2, var3);
         }

         if (this.q[6 * var2[9][var3][0] + 5] == 2) {
            var11 = this.readImage("/" + String.valueOf(var10) + var10 + this.dataExt);
            int[] var14 = new int[9216];
            var11.getRGB(0, 0, 96, 96, var14, 0, 96);
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



   public void loadTextures_subfunction4(int[] var1, int var2, int var3, int var4, byte var5, int var6, int var7) {
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



   public int loadTextures_subfunction5(byte var1, byte var2, byte var3, byte var4, byte var5, short var6, int var7, short var8, byte var9) {
      this.bk[var3] = var7;
      int var10 = this.loadTextures_subfunction6((byte)0, var1, (short)var8, var7);
      var10 = this.loadTextures_subfunction6(var9, var2, (short)0, var10);
      var10 = this.loadTextures_subfunction6((byte)(var9 + var5), var1, (short)((byte)(var4 + var5)), var10);
      this.bk[var3 + 1] = var10;
      this.bs[var3] = var6;
      return var10;
   }


    public int loadTextures_subfunction6(byte var1, byte var2, short var3, int var4) {
      this.br[var4] = (short)var1;
      int var5 = var4 + 1;
      this.br[var5] = (short)var2;
      ++var5;
      this.br[var5] = var3;
      ++var5;
      return var5;
   }



   public static void loadTextures_subfunction7(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int[] var8, boolean var9) {
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




   public void loadTextures_subfunction8(int[] var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
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


   public void loadTextures_subfunction9(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
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



   public void loadTextures_subfunction11(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
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

   public void loadTextures_subfunction12(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
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



   public void loadTextures_subfunction13(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
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


   public int loadTextures_subfunction16(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
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

   public static int clampValue(int value, int maxValue) {
      if (value > maxValue) {
          return maxValue;
      } else {
          return value < 0? 0 : value;
      }
   }





   public void loadTextures(byte[][][] bigLump0, byte[][][] bigLump1, short[] footer) {
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
         BufferedImage layer1 = this.readImage("/" + String.valueOf(i) + this.dataExt);
         BufferedImage layer2 = null;
         if (i == 0) {
            layer2 = this.readImage("/" + String.valueOf(i) + i + this.dataExt);
            int[] tmp = new int[1];
            layer1.getRGB(0, 0, 1, 1, tmp, 0, 1);
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
                  layer1.getRGB(var27, var28, var22, var23, this.N[var20], 0, var22);
                  BufferedImage var10000;
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

                  var10000.getRGB(var10004, var10005, var10006, var10007, var10001, var10002, var10003);
               }

               if (!this.gB) {
                  this.loadTextures_subfunction1(this.N[var20], bigLump0, bigLump1, j);
               }

               if (this.q[6 * bigLump1[9][j][0] + 5] == 2) {
                  int[] var37 = new int[var22 * var23];
                  layer2.getRGB(var27, var28, var22, var23, var37, 0, var22);
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

               if (this.q[6 * bigLump1[9][var6][0]] > 1) {
                  this.loadTextures_subfunction3((byte[][][])bigLump0, (byte[][][])bigLump1, var6, j, -1, -2, -1);
                  var10001 = this.G;
               } else {
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
            this.TEXTURES_W.add(var15);
            this.TEXTURES_H.add(var16);
            this.TEXTURES_DATA.add(this.I);
         }
      }

      // this.G = null;
      // this.H = null;
      // this.I = null;
      // this.N = (int[][])null;
      // this.O = null;
      // this.C = null;
      // this.D = null;
      // System.gc();
   }




   public void d(int var1, int var2) {
      this.cI = new int[var1];
      this.cJ = new int[var1];
      this.cK = new int[var1];
      this.cL = new int[var1];
      this.cM = new int[var2];
      this.cN = new int[var2];
      this.cO = new int[var2];
      this.cP = new int[var2];
   }



   public void initFloorCeilingColor(short[] var1) {
      int var10001;
      if (!this.gB) {
         this.aV = var1[0] << 16 | var1[1] << 8 | var1[2];
         var10001 = var1[3] << 16 | var1[4] << 8 | var1[5];
      } else {
         this.aV = 4210752;
         var10001 = 6316128;
      }

      this.aW = var10001;
      this.aV = (int)((long)this.aV | 0L);
      this.aW = (int)((long)this.aW | 0L);
   }




   public void loadSprites(byte[][][] var1) {
      int[][] var8 = new int[var1[5].length][];
      int[][] var9 = new int[var1[5].length][];
      boolean var2 = false;
      int var7 = var1[5].length;
      this.SPRITES_W = new short[var7];
      this.SPRITES_H = new short[var7];

      int var4;
      for(int spriteFileNum = 0; spriteFileNum <= 1; ++spriteFileNum) {
         BufferedImage backLayer = this.readImage(this.spriteFiles[spriteFileNum] + this.dataExt);
         BufferedImage frontLayer = this.readImage(this.spriteFiles[spriteFileNum + 2] + this.dataExt);

         for(var4 = 0; var4 < var7; ++var4) {
            // System.out.println("" + spriteFileNum + ": " + var1[5][var4][0]);
            if (spriteFileNum == 0) {
               if (var1[5][var4][0] >= 50) {
                  continue;
               }
            } else {
               if (var1[5][var4][0] < 50) {
                  continue;
               }

               var1[5][var4][0] = (byte)(var1[5][var4][0] - 50);
            }

            int var3 = var1[5][var4][0] * 7;
            var8[var4] = new int[this.l[var3 + 2] * this.l[var3 + 3]];
            var9[var4] = new int[this.l[var3 + 2] * this.l[var3 + 3]];
            this.SPRITES_W[var4] = this.l[var3 + 2];
            this.SPRITES_H[var4] = this.l[var3 + 3];
            backLayer.getRGB(this.l[var3 + 0], this.l[var3 + 1], this.l[var3 + 2], this.l[var3 + 3], var8[var4], 0, this.l[var3 + 2]);
            // System.out.println(var1[5][var4][0]);
            if (var1[5][var4][0] == 26) {
               int var12 = this.l[var3 + 2] * this.l[var3 + 3];

               for(int var13 = 0; var13 < var12; ++var13) {
                  if (var8[var4][var13] != this.backgroundColor) {
                     var8[var4][var13] = 176;
                  }
               }
            } else {
               backLayer.getRGB(this.l[var3 + 0], this.l[var3 + 1], this.l[var3 + 2], this.l[var3 + 3], var8[var4], 0, this.l[var3 + 2]);
            }

            frontLayer.getRGB(this.l[var3 + 0], this.l[var3 + 1], this.l[var3 + 2], this.l[var3 + 3], var9[var4], 0, this.l[var3 + 2]);
         }
      }

      short var15 = 800;
      var7 = var1[5].length;

      for(var4 = 0; var4 < var7; ++var4) {
         int[] layer1Color2 = new int[var8[var4].length];
         this.combineLayers(var8[var4], var9[var4], this.bp, var15, var1[6][var4], var1[1][var4], layer1Color2);
         this.SPRITES_DATA_COLOR_1.add(var8[var4]);
         this.SPRITES_DATA_COLOR_2.add(layer1Color2);
         var15 = (short)(var15 + 50);
      }

      // var7 = 16 + var1[5].length;

      // for(int var14 = 16; var14 < var7; ++var14) {
      //    int var6 = this.foeH[var14] / this.bu[var14];
      //    if (this.bt[var14] == 0) {
      //       this.b(var14, var6, var8[var14 - 16]);
      //    } else if (this.bt[var14] == 1) {
      //       this.a(var14, var6, var8[var14 - 16]);
      //    } else if (this.bt[var14] == 2) {
      //       this.c(var14, var6, var8[var14 - 16]);
      //    } else if (this.bt[var14] == 3) {
      //       this.d(var14, var6, var8[var14 - 16]);
      //    } else if (this.bt[var14] == 4) {
      //       this.e(var14, var6, var8[var14 - 16]);
      //    }
      // }

      // this.F = (byte[][][])null;
      // System.gc();
   }

   private void combineLayers(int[] layer1, int[] layer2, int[][] colorData, short startIndex, byte[] palette1, byte[] palette2, int[] layer1Color2) {
      // boolean isBackground = false;
      // byte colorIndex = 1;
      int layerLength = layer1.length;
      // byte[] colorMap = new byte[256];
      // int[] colorIndices = new int[50];
      // short dataIndex = startIndex;
      // short uniqueColorIndex = 0;

      int i;
      int colorValue;
      int pixel;

      for(i = 0; i < layerLength; ++i) {
         pixel = layer1[i];
         if (pixel == this.backgroundColor) {
            layer1[i] = this.backgroundColor;
            if (layer1Color2 != null) {
               layer1Color2[i] = this.backgroundColor;
            }
         } else {
            colorValue = pixel & 255;
            // if (colorMap[colorValue] > 0) {
            //    layer1[i] = colorIndices[colorMap[colorValue]];
            // } else {
               // colorMap[colorValue] = colorIndex;
               // colorIndices[colorIndex] = uniqueColorIndex;
               // ++colorIndex;
               int color1 = this.loadTextures_subfunction16(palette1[0], palette1[1], palette1[2], palette1[3], palette1[4], colorValue, false);
               int color2 = this.loadTextures_subfunction16(palette2[0], palette2[1], palette2[2], palette2[3], palette2[4], colorValue, false);
               // colorData[0][dataIndex] = (int)((long)color1 | 0L);
               // colorData[1][dataIndex] = (int)((long)color2 | 0L);
               layer1[i] = color1;
               if (layer1Color2 != null) {
                  layer1Color2[i] = color2;
               }
               // ++dataIndex;
            // }
         }
      }

      // this.F = new byte[32][32][32];
      // colorIndices = new int[50];

      for(i = 0; i < layerLength; ++i) {
         if ((pixel = layer2[i]) != this.backgroundColor) {
            // int red = (pixel & 0xFF0000) >> 19;
            // int green = (pixel & 0x00FF00) >> 11;
            // int blue = (pixel & 0x0000FF) >> 3;
            // if (this.F[red][green][blue] > 0) {
            //    layer1[i] = colorIndices[this.F[red][green][blue]];
            // } else {
               // this.F[red][green][blue] = colorIndex;
               // colorIndices[colorIndex] = uniqueColorIndex;
               // ++colorIndex;
               // if (layer2[i] != this.backgroundColor) {
               //    colorData[0][dataIndex] = (int)((long)pixel | 0L);
               //    colorData[1][dataIndex] = (int)((long)pixel | 0L);
               // }
                  layer1[i] = pixel;
                  if (layer1Color2 != null) {
                     layer1Color2[i] = pixel;
                  }
               // ++dataIndex;
            // }
         }
      }

   }





}
