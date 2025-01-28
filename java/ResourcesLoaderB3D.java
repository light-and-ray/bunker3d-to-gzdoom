import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class ResourcesLoaderB3D {
   public String ROOT_JAR = "../jars/b3d.d";
   public ArrayList<Integer> DOORS_START_LINE_IDX = new ArrayList<>();
   public ArrayList<Integer> CRATES_START_LINE_IDX = new ArrayList<>();
   public ArrayList<Byte> CRATES_CONTENT = new ArrayList<>();
   public ArrayList<Byte> CRATES_ANGLE = new ArrayList<>();
   public short[] FOOTER;
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
   public int BACKGROUND_COLOR;
   public int selectedMap;
   public boolean gB;
   public int[] bi;
   public int[][] cW;
   public byte[] by;
   public byte[] bz;
   public int eX;
   public byte[] cX;
   byte[] a;

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


   public ResourcesLoaderB3D() {
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
         // this.d(this.E[2]);
      }

      // this.loadedMap = (byte[][])null;
      // this.E[2] = (byte[][][])null;
      // this.c(false);
      // System.gc();
      // this.b(footer);
      // this.a(this.E[0], this.E[1], footer);
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
      this.eY = bigLump1[12].length;
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

      int var13;
      for(var13 = var8; var13 < var8 + var5; ++var13) {
         this.cW[0][var13] = (int)((var6 * this.cos(var14) >> 16) + var1);
         this.cW[1][var13] = (int)((var6 * this.sin(var14) >> 16) + var3);
         var14 -= var15;
         this.cW[2][var13] = (int)((var6 * this.cos(var14) >> 16) + var1);
         this.cW[3][var13] = (int)((var6 * this.sin(var14) >> 16) + var3);
         this.by[var13] = var10;
         this.cX[var13] = (byte)var9;
         this.bz[var13] = var11;
      }

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







   private void readFoePart1(byte[][][] bigLump2) {
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

      for(i = 0; i < var4; ++i) {
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

      for(i = 0; i < var4; ++i) {
         this.cg[var3] = bigLump2[9][i][0];
         this.bT[var3][0] = 128 + bigLump2[9][i][1] << 16 >> 2;
         this.bT[var3][1] = 128 + bigLump2[9][i][2] << 16 >> 2;
         this.cm[var3] = true;
         ++var3;
      }

   }

   private int F() {
      return this.dR.nextInt();
   }



   private void readFoePart2(byte[][][] var1) {
      // Image layer1 = null;
      // Image layer2 = null;
      // layer1 = this.readImage("/e" + this.dataExt);
      // layer2 = this.readImage("/ee" + this.dataExt);
      // int[] tmp = new int[1];
      // layer1.getRGB(tmp, 0, 1, 0, 0, 1, 1);
      // this.BACKGROUND_COLOR = tmp[0];
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

      // int var16 = this.bq[0][this.M[0]] + 10;
      // int var17 = this.bq[1][this.M[1]] + 10;
      // int var18 = this.bq[2][this.M[2]] + 10;
      // int var19 = this.bq[3][this.M[3]] + 10;
      // int var20 = this.bq[4][this.M[4]] + 10;
      // this.readFoeSubfunction2(var16, var17, var1[1].length, var18, var19, var20);
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

   private void readFoeSubfunction1(short[] foeMData, int segNum, int offset) {
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


   // private void readFoeSubfunction2(int var1, int var2, int var3, int var4, int var5, int var6) {
   //    this.bp = new int[2][(16 + var3) * 50];
   //    this.bm = new int[50];
   //    this.cY = new byte[var1];
   //    this.cZ = new byte[var1];
   //    this.da = new byte[var1];
   //    this.db = new byte[var1];
   //    this.dc = new byte[var1];
   //    this.dd = new byte[var1];
   //    this.de = new byte[var2];
   //    this.df = new byte[var2];
   //    this.dg = new byte[var4];
   //    this.dh = new byte[var4];
   //    this.di = new byte[var5];
   //    this.dj = new byte[var5];
   //    this.dk = new byte[var5];
   //    this.dl = new byte[var5];
   //    this.dm = new byte[var6];
   //    this.dn = new byte[var6];
   // }
}
